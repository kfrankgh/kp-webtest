package org.ghc.tests.navigation;

import org.ghc.pages.KPAUIAuthenticatedHomePage;
import org.ghc.utils.extensions.KPAUIEveryTest;
import org.testng.annotations.*;
import java.lang.reflect.Method;

import static org.ghc.pages.KPAUIAuthenticatedHomePage.*;
import static org.ghc.utils.helpers.KPAUITestHelper.*;
import static org.ghc.utils.KPAUICredentials.accountName.*;

public class KPAUIRibbonNavigationTests extends KPAUIEveryTest {
    private KPAUIAuthenticatedHomePage homepage;

    @BeforeMethod(alwaysRun = true)
    public void beforeTest(Method method) {
        homepage = super.initializeTest(method)
                .signIn(EVERYTHING);
    }

    //------------------------------------------------------------------------------------------------------------------

    @Test(description = "Assert All Ribbon Links Are Displayed and Contain Correct Text", groups = {"smoke", "qa", "prod"})
    public void validateGetCareRibbonImage() {
        assertEqualsInsensitive(homepage.getGetCareRibbonLink().getText(), LINKTEXT_GET_CARE_RIBBON);
        assertEqualsInsensitive(homepage.getConsultingNurseRibbonLink().getText(), LINKTEXT_CONSULTING_NURSE_RIBBON);
        assertEqualsInsensitive(homepage.getCareChatRibbonLink().getText(), LINKTEXT_CARE_CHAT_RIBBON);
        assertEqualsInsensitive(homepage.getOnlineVisitRibbonLink().getText(), LINKTEXT_ONLINE_VISIT_RIBBON);
        assertEqualsInsensitive(homepage.getWalkInCareClinicsRibbonLink().getText(), LINKTEXT_WALKIN_CARECLINICS_RIBBON);
        assertEqualsInsensitive(homepage.getUrgentCareRibbonLink().getText(), LINKTEXT_URGENT_CARE_RIBBON);
    }

    @Test(description = "Assert All Ribbon Links Navigate Correctly", groups = {"qa", "prod"})
    public void validateConsultingNurseImage() {
        homepage.openConsultNursePage()
                .openHomePageFromHeader()
                .openGetCareRibbonLink()
                .openHomePageFromHeader()
                .openUrgentCarePage()
                .openHomePageFromHeader()
                .openOnlineVisitPage()
                .openAuthenticatedHomePageFromMyChart()
                .openWalkInCareClinics()
                .openHomePageFromHeader()
                .openCareChatPage();
    }
}
