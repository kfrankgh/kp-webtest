package org.ghc.tests.pages;

import org.ghc.pages.KPAUIFindADoctorDetailsPage;
import org.ghc.utils.extensions.KPAUIEveryTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

import static org.ghc.utils.KPAUICredentials.accountName.EVERYTHING;
import static org.ghc.utils.helpers.KPAUITestHelper.*;
import static org.testng.Assert.assertTrue;

public class KPAUIFindADoctorDetailsPageTests extends KPAUIEveryTest {
    private KPAUIFindADoctorDetailsPage kpauiFindADoctorDetailsPage;

    @BeforeMethod(alwaysRun = true)
    public void beforeTest(Method method) {
        kpauiFindADoctorDetailsPage = super.initializeTest(method)
                .openDoctorsAndLocationsPage()
                .openFaDResultsPage_QuickSearch_PrimaryCare()
                .openFindADoctorDetailsPageFromDoctorName();
    }

    //------------------------------------------------------------------------------------------------------------------

    @Test(description = "Verify Back to Results Bread Crumb is displayed and functional", groups = {"qa", "prod"})
    public void verifyBackToResultsBreadCrumb() {
        assertTrue(kpauiFindADoctorDetailsPage.getBreadCrumbBackToResults().isDisplayed());
        assertTrue(kpauiFindADoctorDetailsPage.getBreadCrumbBackToResults().getText().contains("Back"));
        kpauiFindADoctorDetailsPage.openFindADoctorSearchResultsPageFromBreadCrumb();
    }

    @Test(description = "Verify the Portrait and GMap are displayed, and the Share and Print Doctor Result Links are displayed and functional", groups = {"smoke", "qa", "prod"})
    public void verifyFaDDetailsPageUIElements() {
        assertTrue(kpauiFindADoctorDetailsPage.getGMap().isDisplayed());

        assertTrue(kpauiFindADoctorDetailsPage.getDoctorPortraitDiv().isDisplayed());
        assertContains(kpauiFindADoctorDetailsPage.getDoctorPortraitDiv()
                .getAttribute("style"), "/fad/images/practitioner/");

        assertTrue(kpauiFindADoctorDetailsPage.getShareDoctorResult().isDisplayed());
        assertMatches(kpauiFindADoctorDetailsPage.getShareDoctorResult().getText(),"(?i)share");

        assertTrue(kpauiFindADoctorDetailsPage.getPrintButton().isDisplayed());
        assertMatches(kpauiFindADoctorDetailsPage.getPrintButton().getText(), "(?i)print");

        kpauiFindADoctorDetailsPage.openShareDoctorResultShade();
    }

    @Test(description = "Verify the Choose me button is displayed and functional", groups = {"qa", "prod"})
    public void verifyChooseMeButton() {
        assertTrue(kpauiFindADoctorDetailsPage.getChoosePhysicianButton().isDisplayed());
        assertTrue(kpauiFindADoctorDetailsPage.getChoosePhysicianButton().getText().contains("Choose"));
        kpauiFindADoctorDetailsPage
                .openSignOnShadeFromUnAuthChooseMeBtn()
                .signOnFromFindADoctorSignOnShade(EVERYTHING)
                .openChoosePhysicianShade();
    }
}
