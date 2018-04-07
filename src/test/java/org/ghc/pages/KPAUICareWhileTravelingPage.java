package org.ghc.pages;

import org.ghc.utils.extensions.KPAUIEveryAuthenticatedPage;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.fail;

public class KPAUICareWhileTravelingPage extends KPAUIEveryAuthenticatedPage {

    public KPAUICareWhileTravelingPage(WebDriver driver) {
        super(driver);
        if (!isCurrent(driver, PAGETITLE_CARE_WHILE_TRAVELING))
            fail("The Care While Traveling Page did not load correctly");
    }

    //------------------------------------------------------------------------------------------------------------------

    private static final String PAGETITLE_CARE_WHILE_TRAVELING = "Travel Health: When You Are Traveling";

}
