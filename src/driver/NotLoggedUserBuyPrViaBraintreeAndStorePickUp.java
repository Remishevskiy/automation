package driver;


        import java.util.concurrent.TimeUnit;

        import driver.pageObjectsCheckout.CheckoutPage;
        import org.openqa.selenium.By;
        import org.openqa.selenium.TimeoutException;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.firefox.FirefoxDriver;
        import org.openqa.selenium.support.ui.ExpectedConditions;
        import org.openqa.selenium.support.ui.Select;
        import org.openqa.selenium.support.ui.WebDriverWait;
        import org.testng.annotations.Test;
        import org.testng.annotations.BeforeMethod;
        import org.testng.annotations.AfterMethod;

public class NotLoggedUserBuyPrViaBraintreeAndStorePickUp {

    public WebDriver driver;

    @BeforeMethod

    public void beforeMethod() {


        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://dev.m2ce.deviwd.com/impulse-duffle.html");
        driver.manage().window().maximize();

    }
    @Test

    public void main() throws InterruptedException {

        driver.findElement(By.cssSelector(".action-close")).click();
        WebDriverWait wait1 = new WebDriverWait(driver, 10);
        wait1.until(ExpectedConditions.invisibilityOfElementLocated(By.id("iwd-newsletterpopup-wrapper")));

        driver.findElement(By.id("product-addtocart-button")).click();

        driver.get("http://dev.m2ce.deviwd.com/checkout");
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
        driver.findElement(By.id("customer-email")).sendKeys("test666test@mail.com");

        try {
            wait1.until(ExpectedConditions.visibilityOf(CheckoutPage.Checkout_loader(driver)));
            int k = 0;
            while (CheckoutPage.Checkout_loader(driver).isDisplayed() && k < 30){
                System.out.println(CheckoutPage.Checkout_loader(driver).isDisplayed());
                Thread.sleep(500);
                k = k + 1;
            }
        } catch (org.openqa.selenium.NoSuchElementException | TimeoutException e) {
            System.out.println(2);
        }

        driver.findElement(By.cssSelector("div[id='shipping-new-address-form'] div[class='control'] .input-text[name='firstname']")).sendKeys("Test");
        driver.findElement(By.cssSelector("div[id='shipping-new-address-form'] div[class='control'] .input-text[name='lastname']")).sendKeys("Ignore");
        driver.findElement(By.cssSelector("div[id='shipping-new-address-form'] div[class='control'] .input-text[name='street[0]']")).sendKeys("1978 Lindale Avenue");
        driver.findElement(By.cssSelector("div[id='shipping-new-address-form'] div[class='control'] .input-text[name='city']")).sendKeys("San Francisco");
        Select oSelect = new Select(driver.findElement(By.cssSelector("div[id='shipping-new-address-form'] div[class='control'] .select[name='region_id']")));
        oSelect.selectByVisibleText("California");
        driver.findElement(By.cssSelector("div[id='shipping-new-address-form'] div[class='control'] .input-text[name='postcode']")).sendKeys("94108");
        driver.findElement(By.cssSelector("div[id='shipping-new-address-form'] div[class='control _with-tooltip'] .input-text[name='telephone']")).sendKeys("+1-202-555-0100");

        Select StorePickUp = new Select(CheckoutPage.Store_Pickup(driver));
        StorePickUp.selectByValue("1");

        try {
            wait1.until(ExpectedConditions.visibilityOf(CheckoutPage.Checkout_loader(driver)));
            int k = 0;
            while (CheckoutPage.Checkout_loader(driver).isDisplayed() && k < 30){
                System.out.println(CheckoutPage.Checkout_loader(driver).isDisplayed());
                Thread.sleep(500);
                k = k + 1;
            }
        } catch (org.openqa.selenium.NoSuchElementException | TimeoutException e) {
            System.out.println(3);
        }

        //*BrainTree*//*
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

        driver.findElement(By.cssSelector("#agreement_1")).click();

        driver.findElement(By.cssSelector(".iwd-place-order-button")).click();

        wait1.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".checkout-success>p>span")));
        String order = driver.findElement(By.cssSelector(".checkout-success>p>span")).getText();
        System.out.println(order);
        }


    @AfterMethod

    public void afterMethod() {

        driver.quit();

    }

}