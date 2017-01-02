package driver;


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

public class LogedUserChangeAddress {

    public WebDriver driver;

    @BeforeMethod

    public void beforeMethod() {

        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://dev.m2ce.deviwd.com/");
        driver.manage().window().maximize();

    }
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
        driver.findElement(By.xpath("./*//*[@id='product-addtocart-button']")).click();

        driver.get("http://dev.m2ce.deviwd.com/checkout");

        WebDriverWait wait2 = new WebDriverWait(driver, 10);
        wait2.until(ExpectedConditions.invisibilityOfElementLocated(By.id("checkout-loader")));
        driver.findElement(By.cssSelector(".iwd-not-selected-item:nth-of-type(2)")).click();

        WebDriverWait wait3 = new WebDriverWait(driver, 10);
        wait3.until(ExpectedConditions.invisibilityOfElementLocated(By.id("checkout-loader")));
        driver.findElement(By.id("s_method_freeshipping_freeshipping")).click();

        WebDriverWait wait4 = new WebDriverWait(driver, 10);
        wait4.until(ExpectedConditions.invisibilityOfElementLocated(By.id("checkout-loader")));
        driver.findElement(By.xpath("//span[contains(.,'Check / Money order')]")).click();
        driver.findElement(By.cssSelector("#agreement_1")).click();
        driver.findElement(By.cssSelector("._active .action.primary.checkout")).click();

        wait2.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".order-number>strong")));
        String order = driver.findElement(By.cssSelector(".order-number>strong")).getText();
        System.out.println(order);
        }


    @AfterMethod

    public void afterMethod() {

        driver.quit();

    }

}