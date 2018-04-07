package org.ghc.pages;

import org.ghc.utils.extensions.KPAUIEveryAuthenticatedPage;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.fail;

public class KPAUIAllergiesPage extends KPAUIEveryAuthenticatedPage {

    public KPAUIAllergiesPage(WebDriver driver) {
        super(driver);
        if (!isCurrent(driver, PAGETITLE_ALLERGIES))
            fail("The Allergies Page did not load correctly");
    }

    //------------------------------------------------------------------------------------------------------------------

    private static final String PAGETITLE_ALLERGIES = "Allergies";

}
