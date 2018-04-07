package org.ghc.shades;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.testng.Assert.fail;

public class KPAUIMemberIDHelpShade {
    private WebDriver driver;

    public KPAUIMemberIDHelpShade(WebDriver driver) {
        if (!isCurrent(driver)){
            fail("Member ID Help shade did no load correctly");
        }
        this.driver = driver;
    }

    //------------------------------------------------------------------------------------------------------------------
    public WebElement getCloseButton(){
        return driver.findElement(By.cssSelector(".modal-footer .btn"));
    }

    private boolean isCurrent(WebDriver driver){
        return ( driver.findElement(By.cssSelector(".modal-title")).getText().contains("Member ID Number Info"));
    }
}