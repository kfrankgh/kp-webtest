package org.ghc.tests.pages;

import org.ghc.pages.KPAUIOnBoardingAccountPage;
import org.ghc.pages.KPAUIUnAuthenticatedHomePage;
import org.ghc.utils.extensions.KPAUIEveryTest;
import org.ghc.utils.helpers.KPAUIContextHelper;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.lang.reflect.Method;

import static org.ghc.utils.KPAUICredentials.KPAUIAccount;
import static org.ghc.utils.KPAUICredentials.accountName.WITHOUT_QUIZ;
import static org.ghc.utils.helpers.KPAUITestHelper.assertMatches;
import static org.testng.Assert.assertEquals;

public class KPAUIOnBoardingCreateAccountPageTests extends KPAUIEveryTest {
   private KPAUIUnAuthenticatedHomePage unAuthenticatedHomePage;

    @BeforeMethod(alwaysRun = true)
    public void beforeTest(Method method) {
        unAuthenticatedHomePage = super.initializeTest(method);
    }

    //------------------------------------------------------------------------------------------------------------------

    @Test(description = "Validate Error messages for field entries less than the minimum required length, more than " +
            "the maximum length, invalid characters, and password mismatch. Verify the See Rules link opens the" +
            "password help shade. Verify Cancel button exits to the unauthenticated home page", groups = {"qa"})
    public void validateFieldErrorMessagesPwdHelpLinkAndCancelButton() {
        KPAUIAccount account = WITHOUT_QUIZ.getMemberInfo();
        new KPAUIContextHelper().loginDeactivateReactivateQuit(account);

        KPAUIOnBoardingAccountPage accountPage = unAuthenticatedHomePage.openSignOnShade()
                .openRegisterNowLink()
                .enterYourInformationAndSubmit(account)
                .invalidCreateYourAccount("", "", "", "", false);
        final String pwdMinLengthErrorMsg = "Password must contain at least 8 characters";
        assertEquals(accountPage.getPasswordErrorMsg(), pwdMinLengthErrorMsg);
        String minLengthErrorMsg = "^Doesn\\Wt meet minimum length$";
        assertMatches(accountPage.getRePasswordErrorMsg(), minLengthErrorMsg);
        assertMatches(accountPage.getSecurityQuestionErrorMsg(), minLengthErrorMsg);
        assertMatches(accountPage.getSecurityAnswerErrorMsg(), minLengthErrorMsg);
        assertMatches(accountPage.getEmailErrorMsg(), minLengthErrorMsg);

        accountPage = unAuthenticatedHomePage.openSignOnShade()
                .openRegisterNowLink()
                .enterYourInformationAndSubmit(account)
                .invalidCreateYourAccount("a", "a", "a", "", false);
        assertMatches(accountPage.getPasswordErrorMsg(), pwdMinLengthErrorMsg);
        assertMatches(accountPage.getSecurityQuestionErrorMsg(), minLengthErrorMsg);
        assertMatches(accountPage.getSecurityAnswerErrorMsg(), minLengthErrorMsg);
        assertMatches(accountPage.getEmailErrorMsg(), minLengthErrorMsg);

        accountPage.invalidCreateYourAccount("","","@.comabcdc","",
                false);
        String invalidEmailErrorMsg = "Invalid entry";
        assertEquals(accountPage.getEmailErrorMsg(), invalidEmailErrorMsg);

        accountPage.invalidCreateYourAccount(account.getPass(),account.getPass()+"3",
                account.getEmail(), account.getSecAnswer(), true);
        final String pwdMismatchErrorMsg = "PASSWORDS DO NOT MATCH";
        assertEquals(accountPage.getPwdMismatchErrorMsg().toUpperCase(), pwdMismatchErrorMsg);

        accountPage.invalidCreateYourAccount("mychartab","mychartab",
                account.getEmail(), account.getSecAnswer(), true);
        final String invalidPwdErrorMsg = "Password must contain at least 2 numbers";
        assertEquals(accountPage.getPasswordErrorMsg(), invalidPwdErrorMsg);

        accountPage.invalidCreateYourAccount("mychart1","mychart1",
                account.getEmail(), account.getSecAnswer(), true);
        assertEquals(accountPage.getPasswordErrorMsg(), invalidPwdErrorMsg);

        accountPage.invalidCreateYourAccount("mychart123456789","mychart123456789",
                account.getEmail(), account.getSecAnswer(), true);
        assertEquals(accountPage.getPwdMismatchErrorMsg().toUpperCase(), pwdMismatchErrorMsg);

        final String emailAddress100chars = "123456789091234567890912345678909123456789091234567890" +
                "9123456789091234567890912345678909123456789@b.";
        accountPage.invalidCreateYourAccount(account.getPass(), account.getPass(), emailAddress100chars, account.getSecAnswer(),
                true);
        assertEquals(accountPage.getEmailErrorMsg(), invalidEmailErrorMsg);

        accountPage.clickSeeRulesLink().getCancelButton().click();

        accountPage.clickCancelButton();
    }
}