package org.ghc.utils.extensions;

import org.ghc.pages.KPAUIFindADoctorLandingPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.ghc.utils.helpers.KPAUITestHelper.sleep;
import static org.ghc.utils.helpers.KPAUITestHelper.waitForElement;
import static org.ghc.utils.helpers.KPAUITestHelper.waitForElementToBeClickable;

public class KPAUIFindADoctorEveryPage extends KPAUIEveryUnAuthenticatedPage {

    public KPAUIFindADoctorEveryPage(WebDriver driver) {
        super(driver);
    }

    //------------------------------------------------------------------------------------------------------------------

    //Finders
    @FindBy(xpath = "//form/div[1]/div[1]/div[1]/button")       private WebElement fadSearchButton;
    @FindBy(id =    "queryText")                                private WebElement fadSearchField;
    @FindBy(css =   "#location-input > input")                  private WebElement zipCodeField;

    // Getters
    protected WebElement getFadSearchButton()               { return waitForElementToBeClickable(fadSearchButton, driver); }
    public    WebElement getFadSearchField()                { return waitForElementToBeClickable(fadSearchField, driver); }
    public    WebElement getZipCodeField()                  { return waitForElement(zipCodeField, driver); }

    //Methods
     /** Get the Zip Code Field and clear
     * @return new FaD page with cleared zip code field - KPAUIFindADoctorEveryPage
     */
    public KPAUIFindADoctorLandingPage clearZipCodeField() {
        sleep(2);
        getZipCodeField().clear();
        return new KPAUIFindADoctorLandingPage(driver);
    }
}
