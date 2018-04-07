package org.ghc.pages;

import org.ghc.utils.extensions.KPAUIEveryUnAuthenticatedPage;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.fail;

public class KPAUIVisionAndEyeCarePage extends KPAUIEveryUnAuthenticatedPage {

    public KPAUIVisionAndEyeCarePage(WebDriver driver) {
        super(driver);
        if (!isCurrent(driver, pageTitleVisionAndEyeCare))
            fail("The Vision and Eye Care Page did not load correctly");
    }

    //------------------------------------------------------------------------------------------------------------------

    private static final String pageTitleVisionAndEyeCare = "Eye care services";

}
