package org.ghc.tests.navigation;

import org.ghc.pages.KPAUIAuthenticatedHomePage;
import org.ghc.pages.KPAUIUnAuthenticatedHomePage;
import org.ghc.utils.extensions.KPAUIEveryTest;
import org.testng.annotations.*;
import java.lang.reflect.Method;


import static org.ghc.utils.KPAUIPageConstants.EveryPageHeader.*;
import static org.ghc.utils.KPAUICredentials.accountName.*;
import static org.ghc.utils.helpers.KPAUITestHelper.assertEqualsInsensitive;
import static org.ghc.utils.KPAUIPageConstants.ExpectedLinksAndHeaders.EveryUnAuthenticatedPageHeader.signOnButtonText;
import static org.testng.Assert.*;

public class KPAUIHeaderTests extends KPAUIEveryTest {
    private KPAUIUnAuthenticatedHomePage unAuthHomePage;

    @BeforeMethod(alwaysRun = true)
    public void beforeTest(Method method) {
        unAuthHomePage = super.initializeTest(method);
    }

    //------------------------------------------------------------------------------------------------------------------

    @Test(description = "Verify public home page header contains the KP Logo", groups = {"smoke", "qa", "prod"})
    public void validateUnauthenticatedPageKPLogo(){
        assertEqualsInsensitive(unAuthHomePage.getBtnSignOn().getText(), signOnButtonText);
        assertEqualsInsensitive(unAuthHomePage.getHeaderSearchButton().getText(), searchButtonText);
        assertTrue(unAuthHomePage.verifyUnauthenticatedHeaderLogoSource());

    }

    @Test(description = "Verify secure home page header contains the KP Logo", groups = {"smoke", "qa", "prod"})
    public void validateAuthenticatedPageKPLogo() {
        KPAUIAuthenticatedHomePage homePage = unAuthHomePage.signIn(EVERYTHING);

        assertEqualsInsensitive(homePage.getBtnSignOut().getText(), signOffButtonText);
        assertTrue(homePage.verifyAuthenticatedHeaderLogoSource());

        homePage.openHomePageFromHeader();
    }
}
