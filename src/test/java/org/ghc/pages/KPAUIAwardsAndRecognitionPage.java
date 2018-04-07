package org.ghc.pages;

import org.ghc.utils.extensions.KPAUIEveryAuthenticatedPage;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.fail;

public class KPAUIAwardsAndRecognitionPage extends KPAUIEveryAuthenticatedPage {

    public KPAUIAwardsAndRecognitionPage(WebDriver driver) {
        super(driver);
        if (!isCurrent(driver, PAGETITLE_AWARDS_AND_RECOGNITION))
            fail("The Awards & Recognition Page did not load correctly");
    }

    //------------------------------------------------------------------------------------------------------------------

    private static final String PAGETITLE_AWARDS_AND_RECOGNITION = "Awards and Recognition";

}