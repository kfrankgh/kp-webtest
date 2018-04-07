package org.ghc.pages;

import org.ghc.utils.extensions.KPAUIEveryAuthenticatedPage;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.fail;

public class KPAUIBloodPressureAndWeightPage extends KPAUIEveryAuthenticatedPage {

    public KPAUIBloodPressureAndWeightPage(WebDriver driver) {
        super(driver);
        if (!isCurrent(driver, PAGETITLE_BLOODPRESSURE_AND_WEIGHT))
            fail("The Blood Pressure and Weight Page did not load correctly");
    }

    //------------------------------------------------------------------------------------------------------------------

    private static final String PAGETITLE_BLOODPRESSURE_AND_WEIGHT = "Health Trends";


}
