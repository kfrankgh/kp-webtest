package org.ghc.pages;

import org.ghc.utils.extensions.KPAUIEveryUnAuthenticatedPage;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.fail;

public class KPAUIUnauthenticatedProducersPage extends KPAUIEveryUnAuthenticatedPage{

    public KPAUIUnauthenticatedProducersPage(WebDriver driver) {
        super(driver);
        if (!isCurrent(driver, PAGETITLE_UNAUTHENTICATED_PRODUCERS))
            fail("The KP Unauthenticated Producers Page did not load correctly");
    }

    //------------------------------------------------------------------------------------------------------------------

    private static final String PAGETITLE_UNAUTHENTICATED_PRODUCERS = "Producers, Brokers, Agents Health Care";

}