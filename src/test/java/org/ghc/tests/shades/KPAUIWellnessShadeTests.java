package org.ghc.tests.shades;

import org.ghc.pages.KPAUIUnAuthenticatedHomePage;
import org.ghc.shades.KPAUIWellnessShade;
import org.ghc.utils.extensions.KPAUIEveryTest;
import org.testng.annotations.*;


import java.lang.reflect.Method;

import static org.ghc.shades.KPAUIWellnessShade.*;
import static org.testng.Assert.*;

public class KPAUIWellnessShadeTests extends KPAUIEveryTest {
    private KPAUIUnAuthenticatedHomePage homePage;

    @BeforeMethod(alwaysRun = true)
    public void beforeTest(Method method) {
        homePage = super.initializeTest(method);
    }

    //------------------------------------------------------------------------------------------------------------------

    @Test(description = "Wellness Shade Links and Destination URLs", groups = {"smoke", "qa", "prod"})
    public void validateHealthAndWellnessResourcesLink(){
        KPAUIWellnessShade wellnessShade = homePage.openWellnessShade();

        // Wellness Shade Header Tests
        assertEquals(wellnessShade.getResourcesSubHeader().getText(), RESOURCES_SUBHEADER);

        // Wellness Shade Links And Texts
        assertEquals(wellnessShade.getHealthWellnessLink().getText(), HEALTH_WELLNESS);
        assertEquals(wellnessShade.getClassesEventsGroupsLink().getText(), CLASSES_EVENTS_GROUPS);
        assertEquals(wellnessShade.getCommunityHealthLink().getText(), COMMUNITY_HEALTH);
        assertEquals(wellnessShade.getHealthBlogLink().getText(), HEALTH_BLOG);

        // Help Section
        assertTrue(wellnessShade.getShadeHelpSection().isDisplayed());
        assertTrue(wellnessShade.validateHelpSectionHeader());
        assertTrue(wellnessShade.validateEmailLink());
        assertTrue(wellnessShade.validateHelpSectionPhoneNumber());
    }

    @Test(description = "Validate Wellness Shade Page Destinations", groups = {"qa", "prod"})
    public void validateAllPagesInWellnessShade(){
        homePage.openWellnessShade().openEmailMemberServicesPage()
                .openWellnessShade()
                .openCommunityHealthPage()
                .openWellnessShade()
                .openHealthAndWellnessPage()
                .openWellnessShade()
                .openClassesAndEventsPage()
                .openWellnessShade()
                .openHealthBlogPage();
    }
}
