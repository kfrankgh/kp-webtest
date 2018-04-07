package org.ghc.pages;

import org.ghc.utils.extensions.KPAUIEveryAuthenticatedPage;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.fail;

public class KPAUIRefillPrescriptionPage extends KPAUIEveryAuthenticatedPage {

    public KPAUIRefillPrescriptionPage(WebDriver driver) {
        super(driver);
        if (!isCurrent(driver, PAGETITLE_REFILL_PRESCRIPTION))
            fail("The Refill Medications Page did not load correctly");
    }

    //------------------------------------------------------------------------------------------------------------------

    private static final String PAGETITLE_REFILL_PRESCRIPTION = "Medications";


}
