package org.ghc.tests.cards;

import org.ghc.cards.KPAUIAppointmentsCard;
import org.ghc.pages.KPAUIUnAuthenticatedHomePage;
import org.ghc.utils.extensions.KPAUIEveryTest;
import org.testng.annotations.*;

import java.lang.reflect.Method;

import static org.ghc.utils.KPAUICredentials.accountName.*;
import static org.testng.Assert.assertTrue;

public class KPAUIAppointmentsCardTests extends KPAUIEveryTest {
    private KPAUIUnAuthenticatedHomePage unAuthenticatedHomePage;

    @BeforeMethod(alwaysRun = true)
    public void beforeTest(Method method) {
        unAuthenticatedHomePage = super.initializeTest(method);
    }

    //--------------------------------------------------------------------------------------------------------------

    @Test(description = "Verify Links and Objects on an Account with an Appointment",  groups = {"smoke", "qa", "prod"})
    public void validateCardWithAppointments() {
        KPAUIAppointmentsCard appointmentsCard = unAuthenticatedHomePage
                .signIn(EVERYTHING)
                .getAppointmentsCard();

        // Tests for the Correct Appointment Information
        assertTrue(appointmentsCard.getAppointmentDateAndTime().isDisplayed());
        assertTrue(appointmentsCard.getClinicianNameAndTitle().isDisplayed());
        assertTrue(appointmentsCard.getPhoneNumber().isDisplayed());
        assertTrue(appointmentsCard.getAppointmentLocationLink().isDisplayed());
        assertTrue(appointmentsCard.getMapPin().isDisplayed());
        assertTrue(appointmentsCard.getAppointmentType().isDisplayed());

        // Tests to verify the Link Text and Icons
        assertTrue(appointmentsCard.verifyAppointmentHeaderAndArrow());
        assertTrue(appointmentsCard.verifyScheduleAppointmentsLink());
        assertTrue(appointmentsCard.verifyViewAppointmentsLink());

        // Tests to Follow the Links to ensure valid pages
        appointmentsCard.openScheduleAppointmentsPage()
                .openAuthenticatedHomePageFromMyChart()
                .getAppointmentsCard()
                .openViewAppointmentsPage()
                .openAuthenticatedHomePageFromMyChart()
                .getAppointmentsCard()
                .openAppointmentsPageFromHeader();
    }

    @Test(description = "Verify Links and Objects on an Account that doesn't have an Appointment",   groups = {"smoke", "qa", "prod"})
    public void validateNoAppointmentsCard() {
        KPAUIAppointmentsCard appointmentsCard = unAuthenticatedHomePage
                .signIn(NOTHING)
                .getAppointmentsCard();

        // Verify "No Appointments" Message and "Past Appointments" Links
        assertTrue(appointmentsCard.verifyNoUpcomingAppointmentsMessage());
        assertTrue(appointmentsCard.verifyViewPastAppointmentsLink());
        assertTrue(appointmentsCard.verifyScheduleAppointmentsWithNoAptsLink());

        // Verify's the functionality of the Past Appointment's Page
        appointmentsCard.openViewPastAppointmentsPage()
                .openAuthenticatedHomePageFromMyChart()
                .getAppointmentsCard()
                .openScheduleAppointmentsPageWithNoApts();
    }
}