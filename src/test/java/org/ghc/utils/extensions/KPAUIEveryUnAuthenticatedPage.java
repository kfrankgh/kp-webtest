package org.ghc.utils.extensions;

import org.ghc.pages.*;
import org.ghc.shades.*;
import org.ghc.utils.KPAUICredentials.accountName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.ghc.utils.helpers.KPAUITestHelper.waitForElement;
import static org.ghc.utils.helpers.KPAUITestHelper.waitForElementToBeClickable;

public class KPAUIEveryUnAuthenticatedPage extends KPAUIEveryPage {
    public KPAUIEveryUnAuthenticatedPage(WebDriver driver) {
        super(driver);
    }

    //------------------------------------------------------------------------------------------------------------------
    //shades
    public static final String shopPlansLinkText = "Shop Plans";
    public static final String getCareLinkText = "Get Care";
    public static final String findADoctorLinkText = "Find A Doctor";
    public static final String memberResourcesLinkText = "Member Resources";
    public static final String wellnessLinkText = "Wellness";

    // Finders
    @FindBy(css = "a[name='/get-care'] .link-text")                             private WebElement careShadeIcon;
    @FindBy(css = "a[name='/find-a-doctor'] .link-text")                        private WebElement findADoctorShadeIcon;
    @FindBy(xpath = "//core-nav-bar/nav/div/ul/li[5]/a")                        private WebElement memberResourcesShadeIcon;
    @FindBy(xpath = "//core-header/div[1]/div/div[1]/a/img")                    private WebElement homeIcon;
    @FindBy(css = "a[name='/shop-plans'] .link-text")                           private WebElement shopPlansShadeIcon;
    @FindBy(xpath = "//core-header/div[1]/div/div[2]/div[1]/div/div/button")    private WebElement signOnBtn;
    @FindBy(css = "a[name='/wellness'] .link-text")                             private WebElement wellnessShadeIcon;

    // Getters
    public  WebElement getBtnSignOn()                   { return waitForElementToBeClickable(signOnBtn, driver); }
    public  WebElement getFindADoctorShadeIcon()        { return waitForElement(findADoctorShadeIcon, driver); }
    public  WebElement getGetCareShadeIcon()            { return waitForElement(careShadeIcon, driver); }
    private  WebElement getHomeIcon()                   { return waitForElementToBeClickable(homeIcon, driver); }
    public  WebElement getMemberResourcesShadeIcon()    { return waitForElementToBeClickable(memberResourcesShadeIcon, driver); }
    public  WebElement getShopPlansShadeIcon()          { return waitForElement(shopPlansShadeIcon, driver); }
    public  WebElement getWellnessShadeIcon()           { return waitForElement(wellnessShadeIcon, driver); }


    //Methods
    /** Click on the Find a Doctor link to open the Find a Doctor page
     * @return KPAUIFindADoctorLandingPage
     */
    public KPAUIFindADoctorLandingPage clickFindADoctorTopNavHeader(){
        getFindADoctorShadeIcon().click();
        return new KPAUIFindADoctorLandingPage(driver);
    }

    /** Click on Top Nav Get Care link to open the Get Care shade
     * @return KPAUIGetCareShade
     */
    public KPAUIGetCareShade openGetCareShade(){
        getGetCareShadeIcon().click();
        return new KPAUIGetCareShade(driver);
    }

    /** Click on the Home icon to open the Authenticated Home page
     * @return Top Nav - KPAUIAuthenticatedHomePage
     */
    public KPAUIUnAuthenticatedHomePage openHomePageFromHeader() {
        getHomeIcon().click();
        return new KPAUIUnAuthenticatedHomePage(driver);
    }

    /** Uses driver.get() to open the UnAuthenticated Home page
     * @return KPAUIUnAuthenticatedHomePage
     */
    public KPAUIUnAuthenticatedHomePage openUnAuthenticatedHomePageFromHeader() {
        getHomeIcon().click();
        return new KPAUIUnAuthenticatedHomePage(driver);
    }


    /** Click on Top Nav Member Resources link to open the Member Resources shade
     * @return KPAUIMemberResourcesShade
     */
    public KPAUIMemberResourcesShade openMemberResourcesShade(){
        getMemberResourcesShadeIcon().click();
        return new KPAUIMemberResourcesShade(driver);
    }

    /** Click on Top Nav Shop Plans link to open the Shop Plans shade
     * @return KPAUIShopPlansShade
     */
    public KPAUIShopPlansShade openShopPlansShade(){
        getShopPlansShadeIcon().click();
        return new KPAUIShopPlansShade(driver);
    }

    /** Click on Header Sign on link to open the Sign on shade
     * @return KPAUISignOnShade
     */
    public KPAUISignOnShade openSignOnShade(){
        getBtnSignOn().click();
        return new KPAUISignOnShade(driver);
    }

    /** Click on Top Nav Wellness link to open the Wellness shade
     * @return KPAUIWellnessShade
     */
    public KPAUIWellnessShade openWellnessShade(){
        getWellnessShadeIcon().click();
        return new KPAUIWellnessShade(driver);
    }

    /** Click on the Sign On link in the Header to open the Sign On Shade
     *  Call the Sign In method with params to sign on and return Authenticated Home page
     * @param accountName - The account name you wish to sign in with (KPAUIAccount)
     * @return KPAUIAuthenticatedHomePage
     */
    public KPAUIAuthenticatedHomePage signIn(accountName accountName) {
        return openSignOnShade().signIn(accountName);
    }
}

