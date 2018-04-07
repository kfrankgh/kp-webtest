package org.ghc.pages;

import org.ghc.utils.extensions.KPAUIEveryUnAuthenticatedPage;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.fail;

public class KPAUIPregnancyPage extends KPAUIEveryUnAuthenticatedPage {

    public KPAUIPregnancyPage(WebDriver driver) {
        super(driver);
        if (!isCurrent(driver, pageTitlePregnancyServices))
            fail("The Pregnancy Page did not load correctly");
    }

    //------------------------------------------------------------------------------------------------------------------

    private static final String pageTitlePregnancyServices = "Pregnancy Services";

}
