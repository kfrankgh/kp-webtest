package org.ghc.shades;

import org.ghc.pages.*;
import org.ghc.utils.extensions.KPAUIEveryShade;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.ghc.utils.helpers.KPAUITestHelper.waitForElement;
import static org.testng.Assert.fail;

public class KPAUIShopPlansShade extends KPAUIEveryShade{

    public KPAUIShopPlansShade(WebDriver driver) {
        super(driver);
        if (!isCurrent())
            fail("Shop Plans shade is not visible");
    }

    private boolean isCurrent() {
        return getFindPlansSubHeader().isDisplayed();
    }

    //------------------------------------------------------------------------------------------------------------------

    public static final String FIND_PLANS_SUBHEADER =       "Find Plans";
    public static final String OUR_PLANS =                  "Our Plans";
    public static final String MEDICARE_ADVANTAGE =         "Medicare Advantage";
    public static final String INDIVIDUAL_FAMILY =          "Individual & Family";
    public static final String PUBLIC_EMPLOYEES =           "Public Employees";
    public static final String FEDERAL_EMPLOYEES =          "Federal Employees";
    public static final String SMALL_LARGE_BUSSINESSES =    "Small & Large Businesses";

    @FindBy(xpath = "//div/div[1]/div/p")                   private WebElement findPlansSubHeader;
    @FindBy(xpath = "//div/div[1]/div/ul/li[1]/a")          private WebElement ourPlansLink;
    @FindBy(xpath = "//div/div[1]/div/ul/li[2]/a")          private WebElement medicareAdvatageLink;
    @FindBy(xpath = "//div/div[1]/div/ul/li[3]/a")          private WebElement individualAndFamilyLink;
    @FindBy(xpath = "//div/div[1]/div/ul/li[4]/a")          private WebElement publicEmployeesLink;
    @FindBy(xpath = "//div/div[1]/div/ul/li[5]/a")          private WebElement federalEmployeesLink;
    @FindBy(xpath = "//div/div[1]/div/ul/li[6]/a")          private WebElement smallAndLargeBusinessesLink;

    public WebElement getFindPlansSubHeader()               { return waitForElement(findPlansSubHeader, driver); }
    public WebElement getOurPlansLink()                     { return ourPlansLink; }
    public WebElement getMedicareAdvantageLink()            { return medicareAdvatageLink; }
    public WebElement getIndividualAndFamilyLink()          { return individualAndFamilyLink; }
    public WebElement getPublicEmployeesLink()              { return publicEmployeesLink; }
    public WebElement getFederalEmployeesLink()             { return federalEmployeesLink; }
    public WebElement getSmallAndLargeBusinessesLink()      { return smallAndLargeBusinessesLink; }

    /** Opens the Health Plans Page from the "Our Plans" Link
     * @return - KPAUIHealthPlansPage
     */
    public KPAUIHealthPlansPage openHealthPlansPageFromOurPlansLink(){
        getOurPlansLink().click();
        return new KPAUIHealthPlansPage(driver);
    }

    /** Opens the Medicare Advantage Page
     * @return - KPAUIMedicareAdvantagePage
     */
    public KPAUIMedicareAdvantagePage openMedicareAdvantagePage() {
        getMedicareAdvantageLink().click();
        return new KPAUIMedicareAdvantagePage(driver);
    }

    /** Opens the Health Plans for Individual Family Page
     * @return - KPAUIHealthPlansIndividualAndFamilyPage
     */
    public KPAUIHealthPlansIndividualAndFamilyPage openHealthPlansIndividualAndFamilyPage(){
        getIndividualAndFamilyLink().click();
        return new KPAUIHealthPlansIndividualAndFamilyPage(driver);
    }

    /** Opens the Health Plans for State Employees Page
     * @return - KPAUIStateEmployeesPage
     */
    public KPAUIStateEmployeesPage openStateEmployeesPage(){
        getPublicEmployeesLink().click();
        return new KPAUIStateEmployeesPage(driver);
    }

    /** Opens the Health Plans for Federal Employees Page
     * @return - KPAUIFederalEmployeesPlansPage
     */
    public KPAUIFederalEmployeesPlansPage openFederalEmployessPlansPage(){
        getFederalEmployeesLink().click();
        return new KPAUIFederalEmployeesPlansPage(driver);
    }

    /** Opens the Health Plans for Employers Page From "Small and Large Businesses" Link
     * @return - KPAUIHealthInsuranceForEmployersPage
     */
    public KPAUIHealthInsuranceForEmployersPage openHealthInsuranceForEmployersPage(){
        getSmallAndLargeBusinessesLink().click();
        return new KPAUIHealthInsuranceForEmployersPage(driver);
    }
}
