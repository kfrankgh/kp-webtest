package org.ghc.pages;

import org.ghc.utils.extensions.KPAUIEveryOnBoardingPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.ghc.utils.KPAUIPageConstants.OnBoardingPages.SvaQuizPage.*;
import static org.ghc.utils.helpers.KPAUITestHelper.*;
import static org.testng.Assert.fail;

public class KPAUIOnBoardingSvaQuizPage extends KPAUIEveryOnBoardingPage {

    public KPAUIOnBoardingSvaQuizPage(WebDriver driver) {
        super(driver);
        if(!isCurrent()){
            fail("The Member Registration - Sva Quiz page did not load correctly");
        }
    }

    //------------------------------------------------------------------------------------------------------------------


   public KPAUIOnBoardingWelcomePage answerQuizCorrectly() {
        selectAnswer(svaRightAnswer1);
        selectAnswer(svaRightAnswer2);
        selectAnswer(svaRightAnswer3);
        waitForElementToBeClickable(getNextButton(), driver).click();
        waitForNextPage();
        return new KPAUIOnBoardingWelcomePage(driver);
    }

    public KPAUIOnBoarding4thQuestionPage answerOneQuizQuestionIncorrectly(String answer1, String answer2, String answer3) {
        selectAnswer(answer1);
        selectAnswer(answer2);
        selectAnswer(answer3);
        waitForElementToBeClickable(getNextButton(), driver).click();
        waitForNextPage();
        return new KPAUIOnBoarding4thQuestionPage(driver);
    }

    /*
        Answers the SVA Quiz and goes to the VerifyId page. This applies when more than
        one answer is incorrect
     */
    public KPAUIOnBoardingVerifyIdPage answerQuiz(String answer1, String answer2, String answer3) {
        selectAnswer(answer1);
        selectAnswer(answer2);
        selectAnswer(answer3);
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
        return ( driver.findElements(By.cssSelector(svaRightAnswer1)).size() > 0 );
    }

    private boolean isNextPageDisplayed(){
        return (driver.findElements(By.linkText(svaRightAnswer1)).size() == 0);
    }

    private void selectAnswer(String quizAnswerRadio){
        waitForElementToBeClickable(driver.findElement(By.cssSelector(quizAnswerRadio)), driver).click();
    }

    /*
        Workaround when clicking the Next button does not advance to the Verify Your ID Page or 4th SVA Question page
     */
    private void waitForNextPage(){
        long start = System.currentTimeMillis();
        do{
            if(isNextPageDisplayed()) {
                break;
            }
            else{
                getNextButton().click();
            }
        }while(( System.currentTimeMillis() - start ) < 5000 );
    }
}