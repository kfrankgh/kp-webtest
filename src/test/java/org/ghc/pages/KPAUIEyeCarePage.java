package org.ghc.pages;

import org.ghc.utils.extensions.KPAUIEveryAuthenticatedPage;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.fail;

public class KPAUIEyeCarePage extends KPAUIEveryAuthenticatedPage {

    public KPAUIEyeCarePage(WebDriver driver) {
        super(driver);
        if (!isCurrent(driver, PAGETITLE_EYECARE))
            fail("The Eye Care Page did not load correctly");
    }

    //------------------------------------------------------------------------------------------------------------------

    private static final String PAGETITLE_EYECARE = "Quality Eye Care & Designer Eyewear";


}
