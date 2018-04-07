package org.ghc.shades;

import org.ghc.pages.*;
import org.ghc.utils.extensions.KPAUIEveryShade;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.ghc.utils.helpers.KPAUITestHelper.waitForElement;
import static org.testng.Assert.fail;

public class KPAUIWellnessShade extends KPAUIEveryShade {

    public KPAUIWellnessShade(WebDriver driver) {
        super(driver);
        if (!isCurrent())
            fail("Wellness shade is not visible");
    }

    private boolean isCurrent() {
        return getResourcesSubHeader().isDisplayed();
    }

    //------------------------------------------------------------------------------------------------------------------

    public static final String RESOURCES_SUBHEADER =        "Resources";
    public static final String HEALTH_WELLNESS =            "Health & Wellness";
    public static final String CLASSES_EVENTS_GROUPS =      "Classes, Events & Support Groups";
    public static final String COMMUNITY_HEALTH =           "Community Health";
    public static final String HEALTH_BLOG =                "Health Blog";

    @FindBy(xpath = "//div/div[1]/div/p")                   private WebElement resourcesSubHeader;
    @FindBy(xpath = "//div/div[1]/div/ul/li[1]/a")          private WebElement healthWellnessLink;
    @FindBy(xpath = "//div/div[1]/div/ul/li[2]/a")          private WebElement classesEventsGroupsLink;
    @FindBy(xpath = "//div/div[1]/div/ul/li[3]/a")          private WebElement communityHealthLink;
    @FindBy(xpath = "//div/div[1]/div/ul/li[4]/a")          private WebElement healthBlogLink;

    public WebElement getResourcesSubHeader()               { return waitForElement(resourcesSubHeader, driver); }
    public WebElement getHealthWellnessLink()               { return healthWellnessLink; }
    public WebElement getClassesEventsGroupsLink()          { return classesEventsGroupsLink; }
    public WebElement getCommunityHealthLink()              { return communityHealthLink; }
    public WebElement getHealthBlogLink()                   { return healthBlogLink; }

    /** Opens the Health and Wellness Page
     * @return - KPAUIHealthAndWellnessPage
     */
    public KPAUIHealthAndWellnessPage openHealthAndWellnessPage() {
        getHealthWellnessLink().click();
        return new KPAUIHealthAndWellnessPage(driver);
    }

    /** Opens the Classes and Events Page
     * @return - KPAUIClassesAndEventsPage
     */
    public KPAUIClassesAndEventsPage openClassesAndEventsPage() {
        getClassesEventsGroupsLink().click();
        return new KPAUIClassesAndEventsPage(driver);
    }

    /** Opens the Community Health Page
     * @return - KPAUICommunityHealthPage
     */
    public KPAUICommunityHealthPage openCommunityHealthPage() {
        getCommunityHealthLink().click();
        return new KPAUICommunityHealthPage(driver);
    }

    /** Opens the Health Blog Page
     * @return - KPAUIHealthBlogPage
     */
    public KPAUIHealthBlogPage openHealthBlogPage() {
        getHealthBlogLink().click();
        return new KPAUIHealthBlogPage(driver);
    }
}
