package org.ghc.pages;

import org.ghc.utils.extensions.KPAUIEveryAuthenticatedPage;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.fail;

public class KPAUIAboutUsPage extends KPAUIEveryAuthenticatedPage {

    public KPAUIAboutUsPage(WebDriver driver) {
        super(driver);
        if (!isCurrent(driver, PAGETITLE_ABOUT_US))
            fail("The About Us Page did not load correctly");
    }

    //------------------------------------------------------------------------------------------------------------------

    private static final String PAGETITLE_ABOUT_US = "About Kaiser Permanente Washington";

}