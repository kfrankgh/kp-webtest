package org.ghc.pages;

import org.ghc.utils.extensions.KPAUIEveryAuthenticatedPage;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.fail;

public class KPAUIDrugFormularyPage extends KPAUIEveryAuthenticatedPage {

    public KPAUIDrugFormularyPage(WebDriver driver) {
        super(driver);
        if (!isCurrent(driver, PAGETITLE_DRUG_FORMULARY))
            fail("The Drug Formulary Page did not load correctly");
    }

    //------------------------------------------------------------------------------------------------------------------

    private static final String PAGETITLE_DRUG_FORMULARY = "Drug Formulary";


}
