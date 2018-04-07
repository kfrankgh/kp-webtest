package org.ghc.pages;

import org.ghc.utils.extensions.KPAUIEveryUnAuthenticatedPage;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.fail;

public class KPAUITermsOfUsePage extends KPAUIEveryUnAuthenticatedPage {

    public KPAUITermsOfUsePage(WebDriver driver) {
        super(driver);
        if (!isCurrent(driver, pageTitleTermsOfUse))
            fail("Terms of Use Page did not load correctly");
    }

    //------------------------------------------------------------------------------------------------------------------

    private static final String pageTitleTermsOfUse = "Terms of Use";


}