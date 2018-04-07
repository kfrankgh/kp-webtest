package org.ghc.pages;

import org.ghc.utils.extensions.KPAUIEveryUnAuthenticatedPage;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.fail;

 public class KPAUIMedicalRecordsPage extends KPAUIEveryUnAuthenticatedPage {

     public KPAUIMedicalRecordsPage(WebDriver driver) {
        super(driver);
        if (!isCurrent(driver, pageTitleMedicalRecords))
            fail("The Medical Records Page did not load correctly");
    }

    //------------------------------------------------------------------------------------------------------------------

     private static final String pageTitleMedicalRecords = "Transfer or Get Copies of Medical Records";

 }
