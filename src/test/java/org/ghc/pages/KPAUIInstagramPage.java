package org.ghc.pages;

import org.ghc.utils.extensions.KPAUIEveryAuthenticatedPage;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.fail;

public class KPAUIInstagramPage extends KPAUIEveryAuthenticatedPage {

    public KPAUIInstagramPage(WebDriver driver) {
        super(driver);
        if (!isCurrent(driver, PAGETITLE_INSTAGRAM))
            fail("The KP Instagram Page did not load correctly");
    }

    //------------------------------------------------------------------------------------------------------------------

    private static final String PAGETITLE_INSTAGRAM = "Instagram";

}
