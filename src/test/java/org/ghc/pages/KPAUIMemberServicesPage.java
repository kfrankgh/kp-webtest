package org.ghc.pages;

import org.ghc.utils.extensions.KPAUIEveryPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class KPAUIMemberServicesPage extends KPAUIEveryPage {

    public KPAUIMemberServicesPage(WebDriver driver) {
        super(driver);
        if (!isCurrent(driver, PAGETITLE_MEMBER_SERVICES))
            Assert.fail("The Message Center Page did not load correctly");
    }

    //------------------------------------------------------------------------------------------------------------------

    private static final String PAGETITLE_MEMBER_SERVICES = "Member Services";

}
