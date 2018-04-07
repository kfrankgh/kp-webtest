package org.ghc.pages;

import org.ghc.utils.extensions.KPAUIEveryAuthenticatedPage;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.fail;

public class KPAUITourOnlineServicesPage extends KPAUIEveryAuthenticatedPage {

    public KPAUITourOnlineServicesPage(WebDriver driver) {
        super(driver);
        if (!isCurrent(driver, PAGETITLE_TOUR_ONLINE_SERVICES))
            fail("The Tour Online Services Page did not load correctly");
    }

    //------------------------------------------------------------------------------------------------------------------

    private static final String PAGETITLE_TOUR_ONLINE_SERVICES = " Tour";




}
