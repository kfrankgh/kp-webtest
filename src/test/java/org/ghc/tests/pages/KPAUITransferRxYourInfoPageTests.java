package org.ghc.tests.pages;

import org.ghc.pages.KPAUITransferRxYourInfoPage;
import org.ghc.utils.KPAUICredentials;
import org.ghc.utils.extensions.KPAUIEveryTest;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.Date;
import java.util.List;

import static org.ghc.utils.KPAUICredentials.accountName.EVERYTHING;
import static org.ghc.utils.KPAUIPageConstants.ExpectedLinksAndHeaders.TransferPrescriptions.*;
import static org.ghc.utils.KPAUIPageConstants.FormLabels.*;
import static org.ghc.utils.KPAUIPageConstants.FormWarnings.*;
import static org.ghc.utils.KPAUIPageConstants.TRANSFER_RX_MEMBER_ID_HELP_LINK;
import static org.ghc.utils.helpers.KPAUITestHelper.isValidLink;
import static org.testng.Assert.*;

public class KPAUITransferRxYourInfoPageTests extends KPAUIEveryTest {
    private KPAUITransferRxYourInfoPage kpauiTransferPrescriptionYourInfoPage;

    @BeforeMethod(alwaysRun = true)
    public void beforeTest(Method method) {
        kpauiTransferPrescriptionYourInfoPage = super.initializeTest(method)
                .openSignOnShade()
                .signIn(EVERYTHING)
                .openMedicationsShade()
                .openTransferRxYourInfoPage();
    }

    // ------------------------------------------------------------------------------------------------------------------

    @Test(description = "Validate Short Strings Not Allowed in Forms", groups = {"qa", "prod"})
    public void validateShortStringsNotAllowedInForms() {
        KPAUITransferRxYourInfoPage warningYourInfoPage = kpauiTransferPrescriptionYourInfoPage
                .clearAllStep1Forms()
                .insertShortFirstName()
                .insertShortLastName()
                .insertShortDOB()
                .clickNextStepButtonExpectingError();

        assertEquals(warningYourInfoPage.getFirstNameFormWarn().getText(), SHORT_STRING_WARNING,
                "First Name Warning Not Displayed, or Unexpected Warning Displayed For Short String");
        assertEquals(warningYourInfoPage.getLastNameFormWarn().getText(), SHORT_STRING_WARNING,
                "Last Name Warning Not Displayed, or Unexpected Warning Displayed For Short String");
        assertEquals(warningYourInfoPage.getMemberIDFormWarn().getText(), SHORT_STRING_WARNING,
                "Member ID Warning Not Displayed, or Unexpected Warning Displayed For Short String");
        assertEquals(warningYourInfoPage.getDateOfBirthFormWarn().getText(), SHORT_STRING_WARNING,
                "Date of Birth Warning Not Displayed, or Unexpected Warning Displayed For Short String");
        assertEquals(warningYourInfoPage.getPhoneNumberFormWarn().getText(), SHORT_STRING_WARNING,
                "Phone Number Warning Not Displayed, or Unexpected Warning Displayed For Short String");
    }

    @Test(description = "Validate Long Strings Not Allowed in Forms", groups = {"qa", "prod"})
    public void validateLongStringsNotAllowedInForms() {
        KPAUITransferRxYourInfoPage warningYourInfoPage = kpauiTransferPrescriptionYourInfoPage
                .clearAllStep1Forms()
                .insertLongMemberID()
                .insertLongPhoneExt()
                .clickNextStepButtonExpectingError();

        assertEquals(warningYourInfoPage.getMemberIDFormWarn().getText(), LONG_STRING_WARNING,
                "Member ID Warning Not Displayed, or Unexpected Warning Displayed For Long String");
        assertEquals(warningYourInfoPage.getPhoneExtensionFormWarn().getText(), LONG_STRING_WARNING,
                "Phone Extension Warning Not Displayed, or Unexpected Warning Displayed For Long String");
    }

    @Test(description = "Validate Unexpected Characters and Patterns Not Allowed in Forms", groups = {"qa", "prod"})
    public void validateSpecialCharsNotAllowedInForms() {
        KPAUITransferRxYourInfoPage clearedYourInfoFormsPage = kpauiTransferPrescriptionYourInfoPage
                .clearAllStep1Forms()
                .insertUnexpectedCharFirstName()
                .insertUnexpectedCharLastName()
                .insertUnexpectedDOB()
                .insertUnexpectedCharMemberID()
                .insertUnexpectedCharPhoneExt()
                .clickNextStepButtonExpectingError();

        assertEquals(clearedYourInfoFormsPage.getFirstNameFormWarn().getText(), INVALID_CHARS_IN_STRING,
                "Incorrect First Name Pattern Warning Not Displayed When Clicking Next With Bad First Name String");
        assertEquals(clearedYourInfoFormsPage.getLastNameFormWarn().getText(), INVALID_CHARS_IN_STRING,
                "Incorrect Last Name Pattern Warning Not Displayed When Clicking Next With Bad Last Name String");
        assertEquals(clearedYourInfoFormsPage.getDateOfBirthFormWarn().getText(), INVALID_CHARS_IN_STRING,
                "Incorrect Date of Birth Pattern Warning Not Displayed When Clicking Next With Bad Date of Birth String");
        assertEquals(clearedYourInfoFormsPage.getMemberIDFormWarn().getText(), INVALID_CHARS_IN_STRING,
                "Incorrect Member ID Pattern Warning Not Displayed When Clicking Next With Bad Member ID String");
        assertEquals(clearedYourInfoFormsPage.getPhoneExtensionFormWarn().getText(), INVALID_CHARS_IN_STRING,
                "Incorrect Phone Extension Pattern Warning Not Displayed When Clicking Next With Bad Ext String");
    }


    @Test(description = "Verify Transfer Rx Your Info Page, Expected Nav Elements Are Displayed", groups = {"smoke", "qa", "prod"})
    public void verifyTransferRxYourInfoElementsAreDisplayed() {

        assertTrue(kpauiTransferPrescriptionYourInfoPage.getPrescriptionTransferRequestHeader().isDisplayed(),
                "Prescription Transfer Request Header Not Displayed");
        assertTrue(kpauiTransferPrescriptionYourInfoPage.getRxLearnMoreSubHeader().isDisplayed(),
                "Learn More SubHearer Not Displayed");
        assertTrue(kpauiTransferPrescriptionYourInfoPage.getRxLearnMoreBody().isDisplayed(),
                "Learn More Body is Not Displayed");
        assertTrue(kpauiTransferPrescriptionYourInfoPage.getProgressNavList().isDisplayed(),
                "Progress Nav List Is Not Displayed");
        assertTrue(kpauiTransferPrescriptionYourInfoPage.getMemberIDHelpLink().isDisplayed(),
                "Member ID Help Link Was Not Displayed");
        assertTrue(kpauiTransferPrescriptionYourInfoPage.getClearFormButton().isDisplayed(),
                "Clear Form Button Is Not Displayed");
        assertTrue(kpauiTransferPrescriptionYourInfoPage.getNextStepButton().isDisplayed(),
                "Next Step Button Is Not Displayed");
        assertTrue(kpauiTransferPrescriptionYourInfoPage.getMessagePermsLabel().isDisplayed(),
                "Message Permissions Header Was Not Displayed");
        assertTrue(kpauiTransferPrescriptionYourInfoPage.getYesRadioButtonInput().isDisplayed(),
                "'Yes' Message Permissions Radio Buttons Was Not Displayed");
        assertTrue(kpauiTransferPrescriptionYourInfoPage.getNoRadioButtonInput().isDisplayed(),
                "'No' Message Permissions Radio Buttons Was Not Displayed");
    }

    @Test(description = "Validate Transfer Rx Your Info Form Labels Are Expected Strings", groups = {"qa", "prod"})
    public void validateTransferRxYourInfoFormLabelStrings() {
        // Expected Forms Are Displayed
        assertTrue(kpauiTransferPrescriptionYourInfoPage.getFirstNameForm().isDisplayed(),
                "First Name Form Is Not Displayed");
        assertTrue(kpauiTransferPrescriptionYourInfoPage.getLastNameForm().isDisplayed(),
                "Last Name Form Is Not Displayed");
        assertTrue(kpauiTransferPrescriptionYourInfoPage.getMemberIDForm().isDisplayed(),
                "Member ID Form Is Not Displayed");
        assertTrue(kpauiTransferPrescriptionYourInfoPage.getDateOfBirthForm().isDisplayed(),
                "Date Of Birth Form Is Not Displayed");
        assertTrue(kpauiTransferPrescriptionYourInfoPage.getPhoneNumberForm().isDisplayed(),
                "Phone Number Form Is Not Displayed");
        assertTrue(kpauiTransferPrescriptionYourInfoPage.getPhoneExtensionForm().isDisplayed(),
                "Phone Number Extension Form Is Not Displayed");

        // Expected Labels Are Displayed
        assertTrue(kpauiTransferPrescriptionYourInfoPage.getFirstNameFormLabel().isDisplayed(),
                "First Name Form Label Is Not Displayed");
        assertTrue(kpauiTransferPrescriptionYourInfoPage.getLastNameFormLabel().isDisplayed(),
                "First Name Form Label Is Not Displayed");
        assertTrue(kpauiTransferPrescriptionYourInfoPage.getMemberIDFormLabel().isDisplayed(),
                "Member Id Form Label Is Not Displayed");
        assertTrue(kpauiTransferPrescriptionYourInfoPage.getDateOfBirthFormLabel().isDisplayed(),
                "Date Of Birth Form Label Is Not Displayed");
        assertTrue(kpauiTransferPrescriptionYourInfoPage.getPhoneNumberFormLabel().isDisplayed(),
                "Phone Number Form Label Is Not Displayed");
        assertTrue(kpauiTransferPrescriptionYourInfoPage.getPhoneExtensionFormLabel().isDisplayed(),
                "Phone Extension Form Label Is Not Displayed");

        // Form Labels Are Expected Strings
        assertEquals(kpauiTransferPrescriptionYourInfoPage.getFirstNameFormLabel().getText().toLowerCase(),
                FIRST_NAME_FORM_LABEL_EXPECTED_STRING.toLowerCase(),
                "First Name Form Label is Not Expected String");
        assertEquals(kpauiTransferPrescriptionYourInfoPage.getLastNameFormLabel().getText().toLowerCase(),
                LAST_NAME_FORM_LABEL_EXPECTED_STRING.toLowerCase(),
                "Last Name Form Label is Not Expected String");
        assertEquals(kpauiTransferPrescriptionYourInfoPage.getMemberIDFormLabel().getText().toLowerCase(),
                MEMBER_ID_FORM_LABEL_EXPECTED_STRING.toLowerCase(),
                "Member ID Form Label is Not Expected String");
        assertEquals(kpauiTransferPrescriptionYourInfoPage.getDateOfBirthFormLabel().getText().toLowerCase(),
                DATE_OF_BIRTH_FORM_LABEL_EXPECTED_STRING.toLowerCase(),
                "Date of Birth Form Label is Not Expected String");
        assertEquals(kpauiTransferPrescriptionYourInfoPage.getPhoneNumberFormLabel().getText().toLowerCase(),
                PHONE_NUMBER_FORM_LABEL_EXPECTED_STRING.toLowerCase(),
                "Phone Number Form Label is Not Expected String");
        assertEquals(kpauiTransferPrescriptionYourInfoPage.getPhoneExtensionFormLabel().getText().toLowerCase(),
                PHONE_EXT_FORM_LABEL_EXPECTED_STRING.toLowerCase(),
                "Phone Extension Form Label is Not Expected String");
        assertEquals(kpauiTransferPrescriptionYourInfoPage.getMessagePermsLabel().getText().toLowerCase(),
                PERMISSION_BUTTONS_LABEL_EXPECTED_STRING.toLowerCase(),
                "Message Permissions Label is Not Expected String");

        // Required fields and Asterisk Testing
        assertTrue(kpauiTransferPrescriptionYourInfoPage.getFirstNameFormStar().isDisplayed(),
                "First Name Required Asterisk is Not Displayed");
        assertTrue(kpauiTransferPrescriptionYourInfoPage.getLastNameFormStar().isDisplayed(),
                "Last Name Required Asterisk is Not Displayed");
        assertTrue(kpauiTransferPrescriptionYourInfoPage.getMemberIDFormStar().isDisplayed(),
                "Member ID Required Asterisk is Not Displayed");
        assertTrue(kpauiTransferPrescriptionYourInfoPage.getDateOfBirthFormStar().isDisplayed(),
                "Date of Birth Required Asterisk is Not Displayed");
        assertTrue(kpauiTransferPrescriptionYourInfoPage.getPhoneNumberFormStar().isDisplayed(),
                "Phone Number Required Asterisk is Not Displayed");
        assertTrue(kpauiTransferPrescriptionYourInfoPage.getMessagePermsStar().isDisplayed(),
                "Message Permissions Required Asterisk is Not Displayed");
    }

    @Test(description = "Validate Expected Strings for Nav Elements", groups = {"qa", "prod"})
    public void validateNavElementsExpectedStringsAndHelpIDShade() {
        assertEquals(kpauiTransferPrescriptionYourInfoPage.getPrescriptionTransferRequestHeader().getText().toLowerCase(),
                TRANSFER_PRESCRIPTION_PAGE_HEADER_EXPECTED_STRING.toLowerCase(),
                "Transfer Prescription Header is not using Expected String");
        assertEquals(kpauiTransferPrescriptionYourInfoPage.getRxLearnMoreSubHeader().getText().toLowerCase(),
                TRANSFER_PRESCRIPTION_PAGE_SUBHEADER_EXPECTED_STRING.toLowerCase(),
                "Transfer Prescription Sub-Header is not using Expected String");
        assertEquals(kpauiTransferPrescriptionYourInfoPage.getRxLearnMoreBody().getText().toLowerCase(),
                TRANSFER_PRESCRIPTION_PAGE_BODY_EXPECTED_STRING.toLowerCase(),
                "Transfer Prescription Learn More Body is not using Expected String");
        assertEquals(kpauiTransferPrescriptionYourInfoPage.getYesRadioButtonLabel().toLowerCase(),
                MESSAGE_PERMS_YES_LABEL_EXPECTED_STRING.toLowerCase(),
                "Transfer Prescription Radio Button Label Expected 'YES'");
        assertEquals(kpauiTransferPrescriptionYourInfoPage.getNoRadioButtonLabel().toLowerCase(),
                MESSAGE_PERMS_NO_LABEL_EXPECTED_STRING.toLowerCase(),
                "Transfer Prescription Radio Button Label Expected 'NO'");
        assertEquals(kpauiTransferPrescriptionYourInfoPage.getClearFormButtonLabel().getText().toLowerCase(),
                CLEAR_FORM_LABEL_EXPECTED_STRING.toLowerCase(),
                "Transfer Prescription Clear Form Button Label Expected 'Clear Form'");
        assertEquals(kpauiTransferPrescriptionYourInfoPage.getNextStepButtonLabel().getText().toLowerCase(),
                NEXT_BUTTON_LABEL_EXPECTED_STRING.toLowerCase(),
                "Transfer Prescription Next Step Button Label Expected 'Next'");

        WebElement memberIDHelpLink = kpauiTransferPrescriptionYourInfoPage.getMemberIDHelpLink();
        assertTrue(isValidLink(memberIDHelpLink, TRANSFER_RX_MEMBER_ID_HELP_LINK));

        kpauiTransferPrescriptionYourInfoPage.openMemberIDNumberHelpShade();
    }

    @Test(description = "Validate Pre-Populated Member Data in Forms", groups = {"qa"})
    public void validatePrePopulatedFormData() {
        KPAUICredentials.KPAUIAccount expectedMemberCredentials = EVERYTHING.getMemberInfo();

        String expectedFirstName = expectedMemberCredentials.getFirst();
        String populatedFirstName = kpauiTransferPrescriptionYourInfoPage.getFirstNamePopulatedValue();
        assertEquals(populatedFirstName, expectedFirstName,
                "Unexpected Member First Name Was Entered by Auto-Complete");

        String expectedLastName = expectedMemberCredentials.getLast();
        String populatedLastName = kpauiTransferPrescriptionYourInfoPage.getLastNamePopulatedValue();
        assertEquals(populatedLastName, expectedLastName,
                "Unexpected Member Last Name Was Entered by Auto-Complete");

        String expectedMemberID = expectedMemberCredentials.getID();
        String populatedMemberID = kpauiTransferPrescriptionYourInfoPage.getMemberIDPopulatedValue();
        assertEquals(populatedMemberID, expectedMemberID,
                "Unexpected Member ID Was Entered by Auto-Complete");

        String expectedDateOfBirth = expectedMemberCredentials.getDOB();
        List<Date> dobList = kpauiTransferPrescriptionYourInfoPage.verifyDateMatches(expectedDateOfBirth);
        assertEquals(dobList.get(0), dobList.get(1),
                "Unexpected Member DOB Was Entered by Auto-Complete");

        String expectedPhoneAreaCode = expectedMemberCredentials.getArea();
        String expectedPhoneNumber = expectedMemberCredentials.getPhone();
        String populatedPhoneNumber = kpauiTransferPrescriptionYourInfoPage.getPhoneNumberPopulatedValue();
        assertEquals(populatedPhoneNumber, expectedPhoneAreaCode + expectedPhoneNumber,
                "Unexpected Member Phone Number Was Entered by Auto-Complete");
    }

    @Test(description = "Verify The Forms Show Placeholder Text and Not the Member Data if Form is Cleared", groups = {"qa", "prod"})
    public void verifyTransferRxFormPlaceHolderText() {
        KPAUITransferRxYourInfoPage transferRxYourInfoClearedPage = kpauiTransferPrescriptionYourInfoPage.clearAllStep1Forms();

        String emptyFirstName = transferRxYourInfoClearedPage.getFirstNamePopulatedValue();
        String firstNamePlaceHolder = transferRxYourInfoClearedPage.getFirstNameFormField().getAttribute("placeholder");
        assertTrue(emptyFirstName.isEmpty(), "First Name Was Not Cleared");
        assertEquals(firstNamePlaceHolder, FIRST_NAME_FORM_PLACEHOLDER,
                "First Name Form Place Holder Is Not Expected String");

        String emptyLastName = transferRxYourInfoClearedPage.getLastNamePopulatedValue();
        String lastNamePlaceHolder = transferRxYourInfoClearedPage.getLastNameFormField().getAttribute("placeholder");
        assertTrue(emptyLastName.isEmpty(), "Last Name Was Not Cleared");
        assertEquals(lastNamePlaceHolder, LAST_NAME_FORM_PLACEHOLDER,
                "Last Name Form Place Holder Is Not Expected String");

        String emptyMemberID = transferRxYourInfoClearedPage.getMemberIDPopulatedValue();
        String memberIDPlaceHolder = transferRxYourInfoClearedPage.getMemberIDFormField().getAttribute("placeholder");
        assertTrue(emptyMemberID.isEmpty(), "Member ID Was Not Cleared");
        assertEquals(memberIDPlaceHolder, MEMBER_ID_FORM_PLACEHOLDER,
                "Member ID Place Holder Is Not Expected String");

        String emptyDateOfBirth = transferRxYourInfoClearedPage.getDateOfBirthPopulatedValue();
        String dateOfBirthPlaceHolder = transferRxYourInfoClearedPage.getDateOfBirthFormField().getAttribute("placeholder");
        assertTrue(emptyDateOfBirth.isEmpty(), "Date Of Birth Was Not Cleared");
        assertEquals(dateOfBirthPlaceHolder, DATE_OF_BIRTH_FORM_PLACEHOLDER,
                "Date Of Birth Place Holder Is Not Expected String");

        String emptyPhoneNumber = transferRxYourInfoClearedPage.getPhoneNumberPopulatedValue();
        String phoneNumberPlaceHolder = transferRxYourInfoClearedPage.getPhoneNumberFormField().getAttribute("placeholder");
        assertTrue(emptyPhoneNumber.isEmpty(), "Phone Number Was Not Cleared");
        assertEquals(phoneNumberPlaceHolder, PHONE_NUMBER_FORM_PLACEHOLDER,
                "Phone Number Place Holder Was Not Expected String");
    }

    @Test(description = "Verify The Second Step in the Progress Nav List is Active After Completing the Forms in Step One", groups = {"qa", "prod"})
    public void verifyProgressNavListItemTwoIsActive() {
        kpauiTransferPrescriptionYourInfoPage.completeStep1YesPerms();

        WebElement progressNavListItemTwo = kpauiTransferPrescriptionYourInfoPage.getStep2();
        WebElement activeStep = kpauiTransferPrescriptionYourInfoPage.getActiveStep();
        assertEquals(progressNavListItemTwo, activeStep);

        WebElement progressNavListCheckMarkOne = kpauiTransferPrescriptionYourInfoPage.getStep1DoneCheckMark();
        assertTrue(progressNavListCheckMarkOne.isDisplayed());
    }

    @Test(description = "Verify Selecting No Radio Button Also Allows Member to Proceed After Completing the Step One Forms", groups = {"smoke", "qa", "prod"})
    public void verifyCheckMarkOneIsDisplayedAfterOptOut() {
        kpauiTransferPrescriptionYourInfoPage.completeStep1NoPerms();
        WebElement progressNavListCheckMarkOne = kpauiTransferPrescriptionYourInfoPage.getStep1DoneCheckMark();
        assertTrue(progressNavListCheckMarkOne.isDisplayed());
    }
}
