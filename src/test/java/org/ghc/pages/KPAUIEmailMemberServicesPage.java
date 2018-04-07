package org.ghc.pages;

import org.ghc.utils.extensions.KPAUIEveryUnAuthenticatedPage;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.fail;

public class KPAUIEmailMemberServicesPage extends KPAUIEveryUnAuthenticatedPage {

    public KPAUIEmailMemberServicesPage(WebDriver driver) {
        super(driver);
        if (!isCurrent(driver, pageTitleEmailMemberServices))
            fail("The Email Member Services Page did not load correctly");
    }

    //------------------------------------------------------------------------------------------------------------------

    private static final String pageTitleEmailMemberServices = "Email Member Services";


}
