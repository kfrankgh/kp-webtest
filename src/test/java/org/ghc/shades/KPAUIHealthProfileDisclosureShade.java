package org.ghc.shades;

import org.ghc.pages.KPAUIHealthProfileQuestionnairePage;
import org.ghc.utils.extensions.KPAUIEveryShade;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.ghc.utils.helpers.KPAUITestHelper.getChildDriver;
import static org.ghc.utils.helpers.KPAUITestHelper.waitForElement;
import static org.testng.Assert.fail;

public class KPAUIHealthProfileDisclosureShade extends KPAUIEveryShade {

    public KPAUIHealthProfileDisclosureShade(WebDriver driver) {
        super(driver);
        if (!isCurrent())
            fail("Health Profile Disclosure shade is not visible");
    }

    private boolean isCurrent() {
        return getHealthProfileHeader().isDisplayed();
    }

    //------------------------------------------------------------------------------------------------------------------

    @FindBy(xpath = "//kp-health-action-plan-agreement/div[1]")     private WebElement healthProfileHeader;
    @FindBy(xpath = "//core-checkbox/div/label/input")              private WebElement agreementCheckbox;
    @FindBy(xpath = "//div[3]/core-button[1]/button")               private WebElement acceptButton;

    private WebElement getHealthProfileHeader()                      { return waitForElement(healthProfileHeader, driver); }
    private WebElement getAgreementCheckbox()                        { return agreementCheckbox; }
    private WebElement getAcceptButton()                             { return acceptButton; }

    /** Checks the Agreement Box and then Clicks the "Accept" Button
     * @return - The Health Action Plan Page
     */
    public KPAUIHealthProfileQuestionnairePage agreeToDisclosureAndOpenHealthActionPlanPage() {
        getAgreementCheckbox().click();
        getAcceptButton().click();
        return new KPAUIHealthProfileQuestionnairePage(getChildDriver(driver));
    }
}
