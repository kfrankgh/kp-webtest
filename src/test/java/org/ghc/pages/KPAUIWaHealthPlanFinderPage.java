package org.ghc.pages;

import org.ghc.utils.extensions.KPAUIEveryUnAuthenticatedPage;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.fail;

public class KPAUIWaHealthPlanFinderPage extends KPAUIEveryUnAuthenticatedPage{

    public KPAUIWaHealthPlanFinderPage(WebDriver driver) {
        super(driver);
        if (!isCurrent(driver, "finder"))
            fail("The WA Health Plan Finder Page did not load correctly");
    }

    //------------------------------------------------------------------------------------------------------------------

}