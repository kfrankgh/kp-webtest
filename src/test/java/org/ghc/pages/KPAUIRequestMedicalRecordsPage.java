package org.ghc.pages;

import org.ghc.utils.extensions.KPAUIEveryAuthenticatedPage;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.fail;

public class KPAUIRequestMedicalRecordsPage extends KPAUIEveryAuthenticatedPage {

    public KPAUIRequestMedicalRecordsPage(WebDriver driver) {
        super(driver);
        if (!isCurrent(driver, PAGETITLE_REQUEST_MEDICAL_RECORDS))
            fail("The Request Medical Records Page did not load correctly");
    }

    //------------------------------------------------------------------------------------------------------------------

    private static final String PAGETITLE_REQUEST_MEDICAL_RECORDS = "Transfer or Get Copies of Medical Records";


}