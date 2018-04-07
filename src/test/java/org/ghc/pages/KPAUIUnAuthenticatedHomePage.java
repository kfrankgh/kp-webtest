package org.ghc.pages;

import org.ghc.utils.extensions.KPAUIEveryUnAuthenticatedPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.ghc.utils.KPAIUTestConstants.attributes.srcAttribute;
import static org.ghc.utils.KPAUICredentials.accountName.EVERYTHING;
import static org.ghc.utils.helpers.KPAUITestHelper.waitForElement;
import static org.ghc.utils.helpers.KPAUITestHelper.waitForElementToBeClickable;
import static org.testng.Assert.fail;

public class KPAUIUnAuthenticatedHomePage extends KPAUIEveryUnAuthenticatedPage {

    public KPAUIUnAuthenticatedHomePage(WebDriver driver) {
        super(driver);
        if (!isCurrent(driver, PAGETITLE_UNAUTHENTICATED_HOME))
            fail("The UnAuthenticated Home Page did not load correctly");
    }

    //------------------------------------------------------------------------------------------------------------------

    private static final String PAGETITLE_UNAUTHENTICATED_HOME = "Kaiser Permanente Washington";

    private final String tileTitleCss = " .contentbox-head";
    private final String tileDescriptionCss = " .contentbox-content";
    private final String tileLinkCss = " .contentbox-link a";
    private final String tileIconCss = " .colicon img";
    private final String newMemberTileCss = ".menuright.menuright-dt";
    private final String doctorsAndLocsTileCss = ".menuleft.menuleft-dt";
    private final String shopOurPlansTileCss = ".row.menurow .menumid-dt";
    private final String shopOurPlansTileIconFilename = "icon-shop-our-plans.png";

    public static final String shopOurPlansTileExpectedTitle = "Shop our plans";
    public static final String shopOurPlansTileExpectedDescription = "As a Kaiser Permanente member, you get more than just a health plan.\nShop health plans";
    public static final String newMemberTileExpectedTitle = "New member? Start here";
    public static final String newMemberTileExpectedDescription = "It's easy to get started with a few simple steps.\nGet started";
    public static final String newMemberTileLinkText = "Get started";
    public static final String doctorsAndLocationsTileExpectedTitle = "Doctors and locations";
    public static final String doctorsAndLocationsTileExpectedDescription = "You can find top-notch Kaiser " +
            "Permanente doctors and convenient locations near home or work.\nFind doctors and locations";

    // Finders
    @FindBy(css = doctorsAndLocsTileCss + tileDescriptionCss)       private WebElement doctorsAndLocationsDesc;
    @FindBy(css = doctorsAndLocsTileCss + tileIconCss)              private WebElement doctorsAndLocationsIcon;
    @FindBy(css = doctorsAndLocsTileCss + tileTitleCss)             private WebElement doctorsAndLocationsTitle;
    @FindBy(css = doctorsAndLocsTileCss + tileLinkCss)              private WebElement findDocsAndLocationsLink;
    @FindBy(css = ".desktop-carousel .hero-img")                    private WebElement heroImage;
    @FindBy(css = newMemberTileCss + tileDescriptionCss)            private WebElement newMemberDescription;
    @FindBy(css = newMemberTileCss + tileIconCss)                   private WebElement newMemberIcon;
    @FindBy(css = newMemberTileCss + tileLinkCss)                   private WebElement newMemberLink;
    @FindBy(css = newMemberTileCss + tileTitleCss)                  private WebElement newMemberTitle;
    @FindBy(css = shopOurPlansTileCss + tileLinkCss)                private WebElement shopHealthPlansLink;
    @FindBy(css = shopOurPlansTileCss + tileDescriptionCss)         private WebElement shopOurPlansDescription;
    @FindBy(css = shopOurPlansTileCss + tileIconCss)                private WebElement shopOurPlansIcon;
    @FindBy(css = shopOurPlansTileCss + tileTitleCss)               private WebElement shopOurPlansTitle;
    @FindBy(linkText = "Community events")                                      private WebElement communityEventsLink;
    @FindBy(linkText = "Call a consulting nurse")                               private WebElement consultingNurseLink;
    @FindBy(linkText = "Get a flu shot")                                        private WebElement fluShotLink;
    @FindBy(linkText = "Health and wellness")                                   private WebElement healthAndWellnessLink;
    @FindBy(css = "#righnavalertspan-kp .kpbanner")                             private WebElement fluSymptomsHeaderLink;
    @FindBy(linkText = "Make an appointment")                                   private WebElement makeAnAppointmentLink;
    @FindBy(linkText = "Request medical records")                               private WebElement medicalRecordsLink;
    @FindBy(css = ".ncqa-image")                                                private WebElement ncqaImage;
    @FindBy(css = ".ncqa-text")                                                 private WebElement ncqaText;
    @FindBy(linkText = "Pregnancy services")                                    private WebElement pregnancyServicesLink;
    @FindBy(linkText = "Refill a prescription")                                 private WebElement prescriptionLink;
    @FindBy(linkText = "Request reimbursement")                                 private WebElement reimbursementLink;
    @FindBy(linkText = "Vision and eye care")                                   private WebElement visionAndEyeCareLink;

    // Getters
    private WebElement getCommunityEventsLink()         { return waitForElementToBeClickable(communityEventsLink, driver); }
    private WebElement getConsultingNurseLink()         { return waitForElementToBeClickable(consultingNurseLink, driver); }
    public  WebElement getDoctorsAndLocationsDesc()     { return waitForElement(doctorsAndLocationsDesc, driver); }
    public  WebElement getDoctorsAndLocationsIcon()     { return waitForElement(doctorsAndLocationsIcon, driver); }
    public  WebElement getDoctorsAndLocationsTitle()    { return waitForElement(doctorsAndLocationsTitle, driver); }
    private WebElement getFluShotLink()                 { return waitForElementToBeClickable(fluShotLink, driver); }
    private WebElement getFluSymptomsHeader()           { return waitForElementToBeClickable(fluSymptomsHeaderLink, driver); }
    public  WebElement getFindDocsAndLocationsLink()    { return waitForElementToBeClickable(findDocsAndLocationsLink, driver); }
    private WebElement getHealthAndWellnessLink()       { return waitForElementToBeClickable(healthAndWellnessLink, driver); }
    public  WebElement getHeroImage()                   { return waitForElement(heroImage, driver); }
    public  String     getHeroImageFilePath()           { return getHeroImage().getAttribute(srcAttribute); }
    private WebElement getMakeAnAppointmentLink()       { return waitForElementToBeClickable(makeAnAppointmentLink, driver); }
    private WebElement getPregnancyServicesLink()       { return waitForElementToBeClickable(pregnancyServicesLink, driver); }
    public  WebElement getNcqaImage()                   { return waitForElement(ncqaImage, driver); }
    public  WebElement getNcqaText()                    { return waitForElement(ncqaText, driver); }
    public  WebElement getNewMemberDescription()        { return waitForElement(newMemberDescription, driver); }
    public  WebElement getNewMemberIcon()               { return waitForElement(newMemberIcon, driver); }
    public  WebElement getNewMemberLink()               { return waitForElement(newMemberLink, driver); }
    public  WebElement getNewMemberTitle()              { return waitForElement(newMemberTitle, driver); }
    private WebElement getRefillPrescriptionLink()      { return waitForElementToBeClickable(prescriptionLink, driver); }
    private WebElement getRequestMedicalRecordsLink()   { return waitForElementToBeClickable(medicalRecordsLink, driver); }
    private WebElement getRequestReimbursementLink()    { return waitForElementToBeClickable(reimbursementLink, driver); }
    public  WebElement getShopHealthPlansLink()         { return waitForElement(shopHealthPlansLink, driver); }
    public  WebElement getShopOurPlansDescription()     { return waitForElement(shopOurPlansDescription, driver); }
    public  WebElement getShopOurPlansIcon()            { return waitForElement(shopOurPlansIcon, driver); }
    public  WebElement getShopOurPlansTitle()           { return waitForElement(shopOurPlansTitle, driver); }
    private WebElement getVisionAndEyeCareLink()        { return waitForElementToBeClickable(visionAndEyeCareLink, driver); }


    //Methods
    /** Click on the Make An Appointment link to open the Sign in Fcc page
     * @return KPAUISignOnFccPage
     */
    public KPAUISignOnFccPage clickAppointmentsLink(){
        getMakeAnAppointmentLink().click();
        return new KPAUISignOnFccPage(driver);
    }

    /** Click on the Community Events link to open the Community Events page
     * @return KPAUICommunityEventsPage
     */
    public KPAUICommunityEventsPage clickCommunityEventsLink(){
        getCommunityEventsLink().click();
        return new KPAUICommunityEventsPage(driver);
    }

    /** Click on the Consulting Nurse link to open the Consulting Nurse page
     * @return KPAUIConsultingNursePage
     */
    public KPAUIConsultingNursePage clickConsultingNurseLink(){
        getConsultingNurseLink().click();
        return new KPAUIConsultingNursePage(driver);
    }

    /** Click on Flu Symptoms Header to open the Flu Symptoms page
     * @return KPAUIFluSymptomsPage
     */
    public KPAUIFluSymptomsPage clickFluSymptomsHeader(){
        getFluSymptomsHeader().click();
        return new KPAUIFluSymptomsPage(driver);
    }

    /** Click on Flu Shot link to open the Flu Vaccinations page
     * @return KPAUIFluVaccinationPage
     */
    public KPAUIFluVaccinationPage clickGetAFluShotLink(){
        getFluShotLink().click();
        return new KPAUIFluVaccinationPage(driver);
    }

    /** Click on Health and Wellness link to open the Health and Wellness page
     * @return KPAUIHealthAndWellnessPage
     */
    public KPAUIHealthAndWellnessPage clickHealthAndWellnessLink(){
        getHealthAndWellnessLink().click();
        return new KPAUIHealthAndWellnessPage(driver);
    }

    /** Click on Pregnancy Services link to open the Pregnancy Services page
     * @return KPAUIPregnancyPage
     */
    public KPAUIPregnancyPage clickPregnancyServicesLink(){
        getPregnancyServicesLink().click();
        return new KPAUIPregnancyPage(driver);
    }

    /** Click on Refill Prescriptions link to open the Sign On Fcc page
     * @return KPAUISignOnFccPage
     */
    public KPAUISignOnFccPage clickRefillPrescriptionLink(){
        getRefillPrescriptionLink().click();
        return new KPAUISignOnFccPage(driver);
    }

    /** Click on Medical Records link to open the Medical Records page
     * @return KPAUIMedicalRecordsPage
     */
    public KPAUIMedicalRecordsPage clickRequestMedicalRecordsLink(){
        getRequestMedicalRecordsLink().click();
        return new KPAUIMedicalRecordsPage(driver);
    }

    /** Click on Reimbursement link to open the Reimbursement page
     * @return KPAUIReimbursementPage
     */
    public KPAUIReimbursementPage clickRequestReimbursementLink(){
        getRequestReimbursementLink().click();
        return new KPAUIReimbursementPage(driver);
    }

    /** Click on Vision and Eye Care link to open the Vision and Eye Care page
     * @return KPAUIVisionAndEyeCarePage
     */
    public KPAUIVisionAndEyeCarePage clickVisionAndEyeCareLink(){
        getVisionAndEyeCareLink().click();
        return new KPAUIVisionAndEyeCarePage(driver);
    }



    /** Optionally sign in, enter a search string and return on a search results page
     * @param searchString - String
     * @param signIn - MemberID and PW String
     * @param homepage - fresh page object
     * @return KPAUISearchResultsPage
     */
    public KPAUISearchResultsPage getSearchResultsPage(String searchString, boolean signIn,
                                                       KPAUIUnAuthenticatedHomePage homepage) {
        if (signIn)   return homepage.signIn(EVERYTHING).search(searchString);
        else        return homepage.search(searchString);
    }

    /** Click on the Shop Health Plans Link to open Health Plans Page
     * @return KPAUIHealthPlansPage
     */
    public KPAUIHealthPlansPage openHealthPlansPage(){
        getShopHealthPlansLink().click();
        return new KPAUIHealthPlansPage(driver);
    }

    /** Click on Find Doctors and Locations link to open Find a Doc page
     * @return KPAUIFindADoctorLandingPage
     */
    public KPAUIFindADoctorLandingPage openDoctorsAndLocationsPage(){
        getFindDocsAndLocationsLink().click();
        return new KPAUIFindADoctorLandingPage(driver);
    }

    /** Click on new Member Link to open the New Member Tool Kit Page
     * @return KPAUINewMemberToolkitPage
     */
    public KPAUINewMembersGuidePage openNewMemberToolKitPageFromTile(){
        getNewMemberLink().click();
        return new KPAUINewMembersGuidePage(driver);
    }

    /** Gets the source attribute from the Shop Our Plans Icon and check if it contains the expected file name.
     * @return Boolean
     */
    public boolean validateShopOurPlansIconSource(){
        return  getShopOurPlansIcon().getAttribute(srcAttribute)
                .contains(shopOurPlansTileIconFilename);
    }

    /** Gets the source attribute from the Doctors and Locations Icon and check if it contains the expected file name.
     * @return Boolean
     */
    public boolean validateDoctorsLocationsIconSource(){
        String doctorsAndLocationsTileIconFilename = "icon-doctors-and-locations.png";
        return  getDoctorsAndLocationsIcon().getAttribute(srcAttribute)
                .contains(doctorsAndLocationsTileIconFilename);
    }

    /** Gets the source attribute from the New Members Icon and check if it contains the expected file name.
     * @return Boolean
     */
    public boolean validateNewMembersIconSource(){
        String newMemberTileIconFilename = "icon-new-member-new.png";
        return  getNewMemberIcon().getAttribute(srcAttribute)
                .contains(newMemberTileIconFilename);
    }

    /** Get the Sign In Button if visible to determine if the shade is opened
     * @return Boolean
     */
    public boolean validateSignOnShadeIsClosed(){
        return getBtnSignOn().isDisplayed();
    }
}