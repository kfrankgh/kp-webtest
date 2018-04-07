package org.ghc.shades;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.ghc.utils.helpers.KPAUITestHelper.waitForElement;
import static org.testng.Assert.fail;

public class KPAUIPwdHelpShade{
        public KPAUIPwdHelpShade(WebDriver driver) {
            PageFactory.initElements(driver, this);
            this.driver = driver;
            if (!isCurrent()){
                fail("Password Rules Help shade did not load correctly");
            }
    }
    WebDriver driver;

    //------------------------------------------------------------------------------------------------------------------
    @FindBy(css=".modal-footer .btn")   private WebElement cancelButton;
    @FindBy(css=".modal-content .header-1")  private WebElement header;

    public WebElement getCancelButton(){
        return waitForElement(cancelButton, driver);
    }

    private WebElement getHeader(){
        return waitForElement(header, driver);
    }

    private boolean isCurrent(){
        return ( getHeader().getText().contains("Password"));
    }
}