package org.ghc.tests.cards;

import org.ghc.cards.KPAUIParentalAccessCard;
import org.ghc.utils.extensions.KPAUIEveryTest;
import org.testng.annotations.*;
import java.lang.reflect.Method;

import static org.ghc.utils.KPAUICredentials.accountName.*;
import static org.testng.Assert.assertTrue;

public class KPAUIParentalAccessCardTests extends KPAUIEveryTest {
    private KPAUIParentalAccessCard parentalAccessCard;

    @BeforeMethod(alwaysRun = true)
    public void beforeTest(Method method) {
        parentalAccessCard = super.initializeTest(method)
                .signIn(EVERYTHING)
                .getParentalAccessCard();
    }

    //------------------------------------------------------------------------------------------------------------------

    @Test(description = "Validates that each child is clickable and that each notification goes to the child's dashboard page", groups = {"smoke", "qa", "prod"})
    public void validateTheParentalAccessCard() {
        assertTrue(parentalAccessCard.verifyMedicationsCardHeaderText());
        assertTrue(parentalAccessCard.verifyChildOpensChildCard());
    }
}
