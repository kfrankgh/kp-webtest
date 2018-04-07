package org.ghc.cards;

import org.ghc.pages.KPAUIRoutineCareRemindersPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.ghc.utils.helpers.KPAUITestHelper.waitForElement;
import static org.testng.Assert.fail;

public class KPAUICareRemindersCard {
    private WebDriver driver;

    public KPAUICareRemindersCard(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        if (!isCurrent())
            fail("The Reminders card is not visible");
    }

    private boolean isCurrent() {
        return getCareRemindersCardHeader().isDisplayed();
    }

    //------------------------------------------------------------------------------------------------------------------
    private static final String cardPrefix1 =               "//kp-reminders-card/core-card/div/div[1]/div";
    private static final String cardPrefix2 =               "//kp-reminders-card/core-card/div/div[2]/div";
    private static final String header =                    "Care Reminders \\(\\d+\\)";
    private static final String noMessage =                 "You have no Reminders.";
    private static final String seeAllCareReminders =       "SEE ALL CARE REMINDERS";

    @FindBy(xpath = cardPrefix1 + "/img")                   private WebElement remindersArrow;
    @FindBy(xpath = cardPrefix2 + "/div/div[1]")            private WebElement noRemindersMessage;
    @FindBy(xpath = cardPrefix1 + "/h4")                    private WebElement remindersHeader;
    @FindBy(xpath = cardPrefix2 + "/div/core-link/a/img")   private WebElement seeAllCareRemindersIcon;
    @FindBy(xpath = cardPrefix2 + "/div/core-link/a")       private WebElement seeAllCareRemindersLink;

    private WebElement getCareRemindersArrow()              { return waitForElement(remindersArrow, driver); }
    private WebElement getCareRemindersCardHeader()         { return waitForElement(remindersHeader, driver); }
    private WebElement getNoRemindersMessage()              { return waitForElement(noRemindersMessage, driver); }
    private WebElement getSeeAllCareRemindersIcon()         { return waitForElement(seeAllCareRemindersIcon, driver); }
    private WebElement getSeeAllCareRemindersLink()         { return waitForElement(seeAllCareRemindersLink, driver); }

    /** Opens the Routine Care Reminders Page From the "SEE ALL CARE REMINDERS" link
     * @return - The Routine Care Reminders Page (KPAUIRoutineCareRemindersPage)
     */
    public KPAUIRoutineCareRemindersPage openRemindersPageFromSeeAllCareReminders() {
        getSeeAllCareRemindersLink().click();
        return new KPAUIRoutineCareRemindersPage(driver);
    }

    /** Opens the Routine Care Reminders Page From the Header
     * @return - The Routine Care Reminders Page (KPAUIRoutineCareRemindersPage)
     */
    public KPAUIRoutineCareRemindersPage openRemindersPageFromHeader() {
        getCareRemindersCardHeader().click();
        return new KPAUIRoutineCareRemindersPage(driver);
    }

    /** Checks that the Care Reminders Arrow and that Header says "Care Reminders"
     * @return - True both conditions are met.
     */
    public boolean verifyCareRemindersHeaderAndArrow() {
        return getCareRemindersArrow().isDisplayed() &&
                getCareRemindersCardHeader().getText().matches(header);
    }

    /** Verifies that the "No Reminder Message" text matches the expected
     * @return - True if the message texts are equal
     */
    public boolean verifyNoRemindersMessage() {
        return getNoRemindersMessage().getText().equals(noMessage);
    }

    /** Verifies that the "SEE ALL CARE REMINDERS" Link/Text are displayed
     * @return - True if both conditions are met
     */
    public boolean verifySeeAllCareRemindersLink() {
        return getSeeAllCareRemindersIcon().isDisplayed() &&
                getSeeAllCareRemindersLink().getText().equals(seeAllCareReminders);
    }
}
