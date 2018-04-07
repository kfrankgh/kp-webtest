package org.ghc.pages;

import org.ghc.utils.extensions.KPAUIEveryAuthenticatedPage;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.fail;

public class KPAUILinkedInPage extends KPAUIEveryAuthenticatedPage {

    public KPAUILinkedInPage(WebDriver driver) {
        super(driver);
        if (!isCurrent(driver, PAGETITLE_LINKEDIN))
            fail("The KP LinkedIn Page did not load correctly");
    }

    //------------------------------------------------------------------------------------------------------------------

    private static final String PAGETITLE_LINKEDIN = "LinkedIn";

}
