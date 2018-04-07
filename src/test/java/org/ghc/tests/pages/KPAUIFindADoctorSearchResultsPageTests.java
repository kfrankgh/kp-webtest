package org.ghc.tests.pages;

import org.ghc.pages.KPAUIFindADoctorSearchResultsPage;
import org.ghc.utils.extensions.KPAUIEveryTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.List;

import static org.ghc.utils.KPAUICredentials.accountName.*;
import static org.ghc.utils.helpers.KPAUIRestHelper.getList;
import static org.ghc.utils.helpers.KPAUIRestHelper.getRestSearchResults;
import static org.ghc.utils.helpers.KPAUITestHelper.assertContains;
import static org.ghc.utils.helpers.KPAUITestHelper.assertMatches;
import static org.testng.Assert.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class KPAUIFindADoctorSearchResultsPageTests extends KPAUIEveryTest {
    private KPAUIFindADoctorSearchResultsPage kpauiFindADoctorSearchResultsPage;

    @BeforeMethod(alwaysRun = true)
    public void beforeTest(Method method) {
        kpauiFindADoctorSearchResultsPage = super.initializeTest(method)
                .openDoctorsAndLocationsPage()
                .openFaDResultsPage_QuickSearch_PrimaryCare();
    }


    //------------------------------------------------------------------------------------------------------------------

    @Test(description = "Verify Dropdown Options", groups = {"qa"})
    public void verifyDropDowns() {
        int languageListFromService = getList("language");
        int languageListFromUI = kpauiFindADoctorSearchResultsPage.getLanguagesDropdownList().size();

        int specialtyListFromService = getList("specialty");
        int specialtyListFromUI = kpauiFindADoctorSearchResultsPage.getSpecialtiesDropdownList().size();

        int distanceListFromUI = kpauiFindADoctorSearchResultsPage.getDistanceDropdownList().size();

        List<WebElement> genderDropdownList = kpauiFindADoctorSearchResultsPage.getGenderDropdownList();
        String genderListFirstIndex =   genderDropdownList.get(0).getText();
        String genderListSecondIndex =  genderDropdownList.get(1).getText();

        assertEquals(genderDropdownList.size(),2);
        assertMatches(genderListFirstIndex, "(?i)MALE");
        assertMatches(genderListSecondIndex, "(?i)FEMALE");

        assertEquals(languageListFromUI, languageListFromService + 2);
        assertEquals(specialtyListFromService, specialtyListFromUI);
        assertEquals(distanceListFromUI, 5);
    }

    @Test(description = "Links display and redirect to expected pages", groups = {"qa", "prod"})
    public void verifyLinksAndButtons() {
        kpauiFindADoctorSearchResultsPage.openFindADoctorOnlineVisitsPage();
        driver.navigate().back();
        kpauiFindADoctorSearchResultsPage.openFindADoctorConsultingNursePage();
        driver.navigate().back();
        kpauiFindADoctorSearchResultsPage.openFindADoctorCareClinicPage();
        driver.navigate().back();
        kpauiFindADoctorSearchResultsPage.openShareResultsShade();
    }

    @Test(description = "Placeholder text displays in the search box - Search by name, location, specialty, and more", groups = {"smoke", "qa", "prod"})
    public void verify_SearchBoxDisplays_HasPlaceHolderText() {
        assertTrue(kpauiFindADoctorSearchResultsPage.getFadSearchField().isDisplayed());
        assertContains(kpauiFindADoctorSearchResultsPage.getFadSearchField().getAttribute("placeholder"), ("Search by"));

        assertTrue(kpauiFindADoctorSearchResultsPage.getZipCodeField().isDisplayed());
        assertMatches(kpauiFindADoctorSearchResultsPage.getZipCodeField().getAttribute("placeholder"),"(?i)zip code");
    }

    @Test(description = "When searching for PCP - who are accepting new patients - verify that the count of practitioners returned on the page matches the count returned by the service",
            groups = {"qa"})
    public void verify_ResultsCount_PCP_AcceptingNew() {
        String[] faDSearchMap = driver
                .getCurrentUrl()
                .split("\\?");
        int countFromService = getRestSearchResults(faDSearchMap[1]);
        int countFromUI = kpauiFindADoctorSearchResultsPage.clickAcceptingNew().getCountFromUI();
        assertEquals(countFromUI, countFromService);
    }

    @Test(description = "When searching for PCP who are accepting new patients - verify that the Schedule Now button displays for all PCP results", groups = {"smoke", "qa"})
    public void verify_ScheduleNowButton_PCP() {
        kpauiFindADoctorSearchResultsPage.clickAcceptingNew();
        assertEquals(kpauiFindADoctorSearchResultsPage.getCount_ScheduleNowButtonsDisplayed(), 10);
    }

    @Test(description = "Clearing all Search Tags will redirect the user to the Find a Doctor Landing page", groups = {"smoke", "qa", "prod"})
    public void verify_ClearAllTagsButton() {
        kpauiFindADoctorSearchResultsPage.openFindADoctorLandingPageByClearingChips();
    }

    @Test(description = "verify_YourPcPDiv is displayed for member with a pcp", groups = {"smoke", "qa", "prod"})
    public void verify_YourPcPDiv() {
        assertTrue(kpauiFindADoctorSearchResultsPage.signOnToFindADocAndNavToSearchResults(EVERYTHING).getYourPcPDiv().isDisplayed());
    }

    @Test(description = "verify_YourPcPDiv is not displayed for member without a pcp", groups = {"smoke", "qa", "prod"})
    public void verify_NoPcPDiv() {
        kpauiFindADoctorSearchResultsPage.signOnToFindADocAndNavToSearchResults(NOTHING);
        assertTrue(kpauiFindADoctorSearchResultsPage.driver.findElements(By.xpath("//search-results/div/div[2]/div/div[2]")).size() < 1);
    }
}