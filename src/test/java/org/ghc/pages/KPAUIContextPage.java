package org.ghc.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static org.ghc.utils.helpers.KPAUITestHelper.sleep;

public class KPAUIContextPage {
    WebDriver inContext;

    public KPAUIContextPage(WebDriver inContext) {
        sleep(2);
        this.inContext = inContext;
    }
    //------------------------------------------------------------------------------------------------------------------

    private void getDeReActivateAccountButton(){
        inContext.findElement(By.xpath("//*[@id=\"container\"]/form/input[6]")).click();
    }

    private void confirmYesButtonClick() {
        inContext.findElement(By.xpath("//*[@id=\"confirmContent\"]/form/input[3]")).click();
    }

    private boolean activateDeReAccountImageDisplayed() {
        return inContext.findElements(By.xpath("//*[@id=\"container\"]/form/img")).size() > 0;
    }

    public KPAUIContextPage lookupGroupMemberByID(String ID){
        inContext.findElement(By.cssSelector("input[name=userId]")).sendKeys(ID);
        inContext.findElement(By.cssSelector("input[name=Go]")).click();
        return new KPAUIContextPage(inContext);
    }

    public KPAUIContextPage deactivateAccount() {
        inContext.findElement(By.xpath("//*[@id=\"leftnavbar\"]/p[7]/a")).click();
        if (activateDeReAccountImageDisplayed()) {
            getDeReActivateAccountButton();
            confirmYesButtonClick();
        }
        return new KPAUIContextPage(inContext);
    }

    public KPAUIContextPage reactivateAccount() {
        inContext.findElement(By.xpath("//*[@id=\"leftnavbar\"]/p[8]/a")).click();
        if (activateDeReAccountImageDisplayed()) {
            getDeReActivateAccountButton();
            confirmYesButtonClick();
        }
        return new KPAUIContextPage(inContext);
    }

    public void quitInContext() {
        inContext.quit();
    }
}
