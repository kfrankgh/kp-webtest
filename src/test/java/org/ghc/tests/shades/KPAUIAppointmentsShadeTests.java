package org.ghc.tests.shades;

import org.ghc.pages.KPAUIAuthenticatedHomePage;
import org.ghc.shades.KPAUIAppointmentsShade;
import org.ghc.utils.extensions.KPAUIEveryTest;
import org.testng.annotations.*;

import java.lang.reflect.Method;

import static org.ghc.shades.KPAUIAppointmentsShade.*;
import static org.testng.Assert.*;
import static org.ghc.utils.KPAUICredentials.accountName.*;

public class KPAUIAppointmentsShadeTests extends KPAUIEveryTest {
    private KPAUIAuthenticatedHomePage homePage;

    @BeforeMethod(alwaysRun = true)
    public void beforeTest(Method method) {
        homePage = super.initializeTest(method)
                .signIn(EVERYTHING);
    }

    //------------------------------------------------------------------------------------------------------------------

    @Test(description = "Appointments Shade Links and Destination URLs", groups = {"smoke", "qa", "prod"})
    public void validateAppointmentsShadeLinksAndTexts() {
        KPAUIAppointmentsShade appointmentsShade = homePage.openAppointmentsShade();

        // Header
        assertEquals(appointmentsShade.getMyVisitsSubHeader().getText(), MY_VISITS_SUBHEADER);

        // Appointments Shade Link Texts
        assertEquals(appointmentsShade.getStartAnOnlineVisitLink().getText(), START_AN_ONLINE_VISIT);
        assertEquals(appointmentsShade.getAppointmentsLink().getText(), APPOINTMENTS_AND_VISITS);
        assertEquals(appointmentsShade.getScheduleAppointmentsLink().getText(), SCHEDULING_APPOINTMENTS);
        assertEquals(appointmentsShade.getSchedulingTicketsLink().getText(), SCHEDULING_TICKETS);

        // Help Section
        assertTrue(appointmentsShade.getShadeHelpSection().isDisplayed());
        assertTrue(appointmentsShade.validateHelpSectionHeader());
        assertTrue(appointmentsShade.validateMemEmailLink());
        assertTrue(appointmentsShade.validateHelpSectionPhoneNumber());
    }

    @Test(description = "Validate Appointments Shade Page Destinations", groups = {"qa", "prod"})
    public void validateAllPagesInAppointmentsShade() {
        homePage.openAppointmentsShade().openStartOnlineVisitPage()
                .openAuthenticatedHomePageFromMyChart()
                .openAppointmentsShade()
                .openAppointmentsPage()
                .openAuthenticatedHomePageFromMyChart()
                .openAppointmentsShade()
                .openScheduleAppointmentsPage()
                .openAuthenticatedHomePageFromMyChart()
                .openAppointmentsShade()
                .openSchedulingTicketsPage()
                .openAuthenticatedHomePageFromMyChart()
                .openAppointmentsShade()
                .openEmailMemberServicesPage();
    }
}
