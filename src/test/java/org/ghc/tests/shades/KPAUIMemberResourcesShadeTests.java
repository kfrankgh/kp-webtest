package org.ghc.tests.shades;

import org.ghc.pages.KPAUIUnAuthenticatedHomePage;
import org.ghc.shades.KPAUIMemberResourcesShade;
import org.ghc.utils.extensions.KPAUIEveryTest;
import org.testng.annotations.*;


import java.lang.reflect.Method;

import static org.ghc.shades.KPAUIMemberResourcesShade.*;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class KPAUIMemberResourcesShadeTests extends KPAUIEveryTest {
    private KPAUIUnAuthenticatedHomePage homePage;

    @BeforeMethod(alwaysRun = true)
    public void beforeTest(Method method) {
        homePage = super.initializeTest(method);
    }

    //------------------------------------------------------------------------------------------------------------------

    @Test(description = "Member Resources Shade Links and Destination URLs", groups = {"smoke", "qa", "prod"})
    public void validateMemberResourcesShadeLinksAndTexts(){
        KPAUIMemberResourcesShade kpauiMemberResourcesShade = homePage.openMemberResourcesShade();

        // Member Resources Shade Header Tests
        assertEquals(kpauiMemberResourcesShade.getMemberServicesHeader().getText(), MEMBER_SERVICES_SUBHEADER);
        assertEquals(kpauiMemberResourcesShade.getNewMembersHeader().getText(), NEW_MEMBER_SUBHEADER);

        // Member Resources Shade Links And Texts
        assertEquals(kpauiMemberResourcesShade.getContactMemberServicesLink().getText(), CONTACT_MEMBER_SERVICES);
        assertEquals(kpauiMemberResourcesShade.getCommonFormsLink().getText(), COMMON_FORMS);
        assertEquals(kpauiMemberResourcesShade.getBillsPaymentsLink().getText(), BILLS_AND_PAYMENTS);
        assertEquals(kpauiMemberResourcesShade.getChooseChangeDoctorLink().getText(), CHOOSE_CHANGE_DOCTOR);
        assertEquals(kpauiMemberResourcesShade.getReleaseHealthCareInformationLink().getText(), RESTRICTIONS_RELEASE_INFO);
        assertEquals(kpauiMemberResourcesShade.getAccessChildsMedicalRecordsLink().getText(), ACCESS_CHILDS_RECORDS);
        assertEquals(kpauiMemberResourcesShade.getFinancialAssistanceLink().getText(), FINANCIAL_ASSISTANCE);
        assertEquals(kpauiMemberResourcesShade.getGetStartedLink().getText(), GET_STARTED);

        // Help Section
        assertTrue(kpauiMemberResourcesShade.getShadeHelpSection().isDisplayed());
        assertTrue(kpauiMemberResourcesShade.validateHelpSectionHeader());
        assertTrue(kpauiMemberResourcesShade.validateEmailLink());
        assertTrue(kpauiMemberResourcesShade.validateHelpSectionPhoneNumber());
    }

    @Test(description = "Validate Member Resources Shade Page Destinations", groups = {"qa", "prod"})
    public void validateAllPagesInMembersResourcesShade(){
        homePage.openMemberResourcesShade().openNewMembersGuidePage()
                .openMemberResourcesShade()
                .openFormsPage()
                .openMemberResourcesShade()
                .openBillsAndPaymentPage()
                .openMemberResourcesShade()
                .openChooseOrChangeYourDoctorPage()
                .openMemberResourcesShade()
                .openRestrictionsOnReleaseOfHealthCareInfoPage()
                .openMemberResourcesShade()
                .openAccessChildsMedicalRecordsPage()
                .openMemberResourcesShade()
                .openEmailMemberServicesPage()
                .openMemberResourcesShade()
                .openFinancialAssistancePage();
    }
}
