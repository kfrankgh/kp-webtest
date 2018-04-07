package org.ghc.pages;

import org.ghc.utils.extensions.KPAUIEveryAuthenticatedPage;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.fail;

public class KPAUIHealthConditionsPage extends KPAUIEveryAuthenticatedPage {

    public KPAUIHealthConditionsPage(WebDriver driver) {
        super(driver);
        if (!isCurrent(driver, PAGETITLE_HEALTH_CONDITIONS))
            fail("The Health Conditions Page did not load correctly");
    }

    //------------------------------------------------------------------------------------------------------------------

    private static final String PAGETITLE_HEALTH_CONDITIONS = "Health Conditions";

}
