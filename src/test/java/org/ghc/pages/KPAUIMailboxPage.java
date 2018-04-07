package org.ghc.pages;

import org.ghc.utils.extensions.KPAUIEveryAuthenticatedPage;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.fail;


public class KPAUIMailboxPage extends KPAUIEveryAuthenticatedPage{

    public KPAUIMailboxPage(WebDriver driver) {
        super(driver);
        if (!isCurrent(driver, PAGETITLE_MAILBOX))
            fail("The Mailbox Page did not load correctly");
    }

    //------------------------------------------------------------------------------------------------------------------

    private static final String PAGETITLE_MAILBOX = "Message Center";

}
