package org.ghc.pages;

import org.ghc.utils.extensions.KPAUIEveryAuthenticatedPage;
import org.openqa.selenium.WebDriver;
import static org.testng.Assert.fail;

public class KPAUINewsAndViewsPage extends KPAUIEveryAuthenticatedPage {

    public KPAUINewsAndViewsPage(WebDriver driver) {
        super(driver);
        if (!isCurrent(driver, PAGETITLE_NEWS_AND_VIEWS))
            fail("The News & Views Page did not load correctly");
    }

    //------------------------------------------------------------------------------------------------------------------

    private static final String PAGETITLE_NEWS_AND_VIEWS = "Washington Archives - Kaiser Permanente Share";

}