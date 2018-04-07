package org.ghc.pages;

import org.ghc.utils.extensions.KPAUIEveryUnAuthenticatedPage;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.fail;

class KPAUIFluSymptomsPage extends KPAUIEveryUnAuthenticatedPage {

    KPAUIFluSymptomsPage(WebDriver driver) {
        super(driver);
        if (!isCurrent(driver, pageTitleGetCareForFlu))
            fail("The Get Care for Flu Symptoms Page did not load correctly");
    }

    //------------------------------------------------------------------------------------------------------------------

    private static final String pageTitleGetCareForFlu = "Get Care for Flu Symptoms";

}
