package org.ghc.pages;

import org.ghc.utils.extensions.KPAUITransferRxEveryPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.ghc.utils.helpers.KPAUITestHelper.sleep;
import static org.ghc.utils.helpers.KPAUITestHelper.waitForElement;
import static org.ghc.utils.helpers.KPAUITestHelper.waitForElementToBeClickable;
import static org.testng.Assert.fail;

public class KPAUITransferRxSummaryPage extends KPAUITransferRxEveryPage {
    public KPAUITransferRxSummaryPage(WebDriver driver) {
        super(driver);
        if (!isCurrent())
            fail("The TransferRx Summary Page did not load correctly");

    }

    /** Checks if the Step 2 Check mark is displayed
     * @return boolean - true if Step 2 check mark is displayed
     */
    public boolean isCurrent(){
        return getStep2DoneCheckMark().isDisplayed();

    }

    //------------------------------------------------------------------------------------------------------------------

    // Finders
    @FindBy(xpath = "//div[2]/div/button[1]")                           private WebElement addAPrescriptionButton;
    @FindBy(xpath = "//div[2]/div/div[5]/div/div[1]")                   private WebElement confirmAddrLineOneForm;
    @FindBy(xpath = "//div[2]/div/div[5]/div/div[3]")                   private WebElement confirmCityForm;
    @FindBy(xpath = "//div[2]/div/button[2]")                           private WebElement doneButton;
    @FindBy(xpath = "//div[2]/div/div[1]/div")                          private WebElement prescriptionsYouHaveAddedHeader;
    @FindBy(xpath = "//div[2]/div/div[1]/ul/li[1]")                     private WebElement prescriptionsYouHaveAddedItems1;
    @FindBy(xpath = "//core-button[2]")                                 private WebElement refillLaterButton;
    @FindBy(xpath = "//core-button[2]/button")                          private WebElement refillLaterButtonLabel;
    @FindBy(xpath = "//core-button[1]")                                 private WebElement refillNowButton;
    @FindBy(xpath = "//core-button[1]/button")                          private WebElement refillNowButtonLabel;

    // Getters
    public WebElement getPrescriptionsYouHaveAddedHeader()      { return waitForElement(prescriptionsYouHaveAddedHeader, driver); }
    public WebElement getPrescriptionsYouHaveAddedItems1()      { return waitForElement(prescriptionsYouHaveAddedItems1, driver); }
    public WebElement getAddAPrescriptionButton()               { return waitForElementToBeClickable(addAPrescriptionButton, driver); }
    public WebElement getDoneButton()                           { return waitForElementToBeClickable(doneButton, driver); }

    // Methods
    /** Click Done Button to continue to the Summary page
     * @return KPAUITransferRxConfirmationPage
     */
    public KPAUITransferRxConfirmationPage clickSummaryDone() {
        sleep(1);
        getDoneButton().click();
        sleep(1);
        return new KPAUITransferRxConfirmationPage(driver);
    }
}