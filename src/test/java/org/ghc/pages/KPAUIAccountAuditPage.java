package org.ghc.pages;

import org.ghc.utils.extensions.KPAUIEveryAuthenticatedPage;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.fail;

public class KPAUIAccountAuditPage extends KPAUIEveryAuthenticatedPage {

    public KPAUIAccountAuditPage(WebDriver driver) {
        super(driver);
        if (!isCurrent(driver, PAGETITLE_ACCOUNT_AUDIT))
            fail("The Account Audit Page did not load correctly");
    }

    //------------------------------------------------------------------------------------------------------------------

    private static final String PAGETITLE_ACCOUNT_AUDIT = "Account Audit";

}
