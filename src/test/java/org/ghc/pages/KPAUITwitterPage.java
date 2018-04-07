package org.ghc.pages;

import org.ghc.utils.extensions.KPAUIEveryAuthenticatedPage;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.fail;

public class KPAUITwitterPage extends KPAUIEveryAuthenticatedPage {

    public KPAUITwitterPage(WebDriver driver) {
        super(driver);
        if (!isCurrent(driver, PAGETITLE_TWITTER))
            fail("The KP Twitter Page did not load correctly");
    }

    //------------------------------------------------------------------------------------------------------------------

    private static final String PAGETITLE_TWITTER = "Twitter";



}