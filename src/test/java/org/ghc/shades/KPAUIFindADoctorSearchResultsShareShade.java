package org.ghc.shades;

import org.ghc.utils.extensions.KPAUIEveryShade;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.ghc.utils.helpers.KPAUITestHelper.*;
import static org.testng.Assert.fail;

public class KPAUIFindADoctorSearchResultsShareShade extends KPAUIEveryShade {

    public KPAUIFindADoctorSearchResultsShareShade(WebDriver driver) {
        super(driver);
        if (!isCurrent())
            fail("Find a Doctor Results Page - Share Results shade is not visible");
    }

    private Boolean isCurrent() {
        return getShareThisPageHeader().isDisplayed();
    }

    //------------------------------------------------------------------------------------------------------------------

    // Finders
    @FindBy(xpath = "//email-dialog/div[3]/button[1]")          private WebElement cancelButton;
    @FindBy(id =    "//email")                                  private WebElement emailForm;
    @FindBy(xpath = "//email-dialog/div[2]/form/div[1]/label")  private WebElement emailFormLabel;
    @FindBy(xpath = "//email-dialog/div[3]/button[2]")          private WebElement sendButton;
    @FindBy(xpath = "//email-dialog/div[1]/div")                private WebElement shareThisPageHeader;

    // Getters
    public  WebElement   getCancelButton()                 { return waitForElementToBeClickable(cancelButton, driver); }
    public  WebElement   getEmailForm()                    { return waitForElement(emailForm, driver); }
    public  WebElement   getEmailFormLabel()               { return waitForElement(emailFormLabel, driver); }
    public  WebElement   getSendButton()                   { return waitForElementToBeClickable(sendButton, driver); }
    private WebElement   getShareThisPageHeader()          { return waitForElement(shareThisPageHeader, driver); }

    // Methods
}