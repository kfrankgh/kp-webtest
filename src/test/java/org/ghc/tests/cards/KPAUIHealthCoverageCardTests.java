package org.ghc.tests.cards;

import org.ghc.cards.KPAUIHealthCoverageCard;
import org.ghc.utils.extensions.KPAUIEveryTest;
import org.testng.annotations.*;
import java.lang.reflect.Method;

import static org.ghc.utils.KPAUICredentials.accountName.*;
import static org.testng.Assert.assertTrue;

public class KPAUIHealthCoverageCardTests extends KPAUIEveryTest {
    private KPAUIHealthCoverageCard healthCoverageCard;

    @BeforeMethod(alwaysRun = true)
    public void beforeTest(Method method) {
        healthCoverageCard = super.initializeTest(method)
                .signIn(EVERYTHING)
                .getHealthCoverageCard();
    }

    //------------------------------------------------------------------------------------------------------------------

    @Test(description = "Verify Health Coverage Card Contents And Links",  groups = {"smoke", "qa", "prod"})
    public void validateHealthCoverageCardContentsAndLinks() {
        assertTrue(healthCoverageCard.verifyHealthCoverageHeader());
        assertTrue(healthCoverageCard.verifyBenfitsUsageStatusLinksTexts());
        assertTrue(healthCoverageCard.verifyCoverageDocumentsLinksTexts());
        assertTrue(healthCoverageCard.verifyDigitalIDCardLinksTexts());
        assertTrue(healthCoverageCard.verifyExplanationOfBenefitsLinksTexts());
    }

    @Test(description = "Verify Links Go To The Proper Pages",  groups = {"smoke", "qa", "prod"})
    public void validateHealthCoverageCardLinksGoToValidPages()  {
        healthCoverageCard.openExplanationOfBenefitsPage()
                .openHomePageFromHeader()
                .getHealthCoverageCard()
                .openBenefitsUsagePage()
                .openHomePageFromHeader()
                .getHealthCoverageCard()
                .openCoverageDocumentsPage();
//        healthCoverageCard.openDigitalIdShade();
    }
}
