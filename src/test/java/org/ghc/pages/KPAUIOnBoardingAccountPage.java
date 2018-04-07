package org.ghc.pages;

import org.ghc.shades.KPAUIPwdHelpShade;
import org.ghc.utils.KPAUICredentials.KPAUIAccount;
import org.ghc.utils.extensions.KPAUIEveryOnBoardingPage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

import static org.ghc.utils.helpers.KPAUITestHelper.*;
import static org.testng.Assert.fail;

public class KPAUIOnBoardingAccountPage extends KPAUIEveryOnBoardingPage {
    public KPAUIOnBoardingAccountPage(WebDriver driver, boolean noSsn) {
        super(driver);
        this.driver = driver;
        if (!isCurrent()) {
            fail("The Member Registration - Create Account page did not load correctly");
        }
        this.noSsn = noSsn;

    }

    private Boolean isCurrent(){
        return isAccountPageDisplayed();
    }

    WebDriver driver;
    private Boolean noSsn;

    //------------------------------------------------------------------------------------------------------------------
    @FindBy(css="input[type='email']")  WebElement emailBox;
    @FindBy(css="[property='email'] .invalid-feedback") WebElement emailErrorMsg;
    @FindBy(css="[property='password']>input")  WebElement passwordBox;
    @FindBy(css="[property='password'] .invalid-feedback")  WebElement passwordErrorMsg;
    @FindBy(css="[type='password'] .invalid-feedback")  WebElement passwordMismatchErrorMsg;
    @FindBy(css="[property='retypedPassword']>input") WebElement rePasswordBox;
    @FindBy(css="[property='retypedPassword'] .invalid-feedback")   WebElement rePasswordErrorMsg;
    @FindBy(css="[property='securityQuestionId'] [value='6']")  WebElement securityQuestion;
    @FindBy(css="[property='securityQuestionAnswer']>input")    WebElement securityAnswerBox;
    @FindBy(css="[property='securityQuestionAnswer'] .invalid-feedback")    WebElement securityAnswerErrorMsg;
    @FindBy(css="[property='securityQuestionId'] .invalid-feedback")    WebElement securityQuestionErrorMsg;
    @FindBy(linkText = "see rules") WebElement seeRulesLink;

    private void clearAllFields(){
        do {
            clearField(getEmailBox());
        }while(!getEmailBox().getAttribute("value").isEmpty());

        clearField(getPasswordBox());
        clearField(getRePasswordBox());
        clearField(getsSecurityAnswerBox());
    }

    public KPAUIUnAuthenticatedHomePage clickCancelButton() {
        getCancelButton().click();
        ifAlertThenCloseAlert();
        return new KPAUIUnAuthenticatedHomePage(driver);
    }

    public KPAUIPwdHelpShade clickSeeRulesLink(){
        getSeeRulesLink().click();
        return new KPAUIPwdHelpShade(driver);
    }

    public KPAUIOnBoardingSvaQuizPage createYourAccountAndGoToQuiz(KPAUIAccount account) {
        fillInCreateYourAccount(account);
        sleep(2);
        return new KPAUIOnBoardingSvaQuizPage(driver);
    }

    public KPAUIOnBoardingVerifyIdPage createYourAccountAndNoQuiz(KPAUIAccount account) {
        fillInCreateYourAccount(account);
        return new KPAUIOnBoardingVerifyIdPage(driver);
    }

    /** Click on the Cancel Button. Used for exiting OnBoarding after failed test
     * @return KPAUIUnAuthenticatedHomePage
     */
    public void exitOnBoarding() {
        getCancelButton().click();
        ifAlertThenCloseAlert();
    }

    private void fillInCreateYourAccount(KPAUIAccount account) {
        clearAllFields();
        getEmailBox().sendKeys(account.getEmail());
        getPasswordBox().sendKeys(account.getPass());
        getRePasswordBox().sendKeys(account.getPass());
        chooseSecurityQuestion();
        getsSecurityAnswerBox().sendKeys(account.getSecAnswer());
        long start = System.currentTimeMillis();
        do {
            try {
                getNextButton().click();
            }catch(StaleElementReferenceException e){
                System.out.println(String.format("Clicking Next Button on Account Page threw Exception\n%s"
                        , e.getStackTrace().toString()));
            }
            waitForNextPageToLoad();
        }while(isAccountPageDisplayed() && ( (System.currentTimeMillis() - start) < 10000 ));

        if(isAccountPageDisplayed()){
            System.out.println("Clicking next on the Account page failed to go to next page\nExiting onboarding");
            exitOnBoarding();
        }

    }

    private void fillInCreateYourAccount(String password, String repassword, String email, Boolean chooseSecQuestion, String securityAnswer) {
        clearAllFields();
        getEmailBox().sendKeys(email);
        getPasswordBox().sendKeys(password);
        getRePasswordBox().sendKeys(repassword);
        if(chooseSecQuestion){
            chooseSecurityQuestion();
        }
        getsSecurityAnswerBox().sendKeys(securityAnswer);
        getNextButton().click();
    }

    public WebElement getEmailBox() {
        return waitForElement(emailBox, driver);
    }

    public String getEmailErrorMsg(){
        try {
            return emailErrorMsg.getText();
        }catch(NoSuchElementException e){
            return "";
        }
    }

    public WebElement getPasswordBox() {
        return waitForElement(passwordBox, driver);
    }

    public String getPasswordErrorMsg(){
        return passwordErrorMsg.getText();
    }

    public String getPwdMismatchErrorMsg(){
        return passwordMismatchErrorMsg.getText();
    }

    public WebElement getRePasswordBox() {
        return rePasswordBox;
    }

    public String getRePasswordErrorMsg(){
        return rePasswordErrorMsg.getText();
    }

    public void chooseSecurityQuestion() {
        securityQuestion.click();
    }

    public WebElement getsSecurityAnswerBox() {
        return securityAnswerBox;
    }

    public String getSecurityAnswerErrorMsg(){
        return securityAnswerErrorMsg.getText();
    }

    public String getSecurityQuestionErrorMsg(){
        return securityQuestionErrorMsg.getText();
    }

    public WebElement getSeeRulesLink(){
        return waitForElement(seeRulesLink, driver);
    }

    public KPAUIOnBoardingAccountPage invalidCreateYourAccount(String password, String repassword, String email, String securityAnswer, Boolean chooseSecQuestion){
        fillInCreateYourAccount(password, repassword, email, chooseSecQuestion, securityAnswer);
        return new KPAUIOnBoardingAccountPage(driver, noSsn);
    }

    private Boolean isAccountPageDisplayed(){
        try {
            getPasswordBox();
        }
        catch(NoSuchElementException e){
            return false;
        }
        return true;
    }

    private void waitForNextPageToLoad(){
        long start = System.currentTimeMillis();
        do{
            sleep(1);
        }while(isAccountPageDisplayed() && ((System.currentTimeMillis() - start) < 5000));
    }
}