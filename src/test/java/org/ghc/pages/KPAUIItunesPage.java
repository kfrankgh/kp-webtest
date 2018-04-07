package org.ghc.pages;

import org.ghc.utils.extensions.KPAUIEveryPage;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.fail;

public class KPAUIItunesPage extends KPAUIEveryPage{

    public KPAUIItunesPage(WebDriver driver) {
        super(driver);
        if (!isCurrent(driver, PAGETITLE_UNAUTHENTICATED_ITUNES))
            fail("The ITunes Page did not load correctly");
    }

    //------------------------------------------------------------------------------------------------------------------

    private static final String PAGETITLE_UNAUTHENTICATED_ITUNES = "Kaiser Permanente Washington on the App Store";


}
