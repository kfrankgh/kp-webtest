package org.ghc.tests.navigation;

import org.ghc.pages.KPAUIUnAuthenticatedHomePage;
import org.ghc.utils.extensions.KPAUIEveryTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.lang.reflect.Method;

import static org.ghc.utils.KPAUICredentials.accountName.EVERYTHING;
import static org.ghc.utils.helpers.KPAUITestHelper.*;
import static org.ghc.utils.extensions.KPAUIEveryPage.*;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class KPAUIFooterTests extends KPAUIEveryTest {
    private KPAUIUnAuthenticatedHomePage unAuthenticatedHomePage;

    @BeforeMethod(alwaysRun = true)
    public void beforeTest(Method method) {
        unAuthenticatedHomePage = super.initializeTest(method);
    }

    //------------------------------------------------------------------------------------------------------------------

    @Test(description = "Verify All the Footer Links are Displayed for Unauthenticated Home", groups = {"smoke", "qa", "prod"})
    public void verifyFooterLinksAreDisplayedForUnAuthenticatedHome() {
        // CATEGORIES
        assertEquals(unAuthenticatedHomePage.getFooterWebsiteSupportPhone().getText(), WEBSITE_SUPPORT_PHONE_NUMBER_STRING);
        assertContains(unAuthenticatedHomePage.getFooterLegalCopyright().getText(), footerCopyrightExpectedString);
        assertEqualsInsensitive(unAuthenticatedHomePage.getFooterWebsiteSupportButton().getText(), WEBSITE_SUPPORT_BUTTON_TEXT);
        assertEqualsInsensitive(unAuthenticatedHomePage.getFooterPartnerSitesHeader().getText(), TEXT_PARTNER_SITES);
        assertEqualsInsensitive(unAuthenticatedHomePage.getFooterPartnerSitesNewMembersLink().getText(), NEW_MEMBERS_LINKTEXT);
        assertEqualsInsensitive(unAuthenticatedHomePage.getFooterPartnerSitesMembersLink().getText(), MEMBERS_LINKTEXT);
        assertEqualsInsensitive(unAuthenticatedHomePage.getFooterPartnerSitesEmployersLink().getText(), EMPLOYERS_LINKTEXT);
        assertEqualsInsensitive(unAuthenticatedHomePage.getFooterPartnerSitesProducersLink().getText(), PRODUCERS_LINKTEXT);
        assertEqualsInsensitive(unAuthenticatedHomePage.getFooterPartnerSitesProvidersLink().getText(), PROVIDERS_LINKTEXT);
        assertEqualsInsensitive(unAuthenticatedHomePage.getFooterNavQuickLinksHeader().getText(), LINKTEXT_QUICK_LINKS);
        assertEqualsInsensitive(unAuthenticatedHomePage.getFooterNavOurOrgHeader().getText(), LINKTEXT_OUR_ORGANIZATION);
        assertEqualsInsensitive(unAuthenticatedHomePage.getFooterNavFindCareHeader().getText(), LINKTEXT_FIND_CARE);

        // QUICK LINKS
        assertEqualsInsensitive(unAuthenticatedHomePage.getFooterNavQuickLinksMakeAnAppointmentLink().getText(), QUICK_MAKE_AN_APPOINTMENT_LINKTEXT);
        assertEqualsInsensitive(unAuthenticatedHomePage.getFooterNavQuickLinksRequestReimbursementLink().getText(), QUICK_REQUEST_REIMBURSEMENT_LINKTEXT);
        assertEqualsInsensitive(unAuthenticatedHomePage.getFooterNavQuickLinksRequestMedicalRecordsLink().getText(), QUICK_REQUEST_MEDICAL_RECORDS_LINKTEXT);
        assertEqualsInsensitive(unAuthenticatedHomePage.getFooterNavQuickLinksRefillAPrescriptionLink().getText(), QUICK_REFILL_A_PRESCRIPTION_LINKTEXT);
        assertEqualsInsensitive(unAuthenticatedHomePage.getFooterNavQuickLinksFinancialAssistanceLink().getText(), QUICK_FINANCIAL_ASSISTANCE_LINKTEXT);
        assertEqualsInsensitive(unAuthenticatedHomePage.getFooterNavQuickLinksFormsLink().getText(), QUICK_FORMS_LINKTEXT);
        assertEqualsInsensitive(unAuthenticatedHomePage.getFooterNavQuickLinksTourOnlineServicesLink().getText(), QUICK_TOUR_ONLINE_SERVICES_LINKTEXT);

        // OUR ORGANIZATION
        assertEqualsInsensitive(unAuthenticatedHomePage.getFooterNavOurOrgAboutUsLink().getText(), OUR_ORG_ABOUT_US_LINKTEXT);
        assertEqualsInsensitive(unAuthenticatedHomePage.getFooterNavOurOrgCommunityHealthLink().getText(), OUR_ORG_COMMUNITY_HEALTH_LINKTEXT);
        assertEqualsInsensitive(unAuthenticatedHomePage.getFooterNavOurOrgAwardsRecognitionLink().getText(), OUR_ORG_AWARDS_AND_RECOGNITION_LINKTEXT);
        assertEqualsInsensitive(unAuthenticatedHomePage.getFooterNavOurOrgNewsAndViewsLink().getText(), OUR_ORG_NEWS_AND_VIEWS_LINKTEXT);
        assertEqualsInsensitive(unAuthenticatedHomePage.getFooterNavOurOrgMediaInquiriesLink().getText(), OUR_ORG_MEDIA_INQUIRIES_LINKTEXT);
        assertEqualsInsensitive(unAuthenticatedHomePage.getFooterNavOurOrgKPWAHealthResearchInstituteLink().getText(), OUR_ORG_KPWA_HEALTH_RESEARCH_INSTITUTE_LINKTEXT);
        assertEqualsInsensitive(unAuthenticatedHomePage.getFooterNavOurOrgCareersLink().getText(), CAREERS_LINKTEXT);

        // FIND CARE
        assertEqualsInsensitive(unAuthenticatedHomePage.getFooterNavFindCareCareOptionsLink().getText(), FIND_CARE_CARE_OPTIONS_LINKTEXT);
        assertEqualsInsensitive(unAuthenticatedHomePage.getFooterNavigationFindClinicsAtBartellDrugsLink().getText(), FIND_CARE_CARE_CLINICS_LINKTEXT);
        assertEqualsInsensitive(unAuthenticatedHomePage.getFooterNavFindCareConsultingNurseLink().getText(), FIND_CARE_CONSULTING_NURSE_LINKTEXT);
        assertEqualsInsensitive(unAuthenticatedHomePage.getFooterNavFindCareOnlineVisitsLink().getText(), FIND_CARE_ONLINE_VISITS_LINKTEXT);
        assertEqualsInsensitive(unAuthenticatedHomePage.getFooterNavigationFindCareEmergencyUrgentCareLink().getText(), FIND_CARE_EMERGENCY_AND_URGENT_CARE_LINKTEXT);
        assertEqualsInsensitive(unAuthenticatedHomePage.getFooterNavigationFindCareLocationsLink().getText(), FIND_CARE_LOCATIONS_LINKTEXT);
        assertEqualsInsensitive(unAuthenticatedHomePage.getFooterNavFindCareCareWhileTravelingLink().getText(), FIND_CARE_CARE_WHILE_TRAVELING_LINKTEXT);
        assertEqualsInsensitive(unAuthenticatedHomePage.getFooterNavigationFindCareHealthAndWellnessLink().getText(), FIND_CARE_HEALTH_AND_WELLNESS_LINKTEXT);

        // BOTTOM FOOTER
        assertEqualsInsensitive(unAuthenticatedHomePage.getFooterLegalAndCustomerServiceTOUAndPolicyLink().getText(), TOU_AND_PRIVACY_POLICY_LINKTEXT);
        assertEqualsInsensitive(unAuthenticatedHomePage.getFooterLegalAndCustomerServiceSiteMapLink().getText(), SITE_MAP_LINKTEXT);
        assertEqualsInsensitive(unAuthenticatedHomePage.getFooterLegalAndCustomerServiceContactUsLink().getText(), MEMBER_SERVICES_LINKTEXT);
        assertEqualsInsensitive(unAuthenticatedHomePage.getFooterLegalAndCustomerServiceHelpLink().getText(), HELP_LINKTEXT);
        assertEqualsInsensitive(unAuthenticatedHomePage.getFooterLegalAndCustomerServiceLanguageAccessLink().getText(), LANGUAGE_ACCESS_LINKTEXT);

        // SOCIAL APPS
        assertTrue(unAuthenticatedHomePage.getFooterSocialRibbonInstagramButton().isDisplayed());
        assertTrue(unAuthenticatedHomePage.getFooterSocialRibbonTwitterButton().isDisplayed());
        assertTrue(unAuthenticatedHomePage.getFooterSocialRibbonFacebookButton().isDisplayed());
        assertTrue(unAuthenticatedHomePage.getFooterSocialRibbonLinkedInButton().isDisplayed());
        assertTrue(unAuthenticatedHomePage.getFooterAppStoreGoogleButton().isDisplayed());
        assertTrue(unAuthenticatedHomePage.getFooterAppStoreAppleButton().isDisplayed());
    }

    @Test(description = "Verify All Authenticated Links goto their Correct Pages", groups = {"qa", "prod"})
    public void verifyAuthenticatedFooterLinks() {
        unAuthenticatedHomePage.signIn(EVERYTHING)

                // Partner Site Pages
                .openNewMembersGuidePageFromFooter()
                .openAuthHomePageFromFooter()
                .openUnauthenticatedBusinessPage()
                .openAuthenticatedHomePage()
                .openUnauthenticatedProducersPage()
                .openAuthenticatedHomePage()
                .openUnauthenticatedProvidersPage()
                .openAuthenticatedHomePage()

                // Quick Links Pages
                .openQuickLinksMakeAnAppointmentPage()
                .openAuthenticatedHomePageFromMyChart()
                .openQuickLinksRequestReimbursementPage()
                .openQuickLinksRequestMedicalRecordsPage()
                .openQuickLinksRefillPrescriptionPage()
                .openAuthenticatedHomePageFromMyChart()
                .openQuickLinksFinancialAssistancePage()
                .openAuthenticatedHomePage()
                .openQuickLinksFormsPage()
                .openQuickLinksTourOnlineServicesPage()

                // Our Organization
                .openOurOrganizationAboutUsPage()
                .openOurOrganizationCommunityHealthPage()
                .openOurOrganizationAwardsAndRecognitionPage()
                .openOurOrganizationNewsAndViewsPage()
                .openAuthenticatedHomePage()
                .openOurOrganizationMediaInquiriesPage()
                .openOurOrganizationKPWAHealthResearchInstitutePage()
                .openAuthenticatedHomePage()
                .openCareersPage()
                .openAuthenticatedHomePage()

                // Find Care
                .openFindCareCareOptionsPage()
                .openClinicsAtBartellDrugsPage()
                .openConsultingNursePage()
                .openOnlineVisitsPage()
                .openEmergencyAndUrgentCarePage()
                .openLocationsPage()
                .openFindCareHealthAndWellnessPage()

                // Other Links
                .openTOUAndPrivacyPolicyPage()
                .openSiteMapPage()
                .openMemberServicesPage()
                .openHelpPage()
                .openLanguageAccessPage()
                .openAuthenticatedHomePage()
                .openWebsiteSupportPage()
                .openKPTwitterPage()
                .openAuthenticatedHomePage()
                .openKPFacebookPage()
                .openAuthenticatedHomePage()
                .openKPLinkedInPage()
                .openAuthenticatedHomePage()
                .openKPInstagramPage()
                .openAuthenticatedHomePage()
                .openUnauthenticatedGooglePlayPage();
    }
}