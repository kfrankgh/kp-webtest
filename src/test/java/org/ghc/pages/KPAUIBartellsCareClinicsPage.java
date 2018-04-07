package org.ghc.pages;

import org.ghc.utils.extensions.KPAUIEveryAuthenticatedPage;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.fail;

public class KPAUIBartellsCareClinicsPage extends KPAUIEveryAuthenticatedPage {
    public KPAUIBartellsCareClinicsPage(WebDriver driver) {
        super(driver);
        if (!isCurrent(driver, PAGETITLE_CARE_WALK_IN_BARTELL_CLINICS))
            fail("The Bartell's Care Clinics Page did not load correctly");
    }

    //------------------------------------------------------------------------------------------------------------------

    private static final String PAGETITLE_CARE_WALK_IN_BARTELL_CLINICS = "Bartell Drugs";

}
