package org.ghc.pages;

import org.ghc.utils.extensions.KPAUIEveryAuthenticatedPage;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.fail;

public class KPAUIKPWAHealthResearchInstitutePage extends KPAUIEveryAuthenticatedPage {

    public KPAUIKPWAHealthResearchInstitutePage(WebDriver driver) {
        super(driver);
        if (!isCurrent(driver, PAGETITLE_KPWA_HEALTH_RESEARCH_INSTITUTE))
            fail("The Kaiser Permanente Washington Health Research Institute Page did not load correctly");
    }

    //------------------------------------------------------------------------------------------------------------------

    private static final String PAGETITLE_KPWA_HEALTH_RESEARCH_INSTITUTE = "GHRI is now Kaiser Permanente Washington Health Research Institute | KPWHRI";


}