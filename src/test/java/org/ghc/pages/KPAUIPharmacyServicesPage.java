package org.ghc.pages;

import org.ghc.utils.extensions.KPAUIEveryAuthenticatedPage;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.fail;

public class KPAUIPharmacyServicesPage extends KPAUIEveryAuthenticatedPage {

    public KPAUIPharmacyServicesPage(WebDriver driver) {
        super(driver);
        if (!isCurrent(driver, PAGETITLE_PHARMACY_SERVICES))
            fail("The Pharmacy Services Page did not load correctly");
    }

    //------------------------------------------------------------------------------------------------------------------

    private static final String PAGETITLE_PHARMACY_SERVICES = "Pharmacy Services";

}
