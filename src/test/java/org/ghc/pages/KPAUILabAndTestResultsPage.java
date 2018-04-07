package org.ghc.pages;

import org.ghc.utils.extensions.KPAUIEveryAuthenticatedPage;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.fail;

public class KPAUILabAndTestResultsPage extends KPAUIEveryAuthenticatedPage {

    public KPAUILabAndTestResultsPage(WebDriver driver) {
        super(driver);
        if (!isCurrent(driver, PAGETITLE_LABS_AND_TEST_RESULTS))
            fail("The Lab and Test Results Page did not load correctly");
    }

    //------------------------------------------------------------------------------------------------------------------

    private static final String PAGETITLE_LABS_AND_TEST_RESULTS = "Lab and Test Results";


}
