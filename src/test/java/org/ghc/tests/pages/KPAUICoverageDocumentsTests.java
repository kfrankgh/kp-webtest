package org.ghc.tests.pages;

import org.ghc.pages.KPAUICoverageDocumentsPage;
import org.ghc.utils.KPAUICredentials;
import org.ghc.utils.extensions.KPAUIEveryTest;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.lang.reflect.Method;

import static org.ghc.utils.KPAUICredentials.accountName.EVERYTHING;
import static org.ghc.utils.KPAUIPageConstants.BenefitsUsageStatusAndCovDocsPage.groupNameRegex;
import static org.ghc.utils.KPAUIPageConstants.BenefitsUsageStatusAndCovDocsPage.groupNumberRegex;
import static org.ghc.utils.helpers.KPAUIStringHelper.getOneYearPriorDate;
import static org.ghc.utils.helpers.KPAUITestHelper.errorMsg;
import static org.testng.Assert.*;

public class KPAUICoverageDocumentsTests extends KPAUIEveryTest {
    private KPAUICoverageDocumentsPage coverageDocumentsPage;
    private KPAUICredentials.accountName accountName = EVERYTHING;
    private final String pdfLinkText = "VIEW PDF";

    @BeforeMethod(alwaysRun = true)
    public void beforeTest(Method method) {
        coverageDocumentsPage = super.initializeTest(method)
                    .signIn(accountName)
                    .openCoverageCostsShade().openCoverageDocumentsPage();
    }

    //------------------------------------------------------------------------------------------------------------------

    @Test(description = "Clicking the PDF links under Summary of Benefits opens the pdf", groups = {"smoke", "qa", "prod"})
    public void validateCurrentSummaryOfBenefitsPdfLinkClick() {
        if(!coverageDocumentsPage.areBenefitsDisplayed()) {
            assertFalse(coverageDocumentsPage.selectEnabledBenefitDate().equals(""),
                    "Failed to find a date that displayed Summary of Benefits.");
            }

        List<WebElement> summaryOfBenefitsTableRows = coverageDocumentsPage.getSummaryOfBenefitsTableRows();

        for(WebElement row:summaryOfBenefitsTableRows){
            coverageDocumentsPage.openBenefitPdf(row);
        }
    }

    @Test(description = "Clicking the PDF links under Coverage Agreement opens the pdf", groups = {"smoke", "qa", "prod"})
    public void validateCurrentCoverageAgreementPdfLinkClick(){
        if(!coverageDocumentsPage.areCoverageAgreementsDisplayed()) {
            assertFalse(coverageDocumentsPage.selectEnabledCoverageDate().equals(""),
                    "Failed to find a date that displayed Coverage Agreements docs.");
            }

        List<WebElement> coverageAgreementTableRows = coverageDocumentsPage.getCoverageAgreementTableRows();

        for(WebElement row:coverageAgreementTableRows){
            coverageDocumentsPage.openAgreementPdf(row);
        }
    }

    @Test(description = "Selecting date in the datepicker displays Summary of Benefits coverage documents for that date", groups = {"smoke", "qa", "prod"})
    public void validateBenefitsDocumentsDisplayViaDataPicker(){
        String daySelected = coverageDocumentsPage.selectEnabledBenefitDate();
        assertFalse(daySelected.equals(""), "Failed to find a date that displayed Summary of Benefits.");
        String expectedDate = coverageDocumentsPage.getFullDate(daySelected);
        assertTrue(coverageDocumentsPage.selectedBenefitsDateDisplaysOnPage(expectedDate),
        "Selected Benefits Date is not displayed.");

        List<WebElement> summaryOfBenefitsTableRows = coverageDocumentsPage.getSummaryOfBenefitsTableRows();

        for(WebElement row:summaryOfBenefitsTableRows){
            WebElement groupNumber = coverageDocumentsPage.getGroupNumber(row);
            assertTrue(groupNumber.isDisplayed());
            assertTrue(groupNumber.getText().matches(groupNumberRegex), errorMsg(groupNumberRegex, groupNumber.getText()));

            WebElement pdfLink = coverageDocumentsPage.getBenefitsPdfLink(row);
            assertTrue(pdfLink.isDisplayed());
            assertTrue(pdfLink.isEnabled());
            assertEquals(pdfLink.getText(), pdfLinkText);

            WebElement groupName = coverageDocumentsPage.getGroupName(row);
            assertTrue(groupName.isDisplayed());
            assertFalse(groupName.getText().isEmpty(), "groupName field is empty.");
        }
    }

    @Test(description = "Selecting date in the datepicker displays Coverage Agreement documents for that date", groups = {"smoke", "qa", "prod"})
    public void validateAgreementDocumentsDisplayViaDataPicker(){
        String daySelected = coverageDocumentsPage.selectEnabledCoverageDate();
        assertFalse(daySelected.equals(""), "Failed to find a date that displayed Agreement Documents.");
        String expectedDate = coverageDocumentsPage.getFullDate(daySelected);
        assertTrue(coverageDocumentsPage.selectedAgreementDateDisplaysOnPage(expectedDate),
        "Selected Agreement Date is not displayed.");

        List<WebElement> coverageAgreementTableRows = coverageDocumentsPage.getCoverageAgreementTableRows();

        for(WebElement row:coverageAgreementTableRows){
            WebElement groupNumber = coverageDocumentsPage.getGroupNumber(row);
            assertTrue(groupNumber.isDisplayed());
            assertTrue(groupNumber.getText().matches(groupNumberRegex), errorMsg(groupNumberRegex, groupNumber.getText()));

            WebElement pdfLink = coverageDocumentsPage.getAgreementPdfLink(row);
            assertTrue(pdfLink.isDisplayed());
            assertTrue(pdfLink.isEnabled());
            assertEquals(pdfLink.getText(), pdfLinkText);

            WebElement groupName = coverageDocumentsPage.getGroupName(row);
            assertTrue(groupName.isDisplayed());
            assertFalse(groupName.getText().isEmpty(), "groupName field is empty.");

        }
    }

    @Test(description = "Glossary of Health Plan Terns link opens the correct page", groups = {"qa", "prod"})
    public void clickGlossaryOfHealthPlansLink(){
        coverageDocumentsPage.openHealthPlanTermsGlossaryPage();
    }

    @Test(description = "Static text displays on the page: Title, introductory paragraph, Summary of Benefits title and" +
            " text, Coverage Agreement title and text, table header text, and Disclaimer", groups = {"smoke", "qa", "prod"})
    public void verifyStaticTextDisplays(){
        assertTrue(coverageDocumentsPage.coverageDocumentsTitleTextDisplays(), "Coverage documents Title is not displayed correctly.");
        assertTrue(coverageDocumentsPage.coverageDocumentsIntroTextDisplays(), "Coverage documents Intro text is not displayed correctly.");
        assertTrue(coverageDocumentsPage.summaryOfBenefitsTitleTextDisplays(), "Summary of Benefits Title is not displayed correctly.");
        assertTrue(coverageDocumentsPage.summaryOfBenefitsIntroTextDisplays(), "Summary of Benefits Intro text is not displayed correctly.");
        assertTrue(coverageDocumentsPage.coverageAgreementTitleTextDisplays(), "Coverage Agreement Title text is not displayed correctly.");
        assertTrue(coverageDocumentsPage.coverageAgreementIntroTextDisplays(), "Coverage Agreement Intro text is not displayed correctly.");
        assertTrue(coverageDocumentsPage.disclaimerTitleTextDisplays(), "Disclaimer Title is not displayed correctly.");
        assertTrue(coverageDocumentsPage.disclaimerTextDisplays(), "Disclaimer text is not displayed correctly.");

        if(!coverageDocumentsPage.areBenefitsDisplayed()) {
            assertFalse(coverageDocumentsPage.selectEnabledBenefitDate().equals(""),"Failed to find a date that displayed Summary of Benefits.");
            }

        assertTrue(coverageDocumentsPage.sobTableGroupNumberHeaderTextDisplays(), "Summary of Benefits Group Number header text is not displayed correctly.");
        assertTrue(coverageDocumentsPage.sobTableGroupNameHeaderTextDisplays(), "Summary of Benefits Group Name header text is not displayed correctly.");
        assertTrue(coverageDocumentsPage.sobTablePdfHeaderTextDisplays(), "Summary of Benefits Pdf Header text is not displayed correctly.");

        if(!coverageDocumentsPage.areCoverageAgreementsDisplayed()) {
            if (coverageDocumentsPage.selectEnabledCoverageDate().equals("")) {
                System.out.println("Failed to find a date that displayed Coverage Agreements");
            }
        }

        assertTrue(coverageDocumentsPage.agreementTableGroupNumberHeaderTextDisplays(), "Agreement table Group Number header text is not displayed correctly.");
        assertTrue(coverageDocumentsPage.agreementTableGroupNameHeaderTextDisplays(), "Agreement table Group Name header text is not displayed correctly.");
        assertTrue(coverageDocumentsPage.agreementTablePdfHeaderTextDisplays(), "Agreement table Pdf Header text is not displayed correctly.");
    }

    @Test(description = "Can display Benefits Summary and Coverage Agreement documents for one year in the past", groups = {"smoke", "qa", "prod"})
    public void validateOneYearOldCoverageAgreementDocumentsDisplay(){
        coverageDocumentsPage.getCoverageDatePicker().click();
        assertTrue(coverageDocumentsPage.datePickerBackButtonExists(), "Back button not found in Coverage Date Picker.");
        String oneYearPriorDate = getOneYearPriorDate("MM-dd-yyyy");

        coverageDocumentsPage.selectCovAgreementDate(oneYearPriorDate);
        assertTrue(coverageDocumentsPage.selectedAgreementDateDisplaysOnPage(oneYearPriorDate),
        "Selected Agreement date is not displayed on page correctly.");

        List<WebElement> coverageAgreementTableRows = coverageDocumentsPage.getCoverageAgreementTableRows();

        for(WebElement row:coverageAgreementTableRows){
            WebElement groupNumber = coverageDocumentsPage.getGroupNumber(row);
            assertTrue(groupNumber.isDisplayed());
            assertTrue(groupNumber.getText().matches(groupNumberRegex), errorMsg(groupNumberRegex, groupNumber.getText()));

            WebElement groupName = coverageDocumentsPage.getGroupName(row);
            assertTrue(groupName.isDisplayed());
            assertFalse(groupName.getText().isEmpty(), "groupName field is empty.");

            WebElement pdfLink = coverageDocumentsPage.getAgreementPdfLink(row);
            assertTrue(pdfLink.isDisplayed());
            assertTrue(pdfLink.isEnabled());
            assertEquals(pdfLink.getText(), pdfLinkText);
        }

        coverageDocumentsPage.selectBenefitDate(oneYearPriorDate);
        assertTrue(coverageDocumentsPage.selectedBenefitsDateDisplaysOnPage(oneYearPriorDate),
        "Selected Benefits Date is not displayed correctly.");

        List<WebElement> summaryOfBenefitsTableRows = coverageDocumentsPage.getSummaryOfBenefitsTableRows();

        for(WebElement row:summaryOfBenefitsTableRows){
            WebElement groupNumber = coverageDocumentsPage.getGroupNumber(row);
            assertTrue(groupNumber.isDisplayed());
            assertTrue(groupNumber.getText().matches(groupNumberRegex), errorMsg(groupNumberRegex, groupNumber.getText()));

            WebElement groupName = coverageDocumentsPage.getGroupName(row);
            assertTrue(groupName.isDisplayed());
            assertTrue(groupName.getText().matches(groupNameRegex), errorMsg(groupNameRegex, groupName.getText()));

            WebElement pdfLink = coverageDocumentsPage.getBenefitsPdfLink(row);
            assertTrue(pdfLink.isDisplayed());
            assertTrue(pdfLink.isEnabled());
            assertEquals(pdfLink.getText(), pdfLinkText);
        }
    }

    @Test(description = "The Coverage Documents page defaults to today's date for displaying the Benefits Summary" +
            " and Agreement Coverage documents", groups = {"smoke", "qa", "prod"})
    public void validatePageDefaultsToCurrentDate() {
        LocalDate localDate = LocalDate.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMMM yyyy");
        String currentMonthYear = localDate.format(dtf);
        dtf = DateTimeFormatter.ofPattern("dd");
        String currentDay = localDate.format(dtf);

        coverageDocumentsPage.getCoverageDatePicker().click();
        String day = coverageDocumentsPage.getSelectedDatePickerDayOfMonth();
        assertNotEquals(day, null, "Selected date in datePicker not found.");
        assertEquals(currentDay, day);

        String monthYear = coverageDocumentsPage.getSelectedDatePickerMonthAndYear();
        assertEquals(currentMonthYear, monthYear);
        coverageDocumentsPage.getDatePickerDoneButton().click();

        coverageDocumentsPage.getSummaryOfBenefitsDatePicker().click();
        day = coverageDocumentsPage.getSelectedDatePickerDayOfMonth();
        assertNotEquals(day, null, "Selected date in datePicker not found.");
        assertEquals(currentDay, day);

        monthYear = coverageDocumentsPage.getSelectedDatePickerMonthAndYear();
        assertEquals(monthYear, currentMonthYear);
    }
}