package org.ghc.pages;

import org.ghc.utils.extensions.KPAUITransferRxEveryPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.ghc.utils.helpers.KPAUITestHelper.waitForElement;
import static org.ghc.utils.helpers.KPAUITestHelper.waitForElementToBeClickable;
import static org.testng.Assert.fail;

public class KPAUITransferRxAddPrescriptionsPage extends KPAUITransferRxEveryPage {

    public KPAUITransferRxAddPrescriptionsPage(WebDriver driver) {
        super(driver);
        if (!isCurrent())
            fail("The TransferRx Add Prescriptions Page did not load correctly");
    }

    public boolean isCurrent() {
        return getStep1DoneCheckMark().isDisplayed();

    }
    //------------------------------------------------------------------------------------------------------------------

    // Finders
    @FindBy(xpath = "//div[1]/core-textbox/input")      private WebElement currentPharmacyForm;
    @FindBy(xpath = "//div/div[1]/label")               private WebElement currentPharmacyFormLabel;
    @FindBy(xpath = "//div[2]/div/div/div[1]/span")     private WebElement currentPharmacyFormStar;
    @FindBy(xpath = "//div[8]/core-textbox/input")      private WebElement doctorNameForm;
    @FindBy(xpath = "//div/div[8]/label")               private WebElement doctorNameFormLabel;
    @FindBy(xpath = "//div[2]/div/div/div[8]/span")     private WebElement doctorNameFormStar;
    @FindBy(xpath = "//div[9]/core-textbox/input")      private WebElement doctorPhoneNumberForm;
    @FindBy(xpath = "//div/div[9]/label")               private WebElement doctorPhoneNumberFormLabel;
    @FindBy(xpath = "//div[10]/core-textbox/input")     private WebElement doctorPhoneExtensionForm;
    @FindBy(xpath = "//div/div[10]/label")              private WebElement doctorPhoneExtensionFormLabel;
    @FindBy(xpath = "//div[4]/core-textbox/input")      private WebElement medicationNameForm;
    @FindBy(xpath = "//div/div[4]/label")               private WebElement medicationNameFormLabel;
    @FindBy(xpath = "//div[2]/div/div/div[4]/span")     private WebElement medicationNameFormStar;
    @FindBy(xpath = "//div[5]/core-textbox/input")      private WebElement medicationNumberForm;
    @FindBy(xpath = "//div/div[5]/label")               private WebElement medicationNumberFormLabel;
    @FindBy(xpath = "//div[2]/div/div/div[5]/span")     private WebElement medicationNumberFormStar;
    @FindBy(xpath = "//div[6]/core-textbox/input")      private WebElement medicationStrengthForm;
    @FindBy(xpath = "//div/div[6]/label")               private WebElement medicationStrengthFormLabel;
    @FindBy(xpath = "//core-select/select")             private WebElement medicationSupplyDropDown;
    @FindBy(xpath = "//div/div[7]/label")               private WebElement medicationSupplyDropDownLabel;
    @FindBy(xpath = "//div[2]/div/div/div[7]/span")     private WebElement medicationSupplyDropDownStar;
    @FindBy(xpath = "//div[1]/core-textbox/small")      private WebElement missingCurrentPharmacyIndication;
    @FindBy(xpath = "//div[2]/core-textbox/small")      private WebElement missingPharmacyPhoneNumberIndication;
    @FindBy(xpath = "//div[4]/core-textbox/small")      private WebElement missingMedicationNameIndication;
    @FindBy(xpath = "//div[5]/core-textbox/small")      private WebElement missingMedicationNumberIndication;
    @FindBy(xpath = "//div[7]/core-select/small")       private WebElement missingMedicationSupplySelectionIndication;
    @FindBy(xpath = "//div[8]/core-textbox/small")      private WebElement missingDoctorNameIndication;
    @FindBy(xpath = "//div[2]/core-textbox/input")      private WebElement pharmacyPhoneNumberForm;
    @FindBy(xpath = "//div/div[2]/label")               private WebElement pharmacyPhoneNumberFormLabel;
    @FindBy(xpath = "//div[2]/div/div/div[2]/span")     private WebElement pharmacyPhoneNumberFormStar;
    @FindBy(xpath = "//div[3]/core-textbox/input")      private WebElement pharmacyPhoneExtensionForm;
    @FindBy(xpath = "//div/div[3]/label")               private WebElement pharmacyPhoneExtensionFormLabel;
    @FindBy(xpath = "//core-button[1]")                 private WebElement step2CancelButton;
    @FindBy(xpath = "//core-button[1]/button")          private WebElement step2CancelButtonLabel;
    @FindBy(xpath = "//core-button[2]")                 private WebElement step2SubmitButton;
    @FindBy(xpath = "//core-button[2]/button")          private WebElement step2SubmitButtonLabel;

    // Getters
    public WebElement getCurrentPharmacyForm()              { return waitForElement(currentPharmacyForm, driver); }
    public WebElement getCurrentPharmacyFormLabel()         { return waitForElement(currentPharmacyFormLabel, driver); }
    public WebElement getCurrentPharmacyFormStar()          { return waitForElement(currentPharmacyFormStar, driver); }
    public WebElement getDoctorNameForm()                   { return waitForElement(doctorNameForm, driver); }
    public WebElement getDoctorNameFormLabel()              { return waitForElement(doctorNameFormLabel, driver); }
    public WebElement getDoctorNameFormStar()               { return waitForElement(doctorNameFormStar, driver); }
    public WebElement getDoctorPhoneNumberForm()            { return waitForElement(doctorPhoneNumberForm, driver); }
    public WebElement getDoctorPhoneNumberFormLabel()       { return waitForElement(doctorPhoneNumberFormLabel, driver); }
    public WebElement getDoctorPhoneExtensionForm()         { return waitForElement(doctorPhoneExtensionForm, driver); }
    public WebElement getDoctorPhoneExtensionFormLabel()    { return waitForElement(doctorPhoneExtensionFormLabel, driver); }
    public WebElement getMedicationNameForm()               { return waitForElement(medicationNameForm, driver); }
    public WebElement getMedicationNameFormLabel()          { return waitForElement(medicationNameFormLabel, driver); }
    public WebElement getMedicationNameFormStar()           { return waitForElement(medicationNameFormStar, driver); }
    public WebElement getMedicationNumberForm()             { return waitForElement(medicationNumberForm, driver); }
    public WebElement getMedicationNumberFormLabel()        { return waitForElement(medicationNumberFormLabel, driver); }
    public WebElement getMedicationNumberFormStar()         { return waitForElement(medicationNumberFormStar, driver); }
    public WebElement getMedicationStrengthForm()           { return waitForElement(medicationStrengthForm, driver); }
    public WebElement getMedicationStrengthFormLabel()      { return waitForElement(medicationStrengthFormLabel, driver); }
    public WebElement getMedicationSupplyDropDown()         { return waitForElement(medicationSupplyDropDown, driver); }
    public WebElement getMedicationSupplyDropDownLabel()    { return waitForElement(medicationSupplyDropDownLabel, driver); }
    public WebElement getMedicationSupplyDropDownStar()     { return waitForElement(medicationSupplyDropDownStar, driver); }
    public WebElement getMissingCurrentPharmacyIndication() { return waitForElement(missingCurrentPharmacyIndication, driver); }
    public WebElement getMissingPharmacyPhoneIndication()   { return waitForElement(missingPharmacyPhoneNumberIndication, driver); }
    public WebElement getMissingMedicationNameIndication()  { return waitForElement(missingMedicationNameIndication, driver); }
    public WebElement getMissingMedNumberIndication()       { return waitForElement(missingMedicationNumberIndication, driver); }
    public WebElement getMissingMedicationSupplyIndication(){ return waitForElement(missingMedicationSupplySelectionIndication, driver); }
    public WebElement getMissingDoctorNameIndication()      { return waitForElement(missingDoctorNameIndication, driver); }
    public WebElement getPharmacyPhoneNumberForm()          { return waitForElement(pharmacyPhoneNumberForm, driver); }
    public WebElement getPharmacyPhoneNumberFormLabel()     { return waitForElement(pharmacyPhoneNumberFormLabel, driver); }
    public WebElement getPharmacyPhoneNumberFormStar()      { return waitForElement(pharmacyPhoneNumberFormStar, driver); }
    public WebElement getPharmacyPhoneExtensionForm()       { return waitForElement(pharmacyPhoneExtensionForm, driver); }
    public WebElement getPharmacyPhoneExtensionFormLabel()  { return waitForElement(pharmacyPhoneExtensionFormLabel, driver); }
    public WebElement getStep2CancelButton()                { return waitForElementToBeClickable(step2CancelButton, driver); }
    public WebElement getStep2CancelButtonLabel()           { return waitForElement(step2CancelButtonLabel, driver); }
    public WebElement getStep2SubmitButton()                { return waitForElementToBeClickable(step2SubmitButton, driver); }
    public WebElement getStep2SubmitButtonLabel()           { return waitForElement(step2SubmitButtonLabel, driver); }

    // Methods

    /** Click on Step 2 Submit Button and return a modified KPAUITransferRxSummaryPage
     * @return KPAUITransferRxSummaryPage
     */
    private KPAUITransferRxSummaryPage clickStep2SubmitButton() {
        getStep2SubmitButton().click();
        return new KPAUITransferRxSummaryPage(driver);
    }

    /** Click on Step 2 Submit Button and proceed to the Next step on KPAUITransferRxAddPrescriptionsPage
     * @return KPAUITransferRxAddPrescriptionsPage
     */
    public KPAUITransferRxAddPrescriptionsPage clickStep2SubmitButtonForErrors() {
        getStep2SubmitButton().click();
        return new KPAUITransferRxAddPrescriptionsPage(driver);
    }

    /** Fill out all required forms with valid data and then click on Step 2 submit button proceeding to KPAUITransferRxSummaryPage
     * @return KPAUITransferRxSummaryPage
     */
    public KPAUITransferRxSummaryPage completeAddRx() {
        getCurrentPharmacyForm().sendKeys("Greenwood Bartell Drugs");
        getPharmacyPhoneNumberForm().sendKeys("555-555-5555");
        getPharmacyPhoneExtensionForm().sendKeys("123");
        getMedicationNameForm().sendKeys("hydroxyzine");
        getMedicationNumberForm().sendKeys("55555 666 777 11111111111111");
        getMedicationStrengthForm().sendKeys("50mg");
        getMedicationSupplyDropDown().sendKeys("3");
        getDoctorNameForm().sendKeys("Dr. Feel Better");
        getDoctorPhoneNumberForm().sendKeys("555-555-5555");
        getDoctorPhoneExtensionForm().sendKeys("123");
        clickStep2SubmitButton();
        return new KPAUITransferRxSummaryPage(driver);
    }
}
