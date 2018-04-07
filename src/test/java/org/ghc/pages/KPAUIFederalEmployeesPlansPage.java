package org.ghc.pages;

import org.ghc.utils.extensions.KPAUIEveryUnAuthenticatedPage;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.fail;

public class KPAUIFederalEmployeesPlansPage extends KPAUIEveryUnAuthenticatedPage {

    public KPAUIFederalEmployeesPlansPage(WebDriver driver) {
        super(driver);
        if (!isCurrent(driver, pageTitleFederalEmployeesPlans))
            fail("The Federal Employees Plans Page did not load correctly");
    }

    //------------------------------------------------------------------------------------------------------------------

    private static final String pageTitleFederalEmployeesPlans = "Kaiser Permanente Plans for Federal Employees";


}