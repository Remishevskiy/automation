package driver.TestCases;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import driver.appModules.GetScreenShot;
import driver.pageObjectsCheckout.CheckoutPage;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Created by Император on 09.02.2017.
 */
public class IwdAgencyHeader {
    ExtentReports extent;
    ExtentTest test;

    public WebDriver driver;

    @BeforeTest
    public void init()
    {
        extent = new ExtentReports(System.getProperty("user.dir") + "/test-output/ExtentScreenshot.html", true);
    }

    @BeforeMethod

    public void beforeMethod() {


        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.iwdagency.com/");
        driver.manage().window().maximize();

    }
    @Test

    public void main() throws InterruptedException {
        test = extent.startTest("captureScreenshot2");


        Actions actions = new Actions(driver);
        WebElement mainMenu = driver.findElement(By.cssSelector(".build-store-menu a"));
        actions.moveToElement(mainMenu);

        WebElement subMenu = driver.findElement(By.cssSelector("a[href*='http://weeetail.com/']"));
        actions.moveToElement(subMenu);
        actions.click().build().perform();

        test.log(LogStatus.PASS, "Test Passed");
    }}
