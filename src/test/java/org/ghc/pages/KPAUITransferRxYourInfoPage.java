package org.ghc.pages;

import org.ghc.shades.KPAUIMemberIDHelpShade;
import org.ghc.utils.extensions.KPAUITransferRxEveryPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import static org.ghc.utils.helpers.KPAUITestHelper.*;
import static org.testng.Assert.fail;

public class KPAUITransferRxYourInfoPage extends KPAUITransferRxEveryPage {

    public KPAUITransferRxYourInfoPage(WebDriver driver) {
        super(driver);
        if (!isCurrent()) {
            fail("Transfer Prescriptions Your Information Page failed to load.");
        }
    }

    /** Checks if rxLearnMoreSubHeader is currently displayed
     * @return boolean - true if the Learn More Header is displayed
     */
    private boolean isCurrent() {
        sleep(2);
        try { return rxLearnMoreSubHeader.isDisplayed();
        } catch(Exception ex){}
        return memberSignOn.isDisplayed();
    }


    //------------------------------------------------------------------------------------------------------------------

    // Finders
    @FindBy(xpath = "//*[@id='container']/div[2]/h1")                   private WebElement memberSignOn;
    @FindBy(xpath = "//core-button[1]")                                 private WebElement clearFormButton;
    @FindBy(xpath = "//core-button[1]/button")                          private WebElement clearFormButtonLabel;
    @FindBy(xpath = "//div[3]/div/div/div[4]")                          private WebElement dateOfBirthForm;
    @FindBy(xpath = "//div[4]/core-textbox/input")                      private WebElement dateOfBirthFormField;
    @FindBy(xpath = "//div/div[4]/label")                               private WebElement dateOfBirthFormLabel;
    @FindBy(xpath = "//div[3]/div/div/div[4]/span")                     private WebElement dateOfBirthFormStar;
    @FindBy(xpath = "//*[@id='dob']/small")                             private WebElement dateOfBirthFormWarn;
    @FindBy(xpath = "//div[3]/div/div/div[1]")                          private WebElement firstNameForm;
    @FindBy(xpath = "//div[1]/core-textbox/input")                      private WebElement firstNameFormField;
    @FindBy(xpath = "//div/div[1]/label")                               private WebElement firstNameFormLabel;
    @FindBy(xpath = "//div[3]/div/div/div[1]/span")                     private WebElement firstNameFormStar;
    @FindBy(xpath = "//*[@id='firstName']/small")                       private WebElement firstNameFormWarn;
    @FindBy(xpath = "//div[3]/div/div/div[2]")                          private WebElement lastNameForm;
    @FindBy(xpath = "//div[2]/core-textbox/input")                      private WebElement lastNameFormField;
    @FindBy(xpath = "//div/div[2]/label")                               private WebElement lastNameFormLabel;
    @FindBy(xpath = "//div[3]/div/div/div[2]/span")                     private WebElement lastNameFormStar;
    @FindBy(xpath = "//*[@id='lastName']/small")                        private WebElement lastNameFormWarn;
    @FindBy(xpath = "//div[3]/div/div/div[3]")                          private WebElement memberIDForm;
    @FindBy(xpath = "//div[3]/core-textbox/input")                      private WebElement memberIDFormField;
    @FindBy(xpath = "//div/div[3]/label")                               private WebElement memberIDFormLabel;
    @FindBy(xpath = "//div[3]/div/div/div[3]/span")                     private WebElement memberIDFormStar;
    @FindBy(xpath = "//div[3]/core-link/a")                             private WebElement memberIDHelpLink;
    @FindBy(xpath = "//*[@id='memberId']/small")                        private WebElement memberIDFormWarn;
    @FindBy(xpath = "//core-link/a")                                    private WebElement memberServicesLink;
    @FindBy(xpath = "//div/div[7]/label")                               private WebElement messagePermsLabel;
    @FindBy(xpath = "//div[3]/div/div/div[7]/label/span")               private WebElement messagePermsStar;
    @FindBy(xpath = "//core-button[2]")                                 private WebElement nextStepButton;
    @FindBy(xpath = "//core-button[2]/button")                          private WebElement nextStepButtonLabel;
    @FindBy(xpath = "//div[2]/label/input")                             private WebElement noRadioButtonInput;
    @FindBy(xpath = "//core-radio/div[2]/label")                        private WebElement noRadioButtonLabel;
    @FindBy(xpath = "//div[3]/div/div/div[5]")                          private WebElement phoneNumberForm;
    @FindBy(xpath = "//div[5]/core-textbox/input")                      private WebElement phoneNumberFormField;
    @FindBy(xpath = "//div/div[5]/label")                               private WebElement phoneNumberFormLabel;
    @FindBy(xpath = "//div[3]/div/div/div[5]/span")                     private WebElement phoneNumberFormStar;
    @FindBy(xpath = "//*[@id='phone']/small")                           private WebElement phoneNumberFormWarn;
    @FindBy(xpath = "//div[3]/div/div/div[6]")                          private WebElement phoneExtensionForm;
    @FindBy(xpath = "//div[6]/core-textbox/input")                      private WebElement phoneExtensionFormField;
    @FindBy(xpath = "//div/div[6]/label")                               private WebElement phoneExtensionFormLabel;
    @FindBy(xpath = "//*[@id='phoneExt']/small")                        private WebElement phoneExtensionFormWarn;
    @FindBy(xpath = "//kp-transfer-prescription-info/div[2]/p[2]")      private WebElement rxLearnMoreBody;
    @FindBy(xpath = "//kp-transfer-prescription-info/div[2]/p")         private WebElement rxLearnMoreSubHeader;
    @FindBy(xpath = "//div[1]/label/input")                             private WebElement yesRadioButtonInput;
    @FindBy(xpath = "//core-radio/div[1]/label")                        private WebElement yesRadioButtonLabel;

    // Getters
    public WebElement getClearFormButton()          { return waitForElementToBeClickable(clearFormButton, driver);}
    public WebElement getClearFormButtonLabel()     { return waitForElement(clearFormButtonLabel, driver);}
    public WebElement getDateOfBirthForm()          { return waitForElement(dateOfBirthForm, driver);}
    public WebElement getDateOfBirthFormField()     { return waitForElement(dateOfBirthFormField, driver);}
    public WebElement getDateOfBirthFormLabel()     { return waitForElement(dateOfBirthFormLabel, driver);}
    public WebElement getDateOfBirthFormStar()      { return waitForElement(dateOfBirthFormStar, driver);}
    public WebElement getDateOfBirthFormWarn()      { return waitForElement(dateOfBirthFormWarn, driver);}
    public String getDateOfBirthPopulatedValue()    { return getDateOfBirthFormField().getAttribute("value");}
    public WebElement getFirstNameForm()            { return waitForElement(firstNameForm, driver);}
    public WebElement getFirstNameFormField()       { return waitForElement(firstNameFormField, driver);}
    public WebElement getFirstNameFormLabel()       { return waitForElement(firstNameFormLabel, driver);}
    public WebElement getFirstNameFormStar()        { return firstNameFormStar;}
    public WebElement getFirstNameFormWarn()        { return firstNameFormWarn;}
    public String getFirstNamePopulatedValue()      { return getFirstNameFormField().getAttribute("value");}
    public WebElement getLastNameForm()             { return waitForElement(lastNameForm, driver);}
    public WebElement getLastNameFormField()        { return waitForElement(lastNameFormField, driver);}
    public WebElement getLastNameFormLabel()        { return waitForElement(lastNameFormLabel, driver);}
    public WebElement getLastNameFormStar()         { return lastNameFormStar;}
    public WebElement getLastNameFormWarn()         { return lastNameFormWarn;}
    public String getLastNamePopulatedValue()       { return getLastNameFormField().getAttribute("value");}
    public WebElement getMemberIDForm()             { return waitForElement(memberIDForm, driver);}
    public WebElement getMemberIDFormField()        { return waitForElement(memberIDFormField, driver);}
    public WebElement getMemberIDFormLabel()        { return waitForElement(memberIDFormLabel, driver);}
    public WebElement getMemberIDFormStar()         { return memberIDFormStar;}
    public WebElement getMemberIDFormWarn()         { return memberIDFormWarn;}
    public String getMemberIDPopulatedValue()       { return getMemberIDFormField().getAttribute("value");}
    public WebElement getMemberIDHelpLink()         { return waitForElement(memberIDHelpLink, driver);}
    public WebElement getMessagePermsLabel()        { return waitForElement(messagePermsLabel, driver);}
    public WebElement getMessagePermsStar()         { return waitForElement(messagePermsStar, driver);}
    public WebElement getNextStepButton()           { return waitForElementToBeClickable(nextStepButton, driver);}
    public WebElement getNextStepButtonLabel()      { return waitForElement(nextStepButtonLabel, driver);}
    public String getNoRadioButtonLabel()           { return waitForElement(noRadioButtonLabel, driver).getText();}
    public WebElement getNoRadioButtonInput()       { return waitForElementToBeClickable(noRadioButtonInput, driver);}
    public WebElement getPhoneExtensionForm()       { return waitForElement(phoneNumberForm, driver);}
    private WebElement getPhoneExtensionFormField() { return waitForElement(phoneExtensionFormField, driver);}
    public WebElement getPhoneExtensionFormLabel()  { return waitForElement(phoneExtensionFormLabel, driver);}
    public WebElement getPhoneExtensionFormWarn()   { return phoneExtensionFormWarn;}
    public WebElement getPhoneNumberForm()          { return waitForElement(phoneNumberForm, driver);}
    public WebElement getPhoneNumberFormField()     { return waitForElement(phoneNumberFormField, driver);}
    public WebElement getPhoneNumberFormLabel()     { return waitForElement(phoneNumberFormLabel, driver);}
    public WebElement getPhoneNumberFormStar()      { return phoneNumberFormStar;}
    public WebElement getPhoneNumberFormWarn()      { return phoneNumberFormWarn;}
    public String getPhoneNumberPopulatedValue()    { return getPhoneNumberFormField().getAttribute("value").replaceAll("\\D", "");}
    public WebElement getRxLearnMoreSubHeader()     { return waitForElement(rxLearnMoreSubHeader, driver);}
    public WebElement getRxLearnMoreBody()          { return waitForElement(rxLearnMoreBody, driver);}
    public String getYesRadioButtonLabel()          { return waitForElement(yesRadioButtonLabel, driver).getText();}
    public WebElement getYesRadioButtonInput()      { return waitForElementToBeClickable(yesRadioButtonInput, driver);}

    // Methods
    /** Clicks on the next step button and moves to AddPrescriptionsPage
     * @return - KPAUITransferRxAddPrescriptionsPage
     */
    private KPAUITransferRxAddPrescriptionsPage clickNextStepButton() {
        getNextStepButton().click();
        sleep(1);
        return new KPAUITransferRxAddPrescriptionsPage(driver);
    }

    /** Clicks on the next step button and moves to YourInfoPage
     * @return - KPAUITransferRxYourInfoPage
     */
    public KPAUITransferRxYourInfoPage clickNextStepButtonExpectingError() {
        getNextStepButton().click();
        return new KPAUITransferRxYourInfoPage(driver);
    }

    /** Clicks on the No radio button and moves YourInfoPage
     * @return - KPAUITransferRxYourInfoPage
     */
    private KPAUITransferRxYourInfoPage clickNoRadioButtonInput() {
        getNoRadioButtonInput().click();
        return new KPAUITransferRxYourInfoPage(driver);
    }

    /** Clicks on Yes radio button and moves YourInfoPage
     * @return - KPAUITransferRxYourInfoPage
     */
    private KPAUITransferRxYourInfoPage clickYesRadioButtonInput() {
        getYesRadioButtonInput().click();
//        sleep(1);
        return new KPAUITransferRxYourInfoPage(driver);
    }

    /** Clicks on the Clear forms button and alters YourInfoPage
     * @return - KPAUITransferRxYourInfoPage
     */
    public KPAUITransferRxYourInfoPage clearAllStep1Forms() {
        getClearFormButton().click();
        return new KPAUITransferRxYourInfoPage(driver);
    }

    /** Click on "Yes" radio button then click on "Next" button
     * @return - KPAUITransferRxAddPrescriptionsPage
     */
    public KPAUITransferRxAddPrescriptionsPage completeStep1YesPerms() {
        clickYesRadioButtonInput().clickNextStepButton();
        return new KPAUITransferRxAddPrescriptionsPage(driver);
    }

    /** Click on "No" radio button then click on "Next" button
     * @return - KPAUITransferRxAddPrescriptionsPage
     */
    public KPAUITransferRxAddPrescriptionsPage completeStep1NoPerms() {
        clickNoRadioButtonInput().clickNextStepButton();
        return new KPAUITransferRxAddPrescriptionsPage(driver);
    }

    /** Sends a nine digit Member ID string to the memberIdFormField
     * @return - KPAUITransferRxYourInfoPage
     */
    public KPAUITransferRxYourInfoPage insertLongMemberID() {
        getMemberIDFormField().sendKeys("012345678");
        return new KPAUITransferRxYourInfoPage(driver);
    }

    /** Sends a ten digit string to the phoneExtensionFormField
     * @return - KPAUITransferRxYourInfoPage
     */
    public KPAUITransferRxYourInfoPage insertLongPhoneExt() {
        getPhoneExtensionFormField().sendKeys("01234567891");
        return new KPAUITransferRxYourInfoPage(driver);
    }

    /** Sends a six digit string to the dateOfBirthFormField
     * @return - KPAUITransferRxYourInfoPage
     */
    public KPAUITransferRxYourInfoPage insertShortDOB() {
        getDateOfBirthFormField().sendKeys("0105500");
        return new KPAUITransferRxYourInfoPage(driver);
    }

    /** Sends a one character string to the firstNameFormField
     * @return - KPAUITransferRxYourInfoPage
     */
    public KPAUITransferRxYourInfoPage insertShortFirstName() {
        getFirstNameFormField().sendKeys("A");
        return new KPAUITransferRxYourInfoPage(driver);
    }

    /** Sends a one char string to the lastNameFormField
     * @return - KPAUITransferRxYourInfoPage
     */
    public KPAUITransferRxYourInfoPage insertShortLastName() {
        getLastNameFormField().sendKeys("A");
        return new KPAUITransferRxYourInfoPage(driver);
    }

    /** Sends a string of special chars to firstNameFormField
     * @return - KPAUITransferRxYourInfoPage
     */
    public KPAUITransferRxYourInfoPage insertUnexpectedCharFirstName() {
        getFirstNameFormField().sendKeys("@#$!");
        return new KPAUITransferRxYourInfoPage(driver);
    }

    /** Sends a string of special chars to lastNameFormField
     * @return - KPAUITransferRxYourInfoPage
     */
    public KPAUITransferRxYourInfoPage insertUnexpectedCharLastName() {
        getLastNameFormField().sendKeys("@#$!");
        return new KPAUITransferRxYourInfoPage(driver);
    }

    /** Sends an alpha string to memberIDFormField
     * @return
     */
    public KPAUITransferRxYourInfoPage insertUnexpectedCharMemberID() {
        getMemberIDFormField().sendKeys("A");
        return new KPAUITransferRxYourInfoPage(driver);
    }

    /** Sends a string of special characters to phoneExtensionFormField
     * @return - KPAUITransferRxYourInfoPage
     */
    public KPAUITransferRxYourInfoPage insertUnexpectedCharPhoneExt() {
        getPhoneExtensionFormField().sendKeys("!@#");
        return new KPAUITransferRxYourInfoPage(driver);
    }

    /** Sends an invalid date (future year) to the dateOfBirthFormField
     * @return - KPAUITransferRxYourInfoPage
     */
    public KPAUITransferRxYourInfoPage insertUnexpectedDOB() {
        getDateOfBirthFormField().sendKeys("01555555");
        return new KPAUITransferRxYourInfoPage(driver);
    }

    /** Clicks on memberIDHelpLink in order to open the help shade
     * @return - KPAUIMemberIDNumberHelpShade
     */
    public KPAUIMemberIDHelpShade openMemberIDNumberHelpShade() {
        getMemberIDHelpLink().click();
        return new KPAUIMemberIDHelpShade(driver);
    }

    /** Adds parsed dateOfBirthPopulatedValue and messDOB in SimpleDateFormat to an ArrayList
     * @param messDOB
     * @return ArrayList list
     */
    public ArrayList<Date> verifyDateMatches(String messDOB) {
        ArrayList<Date> list = new ArrayList<>();
        try {
            list.add(new SimpleDateFormat("MM/dd/yyyy").parse(getDateOfBirthPopulatedValue()));
            list.add(new SimpleDateFormat("yyyy-MM-dd").parse(messDOB));
        }catch(Exception e){
            fail(e.toString());
        }
        return list;
    }
}
