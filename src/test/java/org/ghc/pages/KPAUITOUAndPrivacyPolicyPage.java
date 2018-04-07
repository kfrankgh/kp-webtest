package org.ghc.pages;

import org.ghc.utils.extensions.KPAUIEveryAuthenticatedPage;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.fail;

public class KPAUITOUAndPrivacyPolicyPage extends KPAUIEveryAuthenticatedPage {

    public KPAUITOUAndPrivacyPolicyPage(WebDriver driver) {
        super(driver);
        if (!isCurrent(driver, PAGETITLE_TOU_AND_PRIVACY_POLICY))
            fail("The Terms of Use and Privacy Policy Page did not load correctly");
    }

    //------------------------------------------------------------------------------------------------------------------

    private static final String PAGETITLE_TOU_AND_PRIVACY_POLICY = "Terms of Use and Privacy Policy";


}