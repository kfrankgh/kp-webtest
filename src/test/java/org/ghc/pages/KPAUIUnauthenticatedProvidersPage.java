package org.ghc.pages;

import org.ghc.utils.extensions.KPAUIEveryAuthenticatedPage;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.fail;

public class KPAUIUnauthenticatedProvidersPage extends KPAUIEveryAuthenticatedPage{

    public KPAUIUnauthenticatedProvidersPage(WebDriver driver) {
        super(driver);
        if (!isCurrent(driver, PAGETITLE_UNAUTHENTICATED_PROVIDERS))
            fail("The KP Unauthenticated Providers Page did not load correctly");
    }

    //------------------------------------------------------------------------------------------------------------------

    private static final String PAGETITLE_UNAUTHENTICATED_PROVIDERS = "Providers";

}