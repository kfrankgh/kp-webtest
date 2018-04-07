package org.ghc.tests.pages;

import org.ghc.pages.KPAUIAuthenticatedHomePage;
import org.ghc.pages.KPAUIGoodbyePage;
import org.ghc.utils.extensions.KPAUIEveryTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

import static org.ghc.utils.KPAUICredentials.accountName.EVERYTHING;

public class KPAUIGoodbyePageTests extends KPAUIEveryTest {
    private KPAUIAuthenticatedHomePage authenticatedHomePage;

    @BeforeMethod(alwaysRun = true)
    public void beforeTest(Method method) {
        authenticatedHomePage = super.initializeTest(method)
                .signIn(EVERYTHING);
    }

    //------------------------------------------------------------------------------------------------------------------

    @Test(description = "Verify the Public Home Page, and Privacy Policy links open the correct pages." +
            " Verify user can Sign in", groups = {"smoke", "qa", "prod"})
    public void validateHomePagePrivacyPolicyLinksClickAndSignIn() {
        KPAUIGoodbyePage goodbyePage = authenticatedHomePage.signOut();

        goodbyePage.openPublicHomePageLink();

        driver.navigate().back();
        goodbyePage.openPrivacyPolicyLink();

        driver.navigate().back();
        goodbyePage.openSignInLink()
        .signIn(EVERYTHING);
    }
}