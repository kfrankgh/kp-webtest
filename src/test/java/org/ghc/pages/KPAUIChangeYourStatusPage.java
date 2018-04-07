package org.ghc.pages;

import org.ghc.utils.extensions.KPAUIEveryAuthenticatedPage;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.fail;

class KPAUIChangeYourStatusPage extends KPAUIEveryAuthenticatedPage {

    KPAUIChangeYourStatusPage(WebDriver driver) {
        super(driver);
        if (!isCurrent(driver, PAGETITLE_CHANGE_STATUS))
            fail("The Change Your Status Page did not load correctly");
    }

    //------------------------------------------------------------------------------------------------------------------

    private static final String PAGETITLE_CHANGE_STATUS = "Changing Your Status";

}
