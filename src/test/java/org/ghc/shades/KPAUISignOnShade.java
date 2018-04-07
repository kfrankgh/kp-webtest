package org.ghc.shades;

import org.ghc.pages.KPAUIAuthenticatedHomePage;
import org.ghc.pages.KPAUIPasswordResetPage;
import org.ghc.pages.KPAUIOnBoardingInformationPage;
import org.ghc.pages.KPAUIUnAuthenticatedHomePage;
import org.ghc.utils.KPAUICredentials;
import org.ghc.utils.extensions.KPAUIEveryShade;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.ghc.utils.KPAIUTestConstants.logging.loginCredentials;
import static org.ghc.utils.helpers.KPAUITestHelper.waitForElement;
import static org.testng.Assert.fail;

public class KPAUISignOnShade extends KPAUIEveryShade {

    public KPAUISignOnShade(WebDriver driver){
        super(driver);
        if (!isCurrent())
            fail("Sign on Shade is not visible");
    }

    private boolean isCurrent(){
        return getSignOnButton().isDisplayed();
    }

    //------------------------------------------------------------------------------------------------------------------

    public static final String FORGOT_PASSWORD_TEXT =               "Forgot your password?";
    public static final String MEMBERID_TEXT =                      "MEMBER ID";
    public static final String PASSWORD_TEXT =                      "PASSWORD";
    public static final String REGISTER_NOW_TEXT =                  "Register now";
    public static final String SIGN_ON_TEXT =                       "Sign on";

    @FindBy(xpath = "//div[2]/div/div/div/button[2]/span")          private WebElement cancelButton;
    @FindBy(xpath = "//core-login/div/form/div[2]/a")               private WebElement forgotPasswordLink;
    @FindBy(xpath = "//core-login/div/form/div[1]/input")           private WebElement memberIDField;
    @FindBy(xpath = "//core-login/div/form/div[1]/label")           private WebElement memberIDLabel;
    @FindBy(xpath = "//core-login/div/form/div[2]/input")           private WebElement passwordField;
    @FindBy(xpath = "//core-login/div/form/div[2]/label")           private WebElement passwordLabel;
    @FindBy(xpath = "//core-login/div/form/div[3]/a")               private WebElement registerNowLink;
    @FindBy(xpath = "//core-login/div/form/div[3]/button/span")     private WebElement signOnButton;

    public WebElement getCancelButton()                             { return cancelButton; }
    public WebElement getForgotPasswordLink()                       { return forgotPasswordLink; }
    public WebElement getMemberIDField()                            { return memberIDField; }
    public WebElement getMemberIDLabel()                            { return memberIDLabel; }
    public WebElement getPasswordLabel()                            { return passwordLabel; }
    public WebElement getPasswordField()                            { return passwordField; }
    public WebElement getRegisterNowLink()                          { return registerNowLink; }
    public WebElement getSignOnButton()                             { return waitForElement(signOnButton, driver); }

    /**
     * @return
     */
    public KPAUIUnAuthenticatedHomePage clickCancelSignInButton(){
        getCancelButton().click();
        return new KPAUIUnAuthenticatedHomePage(driver);
    }

    /**
     * @return
     */
    public KPAUIPasswordResetPage openForgotPasswordLink(){
        getForgotPasswordLink().click();
        return new KPAUIPasswordResetPage(driver);
    }

    /**
     * @return
     */
    public KPAUIOnBoardingInformationPage openRegisterNowLink(){
        getRegisterNowLink().click();
        return new KPAUIOnBoardingInformationPage(driver);
    }

    /**
     * @param accountName
     * @return
     */
    public KPAUIAuthenticatedHomePage signIn(KPAUICredentials.accountName accountName) {
        getMemberIDField().sendKeys(accountName.getID());
        getPasswordField().sendKeys(accountName.getPass());

        getSignOnButton().click();
        System.out.printf(loginCredentials, accountName.getID(), accountName.getPass() );
        return new KPAUIAuthenticatedHomePage(driver);
    }
}
