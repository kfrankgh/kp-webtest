package org.ghc.pages;

import org.ghc.utils.extensions.KPAUIEveryUnAuthenticatedPage;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.fail;

public class KPAUISignOnFccPage extends KPAUIEveryUnAuthenticatedPage {

    public KPAUISignOnFccPage(WebDriver driver) {
        super(driver);
        if (!isCurrent(driver, PAGETITLE_LOGIN_FCC))
            fail("The LogIn FCC Page did not load correctly");
    }

    //------------------------------------------------------------------------------------------------------------------

    private static final String PAGETITLE_LOGIN_FCC = "Sign on Page";

}