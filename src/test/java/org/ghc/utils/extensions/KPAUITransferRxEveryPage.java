package org.ghc.utils.extensions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.ghc.utils.helpers.KPAUITestHelper.waitForElement;

public class KPAUITransferRxEveryPage extends KPAUIEveryAuthenticatedPage {

    public KPAUITransferRxEveryPage(WebDriver driver) {
        super(driver);
    }

//------------------------------------------------------------------------------------------------------------------

    // Finders
    @FindBy(css = "li.current")                                         private WebElement activeStep;
    @FindBy(xpath = "//kp-transfer-prescription-info/div[1]/div")       private WebElement prescriptionTransferRequestHeader;
    @FindBy(xpath = "//kp-progress-nav/div/ul")                         private WebElement progressNavList;
    @FindBy(xpath = "//li[1]/img")                                      private WebElement step1DoneCheckMark;
    @FindBy(xpath = "//kp-progress-nav/div/ul/li[2]")                   private WebElement step2;
    @FindBy(xpath = "//li[2]/img")                                      private WebElement step2DoneCheckMark;
    @FindBy(xpath = "//kp-progress-nav/div/ul/li[3]")                   private WebElement step3;
    @FindBy(xpath = "//li[3]/img")                                      private WebElement step3DoneCheckMark;
    @FindBy(xpath = "//kp-progress-nav/div/ul/li[4]")                   private WebElement step4;

    // Getters
    public WebElement getActiveStep()                           { return waitForElement(activeStep, driver); }
    public WebElement getPrescriptionTransferRequestHeader()    { return waitForElement(prescriptionTransferRequestHeader, driver); }
    public WebElement getProgressNavList()                      { return waitForElement(progressNavList, driver); }
    public WebElement getStep1DoneCheckMark()                   { return waitForElement(step1DoneCheckMark,driver); }
    public WebElement getStep2()                                { return waitForElement(step2, driver); }
    public WebElement getStep2DoneCheckMark()                   { return waitForElement(step2DoneCheckMark, driver); }
    public WebElement getStep3()                                { return waitForElement(step3, driver); }
    protected WebElement getStep3DoneCheckMark()                { return waitForElement(step3DoneCheckMark, driver); }
    public WebElement getStep4()                                { return waitForElement(step4, driver); }
}