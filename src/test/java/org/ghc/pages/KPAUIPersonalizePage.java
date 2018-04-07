package org.ghc.pages;

import org.ghc.utils.extensions.KPAUIEveryAuthenticatedPage;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.fail;

public class KPAUIPersonalizePage extends KPAUIEveryAuthenticatedPage {

    public KPAUIPersonalizePage(WebDriver driver) {
        super(driver);
        if (!isCurrent(driver, PAGETITLE_PERSONALIZE))
            fail("The Personalize Page did not load correctly");
    }

    //------------------------------------------------------------------------------------------------------------------
    private static final String PAGETITLE_PERSONALIZE = "Personalize";


}
