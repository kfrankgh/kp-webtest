package org.ghc.pages;

import org.ghc.utils.extensions.KPAUIEveryPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.ghc.utils.helpers.KPAUITestHelper.waitForElementToBeClickable;
import static org.testng.Assert.fail;

public class KPAUIUserAgreementPage extends KPAUIEveryPage {

    public KPAUIUserAgreementPage(WebDriver driver) {
        super(driver);
        if (!isCurrent(driver, PAGETITLE_MEMBER_USER_AGREEMENT))
            fail("The Kaiser Permanente Member User Agreement page did not load correctly");
    }

    //------------------------------------------------------------------------------------------------------------------

    private static final String PAGETITLE_MEMBER_USER_AGREEMENT = "User Agreement for Kaiser Permanente member website";

    // Finders
    @FindBy(xpath = "//*[@id='submitButton']")          private WebElement acceptButton;
    @FindBy(xpath = "//*[@id='agreementAccepted']")     private WebElement agreeCheckBox;

    // Getters
    private WebElement getAcceptButton()    { return waitForElementToBeClickable(acceptButton, driver); }
    private WebElement getAgreeCheckBox()   { return waitForElementToBeClickable(agreeCheckBox, driver); }

    /** clicks on agree checkbox and accept button in order to proceed to the Welcome Page
     * @return KPAUIWelcomePage
     */
    // Methods
    public KPAUIWelcomePage acceptAgreementAndContinue() {
        getAgreeCheckBox().click();
        getAcceptButton().click();
        return new KPAUIWelcomePage(driver);
    }
}

