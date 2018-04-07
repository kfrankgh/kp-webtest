package org.ghc.tests.cards;

import org.ghc.cards.KPAUIMessagesCard;
import org.ghc.pages.KPAUIUnAuthenticatedHomePage;
import org.ghc.utils.extensions.KPAUIEveryTest;
import org.testng.annotations.*;
import java.lang.reflect.Method;

import static org.ghc.utils.KPAUICredentials.accountName.*;
import static org.testng.Assert.*;

public class KPAUIMessagesCardTests extends KPAUIEveryTest {
    private KPAUIUnAuthenticatedHomePage unAuthenticatedHomePage;

    @BeforeMethod(alwaysRun = true)
    public void beforeTest(Method method) {
        unAuthenticatedHomePage = super.initializeTest(method);
        }

    //------------------------------------------------------------------------------------------------------------------

    @Test(description = "Verify Links and Objects on an Account with Messages", groups = {"smoke", "qa", "prod"})
    public void validateMessagesCardWithMessages() {
        KPAUIMessagesCard messagesCard = unAuthenticatedHomePage
                .signIn(EVERYTHING)
                .getMessagesCard();

        assertTrue(messagesCard.verifyHeaderLinkAndArrow());
        assertTrue(messagesCard.verifySeeAllMessagesAndLink());
        assertTrue(messagesCard.verifyNumberOfMessageLines());

        messagesCard.openMessageCenterByHeader()
                .openAuthenticatedHomePageFromMyChart()
                .getMessagesCard()
                .openSeeAllMessages();
    }

    @Test(description = "Verify Links and Objects on an Account without Messages", groups = {"smoke", "qa", "prod"})
    public void validateMessagesCardWithoutMessages() {
        KPAUIMessagesCard messagesCard = unAuthenticatedHomePage
                .signIn(NOTHING)
                .getMessagesCard();

        assertTrue(messagesCard.verifyNoMessages());
        assertTrue(messagesCard.verifyGoToMessageCenterIconAndLink());
        messagesCard.openGoToMessageCenter();
    }
}
