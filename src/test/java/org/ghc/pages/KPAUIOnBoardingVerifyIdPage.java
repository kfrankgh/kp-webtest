package org.ghc.pages;

import org.ghc.utils.extensions.KPAUIEveryOnBoardingPage;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static org.ghc.utils.helpers.KPAUITestHelper.ifAlertThenCloseAlert;
import static org.ghc.utils.helpers.KPAUITestHelper.waitForElementToBeClickable;
import static org.testng.Assert.fail;

public class KPAUIOnBoardingVerifyIdPage extends KPAUIEveryOnBoardingPage {
    KPAUIOnBoardingVerifyIdPage(WebDriver driver) {
        super(driver);
        if (!isCurrent())
            fail("The Member Registration - Verify Identity page did not load correctly");
    }

    //------------------------------------------------------------------------------------------------------------------
    // Finders
    @FindBy(css = ".form-check:first-child .form-check-input")              private WebElement emailCheckBox;
    @FindBy(css = ".form-check:nth-child(2) .form-check-input")             private WebElement inPersonCheckBox;
    @FindBy(css = "[href*='tel:']")                                         private WebElement phoneNumLink;
    @FindBy(css = ".form-check:nth-child(2) .form-check-input")             private List<WebElement> inputCheckForm;

    // Getters
    private WebElement getEmailCheckBox()                               { return waitForElementToBeClickable(emailCheckBox, driver); }
    private WebElement getInPersonCheckBox()                            { return waitForElementToBeClickable(inPersonCheckBox, driver); }
    public  WebElement getPhoneNumLink()                                { return waitForElementToBeClickable(phoneNumLink, driver); }
    private List<WebElement> getInputCheckForm()                        { return inputCheckForm; }

    // Methods
    /** Get a list of input check form elements and evaluate that there are more than 0
     * @return tru if list size is > 0 - boolean
     */
    private Boolean isCurrent(){
        return ( getInputCheckForm().size() > 0 );
    }

    /** clicks on the Email Checkbox to mark it as selected
     * @return modified KPAIUOnBoardingPage - KPAUIOnBoardingVerifyIdPage
     */
    private KPAUIOnBoardingVerifyIdPage clickEmailCheckbox(){
        long start = System.currentTimeMillis();
        do {
            try {
                getEmailCheckBox().click();
            }catch(StaleElementReferenceException e) {
                System.out.println("info: StaleElementReferenceException thrown when clicking Email Checkbox");
            }
        }while ( !getEmailCheckBox().isSelected() && ( System.currentTimeMillis() - start ) < 5000 );
        return new KPAUIOnBoardingVerifyIdPage(driver);
    }

    /** clicks on the In-Person Checkbox to mark it as selected
     * @return modified KPAIUOnBoardingPage - KPAUIOnBoardingVerifyIdPage
     */
    private KPAUIOnBoardingVerifyIdPage clickInPersonCheckbox(){
        long start = System.currentTimeMillis();
        do {
            try {
                getInPersonCheckBox().click();
            }catch(StaleElementReferenceException e) {
                System.out.println("info: StaleElementReferenceException thrown when clicking inPersonCheckbox");
            }
        }while ( !getInPersonCheckBox().isSelected() && ( System.currentTimeMillis() - start ) < 5000 );
        return new KPAUIOnBoardingVerifyIdPage(driver);
    }

    /** Click on the Cancel Button to Exit the Registration Flow
     * @return KPAUIAuthenticatedHome
     */
    public KPAUIUnAuthenticatedHomePage clickCancelButton() {
        getCancelButton().click();
        ifAlertThenCloseAlert();
        return new KPAUIUnAuthenticatedHomePage(driver);
    }

    /** Clicks on the In Person Checkbox then the Next button in order to complete the Registration Flow
     * @return KPAUIOnBoardingThankYouPage
     */
    public KPAUIOnBoardingThankYouPage selectInPersonAndSubmit() {
        clickInPersonCheckbox().getNextButton().click();
        return new KPAUIOnBoardingThankYouPage(driver);
    }

    /** Clicks on the Email Option Checkbox then the Next Button in order to complete the Registration Flow
     * @return KPAUIOnBoardingThankYouPage
     */
    public KPAUIOnBoardingThankYouPage selectEmailOptionAndSubmit() {
        clickEmailCheckbox().getNextButton().click();
        return new KPAUIOnBoardingThankYouPage(driver);
    }
}
