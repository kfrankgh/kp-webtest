package org.ghc.pages;

import org.ghc.utils.extensions.KPAUIEveryAuthenticatedPage;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.fail;

public class KPAUIRoutineCareRemindersPage extends KPAUIEveryAuthenticatedPage {

    public KPAUIRoutineCareRemindersPage(WebDriver driver) {
        super(driver);
        if (!isCurrent(driver, PAGETITLE_ROUTINE_CARE_REMINDERS))
            fail("The Routine Care Reminders Page did not load correctly");
    }

    //------------------------------------------------------------------------------------------------------------------

    private static final String PAGETITLE_ROUTINE_CARE_REMINDERS = "Routine-Care Reminders";


}
