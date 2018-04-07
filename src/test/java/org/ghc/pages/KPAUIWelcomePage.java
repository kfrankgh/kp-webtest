package org.ghc.pages;

import org.ghc.utils.extensions.KPAUIEveryPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.ghc.utils.helpers.KPAUITestHelper.waitForElementToBeClickable;
import static org.testng.Assert.fail;

public class KPAUIWelcomePage extends KPAUIEveryPage {

    public KPAUIWelcomePage(WebDriver driver) {
        super(driver);
        if (!isCurrent(driver, PAGETITLE_WELCOME_CONGRATULATIONS))
            fail("The Welcome/Congratulations page did not load correctly");
    }

    //------------------------------------------------------------------------------------------------------------------

    private static final String PAGETITLE_WELCOME_CONGRATULATIONS = "Congratulations!";

    // Finder
    @FindBy(xpath = "//*[@id='registrationPage']/div[3]/p/a")   private WebElement signOnNow;

    // Getter
    private WebElement getSignOnNow() { return waitForElementToBeClickable(signOnNow, driver); }

    // Method
    public KPAUIAuthenticatedHomePage clickSignOnNow() {
        getSignOnNow().click();
        return new KPAUIAuthenticatedHomePage(driver);
    }
}
