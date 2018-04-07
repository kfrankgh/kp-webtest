package org.ghc.pages;

import org.ghc.utils.extensions.KPAUIEveryUnAuthenticatedPage;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.fail;

public class KPAUIUnauthenticatedBusinessPage extends KPAUIEveryUnAuthenticatedPage{

    public KPAUIUnauthenticatedBusinessPage(WebDriver driver) {
        super(driver);
        if (!isCurrent(driver, PAGETITLE_UNAUTHENTICATED_BUSINESS))
            fail("The KP Unauthenticated Business Portal Page did not load correctly");

    }

    //------------------------------------------------------------------------------------------------------------------

    private static final String PAGETITLE_UNAUTHENTICATED_BUSINESS = "Washington Health Insurance for Employers";


}