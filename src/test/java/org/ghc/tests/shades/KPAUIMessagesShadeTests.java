package org.ghc.tests.shades;

import org.ghc.pages.KPAUIAuthenticatedHomePage;
import org.ghc.shades.KPAUIMessagesShade;
import org.ghc.utils.extensions.KPAUIEveryTest;
import org.testng.annotations.*;

import java.lang.reflect.Method;

import static org.ghc.shades.KPAUIMessagesShade.*;
import static org.testng.Assert.*;
import static org.ghc.utils.KPAUICredentials.accountName.*;

public class KPAUIMessagesShadeTests extends KPAUIEveryTest {
    private KPAUIAuthenticatedHomePage homePage;

    @BeforeMethod(alwaysRun = true)
    public void beforeTest(Method method) {
        homePage = super.initializeTest(method)
                .signIn(EVERYTHING);
        }

    //------------------------------------------------------------------------------------------------------------------

    @Test(description = "Messages Shade Links and Destination URLs", groups = {"smoke", "qa", "prod"})
    public void validateMessagesShadeLinksAndTexts() {
        KPAUIMessagesShade messagesShade = homePage.openMessagesShade();

        // Messages Shade Header Tests
        assertEquals(messagesShade.getMessagesSubHeader().getText(), MESSAGES_SUBHEADER);

        // Messages Shade Links And Texts
        assertEquals(messagesShade.getInboxLink().getText(), INBOX);
        assertEquals(messagesShade.getSentLink().getText(), SENT);
        assertEquals(messagesShade.getContactYourCareTeamLink().getText(), CONTACT_CARE_TEAM);

        // Help Section
        assertTrue(messagesShade.getShadeHelpSection().isDisplayed());
        assertTrue(messagesShade.validateHelpSectionHeader());
        assertTrue(messagesShade.validateMemEmailLink());
        assertTrue(messagesShade.validateHelpSectionPhoneNumber());
    }

    @Test(description = "Messages Shade Page Destinations", groups = {"qa", "prod"})
    public void validateAllPagesInMessagesShade() {

        homePage.openMessagesShade().openInboxMessagesPage()
                .openAuthenticatedHomePageFromMyChart()
                .openMessagesShade()
                .openSentMessagesPage()
                .openAuthenticatedHomePageFromMyChart()
                .openMessagesShade()
                .openContactYourCareTeam()
                .openAuthenticatedHomePageFromMyChart()
                .openMessagesShade()
                .openEmailMemberServicesPage();
    }
}
