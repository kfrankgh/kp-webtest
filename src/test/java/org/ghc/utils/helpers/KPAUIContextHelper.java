package org.ghc.utils.helpers;

import org.ghc.pages.KPAUIContextPage;
import org.ghc.utils.KPAUICredentials.KPAUIAccount;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;

import static org.ghc.utils.KPAIUTestConstants.credentials.inContextSite.*;
import static org.ghc.utils.KPAIUTestConstants.links.inContextSite;
import static org.ghc.utils.extensions.KPAUIEveryTest.ENV;
import static org.ghc.utils.helpers.KPAUIStringHelper.getSiteWithPrefix;
import static org.testng.Assert.fail;

public class KPAUIContextHelper {
    private KPAUIContextPage login() {
        WebDriver inContext = null;

        try {
            inContext = new ChromeDriver();
        } catch (Exception e) {
            fail("The WebDriver could not be initialized.");
            e.printStackTrace();
        }

        inContext.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        inContext.manage().window().maximize();
        String site = getSiteWithPrefix(inContextSite);

        if(ENV.equals("QA")){
            site += "?TYPE=33554433&REALMOID=06-0003f4b3-4fec-1088-84be-8300d5b00000&GUID=&SMAUTHREASON=0&METHOD=GET&SMAGENTNAME=agt-incontext-1&TARGET=-SM-https%3a%2f%2fincontext--qa.ghc.org%2fsecure%2fadmin%2fmember%2findex.jhtml";
        }

        inContext.get(site);

        new WebDriverWait(inContext, 10)
                .until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[name=USER]")))
                .sendKeys(inContextLogin);

        inContext.findElement(By.cssSelector("input[name=PASSWORD]")).sendKeys(inContextPass);
        inContext.findElement(By.cssSelector("input[name=submitButton]")).click();

        return new KPAUIContextPage(inContext);
    }

    public void loginDeactivateQuit(KPAUIAccount account) {
        login().lookupGroupMemberByID(account.getID())
            .deactivateAccount()
            .quitInContext();
    }

    public void loginDeactivateReactivateQuit(KPAUIAccount account) {
        login().lookupGroupMemberByID(account.getID())
            .deactivateAccount()
            .reactivateAccount()
            .quitInContext();
    }
}
