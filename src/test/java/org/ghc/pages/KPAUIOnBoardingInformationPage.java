package org.ghc.pages;

import org.ghc.shades.KPAUIMemberIDHelpShade;
import org.ghc.shades.KPAUIWhyIsNeededHelpShade;
import org.ghc.utils.KPAUICredentials.KPAUIAccount;
import org.ghc.utils.extensions.KPAUIEveryOnBoardingPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static org.ghc.utils.helpers.KPAUIStringHelper.formatAccountDob;
import static org.ghc.utils.helpers.KPAUITestHelper.*;
import static org.testng.Assert.fail;

public class KPAUIOnBoardingInformationPage extends KPAUIEveryOnBoardingPage {

    public KPAUIOnBoardingInformationPage(WebDriver driver) {
        super(driver);
        if (!isCurrent()) {
            fail("The Member Registration - Information page did not load correctly");
        }
    }

    private Boolean isCurrent(){
        waitForElement(firstNameBox, driver);
        return (firstName.size() > 0);
    }

    @FindBy(css="[property='firstName']>input")    WebElement firstNameBox;
    @FindBy(css="[property='firstName']>input")    List<WebElement> firstName;
    @FindBy(css="[property='displayDob'] .invalid-feedback")    WebElement ageErrorMsg;
    @FindBy(css="div.red-required") WebElement deactivatedUserErrorMsg;

    //------------------------------------------------------------------------------------------------------------------
    public void checkUserAgreementCheckbox(){
        long start = System.currentTimeMillis();
        do{
            getUserAgreementCheckbox().click();
        }while(!getUserAgreementCheckbox().isSelected() && (System.currentTimeMillis() - start) < 5000);
    }

    private void enterDob(String dob, Boolean lessThanMinLength) {
        dob = formatAccountDob(dob, "MM/dd/yyyy");
        dob = ( lessThanMinLength ? dob.substring(0, ( dob.length()-1 )): dob  );
        getBirthDateBox().sendKeys(dob);
    }

    private void enterFirstName(String firstName, Boolean lessThanMinLength){
        firstName = ( lessThanMinLength ? "" : firstName );
        getFirstNameBox().sendKeys(firstName);
    }

    private void enterInvalidCharacters(){
        getFirstNameBox().sendKeys("1234567890");
        getLastNameBox().sendKeys("1234567890");
        do {
            getBirthDateBox().sendKeys(Keys.chord(Keys.CONTROL, "A", Keys.DELETE));
            getBirthDateBox().sendKeys("11111111");
        }while (!getBirthDateBox().getAttribute("value").contentEquals("11/11/1111"));
        getSSNBox().sendKeys("a$)*");
        getMemberIDBox().sendKeys("zb&^%$#");
    }

    public KPAUIOnBoardingInformationPage enterInvalidValuesAndSubmit(){
        enterInvalidCharacters();
        getUserAgreementCheckbox().click();
        getNextButton().click();
        return new KPAUIOnBoardingInformationPage(driver);
    }

    public KPAUIOnBoardingInformationPage enterLessThanMinLengthInfoAndSubmit(KPAUIAccount account){
        enterYourInformation(account, true);
        getUserAgreementCheckbox().click();
        getNextButton().click();
        return new KPAUIOnBoardingInformationPage(driver);
    }

    private void enterMemberID(String memberId, Boolean lessThanMinLength){
        memberId = ( lessThanMinLength ? "" : memberId );
        getMemberIDBox().sendKeys(memberId);
    }

    private void enterLastName(String lastName, Boolean lessThanMinLength){
        lastName = ( lessThanMinLength ? "" : lastName );
        getLastNameBox().sendKeys(lastName);
    }

    private void enterSSN(String ssn, Boolean validValues){
        ssn = ( validValues ? ssn.substring(0, ( ssn.length()-1 )) : ssn  );
        getSSNBox().sendKeys(ssn);
    }

    public KPAUIOnBoardingInformationPage enterYourFutureDOBAndSubmit(KPAUIAccount account){
        enterYourInformation(account, false);
        clearField(getBirthDateBox());
        getBirthDateBox().sendKeys(Keys.chord("01012030"));
        do{
            getUserAgreementCheckbox().click();
        }while((!getUserAgreementCheckbox().isSelected()));
        getNextButton().click();
        return new KPAUIOnBoardingInformationPage(driver);
    }

    private void enterYourInformation(KPAUIAccount account, Boolean lessThanMinLength){
        enterFirstName(account.getFirst(), lessThanMinLength);
        enterLastName(account.getLast(), lessThanMinLength);
        enterDob(account.getDOB(), lessThanMinLength);
        enterMemberID(account.getID(), lessThanMinLength);
        enterSSN(account.getSSN(), lessThanMinLength);
    }

    public KPAUIOnBoardingAccountPage enterYourInfoExceptSsnAndSubmit(KPAUIAccount account){
        enterYourInformation(account, false);
        clearField(getSSNBox());
        checkUserAgreementCheckbox();
        getNextButton().click();
        return new KPAUIOnBoardingAccountPage(driver, true);
    }

    public KPAUIOnBoardingInformationPage enterYourInfoExceptUserAgreementAndSubmit(KPAUIAccount account){
        enterYourInformation(account, false);
        getNextButton().click();
        return new KPAUIOnBoardingInformationPage(driver);
    }

    public KPAUIOnBoardingInformationPage enterYourInformationInvalidUserAndSubmit(KPAUIAccount account){
        enterYourInformation(account, false);
        checkUserAgreementCheckbox();
        getNextButton().click();
        return new KPAUIOnBoardingInformationPage(driver);
    }

    public KPAUIOnBoardingAccountPage enterYourInformationAndSubmit(KPAUIAccount account) {
        enterYourInformation(account, false);
        getUserAgreementCheckbox().click();
        getNextButton().click();
        return new KPAUIOnBoardingAccountPage(driver, false);
    }

    public String getAgeErrorMsg(){
        return ageErrorMsg.getText();
    }

    public String getDeactivatedUserErrorMsg(){
        return deactivatedUserErrorMsg.getText();
    }

    private WebElement getFirstNameBox() {
        return waitForElementToBeClickable(firstNameBox, driver);
    }

    public String getFirstNameErrorMsg(){
        return driver.findElement(By.cssSelector(".col-12:first-child .invalid-feedback")).getText();
    }

    public String getInvalidAccountErrorMsg(){
        return driver.findElement(By.cssSelector("div.red-required")).getText();
    }

    private WebElement getLastNameBox() {
        return waitForElement(driver.findElement(By.cssSelector("[property='lastName']>input")), driver);
    }

    public String getLastNameErrorMsg(){
        return driver.findElement(By.cssSelector(".col-12:nth-child(2) .invalid-feedback")).getText();
    }

    private WebElement getBirthDateBox() {
        return waitForElement(driver.findElement(By.cssSelector("[placeholder='mm/dd/yyyy']")), driver);
    }

    public String getBirthDateErrorMsg(){
        return driver.findElement(By.cssSelector(".col-12:nth-child(3) .invalid-feedback")).getText();
    }

    private WebElement getSSNBox() {
        return waitForElement(driver.findElement(By.cssSelector("[property='ssn']>input")), driver);
    }

    public String getSSNErrorMsg(){
        return waitForElement(driver.findElement(By.cssSelector(".col-12:nth-child(5) .invalid-feedback")),
                driver).getText();
    }

    private WebElement getMemberIDBox() {
        return waitForElement(driver.findElement(By.cssSelector("[property='memberId']>input")), driver);
    }

    public String getMemberIDErrorMsg(){
        return driver.findElement(By.cssSelector(".col-12:nth-child(4) .invalid-feedback")).getText();
    }

    private WebElement getUserAgreementCheckbox(){
        return waitForElement(driver.findElement(By.cssSelector(".onboarding-agreement>core-checkbox .form-check-input")),
                driver);
    }

    public String getUserAgreementUnreadErrorMsg(){
        return driver.findElement(By.cssSelector(".col-12>core-checkbox .invalid-feedback")).getText();
    }

    public String getUserRegisteredErrorMsg(){
        return driver.findElement(By.cssSelector(".red-required.onboarding-error")).getText();
    }

    public Boolean isFormCleared(){
        Boolean isCleared = true;
        if( !getFirstNameBox().getText().isEmpty() ){
            System.out.println("Field is not empty: FirstName");
            isCleared = false;
        }
        if( !getLastNameBox().getText().isEmpty() ){
            System.out.println("Field is not empty: LastName");
            isCleared = false;
        }
        if( !getBirthDateBox().getAttribute("value").isEmpty() ){
            System.out.println("Field is not empty: Birth Date");
            isCleared = false;
        }
        if( !getMemberIDBox().getText().isEmpty() ){
            System.out.println("Field is not empty: MemberID");
            isCleared = false;
        }
        if( !getSSNBox().getText().isEmpty() ){
            System.out.println("Field is not empty: SSN");
            isCleared = false;
        }
        if( getUserAgreementCheckbox().isSelected() ){
            System.out.println("Field is not empty: User Agreement");
            isCleared = false;
        }
        return isCleared;
    }

    public KPAUIMemberIDHelpShade openMemberIdHelpShade(){
        driver.findElement(By.linkText("Where can I find my member ID?")).click();
        return new KPAUIMemberIDHelpShade(driver);
    }

    public KPAUITermsOfUsePage openTermsOfUsePage(){
        driver.findElement(By.linkText("Terms of Use")).click();
        WebDriver drv = getChildDriver(driver);
        return new KPAUITermsOfUsePage(drv);
    }

    public KPAUIWhyIsNeededHelpShade openWhyIsNeededShade(){
        driver.findElement(By.linkText("Why is this needed?")).click();
        return new KPAUIWhyIsNeededHelpShade(driver);
    }
}