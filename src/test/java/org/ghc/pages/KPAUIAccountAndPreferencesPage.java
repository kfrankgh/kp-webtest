package org.ghc.pages;

import org.ghc.utils.extensions.KPAUIEveryAuthenticatedPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.ghc.utils.helpers.KPAUITestHelper.*;
import static org.testng.Assert.fail;

public class KPAUIAccountAndPreferencesPage extends KPAUIEveryAuthenticatedPage {

    public KPAUIAccountAndPreferencesPage(WebDriver driver) {
        super(driver);
        if (!isCurrent(driver, PAGETITLE_ACCOUNT_AND_PREFERENCES))
            fail("The Account and Preferences Page did not load correctly");
    }

    //------------------------------------------------------------------------------------------------------------------
    private static final String PAGETITLE_ACCOUNT_AND_PREFERENCES = "Account & Preferences";


    // Finders
    @FindBy(id =        "lastupdated")                          private WebElement lastUpdatedOnField;
    @FindBy(id =        "mailAddress")                          private WebElement mailingAddressField;
    @FindBy(id =        "memberId")                             private WebElement memberId;
    @FindBy(id =        "name")                                 private WebElement nameField;
    @FindBy(id =        "phone")                                private WebElement primaryPhoneField;
    @FindBy(id =        "resAddress")                           private WebElement residentialAddressField;
    @FindBy(linkText =  "follow these steps.")                  private WebElement followTheseStepsLink;
    @FindBy(linkText =  "Kaiser Permanente Member Services")    private WebElement kpMemberServicesLink;
    @FindBy(linkText =  "privacy policy.")                      private WebElement privacyPolicyLink;
    @FindBy(linkText =  "Washington Healthplanfinder")          private WebElement waHealthPlanFinderLink;
    @FindBy(id = "otherPhone")                                  private WebElement otherPhoneField;

    // Getters
    public  WebElement  getLastUpdatedOnField()         { return waitForElement(lastUpdatedOnField, driver); }
    public  WebElement  getMailingAddressField()        { return waitForElement(mailingAddressField, driver); }
    private WebElement  getMemberId()                   { return waitForElement(memberId, driver); }
    public  String      getMemberIdString()             { return getMemberId().getText(); }
    public  WebElement  getNameField()                  { return waitForElement(nameField, driver); }
    public  WebElement getOtherPhoneField()             { return waitForElement(otherPhoneField, driver);}
    public  WebElement  getPrimaryPhoneField()          { return waitForElement(primaryPhoneField, driver); }
    public  WebElement  getResidentialAddressField()    { return waitForElement(residentialAddressField, driver); }
    private WebElement  getFollowTheseStepsLink()       { return waitForElementToBeClickable(followTheseStepsLink, driver); }
    private WebElement  getKpMemberServicesLink()       { return waitForElementToBeClickable(kpMemberServicesLink, driver); }
    private WebElement  getPrivacyPolicyLink()          { return waitForElementToBeClickable(privacyPolicyLink, driver); }
    private WebElement  getWaHealthPlanFinderLink()     { return waitForElementToBeClickable(waHealthPlanFinderLink, driver); }


    // Methods
    /** Click on the follow these steps link to open the change your status page
     * @return a new change your status page - KPAUIChangeYourStatusPage
     */
    public KPAUIChangeYourStatusPage openFollowTheseStepsLink(){
        getFollowTheseStepsLink().click();
        return new KPAUIChangeYourStatusPage(getChildDriver(driver));
    }

    /** Click on the Member Services link to open the member services page
     * @return a member services page - KPAUIMemberServicesPage
     */
    public KPAUIMemberServicesPage openMemberServicesLink() {
        getKpMemberServicesLink().click();
        return new KPAUIMemberServicesPage(driver);
    }

    /** Click on the Privacy Policy link to open the privacy policy page
     * @return a privacy policy page - KPAUIPrivacyPolicyPage
     */
    public KPAUIPrivacyPolicyPage openPrivacyPolicyLink(){
        getPrivacyPolicyLink().click();
        return new KPAUIPrivacyPolicyPage(driver);
    }

    /** click on the WA HealthPlan Finder link to open the wa health plan finder page
     * @return a WA HealthPlan Finder page - KPAUIWaHealthPlanFinderPage
     */
    public KPAUIWaHealthPlanFinderPage openWaHealthPlanFinderLink(){
        getWaHealthPlanFinderLink().click();
        return new KPAUIWaHealthPlanFinderPage(driver);
    }
}
