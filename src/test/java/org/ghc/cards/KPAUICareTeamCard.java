package org.ghc.cards;

import org.ghc.pages.KPAUIFindADoctorLandingPage;
import org.ghc.pages.KPAUIMessageCenterPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.testng.Assert.fail;

public class KPAUICareTeamCard {
    private WebDriver driver;

    public KPAUICareTeamCard(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        if (!isCurrent())
            fail("Your Care Team card is not visible");
    }

    public boolean isCurrent() {
        return getCareTeamHeader().isDisplayed();
    }

    //------------------------------------------------------------------------------------------------------------------

    // Constants
    private static final String header =                                "Care Team";
    private static final String cardPrefix1 =                           "//kp-your-care-team/core-card/div/div[1]/div";
    private static final String cardPrefix2 =                           "//kp-your-care-team/core-card/div/div[2]/div";
    private static final String findADoctor =                           "FIND A DOCTOR";
    private static final String noCareTeam =                            ".*choose a Kaiser Permanente primary care provider.*";
    private static final String contactCareTeam =                       "CONTACT CARE TEAM";
    private static final String switchProviders =                       "SWITCH PROVIDERS";

    // Finders
    @FindBy(xpath = cardPrefix1 + "/h4")                                private WebElement careTeamHeader;
    @FindBy(xpath = cardPrefix2 + "/div/div[1]/div[3]/core-link/a")     private WebElement clinicianLocation;
    @FindBy(xpath = cardPrefix2 + "/div/div[1]/div[1]")                 private WebElement clinicianNameTitle;
    @FindBy(xpath = cardPrefix2 + "/div/div[1]/div[4]")                 private WebElement clinicianPhoneNumber;
    @FindBy(xpath = cardPrefix2 + "/div/div[2]/core-link[2]/a/img")     private WebElement contactCareTeamIcon;
    @FindBy(xpath = cardPrefix2 + "/div/div[2]/core-link[2]/a")         private WebElement contactCareTeamLink;
    @FindBy(xpath = cardPrefix2 + "/div/div[2]/core-link/a/img")        private WebElement findADoctorIcon;
    @FindBy(xpath = cardPrefix2 + "/div/div[2]/core-link/a")            private WebElement findADoctorLink;
    @FindBy(xpath = cardPrefix2 + "/div/div[1]/div[3]/core-link/a/img") private WebElement mapPin;
    @FindBy(xpath = cardPrefix2 + "/div/div[2]/core-link/a")            private WebElement noCareTeamFADLink;
    @FindBy(xpath = cardPrefix2 + "/div/div[1]")                        private WebElement noCareTeamMessage;
    @FindBy(xpath = cardPrefix2 + "/div/div[2]/core-link[1]/a/img")     private WebElement switchProvidersButtonIcon;
    @FindBy(xpath = cardPrefix2 + "/div/div[2]/core-link[1]/a")         private WebElement switchProvidersButtonLink;

    // Getters
    private WebElement getCareTeamHeader()                              { return careTeamHeader; }
    public WebElement getClinicianLocation()                            { return clinicianLocation; }
    public WebElement getClinicianNameTitle()                           { return clinicianNameTitle; }
    public WebElement getClinicianPhoneNumber()                         { return clinicianPhoneNumber; }
    private WebElement getContactCareTeamIcon()                         { return contactCareTeamIcon; }
    private WebElement getContactCareTeamLink()                         { return contactCareTeamLink; }
    private WebElement getFindADoctorIcon()                             { return findADoctorIcon; }
    private WebElement getFindADoctorLink()                             { return findADoctorLink; }
    public WebElement getMapPin()                                       { return mapPin; }
    private WebElement getNoCareTeamMessage()                           { return noCareTeamMessage; }
    private WebElement getSwitchProvidersButtonIcon()                   { return switchProvidersButtonIcon; }
    private WebElement getSwitchProvidersButtonLink()                   { return switchProvidersButtonLink; }

    // Methods
    /** Opens the Message Center page from the "Contact Care Team" Link
     * @return - The Message Center Page (KPAUIMessageCenterPage)
     */
    public KPAUIMessageCenterPage openContactCareTeam() {
        getContactCareTeamLink().click();
        return new KPAUIMessageCenterPage(driver);
    }

    /** Opens the Find A Doctor page from the "Find A Doctor" Link
     * @return - The Find A Doctor Page (KPAUIFindADoctorLandingPage)
     */
    public KPAUIFindADoctorLandingPage openFindADoctorPage() {
        getFindADoctorLink().click();
        return new KPAUIFindADoctorLandingPage(driver);
    }

    /** Opens the Find A Doctor page from the "Switch Providers" Link
     * @return - The Schedule Appointments Page (KPAUIScheduleAppointmentPage)
     */
    public KPAUIFindADoctorLandingPage openSwitchProvidersPage(){
        getSwitchProvidersButtonLink().click();
        return new KPAUIFindADoctorLandingPage(driver);
    }

    /** Checks that the Care Team Header says "Care Team"
     * @return - True if Header Matches
     */
    public boolean verifyCareTeamHeader() {
        return getCareTeamHeader().getText().matches(header);
    }

    /** Verifies that the "Contact Care Team" Link/Text are displayed
     * @return - True if both conditions are met
     */
    public boolean verifyContactCareTeamLinkAndIcon() {
        return getContactCareTeamIcon().isDisplayed() &&
                getContactCareTeamLink().getText().equals(contactCareTeam);
    }

    /** Verifies that the "Find A Doctor" Link/Text are displayed
     * @return - True if both conditions are met
     */
    public boolean verifyFindADoctorLinkAndIcon() {
        return getFindADoctorIcon().isDisplayed() &&
                getFindADoctorLink().getText().equals(findADoctor);
    }

    /** Verifies that the "No Care Team Message" text matches the expected
     * @return - True if the message texts are equal
     */
    public boolean verifyNoCareTeamMessage() {
        return getNoCareTeamMessage().getText().matches(noCareTeam);
    }

    /** Verifies that the "SWITCH PROVIDERS" Link/Text are displayed
     * @return - True if both conditions are met
     */
    public boolean verifySwitchProvidersLinkAndIcon() {
        return getSwitchProvidersButtonIcon().isDisplayed() &&
                getSwitchProvidersButtonLink().getText().equals(switchProviders);
    }
}