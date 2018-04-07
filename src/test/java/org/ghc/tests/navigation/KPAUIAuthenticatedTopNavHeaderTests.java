package org.ghc.tests.navigation;

import org.ghc.pages.KPAUIAuthenticatedHomePage;
import org.ghc.utils.extensions.KPAUIEveryTest;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;
import java.lang.reflect.Method;

import static org.ghc.utils.extensions.KPAUIEveryAuthenticatedPage.*;
import static org.testng.Assert.*;
import static org.ghc.utils.KPAUICredentials.accountName.*;


public class KPAUIAuthenticatedTopNavHeaderTests extends KPAUIEveryTest {
    KPAUIAuthenticatedHomePage homePage;

    @BeforeMethod(alwaysRun = true)
    public void beforeTest(Method method) {
        homePage = super.initializeTest(method)
                .signIn(EVERYTHING);
    }

    //------------------------------------------------------------------------------------------------------------------

    @Test(description = "Verifying Top Nav Header", groups = {"smoke", "qa", "prod"})
    public void validateTopNavHeader() {
        WebElement careShadeIcon = homePage.getGetCareShadeIcon();
        WebElement appointmentsShadeIcon = homePage.getAppointmentsShadeIcon();
        WebElement messagesShadeIcon = homePage.getMessagesShadeIcon();
        WebElement medicationsShadeIcon = homePage.getMedicationsShadeIcon();
        WebElement medicalRecordShadeIcon = homePage.getMedicalRecordShadeIcon();
        WebElement coverageCostsShadeIcon = homePage.getCoverageCostsShadeIcon();

        assertEquals(careShadeIcon.getText(), LINKTEXT_GET_CARE);
        assertEquals(appointmentsShadeIcon.getText(), LINKTEXT_APPOINTMENTS);
        assertEquals(messagesShadeIcon.getText(), LINKTEXT_MESSAGES);
        assertEquals(medicationsShadeIcon.getText(), LINKTEXT_MEDICATIONS);
        assertEquals(medicalRecordShadeIcon.getText(), LINKTEXT_MEDICAL_RECORD);
        assertEquals(coverageCostsShadeIcon.getText(), LINKTEXT_COVERAGE_AND_COSTS);
    }
}
