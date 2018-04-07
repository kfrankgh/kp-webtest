package org.ghc.shades;

import org.ghc.pages.KPAUIAppointmentsPage;
import org.ghc.pages.KPAUIScheduleAppointmentPage;
import org.ghc.pages.KPAUISchedulingTicketPage;
import org.ghc.pages.KPAUIStartAnOnlineVisitPage;
import org.ghc.utils.extensions.KPAUIEveryShade;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.ghc.utils.helpers.KPAUITestHelper.waitForElement;
import static org.testng.Assert.fail;

public class KPAUIAppointmentsShade extends KPAUIEveryShade {

    public KPAUIAppointmentsShade(WebDriver driver) {
        super(driver);
        if (!isCurrent())
            fail("Appointments shade is not visible");
    }

    private boolean isCurrent() {
        return getMyVisitsSubHeader().isDisplayed();
    }

    //------------------------------------------------------------------------------------------------------------------

    public static final String MY_VISITS_SUBHEADER =        "My Visits";
    public static final String START_AN_ONLINE_VISIT =      "Start an Online Visit";
    public static final String APPOINTMENTS_AND_VISITS =    "Appointments & Visits";
    public static final String SCHEDULING_APPOINTMENTS =    "Schedule an Appointment";
    public static final String SCHEDULING_TICKETS =         "Scheduling Tickets";

    @FindBy(xpath = "//div/div[1]/div/p")                   private WebElement myVisitsSubHeader;
    @FindBy(xpath = "//div/div[1]/div/ul/li[2]/a")          private WebElement startAnOnlineVisitLink;
    @FindBy(xpath = "//div/div[1]/div/ul/li[1]/a")          private WebElement appointmentsLink;
    @FindBy(xpath = "//div/div[1]/div/ul/li[3]/a")          private WebElement scheduleAppointmentsLink;
    @FindBy(xpath = "//div/div[1]/div/ul/li[4]/a")          private WebElement schedulingTicketsLink;

    public WebElement getMyVisitsSubHeader()                { return waitForElement(myVisitsSubHeader, driver); }
    public WebElement getStartAnOnlineVisitLink()           { return startAnOnlineVisitLink; }
    public WebElement getAppointmentsLink()                 { return appointmentsLink; }
    public WebElement getScheduleAppointmentsLink()         { return scheduleAppointmentsLink; }
    public WebElement getSchedulingTicketsLink()            { return schedulingTicketsLink; }

    /** Opens the "Start Online Visit" Page
     * @return - KPAUIAppointmentsPage
     */
    public KPAUIStartAnOnlineVisitPage openStartOnlineVisitPage() {
        getStartAnOnlineVisitLink().click();
        return new KPAUIStartAnOnlineVisitPage(driver);
    }

    /** Opens the Appointments Page from the Appointments & Visits Link
     * @return - KPAUIAppointmentsPage
     */
    public KPAUIAppointmentsPage openAppointmentsPage() {
        getAppointmentsLink().click();
        return new KPAUIAppointmentsPage(driver);
    }

    /** Opens the Schedule Appointments Page from the "Schedule an Appointments" Link
     * @return - KPAUIScheduleAppointmentPage
     */
    public KPAUIScheduleAppointmentPage openScheduleAppointmentsPage() {
        getScheduleAppointmentsLink().click();
        return new KPAUIScheduleAppointmentPage(driver);
    }

    /** Opens the Scheduling Tickets Page from the "Scheduling Tickets" Link
     * @return - KPAUISchedulingTicketPage
     */
    public KPAUISchedulingTicketPage openSchedulingTicketsPage() {
        getSchedulingTicketsLink().click();
        return new KPAUISchedulingTicketPage(driver);
    }
}
