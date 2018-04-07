package org.ghc.tests.cards;

import org.ghc.cards.KPAUIMedicalBillsCard;
import org.ghc.utils.extensions.KPAUIEveryTest;
import org.testng.annotations.*;

import java.lang.reflect.Method;

import static org.ghc.utils.KPAUICredentials.accountName.*;
import static org.testng.Assert.*;

public class KPAUIMedicalBillsCardTests extends KPAUIEveryTest {
    private  KPAUIMedicalBillsCard billsClaimsCard;

    @BeforeMethod(alwaysRun = true)
    public void beforeTest(Method method) {
        billsClaimsCard = super.initializeTest(method)
                .signIn(EVERYTHING)
                .getBillsClaimsCard();
    }

    //-------------------------------------------------------------------------------------

    @Test(description = "Validate The Medical Bills Card Objects And Links",  groups = {"smoke", "qa", "prod"})
    public void validateMedicalBillsCard() {
        assertTrue(billsClaimsCard.verifyMedicalBillsHeaderAndArrow());
        assertTrue(billsClaimsCard.verifyBalanceDueLabelAndAmount());
        assertTrue(billsClaimsCard.verifyPayBillLinkTextAndIcon());

        billsClaimsCard.openOnlineBillPayPage()
                .openHomePageFromHeader()
                .getBillsClaimsCard()
                .openBillingStatementsFromPayBillLink();
    }
}
