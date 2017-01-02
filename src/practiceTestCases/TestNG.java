package practiceTestCases;


import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class TestNG {

    public WebDriver driver;


    @Test

    public void main() {


        driver.findElement(By.cssSelector(".action-close")).click();
        WebDriverWait wait1 = new WebDriverWait(driver, 10);
        wait1.until(ExpectedConditions.invisibilityOfElementLocated(By.id("iwd-newsletterpopup-wrapper")));


        driver.findElement(By.cssSelector(".authorization-link>a")).click();
        driver.findElement(By.id("email")).sendKeys("remishevskiy@ex.ua");
        driver.findElement(By.id("pass")).sendKeys("gold89_18745120");
        driver.findElement(By.id("send2")).click();
        driver.get("http://dev.m2ce.deviwd.com/impulse-duffle.html");
        driver.findElement(By.id("product-addtocart-button")).click();


        driver.get("http://dev.m2ce.deviwd.com/checkout");

        WebDriverWait wait2 = new WebDriverWait(driver, 15);
        try {
            wait2.until(ExpectedConditions.visibilityOfElementLocated(By.id("checkout-loader")));
            wait2.until(ExpectedConditions.invisibilityOfElementLocated(By.id("checkout-loader")));

        } catch (TimeoutException e) {
            System.out.println(1);
        }
        driver.findElement(By.id("s_method_freeshipping_freeshipping")).click();


        WebDriverWait wait3 = new WebDriverWait(driver, 15);
        wait3.until(ExpectedConditions.invisibilityOfElementLocated(By.id("checkout-loader")));
        driver.findElement(By.xpath("//span[contains(.,'Check / Money order')]")).click();
        driver.findElement(By.cssSelector("#agreement_1")).click();
        driver.findElement(By.cssSelector("._active .action.primary.checkout")).click();

        wait2.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".order-number>strong")));
        String order = driver.findElement(By.cssSelector(".order-number>strong")).getText();
        System.out.println(order);

        // Find the element that's ID attribute is 'account'(My Account)

        /*driver.findElement(By.id("account")).click();

        // Find the element that's ID attribute is 'log' (Username)

        // Enter Username on the element found by above desc.

        driver.findElement(By.id("log")).sendKeys("testuser_1");

        // Find the element that's ID attribute is 'pwd' (Password)

        // Enter Password on the element found by the above desc.

        driver.findElement(By.id("pwd")).sendKeys("Test@123");

        // Now submit the form. WebDriver will find the form for us from the element

        driver.findElement(By.id("login")).click();
*/
        // Print a Log In message to the screen

        System.out.println(" Login Successfully, now it is the time to Log Off buddy.");

        // Find the element that's ID attribute is 'account_logout' (Log Out)

       /* driver.findElement(By.id("account_logout"));*/

    }

    @BeforeMethod

    public void beforeMethod() {

        // Create a new instance of the Firefox driver

        driver = new FirefoxDriver();

        //Put a Implicit wait, this means that any search for elements on the page could take the time the implicit wait is set for before throwing exception

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //Launch the Online Store Website

        driver.get("http://dev.m2ce.deviwd.com/");

    }

    @AfterMethod

    public void afterMethod() {

        // Close the driver

        driver.quit();

    }

}
