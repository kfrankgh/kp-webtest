package org.ghc.pages;

import org.ghc.utils.extensions.KPAUIEveryUnAuthenticatedPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.ghc.utils.helpers.KPAUITestHelper.waitForElementToBeClickable;
import static org.testng.Assert.fail;

public class KPAUIHealthPlansIndividualAndFamilyPage extends KPAUIEveryUnAuthenticatedPage {

    public KPAUIHealthPlansIndividualAndFamilyPage(WebDriver driver) {
        super(driver);
        if (!isCurrent(driver, pageTitleHealthPlansIndividualAndFamily))
            fail("The Health Plans Page did not load correctly");
    }

    //------------------------------------------------------------------------------------------------------------------

    private static final String pageTitleHealthPlansIndividualAndFamily = "Individual and Family";

    // Finders
    @FindBy(xpath = "//*[@id='header']/header/a/img")           private WebElement homePageIcon;

    // Getters
    private WebElement getHomePageIcon()                        { return waitForElementToBeClickable(homePageIcon, driver); }

    //Methods
    /** Click on KP Logo in order to open the Public Home Page
     * @return KPAUIUnAuthenticatedHomePage
     */
    @Override
    public KPAUIUnAuthenticatedHomePage openUnAuthenticatedHomePage(){
        getHomePageIcon().click();
        return new KPAUIUnAuthenticatedHomePage(driver);
    }
}

