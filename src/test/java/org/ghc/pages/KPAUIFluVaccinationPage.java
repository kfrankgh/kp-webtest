package org.ghc.pages;

import org.ghc.utils.extensions.KPAUIEveryUnAuthenticatedPage;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.fail;

public class KPAUIFluVaccinationPage extends KPAUIEveryUnAuthenticatedPage {

    public KPAUIFluVaccinationPage(WebDriver driver) {
        super(driver);
        if (!isCurrent(driver, pageTitleGetFluShot))
            fail("The Flu Vaccination Page did not load correctly");
    }

    //------------------------------------------------------------------------------------------------------------------

    private static final String pageTitleGetFluShot = "Flu Vaccinations";

}
