package org.ghc.pages;

import org.ghc.utils.extensions.KPAUIEveryUnAuthenticatedPage;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.fail;

public class KPAUIHealthBlogPage extends KPAUIEveryUnAuthenticatedPage {

    public KPAUIHealthBlogPage(WebDriver driver) {
        super(driver);
        if (!isCurrent(driver, pageTitleHealthBlog))
            fail("The Health Blog Page did not load correctly");
    }

    //------------------------------------------------------------------------------------------------------------------

    private static final String pageTitleHealthBlog = "NW Health Blog Kaiser Permanente Formerly Group Health";


}