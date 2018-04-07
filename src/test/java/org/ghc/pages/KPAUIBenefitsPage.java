package org.ghc.pages;

import org.ghc.utils.extensions.KPAUIEveryAuthenticatedPage;
import org.openqa.selenium.WebDriver;
import static org.testng.Assert.fail;

public class KPAUIBenefitsPage extends KPAUIEveryAuthenticatedPage {
    public KPAUIBenefitsPage(WebDriver driver) {
        super(driver);
        if (!isCurrent(driver, PAGETITLE_BENEFITS))
            fail("The Benefits Page did not load correctly");
    }

    //------------------------------------------------------------------------------------------------------------------

    private static final String PAGETITLE_BENEFITS = "Secure Member Site";

}
