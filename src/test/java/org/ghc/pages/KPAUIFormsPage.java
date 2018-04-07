package org.ghc.pages;

import org.openqa.selenium.WebDriver;

import static org.testng.Assert.fail;

public class KPAUIFormsPage extends KPAUIUnAuthenticatedHomePage {

    public KPAUIFormsPage(WebDriver driver) {
        super(driver);
        if (!isCurrent(driver, PAGETITLE_FORMS))
            fail("The Forms Page did not load correctly");
    }

    //------------------------------------------------------------------------------------------------------------------

    private static final String PAGETITLE_FORMS = "Kaiser Permanente Washington Forms";

}