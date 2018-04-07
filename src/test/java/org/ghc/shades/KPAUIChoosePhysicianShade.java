package org.ghc.shades;

import org.ghc.utils.extensions.KPAUIEveryShade;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.ghc.utils.helpers.KPAUITestHelper.waitForElement;
import static org.testng.Assert.fail;

public class KPAUIChoosePhysicianShade extends KPAUIEveryShade {

    public KPAUIChoosePhysicianShade(WebDriver driver) {
        super(driver);
        if (!isCurrent())
            fail("Choose Physician shade is not visible");
    }

    private boolean isCurrent() {
        return getClinicianImageDiv().isDisplayed();
    }
    //------------------------------------------------------------------------------------------------------------------


    // Finders
    @FindBy(xpath = "//*[@id='choose-physician']/div[2]/div/div/div[2]")        private WebElement clinicianDetailDiv;
    @FindBy(xpath = "//*[@id='choose-physician']/div[2]/div/div/div[1]/div")    private WebElement clinicianImageDiv;

    // Getters
    private WebElement getClinicianDetailDiv()          { return waitForElement(clinicianDetailDiv, driver); }
    private WebElement getClinicianImageDiv()           { return waitForElement(clinicianImageDiv, driver); }
}
