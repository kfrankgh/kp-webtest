package org.ghc.tests.pages;

import org.ghc.pages.KPAUIUnAuthenticatedHomePage;
import org.ghc.utils.extensions.KPAUIEveryTest;
import org.ghc.utils.helpers.KPAUIContextHelper;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.lang.reflect.Method;

import static org.ghc.utils.KPAUICredentials.KPAUIAccount;
import static org.ghc.utils.KPAUICredentials.accountName.WITH_QUIZ;
import static org.ghc.utils.KPAUIPageConstants.OnBoardingPages.SvaQuizPage.*;

public class KPAUIOnBoardingSVAPageTests extends KPAUIEveryTest {
   private KPAUIUnAuthenticatedHomePage unAuthenticatedHomePage;

    @BeforeMethod(alwaysRun = true)
    public void beforeTest(Method method) {
        unAuthenticatedHomePage = super.initializeTest(method);
    }

    //------------------------------------------------------------------------------------------------------------------
    @Test(description = "Verify answering the SVA Quiz incorrectly takes the user to the Verify Your Identity page, then" +
            "selecting the Email option goes to the Thank you page", groups = {"qa"})
    public void validateIncorrectSvaQuizAnswersWorkflowEmail() {
        KPAUIAccount account = WITH_QUIZ.getMemberInfo();
        new KPAUIContextHelper().loginDeactivateReactivateQuit(account);

        unAuthenticatedHomePage.openSignOnShade()
                .openRegisterNowLink()
                .enterYourInformationAndSubmit(account)
                .createYourAccountAndGoToQuiz(account)
                .answerQuiz(svaWrongAnswer1, svaWrongAnswer2, svaWrongAnswer3)
                .selectEmailOptionAndSubmit();
    }

    @Test(description = "Verify answering the SVA Quiz incorrectly takes the user to the Verify Your Identity page, then" +
            "selecting the In Person option goes to the Thank you page", groups = {"qa"})
    public void validateIncorrectSvaQuizAnswersWorkflowInPerson() {
        KPAUIAccount account = WITH_QUIZ.getMemberInfo();
        new KPAUIContextHelper().loginDeactivateReactivateQuit(account);

        unAuthenticatedHomePage.openSignOnShade()
                .openRegisterNowLink()
                .enterYourInformationAndSubmit(account)
                .createYourAccountAndGoToQuiz(account)
                .answerQuiz(svaWrongAnswer1, svaWrongAnswer2, svaWrongAnswer3)
                .selectInPersonAndSubmit();
    }

    @Test(description = "Verify answering 1 of 3 SVA Questions incorrectly takes the user to the 4th Question then" +
            "the Welcome page", groups = {"qa"})
    public void validate4thSvaQuizAnswerCorrectWorkflow() {
        KPAUIAccount account = WITH_QUIZ.getMemberInfo();
        new KPAUIContextHelper().loginDeactivateReactivateQuit(account);

        unAuthenticatedHomePage.openSignOnShade()
                .openRegisterNowLink()
                .enterYourInformationAndSubmit(account)
                .createYourAccountAndGoToQuiz(account)
                .answerOneQuizQuestionIncorrectly(svaRightAnswer1, svaWrongAnswer2, svaRightAnswer3)
                .answer4thQuestionCorrectly();
    }

    @Test(description = "Verify answering 1 of 3 SVA Questions incorrectly takes the user to the 4th Question which if" +
            "answered incorrectly goes to the Verify ID page, then selecting the In Person option goes to the Thank you page", groups = {"qa"})
    public void validate4thSVAQuizAnswerIncorrectWorkflowInPerson() {
        KPAUIAccount account = WITH_QUIZ.getMemberInfo();
        new KPAUIContextHelper().loginDeactivateReactivateQuit(account);

        unAuthenticatedHomePage.openSignOnShade()
                .openRegisterNowLink()
                .enterYourInformationAndSubmit(account)
                .createYourAccountAndGoToQuiz(account)
                .answerOneQuizQuestionIncorrectly(svaWrongAnswer1, svaRightAnswer2, svaRightAnswer3)
                .answer4thQuestionIncorrectly()
                .selectInPersonAndSubmit();
    }

    @Test(description = "Verify answering 2 of 3 SVA Quiz incorrectly takes the user to the Verify Your Identity page," +
            "then selecting the In Person option goes to the Thank you page", groups = {"qa"})
    public void validate2IncorrectSvaQuizAnswersWorkflowInPerson() {
        KPAUIAccount account = WITH_QUIZ.getMemberInfo();
        new KPAUIContextHelper().loginDeactivateReactivateQuit(account);

        unAuthenticatedHomePage.openSignOnShade()
                .openRegisterNowLink()
                .enterYourInformationAndSubmit(account)
                .createYourAccountAndGoToQuiz(account)
                .answerQuiz(svaWrongAnswer1, svaRightAnswer2, svaWrongAnswer3)
                .selectInPersonAndSubmit();
    }

    @Test(description = "Verify clicking Cancel button opens the PIN Code page", groups = {"qa"})
    public void validateCancelButtonClick() {
        KPAUIAccount account = WITH_QUIZ.getMemberInfo();
        new KPAUIContextHelper().loginDeactivateReactivateQuit(account);

        unAuthenticatedHomePage.openSignOnShade()
                .openRegisterNowLink()
                .enterYourInformationAndSubmit(account)
                .createYourAccountAndGoToQuiz(account)
                .clickCancelButton();
    }

    @Test(description = "Verify clicking Cancel button on the 4th SVA Quiz page opens the PIN Code page",
            groups = {"qa"})
    public void validateCancelButtonClickOn4thSvaQuizPage() {
        KPAUIAccount account = WITH_QUIZ.getMemberInfo();
        new KPAUIContextHelper().loginDeactivateReactivateQuit(account);

        unAuthenticatedHomePage.openSignOnShade()
                .openRegisterNowLink()
                .enterYourInformationAndSubmit(account)
                .createYourAccountAndGoToQuiz(account)
                .answerOneQuizQuestionIncorrectly(svaRightAnswer1, svaWrongAnswer2, svaRightAnswer3)
                .clickCancelButton();
    }
}