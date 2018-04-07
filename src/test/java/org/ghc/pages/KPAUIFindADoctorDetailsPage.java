package org.ghc.pages;

import org.ghc.shades.KPAUIChoosePhysicianShade;
import org.ghc.shades.KPAUIFindADoctorSearchResultsShareShade;
import org.ghc.shades.KPAUIFindADoctorSignOnShade;
import org.ghc.utils.extensions.KPAUIFindADoctorEveryPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.ghc.utils.KPAIUTestConstants.links.findADoctorResultsPage;
import static org.ghc.utils.helpers.KPAUIStringHelper.getSiteWithPrefix;
import static org.ghc.utils.helpers.KPAUITestHelper.*;
import static org.testng.Assert.fail;

public class KPAUIFindADoctorDetailsPage extends KPAUIFindADoctorEveryPage {

    public KPAUIFindADoctorDetailsPage(WebDriver driver) {
        super(driver);
        if (!isCurrent(driver, PAGETITLE_FIND_A_DOCTOR))
            fail("The PCP paneling Page Did Not Load Correctly");
    }

    public KPAUIFindADoctorDetailsPage(WebDriver driver, String doctorName) {
        super(driver);
        if (!isCurrent(doctorName))
            fail("The Doctor Details Page Did Not Load Correctly");
    }

    private boolean isCurrent(String doctorExpectedName) {
        System.out.println("Doctor Name = " + doctorExpectedName);
        return getBreadCrumbPhysicianName().getText().equals(doctorExpectedName);
    }

    //------------------------------------------------------------------------------------------------------------------
    private static final String PAGETITLE_FIND_A_DOCTOR = "Find a Doctor";

    // Finders
    @FindBy(xpath = "//clinician-detail/div/div[1]/div/div[1]/div[1]/span[3]")              private WebElement breadCrumbPhysicianName;
    @FindBy(xpath = "//clinician-detail/div/div[1]/div/div[1]/div[1]/p")                    private WebElement breadCrumbBackToResults;
    @FindBy(xpath = "//clinician-detail/div/div[1]/div/div[1]/div[2]/div/div/button[1]")    private WebElement shareDoctorResult;
    @FindBy(xpath = "//clinician-detail/div/div[1]/div/div[1]/div[2]/div/div/button[2]")    private WebElement printDoctorResult;
    @FindBy(id =    "choose-btn")                                                           private WebElement choosePhysicianButton;
    @FindBy(xpath = "//div[2]/div/div[3]/div[1]/div/div")                                   private WebElement doctorPortraitDiv;
    @FindBy(id =    "results-map")                                                          private WebElement gMap;

    // Getters
    private WebElement getBreadCrumbPhysicianName()     { return waitForElement(breadCrumbPhysicianName, driver); }
    public  WebElement getBreadCrumbBackToResults()     { return waitForElementToBeClickable(breadCrumbBackToResults, driver); }
    public  WebElement getShareDoctorResult()           { return waitForElementToBeClickable(shareDoctorResult, driver); }
    public  WebElement getPrintButton()                 { return waitForElementToBeClickable(printDoctorResult, driver); }
    public  WebElement getChoosePhysicianButton()       { return waitForElementToBeClickable(choosePhysicianButton, driver); }
    public  WebElement getDoctorPortraitDiv()           { return waitForElement(doctorPortraitDiv, driver); }
    public  WebElement getGMap()                        { return waitForElement(gMap, driver); }

    // Methods

    /** Click on the Back to Results bread crumb to return to the Find a Doctor Search Results Page
     * @return back to the FaD Search Results Page - KPAUIFindADoctorSearchResultsPage
     */
    public KPAUIFindADoctorSearchResultsPage openFindADoctorSearchResultsPageFromBreadCrumb() {
        getBreadCrumbBackToResults().click();
        return new KPAUIFindADoctorSearchResultsPage(driver);
    }

    /** Click on the share results button to open the share results shade
     * @return the Share Results email form shade - KPAUIFindADoctorSearchResultsShareShade
     */
    public KPAUIFindADoctorSearchResultsShareShade openShareDoctorResultShade() {
        getShareDoctorResult().click();
        return new KPAUIFindADoctorSearchResultsShareShade(driver);
    }

    /** Assumes button is on UnAuthenticated Page click on the Choose Me button to open the Sign On Shade
     * @return the Sign On Shade - KPAUISignOnShade
     */
    public KPAUIFindADoctorSignOnShade openSignOnShadeFromUnAuthChooseMeBtn() {
        getChoosePhysicianButton().click();
        return new KPAUIFindADoctorSignOnShade(getChildDriver(driver));
    }

    /** Sign on to the Authenticated Find a Doctor Details Page
     *  Click on the Choose Me button to open the Choose PcP shade
     * @return new physician shade - KPAUIChoosePhysicianShade
     */
    public KPAUIChoosePhysicianShade openChoosePhysicianShade() {
        getChoosePhysicianButton().click();
        return new KPAUIChoosePhysicianShade(getChildDriver(driver));
    }


    /** Navigate back one step in the logical stack of pages, to the search results page
     * @return new search results page - KPAUIFindADoctorSearchResultsPage
     */
    public KPAUIFindADoctorSearchResultsPage goBackToFindADoctorSearchResults() {
        driver.get(getSiteWithPrefix(findADoctorResultsPage));
        return new KPAUIFindADoctorSearchResultsPage(driver);
    }
}
