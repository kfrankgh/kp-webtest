package org.ghc.pages;

import org.ghc.utils.extensions.KPAUIEveryUnAuthenticatedPage;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.fail;

public class KPAUIReimbursementPage extends KPAUIEveryUnAuthenticatedPage {

    public KPAUIReimbursementPage(WebDriver driver) {
        super(driver);
        if (!isCurrent(driver, pageTitleReimbursement))
            fail("The Reimbursement Page did not load correctly");
    }

    //------------------------------------------------------------------------------------------------------------------

    private static final String pageTitleReimbursement = "Submit Claims for Reimbursement";

}
