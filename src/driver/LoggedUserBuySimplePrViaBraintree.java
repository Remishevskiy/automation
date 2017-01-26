package driver;


        import java.util.concurrent.TimeUnit;
        import driver.pageObjectsCheckout.CheckoutPage;
        import driver.pageObjectsCheckout.Global_var;
        import org.openqa.selenium.By;
        import org.openqa.selenium.TimeoutException;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.firefox.FirefoxDriver;
        import org.openqa.selenium.support.ui.ExpectedConditions;
        import org.openqa.selenium.support.ui.WebDriverWait;
        import org.testng.annotations.Test;
        import org.testng.annotations.BeforeMethod;
        import org.testng.annotations.AfterMethod;

public class LoggedUserBuySimplePrViaBraintree {

    public WebDriver driver;

    @BeforeMethod

    public void beforeMethod() {

        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(Global_var.URL_MainWebSite);
        driver.manage().window().maximize();

    }
    @Test

    public void main() throws InterruptedException {

        driver.findElement(By.cssSelector(".action-close")).click();
        WebDriverWait wait1 = new WebDriverWait(driver, 10);
        wait1.until(ExpectedConditions.invisibilityOfElementLocated(By.id("iwd-newsletterpopup-wrapper")));

        driver.findElement(By.cssSelector(".authorization-link>a")).click();
        driver.findElement(By.id("email")).sendKeys(Global_var.Login);
        driver.findElement(By.id("pass")).sendKeys(Global_var.Password);
        driver.findElement(By.id("send2")).click();
        driver.get("http://dev.m2ce.deviwd.com/impulse-duffle.html");
        driver.findElement(By.id("product-addtocart-button")).click();

        driver.get(Global_var.URL_Checkout);

        WebDriverWait wait2 = new WebDriverWait(driver, 15);

        try {
            wait2.until(ExpectedConditions.visibilityOf(CheckoutPage.Checkout_loader(driver)));
            int k = 0;

            while (CheckoutPage.Checkout_loader(driver).isDisplayed() && k < 30){
                System.out.println(CheckoutPage.Checkout_loader(driver).isDisplayed());
                Thread.sleep(500);
                k = k + 1;
            }
        } catch (org.openqa.selenium.NoSuchElementException | TimeoutException e) {
            System.out.println(1);
        }

        CheckoutPage.Tablerate_Bestway(driver).click();

        try {
            wait2.until(ExpectedConditions.visibilityOf(CheckoutPage.Checkout_loader(driver)));
            int l = 0;
            while (CheckoutPage.Checkout_loader(driver).isDisplayed() && l < 30){
                System.out.println(CheckoutPage.Checkout_loader(driver).isDisplayed());
                Thread.sleep(500);
                l = l + 1;
            }
        } catch (org.openqa.selenium.NoSuchElementException | TimeoutException e) {
            System.out.println(2);
        }

        //Braintree payment

        driver.findElement(By.xpath("//span[contains(.,'Credit Card (Braintree)')]")).click();
        driver.switchTo().frame(driver.findElement(By.id("braintree-hosted-field-number")));
        driver.findElement(By.id("credit-card-number")).sendKeys("4111111111111111");
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
    }


    @AfterMethod

    public void afterMethod() {

        driver.quit();

    }

}
