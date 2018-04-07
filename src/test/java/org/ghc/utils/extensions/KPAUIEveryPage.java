package org.ghc.utils.extensions;

import org.ghc.pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.ghc.utils.KPAIUTestConstants.attributes.srcAttribute;
import static org.ghc.utils.KPAIUTestConstants.links.findADoctorLandingPage;
import static org.ghc.utils.KPAIUTestConstants.links.kpWAMemberSite;
import static org.ghc.utils.KPAIUTestConstants.links.kpWASite;
import static org.ghc.utils.helpers.KPAUIStringHelper.getSiteWithPrefix;
import static org.ghc.utils.helpers.KPAUITestHelper.*;

public class KPAUIEveryPage {
    public static WebDriver driver;

    public KPAUIEveryPage(WebDriver driver){
        KPAUIEveryPage.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //------------------------------------------------------------------------------------------------------------------

    //footer
    public static final String WEBSITE_SUPPORT_BUTTON_TEXT = "Website Support";
    public static final String WEBSITE_SUPPORT_PHONE_NUMBER_STRING = "1-888-874-1620";
    public static final String CAREERS_LINKTEXT = "Careers";
    public static final String TOU_AND_PRIVACY_POLICY_LINKTEXT = "Terms of Use & Privacy Policy";
    public static final String SITE_MAP_LINKTEXT = "Site Map";
    public static final String MEMBER_SERVICES_LINKTEXT = "Contact Us";
    public static final String HELP_LINKTEXT = "Help";
    public static final String LANGUAGE_ACCESS_LINKTEXT = "Language Access";
    public static final String footerCopyrightExpectedString = "Kaiser Foundation Health Plan of Washington";

    //footer Our Other Sites
    public static final String NEW_MEMBERS_LINKTEXT = "NEW MEMBERS";
    public static final String MEMBERS_LINKTEXT = "MEMBERS";
    public static final String EMPLOYERS_LINKTEXT = "EMPLOYERS";
    public static final String PRODUCERS_LINKTEXT = "PRODUCERS";
    public static final String PROVIDERS_LINKTEXT = "PROVIDERS";

    //footer Find Care
    public static final String FIND_CARE_CARE_OPTIONS_LINKTEXT = "Care Options";
    public static final String FIND_CARE_CARE_CLINICS_LINKTEXT = "CareClinic at Bartell Drugs";
    public static final String FIND_CARE_CONSULTING_NURSE_LINKTEXT = "Consulting Nurse";
    public static final String FIND_CARE_ONLINE_VISITS_LINKTEXT = "Online Visits";
    public static final String FIND_CARE_EMERGENCY_AND_URGENT_CARE_LINKTEXT = "Emergency & Urgent Care";
    public static final String FIND_CARE_LOCATIONS_LINKTEXT = "Locations";

    //footer Our Organization
    public static final String OUR_ORG_ABOUT_US_LINKTEXT = "About Us";
    public static final String OUR_ORG_AWARDS_AND_RECOGNITION_LINKTEXT = "Awards & Recognition";
    public static final String OUR_ORG_NEWS_AND_VIEWS_LINKTEXT = "News & Views";
    public static final String OUR_ORG_COMMUNITY_HEALTH_LINKTEXT = "Community Health";
    public static final String OUR_ORG_MEDIA_INQUIRIES_LINKTEXT = "Media Inquiries";
    public static final String OUR_ORG_KPWA_HEALTH_RESEARCH_INSTITUTE_LINKTEXT = "Kaiser Permanente Washington Health Research Institute";

    //footer Quick Links
    public static final String QUICK_MAKE_AN_APPOINTMENT_LINKTEXT = "Make an Appointment";
    public static final String QUICK_REQUEST_REIMBURSEMENT_LINKTEXT = "Request Reimbursement";
    public static final String QUICK_REQUEST_MEDICAL_RECORDS_LINKTEXT = "Request Medical Records";
    public static final String QUICK_REFILL_A_PRESCRIPTION_LINKTEXT = "Refill a Prescription";
    public static final String FIND_CARE_CARE_WHILE_TRAVELING_LINKTEXT = "Care While Traveling";
    public static final String FIND_CARE_HEALTH_AND_WELLNESS_LINKTEXT = "Health & Wellness";
    public static final String QUICK_FINANCIAL_ASSISTANCE_LINKTEXT = "Financial Assistance";
    public static final String QUICK_FORMS_LINKTEXT = "Forms";
    public static final String QUICK_TOUR_ONLINE_SERVICES_LINKTEXT = "Tour Online Services";

    //footer Headers
    public static final String LINKTEXT_FIND_CARE = "FIND CARE";
    public static final String LINKTEXT_OUR_ORGANIZATION = "OUR ORGANIZATION";
    public static final String LINKTEXT_QUICK_LINKS = "QUICK LINKS";
    public static final String TEXT_PARTNER_SITES = "visit our other sites";


    //Finders
    @FindBy(xpath = "//div[2]/div[1]/a/img")                                private WebElement footerAppStoreAppleButton;
    @FindBy(xpath = "//div[2]/div[2]/a/img")                                private WebElement footerAppStoreGoogleButton;
    @FindBy(linkText = "Contact Us")                                        private WebElement footerLegalAndCustomerServiceContactUsLink;
    @FindBy(linkText = "Help")                                              private WebElement footerLegalAndCustomerServiceHelpLink;
    @FindBy(linkText = "Language Access")                                   private WebElement footerLegalAndCustomerServiceLanguageAccessLink;
    @FindBy(linkText = "Site Map")                                          private WebElement footerLegalAndCustomerServiceSiteMapLink;
    @FindBy(partialLinkText = "Terms of Use")                               private WebElement footerLegalAndCustomerServiceTOUAndPolicyLink;
    @FindBy(xpath = "//core-footer/div/div[1]/div[5]")                      private WebElement footerLegalCopyright;
    @FindBy(xpath = "//core-footer/div/div[1]/div[1]/div[4]/div")           private WebElement footerNavFindCareHeader;
    @FindBy(xpath = "//div[1]/div[4]/ul/li[1]/a")                           private WebElement footerNavFindCareCareOptionsLink;
    @FindBy(xpath = "//div[1]/div[4]/ul/li[2]/a")                           private WebElement footerNavFindCareWalkInCareClinicsLink;
    @FindBy(xpath = "//div[1]/div[4]/ul/li[3]/a")                           private WebElement footerNavFindCareConsultingNurseLink;
    @FindBy(xpath = "//div[1]/div[4]/ul/li[4]/a")                           private WebElement footerNavFindCareOnlineVisitsLink;
    @FindBy(xpath = "//div[1]/div[4]/ul/li[5]/a")                           private WebElement footerNavFindCareEmergencyAndUrgentCareLink;
    @FindBy(xpath = "//div[1]/div[4]/ul/li[6]/a")                           private WebElement footerNavFindCareClinicLocationsLink;
    @FindBy(xpath = "//div[1]/div[4]/ul/li[7]/a")                           private WebElement footerNavFindCareCareWhileTravelingLink;
    @FindBy(xpath = "//div[1]/div[4]/ul/li[8]/a")                           private WebElement footerNavHealthAndWellnessLink;
    @FindBy(xpath = "//core-footer/div/div[1]/div[1]/div[3]/div")           private WebElement footerNavOurOrgHeader;
    @FindBy(xpath = "//div[1]/div[3]/ul/li[1]/a")                           private WebElement footerNavOurOrgAboutUsLink;
    @FindBy(xpath = "//div[1]/div[3]/ul/li[3]/a")                           private WebElement footerNavOurOrgAwardsRecognitionLink;
    @FindBy(xpath = "//div[1]/div[3]/ul/li[7]/a")                           private WebElement footerNavOurOrgCareersLink;
    @FindBy(xpath = "//div[1]/div[3]/ul/li[2]/a")                           private WebElement footerNavOurOrgCommunityHealthLink;
    @FindBy(xpath = "//div[1]/div[3]/ul/li[5]/a")                           private WebElement footerNavOurOrgMediaInquiriesLink;
    @FindBy(xpath = "//div[1]/div[3]/ul/li[4]/a")                           private WebElement footerNavOurOrgNewsAndViewsLink;
    @FindBy(xpath = "//div[1]/div[3]/ul/li[6]/a")                           private WebElement footerNavOurOrgKPWAHealthResearchInstituteLink;
    @FindBy(xpath = "//div[1]/div[2]/ul/li[5]/a")                           private WebElement footerNavQuickLinksFinancialAssistanceLink;
    @FindBy(xpath = "//div[1]/div[2]/ul/li[6]/a")                           private WebElement footerNavQuickLinksFormsLink;
    @FindBy(xpath = "//core-footer/div/div[1]/div[1]/div[2]/div")           private WebElement footerNavQuickLinksHeader;
    @FindBy(xpath = "//div[1]/div[2]/ul/li[1]/a")                           private WebElement footerNavQuickLinksMakeAnAppointmentLink;
    @FindBy(xpath = "//div[1]/div[2]/ul/li[4]/a")                           private WebElement footerNavQuickLinksRefillAPrescriptionLink;
    @FindBy(xpath = "//div[1]/div[2]/ul/li[3]/a")                           private WebElement footerNavQuickLinksRequestMedicalRecordsLink;
    @FindBy(xpath = "//div[1]/div[2]/ul/li[2]/a")                           private WebElement footerNavQuickLinksRequestReimbursementLink;
    @FindBy(xpath = "//div[1]/div[2]/ul/li[7]/a")                           private WebElement footerNavQuickLinksTourOnlineServicesLink;
    @FindBy(xpath = "//div[1]/div[1]/ul/li[3]/a")                           private WebElement footerPartnerSitesEmployersLink;
    @FindBy(xpath = "//core-footer/div/div[1]/div[1]/div[1]/div")           private WebElement footerPartnerSitesHeader;
    @FindBy(xpath = "//core-footer/div/div[1]/div[1]/div[1]/ul/li[2]/a")    private WebElement footerPartnerSitesMembersLink;
    @FindBy(xpath = "//div[1]/div[1]/ul/li[1]/a")                           private WebElement footerPartnerSitesNewMembersLink;
    @FindBy(xpath = "//div[1]/div[1]/ul/li[4]/a")                           private WebElement footerPartnerSitesProducersLink;
    @FindBy(xpath = "//div[1]/div[1]/ul/li[5]/a")                           private WebElement footerPartnerSitesProvidersLink;
    @FindBy(xpath = "//core-footer/div/div[1]/div[3]/a[2]")                 private WebElement footerSocialRibbonFacebookButton;
    @FindBy(xpath = "//core-footer/div/div[1]/div[3]/a[4]")                 private WebElement footerSocialRibbonInstagramButton;
    @FindBy(xpath = "//core-footer/div/div[1]/div[3]/a[3]")                 private WebElement footerSocialRibbonLinkedInButton;
    @FindBy(xpath = "//core-footer/div/div[1]/div[3]/a[1]")                 private WebElement footerSocialRibbonTwitterButton;
    @FindBy(xpath = "//div[2]/div[1]/a")                                    private WebElement footerWebsiteSupportButton;
    @FindBy(xpath = "//div[2]/div[1]/p")                                    private WebElement footerWebsiteSupportPhone;
    @FindBy(css = ".header .logo[src*='page-shell/img/header_logo.svg']")   private WebElement headerLogoImage;
    @FindBy(css = ".input-group-btn.header-search-button")                  private WebElement headerSearchButton;
    @FindBy(css = ".header .form-control")                                  private WebElement headerSearchForm;

    //Getters
    public WebElement getFooterAppStoreAppleButton()                        { return waitForElementToBeClickable(footerAppStoreAppleButton, driver); }
    public WebElement getFooterAppStoreGoogleButton()                       { return waitForElementToBeClickable(footerAppStoreGoogleButton, driver); }
    public WebElement getFooterLegalAndCustomerServiceContactUsLink()       { return waitForElementToBeClickable(footerLegalAndCustomerServiceContactUsLink, driver); }
    public WebElement getFooterLegalAndCustomerServiceHelpLink()            { return waitForElementToBeClickable(footerLegalAndCustomerServiceHelpLink, driver); }
    public WebElement getFooterLegalAndCustomerServiceLanguageAccessLink()  { return waitForElementToBeClickable(footerLegalAndCustomerServiceLanguageAccessLink, driver); }
    public WebElement getFooterLegalAndCustomerServiceSiteMapLink()         { return waitForElementToBeClickable(footerLegalAndCustomerServiceSiteMapLink, driver); }
    public WebElement getFooterLegalAndCustomerServiceTOUAndPolicyLink()    { return waitForElementToBeClickable(footerLegalAndCustomerServiceTOUAndPolicyLink, driver);}
    public WebElement getFooterLegalCopyright()                             { return waitForElement(footerLegalCopyright, driver); }
    public WebElement getFooterNavFindCareHeader()                          { return waitForElementToBeClickable(footerNavFindCareHeader, driver); }
    public WebElement getFooterNavFindCareCareOptionsLink()                 { return waitForElementToBeClickable(footerNavFindCareCareOptionsLink, driver); }
    public WebElement getFooterNavigationFindClinicsAtBartellDrugsLink()    { return waitForElementToBeClickable(footerNavFindCareWalkInCareClinicsLink, driver); }
    public WebElement getFooterNavFindCareConsultingNurseLink()             { return waitForElementToBeClickable(footerNavFindCareConsultingNurseLink,driver); }
    public WebElement getFooterNavFindCareOnlineVisitsLink()                { return waitForElementToBeClickable(footerNavFindCareOnlineVisitsLink, driver); }
    public WebElement getFooterNavigationFindCareEmergencyUrgentCareLink()  { return waitForElementToBeClickable(footerNavFindCareEmergencyAndUrgentCareLink,driver); }
    public WebElement getFooterNavigationFindCareLocationsLink()            { return waitForElementToBeClickable(footerNavFindCareClinicLocationsLink, driver); }
    public WebElement getFooterNavFindCareCareWhileTravelingLink()          { return waitForElementToBeClickable(footerNavFindCareCareWhileTravelingLink, driver); }
    public WebElement getFooterNavigationFindCareHealthAndWellnessLink()    { return waitForElementToBeClickable(footerNavHealthAndWellnessLink, driver); }
    public WebElement getFooterNavOurOrgHeader()                            { return waitForElementToBeClickable(footerNavOurOrgHeader, driver); }
    public WebElement getFooterNavOurOrgAboutUsLink()                       { return waitForElementToBeClickable(footerNavOurOrgAboutUsLink, driver); }
    public WebElement getFooterNavOurOrgAwardsRecognitionLink()             { return waitForElementToBeClickable(footerNavOurOrgAwardsRecognitionLink, driver); }
    public WebElement getFooterNavOurOrgCareersLink()                       { return waitForElementToBeClickable(footerNavOurOrgCareersLink, driver); }
    public WebElement getFooterNavOurOrgCommunityHealthLink()               { return waitForElementToBeClickable(footerNavOurOrgCommunityHealthLink, driver); }
    public WebElement getFooterNavOurOrgMediaInquiriesLink()                { return waitForElementToBeClickable(footerNavOurOrgMediaInquiriesLink, driver); }
    public WebElement getFooterNavOurOrgNewsAndViewsLink()                  { return waitForElementToBeClickable(footerNavOurOrgNewsAndViewsLink, driver); }
    public WebElement getFooterNavOurOrgKPWAHealthResearchInstituteLink()   { return waitForElementToBeClickable(footerNavOurOrgKPWAHealthResearchInstituteLink, driver); }
    public WebElement getFooterNavQuickLinksFinancialAssistanceLink()       { return waitForElementToBeClickable(footerNavQuickLinksFinancialAssistanceLink, driver); }
    public WebElement getFooterNavQuickLinksFormsLink()                     { return waitForElementToBeClickable(footerNavQuickLinksFormsLink, driver); }
    public WebElement getFooterNavQuickLinksHeader()                        { return waitForElementToBeClickable(footerNavQuickLinksHeader, driver); }
    public WebElement getFooterNavQuickLinksMakeAnAppointmentLink()         { return waitForElementToBeClickable(footerNavQuickLinksMakeAnAppointmentLink, driver); }
    public WebElement getFooterNavQuickLinksRefillAPrescriptionLink()       { return waitForElementToBeClickable(footerNavQuickLinksRefillAPrescriptionLink, driver); }
    public WebElement getFooterNavQuickLinksRequestMedicalRecordsLink()     { return waitForElementToBeClickable(footerNavQuickLinksRequestMedicalRecordsLink, driver); }
    public WebElement getFooterNavQuickLinksRequestReimbursementLink()      { return waitForElementToBeClickable(footerNavQuickLinksRequestReimbursementLink, driver); }
    public WebElement getFooterNavQuickLinksTourOnlineServicesLink()        { return waitForElementToBeClickable(footerNavQuickLinksTourOnlineServicesLink, driver); }
    public WebElement getFooterPartnerSitesEmployersLink()                  { return waitForElementToBeClickable(footerPartnerSitesEmployersLink, driver); }
    public WebElement getFooterPartnerSitesHeader()                         { return waitForElementToBeClickable(footerPartnerSitesHeader, driver); }
    public WebElement getFooterPartnerSitesMembersLink()                    { return waitForElementToBeClickable(footerPartnerSitesMembersLink, driver); }
    public WebElement getFooterPartnerSitesNewMembersLink()                 { return waitForElementToBeClickable(footerPartnerSitesNewMembersLink, driver); }
    public WebElement getFooterPartnerSitesProducersLink()                  { return waitForElementToBeClickable(footerPartnerSitesProducersLink, driver); }
    public WebElement getFooterPartnerSitesProvidersLink()                  { return waitForElementToBeClickable(footerPartnerSitesProvidersLink, driver); }
    public WebElement getFooterSocialRibbonFacebookButton()                 { return waitForElementToBeClickable(footerSocialRibbonFacebookButton, driver); }
    public WebElement getFooterSocialRibbonInstagramButton()                { return waitForElementToBeClickable(footerSocialRibbonInstagramButton, driver); }
    public WebElement getFooterSocialRibbonLinkedInButton()                 { return waitForElementToBeClickable(footerSocialRibbonLinkedInButton, driver); }
    public WebElement getFooterSocialRibbonTwitterButton()                  { return waitForElementToBeClickable(footerSocialRibbonTwitterButton, driver); }
    public WebElement getFooterWebsiteSupportButton()                       { return waitForElementToBeClickable(footerWebsiteSupportButton, driver); }
    public WebElement getFooterWebsiteSupportPhone()                        { return waitForElement(footerWebsiteSupportPhone, driver); }
    private WebElement getHeaderLogoImage()                                 { return waitForElement(headerLogoImage, driver); }
    public WebElement getHeaderSearchButton()                               { return waitForElementToBeClickable(headerSearchButton, driver); }
    public WebElement getHeaderSearchForm()                                 { return waitForElement(headerSearchForm, driver); }


    // Methods
    /** Click on New Members link to open the New Members Toolkit page
     * @return KPAUINewMemberToolkitPage
     */
    public KPAUINewMembersGuidePage openNewMembersGuidePageFromFooter() {
        getFooterPartnerSitesNewMembersLink().click();
        return new KPAUINewMembersGuidePage(driver);
}

    /** Click on Members link to open the Authenticated Home page
     * @return KPAUIAuthenticatedHomePage
     */
    public KPAUIAuthenticatedHomePage openAuthHomePageFromFooter() {
        getFooterPartnerSitesMembersLink().click();
        return new KPAUIAuthenticatedHomePage(driver);
}

    /** Uses driver.get() to open the Authenticated Home page
     * @return KPAUIAuthenticatedHomePage
     */
    public KPAUIAuthenticatedHomePage openAuthenticatedHomePage() {
        driver.get(getSiteWithPrefix(kpWAMemberSite));
        return new KPAUIAuthenticatedHomePage(driver);
    }

    /** Uses driver.get() to open the UnAuthenticated Home page
     * @return KPAUIUnAuthenticatedHomePage
     */
    public KPAUIUnAuthenticatedHomePage openUnAuthenticatedHomePage() {
        driver.get(getSiteWithPrefix(kpWASite));
        return new KPAUIUnAuthenticatedHomePage(driver);
    }

    /** Click on UnAuthenticated Members link to open the Login FCC page
     * @return KPAUISignOnFccPage
     */
    public KPAUISignOnFccPage openSignOnFCCPageFromFooter() {
        getFooterPartnerSitesMembersLink().click();
        return new KPAUISignOnFccPage(driver);
}

    /** Click on Employers link to open the UnAuthenticated Business page
     * @return KPAUIUnauthenticatedBusinessPage
     */
    public KPAUIUnauthenticatedBusinessPage openUnauthenticatedBusinessPage() {
        getFooterPartnerSitesEmployersLink().click();
        return new KPAUIUnauthenticatedBusinessPage(driver);
}

    /** Click on Producers link to open the UnAuthenticated Producers page
     * @return KPAUIUnauthenticatedProducersPage
     */
    public KPAUIUnauthenticatedProducersPage openUnauthenticatedProducersPage() {
        getFooterPartnerSitesProducersLink().click();
        return new KPAUIUnauthenticatedProducersPage(driver);
}

    /** Click on Providers link to open the UnAuthenticated Providers page
     * @return KPAUIUnauthenticatedProvidersPage
     */
    public KPAUIUnauthenticatedProvidersPage openUnauthenticatedProvidersPage() {
        getFooterPartnerSitesProvidersLink().click();
        return new KPAUIUnauthenticatedProvidersPage(driver);
}

    /** Click on Make an Appointment link to open the Schedule Appointment page
     * @return KPAUIScheduleAppointmentPage
     */
    public KPAUIScheduleAppointmentPage openQuickLinksMakeAnAppointmentPage() {
        getFooterNavQuickLinksMakeAnAppointmentLink().click();
        return new KPAUIScheduleAppointmentPage(driver);
}

    /** Click on Submit Claim link to open the Submit Claim page
     * @return KPAUIHowToSubmitClaimPage
     */
    public KPAUIHowToSubmitClaimPage openQuickLinksRequestReimbursementPage() {
        getFooterNavQuickLinksRequestReimbursementLink().click();
        return new KPAUIHowToSubmitClaimPage(driver);
}

    /** Click on Medical Records link to open the Request Medical Records page
     * @return KPAUIRequestMedicalRecordsPage
     */
    public KPAUIRequestMedicalRecordsPage openQuickLinksRequestMedicalRecordsPage() {
        getFooterNavQuickLinksRequestMedicalRecordsLink().click();
        return new KPAUIRequestMedicalRecordsPage(driver);
}

    /** Click on Refill Prescription link to open the Refill Prescription page
     * @return KPAUIRefillPrescriptionPage
     */
    public KPAUIRefillPrescriptionPage openQuickLinksRefillPrescriptionPage() {
        getFooterNavQuickLinksRefillAPrescriptionLink().click();
        return new KPAUIRefillPrescriptionPage(driver);
}


    /** Uses driver.get() to open the Find A Doctor Landing Page page
     * @return KPAUIAuthenticatedHomePage
     */
    public KPAUIFindADoctorLandingPage openFindADoctorLandingPage() {
        driver.get(getSiteWithPrefix(findADoctorLandingPage));
        return new KPAUIFindADoctorLandingPage(driver);
    }

    /** Click on Care While Traveling link to open the Care While Traveling page
     * @return KPAUICareWhileTravelingPage
     */
    public KPAUICareWhileTravelingPage openFindCareCareWhileTravelingPage() {
        getFooterNavFindCareCareWhileTravelingLink().click();
        return new KPAUICareWhileTravelingPage(driver);
}

    /** Click on Financial Assistance link to open the Financial Assistance page
     * @return KPAUIFinancialAssistancePage
     */
    public KPAUIFinancialAssistancePage openQuickLinksFinancialAssistancePage() {
        getFooterNavQuickLinksFinancialAssistanceLink().click();
        return new KPAUIFinancialAssistancePage(getChildDriver(driver));
}

    /** Click on Forms link to open the Common Forms page
     * @return KPAUIFormsPage
     */
    public KPAUIFormsPage openQuickLinksFormsPage() {
        getFooterNavQuickLinksFormsLink().click();
        return new KPAUIFormsPage(driver);
}

    /** Click on Tour Online Services link to open the Tour Online Services page
     * @return KPAUITourOnlineServicesPage
     */
    public KPAUITourOnlineServicesPage openQuickLinksTourOnlineServicesPage() {
        getFooterNavQuickLinksTourOnlineServicesLink().click();
        return new KPAUITourOnlineServicesPage(driver);
}

    /** Click on About Us link to open the About Us page
     * @return KPAUIAboutUsPage
     */
    public KPAUIAboutUsPage openOurOrganizationAboutUsPage() {
        getFooterNavOurOrgAboutUsLink().click();
        return new KPAUIAboutUsPage(driver);
}

    /** Click on Awards & Recognition link to open the Awards & Recognition page
     * @return KPAUIAwardsAndRecognitionPage
     */
    public KPAUIAwardsAndRecognitionPage openOurOrganizationAwardsAndRecognitionPage() {
        getFooterNavOurOrgAwardsRecognitionLink().click();
        return new KPAUIAwardsAndRecognitionPage(driver);
}

    /** Click on News & Views link to open the News & Views page
     * @return KPAUINewsAndViewsPage
     */
    public KPAUINewsAndViewsPage openOurOrganizationNewsAndViewsPage() {
        getFooterNavOurOrgNewsAndViewsLink().click();
        return new KPAUINewsAndViewsPage(driver);
}

    /** Click on Community Health link to open the Community Health page
     * @return KPAUICommunityHealthPage
     */
    public KPAUICommunityHealthPage openOurOrganizationCommunityHealthPage() {
        getFooterNavOurOrgCommunityHealthLink().click();
        return new KPAUICommunityHealthPage(driver);
}

    /** Click on Media Inquiries link to open the Media Inquiries page
     * @return KPAUIMediaInquiriesPage
     */
    public KPAUIMediaInquiriesPage openOurOrganizationMediaInquiriesPage() {
        getFooterNavOurOrgMediaInquiriesLink().click();
        return new KPAUIMediaInquiriesPage(driver);
}

    /** Click on KP WA Health Research Institute link to open the KP WA Health Research Institute page
     * @return KPAUIKPWAHealthResearchInstitutePage
     */
    public KPAUIKPWAHealthResearchInstitutePage openOurOrganizationKPWAHealthResearchInstitutePage() {
        getFooterNavOurOrgKPWAHealthResearchInstituteLink().click();
        return new KPAUIKPWAHealthResearchInstitutePage(driver);
}

    /** Click on Care Options link to open the Care Options page
     * @return KPAUICareOptionsPage
     */
    public KPAUICareOptionsPage openFindCareCareOptionsPage() {
        getFooterNavFindCareCareOptionsLink().click();
        sleep(2);
        return new KPAUICareOptionsPage(driver);
}

    /** Click on Care Clinics link to open the Care Clinics page
     * @return KPAUICareClinicsPage
     */
    public KPAUIBartellsCareClinicsPage openClinicsAtBartellDrugsPage() {
        getFooterNavigationFindClinicsAtBartellDrugsLink().click();
        return new KPAUIBartellsCareClinicsPage(driver);
}

    /** Click on Consulting Nurse link to open the Consulting Nurse page
     * @return KPAUICareOptionsPage
     */
    public KPAUIConsultingNursePage openConsultingNursePage() {
        getFooterNavFindCareConsultingNurseLink().click();
        return new KPAUIConsultingNursePage(driver);
}

    /** Click on Online Visits link to open the Online Visits page
     * @return KPAUIOnlineVisitsPage
     */
    public KPAUIOnlineVisitsPage openOnlineVisitsPage() {
        getFooterNavFindCareOnlineVisitsLink().click();
        return new KPAUIOnlineVisitsPage(driver);
}

    /** Click on Emergency And Urgent Care link to open the Emergency And Urgent Care page
     * @return KPAUIEmergencyAndUrgentCarePage
     */
    public KPAUIEmergencyAndUrgentCarePage openEmergencyAndUrgentCarePage() {
        getFooterNavigationFindCareEmergencyUrgentCareLink().click();
        return new KPAUIEmergencyAndUrgentCarePage(driver);
}

    /** Click on Clinic Locations link to open the Clinic Locations page
     * @return KPAUIClinicLocationsPage
     */
    public KPAUIClinicLocationsPage openLocationsPage() {
        getFooterNavigationFindCareLocationsLink().click();
        return new KPAUIClinicLocationsPage(driver);
}

    /** Click on Health And Wellness link to open the Health And Wellness page
     * @return KPAUIHealthAndWellnessPage
     */
    public KPAUIHealthAndWellnessPage openFindCareHealthAndWellnessPage() {
        getFooterNavigationFindCareHealthAndWellnessLink().click();
        return new KPAUIHealthAndWellnessPage(driver);
}

    /** Click on KP Instagram link to open the KP Instagram page
     * @return KPAUIInstagramPage
     */
    public KPAUIInstagramPage openKPInstagramPage() {
        getFooterSocialRibbonInstagramButton().click();
        return new KPAUIInstagramPage(driver);
}

    /** Click on KP Instagram link to open the KP Instagram page
     * @return KPAUIInstagramPage
     */
    public KPAUITwitterPage openKPTwitterPage() {
        getFooterSocialRibbonTwitterButton().click();
        return new KPAUITwitterPage(driver);
}

    /** Click on KP Facebook link to open the KP Facebook page
     * @return KPAUIFacebookPage
     */
    public KPAUIFacebookPage openKPFacebookPage() {
        getFooterSocialRibbonFacebookButton().click();
        return new KPAUIFacebookPage(driver);
}

    /** Click on KP LinkedIn link to open the KP LinkedIn page
     * @return KPAUILinkedInPage
     */
    public KPAUILinkedInPage openKPLinkedInPage() {
        getFooterSocialRibbonLinkedInButton().click();
        return new KPAUILinkedInPage(driver);
}

    /** Click on UnAuthenticated KP Careers link to open the UnAuthenticated KP Careers page
     * @return KPAUILinkedInPage
     */
    public KPAUIUnauthenticatedCareersPage openCareersPage() {
        getFooterNavOurOrgCareersLink().click();
        return new KPAUIUnauthenticatedCareersPage(getChildDriver(driver));
}

    /** Click on Terms Of Use and Privacy Policy link to open the  Terms Of Use and Privacy Policy page
     * @return KPAUITOUAndPrivacyPolicyPage
     */
    public KPAUITOUAndPrivacyPolicyPage openTOUAndPrivacyPolicyPage() {
        getFooterLegalAndCustomerServiceTOUAndPolicyLink().click();
        return new KPAUITOUAndPrivacyPolicyPage(driver);
}

    /** Click on Site Map link to open the Site Map page
     * @return KPAUISiteMapPage
     */
    public KPAUISiteMapPage openSiteMapPage() {
        getFooterLegalAndCustomerServiceSiteMapLink().click();
        return new KPAUISiteMapPage(driver);
}

    /** Click on Member Services link to open the Member Services page
     * @return KPAUIMemberServicesPage
     */
    public KPAUIMemberServicesPage openMemberServicesPage() {
        sleep(1);
        getFooterLegalAndCustomerServiceContactUsLink().click();
        return new KPAUIMemberServicesPage(driver);
}

    /** Click on Help link to open the Help page
     * @return KPAUIHelpPage
     */
    public KPAUIHelpPage openHelpPage() {
        sleep(1);
        getFooterLegalAndCustomerServiceHelpLink().click();
        return new KPAUIHelpPage(driver);
}

    /** Click on Language Access link to open the Language Access page
     * @return KPAUILinkedInPage
     */
    public KPAUILanguageAccessPage openLanguageAccessPage() {
        getFooterLegalAndCustomerServiceLanguageAccessLink().click();
        return new KPAUILanguageAccessPage(getChildDriver(driver));
}

    /** Click on Website Support link to open the Website Support page
     * @return KPAUIWebsiteSupportPage
     */
    public KPAUIWebsiteSupportPage openWebsiteSupportPage() {
        getFooterWebsiteSupportButton().click();
        return new KPAUIWebsiteSupportPage(driver);
}

    /** Click on Apple Store link to open the Apple Store page
     * @return KPAUIItunesPage
     */
    public KPAUIItunesPage openUnAuthenticatedItunesPage() {
        getFooterAppStoreAppleButton().click();
        return new KPAUIItunesPage(driver);
}

    /** Click on Google Play Store link to open the Google Play Store page
     * @return KPAUIGooglePlayPage
     */
    public KPAUIGooglePlayPage openUnauthenticatedGooglePlayPage() {
        getFooterAppStoreGoogleButton().click();
        return new KPAUIGooglePlayPage(driver);
}

    /** Checks every 1000ms (1sec) for the Page Title to match expected Page Title times out after 15 sec)
     * @param driver - The Current WebDriver
     * @param pageTitle - The Page Title that is expected
     */
    public static boolean isCurrent(WebDriver driver, String pageTitle) {
        System.out.println("ExpectedTitle:\t\t\t" + pageTitle);
        System.out.println("DriverTitle:\t\t\t" + driver.getTitle());
        System.out.println("Contains text?:\t\t\t" + driver.getTitle().toLowerCase().contains(pageTitle.toLowerCase()));
        System.out.println("--------------------------------------------");

        WebDriverWait wait = new WebDriverWait(driver, 15, 1000);
        try {wait.until(titleContainsCaseInsensitive(pageTitle)); }
        catch(Exception ex) {
            System.out.println("Wait For Page Load Failed on: " + pageTitle );
        }
        return driver.getTitle().toLowerCase().contains(pageTitle.toLowerCase());
    }


    /** Gets the source attribute from the Unauthenticated Header Logo image and verifies it matches the expected source
     * @return boolean
     */
    public boolean verifyUnauthenticatedHeaderLogoSource() {
        return getHeaderLogoImage().getAttribute(srcAttribute)
                .contains("/static/page-shell/assets/page-shell/img/header_logo.svg");
    }

    /** Gets the source attribute from the Authenticated Header Logo image and verifies it matches the expected source
     * @return - True if the Header logo image matches header_logo.src
     */
    public boolean verifyAuthenticatedHeaderLogoSource() {
        return getHeaderLogoImage().getAttribute(srcAttribute)
                .contains("/home/assets/page-shell/img/header_logo.svg");
    }

    /** This will use the search feature in the header to search for the desired search string
     * @param searchString - The desired String to search for
     * @return - The Search Results Page KPAUISearchResultsPage
     */
    public KPAUISearchResultsPage search(String searchString){
        getHeaderSearchForm().sendKeys(searchString);
        getHeaderSearchButton().click();
        return new KPAUISearchResultsPage(driver);
    }
}
