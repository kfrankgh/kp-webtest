package org.ghc.pages;

import org.ghc.utils.extensions.KPAUIEveryAuthenticatedPage;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.fail;

public class KPAUIBenefitsCoveragePage extends KPAUIEveryAuthenticatedPage {

    public KPAUIBenefitsCoveragePage(WebDriver driver) {
        super(driver);
        if (!isCurrent(driver, PAGETITLE_BENEFITS_CONVERAGE))
            fail("The Benefits Coverage Page did not load correctly");
    }

    //------------------------------------------------------------------------------------------------------------------

    public static final String PAGETITLE_BENEFITS_CONVERAGE = "Your Health Coverage Index";

}
