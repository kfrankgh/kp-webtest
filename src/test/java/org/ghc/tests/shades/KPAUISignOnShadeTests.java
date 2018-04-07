package org.ghc.tests.shades;

import org.ghc.pages.KPAUIUnAuthenticatedHomePage;
import org.ghc.shades.KPAUISignOnShade;
import org.ghc.utils.extensions.KPAUIEveryTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

import static org.ghc.shades.KPAUISignOnShade.*;
import static org.testng.Assert.*;

public class KPAUISignOnShadeTests extends KPAUIEveryTest {
    private KPAUIUnAuthenticatedHomePage homePage;

    @BeforeMethod(alwaysRun = true)
    public void beforeTest(Method method) {
        homePage = super.initializeTest(method);
    }

    //------------------------------------------------------------------------------------------------------------------

    @Test(description = "Verify All Objects And Links are Displayed on the Sign On Shade", groups = {"smoke", "qa", "prod"})
    public void validateObjectsAndLinkTextsOnSignOnShade() {
        KPAUISignOnShade kpauiLoginShade = homePage.openSignOnShade();

        assertTrue(kpauiLoginShade.getCancelButton().isDisplayed());
        assertTrue(kpauiLoginShade.getMemberIDField().isDisplayed());
        assertTrue(kpauiLoginShade.getPasswordField().isDisplayed());

        assertEquals(kpauiLoginShade.getRegisterNowLink().getText(), REGISTER_NOW_TEXT);
        assertEquals(kpauiLoginShade.getForgotPasswordLink().getText(), FORGOT_PASSWORD_TEXT);
        assertEquals(kpauiLoginShade.getSignOnButton().getText(), SIGN_ON_TEXT);
        assertEquals(kpauiLoginShade.getMemberIDLabel().getText(), MEMBERID_TEXT);
        assertEquals(kpauiLoginShade.getPasswordLabel().getText(), PASSWORD_TEXT);
    }

    @Test(description = "Verify Sign On Shade Links Go To Correct Destination", groups = {"qa", "prod"})
    public void validateSignOnShadeLinkDestinations() {
        homePage.openSignOnShade().openRegisterNowLink()
                .openUnAuthenticatedHomePage()
                .openSignOnShade()
                .openForgotPasswordLink()
                .openUnAuthenticatedHomePage()
                .openSignOnShade()
                .clickCancelSignInButton();

        assertTrue(homePage.validateSignOnShadeIsClosed());
    }
}
