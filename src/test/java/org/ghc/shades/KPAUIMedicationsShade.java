package org.ghc.shades;

import org.ghc.pages.*;
import org.ghc.utils.extensions.KPAUIEveryShade;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.ghc.utils.helpers.KPAUITestHelper.waitForElement;
import static org.testng.Assert.fail;

public class KPAUIMedicationsShade extends KPAUIEveryShade {

    public KPAUIMedicationsShade(WebDriver driver) {
        super(driver);
        if (!isCurrent())
            fail("Medications shade is not visible");
    }

    private boolean isCurrent() {
        return getPrescriptionsHeader().isDisplayed() &&
                getPharmacyHeader().isDisplayed();
    }

    //------------------------------------------------------------------------------------------------------------------

    public static final String PRESCRIPTIONS_SUBHEADER =        "Prescriptions";
    public static final String PHARMACY_SUBHEADER =             "Pharmacy";
    public static final String MEDICATIONS_REFILL_STATUS =      "Medications (Refill & Order Status)";
    public static final String TRANSFER_PRESCRIPTIONS =         "Transfer Prescriptions";
    public static final String PHARMACY_SERVICES =              "Pharmacy Services";
    public static final String MAIL_ORDER_PHARMACY =            "Mail Order Pharmacy";
    public static final String DRUG_FORMULARY =                 "Drug Formulary";


    @FindBy(xpath = "//div/div[1]/div[1]/p")                    private WebElement prescriptionsHeader;
    @FindBy(xpath = "//div/div[1]/div[2]/p")                    private WebElement pharmacyHeader;
    @FindBy(xpath = "//div/div[1]/div[1]/ul/li[1]/a")           private WebElement medicationsRefillOrderLink;
    @FindBy(xpath = "//div/div[1]/div[1]/ul/li[2]/a")           private WebElement transferPrescriptionsLink;
    @FindBy(xpath = "//div/div[1]/div[2]/ul/li[1]/a")           private WebElement pharmacyServicesLink;
    @FindBy(xpath = "//div/div[1]/div[2]/ul/li[2]/a")           private WebElement mailOrderPharmacyLink;
    @FindBy(xpath = "//div/div[1]/div[2]/ul/li[3]/a")           private WebElement drugFormularyLink;

    public WebElement getPrescriptionsHeader()                  { return waitForElement(prescriptionsHeader, driver); }
    public WebElement getPharmacyHeader()                       { return pharmacyHeader; }
    public WebElement getMedicationsRefillOrderLink()           { return medicationsRefillOrderLink; }
    public WebElement getTransferPrescriptionsLink()            { return transferPrescriptionsLink; }
    public WebElement getPharmacyServicesLink()                 { return pharmacyServicesLink; }
    public WebElement getMailOrderPharmacyLink()                { return mailOrderPharmacyLink; }
    public WebElement getDrugFormularyLink()                    { return drugFormularyLink; }

    /** Opens the Medications Page from the "Medications Refill Order" Link
     * @return - KPAUIMedicationsPage
     */
    public KPAUIMedicationsPage openMedicationsPage() {
        getMedicationsRefillOrderLink().click();
        return new KPAUIMedicationsPage(driver);
    }

    /** Opens the Transfer Prescriptions Page from the Link
     * @return - KPAUITransferRxYourInfoPage
     */
    public KPAUITransferRxYourInfoPage openTransferRxYourInfoPage() {
        getTransferPrescriptionsLink().click();
        return new KPAUITransferRxYourInfoPage(driver);
    }

    /** Opens the Pharmacy Service Page from its Link
     * @return - KPAUIPharmacyServicesPage
     */
    public KPAUIPharmacyServicesPage openPharmacyServicesPage() {
        getPharmacyServicesLink().click();
        return new KPAUIPharmacyServicesPage(driver);
    }

    /** Opens the Mail Order Services page
     * @return - KPAUIMailOrderServicesPage
     */
    public KPAUIMailOrderServicesPage openMailOrderServicesPage() {
        getMailOrderPharmacyLink().click();
        return new KPAUIMailOrderServicesPage(driver);
    }

    /** Opens the Drug Formulary Page from the Link
     * @return - KPAUIDrugFormularyPage
     */
    public KPAUIDrugFormularyPage openDrugFormularyPage() {
        getDrugFormularyLink().click();
        return new KPAUIDrugFormularyPage(driver);
    }
}
