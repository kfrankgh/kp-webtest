package org.ghc.pages;

import org.ghc.utils.extensions.KPAUIEveryAuthenticatedPage;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.fail;

public class KPAUIClinicLocationsPage extends KPAUIEveryAuthenticatedPage {

    public KPAUIClinicLocationsPage(WebDriver driver) {
        super(driver);
        if (!isCurrent(driver, PAGETITLE_CLINIC_LOCATIONS))
            fail("The Clinician Locations Page did not load correctly");
    }

    //------------------------------------------------------------------------------------------------------------------

    private static final String PAGETITLE_CLINIC_LOCATIONS = "Washington State Medical Centers";

}
