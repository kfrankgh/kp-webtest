package org.ghc.tests.pages;

import org.ghc.pages.KPAUIBenefitsUsagePage;
import org.ghc.utils.KPAUICredentials;
import org.ghc.utils.extensions.KPAUIEveryTest;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;
import java.util.List;
import java.lang.reflect.Method;

import static org.ghc.utils.KPAUICredentials.accountName.EVERYTHING;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class KPAUIBenefitsUsageStatusTests extends KPAUIEveryTest {
    private KPAUIBenefitsUsagePage benefitsUsagePage;
    private KPAUICredentials.accountName accountName = EVERYTHING;

    @BeforeMethod(alwaysRun = true)
    public void beforeTest(Method method) {
        benefitsUsagePage = super.initializeTest(method)
                    .signIn(accountName)
                    .openCoverageCostsShade().openBenefitsUsageStatusPage();
    }

    //------------------------------------------------------------------------------------------------------------------

    @Test(description = "Verify the Member Services link opens the correct page. Verify the Glossary of Health Plan" +
            " Terms link opens the correct page", groups = {"smoke", "qa", "prod"})
    public void validateKPMemberServicesLinkAndHealthPlanGlossaryLinkClicks() {
        benefitsUsagePage.clickMemberServicesLink();
        driver.navigate().back();
        benefitsUsagePage.openGlossaryOfHealthPlansTermsLink();
    }

    @Test(description = "Verify the Benefits Usage Status info displays for each of the Benefit Types", groups = {"qa", "prod"})
    public void validateBenefitsUsageStatusForAllBenefitTypes(){
        assertFalse(benefitsUsagePage.getYearDropdown().getOptions().isEmpty(), "Year dropdown is empty.");
        String year = benefitsUsagePage.selectAnyYear();

        List<WebElement> benefits = benefitsUsagePage.getBenefitDropdownOptions();
        assertTrue(benefits.size() != 0);

        for(int i = 0; i < benefits.size(); i++){
            String selectedBenefit = benefitsUsagePage.selectBenefit(i);
            if (selectedBenefit.contentEquals("Select a Benefit")){
                continue;
            }

            System.out.println(String.format("Selected year: %s. Selected benefit: %s", year, selectedBenefit));

            String selectedBenefitText = String.format("%s %s", year, selectedBenefit);
            String actualBenefitText = benefitsUsagePage.getBenefitTypeText().getText();
            assertEquals(actualBenefitText, selectedBenefitText);

            List<WebElement> benefitsUsageTables = benefitsUsagePage.getBenefitsUsageTables();
            assertTrue(benefitsUsageTables.size() != 0);

            for(WebElement table: benefitsUsageTables){
                assertTrue(benefitsUsagePage.groupNameIsCorrect(table), "Group Name is not displayed correctly.");
                assertTrue(benefitsUsagePage.groupNumberIsCorrect(table), "Group Number is not displayed correctly.");
                assertTrue(benefitsUsagePage.contractNumberIsCorrect(table), "Contract Number is not displayed correctly.");
                assertTrue(benefitsUsagePage.benefitPeriodIsCorrect(table), "Benefit Period is not displayed correctly.");
                assertTrue(benefitsUsagePage.timesUsedIsCorrect(table), "Times used is not displayed correctly.");
                assertTrue(benefitsUsagePage.usageMaximumIsCorrect(table), "Usage maximum is not displayed correctly.");
                assertTrue(benefitsUsagePage.remainingUsageIsCorrect(table), "Remaining usage is not displayed correctly.");
                assertTrue(benefitsUsagePage.tableTitleIsCorrect(table), "Table title is not displayed correctly.");
                assertTrue(benefitsUsagePage.getUsageMaximum(table).isDisplayed(), "Usage Progress bar is not displayed.");
            }
        }
    }

    @Test(description = "Verify static text is displayed: Disclaimer, page title, introductory text under title," +
            " table labels(group name, group #, contract #)", groups = {"qa", "prod"})
    public void staticTextIsDisplayed(){
        assertFalse(benefitsUsagePage.getYearDropdown().getOptions().isEmpty(), "Year dropdown is empty.");
        String year = benefitsUsagePage.selectAnyYear();
        String benefit = benefitsUsagePage.selectBenefit(1);
        assertFalse(benefit.isEmpty(), "Could not select option from benefit dropdown.");
        System.out.println(String.format("Selected year: %s. Selected benefit: %s", year, benefit));

        WebElement disclaimerHeader = benefitsUsagePage.getDisclaimerHeader();
        assertTrue(disclaimerHeader.isDisplayed());
        assertFalse(disclaimerHeader.getText().isEmpty());

        WebElement disclaimer = benefitsUsagePage.getDisclaimerText();
        assertTrue(disclaimer.isDisplayed());
        assertFalse(disclaimer.getText().isEmpty());

        WebElement pageTitle = benefitsUsagePage.getBenefitsUsageStatusTitle();
        assertTrue(pageTitle.isDisplayed());
        assertFalse(pageTitle.getText().isEmpty());

        WebElement text = benefitsUsagePage.getBenefitsUsageStatusIntroText();
        assertTrue(text.isDisplayed());
        assertFalse(text.getText().isEmpty());

        List<WebElement> benefitUsageStatusTables = benefitsUsagePage.getBenefitsUsageTables();
        assertTrue(benefitUsageStatusTables.size() != 0);

        for(WebElement table:benefitUsageStatusTables) {
            WebElement groupNameLabel = benefitsUsagePage.getGroupNameLabel(table);
            assertTrue(groupNameLabel.isDisplayed());
            assertFalse(groupNameLabel.getText().isEmpty());

            WebElement groupNumberLabel = benefitsUsagePage.getGroupNumberLabel(table);
            assertTrue(groupNumberLabel.isDisplayed());
            assertFalse(groupNumberLabel.getText().isEmpty());

            WebElement contractNumberLabel = benefitsUsagePage.getContractNumberLabel(table);
            assertTrue(contractNumberLabel.isDisplayed());
            assertFalse(contractNumberLabel.getText().isEmpty());
        }
    }
}