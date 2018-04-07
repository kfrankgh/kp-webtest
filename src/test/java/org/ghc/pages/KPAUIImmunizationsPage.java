package org.ghc.pages;

import org.ghc.utils.extensions.KPAUIEveryAuthenticatedPage;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.fail;

public class KPAUIImmunizationsPage extends KPAUIEveryAuthenticatedPage {

    public KPAUIImmunizationsPage(WebDriver driver) {
        super(driver);
        if (!isCurrent(driver, PAGETITLE_IMMUNIZATIONS))
            fail("The Immunization Page did not load correctly");
    }

    //------------------------------------------------------------------------------------------------------------------

    private static final String PAGETITLE_IMMUNIZATIONS = "Immunizations";

}
