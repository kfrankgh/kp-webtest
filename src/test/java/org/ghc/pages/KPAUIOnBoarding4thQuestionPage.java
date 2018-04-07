package org.ghc.pages;

import org.ghc.utils.extensions.KPAUIEveryOnBoardingPage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.List;

import static org.ghc.utils.KPAUIPageConstants.OnBoardingPages.SvaQuizPage.*;
import static org.ghc.utils.helpers.KPAUITestHelper.ifAlertThenCloseAlert;
import static org.ghc.utils.helpers.KPAUITestHelper.waitForElementToBeClickable;
import static org.testng.Assert.fail;

public class KPAUIOnBoarding4thQuestionPage extends KPAUIEveryOnBoardingPage {

    public KPAUIOnBoarding4thQuestionPage(WebDriver driver) {
        super(driver);
        if(!isCurrent()){
            fail("The Member Registration - 4th SVA Question page did not load correctly");
        }
    }

    //------------------------------------------------------------------------------------------------------------------
@FindBy(css=svaRightAnswer1)    private List<WebElement> svaRightAnswr1;

    public KPAUIOnBoardingWelcomePage answer4thQuestionCorrectly() {
        selectAnswer(svaRightAnswer4);
        waitForElementToBeClickable(getNextButton(), driver).click();
        waitForNextPage();
        return new KPAUIOnBoardingWelcomePage(driver);
    }

    public KPAUIOnBoardingVerifyIdPage answer4thQuestionIncorrectly() {
        selectAnswer(svaWrongAnswer4);
        waitForElementToBeClickable(getNextButton(), driver).click();
        waitForNextPage();
        return new KPAUIOnBoardingVerifyIdPage(driver);
    }

    /** Click on the Cancel Button
     * @return KPAUIOnBoardingVerifyIdPage
     */
    public KPAUIOnBoardingVerifyIdPage clickCancelButton() {
        getCancelButton().click();
        ifAlertThenCloseAlert();
        return new KPAUIOnBoardingVerifyIdPage(driver);
    }

    private boolean isCurrent(){
        return ( svaRightAnswr1.size() > 0 );
    }

    private boolean isNextPageDisplayed(){
        return ( svaRightAnswr1.size() == 0 );
    }

    private void selectAnswer(String quizAnswerRadio){
        driver.findElement(By.cssSelector(quizAnswerRadio)).click();
    }

    /*
        Workaround when clicking the Next button does not advance to the Thank You Page
     */
    private void waitForNextPage(){
        long start = System.currentTimeMillis();
        do{
            if(isNextPageDisplayed()) {
                break;
            }
            else{
                try {
                    getNextButton().click();
                }catch(AssertionError e){
                    System.out.println("Next button not clickable");
                }catch(NoSuchElementException e){
                    System.out.println("Next button not found");
                }
            }
        }while(( System.currentTimeMillis() - start ) < 5000 );
    }
}