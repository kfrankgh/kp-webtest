package org.ghc.tests.shades;

import org.ghc.pages.KPAUIAuthenticatedHomePage;
import org.ghc.shades.KPAUIMedicalRecordsShade;
import org.ghc.utils.extensions.KPAUIEveryTest;
import org.testng.annotations.*;

import java.lang.reflect.Method;

import static org.ghc.shades.KPAUIMedicalRecordsShade.*;
import static org.testng.Assert.*;
import static org.ghc.utils.KPAUICredentials.accountName.*;

public class KPAUIMedicalRecordsShadeTests extends KPAUIEveryTest {
    private KPAUIAuthenticatedHomePage homePage;

    @BeforeMethod(alwaysRun = true)
    public void beforeTest(Method method) {
        homePage = super.initializeTest(method)
                .signIn(EVERYTHING);
    }

    //------------------------------------------------------------------------------------------------------------------

    @Test(description = "Medical Records Shade Links and Destination URLs", groups = {"smoke", "qa", "prod"})
    public void validateMedicalRecordsShadeLinksAndTexts() {
        KPAUIMedicalRecordsShade medicalRecordsShade = homePage.openMedicalRecordsShade();

        // Medical Records Shade Header tests
        assertEquals(medicalRecordsShade.getMyHealthInformationHeader().getText(), YOUR_HELATH_SUBHEADER);
        assertEquals(medicalRecordsShade.getSettingsHeader().getText(),SETTINGS_SUBHEADER);

        // Medical Records Shade Links And Texts
        assertEquals(medicalRecordsShade.getAllergiesLink().getText(), ALLERGIES);
        assertEquals(medicalRecordsShade.getBloodPressureWeightLink().getText(), BLOOD_PRESSURE_AND_WEIGHT);
        assertEquals(medicalRecordsShade.getLabAndTestResultsLink().getText(),LABS_AND_TEST_RESULTS);
        assertEquals(medicalRecordsShade.getRoutineCareRemindersLink().getText(), ROUTINE_CARE_REMINDERS);
        assertEquals(medicalRecordsShade.getImmunizationsLink().getText(), IMMUNIZATIONS);
        assertEquals(medicalRecordsShade.getHealthConditionsLink().getText(), HEALTH_CONDITIONS);
        assertEquals(medicalRecordsShade.getLettersVisionPrescriptionsLink().getText(), LETTERS_VISION_PRESCRIPTIONS);
        assertEquals(medicalRecordsShade.getGrowthCartLink().getText(), GROWTH_CHART);
        assertEquals(medicalRecordsShade.getAccountPreferencesLink().getText(), ACCOUNT_AND_PREFERENCES);
        assertEquals(medicalRecordsShade.getPersonalizeLink().getText(), PERSONALIZE);
        assertEquals(medicalRecordsShade.getAccountAuditLink().getText(), ACCOUNT_AUDIT);
        assertEquals(medicalRecordsShade.getDownloadMyRecordLink().getText(), DOWNLOAD_MY_RECORD);
        assertEquals(medicalRecordsShade.getAccessToChildsRecordLink().getText(), ACCESS_CHILDS_MEDICAL_RECORD);

        // Help Section
        assertTrue(medicalRecordsShade.getShadeHelpSection().isDisplayed());
        assertTrue(medicalRecordsShade.validateHelpSectionHeader());
        assertTrue(medicalRecordsShade.validateMemEmailLink());
        assertTrue(medicalRecordsShade.validateHelpSectionPhoneNumber());
    }

    @Test(description = "Validate Medical Records Shade Page Destinations", groups = {"qa", "prod"})
    public void validateAllPagesInMedicalRecordsShade() {
        homePage.openMedicalRecordsShade().openAllergiesPage()
                .openAuthenticatedHomePageFromMyChart()
                .openMedicalRecordsShade()
                .openBloodPressureAndWeighPage()
                .openAuthenticatedHomePageFromMyChart()
                .openMedicalRecordsShade()
                .openHealthConditionsPage()
                .openAuthenticatedHomePageFromMyChart()
                .openMedicalRecordsShade()
                .openLettersAndVisionPrescriptionsPage()
                .openAuthenticatedHomePageFromMyChart()
                .openMedicalRecordsShade()
                .openGrowthChartPage()
                .openAuthenticatedHomePageFromMyChart()
                .openMedicalRecordsShade()
                .openAccountAndPreferencesPage()
                .openHomePageFromHeader()
                .openMedicalRecordsShade()
                .openPersonalizePage()
                .openAuthenticatedHomePageFromMyChart()
                .openMedicalRecordsShade()
                .openAccountAuditPage()
                .openAuthenticatedHomePageFromMyChart()
                .openMedicalRecordsShade()
                .openDownloadMyRecordPage()
                .openAuthenticatedHomePageFromMyChart()
                .openMedicalRecordsShade()
                .openAccessYourChildsMedicalRecordPage()
                .openHomePageFromHeader()
                .openMedicalRecordsShade()
                .openRoutineCareRemindersPage()
                .openAuthenticatedHomePageFromMyChart()
                .openMedicalRecordsShade()
                .openLabsAndTestResultsPage()
                .openAuthenticatedHomePageFromMyChart()
                .openMedicalRecordsShade()
                .openImmunizationsPage();
    }
}