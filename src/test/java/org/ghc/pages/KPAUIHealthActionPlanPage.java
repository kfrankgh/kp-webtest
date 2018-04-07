package org.ghc.pages;

import org.ghc.utils.extensions.KPAUIEveryAuthenticatedPage;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.fail;

public class KPAUIHealthActionPlanPage extends KPAUIEveryAuthenticatedPage {

    public KPAUIHealthActionPlanPage(WebDriver driver) {
        super(driver);
        if (!isCurrent(driver, PAGETITLE_YOUR_HEALTH_ACTION_PLAN))
            fail("The Health Care Services Page did not load correctly");
    }

    //------------------------------------------------------------------------------------------------------------------

    private static final String PAGETITLE_YOUR_HEALTH_ACTION_PLAN = "Secure Member Site";

}

