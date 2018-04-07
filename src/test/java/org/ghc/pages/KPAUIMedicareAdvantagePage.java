package org.ghc.pages;

import org.ghc.utils.extensions.KPAUIEveryUnAuthenticatedPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class KPAUIMedicareAdvantagePage extends KPAUIEveryUnAuthenticatedPage {

    public KPAUIMedicareAdvantagePage(WebDriver driver) {
        super(driver);
        if (!isCurrent(driver, pageTitleMedicareAdvantage))
            Assert.fail("The Medicare Advantage Page did not load correctly");
    }

    //------------------------------------------------------------------------------------------------------------------

    private static final String pageTitleMedicareAdvantage = "Washington Medicare Advantage Plans";

}
