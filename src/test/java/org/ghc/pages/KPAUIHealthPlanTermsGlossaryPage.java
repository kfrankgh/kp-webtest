package org.ghc.pages;

import org.ghc.utils.extensions.KPAUIEveryAuthenticatedPage;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.fail;

public class KPAUIHealthPlanTermsGlossaryPage extends KPAUIEveryAuthenticatedPage {

    public KPAUIHealthPlanTermsGlossaryPage(WebDriver driver) {
        super(driver);
        if (!isCurrent(driver, pageTitleHealthPlanTermsGlossary))
            fail("The Glossary of Health Plans Terms Page did not load correctly");
    }

    //------------------------------------------------------------------------------------------------------------------

    private static final String pageTitleHealthPlanTermsGlossary = "Glossary of Health Plan Terms";

}

