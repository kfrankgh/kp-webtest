package org.ghc.tests.pages;

import org.ghc.pages.KPAUITransferRxConfirmationPage;
import org.ghc.utils.KPAUICredentials;
import org.ghc.utils.extensions.KPAUIEveryTest;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

import java.lang.reflect.Method;

import static org.ghc.utils.KPAUICredentials.accountName.EVERYTHING;
import static org.testng.Assert.*;

public class KPAUITransferRxConfirmationPageTests extends KPAUIEveryTest {

    public KPAUITransferRxConfirmationPage kpauiTransferRxConfirmationPage;

    @BeforeMethod(alwaysRun = true)
    public void beforeTest(Method method) {
        kpauiTransferRxConfirmationPage = super.initializeTest(method)
                .openSignOnShade()
                .signIn(EVERYTHING)
                .openMedicationsShade()
                .openTransferRxYourInfoPage()
                .completeStep1YesPerms()
                .completeAddRx()
                .clickSummaryDone()
                .clickStep3RefillNowButton();
    }

    @Test(description = "Validate Expected Pre-populated Member Data", groups = {"qa"})
    public void validatePrePopulatedMemberData() {
        KPAUICredentials.KPAUIAccount expectedMemberCredentials = EVERYTHING.getMemberInfo();

        String expectedMemberStreetAddress = expectedMemberCredentials.getAddress();
        String populatedStreetAddress = kpauiTransferRxConfirmationPage.getAddressLineOnePopulatedValue();
        assertEquals(populatedStreetAddress, expectedMemberStreetAddress,
                "Unexpected Member Address Was Entered by Auto-Complete");

        String expectedMemberCity = expectedMemberCredentials.getCity();
        String populatedCity = kpauiTransferRxConfirmationPage.getCityPopulatedValue();
        assertEquals(populatedCity, expectedMemberCity,
                "Unexpected Member City Was Entered by Auto-Complete");

        String expectedMemberState = expectedMemberCredentials.getState();
        String populatedState = kpauiTransferRxConfirmationPage.getStatePopulatedValue();
        assertEquals(populatedState, expectedMemberState,
                "Unexpected Member City Was Entered by Auto-Complete");

        String expectedMemberZip = expectedMemberCredentials.getZip();
        String populatedZip = kpauiTransferRxConfirmationPage.getZipPopulatedValue();
        assertTrue(expectedMemberZip.contains(populatedZip),
                "Unexpected Member Zip Code Was Entered by Auto-Complete");
    }

    @Test(description = "Verify Expected Nav Elements Displayed", groups = {"smoke", "qa", "prod"})
    public void verifyNavElementsAndExpectedShippingFormsAreDisplayed() {
        WebElement progressNavListItemFour = kpauiTransferRxConfirmationPage.getStep4();
        WebElement activeStep = kpauiTransferRxConfirmationPage.getActiveStep();
        assertEquals(progressNavListItemFour, activeStep);

        assertTrue(kpauiTransferRxConfirmationPage.getRefillNowAddressLineOneForm().isDisplayed(),
                "Line One Address Form Not Displayed");
        assertTrue(kpauiTransferRxConfirmationPage.getRefillNowAddressLineTwoForm().isDisplayed(),
                "Line Two Address Form Not Displayed");
        assertTrue(kpauiTransferRxConfirmationPage.getRefillNowAddressCityForm().isDisplayed(),
                "Address City Form Not Displayed");
        assertTrue(kpauiTransferRxConfirmationPage.getRefillNowAddressStateForm().isDisplayed(),
                "Address State Form Not Displayed");
        assertTrue(kpauiTransferRxConfirmationPage.getRefillNowAddressZipForm().isDisplayed(),
                "Address Zip Code Form Not Displayed");
        assertTrue(kpauiTransferRxConfirmationPage.getRefillNowInstructionsForm().isDisplayed(),
                "Address Special Shipping Instructions Form Not Displayed");
        assertTrue(kpauiTransferRxConfirmationPage.getRefillNowButton().isDisplayed(),
                "Refill Now Button Not Displayed");
        assertTrue(kpauiTransferRxConfirmationPage.getRefillLaterButton().isDisplayed(),
                "Refill Later Button Not Displayed");
        assertTrue(kpauiTransferRxConfirmationPage.getRefillNowDoneButton().isDisplayed(),
                "Done Button Not Displayed after Clicking On Refill Now");
    }
}
