package org.ghc.pages;

import org.ghc.utils.extensions.KPAUIEveryUnAuthenticatedPage;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.fail;

public class KPAUIBillingAndPaymentPage extends KPAUIEveryUnAuthenticatedPage {

    public KPAUIBillingAndPaymentPage(WebDriver driver) {
        super(driver);
        if (!isCurrent(driver, pageTitleBillingAndPayment))
            fail("The Billing and Payment Page did not load correctly");
    }

    //------------------------------------------------------------------------------------------------------------------

    private static final String pageTitleBillingAndPayment = "Kaiser Permanente Washington Billing and Payment";

}
