package org.ghc.tests.shades;

import org.ghc.pages.KPAUIUnAuthenticatedHomePage;
import org.ghc.shades.KPAUIGetCareShade;
import org.ghc.utils.extensions.KPAUIEveryTest;
import org.testng.annotations.*;

import java.lang.reflect.Method;

import static org.ghc.shades.KPAUIGetCareShade.*;
import static org.testng.Assert.*;

public class KPAUIUnauthenticatedGetCareShadeTests extends KPAUIEveryTest {
    private KPAUIUnAuthenticatedHomePage homePage;

    @BeforeMethod(alwaysRun = true)
    public void beforeTest(Method method) {
        homePage = super.initializeTest(method);
    }

    //------------------------------------------------------------------------------------------------------------------

    @Test(description = "UnAuthenticated Get Care Shade Links and Destination URLs", groups = {"qa", "prod"})
    public void validateUnAuthenticatedGetCareNowShadeLinksAndTexts() {
        KPAUIGetCareShade getCareShade = homePage.openGetCareShade();

        // Get Care Shade Header Tests
        assertEquals(getCareShade.getCareOptionsHeader().getText(), CARE_OPTIONS_SUBHEADER);
        assertEquals(getCareShade.getPharmacyHeader().getText(), PHARMACY_SUBHEADER);
        assertEquals(getCareShade.getCareServicesHeader().getText(), CARE_SERVICES_SUBHEADER);

        // Get Care Shade Links And Texts
        assertEquals(getCareShade.getFindCareNowLink().getText(),FIND_CARE_NOW);
        assertEquals(getCareShade.getPharmacyServicesLink().getText(), PHARMACY_SERVICES);
        assertEquals(getCareShade.getTransferPrescriptionsLink().getText(), TRANSFER_PRESCRIPTIONS);
        assertEquals(getCareShade.getMailOrderPharmacyLink().getText(), MAIL_ORDER_PHARMACY);
        assertEquals(getCareShade.getDrugFormularyLink().getText(), DRUG_FORMULARY);
        assertEquals(getCareShade.getFindADoctorLink().getText(), FIND_A_DOCTOR);
        assertEquals(getCareShade.getHealthCareServicesLink().getText(), HEALTH_CARE_SERVICES);
        assertEquals(getCareShade.getSpecialtyCareLink().getText(), SPECIALTY_CARE);
        assertEquals(getCareShade.getBehavioralHealthLink().getText(), BEHAVIORAL_HEALTH_SERVICES);
        assertEquals(getCareShade.getEyeCareLink().getText(), EYE_CARE);
        assertEquals(getCareShade.getLocationsLink().getText(), LOCATIONS);

        // Help Section
        assertTrue(getCareShade.getShadeHelpSection().isDisplayed());
        assertTrue(getCareShade.validateHelpSectionHeader());
        assertTrue(getCareShade.validateMemEmailLink());
        assertTrue(getCareShade.validateHelpSectionPhoneNumber());
    }

    @Test(description = "Validate UnAuthenticated Get Care Shade Page Destinations", groups = {"qa", "prod"})
    public void validateAllPagesInUnAuthenticatedGetCareShade() {
        homePage.openGetCareShade().openFindCareNow()
                .openGetCareShade()
                .openPharmacyServicesPage()
                .openGetCareShade()
                .openMailOrderServicesPage()
                .openGetCareShade()
                .openDrugFormularyPage()
                .openGetCareShade()
                .openFindADoctorPage()
                .openGetCareShade()
                .openSpecialtyCarePage()
                .openGetCareShade()
                .openHealthCareServicesPage()
                .openGetCareShade()
                .openBehavioralHealthServicesPage()
                .openGetCareShade()
                .openLocationsPage()
                .openGetCareShade()
                .openEmailMemberServicesPage()
                .openGetCareShade()
                .openUnauthenticatedTransferRxPage()
                .openUnAuthenticatedHomePage()
                .openGetCareShade()
                .openEyeCarePage();
    }
}
