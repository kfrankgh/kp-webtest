package org.ghc.pages;

import org.ghc.shades.KPAUIFindADoctorSearchResultsShareShade;
import org.ghc.utils.KPAUICredentials.*;
import org.ghc.utils.extensions.KPAUIFindADoctorEveryPage;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static java.lang.Integer.parseInt;
import static org.ghc.utils.helpers.KPAUITestHelper.clickElement;
import static org.ghc.utils.helpers.KPAUITestHelper.waitForElement;
import static org.ghc.utils.helpers.KPAUITestHelper.waitForElementToBeClickable;
import static org.testng.Assert.fail;


public class KPAUIFindADoctorSearchResultsPage extends KPAUIFindADoctorEveryPage {

    KPAUIFindADoctorSearchResultsPage(WebDriver driver) {
        super(driver);
        if (!isCurrent(driver, PAGETITLE_FIND_A_DOCTOR))
            fail("The Find a Doctor Search Results Page did not load correctly");
    }

    KPAUIFindADoctorSearchResultsPage(WebDriver driver, String search) {
        super(driver);
        if (!isCurrent(search))
            fail("The First Filter Tag did not match expected tag for FaD Search Results Page");
    }

    /** Compares passed search string to the text of the tag which appears for quick search
     * @param search String the user wishes to search for
     * @return true if text matches the search string - boolean
     */
    private boolean isCurrent(String search) {
        System.out.println("Quick Search = " + search);
        return getFirstFilteredObject().getText().equals(search);
    }

    //------------------------------------------------------------------------------------------------------------------
    private static final String PAGETITLE_FIND_A_DOCTOR = "Find a Doctor";

    // Finders
    @FindBy(css = ".action-btn-row #acceptingNew")                                          private WebElement acceptingNewCheckBox;
    @FindBy(css = "a[name='link-morecare-careclinics']")                                    private WebElement careClinicLink;
    @FindBy(xpath = "//*[@id='results-page']/form/div[3]/ul/li[3]/img")                     private WebElement clearAllChipsX;
    @FindBy(css = "a[name='link-morecare-consultnurse']")                                   private WebElement consultingNurseLink;
    @FindBy(css = ".distance-dropdown")                                                     private WebElement distanceDropdown;
    @FindAll({@FindBy(css = "*[class='dropdown-item']")})                                     private List<WebElement> dropdownItems;
    @FindBy(xpath = "//*[@id='results-page']/form/div[3]/ul/li[2]/p")                       private WebElement firstFilteredObject;
    @FindBy(css = ".gender-dropdown .justify-content-between")                              private WebElement genderDropdown;
    @FindBy(id = "language-dropdown")                                                       private WebElement languageDropdown;
    @FindBy(css = "a[name='link-morecare-onlinevisit']")                                    private WebElement onlineVisitLink;
    @FindBy(xpath = "//results-list/ul/li[1]/clinician-card/div/div/div[2]/div[1]/a")       private WebElement physicianDetailsCardDocName;
    @FindBy(css = ".results-found")                                                         private WebElement resultsCount;
    @FindBy(xpath = "//button[text()='Schedule Now']")                                      private List<WebElement> scheduleNowButtons;
    @FindBy(xpath = "//*[@id='results-page']/form/div[1]/div[2]/div[1]/button[2]/span")     private WebElement shareResultsButton;
    @FindBy(id = "specialty-dropdown")                                                      private WebElement specialtyDropdown;
    @FindBy(xpath = "//search-results/div/div[2]/div/div[2]")                               private WebElement yourPcPDiv;


    // Getters
    private WebElement getAcceptingNewCheckBox()        { return waitForElementToBeClickable(acceptingNewCheckBox, driver); }
    private WebElement getCareClinicLink()              { return waitForElementToBeClickable(careClinicLink, driver); }
    private WebElement getClearAllChipsX()              { return waitForElementToBeClickable(clearAllChipsX, driver); }
    private WebElement getConsultingNurseLink()         { return waitForElementToBeClickable(consultingNurseLink, driver); }
    private WebElement getDistanceDropdown()            { return waitForElementToBeClickable(distanceDropdown, driver); }
    private List<WebElement> getDropdownList()          { return dropdownItems; }
    private WebElement getGenderDropdown()              { return waitForElementToBeClickable(genderDropdown, driver); }
    private WebElement getLanguageDropdown()            { return waitForElementToBeClickable(languageDropdown, driver); }
    private WebElement getOnlineVisitLink()             { return waitForElementToBeClickable(onlineVisitLink, driver); }
    private WebElement getPhysicianDetailsCardDocName() { return waitForElementToBeClickable(physicianDetailsCardDocName, driver); }
    private WebElement getResultsCount()                { return waitForElement(resultsCount, driver); }
    private List<WebElement> getScheduleNowButtons()    { return scheduleNowButtons; }
    private WebElement getShareResultsButton()          { return waitForElementToBeClickable(shareResultsButton, driver);}
    private WebElement getSpecialtyDropdown()           { return waitForElementToBeClickable(specialtyDropdown, driver); }
    private WebElement getFirstFilteredObject()         { return waitForElement(firstFilteredObject, driver); }
    private String     getFirstDoctorName()             { return getPhysicianDetailsCardDocName().getText(); }
    public  WebElement getYourPcPDiv()                  { return waitForElement(yourPcPDiv, driver);}

    // Methods
    /** Click on the Accepting New Patients checkbox to modify search results page
     * @return Modified Search Results page - KPAUIFindADoctorSearchResultsPageTests
     */
    public KPAUIFindADoctorSearchResultsPage clickAcceptingNew() {
        getAcceptingNewCheckBox().click();
        return new KPAUIFindADoctorSearchResultsPage(driver);
    }

    /** Click on Distance Dropdown to return the page with the dropdown shade opened.
     * @return Modified Search Results page - KPAUIFindADoctorSearchResultsPageTests
     */
    private KPAUIFindADoctorSearchResultsPage clickDistanceDropdown() {
        WebElement ele = getDistanceDropdown();
        try {
            ele.click();
        }catch(ElementNotInteractableException e){
            clickElement(ele);
        }
        return new KPAUIFindADoctorSearchResultsPage(driver);
    }

    /** Click on Gender Dropdown to return the page with the dropdown shade opened.
     * @return Modified Search Results page - KPAUIFindADoctorSearchResultsPageTests
     */
    private KPAUIFindADoctorSearchResultsPage clickGenderDropdown() {
        getGenderDropdown().click();
        return new KPAUIFindADoctorSearchResultsPage(driver);
    }

    /** Click on Language Dropdown to return the page with the dropdown shade opened.
     * @return Modified Search Results page - KPAUIFindADoctorSearchResultsPageTests
     */
    private KPAUIFindADoctorSearchResultsPage clickLanguageDropdown() {
        getLanguageDropdown().click();
        return new KPAUIFindADoctorSearchResultsPage(driver);
    }

    /** Click on Specialty Dropdown to return the page with the dropdown shade opened.
     * @return Modified Search Results page - KPAUIFindADoctorSearchResultsPageTests
     */
    private KPAUIFindADoctorSearchResultsPage clickSpecialtyDropdown() {
        WebElement ele = getSpecialtyDropdown();
        try {
            ele.click();
        }catch(ElementNotInteractableException e){
            clickElement(ele);
        }
        return new KPAUIFindADoctorSearchResultsPage(driver);
    }

    /** Gets the string from the ui which contains the number of results found and parse the int out of it
     * @return the number of results found for a given query  - int
     */
    public int getCountFromUI() {
        String countString = getResultsCount().getText();
        return parseInt(countString.substring(0,countString.indexOf(" ")));
    }

    /** Gets List of Schedule Now Buttons on the Search Results page and checks the size of that list
     * @return Number of elements in the list of Schedule Now buttons - int
     */
    public int getCount_ScheduleNowButtonsDisplayed() {
        return getScheduleNowButtons().size();
    }

    /** Click on the Distance Dropdown and get a list of available options
     * @return A list of Specialties available in the specialty Dropdown - List<WebElements>
     */
    public List<WebElement> getDistanceDropdownList(){
        return clickDistanceDropdown().getDropdownList();
    }

    /** Click on the Gender Dropdown and get a list of available options
     * @return A list of Gender Options available in the Gender Dropdown - List<WebElements>
     */
    public List<WebElement> getGenderDropdownList() {
        return clickGenderDropdown().getDropdownList();
    }

    /** Click on the Language Dropdown and get a list of available options
     * @return A list of Specialties available in the specialty Dropdown - List<WebElements>
     */
    public List<WebElement> getLanguagesDropdownList(){
        return clickLanguageDropdown().getDropdownList();
    }

    /** Click on the Specialty Dropdown and get a list of available options
     * @return A list of Specialties available in the specialty Dropdown - List<WebElements>
     */
    public List<WebElement> getSpecialtiesDropdownList() {
        return clickSpecialtyDropdown().getDropdownList();
    }

    /** Click on the Online Visits Link
     * @return new Care Clinics page to check the title - KPAUICareClinicsPage
     */
    public KPAUIBartellsCareClinicsPage openFindADoctorCareClinicPage() {
        getCareClinicLink().click();
        return new KPAUIBartellsCareClinicsPage(driver);
    }

    /** Click on the Consulting Nurse Link to open the Consulting Nurse Page
     * @return new Consulting Nurse page to check the title - KPAUIConsultingNursePage
     */
    public KPAUIConsultingNursePage     openFindADoctorConsultingNursePage() {
        getConsultingNurseLink().click();
        return new KPAUIConsultingNursePage(driver);
    }

    /** Click on the Physician Details Page
     * @return redirects to the Physician Details Page - KPAUIFindADoctorDetailsPage
     */
    public KPAUIFindADoctorDetailsPage  openFindADoctorDetailsPageFromDoctorName() {
        String doctorName = getFirstDoctorName();
        WebElement ele = getPhysicianDetailsCardDocName();
        try {
            getPhysicianDetailsCardDocName().click();
        }catch(ElementNotInteractableException e){
            clickElement(ele);
        }
        return new KPAUIFindADoctorDetailsPage(driver, doctorName);
    }

    /** Click on the Clear All Chips X button to open the Find a Doctor Landing Page
     * @return returns to the Find a Doctor Landing Page - KPAUIFindADoctorLandingPage
     */
    public KPAUIFindADoctorLandingPage  openFindADoctorLandingPageByClearingChips() {
        getClearAllChipsX().click();
        return new KPAUIFindADoctorLandingPage(driver);
    }

    /** Click on the Online Visits Link to open the Online Visits Page
     * @return new Online Visits page to check the title - KPAUIFindADoctorSearchResultsPage
     */
    public KPAUIOnlineVisitsPage        openFindADoctorOnlineVisitsPage() {
        getOnlineVisitLink().click();
        return new KPAUIOnlineVisitsPage(driver);
    }

    /** Clicks on share results button to open the Share Results shade with email form
     * @return new Share Results Email Form Shade - KPAUIFindADoctorSearchResultsShareShade
     */
    public KPAUIFindADoctorSearchResultsShareShade openShareResultsShade() {
        getShareResultsButton().click();
        return new KPAUIFindADoctorSearchResultsShareShade(driver);
    }

    /** Click on the Sign On Link to open the Sign In shade
     * Enter Member ID and PW in the appropriate fields
     * @param account Member ID and Password
     *                Then after signing in, return to the Search Results page
     * @return KPAUIFindADoctorSearchResultsPage
     */
    public KPAUIFindADoctorSearchResultsPage signOnToFindADocAndNavToSearchResults(accountName account) {
        openFindADoctorDetailsPageFromDoctorName()
                .openSignOnShadeFromUnAuthChooseMeBtn()
                .signOnFromFindADoctorSignOnShade(account)
                .goBackToFindADoctorSearchResults();
        return new KPAUIFindADoctorSearchResultsPage(driver);
    }
}
