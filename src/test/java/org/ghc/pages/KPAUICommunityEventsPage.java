package org.ghc.pages;

import org.ghc.utils.extensions.KPAUIEveryUnAuthenticatedPage;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.fail;

public class KPAUICommunityEventsPage extends KPAUIEveryUnAuthenticatedPage {

    public KPAUICommunityEventsPage(WebDriver driver) {
        super(driver);
        if (!isCurrent(driver, pageTitleCommunityEvents))
            fail("The Community Events Page did not load correctly");
    }

    //------------------------------------------------------------------------------------------------------------------

    private static final String pageTitleCommunityEvents = "Kaiser Permanente-Sponsored Community Events";

}
