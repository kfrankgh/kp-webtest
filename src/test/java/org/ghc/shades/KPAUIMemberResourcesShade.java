package org.ghc.shades;

import org.ghc.pages.*;
import org.ghc.utils.extensions.KPAUIEveryShade;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.ghc.utils.helpers.KPAUITestHelper.*;
import static org.testng.Assert.fail;

public class KPAUIMemberResourcesShade extends KPAUIEveryShade {

    public KPAUIMemberResourcesShade(WebDriver driver) {
        super(driver);
        if (!isCurrent())
            fail("Member Resources shade is not visible");
    }

    private boolean isCurrent() {
        return getMemberServicesHeader().isDisplayed() &&
                getNewMembersHeader().isDisplayed();
    }

    //------------------------------------------------------------------------------------------------------------------

    public static final String MEMBER_SERVICES_SUBHEADER =  "Member Services";
    public static final String NEW_MEMBER_SUBHEADER =       "New Members";
    public static final String CONTACT_MEMBER_SERVICES =    "Contact Member Services";
    public static final String COMMON_FORMS =               "Common Forms";
    public static final String BILLS_AND_PAYMENTS =         "Bills & Payment";
    public static final String CHOOSE_CHANGE_DOCTOR =       "Choose or Change Your Doctor";
    public static final String RESTRICTIONS_RELEASE_INFO =  "Restrictions on the Release of Health Care Information";
    public static final String ACCESS_CHILDS_RECORDS =      "Access Your Child's Medical Records Online";
    public static final String FINANCIAL_ASSISTANCE =       "Financial Assistance";
    public static final String GET_STARTED =                "Get Started";

    @FindBy(xpath = "//core-generic-expando/div/div[1]/div[1]/p")                private WebElement memberServicesHeader;
    @FindBy(xpath = "//core-generic-expando/div/div[1]/div[2]/p")                private WebElement newMembersHeader;
    @FindBy(xpath = "//core-generic-expando/div/div[1]/div[1]/ul[1]/li/a")       private WebElement contactMemberServicesLink;
    @FindBy(xpath = "//core-generic-expando/div/div[1]/div[1]/ul/li[2]/a")       private WebElement commonFormsLink;
    @FindBy(xpath = "//core-generic-expando/div/div[1]/div[1]/ul/li[3]/a")       private WebElement billsPaymentsLink;
    @FindBy(xpath = "//core-generic-expando/div/div[1]/div[1]/ul/li[4]/a")       private WebElement chooseChangeDoctorLink;
    @FindBy(xpath = "//core-generic-expando/div/div[1]/div[1]/ul/li[5]/a")       private WebElement releaseHealthCareInformationLink;
    @FindBy(xpath = "//core-generic-expando/div/div[1]/div[1]/ul/li[6]/a")       private WebElement accessChildsMedicalRecordsLink;
    @FindBy(xpath = "//core-generic-expando/div/div[1]/div[1]/ul/li[7]/a")       private WebElement financialAssistanceLink;
    @FindBy(xpath = "//core-generic-expando/div/div[1]/div[2]/ul/li/a")          private WebElement getStartedLink;

    public WebElement getMemberServicesHeader()             { return waitForElement(memberServicesHeader, driver); }
    public WebElement getNewMembersHeader()                 { return newMembersHeader; }
    public WebElement getContactMemberServicesLink()        { return contactMemberServicesLink; }
    public WebElement getCommonFormsLink()                  { return commonFormsLink; }
    public WebElement getBillsPaymentsLink()                { return billsPaymentsLink; }
    public WebElement getChooseChangeDoctorLink()           { return chooseChangeDoctorLink; }
    public WebElement getReleaseHealthCareInformationLink() { return releaseHealthCareInformationLink; }
    public WebElement getAccessChildsMedicalRecordsLink()   { return accessChildsMedicalRecordsLink; }
    public WebElement getFinancialAssistanceLink()          { return financialAssistanceLink; }
    public WebElement getGetStartedLink()                   { return getStartedLink; }

    /** Opens the Members Services Page from the Contact Member Services Link
     * @return - KPAUIMemberServicesPage
     */
    public KPAUIMemberServicesPage openMemberServicesPage() {
        getContactMemberServicesLink().click();
        return new KPAUIMemberServicesPage(driver);
    }

    /** Opens the New New Members Guide Page from the "Get Started" Link
     * @return - KPAUINewMembersGuidePage
     */
    public KPAUINewMembersGuidePage openNewMembersGuidePage() {
        getGetStartedLink().click();
        return new KPAUINewMembersGuidePage(driver);
    }

    /** Opens the Forms Page
     * @return - KPAUIFormsPage
     */
    public KPAUIFormsPage openFormsPage() {
        getCommonFormsLink().click();
        return new KPAUIFormsPage(driver);
    }

    /** Opens the Billing and Payments Page
     * @return - KPAUIBillingAndPaymentPage
     */
    public KPAUIBillingAndPaymentPage openBillsAndPaymentPage() {
        getBillsPaymentsLink().click();
        return new KPAUIBillingAndPaymentPage(driver);
    }

    /** Opens the Choose or Change Your Doctor Page
     * @return - KPAUIChooseOrChangeYourDoctorPage
     */
    public KPAUIChooseOrChangeYourDoctorPage openChooseOrChangeYourDoctorPage() {
        getChooseChangeDoctorLink().click();
        return new KPAUIChooseOrChangeYourDoctorPage(driver);
    }

    /** Opens the Restrictions On Release Of Health Care Info Page
     * @return - KPAUIHealthCareInfoRestrictionsPage
     */
    public KPAUIHealthCareInfoRestrictionsPage openRestrictionsOnReleaseOfHealthCareInfoPage() {
        getReleaseHealthCareInformationLink().click();
        return new KPAUIHealthCareInfoRestrictionsPage(driver);
    }

    /** Open the Access Childs Medical Records Page
     * @return - KPAUIAccessChildsMedicalRecordsPage
     */
    public KPAUIAccessChildsMedicalRecordsPage openAccessChildsMedicalRecordsPage() {
        getAccessChildsMedicalRecordsLink().click();
        return new KPAUIAccessChildsMedicalRecordsPage(driver);
    }

    /** Open the Financial Assistance Page
     * @return - KPAUIFinancialAssistancePage
     */
    public KPAUIFinancialAssistancePage openFinancialAssistancePage() {
        getFinancialAssistanceLink().click();
        return new KPAUIFinancialAssistancePage(getChildDriver(driver));
    }
}
