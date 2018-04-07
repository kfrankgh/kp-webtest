package org.ghc.cards;

import org.ghc.pages.KPAUIBenefitsCoveragePage;
import org.ghc.pages.KPAUIBenefitsPage;
import org.ghc.pages.KPAUIBenefitsUsagePage;
import org.ghc.pages.KPAUIExplanationOfBenefitsPage;
import org.ghc.shades.KPAUIDigitalIDShade;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.ghc.utils.helpers.KPAUITestHelper.waitForElement;
import static org.ghc.utils.helpers.KPAUITestHelper.waitForElementToBeClickable;
import static org.testng.Assert.fail;


public class KPAUIHealthCoverageCard {
    private WebDriver driver;

    public KPAUIHealthCoverageCard(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        if (!isCurrent())
            fail("Health Coverage Card is not visible");
    }

    private boolean isCurrent() {
        return getHealthCoverageHeader().isDisplayed();
    }

    //------------------------------------------------------------------------------------------------------------------
    private static final String benefitsUsage =                     "BENEFITS USAGE STATUS";
    private static final String coverageDocs =                      "COVERAGE DOCUMENTS";
    private static final String cardPrefix1 =                       "//kp-benefits-usage-card/core-card/div/div[1]/div";
    private static final String cardPrefix2 =                       "//kp-benefits-usage-card/core-card/div/div[2]/div";
    private static final String digitalIDCard =                     "DIGITAL ID CARD";
    private static final String explanOfBens =                      "EXPLANATION OF BENEFITS";
    private static final String header =                            "Health Coverage";

    @FindBy(xpath = cardPrefix2 + "/div/div/core-link[2]/a")        private WebElement benefitsExplanationLinkPath;
    @FindBy(xpath = cardPrefix2 + "/div/div/div[2]")                private WebElement benefitsExplanationDesc;
    @FindBy(xpath = cardPrefix2 + "/div/div/core-link[2]/a/img")    private WebElement benefitsExplanationIcon;
    @FindBy(xpath = cardPrefix2 + "/div/div/core-link[3]/a")        private WebElement benefitsUsageLinkPath;
    @FindBy(xpath = cardPrefix2 + "/div/div/div[3]")                private WebElement benefitsUsageDescPath;
    @FindBy(xpath = cardPrefix2 + "/div/div/core-link[3]/a/img")    private WebElement benefitsUsageIconPath;
    @FindBy(xpath = cardPrefix2 + "/div/div/core-link[1]/a")        private WebElement coverageDocumentsLinkPath;
    @FindBy(xpath = cardPrefix2 + "/div/div/div[1]")                private WebElement coverageDocumentsDesc;
    @FindBy(xpath = cardPrefix2 + "/div/div/core-link[1]/a/img")    private WebElement coverageDocumentsIcon;
    @FindBy(xpath = cardPrefix2 + "/div/div/core-digital-card/a")   private WebElement DIDLinkPath;
    @FindBy(xpath = cardPrefix2 + "/div/div/div[1]")                private WebElement DIDDescPath;
    @FindBy(xpath = cardPrefix2 + "/div/div/core-link[1]/a/img")    private WebElement DIDIconPath;
    @FindBy(xpath = cardPrefix1 + "/h4")                            private WebElement healthCoverageHeaderPath;

    private WebElement getBenefitsUsageDescription()                { return waitForElement(benefitsUsageDescPath, driver); }
    private WebElement getBenefitsUsageIcon()                       { return waitForElement(benefitsUsageIconPath, driver); }
    private WebElement getBenefitsUsageLink()                       { return waitForElement(benefitsUsageLinkPath, driver); }
    private WebElement getCoverageDocumentsDescription()            { return waitForElement(coverageDocumentsDesc, driver); }
    private WebElement getCoverageDocumentsIcon()                   { return waitForElement(coverageDocumentsIcon, driver); }
    private WebElement getCoverageDocumentsLink()                   { return waitForElement(coverageDocumentsLinkPath, driver); }
    private WebElement getDigitalIdDescription()                    { return waitForElement(DIDDescPath, driver); }
    private WebElement getDigitalIdIcon()                           { return waitForElement(DIDIconPath, driver); }
    private WebElement getDigitalIdLink()                           { return waitForElementToBeClickable(DIDLinkPath, driver); }
    private WebElement getExplanationOfBenefitsDescription()        { return waitForElement(benefitsExplanationDesc, driver); }
    private WebElement getExplanationOfBenefitsIcon()               { return waitForElement(benefitsExplanationIcon, driver); }
    private WebElement getExplanationOfBenefitsLink()               { return waitForElement(benefitsExplanationLinkPath, driver); }
    private WebElement getHealthCoverageHeader()                    { return waitForElement(healthCoverageHeaderPath, driver); }

    /** Opens the Benefits Usage Page from the Link
     * @return - The Benefits Usage Page (KPAUIBenefitsUsagePage)
     */
    public KPAUIBenefitsUsagePage openBenefitsUsagePage() {
        getBenefitsUsageLink().click();
        return new KPAUIBenefitsUsagePage(driver);
    }

    /** Opens the Benefits Coverage Page from the Link
     * @return - The Benefits Coverage Page (KPAUIBenefitsCoveragePage)
     */
    public KPAUIBenefitsCoveragePage openCoverageDocumentsPage() {
        getCoverageDocumentsLink().click();
        return new KPAUIBenefitsCoveragePage(driver);
    }

    /** Opens the Digital Id Shade from the Link
     * @return - The Digital Id Card (KPAUIDigitalIdShade)
     */
    public KPAUIDigitalIDShade openDigitalIdShade() {
        getDigitalIdLink().click();
        return new KPAUIDigitalIDShade(driver);
    }

    /** Opens the Explanation of Benefits Page
     * @return - The Explanation of Benefits Page (KPAUIExplanationOfBenefitsPage)
     */
    public KPAUIExplanationOfBenefitsPage openExplanationOfBenefitsPage() {
        getExplanationOfBenefitsIcon().click();
        return new KPAUIExplanationOfBenefitsPage(driver);
    }

    /** Verifies the health coverage header is "Health Coverage"
     * @return - The Benefits Page (KPAUIBenefitsPage)
     */
    public boolean verifyHealthCoverageHeader() {
        return getHealthCoverageHeader().getText().matches(header);
    }

    /** Verifies the "Benefits Usage Status" Icon, Link, Description are present
     * @return - True if all conditions are met.
     */
    public boolean verifyBenfitsUsageStatusLinksTexts() {
        return getBenefitsUsageIcon().isDisplayed() &&
                getBenefitsUsageDescription().isDisplayed() &&
                getBenefitsUsageLink().getText().matches(benefitsUsage);
    }

    /** Verifies the "Coverage Documents" Icon, Link, Description are present
     * @return - True if all conditions are met.
     */
    public boolean verifyCoverageDocumentsLinksTexts() {
        return getCoverageDocumentsIcon().isDisplayed() &&
                getCoverageDocumentsDescription().isDisplayed() &&
                getCoverageDocumentsLink().getText().matches(coverageDocs);
    }

    /** Verifies the "Explanation of Benefits" Icon, Link, Description are present
     * @return - True if all conditions are met.
     */
    public boolean verifyExplanationOfBenefitsLinksTexts() {
        return getExplanationOfBenefitsIcon().isDisplayed() &&
                getExplanationOfBenefitsDescription().isDisplayed() &&
                getExplanationOfBenefitsLink().getText().matches(explanOfBens);
    }

    /** Verifies the "Digital ID Card" Icon, Link, Description are present
     * @return - True if all conditions are met.
     */
    public boolean verifyDigitalIDCardLinksTexts() {
        return getDigitalIdIcon().isDisplayed() &&
                getDigitalIdDescription().isDisplayed() &&
                getDigitalIdLink().getText().matches(digitalIDCard);
    }
}
