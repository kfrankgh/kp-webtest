package org.ghc.utils.helpers;

import org.openqa.selenium.*;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.*;

import static org.ghc.utils.KPAIUTestConstants.attributes.hrefAttribute;
import static org.ghc.utils.KPAIUTestConstants.logging.*;
import static org.ghc.utils.extensions.KPAUIEveryPage.driver;
import static org.testng.Assert.fail;

public class KPAUITestHelper {

    public static void assertContains (String input, String contains){
        if (!input.contains(contains))
            fail(String.format("The Phrase: '%s' was not found in: '%s'", contains, input));
    }

    public static void assertMatches (String input, String regex){
        if (!input.matches(regex))
            fail(String.format("The Regex: '%s' did not return a match in: '%s'", regex, input));
    }

    public static void assertEqualsInsensitive (String input1, String input2){
        if (!input1.toLowerCase().equals(input2.toLowerCase()))
            fail(String.format("The Phrase: '%s' does not equal the phrase: '%s'", input1, input2));
    }

    public static void clearField(WebElement element){
        element.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
    }

    public static String errorMsg(String expected, String actual) {
        return (String.format("expected '%s' but found '%s'.", expected, actual));
    }

    public static WebDriver getChildDriver(WebDriver driver) {
        String subWindowHandler = null;
        Set<String> handles;
        long start = System.currentTimeMillis();
        do{
            handles = driver.getWindowHandles();
        }while(handles.size() == 1 && (System.currentTimeMillis() - start) < 5000);

        Iterator<String> iterator = handles.iterator();
        while (iterator.hasNext()){
            subWindowHandler = iterator.next();
        }
        return driver.switchTo().window(subWindowHandler);
    }

    /**
     * @return true if alert found, else false
     */
    public static boolean ifAlertThenCloseAlert(){
        try{
            WebDriverWait wait = new WebDriverWait(driver, 5);
            wait.until(ExpectedConditions.alertIsPresent());
            driver.switchTo().alert().accept();
        }catch(TimeoutException e){
            System.out.println("Failed to Find Alert.");
            return false;
        }
        return true;
    }

    public static boolean isValidLink(WebElement link, KPAUILink expected){
        String linkDisplayed = link.getAttribute(hrefAttribute);
        System.out.println("Link Displayed:\t\t\t" + linkDisplayed);
        System.out.println("Link Expected:\t\t\t" + expected.getDestination());
        System.out.println("Link Matches:\t\t\t" + linkDisplayed.matches(expected.getDestination()));
        System.out.println("Text Displayed:\t\t\t" + link.getText());
        System.out.println("Text Expected:\t\t\t" + expected.getText());
        System.out.println("Text Matches:\t\t\t" + link.getText().contentEquals(expected.getText()));
        System.out.println("ToLow Matches:\t\t\t" + link.getText().toLowerCase().equals(expected.getText().toLowerCase()));
        System.out.println("--------------------------------------------");

        return linkDisplayed.matches(expected.getDestination()) &&
                link.getText().toLowerCase().equals(expected.getText().toLowerCase());
    }

    /**
     * @param title
     * @return
     */
    public static ExpectedCondition<Boolean> titleContainsCaseInsensitive(final String title) {
        return new ExpectedCondition<Boolean>() {
            private String currentTitle = "";

            @Override
            public Boolean apply(WebDriver driver) {
                currentTitle = driver.getTitle();
                return currentTitle.toLowerCase().contains(title.toLowerCase());
            }

            @Override
            public String toString() {
                return String.format("title to contain \"%s\". Current title: \"%s\"", title, currentTitle);
            }
        };
    }

    public static void clickElement(WebElement ele){
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ele);
        sleep(1);
        Actions actions = new Actions(driver);
        actions.moveToElement(ele).perform();
        actions.click().perform();
    }

    public static void sleep(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (Exception ex){
            fail("Failed to Sleep");
        }
    }

    public static WebElement waitForElement(WebElement element, WebDriver driver){
        WebDriverWait wait = new WebDriverWait(driver, 5);
        try {
            System.out.printf("Waiting For Element:\t\t%s\n", element.getText());
            wait.until(ExpectedConditions.visibilityOf(element));
        } catch (Exception ex) {
            System.out.printf("Element Not Displayed:\t%s\n", element.getText());
            fail(String.format("Element Failed to Display:\t%s", driver.getTitle()));
        }
        System.out.printf(elementDisplayed, element.getText());
        return element;
    }

    public static WebElement waitForElementToBeClickable(WebElement element, WebDriver driver){
        WebDriverWait wait = new WebDriverWait(driver, 20);
        try {
            System.out.printf("Waiting For Clickable:\t\t%s\n", element.getText());
            wait.until(ExpectedConditions.elementToBeClickable(element));
        } catch (Exception ex) {
            System.out.printf("Element Not Clickable:\t%s\n", element.getText());
            fail(String.format("Clickable Element Failed on Page:\t%s", driver.getTitle()));
        }
        System.out.printf(elementClickable, element.getText());
        return element;
    }

    public static WebElement waitForElementToBeVisible(By by, WebDriver driver){
        WebDriverWait wait = new WebDriverWait(driver, 5);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }
}
