package org.ghc.tests.shades;

import org.ghc.pages.KPAUIAuthenticatedHomePage;
import org.ghc.shades.KPAUIMedicationsShade;
import org.ghc.utils.extensions.KPAUIEveryTest;
import org.testng.annotations.*;

import java.lang.reflect.Method;

import static org.ghc.shades.KPAUIMedicationsShade.*;
import static org.testng.Assert.*;
import static org.ghc.utils.KPAUICredentials.accountName.*;

public class KPAUIMedicationsShadeTests extends KPAUIEveryTest {
    private KPAUIAuthenticatedHomePage homePage;

    @BeforeMethod(alwaysRun = true)
    public void beforeTest(Method method) {
        homePage = super.initializeTest(method)
                .signIn(EVERYTHING);
    }

    //------------------------------------------------------------------------------------------------------------------

    @Test(description = "Medications Shade Links and Destination URLs", groups = {"smoke", "qa", "prod"})
    public void validateMedicationsShadeLinksAndTexts() {
        KPAUIMedicationsShade medicationsShade = homePage.openMedicationsShade();

        // Medications Shade Header Tests
        assertEquals(medicationsShade.getPrescriptionsHeader().getText(), PRESCRIPTIONS_SUBHEADER);
        assertEquals(medicationsShade.getPharmacyHeader().getText(), PHARMACY_SUBHEADER);

        // Medications Shade Links And Texts
        assertEquals(medicationsShade.getMedicationsRefillOrderLink().getText(), MEDICATIONS_REFILL_STATUS);
        assertEquals(medicationsShade.getTransferPrescriptionsLink().getText(), TRANSFER_PRESCRIPTIONS);
        assertEquals(medicationsShade.getPharmacyServicesLink().getText(), PHARMACY_SERVICES);
        assertEquals(medicationsShade.getMailOrderPharmacyLink().getText(), MAIL_ORDER_PHARMACY);
        assertEquals(medicationsShade.getDrugFormularyLink().getText(), DRUG_FORMULARY);

        // Help Section
        assertTrue(medicationsShade.getShadeHelpSection().isDisplayed());
        assertTrue(medicationsShade.validateHelpSectionHeader());
        assertTrue(medicationsShade.validateMemEmailLink());
        assertTrue(medicationsShade.validateHelpSectionPhoneNumber());
    }

    @Test(description = "Validate Medications Shade Page Destinations", groups = {"qa", "prod"})
    public void validateAllPagesInMedicationsShade() {
        homePage.openMedicationsShade().openPharmacyServicesPage()
                .openHomePageFromHeader()
                .openMedicationsShade()
                .openMailOrderServicesPage()
                .openHomePageFromHeader()
                .openMedicationsShade()
                .openDrugFormularyPage()
                .openHomePageFromHeader()
                .openMedicationsShade()
                .openMedicationsPage()
                .openAuthenticatedHomePageFromMyChart()
                .openMedicationsShade()
                .openTransferRxYourInfoPage()
                .openHomePageFromHeader()
                .openMedicationsShade()
                .openEmailMemberServicesPage();
    }
}
