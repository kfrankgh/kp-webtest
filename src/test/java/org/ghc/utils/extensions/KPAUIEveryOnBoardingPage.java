package org.ghc.utils.extensions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.ghc.utils.helpers.KPAUITestHelper.waitForElementToBeClickable;

public class KPAUIEveryOnBoardingPage extends KPAUIEveryUnAuthenticatedPage {

    public KPAUIEveryOnBoardingPage(WebDriver driver) {
        super(driver);
    }

    //------------------------------------------------------------------------------------------------------------------

    // Finders
    @FindBy(css = ".onboarding-body .onboarding-button-2")      private WebElement cancelButton;
    @FindBy(css = ".onboarding-button-2")                       private WebElement clearFormButton;
    @FindBy(css = ".onboarding-body .onboarding-button-1")      private WebElement nextButton;

    //getters
    protected WebElement getCancelButton()  { return waitForElementToBeClickable(cancelButton, driver); }
    public WebElement getClearFormButton()  { return waitForElementToBeClickable(clearFormButton, driver); }
    protected WebElement getNextButton()    { return waitForElementToBeClickable(nextButton, driver); }
}