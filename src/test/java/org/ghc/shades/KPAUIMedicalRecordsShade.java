package org.ghc.shades;

import org.ghc.pages.*;
import org.ghc.utils.extensions.KPAUIEveryShade;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.ghc.utils.helpers.KPAUITestHelper.waitForElement;
import static org.testng.Assert.fail;

public class KPAUIMedicalRecordsShade extends KPAUIEveryShade {

    public KPAUIMedicalRecordsShade(WebDriver driver) {
        super(driver);
        if (!isCurrent())
            fail("Records and Lab Results shade is not visible");
    }

    private boolean isCurrent() {
        return getMyHealthInformationHeader().isDisplayed() &&
                getSettingsHeader().isDisplayed();
    }

    //------------------------------------------------------------------------------------------------------------------

    public static final String YOUR_HELATH_SUBHEADER =          "My Health Information";
    public static final String SETTINGS_SUBHEADER =             "Settings";
    public static final String ALLERGIES =                      "Allergies";
    public static final String BLOOD_PRESSURE_AND_WEIGHT =      "Blood Pressure & Weight";
    public static final String LABS_AND_TEST_RESULTS =          "Lab & Test Results";
    public static final String ROUTINE_CARE_REMINDERS =         "Routine Care Reminders";
    public static final String IMMUNIZATIONS =                  "Immunizations";
    public static final String HEALTH_CONDITIONS =              "Health Conditions";
    public static final String LETTERS_VISION_PRESCRIPTIONS =   "Letters & Vision Prescriptions";
    public static final String GROWTH_CHART =                   "Growth Chart";
    public static final String ACCOUNT_AND_PREFERENCES=         "Account Preferences";
    public static final String PERSONALIZE =                    "Personalize";
    public static final String ACCOUNT_AUDIT =                  "Account Audit";
    public static final String DOWNLOAD_MY_RECORD =             "Download My Record";
    public static final String ACCESS_CHILDS_MEDICAL_RECORD =   "Get Access to My Child's Medical Record";

    @FindBy(xpath = "//div/div[1]/div[1]/p")                    private WebElement myHealthInformationHeader;
    @FindBy(xpath = "//div/div[1]/div[2]/p")                    private WebElement settingsHeader;
    @FindBy(xpath = "//div/div[1]/div[1]/ul/li[1]/a")           private WebElement labAndTestResultsLink;
    @FindBy(xpath = "//div/div[1]/div[1]/ul/li[2]/a")           private WebElement routineCareRemindersLink;
    @FindBy(xpath = "//div/div[1]/div[1]/ul/li[3]/a")           private WebElement immunizationsLink;
    @FindBy(xpath = "//div/div[1]/div[1]/ul/li[4]/a")           private WebElement allergiesLink;
    @FindBy(xpath = "//div/div[1]/div[1]/ul/li[5]/a")           private WebElement bloodPressureWeightLink;
    @FindBy(xpath = "//div/div[1]/div[1]/ul/li[6]/a")           private WebElement healthConditionsLink;
    @FindBy(xpath = "//div/div[1]/div[1]/ul/li[7]/a")           private WebElement lettersVisionPrescriptionsLink;
    @FindBy(xpath = "//div/div[1]/div[1]/ul/li[8]/a")           private WebElement growthCartLink;
    @FindBy(xpath = "//div/div[1]/div[2]/ul/li[1]/a")           private WebElement accountPreferencesLink;
    @FindBy(xpath = "//div/div[1]/div[2]/ul/li[2]/a")           private WebElement personalizeLink;
    @FindBy(xpath = "//div/div[1]/div[2]/ul/li[3]/a")           private WebElement accountAuditLink;
    @FindBy(xpath = "//div/div[1]/div[2]/ul/li[4]/a")           private WebElement downloadMyRecordLink;
    @FindBy(xpath = "//div/div[1]/div[2]/ul/li[5]/a")           private WebElement accessToChildsRecordLink;

    public WebElement getMyHealthInformationHeader()            { return waitForElement(myHealthInformationHeader, driver); }
    public WebElement getSettingsHeader()                       { return settingsHeader; }
    public WebElement getLabAndTestResultsLink()                { return labAndTestResultsLink; }
    public WebElement getRoutineCareRemindersLink()             { return routineCareRemindersLink; }
    public WebElement getImmunizationsLink()                    { return immunizationsLink; }
    public WebElement getAllergiesLink()                        { return allergiesLink; }
    public WebElement getBloodPressureWeightLink()              { return bloodPressureWeightLink; }
    public WebElement getHealthConditionsLink()                 { return healthConditionsLink; }
    public WebElement getLettersVisionPrescriptionsLink()       { return lettersVisionPrescriptionsLink; }
    public WebElement getGrowthCartLink()                       { return growthCartLink; }
    public WebElement getAccountPreferencesLink()               { return accountPreferencesLink; }
    public WebElement getPersonalizeLink()                      { return personalizeLink; }
    public WebElement getAccountAuditLink()                     { return accountAuditLink; }
    public WebElement getDownloadMyRecordLink()                 { return downloadMyRecordLink; }
    public WebElement getAccessToChildsRecordLink()             { return accessToChildsRecordLink; }

    /** Open Lab and Test Results Page
     * @return - KPAUILabAndTestResultsPage
     */
    public KPAUILabAndTestResultsPage openLabsAndTestResultsPage() {
        getLabAndTestResultsLink().click();
        return new KPAUILabAndTestResultsPage(driver);
    }

    /** Open Routine Care Reminders Page
     * @return - KPAUIRoutineCareRemindersPage
     */
    public KPAUIRoutineCareRemindersPage openRoutineCareRemindersPage() {
        getRoutineCareRemindersLink().click();
        return new KPAUIRoutineCareRemindersPage(driver);
    }

    /** Open Immunizations Page
     * @return - KPAUIImmunizationsPage
     */
    public KPAUIImmunizationsPage openImmunizationsPage() {
        getImmunizationsLink().click();
        return new KPAUIImmunizationsPage(driver);
    }

    /** Open Allergies Page
     * @return - KPAUIAllergiesPage
     */
    public KPAUIAllergiesPage openAllergiesPage() {
        getAllergiesLink().click();
        return new KPAUIAllergiesPage(driver);
    }

    /** Opens Blood Pressure and Weight Page
     * @return - KPAUIBloodPressureAndWeightPage
     */
    public KPAUIBloodPressureAndWeightPage openBloodPressureAndWeighPage() {
        getBloodPressureWeightLink().click();
        return new KPAUIBloodPressureAndWeightPage(driver);
    }

    /** Open Health Conditions Page
     * @return - KPAUIHealthConditionsPage
     */
    public KPAUIHealthConditionsPage openHealthConditionsPage() {
        getHealthConditionsLink().click();
        return new KPAUIHealthConditionsPage(driver);
    }

    /** Open Letters and Vision Prescriptions Page
     * @return - KPAUILettersAndVisionPrescriptionPage
     */
    public KPAUILettersAndVisionPrescriptionPage openLettersAndVisionPrescriptionsPage() {
        getLettersVisionPrescriptionsLink().click();
        return new KPAUILettersAndVisionPrescriptionPage(driver);
    }

    /** Open Growth Chart Page
     * @return - KPAUIGrowthChartPage
     */
    public KPAUIGrowthChartPage openGrowthChartPage() {
        getGrowthCartLink().click();
        return new KPAUIGrowthChartPage(driver);
    }

    /** Open Account and Preferences Page
     * @return - KPAUIAccountAndPreferencesPage
     */
    public KPAUIAccountAndPreferencesPage openAccountAndPreferencesPage() {
        getAccountPreferencesLink().click();
        return new KPAUIAccountAndPreferencesPage(driver);
    }

    /** Open The Personalize Page
     * @return - KPAUIPersonalizePage
     */
    public KPAUIPersonalizePage openPersonalizePage() {
        getPersonalizeLink().click();
        return new KPAUIPersonalizePage(driver);
    }

    /** Open the Account Audit Page
     * @return - KPAUIAccountAuditPage
     */
    public KPAUIAccountAuditPage openAccountAuditPage() {
        getAccountAuditLink().click();
        return new KPAUIAccountAuditPage(driver);
    }

    /** Open the DownloadMyRecordsPage
     * @return - KPAUIDownloadMyRecordsPage
     */
    public KPAUIDownloadMyRecordsPage openDownloadMyRecordPage() {
        getDownloadMyRecordLink().click();
        return new KPAUIDownloadMyRecordsPage(driver);
    }

    /** Open the Access Your Child's Medical Record's Page
     * @return - KPAUIAccessChildsMedicalRecordsPage
     */
    public KPAUIAccessChildsMedicalRecordsPage openAccessYourChildsMedicalRecordPage() {
        getAccessToChildsRecordLink().click();
        return new KPAUIAccessChildsMedicalRecordsPage(driver);
    }
}
