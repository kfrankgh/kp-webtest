package org.ghc.pages;

import org.ghc.utils.extensions.KPAUIEveryAuthenticatedPage;
import org.openqa.selenium.WebDriver;
import static org.testng.Assert.fail;

public class KPAUIGrowthChartPage extends KPAUIEveryAuthenticatedPage {

    public KPAUIGrowthChartPage(WebDriver driver) {
        super(driver);
        if (!isCurrent(driver, PAGETITLE_GROWTH_CHART))
            fail("The Growth Chart Page did not load correctly");
    }

    //------------------------------------------------------------------------------------------------------------------

    private static final String PAGETITLE_GROWTH_CHART = "Growth Charts";

}
