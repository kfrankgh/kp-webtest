package org.ghc.pages;

import org.ghc.utils.extensions.KPAUIEveryAuthenticatedPage;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.fail;

public class KPAUIFacebookPage extends KPAUIEveryAuthenticatedPage {

    public KPAUIFacebookPage(WebDriver driver) {
        super(driver);
        if (!isCurrent(driver, PAGETITLE_FACEBOOK))
            fail("The KP Facebook Page did not load correctly");
    }

    //------------------------------------------------------------------------------------------------------------------

    private static final String PAGETITLE_FACEBOOK = "Facebook";


}
