package org.ghc.shades;

import org.ghc.pages.KPAUIContactCareTeamPage;
import org.ghc.pages.KPAUIMessageCenterPage;
import org.ghc.utils.extensions.KPAUIEveryShade;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.ghc.utils.helpers.KPAUITestHelper.waitForElement;
import static org.testng.Assert.fail;

public class KPAUIMessagesShade extends KPAUIEveryShade {

    public KPAUIMessagesShade(WebDriver driver) {
        super(driver);
        if (!isCurrent())
            fail("Messages shade is not visible");
    }

    private boolean isCurrent(){
        return getMessagesSubHeader().isDisplayed();
    }

    //------------------------------------------------------------------------------------------------------------------

    public static final String MESSAGES_SUBHEADER =         "Messages";
    public static final String INBOX =                      "Inbox";
    public static final String SENT =                       "Sent";
    public static final String CONTACT_CARE_TEAM =          "Contact Your Care Team";

    @FindBy(xpath = "//div/div[1]/div/p")                   private WebElement mesasgesSubHeader;
    @FindBy(xpath = "//div/div[1]/div/ul/li[1]/a")          private WebElement inboxLink;
    @FindBy(xpath = "//div/div[1]/div/ul/li[2]/a")          private WebElement sentLink;
    @FindBy(xpath = "//div/div[1]/div/ul/li[3]/a")          private WebElement contactCareTeamLink;

    public WebElement getMessagesSubHeader()                { return waitForElement(mesasgesSubHeader, driver); }
    public WebElement getInboxLink()                        { return inboxLink; }
    public WebElement getSentLink()                         { return sentLink; }
    public WebElement getContactYourCareTeamLink()          { return contactCareTeamLink; }


    /** Opens the Message Center Page from the Inbox Link
     * @return - KPAUIMessageCenterPage
     */
    public KPAUIMessageCenterPage openInboxMessagesPage() {
        getInboxLink().click();
        return new KPAUIMessageCenterPage(driver);
    }

    /** Opens the Message Center Page from the Inbox Link
     * @return - KPAUIMessageCenterPage
     */
    public KPAUIMessageCenterPage openSentMessagesPage() {
        getSentLink().click();
        return new KPAUIMessageCenterPage(driver);
    }

    /** Opens the Contact Your Care Team Page
     * @return - KPAUIContactCareTeamPage
     */
    public KPAUIContactCareTeamPage openContactYourCareTeam() {
        getContactYourCareTeamLink().click();
        return new KPAUIContactCareTeamPage(driver);
    }
}
