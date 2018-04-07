package org.ghc.pages;

import org.ghc.utils.extensions.KPAUIEveryAuthenticatedPage;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.fail;

public class KPAUISpecialtyCarePage extends KPAUIEveryAuthenticatedPage {

    public KPAUISpecialtyCarePage(WebDriver driver) {
        super(driver);
        if (!isCurrent(driver, PAGETITLE_SPECIALTY_CARE))
            fail("The Specialty Care Page did not load correctly");
    }

    //------------------------------------------------------------------------------------------------------------------

    private static final String PAGETITLE_SPECIALTY_CARE = "Specialists and Specialty Care";


}
