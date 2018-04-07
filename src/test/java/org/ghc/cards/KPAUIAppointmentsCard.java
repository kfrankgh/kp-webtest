/**
 * Created by KaiserPermanente
 */

package org.ghc.cards;

import org.ghc.pages.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.ghc.utils.helpers.KPAUITestHelper.waitForElement;
import static org.ghc.utils.helpers.KPAUITestHelper.waitForElementToBeClickable;
import static org.testng.Assert.fail;


public class KPAUIAppointmentsCard {
    private WebDriver driver;

    public KPAUIAppointmentsCard(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        if (!isCurrent())
            fail("Appointments Card is not visible");
    }

    private boolean isCurrent() {
        return getAppointmentsHeader().isDisplayed();
    }

    //------------------------------------------------------------------------------------------------------------------

    private static final String cardPrefix1 =                               "//kp-appointments-card/core-card/div/div[1]/div";
    private static final String cardPrefix2 =                               "//kp-appointments-card/core-card/div/div[2]/div";
    private static final String header =                                    "Appointments \\(\\d+\\)";
    private static final String noMessage =                                 "You have no upcoming appointments.";
    private static final String scheduleAppointment =                       "SCHEDULE AN APPOINTMENT";
    private static final String viewAppointment =                           "VIEW APPOINTMENT";
    private static final String viewPastAppointment =                       "VIEW PAST APPOINTMENTS";

    @FindBy(xpath = cardPrefix1 + "/img")                                   private WebElement appointmentsArrow;
    @FindBy(xpath = cardPrefix2 + "/div/div[3]/div[1]")                     private WebElement appointmentsClinician;
    @FindBy(xpath = cardPrefix2 + "/div/div[2]")                            private WebElement appointmentsDateAndTime;
    @FindBy(xpath = cardPrefix1 + "/h4")                                    private WebElement appointmentsHeader;
    @FindBy(xpath = cardPrefix2 + "/div/div[3]/div[2]/core-link/a/span")    private WebElement appointmentsLocation;
    @FindBy(xpath = cardPrefix2 + "/div/div[3]/div[2]/core-link/a/img")     private WebElement appointmentsMapPin;
    @FindBy(xpath = cardPrefix2 + "/div/div[3]/div[3]")                     private WebElement appointmentsPhoneNumber;
    @FindBy(xpath = cardPrefix2 + "/div/div[1]")                            private WebElement appointmentsType;
    @FindBy(xpath = cardPrefix2 + "/div/div[1]")                            private WebElement noUpComingAppointments;
    @FindBy(xpath = cardPrefix2 + "/div/div[4]/core-link[1]/a")             private WebElement scheduleAppointmentLink;
    @FindBy(xpath = cardPrefix2 + "/div/div[4]/core-link[1]/a/img")         private WebElement scheduleAppointmentIcon;
    @FindBy(xpath = cardPrefix2 + "/div/div[2]/core-link[1]/a")             private WebElement scheduleAppointmentWithNoAptsLink;
    @FindBy(xpath = cardPrefix2 + "/div/div[2]/core-link[1]/a/img")         private WebElement scheduleAppointmentWithNoAptsIcon;
    @FindBy(xpath = cardPrefix2 + "/div/div[2]/core-link[2]/a/img")         private WebElement viewPastAppointmentsIcon;
    @FindBy(xpath = cardPrefix2 + "/div/div[2]/core-link[2]/a")             private WebElement viewPastAppointmentsLink;
    @FindBy(xpath = cardPrefix2 + "/div/div[4]/core-link[2]/a/img")         private WebElement viewAppointmentsIcon;
    @FindBy(xpath = cardPrefix2 + "/div/div[4]/core-link[2]/a")             private WebElement viewAppointmentsLink;

    private WebElement getAppointmentsArrow()                               { return waitForElement(appointmentsArrow, driver); }
    public WebElement getAppointmentDateAndTime()                           { return waitForElement(appointmentsDateAndTime, driver); }
    public WebElement getAppointmentsHeader()                               { return waitForElementToBeClickable(appointmentsHeader, driver); }
    public WebElement getAppointmentLocationLink()                          { return waitForElement(appointmentsLocation, driver); }
    public WebElement getAppointmentType()                                  { return waitForElement(appointmentsType, driver); }
    public WebElement getClinicianNameAndTitle()                            { return waitForElement(appointmentsClinician, driver); }
    public WebElement getMapPin()                                           { return waitForElement(appointmentsMapPin, driver); }
    private WebElement getNoAppointmentsMessage()                           { return waitForElement(noUpComingAppointments, driver); }
    public WebElement getPhoneNumber()                                      { return waitForElement(appointmentsPhoneNumber, driver); }
    private WebElement getScheduleAppointmentsIcon()                        { return waitForElement(scheduleAppointmentIcon, driver); }
    private WebElement getScheduleAppointmentsLink()                        { return waitForElementToBeClickable(scheduleAppointmentLink, driver); }
    private WebElement getScheduleAppointmentWithNoAptsIcon()               { return waitForElement(scheduleAppointmentWithNoAptsIcon, driver); }
    private WebElement getScheduleAppointmentWithNoAptsLink()               { return waitForElementToBeClickable(scheduleAppointmentWithNoAptsLink, driver); }
    private WebElement getViewAppointmentsIcon()                            { return waitForElement(viewAppointmentsIcon, driver); }
    private WebElement getViewAppointmentsLink()                            { return waitForElementToBeClickable(viewAppointmentsLink, driver); }
    private WebElement getViewPastAppointmentsIcon()                        { return waitForElement(viewPastAppointmentsIcon, driver); }
    private WebElement getViewPastAppointmentsLink()                        { return waitForElementToBeClickable(viewPastAppointmentsLink, driver); }


    /** Opens the Appointments Page from the "Appointments" Header
     * @return - The Appointments Page (KPAUIAppointmentsPage)
     */
    public KPAUIAppointmentsPage openAppointmentsPageFromHeader() {
        getAppointmentsHeader().click();
        return new KPAUIAppointmentsPage(driver);
    }

    /** Opens the Appointments Page From the "View Appointments" Element
     * @return - The Appointments Page (KPAUIAppointmentsPage)
     */
    public KPAUIAppointmentsPage openViewAppointmentsPage() {
        getViewAppointmentsLink().click();
        return new KPAUIAppointmentsPage(driver);
    }

    /** Opens the Appointments Page From the "View Past Appointments" Element (no appointments)
     * @return - The Appointments Page (KPAUIAppointmentsPage)
     */
    public KPAUIAppointmentsPage openViewPastAppointmentsPage() {
        getViewPastAppointmentsLink().click();
        return new KPAUIAppointmentsPage(driver);
    }

    /** Opens the Appointments Page From the "View Appointments" Element
     * @return - The Appointments Page (KPAUIAppointmentsPage)
     */
    public KPAUIScheduleAppointmentPage openScheduleAppointmentsPage() {
        getScheduleAppointmentsLink().click();
        return new KPAUIScheduleAppointmentPage(driver);
    }

    /** Opens the Appointments Page From the "View Appointments" Element
     * @return - The Appointments Page (KPAUIAppointmentsPage)
     */
    public KPAUIScheduleAppointmentPage openScheduleAppointmentsPageWithNoApts() {
        getScheduleAppointmentWithNoAptsLink().click();
        return new KPAUIScheduleAppointmentPage(driver);
    }

    /** Verifies that the "Appointments" Header and Arrow are displayed
     * @return - True if both conditions are met
     */
    public boolean verifyAppointmentHeaderAndArrow() {
        return getAppointmentsArrow().isDisplayed() &&
                getAppointmentsHeader().getText().matches(header);
    }

    /** Verifies that the "No Messages" text matches the expected
     * @return - True if the message texts are equal
     */
    public boolean verifyNoUpcomingAppointmentsMessage() {
        return getNoAppointmentsMessage().getText().equals(noMessage);
    }

    /** Verifies that the "Schedule An Appointment" Link/Text are displayed
     * @return - True if both conditions are met
     */
    public boolean verifyScheduleAppointmentsLink() {
        return getScheduleAppointmentsIcon().isDisplayed() &&
                getScheduleAppointmentsLink().getText().equals(scheduleAppointment);
    }

    /** Verifies that the "Schedule An Appointment" Link/Text with no appointments are displayed
     * @return - True if both conditions are met
     */
    public boolean verifyScheduleAppointmentsWithNoAptsLink() {
        return getScheduleAppointmentWithNoAptsIcon().isDisplayed() &&
                getScheduleAppointmentWithNoAptsLink().getText().equals(scheduleAppointment);
    }


    /** Verifies that the "View An Appointment" Link/Text are displayed
     * @return - True if both conditions are met
     */
    public boolean verifyViewAppointmentsLink() {
        return getViewAppointmentsIcon().isDisplayed() &&
                getViewAppointmentsLink().getText().equals(viewAppointment);
    }

    /** Verifies that the "View Past Appointments" Link/Text are displayed
     * @return - True if both conditions are met
     */
    public boolean verifyViewPastAppointmentsLink() {
        return getViewPastAppointmentsIcon().isDisplayed() &&
                getViewPastAppointmentsLink().getText().equals(viewPastAppointment);
    }
}
