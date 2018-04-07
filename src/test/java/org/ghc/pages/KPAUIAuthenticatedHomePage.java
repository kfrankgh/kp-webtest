package org.ghc.pages;

import org.ghc.cards.*;
import org.ghc.utils.extensions.KPAUIEveryAuthenticatedPage;
import org.ghc.utils.helpers.KPAUILink;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.ghc.utils.KPAUIPageConstants.baseBoth;
import static org.ghc.utils.helpers.KPAUITestHelper.getChildDriver;
import static org.ghc.utils.helpers.KPAUITestHelper.waitForElementToBeClickable;
import static org.testng.Assert.fail;

public class KPAUIAuthenticatedHomePage extends KPAUIEveryAuthenticatedPage {

    public KPAUIAuthenticatedHomePage(WebDriver driver) {
        super(driver);
        if (!isCurrent()) {
            fail("Authenticated Home Page Did Not Load Correctly");
        }
    }

    private boolean isCurrent() {
        return getAppointmentsCard().getAppointmentsHeader().isDisplayed();
    }

    //Ribbon
    public static final String LINKTEXT_GET_CARE_RIBBON = "Get Care";
    public static final String GET_CARE_RIBBON_LINK_DESTINATION = baseBoth + "/html/public/care-options";
    public static final String LINKTEXT_CONSULTING_NURSE_RIBBON = "Consulting Nurse";
    public static final String CONSULTING_NURSE_RIBBON_LINK_DESTINATION = baseBoth + "/html/public/services/consulting-nurse";
    public static final String LINKTEXT_CARE_CHAT_RIBBON = "Care Chat";
    public static final String CARE_CHAT_RIBBON_LINK_DESTINATION = baseBoth + "/home/#";
    public static final String LINKTEXT_ONLINE_VISIT_RIBBON = "Online Visit";
    public static final String ONLINE_VISIT_RIBBON_LINK_DESTINATION = baseBoth + "/mychart/inside.asp\\?mode=evisit";
    public static final String LINKTEXT_WALKIN_CARECLINICS_RIBBON = "Walk-In CareClinic";
    public static final String WALKIN_CARECLINICS_RIBBON_LINK_DESTINATION = baseBoth + "/html/public/services/care-clinics";
    public static final String LINKTEXT_URGENT_CARE_RIBBON = "Urgent Care";
    public static final String URGENT_CARE_RIBBON_LINK_DESTINATION = baseBoth + "/html/public/services/urgent-care";

    //Ribbon Links
    public static final KPAUILink GET_CARE_RIBBON_EXPECTED_LINK = new KPAUILink(LINKTEXT_GET_CARE_RIBBON, GET_CARE_RIBBON_LINK_DESTINATION);
    public static final KPAUILink CONSULTING_NURSE_RIBBON_EXPECTED_LINK = new KPAUILink(LINKTEXT_CONSULTING_NURSE_RIBBON, CONSULTING_NURSE_RIBBON_LINK_DESTINATION);
    public static final KPAUILink CARE_CHAT_RIBBON_EXPECTED_LINK = new KPAUILink(LINKTEXT_CARE_CHAT_RIBBON, CARE_CHAT_RIBBON_LINK_DESTINATION);
    public static final KPAUILink ONLINE_VISIT_RIBBON_EXPECTED_LINK = new KPAUILink(LINKTEXT_ONLINE_VISIT_RIBBON, ONLINE_VISIT_RIBBON_LINK_DESTINATION);
    public static final KPAUILink WALKIN_CARECLINICS_RIBBON_EXPECTED_LINK = new KPAUILink(LINKTEXT_WALKIN_CARECLINICS_RIBBON, WALKIN_CARECLINICS_RIBBON_LINK_DESTINATION);
    public static final KPAUILink URGENT_CARE_RIBBON_EXPECTED_LINK = new KPAUILink(LINKTEXT_URGENT_CARE_RIBBON, URGENT_CARE_RIBBON_LINK_DESTINATION);

    //------------------------------------------------------------------------------------------------------------------

    //Ribbon Finders
    @FindBy(xpath = "//div[1]/div/div/div[1]/core-link/a")      private WebElement getCareRibbonLink;
    @FindBy(xpath = "//div[1]/div/div/div[2]/core-link/a")      private WebElement consultingNurseRibbonLink;
    @FindBy(linkText = "Care Chat")                             private WebElement careChatRibbonLink;
    @FindBy(xpath = "//div[1]/div/div/div[5]/core-link/a")      private WebElement onlineVisitRibbonLink;
    @FindBy(xpath = "//div[1]/div/div/div[6]/core-link/a")      private WebElement walkInCareClinicsRibbonLink;
    @FindBy(xpath = "//div[1]/div/div/div[7]/core-link/a")      private WebElement urgentCareRibbonLink;

    // Link Getters
    public WebElement getGetCareRibbonLink()                { return waitForElementToBeClickable(getCareRibbonLink, driver); }
    public WebElement getConsultingNurseRibbonLink()        { return waitForElementToBeClickable(consultingNurseRibbonLink, driver); }
    public WebElement getCareChatRibbonLink()               { return waitForElementToBeClickable(careChatRibbonLink, driver); }
    public WebElement getOnlineVisitRibbonLink()            { return waitForElementToBeClickable(onlineVisitRibbonLink, driver); }
    public WebElement getUrgentCareRibbonLink()             { return waitForElementToBeClickable(urgentCareRibbonLink, driver); }
    public WebElement getWalkInCareClinicsRibbonLink()      { return waitForElementToBeClickable(walkInCareClinicsRibbonLink, driver); }

    // Card Getters
    public KPAUIAppointmentsCard getAppointmentsCard()           { return new KPAUIAppointmentsCard(driver); }
    public KPAUIMedicalBillsCard getBillsClaimsCard()            { return new KPAUIMedicalBillsCard(driver); }
    public KPAUIHealthActionPlanCard getHealthActionPlanCard()   { return new KPAUIHealthActionPlanCard(driver); }
    public KPAUIHealthCoverageCard getHealthCoverageCard()       { return new KPAUIHealthCoverageCard(driver); }
    public KPAUIMedicationsCard getMedicationsCard()             { return new KPAUIMedicationsCard(driver); }
    public KPAUIMessagesCard getMessagesCard()                   { return new KPAUIMessagesCard(driver); }
    public KPAUIParentalAccessCard getParentalAccessCard()       { return new KPAUIParentalAccessCard(driver); }
    public KPAUICareRemindersCard getCareRemindersCard()         { return new KPAUICareRemindersCard(driver); }
    public KPAUICareTeamCard getYourCareTeamCard()               { return new KPAUICareTeamCard(driver); }

    // Methods
    /** Click on the Care Options link to start the Care Options page
     * @return new Care Options page - KPAUICareOptionsPage
     */
    public KPAUICareOptionsPage openGetCareRibbonLink() {
        getGetCareRibbonLink().click();
        return new KPAUICareOptionsPage(driver);
    }

    /** Click on the Consulting Nurse link to start the Consulting Nurse experience
     * @return new Care Chat experience - KPAUIConsultingNursePage
     */
    public KPAUIConsultingNursePage openConsultNursePage() {
        getConsultingNurseRibbonLink().click();
        return new KPAUIConsultingNursePage(driver);
    }

    /** Click on the Care Chat link to start the Care Chat experience
     * @return new Care Chat experience - KPAUIStartAnOnlineVisitPage
     */
    public KPAUICareChatPage openCareChatPage() {
        getCareChatRibbonLink().click();
        return new KPAUICareChatPage(getChildDriver(driver));
    }

    /** Click on the Start Online Visit link to start the Online Visit experience
     * @return new Online Visit experience - KPAUIStartAnOnlineVisitPage
     */
    public KPAUIStartAnOnlineVisitPage openOnlineVisitPage() {
        getOnlineVisitRibbonLink().click();
        return new KPAUIStartAnOnlineVisitPage(driver);
    }

    /** Click on the Care Clinics link to open the Care Clinics page
     * @return new Care Clinics page - KPAUICareClinicsPage
     */
    public KPAUIBartellsCareClinicsPage openWalkInCareClinics() {
        getWalkInCareClinicsRibbonLink().click();
        return new KPAUIBartellsCareClinicsPage(driver);
    }

    /** Click on the Urgent Care link to open the Emergency and Urgent Care page
     * @return new Emergency and Urgent Care page - KPAUIEmergencyAndUrgentCarePage
     */
    public KPAUIEmergencyAndUrgentCarePage openUrgentCarePage() {
        getUrgentCareRibbonLink().click();
        return new KPAUIEmergencyAndUrgentCarePage(driver);
    }
}
