package org.ghc.pages;

import org.ghc.utils.extensions.KPAUIEveryUnAuthenticatedPage;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.fail;

public class KPAUIStateEmployeesPage extends KPAUIEveryUnAuthenticatedPage {

    public KPAUIStateEmployeesPage(WebDriver driver) {
        super(driver);
        if (!isCurrent(driver, pageTitleStateEmployees))
            fail("The State Employees Page did not load correctly");
    }

    //------------------------------------------------------------------------------------------------------------------

    private static final String pageTitleStateEmployees = "PEBB State Employees";

}