package org.ghc.cards;

import org.ghc.pages.KPAUIHealthActionPlanPage;
import org.ghc.pages.KPAUIHealthProfileQuestionnairePage;
import org.ghc.shades.KPAUIHealthProfileDisclosureShade;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.ghc.utils.helpers.KPAUITestHelper.*;
import static org.testng.Assert.fail;

public class KPAUIHealthActionPlanCard {
    private WebDriver driver;

    public KPAUIHealthActionPlanCard(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        if (!isCurrent())
            fail("Health Action Plan card is not visible");
    }

    private boolean isCurrent() {
        return getYourHealthActionPlanLink().isDisplayed();
    }

    //------------------------------------------------------------------------------------------------------------------

    private static final String cardPrefix1 =                   "//kp-health-action-plan-card/core-card/div/div[1]/div";
    private static final String header =                        "Health Action Plan";
    private static final String healthProfile =                 "(?i)Fill out your health profile now and see personalized health information.";

    @FindBy(xpath = cardPrefix1 + "/div/h4/core-router-link/a") private WebElement yourHealthActionPlanLink;
    @FindBy(xpath = cardPrefix1 + "/div/core-link/a")           private WebElement healthProfileQuestionnaire;

    private WebElement getHealthProfileQuestionnaireLink()      { return waitForElementToBeClickable(healthProfileQuestionnaire, driver); }
    private WebElement getYourHealthActionPlanLink()            { return waitForElementToBeClickable(yourHealthActionPlanLink, driver); }

    /** Opens the Health Profile Questionnaire page from the Questionnaire Link
     * @return - Health Profile Questionnaire Page (KPAUIHealthProfileQuestionnairePage)
     */
    public KPAUIHealthProfileDisclosureShade openHealthProfileDisclosureShade() {
        getHealthProfileQuestionnaireLink().click();
        return new KPAUIHealthProfileDisclosureShade(driver);
    }

    /** Opens the Health Action Plan page from the Health Action Plan Link
     * @return - Health Action Plan Page (KPAUIHealthActionPlanPage)
     */
    public KPAUIHealthActionPlanPage openHealthActionPlanPage() {
        getYourHealthActionPlanLink().click();
        return new KPAUIHealthActionPlanPage(driver);
    }

    /** Verifies that the Health Action Plan Text Matches Expected
     * @return - True Links Matches "Health Action Plan"
     */
    public boolean verifyHealthActionPlanLinkText() {
        return getYourHealthActionPlanLink().getText().matches(header);
    }

    /** Verifies that the Health Profile Text Matches Expected
     * @return - True if the Text Matches
     */
    public boolean verifyProfileTextMatches() {
        return getHealthProfileQuestionnaireLink().getText().matches(healthProfile);
    }
}