package driver;


        import java.util.concurrent.TimeUnit;

        import driver.pageObjectsCheckout.CheckoutPage;
        import org.openqa.selenium.By;
        import org.openqa.selenium.TimeoutException;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.firefox.FirefoxDriver;
        import org.openqa.selenium.support.ui.ExpectedConditions;
        import org.openqa.selenium.support.ui.WebDriverWait;
        import org.testng.annotations.Test;
        import org.testng.annotations.BeforeMethod;
        import org.testng.annotations.AfterMethod;

public class LoggedUserBuyGroupedPrViaBraintree {

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
        driver.get("https://dev.m2ce.deviwd.com/set-of-sprite-yoga-straps-1.html");
       /* driver.findElement(By.xpath("//input[@name='super_group[33]']")).sendKeys("1");
        driver.findElement(By.xpath("//input[@name='super_group[34]']")).sendKeys("1");
        driver.findElement(By.xpath("//input[@name='super_group[35]']")).sendKeys("1");*/
        driver.findElement(By.id("product-addtocart-button")).click();

        driver.get("http://dev.m2ce.deviwd.com/checkout");

        WebDriverWait wait2 = new WebDriverWait(driver, 15);
        try{
            wait2.until(ExpectedConditions.visibilityOfElementLocated(By.id("checkout-loader")));
            wait2.until(ExpectedConditions.invisibilityOfElementLocated(By.id("checkout-loader")));

        }catch (TimeoutException e) {
            System.out.println(1);
        }

        //Braintree payment
        CheckoutPage.UPS_NextDayAirEarlyAM(driver).click();
        //driver.findElement(By.id("label_method_1DM_ups")).click();
        try{
            wait2.until(ExpectedConditions.visibilityOfElementLocated(By.id("checkout-loader")));
            wait2.until(ExpectedConditions.invisibilityOfElementLocated(By.id("checkout-loader")));

        }catch (TimeoutException e) {
            System.out.println(2);
            driver.findElement(By.xpath("//span[contains(.,'Credit Card (Braintree)')]")).click();

            driver.switchTo().frame(driver.findElement(By.id("braintree-hosted-field-number")));
            driver.findElement(By.id("credit-card-number")).sendKeys("5555555555554444");
            driver.switchTo().defaultContent();
            driver.switchTo().frame(driver.findElement(By.id("braintree-hosted-field-expirationMonth")));
            driver.findElement(By.id("expiration-month")).sendKeys("12");
            driver.switchTo().defaultContent();
            driver.switchTo().frame(driver.findElement(By.id("braintree-hosted-field-expirationYear")));
            driver.findElement(By.id("expiration-year")).sendKeys("20");
            driver.switchTo().defaultContent();
            driver.switchTo().frame(driver.findElement(By.id("braintree-hosted-field-cvv")));
            driver.findElement(By.id("cvv")).sendKeys("111");
            driver.switchTo().defaultContent();
            driver.findElement(By.id("braintree_enable_vault")).click();

            driver.findElement(By.cssSelector("#agreement_1")).click();

            driver.findElement(By.cssSelector(".iwd-place-order-button")).click();


            wait2.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".order-number>strong")));
            String order = driver.findElement(By.cssSelector(".order-number>strong")).getText();
            System.out.println(order);

    }}


    @AfterMethod

    public void afterMethod() {

        driver.quit();

    }

}
