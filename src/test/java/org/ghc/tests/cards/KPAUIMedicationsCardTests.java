package org.ghc.tests.cards;

import org.ghc.cards.KPAUIMedicationsCard;
import org.ghc.pages.KPAUIUnAuthenticatedHomePage;
import org.ghc.utils.extensions.KPAUIEveryTest;
import org.testng.annotations.*;
import java.lang.reflect.Method;

import static org.ghc.utils.KPAUICredentials.accountName.*;
import static org.testng.Assert.assertTrue;

public class KPAUIMedicationsCardTests extends KPAUIEveryTest {
    private KPAUIUnAuthenticatedHomePage unAuthenticatedHomePage;

    @BeforeMethod(alwaysRun = true)
    public void beforeTest(Method method) {
        unAuthenticatedHomePage = super.initializeTest(method);
    }

    //------------------------------------------------------------------------------------------------------------------

    @Test(description = "Validate the Medications card when a user has medications",  groups = {"smoke", "qa", "prod"})
    public void validateMedicationsObjectsAndLinks() {
        KPAUIMedicationsCard medicationsCard = unAuthenticatedHomePage
                .signIn(EVERYTHING)
                .getMedicationsCard();

        assertTrue(medicationsCard.verifyMedicationsCardHeaderText());
        assertTrue(medicationsCard.verifyOrderStatusTextAndIcon());
        assertTrue(medicationsCard.verifySeeAllMedicationsTextAndIcon());
        assertTrue(medicationsCard.getMedicationGenericName().isDisplayed());
        assertTrue(medicationsCard.getMedicationBrandName().isDisplayed());
        assertTrue(medicationsCard.getMedicationsDoseInstructions().isDisplayed());
        assertTrue(medicationsCard.getMedicationDatePrescribed().isDisplayed());

        medicationsCard.openMedicationsPageFromHeader()
                .openAuthenticatedHomePageFromMyChart()
                .getMedicationsCard()
                .openMedicationsPageFromOrderStatus()
                .openAuthenticatedHomePageFromMyChart()
                .getMedicationsCard()
                .openSeeAllMedications();
    }

    @Test (description = "validate the Medications Card when the user has no medications",  groups = {"smoke", "qa", "prod"})
    public void validateNoMedicationsObjectsAndLinks()  {
        KPAUIMedicationsCard medicationsCard = unAuthenticatedHomePage
                .signIn(NOTHING)
                .getMedicationsCard();

        assertTrue(medicationsCard.verifyNoMedicationsMessage());
        assertTrue(medicationsCard.verifyTransferPrescriptionsTextAndIcon());

        medicationsCard.openTransferPrescriptions();
    }
}