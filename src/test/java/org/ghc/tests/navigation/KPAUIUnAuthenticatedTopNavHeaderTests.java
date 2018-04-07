package org.ghc.tests.navigation;

import org.ghc.pages.KPAUIUnAuthenticatedHomePage;
import org.ghc.utils.extensions.KPAUIEveryTest;
import org.testng.annotations.*;
import java.lang.reflect.Method;

import static org.ghc.utils.helpers.KPAUITestHelper.assertEqualsInsensitive;
import static org.ghc.utils.extensions.KPAUIEveryUnAuthenticatedPage.*;

public class KPAUIUnAuthenticatedTopNavHeaderTests extends KPAUIEveryTest {
    private KPAUIUnAuthenticatedHomePage homepage;

    @BeforeMethod(alwaysRun = true)
    public void beforeTest(Method method) {
        homepage = super.initializeTest(method);
    }

    //------------------------------------------------------------------------------------------------------------------

    @Test(description = "Verify Shop Plans Header", groups = {"smoke", "qa", "prod"})
    public void validateShopPlansHeader(){
        assertEqualsInsensitive(homepage.getShopPlansShadeIcon().getText(), shopPlansLinkText);
        assertEqualsInsensitive(homepage.getGetCareShadeIcon().getText(), getCareLinkText);
        assertEqualsInsensitive(homepage.getFindADoctorShadeIcon().getText(), findADoctorLinkText);
        assertEqualsInsensitive(homepage.getMemberResourcesShadeIcon().getText(), memberResourcesLinkText);
        assertEqualsInsensitive(homepage.getWellnessShadeIcon().getText(), wellnessLinkText);

        homepage.clickFindADoctorTopNavHeader();
    }
}
