package org.ghc.pages;

import org.ghc.utils.extensions.KPAUIEveryAuthenticatedPage;
import org.openqa.selenium.WebDriver;
import static org.testng.Assert.fail;

public class KPAUIOnlineVisitsPage extends KPAUIEveryAuthenticatedPage {

    public KPAUIOnlineVisitsPage(WebDriver driver) {
        super(driver);
        if (!isCurrent(driver, PAGETITLE_ONLINE_VISITS))
            fail("The Online Visit Page did not load correctly");
    }

    //------------------------------------------------------------------------------------------------------------------

    private static final String PAGETITLE_ONLINE_VISITS = "Online Visit";


}
