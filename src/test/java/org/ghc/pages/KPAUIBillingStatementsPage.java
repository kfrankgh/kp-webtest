package org.ghc.pages;

import org.ghc.utils.extensions.KPAUIEveryAuthenticatedPage;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.fail;

public class KPAUIBillingStatementsPage extends KPAUIEveryAuthenticatedPage {

    public KPAUIBillingStatementsPage(WebDriver driver) {
        super(driver);
        if (!isCurrent(driver, PAGETITLE_ONLINE_BILLPAY))
            fail("The Online Bill Pay Page did not load correctly");
    }

    //------------------------------------------------------------------------------------------------------------------
    private static final String PAGETITLE_ONLINE_BILLPAY = "Billing Statement for Medical Services";

}
