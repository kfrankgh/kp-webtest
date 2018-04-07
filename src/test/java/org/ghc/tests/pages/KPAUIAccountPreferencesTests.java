package org.ghc.tests.pages;

import org.ghc.pages.KPAUIAccountAndPreferencesPage;
import org.ghc.utils.extensions.KPAUIEveryTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

import static org.ghc.utils.KPAUICredentials.accountName.EVERYTHING;
import static org.ghc.utils.helpers.KPAUITestHelper.*;
import static org.testng.Assert.*;
import static org.testng.Assert.assertEquals;

public class KPAUIAccountPreferencesTests extends KPAUIEveryTest {
    private KPAUIAccountAndPreferencesPage accountAndPreferencesPage;

    @BeforeMethod(alwaysRun = true)
    public void beforeTest(Method method) {
        accountAndPreferencesPage = super.initializeTest(method)
                .signIn(EVERYTHING)
                .openMedicalRecordsShade()
                .openAccountAndPreferencesPage();
    }

    //------------------------------------------------------------------------------------------------------------------

    @Test(description = "Verify Kaiser Permanente Member Services link opens the KP Member Services Page", groups = {"qa", "prod"})
    public void validateKPMemberServicesLinkClick() {
        accountAndPreferencesPage.openMemberServicesLink();
    }

    @Test(description = "Verify Washington Healthplanfinder link opens the WA Healthplanfinder Page", groups = {"qa", "prod"})
    public void validateWAHealthPlanFinderLinkClick() {
        accountAndPreferencesPage.openWaHealthPlanFinderLink();
    }

    @Test(description = "Verify 'follow these steps' link opens the Changing your status page", groups = {"qa", "prod"})
    public void validateFollowTheseStepsLinkClick() {
        accountAndPreferencesPage.openFollowTheseStepsLink();
    }


    @Test(description = "Verify Privacy Policy link opens the Privacy Policy page", groups = {"qa", "prod"})
    public void validatePrivacyPolicyLinkClick() {
        accountAndPreferencesPage.openPrivacyPolicyLink();
    }

    @Test(description = "Verify Member ID is correct", groups = {"qa", "prod"})
    public void validateMemberId() {
        String actualId = accountAndPreferencesPage.getMemberIdString();
        String expectedId = EVERYTHING.getID();
        assertEquals(expectedId, actualId);
    }

    @Test(description = "Verify Member Info fields are populated", groups = {"smoke", "qa", "prod"})
    public void verifyMemberInfoFieldsArePopulated() {

        assertNotNull(accountAndPreferencesPage.getNameField().getText(), "Name Field is empty.");
        assertNotNull(accountAndPreferencesPage.getMailingAddressField().getText(),
                "Mailing Address field is empty.");
        assertNotNull(accountAndPreferencesPage.getResidentialAddressField().getText(),
                "Residential Address field is empty.");
        assertNotNull(accountAndPreferencesPage.getPrimaryPhoneField().getText(),
                "Primary Phone field is empty.");
        String lastUpdatedOnText = "^Last updated on \\d{2}/\\d{2}/\\d{4}$";
        assertTrue(accountAndPreferencesPage.getLastUpdatedOnField().getText().matches(lastUpdatedOnText),
                errorMsg(lastUpdatedOnText, accountAndPreferencesPage.getLastUpdatedOnField().getText()));
        assertTrue(accountAndPreferencesPage.getLastUpdatedOnField().getText().matches(lastUpdatedOnText),
                errorMsg("lastupdated", accountAndPreferencesPage.getLastUpdatedOnField().getText()));
    }
}