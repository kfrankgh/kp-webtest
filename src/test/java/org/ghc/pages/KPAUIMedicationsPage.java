package org.ghc.pages;

import org.ghc.utils.extensions.KPAUIEveryAuthenticatedPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class KPAUIMedicationsPage extends KPAUIEveryAuthenticatedPage {

    public KPAUIMedicationsPage(WebDriver driver) {
        super(driver);
        if (!isCurrent(driver, PAGETITLE_MEDICATIONS))
            Assert.fail("The Medications Page did not load correctly");
    }

    //------------------------------------------------------------------------------------------------------------------

    private static final String PAGETITLE_MEDICATIONS = "Medications";

}
