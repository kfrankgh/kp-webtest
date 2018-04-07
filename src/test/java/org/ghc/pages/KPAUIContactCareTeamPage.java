package org.ghc.pages;

import org.ghc.utils.extensions.KPAUIEveryAuthenticatedPage;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.fail;

public class KPAUIContactCareTeamPage extends KPAUIEveryAuthenticatedPage {

    public KPAUIContactCareTeamPage(WebDriver driver) {
        super(driver);
        if (!isCurrent(driver, PAGETITLE_CONTACT_YOUR_CARE_TEAM))
            fail("The Contact Your Care Team Page did not load correctly");
    }

    //------------------------------------------------------------------------------------------------------------------

    private static final String PAGETITLE_CONTACT_YOUR_CARE_TEAM = "Contact Care Team";


}
