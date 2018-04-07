package org.ghc.pages;

import org.ghc.utils.extensions.KPAUIEveryUnAuthenticatedPage;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.fail;

public class KPAUICommunityHealthPage extends KPAUIEveryUnAuthenticatedPage {

    public KPAUICommunityHealthPage(WebDriver driver) {
        super(driver);
        if (!isCurrent(driver, PAGETITLE_COMMUNITY_HEALTH))
            fail("The Community Health Page did not load correctly");
    }

    //------------------------------------------------------------------------------------------------------------------

    private static final String PAGETITLE_COMMUNITY_HEALTH = "Creating Healthy Communities";

}