package org.ghc.tests.cards;

import org.ghc.cards.KPAUICareRemindersCard;
import org.ghc.utils.extensions.KPAUIEveryTest;
import org.testng.annotations.*;


import java.lang.reflect.Method;

import static org.ghc.utils.KPAUICredentials.accountName.*;
import static org.testng.Assert.assertTrue;

public class KPAUICareRemindersCardTest extends KPAUIEveryTest {
    private  KPAUICareRemindersCard careCard;

    @BeforeMethod(alwaysRun = true)
    public void beforeTest(Method method) {
        careCard = super.initializeTest(method)
                .signIn(EVERYTHING)
                .getCareRemindersCard();
    }

    //------------------------------------------------------------------------------------------------------------------

    @Test(description = "Validate Objects and Links on the Care Card",  groups = {"smoke", "qa", "prod"})
    public void validateObjectsLinksCareCard() {
        // Verify Contents of the Care Card
        assertTrue(careCard.verifyCareRemindersHeaderAndArrow());
        assertTrue(careCard.verifySeeAllCareRemindersLink());

        // Verify The Links on the Care Card go to Valid Pages
        careCard.openRemindersPageFromSeeAllCareReminders()
                .openAuthenticatedHomePageFromMyChart()
                .getCareRemindersCard()
                .openRemindersPageFromHeader();
    }

    @Test (description = "No Care Reminders Message",  groups = {"smoke", "qa", "prod"})
    public void validateNoCareRemindersOnCard() {
        //TODO: Get a "No Care Reminders" Account
//        assertTrue(careCard.verifyNoRemindersMessage());
    }
}