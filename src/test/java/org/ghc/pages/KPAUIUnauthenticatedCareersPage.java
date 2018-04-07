package org.ghc.pages;

import org.ghc.utils.extensions.KPAUIEveryUnAuthenticatedPage;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.fail;

public class KPAUIUnauthenticatedCareersPage extends KPAUIEveryUnAuthenticatedPage{

    public KPAUIUnauthenticatedCareersPage(WebDriver driver) {
        super(driver);
        if (!isCurrent(driver, PAGETITLE_CAREERS))
            fail("The KP Unauthenticated Careers Page did not load correctly");
    }

    //------------------------------------------------------------------------------------------------------------------
    private static final String PAGETITLE_CAREERS = "Working at Kaiser Permanente";


}

