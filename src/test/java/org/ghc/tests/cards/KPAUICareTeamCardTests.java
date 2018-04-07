package org.ghc.tests.cards;

import org.ghc.cards.KPAUICareTeamCard;
import org.ghc.pages.KPAUIUnAuthenticatedHomePage;
import org.ghc.utils.extensions.KPAUIEveryTest;
import org.testng.annotations.*;
import java.lang.reflect.Method;

import static org.ghc.utils.KPAUIPageConstants.*;
import static org.ghc.utils.KPAUICredentials.accountName.*;
import static org.ghc.utils.helpers.KPAUITestHelper.isValidLink;
import static org.testng.Assert.*;

public class KPAUICareTeamCardTests extends KPAUIEveryTest {
    private KPAUIUnAuthenticatedHomePage unAuthenticatedHomePage;

    @BeforeMethod(alwaysRun = true)
    public void beforeTest(Method method) {
        unAuthenticatedHomePage = super.initializeTest(method);
    }

    //------------------------------------------------------------------------------------------------------------------

    @Test(description = "Verify Team Care Card Links and Objects with a provider'", groups = {"smoke", "qa", "prod"})
    public void validateTeamCardObjectsAndLinksWithProvider() {
        KPAUICareTeamCard yourCareTeamCard = unAuthenticatedHomePage
                .signIn(EVERYTHING)
                .getYourCareTeamCard();

        assertTrue(yourCareTeamCard.verifyCareTeamHeader());
        assertTrue(yourCareTeamCard.verifySwitchProvidersLinkAndIcon());
        assertTrue(yourCareTeamCard.verifyContactCareTeamLinkAndIcon());

        assertTrue(yourCareTeamCard.getClinicianNameTitle().isDisplayed());
        assertTrue(yourCareTeamCard.getClinicianLocation().isDisplayed());
        assertTrue(yourCareTeamCard.getClinicianPhoneNumber().isDisplayed());
        assertTrue(yourCareTeamCard.getMapPin().isDisplayed());

        yourCareTeamCard.openSwitchProvidersPage()
                .openHomePageFromHeader()
                .openAuthenticatedHomePage()
                .getYourCareTeamCard()
                .openContactCareTeam();
    }

    @Test(description = "Verify Team Care Card Links and Objects without a provider", groups = {"smoke", "qa", "prod"})
    public void validateTeamCardObjectsAndLinksWithoutProvider() {
        KPAUICareTeamCard yourCareTeamCard = unAuthenticatedHomePage
                .signIn(NOTHING)
                .getYourCareTeamCard();
        assertTrue(yourCareTeamCard.verifyNoCareTeamMessage());
        assertTrue(yourCareTeamCard.verifyFindADoctorLinkAndIcon());
        yourCareTeamCard.openFindADoctorPage();
    }
}