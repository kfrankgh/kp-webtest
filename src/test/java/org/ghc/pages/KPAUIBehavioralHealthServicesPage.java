package org.ghc.pages;

import org.ghc.utils.extensions.KPAUIEveryAuthenticatedPage;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.fail;

public class KPAUIBehavioralHealthServicesPage extends KPAUIEveryAuthenticatedPage {

    public KPAUIBehavioralHealthServicesPage(WebDriver driver) {
        super(driver);
        if (!isCurrent(driver, PAGETITLE_BEHAVIORAL_HEALTH))
            fail("The Behavioral Health Page did not load correctly");
    }

    //------------------------------------------------------------------------------------------------------------------

    private static final String PAGETITLE_BEHAVIORAL_HEALTH = "Behavioral Health Services";

}
