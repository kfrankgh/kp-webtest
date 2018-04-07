package org.ghc.pages;

import org.ghc.shades.KPAUIMemberResourcesShade;
import org.ghc.utils.extensions.KPAUIEveryAuthenticatedPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.ghc.utils.helpers.KPAUITestHelper.waitForElement;
import static org.testng.Assert.fail;

public class KPAUIAccessChildsMedicalRecordsPage extends KPAUIEveryAuthenticatedPage {

    public KPAUIAccessChildsMedicalRecordsPage(WebDriver driver) {
        super(driver);
        if (!isCurrent(driver, PAGETITLE_ACCESS_CHILDS_MEDICAL_RECORD))
            fail("The Children's Medical Records Page did not load correctly");
    }

    //------------------------------------------------------------------------------------------------------------------

    private static final String PAGETITLE_ACCESS_CHILDS_MEDICAL_RECORD = "Parental Access to Children's Online Records";

    @FindBy(xpath = "//core-nav-bar/nav/div/ul/li[5]/a")    private WebElement memberResourcesShadeIcon;

    private WebElement getMemberResourcesShadeIcon()         { return waitForElement(memberResourcesShadeIcon, driver); }

    /** Click on Top Nav Member Resources link to open the Member Resources shade
     * @return KPAUIMemberResourcesShade
     */
    public KPAUIMemberResourcesShade openMemberResourcesShade(){
        getMemberResourcesShadeIcon().click();
        return new KPAUIMemberResourcesShade(driver);
    }
}
