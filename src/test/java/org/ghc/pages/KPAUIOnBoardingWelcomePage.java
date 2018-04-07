package org.ghc.pages;

import org.ghc.utils.extensions.KPAUIEveryAuthenticatedPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static org.testng.Assert.fail;

public class KPAUIOnBoardingWelcomePage extends KPAUIEveryAuthenticatedPage {

    public KPAUIOnBoardingWelcomePage(WebDriver driver) {
        super(driver);
        if (!isCurrent()) {
            fail("The Member Registration - Welcome page did not load correctly");
        }
    }

    //------------------------------------------------------------------------------------------------------------------

    // Finders
    @FindAll({@FindBy(css = "kp-member-registration-landing .page-title")})           private List<WebElement> pageTitle;

    // Getters

    public List<WebElement> getPageTitle() {
        return pageTitle;
    }


    // Methods
    /** get a list of Page Title elements and evaluate for true that there are more than 0
     * @return true if there is more than 0 titles - boolean
     */
    private boolean isCurrent(){
        return (getPageTitle().size() > 0);
    }
}
