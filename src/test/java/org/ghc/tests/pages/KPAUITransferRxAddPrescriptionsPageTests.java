package org.ghc.tests.pages;

import org.ghc.pages.KPAUITransferRxAddPrescriptionsPage;
import org.ghc.utils.extensions.KPAUIEveryTest;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;


import java.lang.reflect.Method;

import static org.ghc.utils.KPAUICredentials.accountName.EVERYTHING;
import static org.ghc.utils.KPAUIPageConstants.FormLabels.*;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class KPAUITransferRxAddPrescriptionsPageTests extends KPAUIEveryTest {
    private KPAUITransferRxAddPrescriptionsPage kpauiTransferRxAddPrescriptionsPage;

    @BeforeMethod(alwaysRun = true)
    public void beforeTest(Method method) {
        kpauiTransferRxAddPrescriptionsPage = super.initializeTest(method)
                .openSignOnShade()
                .signIn(EVERYTHING)
                .openMedicationsShade()
                .openTransferRxYourInfoPage()
                .completeStep1YesPerms();
    }

    // ------------------------------------------------------------------------------------------------------------------

    @Test(description = "Verify Transfer Rx Add Prescriptions Form, Expected Labels And Nav Elements Are Displayed", groups = {"smoke", "qa", "prod"})
    public void verifyTransferRxAddPrescriptionsLabelsAreDisplayed() {

        // Expected Nav Elements
        assertTrue(kpauiTransferRxAddPrescriptionsPage.getMedicationSupplyDropDown().isDisplayed(),
                "Medication Supply Drop Down Not Displayed");
        assertTrue(kpauiTransferRxAddPrescriptionsPage.getStep2CancelButton().isDisplayed(),
                "Cancel Button Not Displayed");
        assertTrue(kpauiTransferRxAddPrescriptionsPage.getStep2SubmitButton().isDisplayed(),
                "Submit Button Not Displayed");

        assertEquals(kpauiTransferRxAddPrescriptionsPage.getStep2CancelButtonLabel().getText().toLowerCase(),
                CANCEL_BUTTON_EXPECTED_STRING.toLowerCase(),
                "Cancel Button Not Labeled with Expected String ");
        assertEquals(kpauiTransferRxAddPrescriptionsPage.getStep2SubmitButtonLabel().getText().toLowerCase(),
                NEXT_BUTTON_LABEL_EXPECTED_STRING.toLowerCase(),
                "Submit Button Not Labeled with Expected String ");

        // Expected Labels
        assertTrue(kpauiTransferRxAddPrescriptionsPage.getCurrentPharmacyFormLabel().isDisplayed(),
                "Current Pharmacy Form Label is Not Displayed");
        assertTrue(kpauiTransferRxAddPrescriptionsPage.getPharmacyPhoneNumberFormLabel().isDisplayed(),
                "Current Pharmacy Phone Number Label is Not Displayed");
        assertTrue(kpauiTransferRxAddPrescriptionsPage.getPharmacyPhoneExtensionFormLabel().isDisplayed(),
                "Current Pharmacy Phone Extension Form Label is Not Displayed");
        assertTrue(kpauiTransferRxAddPrescriptionsPage.getMedicationNameFormLabel().isDisplayed(),
                "Medication Name Form Label is Not Displayed");
        assertTrue(kpauiTransferRxAddPrescriptionsPage.getMedicationNumberFormLabel().isDisplayed(),
                "Medication Number Form Label is Not Displayed");
        assertTrue(kpauiTransferRxAddPrescriptionsPage.getMedicationStrengthFormLabel().isDisplayed(),
                "Medication Strength Form Label is Not Displayed");
        assertTrue(kpauiTransferRxAddPrescriptionsPage.getMedicationSupplyDropDownLabel().isDisplayed(),
                "Medication Supply Drop Down Label is Not Displayed");
        assertTrue(kpauiTransferRxAddPrescriptionsPage.getDoctorNameFormLabel().isDisplayed(),
                "Medication Supply Doctor Name Label is Not Displayed");
        assertTrue(kpauiTransferRxAddPrescriptionsPage.getDoctorPhoneNumberFormLabel().isDisplayed(),
                "Medication Supply Doctor Phone Number Label is Not Displayed");
        assertTrue(kpauiTransferRxAddPrescriptionsPage.getDoctorPhoneExtensionFormLabel().isDisplayed(),
                "Medication Supply Doctor Phone Extension Label is Not Displayed");
    }

    @Test(description = "Validate Transfer Rx Add Prescriptions Form Labels Are Expected Strings", groups = {"qa", "prod"})
    public void validateTransferRxAddPrescriptionsFormLabels() {
        assertEquals(kpauiTransferRxAddPrescriptionsPage.getCurrentPharmacyFormLabel().getText(), CURRENT_PHARMACY_LABEL_EXPECTED_STRING,
                "Current Pharmacy Form Label Not The Expected String");
        assertEquals(kpauiTransferRxAddPrescriptionsPage.getPharmacyPhoneNumberFormLabel().getText(), PHARMACY_PHONE_LABEL_EXPECTED_STRING,
                "Current Pharmacy Phone Number Form Label Not The Expected String");
        assertEquals(kpauiTransferRxAddPrescriptionsPage.getPharmacyPhoneExtensionFormLabel().getText(), PHONE_EXT_FORM_LABEL_EXPECTED_STRING,
                "Current Pharmacy Phone Extension Form Label Not The Expected String");
        assertEquals(kpauiTransferRxAddPrescriptionsPage.getMedicationNameFormLabel().getText(), MEDICATION_NAME_LABEL_EXPECTED_STRING,
                "Medication Name Form Label Not The Expected String");
        assertEquals(kpauiTransferRxAddPrescriptionsPage.getMedicationNumberFormLabel().getText(), MEDICATION_NUMBER_LABEL_EXPECTED_STRING,
                "Medication Number Form Label Not The Expected String");
        assertEquals(kpauiTransferRxAddPrescriptionsPage.getMedicationStrengthFormLabel().getText(), MEDICATION_STRENGTH_LABEL_EXPECTED_STRING,
                "Medication Strength Form Label Not The Expected String");
        assertEquals(kpauiTransferRxAddPrescriptionsPage.getMedicationSupplyDropDownLabel().getText(), MEDICATION_SUPPLY_LABEL_EXPECTED_STRING,
                "Medication Supply Drop-down Label Not The Expected String");
        assertEquals(kpauiTransferRxAddPrescriptionsPage.getDoctorNameFormLabel().getText(), DOCTOR_NAME_LABEL_EXPECTED_STRING,
                "Doctor Name Form Label Not The Expected String");
        assertEquals(kpauiTransferRxAddPrescriptionsPage.getDoctorPhoneNumberFormLabel().getText(), DOCTOR_PHONE_LABEL_EXPECTED_STRING,
                "Doctor Phone Number Form Label Not The Expected String");
        assertEquals(kpauiTransferRxAddPrescriptionsPage.getDoctorPhoneExtensionFormLabel().getText(), PHONE_EXT_FORM_LABEL_EXPECTED_STRING,
                "Doctor Phone Extension Form Label Not The Expected String");
    }

    @Test(description = "Verify Transfer Rx Add Prescriptions Expected Forms Are Displayed With Required Asterisks", groups = {"smoke", "qa", "prod"})
    public void verifyTransferRxAddPrescriptionsFormsAreDisplayed() {
        // Required Forms Have Designated Asterisks
        assertTrue(kpauiTransferRxAddPrescriptionsPage.getCurrentPharmacyFormStar().isDisplayed(),
                "Current Pharmacy Not Indicated As Required Field");
        assertTrue(kpauiTransferRxAddPrescriptionsPage.getPharmacyPhoneNumberFormStar().isDisplayed(),
                "Current Pharmacy Phone Number Not Indicated As Required Field");
        assertTrue(kpauiTransferRxAddPrescriptionsPage.getMedicationNameFormStar().isDisplayed(),
                "Medication Name Not Indicated As Required Field");
        assertTrue(kpauiTransferRxAddPrescriptionsPage.getMedicationNumberFormStar().isDisplayed(),
                "Medication Number Not Indicated As Required Field");
        assertTrue(kpauiTransferRxAddPrescriptionsPage.getMedicationSupplyDropDownStar().isDisplayed(),
                "Medication Supply Drop Down Selection Not Indicated As Required");
        assertTrue(kpauiTransferRxAddPrescriptionsPage.getDoctorNameFormStar().isDisplayed(),
                "Prescribing Doctor Name Not Indicated As Required Field");

        // Transfer Prescription Form Objects
        assertTrue(kpauiTransferRxAddPrescriptionsPage.getCurrentPharmacyForm().isDisplayed(),
                "Current Pharmacy Form Not Displayed");
        assertTrue(kpauiTransferRxAddPrescriptionsPage.getPharmacyPhoneNumberForm().isDisplayed(),
                "Current Pharmacy Phone Number Form Not Displayed");
        assertTrue(kpauiTransferRxAddPrescriptionsPage.getPharmacyPhoneExtensionForm().isDisplayed(),
                "Current Pharmacy Phone Extension Form Not Displayed");
        assertTrue(kpauiTransferRxAddPrescriptionsPage.getMedicationNameForm().isDisplayed(),
                "Medication Name Form Not Displayed");
        assertTrue(kpauiTransferRxAddPrescriptionsPage.getMedicationNumberForm().isDisplayed(),
                "Medication Number Form Not Displayed");
        assertTrue(kpauiTransferRxAddPrescriptionsPage.getMedicationStrengthForm().isDisplayed(),
                "Medication Strength Form Not Displayed");
        assertTrue(kpauiTransferRxAddPrescriptionsPage.getMedicationSupplyDropDown().isDisplayed(),
                "Medication Supply Drop Down Not Displayed");
        assertTrue(kpauiTransferRxAddPrescriptionsPage.getDoctorNameForm().isDisplayed(),
                "Doctor Name Form Not Displayed");
        assertTrue(kpauiTransferRxAddPrescriptionsPage.getDoctorPhoneNumberForm().isDisplayed(),
                "Doctor Phone Number Form Not Displayed");
        assertTrue(kpauiTransferRxAddPrescriptionsPage.getDoctorPhoneExtensionForm().isDisplayed(),
                "Doctor Phone Extension Form Not Displayed");
    }

    @Test(description = "Verify Required Field Warning is Displayed If Forms Are Empty When Clicking 'Next' Button", groups = {"qa", "prod"})
    public void verifyRequiredFormWarnings() {
        KPAUITransferRxAddPrescriptionsPage transferRxWarningsDisplayedPage = kpauiTransferRxAddPrescriptionsPage
                .clickStep2SubmitButtonForErrors();

        WebElement missingPharmacyPhoneWarning = transferRxWarningsDisplayedPage.getMissingPharmacyPhoneIndication();
        assertTrue(missingPharmacyPhoneWarning.isDisplayed(),
                "Missing Current Warning Was Not Displayed");

        WebElement missingCurrentPharmacyWarning = transferRxWarningsDisplayedPage.getMissingCurrentPharmacyIndication();
        assertTrue(missingCurrentPharmacyWarning.isDisplayed(),
                "Missing First Name Warning Was Not Displayed");

        WebElement missingMedicationNameWarning = transferRxWarningsDisplayedPage.getMissingMedicationNameIndication();
        assertTrue(missingMedicationNameWarning.isDisplayed(),
                "Missing Medication Name Warning Was Not Displayed");

        WebElement missingMedicationNumberWarning = transferRxWarningsDisplayedPage.getMissingMedNumberIndication();
        assertTrue(missingMedicationNumberWarning.isDisplayed(),
                "Missing Medication Number Warning Was Not Displayed");

        WebElement missingMedicationSupplyWarning = transferRxWarningsDisplayedPage.getMissingMedicationSupplyIndication();
        assertTrue(missingMedicationSupplyWarning.isDisplayed(),
                "Missing Medication Supply Selection Warning Was Not Displayed");

        WebElement missingDoctorNameWarning = transferRxWarningsDisplayedPage.getMissingDoctorNameIndication();
        assertTrue(missingDoctorNameWarning.isDisplayed(),
                "Missing Doctor Name Warning Was Not Displayed");
    }

    @Test(description = "Validate The Expected Placeholder Text Expected String", groups = {"qa", "prod"})
    public void validatePlaceHolderText() {
        assertEquals(kpauiTransferRxAddPrescriptionsPage.getCurrentPharmacyForm().getAttribute("placeholder"),
                CURRENT_PHARMACY_FORM_PLACEHOLDER,
                "Current Pharmacy Placeholder Text Not Displayed");

        assertEquals(kpauiTransferRxAddPrescriptionsPage.getPharmacyPhoneNumberForm().getAttribute("placeholder"),
                PHARMACY_PHONE_FORM_PLACEHOLDER,
                "Pharmacy Phone Placeholder Text Not Displayed");

        assertEquals(kpauiTransferRxAddPrescriptionsPage.getMedicationNameForm().getAttribute("placeholder"),
                MEDICATION_NAME_FORM_PLACEHOLDER,
                "Medication Name Placeholder Text Not Displayed");

        assertEquals(kpauiTransferRxAddPrescriptionsPage.getMedicationNumberForm().getAttribute("placeholder"),
                MEDICATION_NUMBER_FORM_PLACEHOLDER,
                "Medication Name Placeholder Text Not Displayed");

        assertEquals( kpauiTransferRxAddPrescriptionsPage.getMedicationStrengthForm().getAttribute("placeholder"),
                MEDICATION_STRENGTH_FORM_PLACEHOLDER,
                "Medication Strength Placeholder Text Not Displayed");

        assertEquals(kpauiTransferRxAddPrescriptionsPage.getDoctorNameForm().getAttribute("placeholder"),
                DOCTOR_NAME_FORM_PLACEHOLDER,
                "Doctor Name Placeholder Not Expected String");
    }
}
