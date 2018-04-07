package org.ghc.pages;

import org.ghc.utils.extensions.KPAUIEveryUnAuthenticatedPage;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.fail;

public class KPAUIHealthPlansPage extends KPAUIEveryUnAuthenticatedPage {

    public KPAUIHealthPlansPage(WebDriver driver) {
        super(driver);
        if (!isCurrent(driver, PAGETITLE_HEALTH_PLANS))
            fail("The Health Plans Page did not load correctly");
    }

    //------------------------------------------------------------------------------------------------------------------

    private static final String PAGETITLE_HEALTH_PLANS = "Health Plans";

}

