package org.ghc.pages;

import org.ghc.utils.extensions.KPAUIEveryAuthenticatedPage;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.fail;

public class KPAUICoverageAndClaimsAppealsPage extends KPAUIEveryAuthenticatedPage {

    public KPAUICoverageAndClaimsAppealsPage(WebDriver driver) {
        super(driver);
        if (!isCurrent(driver, PAGETITLE_CLAIMS_APPEALS))
            fail("The Claims Appeals Page did not load correctly");
    }

    //------------------------------------------------------------------------------------------------------------------

    private static final String PAGETITLE_CLAIMS_APPEALS = "Coverage and Claims Appeals";


}
