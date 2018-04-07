package org.ghc.pages;

import org.ghc.utils.extensions.KPAUIEveryAuthenticatedPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static org.ghc.utils.KPAUIPageConstants.BenefitsUsageStatusAndCovDocsPage.*;
import static org.ghc.utils.helpers.KPAUITestHelper.*;
import static org.openqa.selenium.By.cssSelector;
import static org.testng.Assert.fail;


public class KPAUIBenefitsUsagePage extends KPAUIEveryAuthenticatedPage {

    public KPAUIBenefitsUsagePage(WebDriver driver) {
        super(driver);
        if (!isCurrent(driver, PAGETITLE_BENEFITS_USAGE))
            fail("The Benefits Usage Status Page did not load correctly");
    }

    //------------------------------------------------------------------------------------------------------------------
    private static final String PAGETITLE_BENEFITS_USAGE = "Benefits Usage Status";
    private final String dollarsRegex = "\\$(\\d+,?)?\\d+,?\\d*\\.?\\d{0,2}";

    // Finders
    @FindBy(css = "#type-combo")                        private WebElement benefitTypeDropdown;
    @FindBy(css = "#cat-header")                        private WebElement benefitTypeText;
    @FindBy(css = ".div-table-overview")                private List<WebElement> benefitsUsageStatusTables;
    @FindBy(css = ".intro")                             private WebElement benefitsUsageStatusIntroText;
    @FindBy(css = ".ghContent h1")                      private WebElement benefitsUsageStatusTitle;
    @FindBy(css = "detail-overview #div-contract-data") private WebElement contractNumber;
    @FindBy(css = ".info-header")                       private WebElement disclaimerHeader;
    @FindBy(css = ".first")                             private WebElement disclaimerText;
    @FindBy(partialLinkText = "Glossary")               private WebElement healthPlanTermsLink;
    @FindBy(linkText = "Member Services")               private WebElement memberServicesLink;
    @FindBy(id = "year-combo")                          private WebElement yearDropdown;

    // Getters
    private WebElement getBenefitTypeDropdown()                             { return waitForElementToBeClickable(benefitTypeDropdown, driver); }
    public  WebElement getBenefitTypeText()                                 { return waitForElement(benefitTypeText, driver); }
    private WebElement getHealthPlansTermsLink()                            { return waitForElementToBeClickable(healthPlanTermsLink, driver); }
    private WebElement getBenefitPeriod(WebElement benefitsUsageTable)      { return benefitsUsageTable.findElement(cssSelector(".div-period-col")); }
    public  WebElement getBenefitsUsageStatusTitle()                        { return waitForElement(benefitsUsageStatusTitle, driver); }
    public  List<WebElement> getBenefitsUsageTables()                       { return benefitsUsageStatusTables; }
    private WebElement getContractNumber(WebElement benefitsUsageTable)     { return waitForElement(benefitsUsageTable.findElement(cssSelector("detail-overview #div-contract-data")), driver); }
    public  WebElement getContractNumberLabel(WebElement benefitsUsageTable){ return waitForElement(benefitsUsageTable.findElement(cssSelector("detail-overview .div-header-col-2w:nth-last-of-type(2)")), driver); }
    public  WebElement getDisclaimerText()                                  { return waitForElement(disclaimerText, driver); }
    public  WebElement getDisclaimerHeader()                                { return waitForElement(disclaimerHeader, driver); }
    private WebElement getGroupName(WebElement benefitsUsageTable)          { return benefitsUsageTable.findElement(cssSelector("#div-grp-data")); }
    public  WebElement getGroupNameLabel(WebElement benefitsUsageTable)     { return benefitsUsageTable.findElement(cssSelector("detail-overview .div-header-col-2w:first-of-type")); }
    private WebElement getGroupNumber(WebElement benefitsUsageTable)        { return benefitsUsageTable.findElement((cssSelector("detail-overview #div-grpno-data"))); }
    public  WebElement getGroupNumberLabel(WebElement benefitsUsageTable)   { return benefitsUsageTable.findElement(cssSelector(".div-table .div-header-col")); }
    private WebElement getMemberServicesLink()                              { return waitForElementToBeClickable(memberServicesLink, driver); }
    private WebElement getRemainingUsage(WebElement benefitsUsageTable)     { return benefitsUsageTable.findElement(cssSelector(".div-remaining-col")); }
    private WebElement getTableTitle(WebElement benefitsUsageTable)         { return benefitsUsageTable.findElement(cssSelector(".bene-use-header")); }
    public  WebElement getBenefitsUsageStatusIntroText()                    { return benefitsUsageStatusIntroText; }
    private WebElement getTimesUsed(WebElement benefitsUsageTable)          { return benefitsUsageTable.findElement(cssSelector(".div-used-col")); }
    public WebElement getUsageMaximum(WebElement benefitsUsageTable)        { return benefitsUsageTable.findElement(cssSelector(".div-max-col")); }
    public Select getYearDropdown()                                         { return new Select(yearDropdown); }

    // Methods
    public List<WebElement> getBenefitDropdownOptions(){
        Select dropdown = new Select(getBenefitTypeDropdown());
        List<WebElement> options;
        long startTime = System.currentTimeMillis();

        do{
            sleep(1);
            options = dropdown.getOptions();

        }while ((options.size() <= 1) && ((System.currentTimeMillis() - startTime) < 5000));

        return options;
    }

    public KPAUIMemberServicesPage clickMemberServicesLink() {
        getMemberServicesLink().click();
        return new KPAUIMemberServicesPage(driver);
    }

    public KPAUIHealthPlanTermsGlossaryPage openGlossaryOfHealthPlansTermsLink(){
        getHealthPlansTermsLink().click();
        return new KPAUIHealthPlanTermsGlossaryPage(driver);
    }

    public String selectBenefit(int optionIndex){
        List<WebElement> options = getBenefitDropdownOptions();
        if( options.size() < (optionIndex + 1) ){
            return "";
        }
        WebElement option = getBenefitDropdownOptions().get(optionIndex);
        option.click();
        return option.getText();
    }

    public String selectAnyYear(){
        Select dropdown = getYearDropdown();
        dropdown.selectByIndex(0);
        return dropdown.getFirstSelectedOption().getText();
    }

    public boolean benefitPeriodIsCorrect(WebElement benefitsUsageTable){
        WebElement benefitPeriod = getBenefitPeriod(benefitsUsageTable);
        return (benefitPeriod.isDisplayed() && benefitPeriod.getText()
                .matches("^Benefit Period: \\d{2}/\\d{2}/\\d{4} - \\d{2}/\\d{2}/\\d{4}$"));
    }

    public boolean contractNumberIsCorrect(WebElement benefitsUsageTable){
        WebElement contractNumber = getContractNumber(benefitsUsageTable);
        return (contractNumber.isDisplayed() && contractNumber.getText().matches("^[a-zA-Z\\d]+$"));
    }

    public boolean groupNameIsCorrect(WebElement benefitsUsageTable){
        WebElement groupName = getGroupName(benefitsUsageTable);
        return (groupName.isDisplayed() && groupName.getText().matches(groupNameRegex));
    }

    public boolean groupNumberIsCorrect(WebElement benefitsUsageTable){
        WebElement groupNumber = getGroupNumber(benefitsUsageTable);
        return (groupNumber.isDisplayed() && groupNumber.getText().matches(groupNumberRegex));
    }

    public boolean remainingUsageIsCorrect(WebElement benefitsUsageTable){
        WebElement remainingUsage = getRemainingUsage(benefitsUsageTable);
        return (remainingUsage.isDisplayed() && remainingUsage.getText()
                .matches("(^\\d+ remaining$)|((^" + dollarsRegex + " remaining$))"));
    }

    public boolean tableTitleIsCorrect(WebElement benefitsUsageTable){
        WebElement tableTitle = getTableTitle(benefitsUsageTable);
        return (tableTitle.isDisplayed() && !tableTitle.getText().isEmpty());
    }

    public boolean timesUsedIsCorrect(WebElement benefitsUsageTable){
        WebElement timesUsed = getTimesUsed(benefitsUsageTable);
        return (timesUsed.isDisplayed() && timesUsed.getText()
                .matches( "(^\\d+ used$)|(^" + dollarsRegex + " used$)"));
    }

    public boolean usageMaximumIsCorrect(WebElement benefitsUsageTable){
        WebElement usageMaximum = getUsageMaximum(benefitsUsageTable);
        return (usageMaximum.isDisplayed() && usageMaximum.getText()
                .matches("(^\\d+ maximum$)|(^" + dollarsRegex + " maximum$)"));
    }
}
