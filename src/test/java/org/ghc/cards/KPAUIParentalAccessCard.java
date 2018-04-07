package org.ghc.cards;

import org.ghc.pages.KPAUIChildDashboardPage;
import org.ghc.pages.KPAUIMessageCenterPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import java.util.List;

import static org.ghc.utils.helpers.KPAUITestHelper.sleep;
import static org.ghc.utils.helpers.KPAUITestHelper.waitForElement;
import static org.ghc.utils.helpers.KPAUITestHelper.waitForElementToBeClickable;
import static org.testng.Assert.fail;

public class KPAUIParentalAccessCard {
    private WebDriver driver;

    public KPAUIParentalAccessCard(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        if (!isCurrent())
            fail("The Parental Access card is not visible");
    }

    public boolean isCurrent() {
        return getParentalAccessHeader().isDisplayed();
    }

    //------------------------------------------------------------------------------------------------------------------
    private static final String header =                                "Parental Access";
    private static final String cardPrefix1 =                           "//kp-proxy-information-card/core-card/div/div[1]/div";
    private static final String cardPrefix2 =                           "//kp-proxy-information-card/core-card/div/div[2]/div";
    private static final String childCardPrefix1 =                      "//kp-proxy-information-detail-card/core-card/div/div[1]/div";
    private static final String childCardPrefix2 =                      "//kp-proxy-information-detail-card/core-card/div/div[2]/div";

    @FindBy(xpath = cardPrefix1 + "/h4")                                private WebElement parentalAccessHeader;
    @FindBy(xpath = childCardPrefix1 + "/img")                          private WebElement childCardArrow;
    @FindBy(xpath = childCardPrefix1 + "/h4")                           private WebElement childHeader;
    @FindAll({@FindBy(xpath = cardPrefix2 + "/div")})                   private List<WebElement> allChildrensNames;
    @FindAll({@FindBy(xpath = childCardPrefix2 + "/div")})              private List<WebElement> allChildItems;

    private WebElement getChildHeader()                                 { return waitForElement(childHeader, driver); }
    private WebElement getChildCardArrow()                              { return waitForElementToBeClickable(childCardArrow, driver); }
    private WebElement getParentalAccessHeader()                        { return waitForElement(parentalAccessHeader, driver); }
    private List<WebElement> getAllChildItems()                         { return allChildItems; }
    private List<WebElement> getAllChildrensNames()                     { return allChildrensNames; }

    /** Opens the The Child's Dashboard Page that contains New Messages and Reminders
     * @return - The Child's Dashboard Page(KPAUIChildDashboardPage)
     */
    private KPAUIChildDashboardPage openChildDashBoardPage(WebElement child) {
        child.click();
        return new KPAUIChildDashboardPage(driver);
    }

    /** Verifies that the card Header text matches "Parental Access"
     * @return - True if the text is correct
     */
    public boolean verifyMedicationsCardHeaderText() {
        return getParentalAccessHeader().getText().matches(header);
    }

    /** Goes through each child on the proxy card and verifies that the first link goes to the proper page.
     * @return - True if it can get through all the children on the card.
     */
    public boolean verifyChildOpensChildCard() {
        for (int i = 0; i < getAllChildrensNames().size(); i++) {

            // Gets each child's name in the list of Children
            WebElement child = getAllChildrensNames().get(i);
            String childName = child.getText();

            // If that child has notifications, click on the child
            if (!childName.matches(".*\\(N/A\\)") && !childName.matches(".*\\(0\\)")) {
                childName = childName.substring(0, child.getText().indexOf(" ("));
                child.click();

                // Ensures that the Child's name matches the header and the back arrow is displayed
                if (!getChildHeader().getText().equals(childName) ||
                        !getChildCardArrow().isDisplayed())
                    return false;

                // Clinks the first link under every child

                openChildDashBoardPage(getAllChildItems().get(0));
                driver.navigate().back();
                }
            }
        // Returns True if all kids/links are working
        return true;
    }
}
