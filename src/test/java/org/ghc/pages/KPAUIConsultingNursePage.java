package org.ghc.pages;

import org.ghc.utils.extensions.KPAUIEveryAuthenticatedPage;
import org.openqa.selenium.WebDriver;

import static org.ghc.utils.KPAIUTestConstants.links.findADoctorLandingPage;
import static org.ghc.utils.helpers.KPAUIStringHelper.getSiteWithPrefix;
import static org.testng.Assert.fail;

public class KPAUIConsultingNursePage extends KPAUIEveryAuthenticatedPage {

    public KPAUIConsultingNursePage(WebDriver driver) {
        super(driver);
        if (!isCurrent(driver, PAGETITLE_CONSULTING_NURSE))
            fail("The Consulting Nurse Page did not load correctly");
    }

    //------------------------------------------------------------------------------------------------------------------


    private static final String PAGETITLE_CONSULTING_NURSE = "Consulting Nurse Service";
}
