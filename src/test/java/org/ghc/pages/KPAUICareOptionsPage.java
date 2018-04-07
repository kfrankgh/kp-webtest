package org.ghc.pages;

import org.ghc.utils.extensions.KPAUIEveryAuthenticatedPage;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.fail;

public class KPAUICareOptionsPage extends KPAUIEveryAuthenticatedPage {

    public KPAUICareOptionsPage(WebDriver driver) {
        super(driver);
        if (!isCurrent(driver, PAGETITLE_CARE_OPTIONS))
            fail("The Care Options Page did not load correctly");
    }

    //------------------------------------------------------------------------------------------------------------------

    private static final String PAGETITLE_CARE_OPTIONS = "Find the Best Care Option";

}
