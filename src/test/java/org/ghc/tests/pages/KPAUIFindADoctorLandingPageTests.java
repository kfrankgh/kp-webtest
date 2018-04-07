package org.ghc.tests.pages;

import org.ghc.pages.KPAUIFindADoctorLandingPage;
import org.ghc.utils.extensions.KPAUIEveryTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

import static org.ghc.utils.helpers.KPAUIRestHelper.getRestSearchResults;
import static org.ghc.utils.helpers.KPAUITestHelper.assertEqualsInsensitive;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class KPAUIFindADoctorLandingPageTests extends KPAUIEveryTest {
    private KPAUIFindADoctorLandingPage kpauiFindADoctorLandingPage;

    @BeforeMethod(alwaysRun = true)
    public void beforeTest(Method method) {
        kpauiFindADoctorLandingPage = super.initializeTest(method)
        .openFindADoctorLandingPage();
    }

    //------------------------------------------------------------------------------------------------------------------

    @Test(description = "Clicking Search on page load does nothing - keeps users on the same page", groups = {"qa", "prod"})
    public void verify_Search_NoParams() {
        String startingPageUrl = kpauiFindADoctorLandingPage.driver.getCurrentUrl();
        kpauiFindADoctorLandingPage.clearZipCodeField()
                .doctorSearch("");
        assertEquals(driver.getCurrentUrl(), startingPageUrl);
    }

    @Test(description = "Expected nav elements are displayed", groups = {"smoke", "qa", "prod"})
    public void verify_CallConsultingNurseButtonDisplays() {
        assertTrue(kpauiFindADoctorLandingPage.getCallNurseButton().isDisplayed());
        assertTrue(kpauiFindADoctorLandingPage.getLearnMoreButton().isDisplayed());
        assertTrue(kpauiFindADoctorLandingPage.getChildTeenCareQuickSearchLink().isDisplayed());
        assertTrue(kpauiFindADoctorLandingPage.getPregnancyCareQuickSearchLink().isDisplayed());
        assertTrue(kpauiFindADoctorLandingPage.getPrimaryCareQuickSearchLink().isDisplayed());
        assertTrue(kpauiFindADoctorLandingPage.getSearchAllProvidersLink().isDisplayed());
        assertTrue(kpauiFindADoctorLandingPage.getStartOnlineVisitButton().isDisplayed());
    }

    @Test(description = "Forms Display and Placeholder text displays in the forms",
            groups = {"smoke", "qa", "prod"})
    public void verify_FormsDisplay_HavePlaceHolderText() {
        assertTrue(kpauiFindADoctorLandingPage.getFadSearchField().isDisplayed());
        assertEqualsInsensitive(kpauiFindADoctorLandingPage.getFadSearchField().getAttribute("placeholder"), "Search by name, specialty, and more");

        assertTrue(kpauiFindADoctorLandingPage.getZipCodeField().isDisplayed());
        assertEqualsInsensitive(kpauiFindADoctorLandingPage.getZipCodeField().getAttribute("placeholder"),"ZIP code");
    }

    @Test(description = "Links and buttons redirect as expected", groups = {"qa", "prod"})
    public void validate_LinksAndButtons() {
        kpauiFindADoctorLandingPage
                .openConsultingNursePageFromCallNurseButton()
                .openFindADoctorLandingPage()
                .openChooseOrChangeYourDoctorPageFromLearnMoreButton()
                .openFindADoctorLandingPage()
                .openFaDResultsPage_QuickSearch_ChildAndTeenCare()
                .openFindADoctorLandingPage()
                .openFaDResultsPage_QuickSearch_PregnancyCare()
                .openFindADoctorLandingPage()
                .openFaDResultsPage_QuickSearch_PrimaryCare()
                .openFindADoctorLandingPage()
                .openOnlineVisitPageFromStartOnlineVisitButton()
                .openFindADoctorLandingPage()
                .openVitalsChoicePage();
    }

    @Test(description = "Search by Specialty returns results - redirects users to search results page", groups = {"qa" , "prod"})
    public void verify_SearchOnSpecialty() {
        kpauiFindADoctorLandingPage.clearZipCodeField().doctorSearch("Physical Therapy");
        assertTrue(driver.getCurrentUrl().contains("/results?q=Physical%20Therapy"));
    }

    @Test(description = "Search by only zip code returns results - redirects users to search results page", groups = {"qa" })
    public void verify_SearchOnZipCodeSubmit() {
        kpauiFindADoctorLandingPage.clearZipCodeField()
                .doctorSearch("98075");
        assertTrue(driver.getCurrentUrl().contains("/find-a-doctor/results?q=98075"));
    }

    @Test(description = "Search by Specialty returns results and count of practitioners matches the count from the service - redirects users to search results page",
            groups = {"smoke", "qa", "prod"})
    public void verifyUiSearchCountMatchesServiceCount() {
        int countOnPage = kpauiFindADoctorLandingPage
                .clearZipCodeField()
                .doctorSearch("Family Medicine")
                .getCountFromUI();

        String[] faDSearchMap = driver
                .getCurrentUrl()
                .split("\\?");

        int results = getRestSearchResults(faDSearchMap[1]);
        assertEquals(countOnPage, results);
    }

}
