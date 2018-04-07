package org.ghc.tests.shades;

import org.ghc.pages.KPAUIAuthenticatedHomePage;
import org.ghc.shades.KPAUICoverageCostsShade;
import org.ghc.utils.extensions.KPAUIEveryTest;
import org.testng.annotations.*;

import java.lang.reflect.Method;

import static org.ghc.shades.KPAUICoverageCostsShade.*;
import static org.ghc.utils.KPAUICredentials.accountName.*;
import static org.testng.Assert.*;

public class KPAUICoverageCostsShadeTests extends KPAUIEveryTest {
    private KPAUIAuthenticatedHomePage homePage;

    @BeforeMethod(alwaysRun = true)
    public void beforeTest(Method method) {
        homePage = super.initializeTest(method)
                .signIn(EVERYTHING);
    }

    //------------------------------------------------------------------------------------------------------------------

    @Test(description = "Coverage Costs Shade Links and Destination URLs", groups = {"smoke", "qa", "prod"})
    public void validateCoverageCostsShadeLinksAndTexts() {
        KPAUICoverageCostsShade coverageCostsShade = homePage.openCoverageCostsShade();

        // Coverage Costs Shade Header Test
        assertEquals(coverageCostsShade.getBillsSubHeader().getText(), BILLS_SUBHEADER);
        assertEquals(coverageCostsShade.getBenefitsSubHeader().getText(), BENEFITS_SUBHEADER);
        assertEquals(coverageCostsShade.getClaimsSubHeader().getText(), CLAIMS_SUBHEADER);

        // Coverage Costs Shade Links And Texts
        assertEquals(coverageCostsShade.getPayMyBillsLink().getText(), PAY_MY_BILL);
        assertEquals(coverageCostsShade.getPastPaymentsLink().getText(), PAST_PAYMENTS);
        assertEquals(coverageCostsShade.getFinancialAssistanceLink().getText(), FINANCIAL_ASSISTANCE);
        assertEquals(coverageCostsShade.getCoverageDocumentsLink().getText(), COVERAGE_DOCUMENTS);
        assertEquals(coverageCostsShade.getExplanationOfBenefitsLink().getText(), EXPLANATION_OF_BENEFITS);
        assertEquals(coverageCostsShade.getBenefitsUsageStatusLink().getText(), BENEFITS_USAGE_STATUS);
        assertEquals(coverageCostsShade.getSubmitAClaimLink().getText(), SUBMIT_CLAIM);
        assertEquals(coverageCostsShade.getHowToSubmitAClaimLink().getText(), HOW_TO_SUBMIT_CLAIMS_);
        assertEquals(coverageCostsShade.getCoverageClaimsAppeals().getText(), COVERAGE_CLAIMS_APPEALS);

        // Help Section
        assertTrue(coverageCostsShade.getShadeHelpSection().isDisplayed());
        assertTrue(coverageCostsShade.validateHelpSectionHeader());
        assertTrue(coverageCostsShade.validateMemEmailLink());
        assertTrue(coverageCostsShade.validateHelpSectionPhoneNumber());
    }

    @Test(description = "Validate Coverage Costs Shade Page Destinations", groups = {"qa", "prod"})
    public void validateAllPagesICoverageCostsShade() {
        homePage.openCoverageCostsShade().openBenefitsUsageStatusPage()
                .openCoverageCostsShade()
                .openBenefitsExplanationPage()
                .openCoverageCostsShade()
                .openCoverageDocumentsPage()
                .openCoverageCostsShade()
                .openPayMyBillPage()
                .openCoverageCostsShade()
                .openPastPaymentsLink()
                .openCoverageCostsShade()
                .openSubmitClaimPage()
                .openCoverageCostsShade()
                .openHowToSubmitAClaimPage()
                .openCoverageCostsShade()
                .openCoverageClaimsAppealsPage()
                .openCoverageCostsShade()
                .openFinancialAssistancePage();
    }
}
