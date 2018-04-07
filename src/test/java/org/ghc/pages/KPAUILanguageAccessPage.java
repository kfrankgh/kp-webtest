package org.ghc.pages;

import org.ghc.utils.extensions.KPAUIEveryAuthenticatedPage;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.fail;

public class KPAUILanguageAccessPage extends KPAUIEveryAuthenticatedPage {

    public KPAUILanguageAccessPage(WebDriver driver) {
        super(driver);
        if (!isCurrent(driver, PAGETITLE_LANGUAGE_ACCESS))
            fail("The Language Access Page did not load correctly");
    }

    //------------------------------------------------------------------------------------------------------------------

    private static final String PAGETITLE_LANGUAGE_ACCESS = "Language Access Services";

}