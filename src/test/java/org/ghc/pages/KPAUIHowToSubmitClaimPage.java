package org.ghc.pages;

import org.ghc.utils.extensions.KPAUIEveryAuthenticatedPage;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.fail;

public class KPAUIHowToSubmitClaimPage extends KPAUIEveryAuthenticatedPage {
    public KPAUIHowToSubmitClaimPage(WebDriver driver) {
        super(driver);
        if (!isCurrent(driver, PAGETITLE_CLAIM_REIMBURSEMENT))
            fail("The Claims Reimbursement Page did not load correctly");
    }

    //------------------------------------------------------------------------------------------------------------------

    private static final String PAGETITLE_CLAIM_REIMBURSEMENT = "Submit Claims for Reimbursement";

}
