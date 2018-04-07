package org.ghc.pages;

import org.ghc.utils.extensions.KPAUIEveryUnAuthenticatedPage;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.fail;

public class KPAUIHealthInsuranceForEmployersPage extends KPAUIEveryUnAuthenticatedPage {

    public KPAUIHealthInsuranceForEmployersPage(WebDriver driver) {
        super(driver);
        if (!isCurrent(driver, pageTitleHealthInsuranceForEmployers))
            fail("The Health Insurance for Employers Page did not load correctly");
    }

    //------------------------------------------------------------------------------------------------------------------

    private static final String pageTitleHealthInsuranceForEmployers = "Washington Health Insurance for Employers";

}