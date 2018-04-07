package org.ghc.pages;

import org.ghc.utils.extensions.KPAUIEveryAuthenticatedPage;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.fail;

public class KPAUIEmergencyAndUrgentCarePage extends KPAUIEveryAuthenticatedPage {

    public KPAUIEmergencyAndUrgentCarePage(WebDriver driver) {
        super(driver);
        if (!isCurrent(driver, PAGETITLE_EMERGENCY_URGENT_CARE))
            fail("The Emergency Care Page did not load correctly");
    }

    //------------------------------------------------------------------------------------------------------------------

    private static final String PAGETITLE_EMERGENCY_URGENT_CARE = "Emergency and Urgent Care";


}
