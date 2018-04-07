package org.ghc.pages;

import org.ghc.utils.extensions.KPAUIEveryAuthenticatedPage;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.fail;

public class KPAUIStartAnOnlineVisitPage extends KPAUIEveryAuthenticatedPage {

    public KPAUIStartAnOnlineVisitPage(WebDriver driver) {
        super(driver);
        if (!isCurrent(driver, PAGETITLE_START_ONLINE_VISIT))
            fail("The Start an Online Visit Page did not load correctly");
    }

    //------------------------------------------------------------------------------------------------------------------

    private static final String PAGETITLE_START_ONLINE_VISIT = "Online Visit";


}
