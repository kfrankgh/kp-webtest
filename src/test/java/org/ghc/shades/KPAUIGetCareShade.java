package org.ghc.shades;

import org.ghc.pages.*;
import org.ghc.utils.extensions.KPAUIEveryShade;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.ghc.utils.helpers.KPAUITestHelper.waitForElement;
import static org.testng.Assert.fail;

public class KPAUIGetCareShade extends KPAUIEveryShade {

    public KPAUIGetCareShade(WebDriver driver) {
        super(driver);
        if (!isCurrent())
            fail("Get Care shade is not visible");
    }

    private boolean isCurrent() {
        return getCareOptionsHeader().isDisplayed() &&
                getPharmacyHeader().isDisplayed() &&
                getCareServicesHeader().isDisplayed();
    }

    //------------------------------------------------------------------------------------------------------------------

    public static final String CARE_OPTIONS_SUBHEADER =     "Care Options";
    public static final String PHARMACY_SUBHEADER =         "Pharmacy";
    public static final String CARE_SERVICES_SUBHEADER =    "Care Services";
    public static final String FIND_CARE_NOW =              "Find Care Now";
    public static final String PHARMACY_SERVICES =          "Pharmacy Services";
    public static final String TRANSFER_PRESCRIPTIONS =     "Transfer Prescriptions";
    public static final String MAIL_ORDER_PHARMACY =        "Mail Order Pharmacy";
    public static final String DRUG_FORMULARY =             "Drug Formulary";
    public static final String FIND_A_DOCTOR =              "Find a Doctor";
    public static final String HEALTH_CARE_SERVICES =       "Health Care Services";
    public static final String SPECIALTY_CARE =             "Specialty Care";
    public static final String BEHAVIORAL_HEALTH_SERVICES = "Behavioral Health";
    public static final String EYE_CARE =                   "Eye Care";
    public static final String LOCATIONS =                  "Locations";

    @FindBy(xpath = "//div/div[1]/div[1]/p[1]")             private WebElement careOptionsHeader;
    @FindBy(xpath = "//div/div[1]/div[1]/p[2]")             private WebElement pharmacyHeader;
    @FindBy(xpath = "//div/div[1]/div[2]/p[1]")             private WebElement careServicesHeader;
    @FindBy(xpath = "//div/div[1]/div[1]/ul[1]/li/a")       private WebElement findCareNowLink;
    @FindBy(xpath = "//div/div[1]/div[1]/ul[2]/li[1]/a")    private WebElement pharmacyServicesLink;
    @FindBy(xpath = "//div/div[1]/div[1]/ul[2]/li[2]/a")    private WebElement transferPrescriptionsLink;
    @FindBy(xpath = "//div/div[1]/div[1]/ul[2]/li[3]/a")    private WebElement mailOrderPharmacyLink;
    @FindBy(xpath = "//div/div[1]/div[1]/ul[2]/li[4]/a")    private WebElement drugFormularyLink;
    @FindBy(xpath = "//div/div[1]/div[2]/ul/li[1]/a")       private WebElement findADoctorLink;
    @FindBy(xpath = "//div/div[1]/div[2]/ul/li[2]/a")       private WebElement healthCareServicesLink;
    @FindBy(xpath = "//div/div[1]/div[2]/ul/li[3]/a")       private WebElement specialtyCareLink;
    @FindBy(xpath = "//div/div[1]/div[2]/ul/li[4]/a")       private WebElement behavioralHealthLink;
    @FindBy(xpath = "//div/div[1]/div[2]/ul/li[5]/a")       private WebElement eyeCareLink;
    @FindBy(xpath = "//div/div[1]/div[2]/ul/li[6]/a")       private WebElement locationsLink;

    public WebElement getCareOptionsHeader()                { return waitForElement(careOptionsHeader, driver); }
    public WebElement getPharmacyHeader()                   { return waitForElement(pharmacyHeader, driver); }
    public WebElement getCareServicesHeader()               { return waitForElement(careServicesHeader, driver); }
    public WebElement getFindCareNowLink()                  { return findCareNowLink; }
    public WebElement getPharmacyServicesLink()             { return pharmacyServicesLink; }
    public WebElement getTransferPrescriptionsLink()        { return transferPrescriptionsLink; }
    public WebElement getMailOrderPharmacyLink()            { return mailOrderPharmacyLink; }
    public WebElement getDrugFormularyLink()                { return drugFormularyLink; }
    public WebElement getFindADoctorLink()                  { return findADoctorLink; }
    public WebElement getHealthCareServicesLink()           { return healthCareServicesLink; }
    public WebElement getSpecialtyCareLink()                { return specialtyCareLink; }
    public WebElement getBehavioralHealthLink()             { return behavioralHealthLink; }
    public WebElement getEyeCareLink()                      { return eyeCareLink; }
    public WebElement getLocationsLink()                    { return locationsLink; }

    /** Opens the Care Options Page from The Find Care Now Link
     * @return - KPAUICareOptionsPage
     */
    public KPAUICareOptionsPage openFindCareNow() {
        getFindCareNowLink().click();
        return new KPAUICareOptionsPage(driver);
    }

    /** Opens the Pharmacy Services Page from its link
     * @return - KPAUIPharmacyServicesPage
     */
    public KPAUIPharmacyServicesPage openPharmacyServicesPage() {
        getPharmacyServicesLink().click();
        return new KPAUIPharmacyServicesPage(driver);
    }

    /** Opens the Transfers RX Page from its link
     * @return - KPAUITransferRxYourInfoPage
     */
    public KPAUITransferRxYourInfoPage openTransferRxPage() {
        getTransferPrescriptionsLink().click();
        return new KPAUITransferRxYourInfoPage(driver);
    }

    /** Opens Unauthenticated Transfers RX Page
     * @return - KPAUIMemberSignOnPage
     */
    public KPAUIMemberSignOnPage openUnauthenticatedTransferRxPage() {
        getTransferPrescriptionsLink().click();
        return new KPAUIMemberSignOnPage(driver);
    }

    /** Opens the Mail Order Services Page from its Link
     * @return - KPAUIMailOrderServicesPage
     */
    public KPAUIMailOrderServicesPage openMailOrderServicesPage() {
        getMailOrderPharmacyLink().click();
        return new KPAUIMailOrderServicesPage(driver);
    }

    /** Opens the Drug Formulary Page from its Link
     * @return - KPAUIDrugFormularyPage
     */
    public KPAUIDrugFormularyPage openDrugFormularyPage() {
        getDrugFormularyLink().click();
        return new KPAUIDrugFormularyPage(driver);
    }

    /** Opens the Find a Doctor Landing Page from its link
     * @return - KPAUIFindADoctorLandingPage
     */
    public KPAUIFindADoctorLandingPage openFindADoctorPage() {
        getFindADoctorLink().click();
        return new KPAUIFindADoctorLandingPage(driver);
    }

    /** Opens Specialty Care Page from its link
     * @return - KPAUISpecialtyCarePage
     */
    public KPAUISpecialtyCarePage openSpecialtyCarePage() {
        getSpecialtyCareLink().click();
        return new KPAUISpecialtyCarePage(driver);
    }

    /** Opens the Health Care Services Page from its
     * @return - KPAUIHealthCareServicesPage
     */
    public KPAUIHealthCareServicesPage openHealthCareServicesPage() {
        getHealthCareServicesLink().click();
        return new KPAUIHealthCareServicesPage(driver);
    }

    /** Opens Behavioral Health Services Page
     * @return - KPAUIBehavioralHealthServicesPage
     */
    public KPAUIBehavioralHealthServicesPage openBehavioralHealthServicesPage() {
        getBehavioralHealthLink().click();
        return new KPAUIBehavioralHealthServicesPage(driver);
    }

    /** Opens the Eye Care Page
     * @return - KPAUIEyeCarePage
     */
    public KPAUIEyeCarePage openEyeCarePage() {
        getEyeCareLink().click();
        return new KPAUIEyeCarePage(driver);
    }

    /** Opens the ClinicLocations Page from the Locations Link
     * @return - KPAUIClinicLocationsPage
     */
    public KPAUIClinicLocationsPage openLocationsPage() {
        getLocationsLink().click();
        return new KPAUIClinicLocationsPage(driver);
    }
}
