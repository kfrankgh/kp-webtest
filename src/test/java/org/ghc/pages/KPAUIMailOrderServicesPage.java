package org.ghc.pages;

import org.ghc.utils.extensions.KPAUIEveryAuthenticatedPage;
import org.openqa.selenium.WebDriver;
import static org.testng.Assert.fail;

public class KPAUIMailOrderServicesPage extends KPAUIEveryAuthenticatedPage {

    public KPAUIMailOrderServicesPage(WebDriver driver) {
        super(driver);
        if (!isCurrent(driver, PAGETITLE_MAILORDER_SERVICES))
            fail("The Mail Order Services Page did not load correctly");
    }

    //------------------------------------------------------------------------------------------------------------------

    private static final String PAGETITLE_MAILORDER_SERVICES = "Mail Order Pharmacy Services";


}
