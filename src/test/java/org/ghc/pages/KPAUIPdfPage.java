package org.ghc.pages;

import org.ghc.utils.extensions.KPAUIEveryAuthenticatedPage;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.fail;

public class KPAUIPdfPage extends KPAUIEveryAuthenticatedPage {

    public KPAUIPdfPage(WebDriver driver) {
        super(driver);
        if (!driver.getTitle().contains(PAGETITLE_COVERAGE_DOCUMENTS)) {
            fail("The PDF did not load correctly");
        }
    }

    //------------------------------------------------------------------------------------------------------------------

    private static final String PAGETITLE_COVERAGE_DOCUMENTS = "Your Health Coverage Index";

}