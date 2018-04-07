package org.ghc.pages;

import org.ghc.utils.extensions.KPAUIEveryAuthenticatedPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.testng.Assert.fail;
class KPAUICareChatPage extends KPAUIEveryAuthenticatedPage {

    KPAUICareChatPage(WebDriver driver) {
        super(driver);
        if (!isCurrent())
            fail("The Care Chat Page did not load correctly");
    }
    private boolean isCurrent() {
        return bodyAttribute.isDisplayed();
    }
    //------------------------------------------------------------------------------------------------------------------

    @FindBy(css = "[data-tenant*='kaiser']")       private WebElement bodyAttribute;
}
