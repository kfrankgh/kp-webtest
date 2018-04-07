package org.ghc.pages;

import org.ghc.utils.extensions.KPAUIEveryAuthenticatedPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class KPAUIMessageCenterPage extends KPAUIEveryAuthenticatedPage{

    public KPAUIMessageCenterPage(WebDriver driver) {
        super(driver);
        if (!isCurrent(driver, PAGETITLE_MESSAGE_CENTER))
            Assert.fail("The Message Center Page did not load correctly");
    }

    //------------------------------------------------------------------------------------------------------------------

    private static final String PAGETITLE_MESSAGE_CENTER = "Message Center";

}
