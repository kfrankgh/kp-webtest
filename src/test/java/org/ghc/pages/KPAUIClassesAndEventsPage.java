package org.ghc.pages;

import org.ghc.utils.extensions.KPAUIEveryUnAuthenticatedPage;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.fail;

public class KPAUIClassesAndEventsPage extends KPAUIEveryUnAuthenticatedPage {

    public KPAUIClassesAndEventsPage(WebDriver driver) {
        super(driver);
        if (!isCurrent(driver, pageTitleClassesAndEvents))
            fail("The Classes and Events Page did not load correctly");
    }

    //------------------------------------------------------------------------------------------------------------------

    private static final String pageTitleClassesAndEvents = "Kaiser Permanente Washington Events and Classes";

}