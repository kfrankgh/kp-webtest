package org.ghc.tests.navigation;

import org.ghc.pages.KPAUIUnAuthenticatedHomePage;
import org.ghc.utils.extensions.KPAUIEveryTest;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class KPAUIRightNavTests extends KPAUIEveryTest {
    private KPAUIUnAuthenticatedHomePage kpauiUnAuthenticatedHomePage;

    @BeforeMethod(alwaysRun = true)
    public void beforeTest(Method method) {
        kpauiUnAuthenticatedHomePage = super.initializeTest(method);
    }

    //------------------------------------------------------------------------------------------------------------------

    @Test(description = "Verify clicking all the public links open the expected page", groups = {"smoke", "qa", "prod"})
    public void validatePublicFacingLinksClick(){
        assertTrue(kpauiUnAuthenticatedHomePage.getNcqaText().isDisplayed());
        assertTrue(kpauiUnAuthenticatedHomePage.getNcqaImage().isDisplayed());

        kpauiUnAuthenticatedHomePage.clickAppointmentsLink()
                .openUnAuthenticatedHomePage()
                .clickConsultingNurseLink()
                .openUnAuthenticatedHomePage()
                .clickRequestReimbursementLink()
                .openUnAuthenticatedHomePage()
                .clickRequestMedicalRecordsLink()
                .openUnAuthenticatedHomePage()
                .clickRefillPrescriptionLink()
                .openUnAuthenticatedHomePage()
                .clickGetAFluShotLink()
                .openUnAuthenticatedHomePage()
                .clickCommunityEventsLink()
                .openUnAuthenticatedHomePage()
                .clickVisionAndEyeCareLink()
                .openUnAuthenticatedHomePage()
                .clickPregnancyServicesLink()
                .openUnAuthenticatedHomePage()
                .clickHealthAndWellnessLink();
    }
}
