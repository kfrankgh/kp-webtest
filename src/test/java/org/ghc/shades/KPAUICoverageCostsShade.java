package org.ghc.shades;

import org.ghc.pages.*;
import org.ghc.utils.extensions.KPAUIEveryShade;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.ghc.utils.helpers.KPAUITestHelper.*;
import static org.testng.Assert.fail;

public class KPAUICoverageCostsShade extends KPAUIEveryShade {

    public KPAUICoverageCostsShade(WebDriver driver) {
        super(driver);
        if (!isCurrent())
            fail("Coverage & Costs shade is not visible");
    }

    private boolean isCurrent(){
        return getBillsSubHeader().isDisplayed() &&
                    getBenefitsSubHeader().isDisplayed() &&
                    getClaimsSubHeader().isDisplayed();
    }

    //------------------------------------------------------------------------------------------------------------------
    public static final String BILLS_SUBHEADER =                "Bills";
    public static final String BENEFITS_SUBHEADER =             "Benefits";
    public static final String CLAIMS_SUBHEADER =               "Claims";
    public static final String PAY_MY_BILL =                    "Pay My Bill";
    public static final String PAST_PAYMENTS =                  "Past Payments";
    public static final String FINANCIAL_ASSISTANCE =           "Financial Assistance";
    public static final String COVERAGE_DOCUMENTS =             "Coverage Documents";
    public static final String EXPLANATION_OF_BENEFITS =        "Explanation of Benefits";
    public static final String BENEFITS_USAGE_STATUS =          "Benefits Usage Status";
    public static final String SUBMIT_CLAIM =                   "Submit a Claim";
    public static final String HOW_TO_SUBMIT_CLAIMS_ =          "How to Submit Claims";
    public static final String COVERAGE_CLAIMS_APPEALS =        "Coverage & Claims Appeals";

    @FindBy(xpath = "//div/div[1]/div[1]/p[1]")                 private WebElement billsSubHeader;
    @FindBy(xpath = "//div/div[1]/div[1]/p[2]")                 private WebElement benefitsSubHeader;
    @FindBy(xpath = "//div/div[1]/div[2]/p")                    private WebElement claimsSubHeader;
    @FindBy(xpath = "//div/div[1]/div[1]/ul[1]/li[1]/a")        private WebElement payMyBillsLink;
    @FindBy(xpath = "//div/div[1]/div[1]/ul[1]/li[2]/a")        private WebElement pastPaymentsLink;
    @FindBy(xpath = "//div/div[1]/div[1]/ul[1]/li[3]/a")        private WebElement financialAssistanceLink;
    @FindBy(xpath = "//div/div[1]/div[1]/ul[2]/li[1]/a")        private WebElement coverageDocumentsLink;
    @FindBy(xpath = "//div/div[1]/div[1]/ul[2]/li[2]/a")        private WebElement explanationOfBenefitsLink;
    @FindBy(xpath = "//div/div[1]/div[1]/ul[2]/li[3]/a")        private WebElement benefitsUsageStatusLink;
    @FindBy(xpath = "//div/div[1]/div[2]/ul/li[1]/a")           private WebElement submitAClaimLink;
    @FindBy(xpath = "//div/div[1]/div[2]/ul/li[2]/a")           private WebElement howToSubmitAClaimLink;
    @FindBy(xpath = "//div/div[1]/div[2]/ul/li[3]/a")           private WebElement coverageClaimsAppeals;

    public WebElement getBillsSubHeader()                       { return waitForElement(billsSubHeader, driver); }
    public WebElement getBenefitsSubHeader()                    { return benefitsSubHeader; }
    public WebElement getClaimsSubHeader()                      { return claimsSubHeader; }
    public WebElement getPayMyBillsLink()                       { return payMyBillsLink; }
    public WebElement getPastPaymentsLink()                     { return pastPaymentsLink; }
    public WebElement getFinancialAssistanceLink()              { return financialAssistanceLink; }
    public WebElement getCoverageDocumentsLink()                { return coverageDocumentsLink; }
    public WebElement getExplanationOfBenefitsLink()            { return explanationOfBenefitsLink; }
    public WebElement getBenefitsUsageStatusLink()              { return benefitsUsageStatusLink; }
    public WebElement getSubmitAClaimLink()                     { return submitAClaimLink; }
    public WebElement getHowToSubmitAClaimLink()                { return howToSubmitAClaimLink; }
    public WebElement getCoverageClaimsAppeals()                { return coverageClaimsAppeals; }

    /** Opens the Benefits Usage Status Page from the its link
     * @return - KPAUIBenefitsUsagePage
     */
    public KPAUIBenefitsUsagePage openBenefitsUsageStatusPage() {
        getBenefitsUsageStatusLink().click();
        return new KPAUIBenefitsUsagePage(driver);
    }

    /** Opens the Coverage Documents Page
     * @return - KPAUICoverageDocumentsPage
     */
    public KPAUICoverageDocumentsPage openCoverageDocumentsPage() {
        getCoverageDocumentsLink().click();
        return new KPAUICoverageDocumentsPage(driver);
    }

    /** Opens the Financial Assistance Page from its link
     * @return - KPAUIFinancialAssistancePage
     */
    public KPAUIFinancialAssistancePage openFinancialAssistancePage() {
        getFinancialAssistanceLink().click();
        WebDriver drv = getChildDriver(driver);
        return new KPAUIFinancialAssistancePage(drv);
    }

    /** Opens the Explanation of Benefits Page from its Link
     * @return - KPAUIExplanationOfBenefitsPage
     */
    public KPAUIExplanationOfBenefitsPage openBenefitsExplanationPage() {
        getExplanationOfBenefitsLink().click();
        return new KPAUIExplanationOfBenefitsPage(driver);
    }

    /** Opens the Billing Statements Page from the Past Payments Link
     * @return - KPAUIBillingStatementsPage
     */
    public KPAUIBillingStatementsPage openPastPaymentsLink() {
        getPastPaymentsLink().click();
        return new KPAUIBillingStatementsPage(driver);
    }

    /** Opens the Submit a Claim Page from its Link
     * @return - KPAUISubmitClaimPage
     */
    public KPAUISubmitClaimPage openSubmitClaimPage() {
        getSubmitAClaimLink().click();
        return new KPAUISubmitClaimPage(driver);
    }

    /** Opens How to Submit A Claims Page from its Link
     * @return - KPAUISubmitClaimPage
     */
    public KPAUIHowToSubmitClaimPage openHowToSubmitAClaimPage() {
        getHowToSubmitAClaimLink().click();
        return new KPAUIHowToSubmitClaimPage(driver);
    }

    /** Opens the Coverage Claims and Appeals Page from the "Coverage Claims Appeals" Link
     * @return - KPAUICoverageAndClaimsAppealsPage
     */
    public KPAUICoverageAndClaimsAppealsPage openCoverageClaimsAppealsPage() {
        getCoverageClaimsAppeals().click();
        return new KPAUICoverageAndClaimsAppealsPage(driver);
    }

    /** Opens the Billing Statements page from the "Pay My Bills" Link
     * @return - KPAUIBillingStatementsPage
     */
    public KPAUIBillingStatementsPage openPayMyBillPage() {
        getPayMyBillsLink().click();
        return new KPAUIBillingStatementsPage(driver);
    }
}
