package org.ghc.pages;

import org.ghc.utils.extensions.KPAUIEveryUnAuthenticatedPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.ghc.utils.helpers.KPAUITestHelper.waitForElementToBeClickable;
import static org.testng.Assert.fail;

public class KPAUIGoodbyePage extends KPAUIEveryUnAuthenticatedPage {

    public KPAUIGoodbyePage(WebDriver driver) {
        super(driver);
        if (!isCurrent(driver, PAGETITLE_GOODBYE))
            fail("The KP Goodbye Page did not load correctly");
    }

    //------------------------------------------------------------------------------------------------------------------

    public static final String PAGETITLE_GOODBYE = "Signed out of Kaiser";

    // Finders
    @FindBy(linkText = "privacy policy")                    private WebElement privacyPolicyLink;
    @FindBy(linkText = "public home page")                  private WebElement publicHomePageLink;
    @FindBy(linkText = "sign on")                           private WebElement signInLink;

    // Getters
    private WebElement getPrivacyPolicyLink()               { return waitForElementToBeClickable(privacyPolicyLink, driver); }
    private WebElement getPublicHomePageLink()              { return waitForElementToBeClickable(publicHomePageLink, driver); }
    private WebElement getSignInLink()                      { return waitForElementToBeClickable(signInLink, driver); }

    // Methods
    /** Click on the Privacy Policy Link in order to open the Privacy Policy Page
     * @return KPAUIPrivacyPolicyPage
     */
    public KPAUIPrivacyPolicyPage openPrivacyPolicyLink(){
        getPrivacyPolicyLink().click();
        return new KPAUIPrivacyPolicyPage(driver);
    }

    /** Click on the KP Logo in order to open the Public Home Page
     * @return KPAUIUnAuthenticatedHomePage
     */
    public KPAUIUnAuthenticatedHomePage openPublicHomePageLink(){
        getPublicHomePageLink().click();
        return new KPAUIUnAuthenticatedHomePage(driver);
    }

    /** Click on the Sign In Link in order to open the Sign On Page
     * @return KPAUISiteMinderLoginPage
     */
    public KPAUISiteMinderLoginPage openSignInLink(){
        getSignInLink().click();
        return new KPAUISiteMinderLoginPage(driver);
    }
}