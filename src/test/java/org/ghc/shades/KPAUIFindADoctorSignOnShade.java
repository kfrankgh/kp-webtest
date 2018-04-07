package org.ghc.shades;

import org.ghc.pages.KPAUIFindADoctorDetailsPage;
import org.ghc.utils.KPAUICredentials;
import org.ghc.utils.extensions.KPAUIEveryShade;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.ghc.utils.helpers.KPAUITestHelper.*;
import static org.testng.Assert.fail;

public class KPAUIFindADoctorSignOnShade extends KPAUIEveryShade {

    public KPAUIFindADoctorSignOnShade(WebDriver driver){
        super(driver);
        if (!isCurrent())
            fail("Sign on Shade is not visible");
    }

    private boolean isCurrent(){
        return getLoginForm().isDisplayed();
    }

    //------------------------------------------------------------------------------------------------------------------

    // Finders
    @FindBy(xpath = "//*[@id='choose-physician']/div[2]/div/core-login/div/form")               private WebElement loginForm;
    @FindBy(xpath = "//*[@id='choose-physician']/button/span")                                  private WebElement closeFormX;
    @FindBy(xpath = "//*[@id='choose-physician']/div[2]/div/core-login/div/form/div[1]/input")  private WebElement memberIdField;
    @FindBy(xpath = "//*[@id='choose-physician']/div[2]/div/core-login/div/form/div[2]/input")  private WebElement passwordField;
    @FindBy(xpath = "//*[@id='choose-physician']/div[2]/div/core-login/div/form/div[3]/button") private WebElement btnSignInWithCredentials;

    // Getters
    private WebElement getLoginForm()                           { return waitForElementToBeClickable(loginForm, driver); }
    private WebElement getCloseFormX()                          { return waitForElementToBeClickable(closeFormX, driver); }
    private WebElement getMemberIdField()                       { return waitForElement(memberIdField, driver); }
    private WebElement getPasswordField()                       { return waitForElement(passwordField, driver); }
    private WebElement getBtnSignInWithCredentials()            { return waitForElementToBeClickable(btnSignInWithCredentials, driver); }

    // Methods
    /** Clicks on the X from the Sign on Shade to close the shade and return to the Details page
     * @return stays on the details page with closed sign on shade - KPAUIFindADoctorDetailsPage
     */
    public KPAUIFindADoctorDetailsPage closeFindADoctorSignOnShade() {
        sleep(5);
        getCloseFormX().click();
        return new KPAUIFindADoctorDetailsPage(driver);
    }

    /** Send keys to Member ID and Password Field then click on Sing in Button
     * @param accountName Member ID and Password
     * @return Authenticated Find a Doctor Details Page
     */
    public KPAUIFindADoctorDetailsPage signOnFromFindADoctorSignOnShade(KPAUICredentials.accountName accountName) {
        System.out.printf("Using Account:\t\t%s/%s\n", accountName.getID(), accountName.getPass());

        getMemberIdField().sendKeys(accountName.getID());
        getPasswordField().sendKeys(accountName.getPass());

        System.out.println("Logging In...");
        System.out.println("--------------------------------------------" );
        getBtnSignInWithCredentials().click();
        return new KPAUIFindADoctorDetailsPage(driver);
    }
}
