package org.ghc.pages;

import org.ghc.utils.extensions.KPAUIEveryUnAuthenticatedPage;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.fail;

public class KPAUIHealthAndWellnessPage extends KPAUIEveryUnAuthenticatedPage {

    public KPAUIHealthAndWellnessPage(WebDriver driver) {
        super(driver);
        if (!isCurrent(driver, pageTitleHealthAndWellness))
            fail("The Health and Wellness Page did not load correctly");
    }

    //------------------------------------------------------------------------------------------------------------------

    private static final String pageTitleHealthAndWellness = "Health and Wellness Resources";

}

