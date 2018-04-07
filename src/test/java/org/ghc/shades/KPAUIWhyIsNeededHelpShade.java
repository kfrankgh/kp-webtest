package org.ghc.shades;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.testng.Assert.fail;

public class KPAUIWhyIsNeededHelpShade {
    private WebDriver driver;

    public KPAUIWhyIsNeededHelpShade(WebDriver driver) {
        this.driver = driver;
        if (!isCurrent(driver)) {
            fail("The 'Why is this needed' help shade did not load correctly");
        }
    }

    //------------------------------------------------------------------------------------------------------------------
    public WebElement getCloseButton(){
        return driver.findElement(By.cssSelector(".modal-footer .btn"));
    }

    private boolean isCurrent(WebDriver driver){
        return ( driver.findElement(By.cssSelector(".modal-header")).getText().contains("Why do we need this info"));
    }
}