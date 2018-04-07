package org.ghc.pages;

import org.ghc.utils.extensions.KPAUIEveryAuthenticatedPage;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.fail;

public class KPAUIExplanationOfBenefitsPage extends KPAUIEveryAuthenticatedPage {

    public KPAUIExplanationOfBenefitsPage(WebDriver driver) {
        super(driver);
        if (!isCurrent(driver, PAGETITLE_BENEFITS_EXPLANATION))
            fail("The Explanation of benefits Page did not load correctly");
    }

    //------------------------------------------------------------------------------------------------------------------

    private static final String PAGETITLE_BENEFITS_EXPLANATION = "Find an Explanation of Benefits Statement";

}
