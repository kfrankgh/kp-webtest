package org.ghc.shades;

import org.ghc.utils.extensions.KPAUIEveryAuthenticatedPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.ghc.utils.helpers.KPAUITestHelper.waitForElement;
import static org.testng.Assert.fail;

public class KPAUIDigitalIDShade  extends KPAUIEveryAuthenticatedPage {

    public KPAUIDigitalIDShade(WebDriver driver) {
        super(driver);
        if (!isCurrent())
            fail("The Digital ID Card is not displayed");
    }

    private boolean isCurrent(){
        return verifyCardHeader() &&
                getDigitalIDCardImage1().isDisplayed() &&
                getDigitalIDCardImage2().isDisplayed() &&
                getDigitalIDCloseButton().isDisplayed();
    }

    //------------------------------------------------------------------------------------------------------------------

    @FindBy(xpath = "//div/div/div/div[1]/h4")                  private WebElement digitalIDCardheader;
    @FindBy(xpath = "//div/div/div/div[2]/div/div/div[1]/img")  private WebElement digitalIDCardImage1;
    @FindBy(xpath = "//div/div/div/div[2]/div/div/div[2]/img")  private WebElement digitalIDCardImage2;
    @FindBy(xpath = "//div/div/div/div[3]/button")              private WebElement digitalIDCloseButton;

    private WebElement getDigitalIIDCardHeader()                { return waitForElement(digitalIDCardheader, driver); }
    private WebElement getDigitalIDCardImage1()                 { return waitForElement(digitalIDCardImage1, driver); }
    private WebElement getDigitalIDCardImage2()                 { return waitForElement(digitalIDCardImage2, driver); }
    private WebElement getDigitalIDCloseButton()                { return waitForElement(digitalIDCloseButton, driver); }

    /** Verifies that the header matches "Your Digital ID Card"
     * @return - True if it matches
     */
    private boolean verifyCardHeader() {
        return getDigitalIIDCardHeader().getText().equals("Your Digital ID Card");
    }
}
