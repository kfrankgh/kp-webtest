package org.ghc.utils.extensions;

import org.ghc.pages.KPAUIEmailMemberServicesPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.ghc.utils.KPAUIPageConstants.EveryShadeHelpSection.*;
import static org.ghc.utils.KPAUIPageConstants.SHADE_HELP_SECTION_EMAILEXPECTED_LINK;
import static org.ghc.utils.KPAUIPageConstants.SHADE_HELP_SECTION_EMAILEXPECTED_MEM_LINK;
import static org.ghc.utils.helpers.KPAUITestHelper.*;


public class KPAUIEveryShade {
    public WebDriver driver;
    private final String helpSectionHeaderText = "Questions?";
    private static final String helpSectionPhoneNum = "\\d-\\d{3}-\\d{3}-\\d{4}";

    public KPAUIEveryShade(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    //------------------------------------------------------------------------------------------------------------------

    // Finders
    @FindBy(xpath = "//core-generic-expando/div/div[2]")        private WebElement everyShadeHelpSection;
    @FindBy(xpath = "//core-generic-expando/div/div[2]/p[1]")   private WebElement everyShadeHelpSectionHeader;
    @FindBy(xpath = "//core-generic-expando/div/div[2]/p[3]")   private WebElement everyShadeHelpSectionPhone;
    @FindBy(xpath = "//core-generic-expando/div/div[2]/p[4]/a") private WebElement everyShadeHelpSectionEmail;

    // Getters
    public  WebElement getShadeHelpSection()                    { return waitForElement(everyShadeHelpSection, driver); }
    private WebElement getShadeHelpSectionHeader()              { return waitForElement(everyShadeHelpSectionHeader, driver); }
    private WebElement getShadeHelpSectionPhone()               { return waitForElement(everyShadeHelpSectionPhone, driver); }
    private WebElement getEveryShadeHelpSectionEmail()          { return waitForElementToBeClickable(everyShadeHelpSectionEmail, driver); }

    // Methods
    /** Click on Email Member Services link to open Email Member Services page
     * @return KPAUIEmailMemberServicesPage
     */
    public KPAUIEmailMemberServicesPage openEmailMemberServicesPage(){
        getEveryShadeHelpSectionEmail().click();
        return new KPAUIEmailMemberServicesPage(driver);
    }

    /** Compare Email Link attributes using the isValidLink method
     * @return boolean
     */
    public boolean validateEmailLink(){
        return isValidLink(everyShadeHelpSectionEmail, SHADE_HELP_SECTION_EMAILEXPECTED_LINK);
    }

    /** Compare Help Section Header to Expected value
     * @return boolean
     */
    public boolean validateHelpSectionHeader() {
        return helpSectionHeaderText.equals(getShadeHelpSectionHeader().getText());
    }

    /** Compare Help Section Phone number String to expected regex
     * @return boolean
     */
    public boolean validateHelpSectionPhoneNumber() {
        return getShadeHelpSectionPhone().getText().matches(helpSectionPhoneNum);
    }

    /** Compare Authenticated Email Link attributes using the isValidLink method
     * @return boolean
     */
    public boolean validateMemEmailLink(){
        return isValidLink(everyShadeHelpSectionEmail, SHADE_HELP_SECTION_EMAILEXPECTED_MEM_LINK);
    }
}
