package org.ghc.pages;

import org.ghc.utils.extensions.KPAUIEveryUnAuthenticatedPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.ghc.utils.helpers.KPAUITestHelper.waitForElementToBeClickable;
import static org.testng.Assert.fail;

public class KPAUINewMembersGuidePage extends KPAUIEveryUnAuthenticatedPage {

    public KPAUINewMembersGuidePage(WebDriver driver) {
        super(driver);
        if (!isCurrent(driver, PAGETITLE_NEW_MEMBER_TOOLKIT))
            fail("The New Member Toolkit Page did not load correctly");
    }

    //------------------------------------------------------------------------------------------------------------------

    private static final String PAGETITLE_NEW_MEMBER_TOOLKIT = "Kaiser Foundation Health Plan of Washington, Seattle, Washington";


    // Finder
    @FindBy(xpath = "//*[@id=\"1456544606485\"]/a[1]/img")                  private WebElement registerHereLink;

    private WebElement getRegisterHereLink()                                { return waitForElementToBeClickable(registerHereLink, driver); }

    public KPAUIOnBoardingInformationPage openRegisterHerePage() {
        getRegisterHereLink().click();
        return new KPAUIOnBoardingInformationPage(driver);
    }
}