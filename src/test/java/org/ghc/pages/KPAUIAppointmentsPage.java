package org.ghc.pages;

import org.ghc.utils.extensions.KPAUIEveryAuthenticatedPage;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.fail;

public class KPAUIAppointmentsPage extends KPAUIEveryAuthenticatedPage {

    public KPAUIAppointmentsPage(WebDriver driver) {
        super(driver);
        if (!isCurrent(driver, PAGETITLE_APPOINTMENTS))
            fail("The Appointments Page did not load correctly");
    }

    //------------------------------------------------------------------------------------------------------------------

    private static final String PAGETITLE_APPOINTMENTS = "Appointments and Visits";

}

