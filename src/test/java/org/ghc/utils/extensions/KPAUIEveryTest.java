package org.ghc.utils.extensions;

import org.ghc.pages.KPAUIUnAuthenticatedHomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import static org.ghc.utils.KPAIUTestConstants.links.*;
import static org.ghc.utils.KPAIUTestConstants.logging.*;
import static org.ghc.utils.helpers.KPAUIStringHelper.getSiteWithPrefix;
import static org.testng.Assert.fail;

public class KPAUIEveryTest {
    protected static WebDriver driver;
    public static final String ENV = System.getProperty("ENV") == null ?
            "QA" : System.getProperty("ENV");
    private static final String driverName = System.getProperty("WEBDRIVER") == null ?
            "chrome" : System.getProperty("WEBDRIVER");

    //------------------------------------------------------------------------------------------------------------------

    public KPAUIUnAuthenticatedHomePage initializeTest(Method method) {
        try {

            switch (driverName) {
                case "ie":
                    driver = new InternetExplorerDriver();
                    break;
                case "firefox":
                    FirefoxOptions options = new FirefoxOptions();
                    options.addPreference("security.sandbox.content.level", 5);
                    driver = new FirefoxDriver(options);
                    break;
                default:
                    driver = new ChromeDriver();
                    break;
            }

        } catch (Exception e) {
            fail("The WebDriver could not be initialized.");
            e.printStackTrace();
        }

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(getSiteWithPrefix(kpWASite));

        System.out.println(String.format(testInformation,
                method.getName(), method.getDeclaringClass().getName(),
                method.getAnnotation(Test.class).description(), ENV, driverName));

        return new KPAUIUnAuthenticatedHomePage(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void afterTest(ITestResult result) {
        String resultStr = result.getStatus() == 1 ? "PASSED" :
                result.getStatus() == 2 ? "FAILED" : "IGNORED";
        System.out.println(String.format(resultInformation, resultStr));

        try {
            driver.close();
            driver.quit();

            if (driver != null) {
                driver.quit();
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
