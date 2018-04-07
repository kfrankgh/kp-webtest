package org.ghc.pages;

import org.ghc.utils.extensions.KPAUIEveryAuthenticatedPage;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.fail;

public class KPAUIScheduleAppointmentPage extends KPAUIEveryAuthenticatedPage {

        public KPAUIScheduleAppointmentPage(WebDriver driver) {
            super(driver);
            if (!isCurrent(driver, PAGETITLE_SCHEDULE_APPOINTMENTS))
                fail("The Schedule Appointments Page did not load correctly");
    }

    //------------------------------------------------------------------------------------------------------------------

    private static final String PAGETITLE_SCHEDULE_APPOINTMENTS = "Schedule Appointment";


}
