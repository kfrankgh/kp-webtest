package org.ghc.pages;

import org.ghc.utils.extensions.KPAUIEveryUnAuthenticatedPage;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.fail;

public class KPAUIPrivacyPolicyPage extends KPAUIEveryUnAuthenticatedPage {

    public KPAUIPrivacyPolicyPage(WebDriver driver) {
        super(driver);
        if (!isCurrent(driver, pageTitlePrivacyPolicy))
            fail("Privacy Policy Page did not load correctly");
    }

    //------------------------------------------------------------------------------------------------------------------

    public static final String pageTitlePrivacyPolicy = "Kaiser Permanente Website Privacy Policy";


}