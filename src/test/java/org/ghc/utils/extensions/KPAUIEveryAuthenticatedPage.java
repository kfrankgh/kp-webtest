package org.ghc.utils.extensions;

import org.ghc.pages.KPAUIAuthenticatedHomePage;
import org.ghc.pages.KPAUIGoodbyePage;
import org.ghc.shades.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.ghc.utils.KPAUIPageConstants.ExpectedLinksAndHeaders.EveryAuthenticatedPageHeader.btnSignOut;
import static org.ghc.utils.helpers.KPAUITestHelper.waitForElementToBeClickable;

public class KPAUIEveryAuthenticatedPage extends KPAUIEveryPage {

    public KPAUIEveryAuthenticatedPage(WebDriver driver) {
        super(driver);
    }

    //------------------------------------------------------------------------------------------------------------------
    public static final String LINKTEXT_APPOINTMENTS =          "Appointments";
    public static final String LINKTEXT_COVERAGE_AND_COSTS =    "Coverage & Costs";
    public static final String LINKTEXT_GET_CARE =              "Get Care";
    public static final String LINKTEXT_MEDICATIONS =           "Medications";
    public static final String LINKTEXT_MESSAGES =              "Message Center";
    public static final String LINKTEXT_MEDICAL_RECORD =        "Medical Record";

    //Finders
    @FindBy(css = "a[name=\\/appointments]")                    private WebElement appointmentsShadeIcon;
    @FindBy(css = "a[name=\\/bills-and-coverage]")              private WebElement coverageCostsShadeIcon;
    @FindBy(css = "a[name=\\/records-and-results]")             private WebElement medicalRecordsShadeIcon;
    @FindBy(css = "a[name=\\/get-care]")                        private WebElement getCareShadeIcon;
    @FindBy(xpath = "//core-header/div[1]/div/div[1]/a/img")    private WebElement homeIcon;
    @FindBy(xpath = "//*[@id=\"logo\"]")                        private WebElement homeIconFromMyChart;
    @FindBy(css = "a[name=\\/medications]")                     private WebElement medicationsShadeIcon;
    @FindBy(css = "a[name=\\/messages]")                        private WebElement messagesShadeIcon;

    // Getters
    public WebElement   getAppointmentsShadeIcon()              { return waitForElementToBeClickable(appointmentsShadeIcon, driver); }
    public WebElement   getCoverageCostsShadeIcon()             { return waitForElementToBeClickable(coverageCostsShadeIcon, driver); }
    public WebElement   getGetCareShadeIcon()                   { return waitForElementToBeClickable(getCareShadeIcon, driver); }
    private WebElement  getHomeIcon()                           { return waitForElementToBeClickable(homeIcon, driver); }
    private WebElement  getHomeIconFromMyChart()                { return waitForElementToBeClickable(homeIconFromMyChart, driver); }
    public WebElement   getMedicalRecordShadeIcon()             { return waitForElementToBeClickable(medicalRecordsShadeIcon, driver); }
    public WebElement   getMedicationsShadeIcon()               { return waitForElementToBeClickable(medicationsShadeIcon, driver); }
    public WebElement   getMessagesShadeIcon()                  { return waitForElementToBeClickable(messagesShadeIcon, driver); }

    // Methods

    /**
     * @return SignOut button
     */
    public WebElement getBtnSignOut() {
        return driver.findElement(By.xpath(btnSignOut));
    }

    /** Click on the Appointments icon to open the Appointments shade
     * @return Top Nav - KPAUIAppointmentsShade
     */
    public KPAUIAppointmentsShade openAppointmentsShade() {
        getAppointmentsShadeIcon().click();
        return new KPAUIAppointmentsShade(driver);
    }

    /** Click on the Get Care icon to open the Get Care shade
     * @return Top Nav - KPAUIGetCareShade
     */
    public KPAUIGetCareShade openGetCareShade() {
        getGetCareShadeIcon().click();
        return new KPAUIGetCareShade(driver);
    }

    /** Click on the Coverage & Costs icon to open the Coverage & Costs shade
     * @return Top Nav - KPAUICoverageCostsShade
     */
    public KPAUICoverageCostsShade openCoverageCostsShade() {
        getCoverageCostsShadeIcon().click();
        return new KPAUICoverageCostsShade(driver);
    }

    /** Click on the Medications icon to open the Medications shade
     * @return Top Nav - KPAUIMedicationsShade
     */
    public KPAUIMedicationsShade openMedicationsShade() {
       getMedicationsShadeIcon().click();
        return new KPAUIMedicationsShade(driver);
    }

    /** Click on the Medical Record icon to open the Medical Record shade
     * @return Top Nav - KPAUIMedicalRecordsShade
     */
    public KPAUIMedicalRecordsShade openMedicalRecordsShade() {
        getMedicalRecordShadeIcon().click();
        return new KPAUIMedicalRecordsShade(driver);
    }

    /** Click on the Home icon to open the Authenticated Home page
     * @return Top Nav - KPAUIAuthenticatedHomePage
     */
    public KPAUIAuthenticatedHomePage openHomePageFromHeader() {
        getHomeIcon().click();
        return new KPAUIAuthenticatedHomePage(driver);
    }

    /** Click on the Home icon to open the Authenticated Home page From the MyChart Page Logo
     * @return Top Nav - KPAUIAuthenticatedHomePage
     */
    public KPAUIAuthenticatedHomePage openAuthenticatedHomePageFromMyChart() {
        getHomeIconFromMyChart().click();
        return new KPAUIAuthenticatedHomePage(driver);
    }

    public KPAUIGoodbyePage signOut(){
        getBtnSignOut().click();
        return new KPAUIGoodbyePage(driver);
    }

    /** Click on the Message Center icon to open the Message Center shade
     * @return Top Nav - KPAUIMessagesShade
     */
    public KPAUIMessagesShade openMessagesShade() {
        getMessagesShadeIcon().click();
        return new KPAUIMessagesShade(driver);
    }
}
