package org.ghc.tests.pages;

import org.ghc.pages.KPAUIUnAuthenticatedHomePage;
import org.ghc.utils.extensions.KPAUIEveryTest;
import org.ghc.utils.helpers.KPAUIContextHelper;
import org.testng.annotations.*;
import java.lang.reflect.Method;

import static org.ghc.utils.KPAUICredentials.*;
import static org.ghc.utils.KPAUICredentials.accountName.*;


public class KPAUIOnBoardingTests extends KPAUIEveryTest {
   private KPAUIUnAuthenticatedHomePage unAuthenticatedHomePage;

    @BeforeMethod(alwaysRun = true)
    public void beforeTest(Method method) {
        unAuthenticatedHomePage = super.initializeTest(method);
    }

    //------------------------------------------------------------------------------------------------------------------

    @Test(description = "Validate the user can on-board (happy path) with registration quiz",
            groups = {"qa"})
    public void validateNewMemberWithQuiz() {
        KPAUIAccount account = WITH_QUIZ.getMemberInfo();
        new KPAUIContextHelper().loginDeactivateReactivateQuit(account);

        unAuthenticatedHomePage.openSignOnShade()
                .openRegisterNowLink()
                .enterYourInformationAndSubmit(account)
                .createYourAccountAndGoToQuiz(account)
                .answerQuizCorrectly()
                .openAuthenticatedHomePage();
    }

    @Test(description = "Validate a user with no SVA Quiz can on-board (happy path) with in-person id verification",
            groups = {"qa"})
    public void validateNewMemberNoQuizInPerson() {
        KPAUIAccount account = WITHOUT_QUIZ.getMemberInfo();
        new KPAUIContextHelper().loginDeactivateReactivateQuit(account);

        unAuthenticatedHomePage.openSignOnShade()
                .openRegisterNowLink()
                .enterYourInformationAndSubmit(account)
                .createYourAccountAndNoQuiz(account)
                .selectInPersonAndSubmit()
                .clickReturnToKpHomePage();
    }

    @Test(description = "Validate a user with no SVQ Quiz can on-board (happy path) with email verification",
            groups = {"qa"})
    public void validateNewMemberNoQuizEmail() {
        KPAUIAccount account = WITHOUT_QUIZ.getMemberInfo();
        new KPAUIContextHelper().loginDeactivateReactivateQuit(account);

        unAuthenticatedHomePage.openSignOnShade()
                .openRegisterNowLink()
                .enterYourInformationAndSubmit(account)
                .createYourAccountAndNoQuiz(account)
                .selectEmailOptionAndSubmit()
                .clickReturnToKpHomePage();
    }

    @Test(description = "Validate SVA Quiz User onboarding workflow when they do not enter their SSN on the Your" +
            "Information page", groups = {"qa"})
    public void validateNewMemberWithQuizNoSsnEntered() {
        KPAUIAccount account = WITH_QUIZ.getMemberInfo();
        new KPAUIContextHelper().loginDeactivateReactivateQuit(account);

        unAuthenticatedHomePage.openSignOnShade()
                .openRegisterNowLink()
                .enterYourInfoExceptSsnAndSubmit(account)
                .createYourAccountAndNoQuiz(account)
                .selectInPersonAndSubmit()
                .clickReturnToKpHomePage();
    }

    @Test(description = "Validate User with No SVA Quiz onboarding workflow when they do not enter their SSN on the " +
            "Your Information page", groups = {"qa"})
    public void validateNewMemberWithNoQuizNoSsnEntered() {
        KPAUIAccount account = WITHOUT_QUIZ.getMemberInfo();
        new KPAUIContextHelper().loginDeactivateReactivateQuit(account);

        unAuthenticatedHomePage.openSignOnShade()
                .openRegisterNowLink()
                .enterYourInfoExceptSsnAndSubmit(account)
                .createYourAccountAndNoQuiz(account)
                .selectInPersonAndSubmit()
                .clickReturnToKpHomePage();
    }
}