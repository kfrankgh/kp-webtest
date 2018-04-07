package org.ghc.cards;

import org.ghc.pages.KPAUIMailOrderServicesPage;
import org.ghc.pages.KPAUIMedicationsPage;
import org.ghc.pages.KPAUITransferRxYourInfoPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.ghc.utils.helpers.KPAUITestHelper.waitForElement;
import static org.ghc.utils.helpers.KPAUITestHelper.waitForElementToBeClickable;
import static org.testng.Assert.fail;

public class KPAUIMedicationsCard {
    private WebDriver driver;

    public KPAUIMedicationsCard(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        if (!isCurrent())
            fail("Medications card is not visible");
    }

    public boolean isCurrent() {
        return getMedicationsCardHeader().isDisplayed();
    }

    //------------------------------------------------------------------------------------------------------------------
    private static final String header =                                "Medications";
    private static final String noMedications =                         "You have no medications.";
    private static final String cardPrefix1 =                           "//kp-medications-card/core-card/div/div[1]/div";
    private static final String cardPrefix2 =                           "//kp-medications-card/core-card/div/div[2]/div";
    private static final String orderStatus =                           "ORDER STATUS";
    private static final String seeAllMedications =                     "SEE ALL MEDICATIONS";
    private static final String transferPrescriptions =                 "TRANSFER PRESCRIPTIONS";

    @FindBy(xpath = cardPrefix1 + "/img")                               private WebElement medicationsArrow;
    @FindBy(xpath = cardPrefix1 + "/h4")                                private WebElement medicationsHeader;
    @FindBy(xpath = cardPrefix2 + "/div/div[1]/div[2]")                 private WebElement brandName;
    @FindBy(xpath = cardPrefix2 + "/div/div[1]/div[1]")                 private WebElement genericName;
    @FindBy(xpath = cardPrefix2 + "/div/div[1]/div[3]")                 private WebElement doseInstructions;
    @FindBy(xpath = cardPrefix2 + "/div/div[1]/div[4]")                 private WebElement prescribedDate;
    @FindBy(xpath = cardPrefix2 + "/div/div[1]")                        private WebElement noMedicationsMessage;
    @FindBy(xpath = cardPrefix2 + "/div/div[2]/core-link/a")            private WebElement seeAllMedicationsButton;
    @FindBy(xpath = cardPrefix2 + "/div/div[2]/core-link/a/img")        private WebElement seeAllMedicationsButtonIcon;
    @FindBy(xpath = cardPrefix2 + "/div/div[3]/core-link/a")            private WebElement orderStatusLink;
    @FindBy(xpath = cardPrefix2 + "/div/div[3]/core-link/a/img")        private WebElement orderStatusIcon;
    @FindBy(xpath = cardPrefix2 + "/div/div[2]/core-router-link/a")     private WebElement transferPerscriptionLink;
    @FindBy(xpath = cardPrefix2 + "/div/div[2]/core-router-link/a/img") private WebElement transferPerscriptionIcon;

    public WebElement getMedicationBrandName()                          { return waitForElement(brandName, driver); }
    private WebElement getMedicationsCardArrow()                        { return waitForElement(medicationsArrow, driver); }
    private WebElement getMedicationsCardHeader()                       { return waitForElementToBeClickable(medicationsHeader, driver); }
    public WebElement getMedicationDatePrescribed()                     { return waitForElement(prescribedDate, driver); }
    public WebElement getMedicationsDoseInstructions()                  { return waitForElement(doseInstructions, driver); }
    public WebElement getMedicationGenericName()                        { return waitForElement(genericName, driver); }
    private WebElement getNoMedicationsMessage()                        { return waitForElement(noMedicationsMessage, driver); }
    private WebElement getOrderStatusLink()                             { return waitForElementToBeClickable(orderStatusLink, driver); }
    private WebElement getOrderStatusIcon()                             { return waitForElement(orderStatusIcon, driver); }
    private WebElement getSeeAllMedications()                           { return waitForElementToBeClickable(seeAllMedicationsButton, driver); }
    private WebElement getSeeAllMedicationsIcon()                       { return waitForElement(seeAllMedicationsButton, driver); }
    private WebElement getTransferPrescriptionLink()                    { return waitForElementToBeClickable(transferPerscriptionLink, driver); }
    private WebElement getTransferPrescriptionIcon()                    { return waitForElement(transferPerscriptionIcon, driver); }


    /** Opens the "Medications" Page from the card header
     * @return - Medications Page (KPAUIMedicationsPage)
     */
    public KPAUIMedicationsPage openMedicationsPageFromHeader() {
        getMedicationsCardHeader().click();
        return new KPAUIMedicationsPage(driver);
    }

    /** Opens the "Medications" Page from the order status link
     * @return - Medications Page (KPAUIMedicationsPage)
     */
    public KPAUIMedicationsPage openMedicationsPageFromOrderStatus() {
        getOrderStatusLink().click();
        return new KPAUIMedicationsPage(driver);
    }

    /** Opens the "Medications" Page from the card header
     * @return - Medications Page (KPAUIMedicationsPage)
     */
    public KPAUIMedicationsPage openSeeAllMedications() {
        getSeeAllMedications().click();
        return new KPAUIMedicationsPage(driver);
    }

    /** Opens the "Transfer Prescriptions" Page from the Transfer Prescriptions Link
     * @return - Transfer Prescriptions (KPAUITransferRxYourInfoPage)
     */
    public KPAUITransferRxYourInfoPage openTransferPrescriptions() {
        getTransferPrescriptionLink().click();
        return new KPAUITransferRxYourInfoPage(driver);
    }

    /** Verifies that the card Header text matches "Medications"
     * @return - True if the text is correct
     */
    public boolean verifyMedicationsCardHeaderText() {
        return getMedicationsCardArrow().isDisplayed() &&
                getMedicationsCardHeader().getText().matches(header);
    }

    /** Verifies that if no medications are present, that a "No Medications" message is displayed.
     * @return - True if the message is visible and correct
     */
    public boolean verifyNoMedicationsMessage() {
        return getNoMedicationsMessage().getText().equals(noMedications);
    }

    /** Verifies that the "Order Status" link text and the icon are correct
     * @return - True if both conditions are met
     */
    public boolean verifyOrderStatusTextAndIcon() {
        return getOrderStatusIcon().isDisplayed() &&
                getOrderStatusLink().getText().equals(orderStatus);
    }

    /** Verifies that the "See All Medications" link text and the icon are correct
     * @return - True if both conditions are met
     */
    public boolean verifySeeAllMedicationsTextAndIcon() {
        return getSeeAllMedicationsIcon().isDisplayed() &&
                getSeeAllMedications().getText().equals(seeAllMedications);
    }

    /** Verifies that the "Transfer Prescription" link text and the icon are correct
     * @return - True if both conditions are met
     */
    public boolean verifyTransferPrescriptionsTextAndIcon() {
        return getTransferPrescriptionIcon().isDisplayed() &&
                getTransferPrescriptionLink().getText().equals(transferPrescriptions);
    }
}
