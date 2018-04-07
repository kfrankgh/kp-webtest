package org.ghc.pages;

import org.ghc.utils.extensions.KPAUIEveryOnBoardingPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static org.ghc.utils.helpers.KPAUITestHelper.waitForElement;
import static org.testng.Assert.fail;

public class KPAUIOnBoardingThankYouPage extends KPAUIEveryOnBoardingPage {

    public KPAUIOnBoardingThankYouPage(WebDriver driver) {
        super(driver);
        if (!isCurrent()) {
            fail("The Member Registration - Thank You page did not load correctly");
        }
    }

    //------------------------------------------------------------------------------------------------------------------

    // Finders
    @FindBy(linkText = "RETURN TO KAISER PERMANENTE HOME")          private WebElement returnToKpHome;
    @FindBy(css = ".row.next-steps")                                private List<WebElement> thankYouSection;

    // Getters
    private WebElement getReturnToKpHome()                          { return waitForElement(returnToKpHome, driver); }
    private List<WebElement> getThankYouSection()                   { return thankYouSection; }

    // Methods
    /** Click on the KP Logo and click on it in order to return to the Home Page.
     * @return Public Home Page - KPAUIUnAuthenticatedHomePage
     */
    public KPAUIUnAuthenticatedHomePage clickReturnToKpHomePage() {
        getReturnToKpHome().click();
        return new KPAUIUnAuthenticatedHomePage(driver);
    }

    /** get a list of Thank You Section web elements and see if there is more than 0 items in that list.
     * @return true if List size > 0 - boolean
     */
    private boolean isCurrent(){
        return getThankYouSection().size() > 0;
    }
}
