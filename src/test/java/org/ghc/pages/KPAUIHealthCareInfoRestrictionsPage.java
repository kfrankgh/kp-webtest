package org.ghc.pages;

import org.ghc.utils.extensions.KPAUIEveryUnAuthenticatedPage;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.fail;

public class KPAUIHealthCareInfoRestrictionsPage extends KPAUIEveryUnAuthenticatedPage {

    public KPAUIHealthCareInfoRestrictionsPage(WebDriver driver) {
        super(driver);
        if (!isCurrent(driver, pageTitleHealthCareInfoRestrictions))
            fail("The Restrictions on the release of health care information Page did not load correctly");
    }

    //------------------------------------------------------------------------------------------------------------------

    private static final String pageTitleHealthCareInfoRestrictions = "Restrictions on the Release of Health Care Information";


}