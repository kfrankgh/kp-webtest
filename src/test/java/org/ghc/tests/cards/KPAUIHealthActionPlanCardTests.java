package org.ghc.tests.cards;

import org.ghc.cards.KPAUIHealthActionPlanCard;
import org.ghc.utils.extensions.KPAUIEveryTest;
import org.testng.annotations.*;

import java.lang.reflect.Method;

import static org.ghc.utils.KPAUICredentials.accountName.*;
import static org.testng.Assert.assertTrue;

public class KPAUIHealthActionPlanCardTests extends KPAUIEveryTest {
    private KPAUIHealthActionPlanCard healthActionPlanCard;

    @BeforeMethod(alwaysRun = true)
    public void beforeTest(Method method) {
        healthActionPlanCard = super.initializeTest(method)
                .signIn(EVERYTHING)
                .getHealthActionPlanCard();
    }

    //------------------------------------------------------------------------------------------------------------------

    @Test(description = "Health Action Plan Card Links and Texts",  groups = {"smoke", "qa", "prod"})
    public void verifyHealthActionCardLinks() {
        assertTrue(healthActionPlanCard.verifyHealthActionPlanLinkText());
        assertTrue(healthActionPlanCard.verifyProfileTextMatches());

        healthActionPlanCard.openHealthActionPlanPage()
                .openAuthenticatedHomePage()
                .getHealthActionPlanCard()
                .openHealthProfileDisclosureShade()
                .agreeToDisclosureAndOpenHealthActionPlanPage();
    }
}
