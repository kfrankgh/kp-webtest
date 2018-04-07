package org.ghc.tests.pages;

import org.ghc.pages.KPAUITransferRxSummaryPage;
import org.ghc.utils.extensions.KPAUIEveryTest;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

import java.lang.reflect.Method;

import static org.ghc.utils.KPAUICredentials.accountName.EVERYTHING;
import static org.ghc.utils.KPAUIPageConstants.ExpectedLinksAndHeaders.TransferPrescriptions.*;
import static org.ghc.utils.KPAUIPageConstants.FormLabels.*;
import static org.testng.Assert.*;

public class KPAUITransferRxSummaryPageTests extends KPAUIEveryTest {
    private KPAUITransferRxSummaryPage kpauiTransferRxSummaryPage;

    @BeforeMethod(alwaysRun = true)
    public void beforeTest(Method method) {
        kpauiTransferRxSummaryPage = super.initializeTest(method)
                .openSignOnShade()
                .signIn(EVERYTHING)
                .openMedicationsShade()
                .openTransferRxYourInfoPage()
                .completeStep1YesPerms()
                .completeAddRx();
    }
    // ------------------------------------------------------------------------------------------------------------------

    // List of Prescriptions to Transfer Tests
    @Test(description = "Verify The Third Step Functionality", groups = {"smoke", "qa", "prod"})
    public void verifyProgressNavListItemThreeIsActive() {

        // Verify The Third Step in the Progress Nav List is Active
        WebElement step2Done = kpauiTransferRxSummaryPage.getStep2DoneCheckMark();
        WebElement progressNavListItemThree = kpauiTransferRxSummaryPage.getStep3();
        WebElement activeStep = kpauiTransferRxSummaryPage.getActiveStep();
        assertEquals(progressNavListItemThree, activeStep);
        assertTrue(step2Done.isDisplayed());

        // Verify the List of Prescriptions Test is Displayed
        WebElement rxYouHaveAddedHeader = kpauiTransferRxSummaryPage.getPrescriptionsYouHaveAddedHeader();
        WebElement listOfDrugsAddedItem1 = kpauiTransferRxSummaryPage.getPrescriptionsYouHaveAddedItems1();
        assertTrue(rxYouHaveAddedHeader.isDisplayed());
        assertEquals(rxYouHaveAddedHeader.getText().toLowerCase(), DRUGS_YOUVE_ADDED_HEADER_EXPECTED_TEXT.toLowerCase());
        assertTrue(listOfDrugsAddedItem1.isDisplayed());

        // Verify Add A Prescription Button And Done buttons Are Displayed
        WebElement addAPrescriptionButton = kpauiTransferRxSummaryPage.getAddAPrescriptionButton();
        WebElement doneButton = kpauiTransferRxSummaryPage.getDoneButton();
        assertTrue(doneButton.isDisplayed());
        assertEquals(doneButton.getText().toLowerCase(), SUBMIT_BUTTON_EXPECTED_STRING.toLowerCase());
        assertTrue(addAPrescriptionButton.isDisplayed(), "addAPrescriptionButton is not displayed!");
        assertEquals(addAPrescriptionButton.getText().toLowerCase(), ADD_RX_BUTTON_LABEL_EXPECTED_STRING.toLowerCase());
    }
}
