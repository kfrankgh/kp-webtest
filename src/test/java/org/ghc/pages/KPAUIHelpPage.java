package org.ghc.pages;

import org.ghc.utils.extensions.KPAUIEveryAuthenticatedPage;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.fail;

public class KPAUIHelpPage extends KPAUIEveryAuthenticatedPage {
    public KPAUIHelpPage(WebDriver driver) {
        super(driver);
        if (!isCurrent(driver, PAGETITLE_HELP))
            fail("The Help Page did not load correctly");
    }

    //------------------------------------------------------------------------------------------------------------------

    private static final String PAGETITLE_HELP = "Technical Help";

}