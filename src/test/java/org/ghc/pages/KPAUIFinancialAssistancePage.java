package org.ghc.pages;

import org.ghc.utils.extensions.KPAUIEveryAuthenticatedPage;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.fail;

public class KPAUIFinancialAssistancePage extends KPAUIEveryAuthenticatedPage {

    public KPAUIFinancialAssistancePage(WebDriver driver) {
        super(driver);
        if (!isCurrent(driver, PAGETITLE_FINANCIAL_ASSISTANCE))
            fail("The Financial Assistance Page did not load correctly");
    }

    //------------------------------------------------------------------------------------------------------------------

    private static final String PAGETITLE_FINANCIAL_ASSISTANCE = "Medical Financial Assistance";


}
