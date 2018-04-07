package org.ghc.pages;

import org.ghc.utils.extensions.KPAUIEveryAuthenticatedPage;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.fail;

public class KPAUIHealthCareServicesPage extends KPAUIEveryAuthenticatedPage {

    public KPAUIHealthCareServicesPage(WebDriver driver) {
        super(driver);
        if (!isCurrent(driver, PAGETITLE_HEALTHCARE_SERVICES))
            fail("The Health Care Services Page did not load correctly");
    }

    //------------------------------------------------------------------------------------------------------------------

    private static final String PAGETITLE_HEALTHCARE_SERVICES = "Health Care Services";

}
