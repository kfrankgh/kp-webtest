package org.ghc.tests.pages;

import org.ghc.pages.KPAUIUnAuthenticatedHomePage;
import org.ghc.utils.extensions.KPAUIEveryTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

import static org.ghc.pages.KPAUIUnAuthenticatedHomePage.*;
import static org.ghc.utils.KPAUIPageConstants.DOCTORS_AND_LOCATIONS_TILE_EXPECTED_LINK;
import static org.ghc.utils.KPAUIPageConstants.SHOP_HEALTH_PLANS_TILE_EXPECTED_LINK;
import static org.ghc.utils.KPAUIPageConstants.baseBoth;
import static org.ghc.utils.helpers.KPAUITestHelper.errorMsg;
import static org.ghc.utils.helpers.KPAUITestHelper.isValidLink;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class KPAUIUnauthenticatedHomePageTests extends KPAUIEveryTest {
    private KPAUIUnAuthenticatedHomePage unAuthHomePage;
    public static final String heroImageFile = baseBoth + "/.+\\.jpg";

    @BeforeMethod(alwaysRun = true)
    public void beforeTest(Method method) {
        unAuthHomePage = super.initializeTest(method);
    }

    //------------------------------------------------------------------------------------------------------------------

    @Test(description = "Verify public home page header displays the Hero image", groups = {"smoke", "qa", "prod"})
    public void validateHeroImage(){
        assertTrue(unAuthHomePage.getHeroImage().isDisplayed());
    }

    @Test(description = "Verify public the Hero image is the correct file", groups = {"qa", "prod"})
    public void validateHeroImageFilePath(){
        String actualPath = unAuthHomePage.getHeroImageFilePath();
        assertTrue(unAuthHomePage.getHeroImageFilePath().matches(heroImageFile), errorMsg(heroImageFile, actualPath));
    }

    @Test(description = "Verify the Shop Our Plans Tile Title, Icon, and link opens the Health Plans page", groups = {"qa", "prod"})
    public void validateShopOurPlans(){
        assertTrue(unAuthHomePage.getShopOurPlansIcon().isDisplayed());
        assertTrue(unAuthHomePage.validateShopOurPlansIconSource());
        assertEquals(unAuthHomePage.getShopOurPlansTitle().getText(), shopOurPlansTileExpectedTitle);
        assertEquals(unAuthHomePage.getShopOurPlansDescription().getText(), shopOurPlansTileExpectedDescription);
        assertTrue(isValidLink(unAuthHomePage.getShopHealthPlansLink(), SHOP_HEALTH_PLANS_TILE_EXPECTED_LINK));
        unAuthHomePage.openHealthPlansPage();
    }

    @Test(description = "Verify the Doctors and Locations Tile Title, Icon, and link opens the Doctors and Locations page", groups = {"qa", "prod"})
    public void validateDoctorsAndLocations(){
        assertTrue(unAuthHomePage.getDoctorsAndLocationsIcon().isDisplayed());
        assertTrue(unAuthHomePage.validateDoctorsLocationsIconSource());
        assertEquals(unAuthHomePage.getDoctorsAndLocationsTitle().getText(), doctorsAndLocationsTileExpectedTitle);
        assertEquals(unAuthHomePage.getDoctorsAndLocationsDesc().getText(), doctorsAndLocationsTileExpectedDescription);
        assertTrue(isValidLink(unAuthHomePage.getFindDocsAndLocationsLink(), DOCTORS_AND_LOCATIONS_TILE_EXPECTED_LINK));
        unAuthHomePage.openDoctorsAndLocationsPage();
    }

    @Test(description = "Verify the New Member Tile Title, Icon, and link opens the Health Plans page", groups = {"qa", "prod"})
    public void validateNewMembers(){
        assertTrue(unAuthHomePage.getNewMemberIcon().isDisplayed());
        assertTrue(unAuthHomePage.validateNewMembersIconSource());
        assertEquals(unAuthHomePage.getNewMemberTitle().getText(), newMemberTileExpectedTitle);
        assertEquals(unAuthHomePage.getNewMemberDescription().getText(), newMemberTileExpectedDescription);
        assertEquals(unAuthHomePage.getNewMemberLink().getText(), newMemberTileLinkText);
        unAuthHomePage.openNewMemberToolKitPageFromTile();
    }
}
