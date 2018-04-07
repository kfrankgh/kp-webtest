package org.ghc.pages;

import org.ghc.utils.extensions.KPAUIEveryUnAuthenticatedPage;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.fail;

public class KPAUIChooseOrChangeYourDoctorPage extends KPAUIEveryUnAuthenticatedPage {

    public KPAUIChooseOrChangeYourDoctorPage(WebDriver driver) {
        super(driver);
        if (!isCurrent(driver, pageTitleChooseOrChangeYourDoctor))
            fail("The Choose or Change Your Doctor Page did not load correctly");
    }

    //------------------------------------------------------------------------------------------------------------------

    private static final String pageTitleChooseOrChangeYourDoctor = "Choose or Change Your Doctor";

}
