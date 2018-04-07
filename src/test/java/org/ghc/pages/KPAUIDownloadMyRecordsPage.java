package org.ghc.pages;

import org.ghc.utils.extensions.KPAUIEveryAuthenticatedPage;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.fail;

public class KPAUIDownloadMyRecordsPage extends KPAUIEveryAuthenticatedPage {

    public KPAUIDownloadMyRecordsPage(WebDriver driver) {
        super(driver);
        if (!isCurrent(driver, PAGETITLE_DOWNLOAD_MY_RECORD))
            fail("The Download My Records Page did not load correctly");
    }

    //------------------------------------------------------------------------------------------------------------------

    private static final String PAGETITLE_DOWNLOAD_MY_RECORD = "Visit Records";


}
