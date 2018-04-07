package org.ghc.cards;

import org.ghc.pages.KPAUIBillingStatementsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.ghc.utils.helpers.KPAUITestHelper.waitForElement;
import static org.ghc.utils.helpers.KPAUITestHelper.waitForElementToBeClickable;
import static org.testng.Assert.fail;

public class KPAUIMedicalBillsCard {
    private WebDriver driver;

    public KPAUIMedicalBillsCard(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
        if (!isCurrent())
            fail("Medical Bills and Claims card is not visible");
    }

    private boolean isCurrent() {
        return getMedicalBillsCardHeader().isDisplayed();
    }

    //------------------------------------------------------------------------------------------------------------------
    private static final String header =                            "Medical Bills";
    private static final String payBill =                           "PAY BILL";
    private static final String balanceDue =                        "Balance Due";
    private static final String balanceRegex =                      "\\$\\d+.\\d{2}";
    private static final String cardPrefix1 =                       "//kp-finance-card/core-card/div/div[1]/div";
    private static final String cardPrefix2 =                       "//kp-finance-card/core-card/div/div[2]/div";

    @FindBy(xpath = cardPrefix2 + "/div/div[1]/div[2]")             private WebElement balance;
    @FindBy(xpath = cardPrefix2 + "/div/div[1]/div[1]")             private WebElement balanceLabel;
    @FindBy(xpath = cardPrefix2 + "/div/div[2]/core-link/a/img")    private WebElement billPayIcon;
    @FindBy(xpath = cardPrefix2 + "/div/div[2]/core-link/a")        private WebElement billPayLink;
    @FindBy(xpath = cardPrefix1 + "/img")                           private WebElement healthCoverageArrow;
    @FindBy(xpath = cardPrefix1 + "/h4")                            private WebElement healthCoverageHeader;

    private WebElement getMedicalBillsCardBalance()                 { return waitForElement(balance, driver); }
    private WebElement getMedicalBillsCardBalanceLabel()            { return waitForElement(balanceLabel, driver); }
    private WebElement getMedicalBillsCardHeader()                  { return waitForElementToBeClickable(healthCoverageHeader, driver); }
    private WebElement getMedicalBillsCardHeaderArrow()             { return waitForElement(healthCoverageArrow, driver); }
    private WebElement getMedicalBillsCardPayBillIcon()             { return waitForElement(billPayIcon, driver); }
    private WebElement getMedicalBillsCardPayBillLink()             { return waitForElementToBeClickable(billPayLink, driver); }

    /** Opens the Billing Statements page from the "Pay Bill" Link
     * @return - The Billing Statements Page (KPAUIBillingStatementsPage)
     */
    public KPAUIBillingStatementsPage openBillingStatementsFromPayBillLink() {
        getMedicalBillsCardPayBillLink().click();
        return new KPAUIBillingStatementsPage(driver);
    }

    /** Opens the Billing Statements page from "Medical Bills" header
     * @return - The Billing Statements Page (KPAUIBillingStatementsPage)
     */
    public KPAUIBillingStatementsPage openOnlineBillPayPage() {
        getMedicalBillsCardHeader().click();
        return new KPAUIBillingStatementsPage(driver);
    }

    /** Verifies that the "Balance Due" text is correct and the dollar amount is in the right format
     * @return - True if both conditions are met
     */
    public boolean verifyBalanceDueLabelAndAmount() {
        return getMedicalBillsCardBalanceLabel().getText().equals(balanceDue) &&
                getMedicalBillsCardBalance().getText().matches(balanceRegex);
    }

    /** Verifies that the "Medical Bills" Header and Arrow are displayed
     * @return - True if both conditions are met
     */
    public boolean verifyMedicalBillsHeaderAndArrow() {
        return getMedicalBillsCardHeaderArrow().isDisplayed() &&
                getMedicalBillsCardHeader().getText().equals(header);
    }

    /** Verifies that the "Pay Bill" link text and the icon are correct
     * @return - True if both conditions are met
     */
    public boolean verifyPayBillLinkTextAndIcon() {
        return getMedicalBillsCardPayBillIcon().isDisplayed() &&
                getMedicalBillsCardPayBillLink().getText().equals(payBill);
    }
}