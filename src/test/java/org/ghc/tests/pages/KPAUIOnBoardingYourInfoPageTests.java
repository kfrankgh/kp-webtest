package org.ghc.tests.pages;

import org.ghc.pages.KPAUIOnBoardingInformationPage;
import org.ghc.pages.KPAUIUnAuthenticatedHomePage;
import org.ghc.utils.extensions.KPAUIEveryTest;
import org.ghc.utils.helpers.KPAUIContextHelper;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.lang.reflect.Method;

import static org.ghc.utils.KPAUICredentials.KPAUIAccount;
import static org.ghc.utils.KPAUICredentials.accountName.*;
import static org.ghc.utils.helpers.KPAUITestHelper.assertMatches;
import static org.ghc.utils.helpers.KPAUITestHelper.errorMsg;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class KPAUIOnBoardingYourInfoPageTests extends KPAUIEveryTest {
   private KPAUIUnAuthenticatedHomePage unAuthenticatedHomePage;

    @BeforeMethod(alwaysRun = true)
    public void beforeTest(Method method) {
        unAuthenticatedHomePage = super.initializeTest(method);
    }

    @Test(description = "Validate Error messages for field entries less than the minimum required length, user" +
            "who does not exist, and invalid characters entered into the fields. Also verifies the ClearForm button",
            groups = {"qa"})
    public void validateFieldErrorMessages() {
        KPAUIAccount account = INVALID.getMemberInfo();

        KPAUIOnBoardingInformationPage infoPage = unAuthenticatedHomePage.openSignOnShade()
                .openRegisterNowLink()
                .enterLessThanMinLengthInfoAndSubmit(account);
        final String minLengthErrorMsg = "^Doesn\\Wt meet minimum length$";
        assertMatches(infoPage.getFirstNameErrorMsg(), minLengthErrorMsg);
        assertMatches(infoPage.getLastNameErrorMsg(), minLengthErrorMsg);
        assertMatches(infoPage.getBirthDateErrorMsg(), minLengthErrorMsg);
        assertMatches(infoPage.getMemberIDErrorMsg(), minLengthErrorMsg);
        String invalidCharsErrorMsg = "Invalid entry";
        assertEquals(infoPage.getSSNErrorMsg(), invalidCharsErrorMsg);

        infoPage.getClearFormButton().click();
        assertTrue(infoPage.isFormCleared(), "Clear Form button failed to clear the fields");

        infoPage.enterYourInformationInvalidUserAndSubmit(account);
        String errorStr = infoPage.getInvalidAccountErrorMsg();
        assertTrue( errorStr.toUpperCase().contains("SORRY"),
                errorMsg("contains SORRY", errorStr) );

        infoPage.getClearFormButton().click();
        assertTrue(infoPage.isFormCleared(), "Clear Form button failed to clear the fields");

        infoPage.enterInvalidValuesAndSubmit();
        assertEquals(infoPage.getFirstNameErrorMsg(), invalidCharsErrorMsg);
        assertEquals(infoPage.getLastNameErrorMsg(), invalidCharsErrorMsg);
        assertEquals(infoPage.getBirthDateErrorMsg(), invalidCharsErrorMsg);
        assertEquals(infoPage.getMemberIDErrorMsg(), invalidCharsErrorMsg);
        assertEquals(infoPage.getSSNErrorMsg(), invalidCharsErrorMsg);

        infoPage.getClearFormButton().click();
        assertTrue(infoPage.isFormCleared(), "Clear Form button failed to clear the fields");
        infoPage.enterYourFutureDOBAndSubmit(account);
        String errorMsg = infoPage.getAgeErrorMsg();
        String ageErrorMsg = "18 years old to register";
        assertTrue(infoPage.getAgeErrorMsg().toLowerCase().contains(ageErrorMsg), errorMsg(ageErrorMsg, errorMsg));
    }

    @Test(description = "Validate Error message for user account that is deactivated", groups = {"qa"})
    public void validateDeactivatedUserErrorMessage() {
        KPAUIAccount account = WITHOUT_QUIZ.getMemberInfo();
        new KPAUIContextHelper().loginDeactivateQuit(account);

        KPAUIOnBoardingInformationPage infoPage = unAuthenticatedHomePage.openSignOnShade()
                .openRegisterNowLink()
                .enterYourInformationInvalidUserAndSubmit(account);
        String error = infoPage.getDeactivatedUserErrorMsg();
        String deactivatedAccountErrorMsg = "^SORRY, WE CAN\\WT PROCESS YOUR REQUEST.+$";
        assertMatches(error.toUpperCase(), deactivatedAccountErrorMsg);
    }

    @Test(description = "Validate Error message when User Agreement Read checkbox is not checked", groups = {"qa"})
    public void validateUnreadUserAgreementErrorMessage(){
        KPAUIAccount account = WITHOUT_QUIZ.getMemberInfo();
        new KPAUIContextHelper().loginDeactivateReactivateQuit(account);
        KPAUIOnBoardingInformationPage infoPage = unAuthenticatedHomePage.openSignOnShade()
                .openRegisterNowLink()
                .enterYourInfoExceptUserAgreementAndSubmit(account);
        String error = infoPage.getUserAgreementUnreadErrorMsg();
        final String userAgreementUnreadErrorMsg = "YOU MUST AGREE";
        assertTrue(error.toUpperCase().contains(userAgreementUnreadErrorMsg),errorMsg(userAgreementUnreadErrorMsg,
                error));
    }

    @Test(description = "Validate Error message for user who is already registered", groups = {"qa"})
    public void validateRegisteredUserErrorMessage(){
        KPAUIAccount account = WITH_QUIZ.getMemberInfo();
        new KPAUIContextHelper().loginDeactivateReactivateQuit(account);
        KPAUIOnBoardingInformationPage infoPage = unAuthenticatedHomePage.openSignOnShade()
                .openRegisterNowLink()
                .enterYourInformationAndSubmit(account)
                .createYourAccountAndGoToQuiz(account)
                .answerQuizCorrectly()
                .openAuthenticatedHomePage()
                .signOut()
                .openPublicHomePageLink()
                .openSignOnShade()
                .openRegisterNowLink();

                infoPage.enterYourInformationInvalidUserAndSubmit(account);
        String error = infoPage.getUserRegisteredErrorMsg().toUpperCase();
        final String userRegisteredErrorMsg = "ALREADY REGISTERED";
        assertTrue(infoPage.getUserRegisteredErrorMsg().toUpperCase().contains(userRegisteredErrorMsg),
                errorMsg(userRegisteredErrorMsg, error));
    }

    @Test(description = "Validate the 'Where can I find my member ID?', 'Why is this needed', and Terms of Use links" +
            " open the correct pages", groups = {"smoke", "qa", "prod"})
    public void openMemberIdWhyIsThisNeededAndUserAgreementPages(){
        KPAUIOnBoardingInformationPage infoPage = unAuthenticatedHomePage.openSignOnShade()
                .openRegisterNowLink();
        infoPage.openMemberIdHelpShade().getCloseButton().click();
        infoPage.openWhyIsNeededShade().getCloseButton().click();
        infoPage.openTermsOfUsePage();
    }
}