package org.ghc.pages;

import org.ghc.utils.KPAUICredentials.KPAUIAccount;
import org.ghc.utils.extensions.KPAUIEveryPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import static org.ghc.utils.helpers.KPAUITestHelper.waitForElement;
import static org.ghc.utils.helpers.KPAUITestHelper.waitForElementToBeClickable;

public class KPAUIMemberSignOnPage extends KPAUIEveryPage {

    public KPAUIMemberSignOnPage(WebDriver driver) {
        super(driver);
        if (!isCurrent(driver, PAGETITLE_MEMBER_SIGN_ON_PAGE))
            Assert.fail("The Member Sign On Page did not load correctly");
    }

    //------------------------------------------------------------------------------------------------------------------
    private static final String PAGETITLE_MEMBER_SIGN_ON_PAGE = "Kaiser Permanente member website Sign on Page";


    // Finders
    @FindBy(xpath = "//*[@id='header']/a/img")              private WebElement homePageIcon;
    @FindBy(xpath = "//*[@id='userId']")                    private WebElement memberIDBox;
    @FindBy(xpath = "//*[@id='passwordBox']")               private WebElement passwordBox;
    @FindBy(xpath = "//*[@id='submitButton']")              private WebElement signOnButton;

    // Getters
    private WebElement getHomePageIcon()                    { return waitForElementToBeClickable(homePageIcon, driver); }
    private WebElement getMemberIDBox()                     { return waitForElement(memberIDBox, driver); }
    private WebElement getPasswordBox()                     { return waitForElement(passwordBox, driver); }
    private WebElement getSignOnButton()                    { return waitForElementToBeClickable(signOnButton, driver); }

    // Methods

    /** click on the KP Logo in order to return to the Home Page
     * @return KPAUIUnAuthenticatedHomePage
     */
    public KPAUIUnAuthenticatedHomePage openUnAuthenticatedHomePage(){
        getHomePageIcon().click();
        return new KPAUIUnAuthenticatedHomePage(driver);
    }

    /** Get the Member and Password fields and enter member id and password then click on the Sign On Button to authenticate the user
     * @param account member ID and Password
     * @return KPAUIAuthenticatedHomePage
     */
    public KPAUIAuthenticatedHomePage loginToAuthticatedHomePage(KPAUIAccount account) {
        getMemberIDBox().sendKeys(account.getID());
        getPasswordBox().sendKeys(account.getPass());
        getSignOnButton().click();
        return new KPAUIAuthenticatedHomePage(driver);
    }

    /** Get the Member and Password fields and enter member id and password then click on the Sign On Button to authenticate the user
     * @param account member ID and Password
     * @return KPAUIUserAgreementPage
     */
    public KPAUIUserAgreementPage loginToUserAgreementPage(KPAUIAccount account) {
        getMemberIDBox().sendKeys(account.getID());
        getPasswordBox().sendKeys(account.getPass());
        getSignOnButton().click();
        return new KPAUIUserAgreementPage(driver);
    }
}
