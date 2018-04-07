package org.ghc.pages;

import org.ghc.utils.extensions.KPAUIEveryAuthenticatedPage;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.fail;

public class KPAUISchedulingTicketPage extends KPAUIEveryAuthenticatedPage {

    public KPAUISchedulingTicketPage(WebDriver driver) {
        super(driver);
        if (!isCurrent(driver, PAGETITLE_SCHEDULING_TICKETS))
            fail("The Scheduling Tickets Page did not load correctly");
    }

    //------------------------------------------------------------------------------------------------------------------

    private static final String PAGETITLE_SCHEDULING_TICKETS = "Scheduling Tickets";
}
