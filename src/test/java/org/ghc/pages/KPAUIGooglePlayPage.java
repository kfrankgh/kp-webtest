package org.ghc.pages;

import org.ghc.utils.extensions.KPAUIEveryUnAuthenticatedPage;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.fail;

public class KPAUIGooglePlayPage extends KPAUIEveryUnAuthenticatedPage{

    public KPAUIGooglePlayPage(WebDriver driver) {
        super(driver);
        if (!isCurrent(driver, PAGETITLE_UNAUTHENTICATED_GOOGLE_PLAY))
            fail("The KP Unauthenticated Providers Page did not load correctly");
    }

    //------------------------------------------------------------------------------------------------------------------

    private static final String PAGETITLE_UNAUTHENTICATED_GOOGLE_PLAY = "Android Apps on Google Play";

}