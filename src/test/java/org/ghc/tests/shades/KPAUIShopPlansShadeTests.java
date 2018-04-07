package org.ghc.tests.shades;

import org.ghc.pages.KPAUIUnAuthenticatedHomePage;
import org.ghc.shades.KPAUIShopPlansShade;
import org.ghc.utils.extensions.KPAUIEveryTest;
import org.testng.annotations.*;


import java.lang.reflect.Method;

import static org.ghc.shades.KPAUIShopPlansShade.*;
import static org.testng.Assert.*;

public class KPAUIShopPlansShadeTests extends KPAUIEveryTest {
    private KPAUIUnAuthenticatedHomePage homePage;

    @BeforeMethod(alwaysRun = true)
    public void beforeTest(Method method) {
        homePage = super.initializeTest(method);
    }

    //------------------------------------------------------------------------------------------------------------------}

    @Test(description = "Shop Plans Shade Links and Destination URLs", groups = {"qa", "prod"})
    public void validateShopPlansShadeLinksAndTexts(){
        KPAUIShopPlansShade kpauiShopPlansShade = homePage.openShopPlansShade();

        // Shop Plans Shade Header Tests
        assertEquals(kpauiShopPlansShade.getFindPlansSubHeader().getText(), FIND_PLANS_SUBHEADER);

        // Shop Plans Shade Links And Texts
        assertEquals(kpauiShopPlansShade.getOurPlansLink().getText(), OUR_PLANS);
        assertEquals(kpauiShopPlansShade.getMedicareAdvantageLink().getText(), MEDICARE_ADVANTAGE);
        assertEquals(kpauiShopPlansShade.getIndividualAndFamilyLink().getText(), INDIVIDUAL_FAMILY);
        assertEquals(kpauiShopPlansShade.getPublicEmployeesLink().getText(), PUBLIC_EMPLOYEES);
        assertEquals(kpauiShopPlansShade.getFederalEmployeesLink().getText(), FEDERAL_EMPLOYEES);
        assertEquals(kpauiShopPlansShade.getSmallAndLargeBusinessesLink().getText(), SMALL_LARGE_BUSSINESSES);

        // Help Section
        assertTrue(kpauiShopPlansShade.getShadeHelpSection().isDisplayed());
        assertTrue(kpauiShopPlansShade.validateHelpSectionHeader());
        assertTrue(kpauiShopPlansShade.validateEmailLink());
        assertTrue(kpauiShopPlansShade.validateHelpSectionPhoneNumber());
    }

    @Test(description = "Validate Shop Plans Shade Page Destinations", groups = {"qa", "prod"})
    public void validateAllPagesInShopPlansShade() {
        homePage.openShopPlansShade().openEmailMemberServicesPage()
                .openUnAuthenticatedHomePage()
                .openShopPlansShade()
                .openStateEmployeesPage()
                .openUnAuthenticatedHomePage()
                .openShopPlansShade()
                .openFederalEmployessPlansPage()
                .openUnAuthenticatedHomePage()
                .openShopPlansShade()
                .openHealthPlansPageFromOurPlansLink()
                .openUnAuthenticatedHomePage()
                .openShopPlansShade()
                .openHealthInsuranceForEmployersPage()
                .openUnAuthenticatedHomePage()
                .openShopPlansShade()
                .openMedicareAdvantagePage()
                .openUnAuthenticatedHomePage()
                .openShopPlansShade()
                .openHealthPlansIndividualAndFamilyPage();
    }
}
