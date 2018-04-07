package org.ghc.pages;

import org.ghc.utils.KPAUICredentials.accountName;
import org.ghc.utils.extensions.KPAUIEveryAuthenticatedPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.testng.Assert.fail;

public class KPAUISiteMinderLoginPage extends KPAUIEveryAuthenticatedPage {

    public KPAUISiteMinderLoginPage(WebDriver driver) {
        super(driver);
        if (!isCurrent(driver, "member website Sign on Page"))
            fail("The SiteMinder loginmember.fcc Page did not load correctly");
    }

    //------------------------------------------------------------------------------------------------------------------
    private KPAUIAuthenticatedHomePage clickSignOnBtn(){
        getSignOnButton().click();
        return new KPAUIAuthenticatedHomePage(driver);
    }

    private void enterPassword(String pwd){
        getPasswordField().sendKeys(pwd);
    }

    private void enterUserId(String id){
        getIdField().sendKeys(id);
    }

    private WebElement getIdField(){
        return driver.findElement(By.cssSelector(".loginBox #userId"));
    }

    private WebElement getPasswordField(){
        return driver.findElement(By.cssSelector(".loginBox #passwordBox"));
    }

    private WebElement getSignOnButton(){
        return driver.findElement(By.cssSelector("#submitButton"));
    }

    public KPAUIAuthenticatedHomePage signIn(accountName accountName){
        enterUserId(accountName.getID());
        enterPassword(accountName.getPass());
        return clickSignOnBtn();
    }
}