package org.ghc.pages;

import org.ghc.utils.extensions.KPAUIEveryAuthenticatedPage;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.fail;

public class KPAUIChildDashboardPage extends KPAUIEveryAuthenticatedPage {

    public KPAUIChildDashboardPage(WebDriver driver) {
        super(driver);
        if (!isCurrent(driver, PAGETITLE_CHILD_DASHBOARD))
            fail("The Child Dashboard/Messages Page Did Not Load Correctly");
    }

    //------------------------------------------------------------------------------------------------------------------

    private static final String PAGETITLE_CHILD_DASHBOARD = "Kaiser Permanente - Home";

}
