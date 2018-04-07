package org.ghc.pages;

import org.ghc.utils.extensions.KPAUIEveryAuthenticatedPage;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.fail;

public class KPAUISiteMapPage extends KPAUIEveryAuthenticatedPage {

    public KPAUISiteMapPage(WebDriver driver) {
        super(driver);
        if (!isCurrent(driver, PAGETITLE_LOGIN_FCC))
            fail("The Site Map Page did not load correctly");
    }

    //------------------------------------------------------------------------------------------------------------------
    private static final String PAGETITLE_LOGIN_FCC = "Site Map";

}