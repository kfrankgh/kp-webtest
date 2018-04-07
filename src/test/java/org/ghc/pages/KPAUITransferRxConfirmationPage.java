package org.ghc.pages;

import org.ghc.utils.extensions.KPAUITransferRxEveryPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.ghc.utils.helpers.KPAUITestHelper.waitForElement;
import static org.ghc.utils.helpers.KPAUITestHelper.waitForElementToBeClickable;
import static org.testng.Assert.fail;

public class KPAUITransferRxConfirmationPage extends KPAUITransferRxEveryPage {

    public KPAUITransferRxConfirmationPage(WebDriver driver) {
        super(driver);
        if (!isCurrent())
            fail("The TransferRx Confirmation Page did not load correctly");
    }

    /** Get step 3 check mark and verify it is displayed to verigy the test is in the correct step og the flow.
     * @return boolean
     */
    public boolean isCurrent(){
        return getStep3DoneCheckMark().isDisplayed();
    }

    //------------------------------------------------------------------------------------------------------------------

    // Finders
    @FindBy(xpath = "//core-button[1]")                                 private WebElement refillNowButton;
    @FindBy(xpath = "//core-button[2]")                                 private WebElement refillLaterButton;
    @FindBy(xpath = "//div[1]/core-textbox/input")                      private WebElement refillNowAddressLineOneForm;
    @FindBy(xpath = "//div[2]/core-textbox/input")                      private WebElement refillNowAddressLineTwoForm;
    @FindBy(xpath = "//div[3]/core-textbox/input")                      private WebElement refillNowAddressCityForm;
    @FindBy(xpath = "//div[4]/core-textbox/input")                      private WebElement refillNowAddressStateForm;
    @FindBy(xpath = "//div[5]/core-textbox/input")                      private WebElement refillNowAddressZipForm;
    @FindBy(xpath = "//div[6]/core-textbox/input")                      private WebElement refillNowInstructionsForm;
    @FindBy(xpath = "//div[7]/core-button")                             private WebElement refillNowDoneButton;


    // Getters
    public WebElement getRefillNowButton()                          { return waitForElementToBeClickable(refillNowButton, driver); }
    public WebElement getRefillLaterButton()                        { return waitForElementToBeClickable(refillLaterButton, driver); }
    public WebElement getRefillNowAddressLineOneForm()              { return waitForElement(refillNowAddressLineOneForm, driver); }
    public String getAddressLineOnePopulatedValue()                 { return refillNowAddressLineOneForm.getAttribute("value"); }
    public WebElement getRefillNowAddressLineTwoForm()              { return waitForElement(refillNowAddressLineTwoForm, driver); }
    public String getCityPopulatedValue()                           { return getRefillNowAddressCityForm().getAttribute("value"); }
    public WebElement getRefillNowAddressCityForm()                 { return waitForElement(refillNowAddressCityForm, driver); }
    public WebElement getRefillNowAddressStateForm()                { return waitForElement(refillNowAddressStateForm, driver); }
    public String getStatePopulatedValue()                          { return getRefillNowAddressStateForm().getAttribute("value"); }
    public WebElement getRefillNowAddressZipForm()                  { return waitForElement(refillNowAddressZipForm, driver); }
    public String getZipPopulatedValue()                            { return getRefillNowAddressZipForm().getAttribute("value"); }
    public WebElement getRefillNowInstructionsForm()                { return waitForElement(refillNowInstructionsForm, driver); }
    public WebElement getRefillNowDoneButton()                      { return waitForElement(refillNowDoneButton, driver); }


    /** Click on Refill Now button to return a modified Confirmation Page
     * @return KPAUITransferRxConfirmationPage
     */
    public KPAUITransferRxConfirmationPage clickStep3RefillNowButton() {
        getRefillNowButton().click();
        return new KPAUITransferRxConfirmationPage(driver);
    }

    /**  Click on Refill Later button to return to Summary Page
     * @return KPAUITransferRxSummaryPage
     */
    public KPAUITransferRxSummaryPage step3RefillLaterButton() {
        getRefillLaterButton().click();
        return new KPAUITransferRxSummaryPage(driver);
    }
}

