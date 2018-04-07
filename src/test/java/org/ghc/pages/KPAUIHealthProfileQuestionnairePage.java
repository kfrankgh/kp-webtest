package org.ghc.pages;

import org.ghc.utils.extensions.KPAUIEveryAuthenticatedPage;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.fail;

public class KPAUIHealthProfileQuestionnairePage extends KPAUIEveryAuthenticatedPage {

    public KPAUIHealthProfileQuestionnairePage(WebDriver driver) {
        super(driver);
        if (!isCurrent(driver, PAGETITLE_HEALTH_PROFILE_QUESTIONNAIRE))
            fail("The Health Profile Questionnaire page did not load correctly");
    }

    //------------------------------------------------------------------------------------------------------------------

    private static final String PAGETITLE_HEALTH_PROFILE_QUESTIONNAIRE = "Health Profile";

}