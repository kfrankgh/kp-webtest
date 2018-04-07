package org.ghc.cards;

import org.ghc.pages.KPAUIMailboxPage;
import org.ghc.pages.KPAUIMessageCenterPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.fail;


public class KPAUIMessagesCard {
    WebDriver driver;

    public KPAUIMessagesCard(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
        if (!isCurrent())
            fail("Messages card is not visible");
    }
    public boolean isCurrent() {
        return getMessagesHeader().isDisplayed();
    }

    //------------------------------------------------------------------------------------------------------------------

    private static final String cardPrefix1 =                       "//kp-messages-card/core-card/div/div[1]/div";
    private static final String cardPrefix2 =                       "//kp-messages-card/core-card/div/div[2]/div";
    private static final String goToMessageCenter =                 "GO TO MESSAGE CENTER";
    private static final String noMessages =                        "You have no new messages.";
    private static final String header =                            "Messages \\(\\d+\\)";
    private static final String seeAllMessages =                    "SEE ALL MESSAGES";

    @FindBy(xpath = cardPrefix2 + "/div/div[1]/div[2]")             private WebElement fromLine;
    @FindBy(xpath = cardPrefix2 + "/div/div[2]/core-link/a")        private WebElement goToMessageCenterLink;
    @FindBy(xpath = cardPrefix2 + "/div/div[2]/core-link/a/img")    private WebElement goToMessageCenterIcon;
    @FindBy(xpath = cardPrefix2 + "/div")                           private WebElement messagesBody;
    @FindBy(xpath = cardPrefix1 + "/img")                           private WebElement messagesArrow;
    @FindBy(xpath = cardPrefix1 + "/h4")                            private WebElement messagesHeader;
    @FindBy(xpath = cardPrefix2 + "/div/div[1]")                    private WebElement noMessagesMessage;
    @FindBy(xpath = cardPrefix2 + "/div/div[1]/div[3]")             private WebElement receivedLines;
    @FindBy(xpath = cardPrefix2 + "/div/div[3]/core-link/a")        private WebElement seeAllMessagesLink;
    @FindBy(xpath = cardPrefix2 + "/div/div[3]/core-link/a/img")    private WebElement seeAllMessagesIcon;
    @FindBy(xpath = cardPrefix2 + "/div/div[1]/div[1]")             private WebElement titleLine;

    private WebElement getMessagesHeader()                          { return messagesHeader; }
    private WebElement getMessagesCardArrow()                       { return messagesArrow; }
    private WebElement getSeeAllMessagesLink()                      { return seeAllMessagesLink; }
    private WebElement getSeeAllMessagesIcon()                      { return seeAllMessagesIcon; }
    private WebElement getGoToMessageCenterLink()                   { return goToMessageCenterLink; }
    private WebElement getGoToMessageCenterIcon()                   { return goToMessageCenterIcon; }
    private WebElement getNoNewMessages()                           { return noMessagesMessage; }
    private WebElement getMessagesBody()                            { return messagesBody; }

    /** Opens the Message Center Page from the "Go To Message Center"
     * @return - The Message Center Page (KPAUIMessageCenterPage)
     */
    public KPAUIMessageCenterPage openGoToMessageCenter(){
        getGoToMessageCenterLink().click();
        return new KPAUIMessageCenterPage(driver);
    }

    /** - Opens the Mailbox Page from the Card Header
     * @return - The Mailbox page (KPAUIMailboxPage)
     */
    public KPAUIMailboxPage openMessageCenterByHeader(){
        getMessagesHeader().click();
        return new KPAUIMailboxPage(driver);
    }

    /** Opens the Mailbox Page from the "See All Messages" Link
     * @return - The Mailbox page (KPAUIMailboxPage)
     */
    public KPAUIMailboxPage openSeeAllMessages(){
        getSeeAllMessagesLink().click();
        return new KPAUIMailboxPage(driver);
    }

    /** Verifies that the Header Text and Header Arrow is displayed and matches
     * @return - True if both conditions are met
     */
    public boolean verifyHeaderLinkAndArrow() {
        return getMessagesCardArrow().isDisplayed() &&
                getMessagesHeader().getText().matches(header);
    }

    /** Verifies that the "Go To Message Center" Link/Text are displayed
     * @return - True if both conditions are met
     */
    public boolean verifyGoToMessageCenterIconAndLink() {
        return getGoToMessageCenterIcon().isDisplayed() &&
                getGoToMessageCenterLink().getText().equals(goToMessageCenter);
    }

    /** Verify that the "No Messages" Text appears on an account with no messages
     * @return - True if the "No Messages" matches
     */
    public boolean verifyNoMessages() {
        return getNoNewMessages().getText().equals(noMessages);
    }

    /** Gets the lines from the card and verifies it's a multiple of 3 (Title, From, Received).
     * @return - True if the messages contain the correct number of lines.
     */
    public boolean verifyNumberOfMessageLines(){
        System.out.println(getMessagesBody().getText());
        List<String> allLines = Arrays.asList(getMessagesBody().getText().split("\n"));
        return ((allLines.size() - 1) % 3 == 0);
    }

    /** Verifies that the "See All Messages" Link/Text are displayed
     * @return - True if both conditions are met
     */
    public boolean verifySeeAllMessagesAndLink() {
        return getSeeAllMessagesIcon().isDisplayed() &&
                getSeeAllMessagesLink().getText().equals(seeAllMessages);
    }
}
