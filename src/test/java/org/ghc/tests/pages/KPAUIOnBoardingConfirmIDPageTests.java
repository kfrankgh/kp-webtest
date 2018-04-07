package org.ghc.tests.pages;

import org.ghc.pages.KPAUIOnBoardingVerifyIdPage;
import org.ghc.pages.KPAUIUnAuthenticatedHomePage;
import org.ghc.utils.extensions.KPAUIEveryTest;
import org.ghc.utils.helpers.KPAUIContextHelper;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

import static org.ghc.utils.KPAUICredentials.KPAUIAccount;
import static org.ghc.utils.KPAUICredentials.accountName.WITHOUT_QUIZ;
import static org.testng.Assert.assertTrue;

public class KPAUIOnBoardingConfirmIDPageTests extends KPAUIEveryTest {
   private KPAUIUnAuthenticatedHomePage unAuthenticatedHomePage;

    @BeforeMethod(alwaysRun = true)
    public void beforeTest(Method method) {
        unAuthenticatedHomePage = super.initializeTest(method);
    }

    //------------------------------------------------------------------------------------------------------------------
    @Test(description = "Verify phone number link opens the correct page. Verify clicking Cancel button exits Member" +
            " Onboarding and opens the Public Home page", groups = {"qa"})
    public void validatePhoneNumLinkAndCancelButtonClick() {
        KPAUIAccount account = WITHOUT_QUIZ.getMemberInfo();
        new KPAUIContextHelper().loginDeactivateReactivateQuit(account);

        KPAUIOnBoardingVerifyIdPage verifyIdPage = unAuthenticatedHomePage.openSignOnShade()
                .openRegisterNowLink()
                .enterYourInfoExceptSsnAndSubmit(account)
                .createYourAccountAndNoQuiz(account);
        WebElement phoneNumLink = verifyIdPage.getPhoneNumLink();
        assertTrue(phoneNumLink.isDisplayed(), "Phone number link is not displayed");
        final String phoneNumRegex = "^\\d-\\d{3}-\\d{3}-\\d{4}$";
        assertTrue(phoneNumLink.getText().matches(phoneNumRegex), "Phone number format not: " + phoneNumRegex);
        verifyIdPage.clickCancelButton();
    }
}