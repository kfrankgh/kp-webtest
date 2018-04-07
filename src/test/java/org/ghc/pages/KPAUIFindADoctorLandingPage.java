package org.ghc.pages;

import org.ghc.utils.extensions.KPAUIFindADoctorEveryPage;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.ghc.utils.helpers.KPAUITestHelper.clickElement;
import static org.ghc.utils.helpers.KPAUITestHelper.waitForElementToBeClickable;
import static org.testng.Assert.fail;

public class KPAUIFindADoctorLandingPage extends KPAUIFindADoctorEveryPage {

    public KPAUIFindADoctorLandingPage(WebDriver driver) {
        super(driver);
        if (!isCurrent(driver, PAGETITLE_FIND_A_DOCTOR))
            fail("The Find a Doctor Landing Page did not load correctly");
    }


    //------------------------------------------------------------------------------------------------------------------
    private static final String PAGETITLE_FIND_A_DOCTOR = "Find a Doctor";

    // Finders
    @FindBy(name = "link-consultnurse")                         private WebElement callNurseButton;
    @FindBy(name = "link-childandteencare")                     private WebElement childTeenCareQuickSearchLink;
    @FindBy(name = "link-learnmore")                            private WebElement learnMoreButton;
    @FindBy(name = "link-pregnancycare")                        private WebElement pregnancyCareQuickSearchLink;
    @FindBy(name = "link-primarycare")                          private WebElement primaryCareQuickSearchLink;
    @FindBy(name = "link-additionalresults")                    private WebElement searchAllProvidersLink;
    @FindBy(name = "link-onlinevisit")                          private WebElement startOnlineVisitButton;

    // Getters
    public WebElement getCallNurseButton()                      { return waitForElementToBeClickable(callNurseButton, driver); }
    public WebElement getChildTeenCareQuickSearchLink()         { return waitForElementToBeClickable(childTeenCareQuickSearchLink, driver); }
    public WebElement getLearnMoreButton()                      { return waitForElementToBeClickable(learnMoreButton, driver); }
    public WebElement getPregnancyCareQuickSearchLink()         { return waitForElementToBeClickable(pregnancyCareQuickSearchLink, driver); }
    public WebElement getPrimaryCareQuickSearchLink()           { return waitForElementToBeClickable(primaryCareQuickSearchLink, driver); }
    public WebElement getStartOnlineVisitButton()               { return waitForElementToBeClickable(startOnlineVisitButton, driver); }
    public WebElement getSearchAllProvidersLink()               { return waitForElementToBeClickable(searchAllProvidersLink, driver); }

    // Methods

    /** Clicks on the Search all Providers Link top open the Vitals Choice page
     * @return new Un Authenticated Vitals Choice page
     */
    public KPAUIVitalsChoicePage openVitalsChoicePage() {
        getSearchAllProvidersLink().click();
        return new KPAUIVitalsChoicePage(driver);
    }

    /**
     * Click on the Child and Teen Care Quick Search checkbox to open the Search Results page with Pediatrician results
     *
     * @return new FaD Search results page - KPAUIFindADoctorSearchResultsPageTests
     */
    public KPAUIFindADoctorSearchResultsPage openFaDResultsPage_QuickSearch_ChildAndTeenCare() {
        getChildTeenCareQuickSearchLink().click();
        return new KPAUIFindADoctorSearchResultsPage(driver, "Child and teen care");
    }

    /**
     * Click on the Pregnancy Care Quick Search checkbox to open the Search Results page with Obstetrician results
     *
     * @return FaD Search results page - KPAUIFindADoctorSearchResultsPageTests
     */
    public KPAUIFindADoctorSearchResultsPage openFaDResultsPage_QuickSearch_PregnancyCare() {
        getPregnancyCareQuickSearchLink().click();
        return new KPAUIFindADoctorSearchResultsPage(driver, "Pregnancy care");
    }

    /**
     * Click on the Primary Care Quick Search checkbox to open the Search Results page with PCP results
     *
     * @return new FaD Search results page - KPAUIFindADoctorSearchResultsPageTests
     */
    public KPAUIFindADoctorSearchResultsPage openFaDResultsPage_QuickSearch_PrimaryCare() {
        getPrimaryCareQuickSearchLink().click();
        return new KPAUIFindADoctorSearchResultsPage(driver, "Primary care physician");
    }

    /**
     * Click on the Search button to open the Search Results page with Search results
     *
     * @return new FaD Search results page - KPAUIFindADoctorSearchResultsPageTests
     */
    public KPAUIFindADoctorSearchResultsPage openFaDResultsPage() {
        getFadSearchButton().click();
        return new KPAUIFindADoctorSearchResultsPage(driver, "");
    }

    /**
     * Click on the Start online visit button from the UnAuthenticated Find a Doctor Landing page
     *
     * @return new Sign on Page - KPAUISignOnFccPage
     */
    public KPAUISignOnFccPage openSignOnFccPageFromStartOnlineVisitButton() {
        getStartOnlineVisitButton().click();
        return new KPAUISignOnFccPage(driver);
    }

    /**
     * Click on the Call Nurse button from the Authenticated Find a Doctor Landing page
     *
     * @return new Online Visits page - KPAUIOnlineVisitsPage
     */
    public KPAUIOnlineVisitsPage openOnlineVisitPageFromStartOnlineVisitButton() {
        WebElement ele = getStartOnlineVisitButton();
        try {
            ele.click();
        }catch(ElementNotInteractableException e){
            clickElement(ele);
        }

        return new KPAUIOnlineVisitsPage(driver);
    }

    /**
     * Click on Call Nurse Button from the Find a Doctor Landing page
     *
     * @return new Consulting Nurse page - KPAUIConsultingNursePage
     */
    public KPAUIConsultingNursePage openConsultingNursePageFromCallNurseButton() {
        WebElement ele;
        ele = getCallNurseButton();
        try {
            ele.click();
        }catch(ElementNotInteractableException e){
            clickElement(ele);
        }
        return new KPAUIConsultingNursePage(driver);
    }

    /**
     * Click on Call Nurse Button from the Find a Doctor Landing page
     *
     * @return new Consulting Nurse page - KPAUIConsultingNursePage
     */
    public KPAUIChooseOrChangeYourDoctorPage openChooseOrChangeYourDoctorPageFromLearnMoreButton() {
        WebElement ele = getLearnMoreButton();
        try {
            ele.click();
        }catch(ElementNotInteractableException e){
            clickElement(ele);
        }

        return new KPAUIChooseOrChangeYourDoctorPage(driver);
    }

    /** Sends a searchString argument to the Search Field then clicks on the Search Button to return Results Page
     * @param searchString
     * @return - results based on the search string, on the FaD Search Results page - KPAUIFindADoctorSearchResultsPageTests
     */
    public KPAUIFindADoctorSearchResultsPage doctorSearch(String searchString) {
        getFadSearchField().sendKeys(searchString);
        getFadSearchButton().click();
        return new KPAUIFindADoctorSearchResultsPage(driver);
    }
}

