package org.ghc.pages;

import org.ghc.utils.extensions.KPAUIEveryAuthenticatedPage;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.fail;

public class KPAUILettersAndVisionPrescriptionPage extends KPAUIEveryAuthenticatedPage {

    public KPAUILettersAndVisionPrescriptionPage(WebDriver driver) {
        super(driver);
        if (!isCurrent(driver, PAGETITLE_LETTERS_AND_VISION_PRESCRIPTIONS))
            fail("The Letters and Vision Prescriptions Page did not load correctly");
    }

    //------------------------------------------------------------------------------------------------------------------

    private static final String PAGETITLE_LETTERS_AND_VISION_PRESCRIPTIONS = "Letters & Vision Prescriptions";

}
