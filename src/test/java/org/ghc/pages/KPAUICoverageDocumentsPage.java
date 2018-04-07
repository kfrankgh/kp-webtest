package org.ghc.pages;

import org.ghc.utils.extensions.KPAUIEveryAuthenticatedPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Iterator;
import java.util.List;

import static org.ghc.utils.helpers.KPAUIStringHelper.getDayFromDate;
import static org.ghc.utils.helpers.KPAUITestHelper.*;
import static org.testng.Assert.fail;

public class KPAUICoverageDocumentsPage extends KPAUIEveryAuthenticatedPage {

    public KPAUICoverageDocumentsPage(WebDriver driver) {
        super(driver);
        if (!isCurrent(driver, PAGETITLE_COVERAGE_DOCUMENTS))
            fail("The Coverage Documents Page did not load correctly");
    }

    //------------------------------------------------------------------------------------------------------------------

    private static final String PAGETITLE_COVERAGE_DOCUMENTS = "Your Health Coverage Index";
    public static final String agreementPdfLink = "coverageagreement [ng-click^='viewPDF']";
    public static final String benefitPdfLink = "summaryofbenefits [ng-click^='viewPDF']";
    public static final String benefitsTableGroupNameHeader = "summaryofbenefits th:nth-child(2)";
    public static final String benefitsTableGroupNumHeader = "coverageagreement th:first-child";
    public static final String benefitsTablePdfHeader = "coverageagreement th:nth-child(3)";
    public static final String coverageAgreementIntro = "div:nth-child(5) > p:first-of-type";
    public static final String coverageAgreementTableRows = "coverageagreement .stripe.ng-valid";
    public static final String coverageAgreementTitle = "Coverage Agreement";
    public static final String coverageDocumentsTitle = "Coverage Documents";
    public static final String dateDelimiter = "-";
    public static final String datePickerBackButton = ".glyphicon-chevron-left";
    public static final String disclaimerTitle = ".smalltext > strong";
    public static final String datePickerDoneButton = ".datePicker .uib-datepicker-popup .btn-success";
    private final String pageTextRegex = "^.+[\\n\\?.*]*$";


    public boolean agreementTableGroupNameHeaderTextDisplays(){
        WebElement groupName = getAgreementTableGroupNameHeader();
        return ( groupName.isDisplayed() && !groupName.getText().isEmpty() );

    }

    public boolean agreementTableGroupNumberHeaderTextDisplays(){
        WebElement groupNumber = getAgreementTableGroupNumHeader();
        return ( groupNumber.isDisplayed() && !groupNumber.getText().isEmpty() );
    }

    public boolean agreementTablePdfHeaderTextDisplays(){
        WebElement pdfHeader = getAgreementTablePdfHeader();
        return ( pdfHeader.isDisplayed() && !pdfHeader.getText().isEmpty() );
    }

    public Boolean areBenefitsDisplayed(){
        return (getSummaryOfBenefitsTableRows().size() > 0);
    }

    public Boolean areCoverageAgreementsDisplayed(){
        return (getCoverageAgreementTableRows().size() > 0 );
    }

    public boolean coverageAgreementIntroTextDisplays(){
        WebElement intro = getCoverageAgreementIntro();
        return ( intro.isDisplayed() && intro.getText().matches(pageTextRegex));
    }

    public boolean coverageAgreementTitleTextDisplays(){
        WebElement title = getCoverageAgreementTitle();
        return( title.isDisplayed() && title.getText().toLowerCase().contentEquals(coverageAgreementTitle.toLowerCase()) );
    }

    public boolean coverageDocumentsIntroTextDisplays(){
        WebElement intro = getCoverageDocumentsIntro();
        return (intro.isDisplayed() && intro.getText().matches(pageTextRegex) );
    }

    public boolean coverageDocumentsTitleTextDisplays(){
        WebElement title = getCoverageDocumentsTitle();
        return (title.getText().toLowerCase().contentEquals(coverageDocumentsTitle.toLowerCase()) );
    }


    /**
     * selects date from datepicker
     * @param date the date in format MM-dd-yyyy
     */
    public void datePickerSelectDate(String date){
        long monthsFromNow = getMonthsFromNow(date);
        datePickerSelectMonth(monthsFromNow);

        String dayOfMonth = getDayFromDate(date, "MM-dd-yyyy");
        WebElement datePickerDate = getDatePickerDate(dayOfMonth);
        datePickerDate.click();
    }

    /**
     * sets month in datepicker
     * @param months equals the number of times to click the back or forward buttons to go to the next or previous month
     */
    private void datePickerSelectMonth(long months){
        if(months < 0){
            WebElement button = datePickerGetBackButton();
            for(int i = 0; i > months; i--) {
                button.click();
            }
        }
        if (months > 0) {
            WebElement button = datePickerGetForwardButton();
            for(int i = 0; i < months; i++){
                button.click();
            }
        }
    }

    private WebElement datePickerGetBackButton(){
        return waitForElement(driver.findElement(By.cssSelector(datePickerBackButton)), driver);
    }

    public boolean datePickerBackButtonExists(){
        datePickerGetBackButton();
        return ( driver.findElements(By.cssSelector(datePickerBackButton)).size() > 0);
    }
    private WebElement datePickerGetForwardButton(){
        return waitForElement(driver.findElement(By.cssSelector(".uib-daypicker .btn.uib-right")), driver);
    }

    public boolean disclaimerTextDisplays(){
        WebElement disclaimer = getDisclaimerParagraph();
        return ( disclaimer.isDisplayed() && disclaimer.getText().matches("^.+\\n?.+[\\n\\?.*]*$") );
    }

    public boolean disclaimerTitleTextDisplays(){
        WebElement disclaimerTitle = getDisclaimerTitle();
        return ( disclaimerTitle.isDisplayed() && disclaimerTitle.getText().contentEquals("Disclaimer") );
    }

    private WebElement getAgreementTableDateHeader(){
        return driver.findElement(By.cssSelector("coverageagreement .resultsFor td"));
    }

    public WebElement getAgreementTableGroupNameHeader(){
        return driver.findElement(By.cssSelector("coverageagreement th:nth-child(2)"));
    }

    public WebElement getAgreementTableGroupNumHeader() {
        return driver.findElement(By.cssSelector("coverageagreement th:first-child"));
    }

    public WebElement getAgreementTablePdfHeader(){
        return driver.findElement(By.cssSelector("coverageagreement th:nth-child(3)"));
    }

    public WebElement getAgreementPdfLink(WebElement tableRow){
        return tableRow.findElement(By.cssSelector(agreementPdfLink));
    }

    public WebElement getBenefitsPdfLink(WebElement tableRow){
        return tableRow.findElement(By.cssSelector(benefitPdfLink));
    }

    public WebElement getBenefitsTableDateHeader(){
        return driver.findElement(By.cssSelector("summaryofbenefits .resultsFor td"));
    }

    public WebElement getBenefitsTableGroupNameHeader(){
        return driver.findElement(By.cssSelector(benefitsTableGroupNameHeader));
    }

    public WebElement getBenefitsTableGroupNumHeader(){
        return driver.findElement(By.cssSelector(benefitsTableGroupNumHeader));
    }

    public WebElement getBenefitsTablePdfHeader(){
        return driver.findElement(By.cssSelector(benefitsTablePdfHeader));
    }

    public WebElement getCoverageAgreementIntro(){
        return driver.findElement(By.cssSelector(coverageAgreementIntro));
    }

    public WebElement getCoverageAgreementTitle(){
        return driver.findElement(By.cssSelector("div:nth-child(5) > h2"));
    }

    public List<WebElement> getCoverageAgreementTableRows(){
        return driver.findElements(By.cssSelector(coverageAgreementTableRows));
    }

    public WebElement getCoverageDatePicker(){
        WebElement datePicker = driver.findElement(By.cssSelector("#coc-button"));
        return waitForElementToBeClickable(datePicker, driver);
    }

    public WebElement getCoverageDocumentsIntro(){
        return driver.findElement(By.cssSelector(".coverageDocs > div:first-of-type"));
    }

    public WebElement getCoverageDocumentsTitle(){
        return waitForElement( driver.findElement(By.cssSelector(".coverdoc-title")) , driver );
    }

    /**
     * gets date from header of Agreement table
     * @return the date or "" if not found
     */
    public String getDateFromAgreementTableHeader(){
        String headerDateSelectedText = getAgreementTableDateHeader().getText();
        return getDateFromString(headerDateSelectedText);
    }

    /**
     * gets date from header from Benefits table
     * @return the date or "" if not found
     */
    public String getDateFromBenefitsTableHeader(){
        String headerDateSelectedText = getBenefitsTableDateHeader().getText();
        return getDateFromString(headerDateSelectedText);
    }

    /**
     *
     * @return the date or "" if not found
     */
    private String getDateFromString(String headerDateText){
        int startIndex = headerDateText.indexOf("-") - 2;
        int endIndex = headerDateText.lastIndexOf(dateDelimiter) + 5;
        try {
            return headerDateText.substring(startIndex, endIndex);
        }catch(IndexOutOfBoundsException e){
            return "";
        }
    }

    /**
     * gets the datePicker date WebElement that corresponds to the dayOfMonth
     * @param dayOfMonth the day of month to get
     * @return day of month WebElement or null if not found
     */
    private WebElement getDatePickerDate(String dayOfMonth){
        List<WebElement> dates =  getDatePickerEnabledDates();
        for(WebElement date: dates){
            String dateText = date.getText();
            if (dateText.contentEquals(dayOfMonth)){
                return date;
            }
        }
        return null;
    }

    public List<WebElement> getDatePickerEnabledDates(){
        return driver.findElements(By.cssSelector("[id^='datepicker-'] .btn [class='ng-binding']"));
    }

    public WebElement getDatePickerDoneButton(){
        return driver.findElement(By.cssSelector(datePickerDoneButton));
    }

    public WebElement getDisclaimerParagraph(){
        return driver.findElement(By.cssSelector(".smalltext"));
    }

    public WebElement getDisclaimerTitle(){
        return driver.findElement(By.cssSelector(disclaimerTitle));
    }

    /**
     *
     * @param day day of month in format dd
     * @return date in format MM-dd-yyyy where month and year are the current month and year
     */
    public String getFullDate(String day){
        LocalDate date = LocalDate.of(LocalDate.now().getYear(), LocalDate.now().getMonthValue(), Integer.valueOf(day));
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM-dd-yyyy");
        return date.format(dtf);
    }

    public WebElement getGlossaryOfHealthPlansLink(){
        return waitForElementToBeClickable(driver.findElement(By.partialLinkText("Glossary")), driver);
    }

    public WebElement getGroupName(WebElement tableRow){
        return tableRow.findElement(By.cssSelector("td:nth-of-type(2).ng-binding"));
    }

    public WebElement getGroupNumber(WebElement tableRow){
        return tableRow.findElement(By.cssSelector("td:first-of-type.ng-binding"));
    }

    private long getMonthsFromNow(String date){
        LocalDate now = LocalDate.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM-dd-yyyy");
        LocalDate dateToPick = LocalDate.parse(date, dtf);
        return now.until(dateToPick, ChronoUnit.MONTHS);
    }

    /**
        @return the selected day of month in the dayPicker, in 2 digit format, or null if not found
     */
    public String getSelectedDatePickerDayOfMonth(){
        String dayOfMonth;
        try {
            dayOfMonth = driver.findElement(By.cssSelector("[id^='datepicker'] .btn.active")).getText();
        }catch(Exception e){
            return null;
        }
        dayOfMonth = ( dayOfMonth.length() == 1 ) ? ( "0" + dayOfMonth ) : dayOfMonth;

        return ( dayOfMonth == null ) ? null : dayOfMonth;
    }

    public String getSelectedDatePickerMonthAndYear(){
        return driver.findElement(By.cssSelector("th>[id^='datepicker']>.ng-binding")).getText();
    }

    public WebElement getSummaryOfBenefitsDatePicker(){
        return waitForElementToBeClickable(driver.findElement(By.cssSelector("#sob-button")), driver);
    }

    public WebElement getSummaryOfBenefitsIntro(){
        return driver.findElement(By.cssSelector(".coverageDocs > div:nth-child(3) .intro"));
    }

    public List<WebElement> getSummaryOfBenefitsTableRows(){
        return driver.findElements(By.cssSelector("summaryofbenefits .stripe.ng-valid"));
    }

    public WebElement getSummaryOfBenefitsTitle(){
        return driver.findElement(By.cssSelector(".coverageDocs h2:first-child"));
    }

    public KPAUIPdfPage openAgreementPdf(WebElement tableRow){
        tableRow.findElement(By.cssSelector(agreementPdfLink)).click();
        return new KPAUIPdfPage(getChildDriver(driver));
    }

    public KPAUIPdfPage openBenefitPdf(WebElement tableRow){
        tableRow.findElement(By.cssSelector(benefitPdfLink)).click();
        return new KPAUIPdfPage(getChildDriver(driver));
    }

    public KPAUIHealthPlanTermsGlossaryPage openHealthPlanTermsGlossaryPage(){
        getGlossaryOfHealthPlansLink().click();
        return new KPAUIHealthPlanTermsGlossaryPage(driver);
    }

    public void selectBenefitDate(String date){
        getSummaryOfBenefitsDatePicker().click();
        datePickerSelectDate(date);
    }

    public void selectCovAgreementDate(String date){
        getCoverageDatePicker().click();
        datePickerSelectDate(date);
    }

    public boolean selectedAgreementDateDisplaysOnPage(String expectedDate){
        String date = getDateFromAgreementTableHeader();
        return ( !date.contentEquals("") && date.contentEquals(expectedDate) );
    }
    public boolean selectedBenefitsDateDisplaysOnPage(String expectedDate){
        String date = getDateFromBenefitsTableHeader();
        return ( !date.contentEquals("") && date.contentEquals(expectedDate));
    }

    public String selectEnabledBenefitDate(){
        getSummaryOfBenefitsDatePicker().click();
        List<WebElement> days = getDatePickerEnabledDates();
        Iterator it = days.iterator();
        while(it.hasNext()){
            WebElement date = (WebElement)it.next();
            String day = date.getText();
            getDatePickerDate(day).click();
            if( getSummaryOfBenefitsTableRows().size() > 0 ) {
                return day;
            }
        }
        return "";
    }

    public String selectEnabledCoverageDate(){
        getCoverageDatePicker().click();
        List<WebElement> days = getDatePickerEnabledDates();
        Iterator it = days.iterator();
        while(it.hasNext()){
            WebElement date = (WebElement)it.next();
            String day = date.getText();
            getDatePickerDate(day).click();
            if( getCoverageAgreementTableRows().size() > 0 ) {
                return day;
            }
        }
        return "";
    }

    public boolean sobTableGroupNameHeaderTextDisplays(){
        WebElement groupName = getBenefitsTableGroupNameHeader();
        return ( groupName.isDisplayed() && !groupName.getText().isEmpty() );
    }

    public boolean sobTableGroupNumberHeaderTextDisplays(){
        WebElement groupNumber = getBenefitsTableGroupNumHeader();
        return ( groupNumber.isDisplayed() && !groupNumber.getText().isEmpty());
    }

    public boolean sobTablePdfHeaderTextDisplays(){
        WebElement pdfHeader = getBenefitsTablePdfHeader();
        return( pdfHeader.isDisplayed() && !pdfHeader.getText().isEmpty() );
    }

    public boolean summaryOfBenefitsIntroTextDisplays(){
        WebElement intro = getSummaryOfBenefitsIntro();
        return ( intro.isDisplayed() && !intro.getText().isEmpty());
    }

    public boolean summaryOfBenefitsTitleTextDisplays(){
        WebElement title = getSummaryOfBenefitsTitle();
        return ( title.isDisplayed() && title.getText().toLowerCase().contentEquals("summary of benefits"));
    }
}
