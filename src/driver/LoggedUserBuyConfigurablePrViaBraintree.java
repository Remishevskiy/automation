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

public class LoggedUserBuyConfigurablePrViaBraintree {

    public WebDriver driver;

    @BeforeMethod

    public void beforeMethod() {


        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://dev.m2ce.deviwd.com/");
        driver.manage().window().maximize();

    }
    @Test

    public void main() throws InterruptedException {

        driver.findElement(By.cssSelector(".action-close")).click();
        WebDriverWait wait1 = new WebDriverWait(driver, 15);
        wait1.until(ExpectedConditions.invisibilityOfElementLocated(By.id("iwd-newsletterpopup-wrapper")));

        driver.findElement(By.cssSelector(".authorization-link>a")).click();
        driver.findElement(By.id("email")).sendKeys("remishevskiy@ex.ua");
        driver.findElement(By.id("pass")).sendKeys("gold89_18745120");
        driver.findElement(By.id("send2")).click();
        driver.get("https://dev.m2ce.deviwd.com/ana-running-short.html");

        driver.findElement(By.cssSelector(".swatch-option.color[option-id='59']")).click();
        driver.findElement(By.cssSelector(".swatch-option.text[option-id='172']")).click();



            /*ProductDesigner*/
    /*driver.findElement(By.cssSelector(".fpd-add-text.fpd-btn-raised.fpd-secondary-bg-color.fpd-secondary-text-color>span")).click();
    wait1.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".modal-body>textarea")));
    driver.findElement(By.cssSelector(".modal-body>textarea")).sendKeys("Automation Test");
    driver.findElement(By.cssSelector(".btn.action.primary.iwdpd-add-text-btn")).click();
    wait1.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".modal-body>textarea")));*/
    /*wait1.until(ExpectedConditions.elementToBeClickable(By.id("product-addtocart-button")));*/
        driver.findElement(By.id("product-addtocart-button")).click();

        driver.get("http://dev.m2ce.deviwd.com/checkout");

        WebDriverWait wait2 = new WebDriverWait(driver, 15);
        try {
            wait1.until(ExpectedConditions.visibilityOf(CheckoutPage.Checkout_loader(driver)));
            int k = 0;
            while (CheckoutPage.Checkout_loader(driver).isDisplayed() && k < 30){
                System.out.println(CheckoutPage.Checkout_loader(driver).isDisplayed());
                Thread.sleep(500);
                k = k + 1;
            }
        } catch (org.openqa.selenium.NoSuchElementException | TimeoutException e) {
            System.out.println(1);
        }

        //Braintree payment
        CheckoutPage.UPS_NextDayAir(driver).click();

        //driver.findElement(By.id("label_method_1DP_ups")).click();
        try {
            wait1.until(ExpectedConditions.visibilityOf(CheckoutPage.Checkout_loader(driver)));
            int k = 0;
            while (CheckoutPage.Checkout_loader(driver).isDisplayed() && k < 30){
                System.out.println(CheckoutPage.Checkout_loader(driver).isDisplayed());
                Thread.sleep(500);
                k = k + 1;
            }
        } catch (org.openqa.selenium.NoSuchElementException | TimeoutException e) {
            System.out.println(1);
        }
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

        }


    @AfterMethod

    public void afterMethod() {

        driver.quit();

    }

}