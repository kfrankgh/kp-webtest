package org.ghc.pages;

import org.ghc.utils.extensions.KPAUIEveryUnAuthenticatedPage;
import org.openqa.selenium.WebDriver;

import static org.ghc.utils.helpers.KPAUITestHelper.getChildDriver;
import static org.testng.Assert.fail;

public class KPAUIVitalsChoicePage extends KPAUIEveryUnAuthenticatedPage {

    public KPAUIVitalsChoicePage(WebDriver driver) {
        super(driver);
        if (!isCurrent(getChildDriver(driver), "Home"))
            fail("The Vitals Choice Page did not load correctly");
    }

    //------------------------------------------------------------------------------------------------------------------
}