package org.ghc.pages;

import org.ghc.utils.extensions.KPAUIEveryUnAuthenticatedPage;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.fail;

public class KPAUIWebsiteSupportPage extends KPAUIEveryUnAuthenticatedPage {

    public KPAUIWebsiteSupportPage(WebDriver driver) {
        super(driver);
        if (!isCurrent(driver, PAGETITLE_WEBSITE_SUPPORT))
            fail("The Website Feedback and Support Page did not load correctly");
    }

    //------------------------------------------------------------------------------------------------------------------

    private static final String PAGETITLE_WEBSITE_SUPPORT = "Website Feedback and Support";


}