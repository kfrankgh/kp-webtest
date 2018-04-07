package org.ghc.pages;

import org.ghc.utils.extensions.KPAUIEveryUnAuthenticatedPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.ghc.utils.helpers.KPAUITestHelper.waitForElementToBeClickable;
import static org.testng.Assert.fail;

public class KPAUIPasswordResetPage extends KPAUIEveryUnAuthenticatedPage {

    public KPAUIPasswordResetPage(WebDriver driver) {
        super(driver);
        if (!isCurrent(driver, pageTitlePasswordReset))
            fail("The Password Reset Page did not load correctly");
    }

    //------------------------------------------------------------------------------------------------------------------

    private static final String pageTitlePasswordReset = "Verify Your Account Information";


    // Finders
    @FindBy(xpath = "//*[@id=\"header\"]/a/img")            private WebElement homePageIcon;

    // Getters
    private WebElement getHomePageIcon()                    { return waitForElementToBeClickable(homePageIcon, driver); }

    //Methods
    /** clicks on the Home Page Icon to open the UnAuthenticated Home Page.
     * @return The Public Home Page - KPAUIUnAuthenticatedHomePage
     */
    @Override
    public KPAUIUnAuthenticatedHomePage openUnAuthenticatedHomePage(){
        getHomePageIcon().click();
        return new KPAUIUnAuthenticatedHomePage(driver);
    }
}