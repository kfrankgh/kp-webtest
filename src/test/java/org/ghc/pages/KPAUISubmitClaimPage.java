package org.ghc.pages;

import org.ghc.utils.extensions.KPAUIEveryAuthenticatedPage;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.fail;

public class KPAUISubmitClaimPage extends KPAUIEveryAuthenticatedPage {

    public KPAUISubmitClaimPage(WebDriver driver) {
        super(driver);
        if (!isCurrent(driver, PAGETITLE_SUBMIT_CLAIM))
            fail("The Submit Claims Page did not load correctly");
    }

    //------------------------------------------------------------------------------------------------------------------

    private static final String PAGETITLE_SUBMIT_CLAIM = "Request a Coverage Decision Appeal";


}
