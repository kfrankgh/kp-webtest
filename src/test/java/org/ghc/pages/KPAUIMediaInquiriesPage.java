package org.ghc.pages;

import org.ghc.utils.extensions.KPAUIEveryAuthenticatedPage;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.fail;

public class KPAUIMediaInquiriesPage extends KPAUIEveryAuthenticatedPage {

    public KPAUIMediaInquiriesPage(WebDriver driver) {
        super(driver);
        if (!isCurrent(driver, PAGETITLE_MEDIA_INQUIRIES))
            fail("The Media Inquiries Page did not load correctly");
    }

    //------------------------------------------------------------------------------------------------------------------

    private static final String PAGETITLE_MEDIA_INQUIRIES = "Media Contacts";

}