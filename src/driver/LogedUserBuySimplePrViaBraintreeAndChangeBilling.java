package driver;

        import java.util.concurrent.TimeUnit;
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

public class LogedUserBuySimplePrViaBraintreeAndChangeBilling {

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
        driver.findElement(By.id("product-addtocart-button")).click();

        driver.get("http://dev.m2ce.deviwd.com/checkout");

        WebDriverWait wait2 = new WebDriverWait(driver, 15);
        try{
            wait2.until(ExpectedConditions.visibilityOfElementLocated(By.id("checkout-loader")));
            wait2.until(ExpectedConditions.invisibilityOfElementLocated(By.id("checkout-loader")));

        }catch (TimeoutException e) {
            System.out.println(1);
        }

        driver.findElement(By.id("label_method_2DA_ups")).click();

        try{
            wait2.until(ExpectedConditions.visibilityOfElementLocated(By.id("checkout-loader")));
            wait2.until(ExpectedConditions.invisibilityOfElementLocated(By.id("checkout-loader")));

        }catch (TimeoutException e) {
            System.out.println(2);
        }

        //Braintree payment

        driver.findElement(By.xpath("//span[contains(.,'Credit Card (Braintree)')]")).click();
        driver.findElement(By.id("billing-address-same-as-shipping-braintree")).click();

    /*Change billing address*/
        Select SelectNewAdress = new Select(driver.findElement(By.cssSelector("div[class='payment-method payment-method-braintree _active'] div[class='control'] .select[name=billing_address_id]")));
        SelectNewAdress.selectByVisibleText("New Address");
        driver.findElement(By.cssSelector("div[class='payment-method payment-method-braintree _active'] div[class='control'] .input-text[name='firstname']")).sendKeys("Tadeush");
        driver.findElement(By.cssSelector("div[class='payment-method payment-method-braintree _active'] div[class='control'] .input-text[name='lastname']")).sendKeys("Borowskiy");
        driver.findElement(By.cssSelector("div[class='payment-method payment-method-braintree _active'] div[class='control'] .input-text[name='street[0]']")).sendKeys("8104 E Nora Ave");
        driver.findElement(By.cssSelector("div[class='payment-method payment-method-braintree _active'] div[class='control'] .input-text[name='city']")).sendKeys("SPOKANE");
        Select SelectNewRegion = new Select(driver.findElement(By.cssSelector("div[class='payment-method payment-method-braintree _active'] div[class='control'] .select[name=region_id]")));
        SelectNewRegion.selectByVisibleText("Washington");

        driver.findElement(By.cssSelector("div[class='payment-method payment-method-braintree _active'] div[class='control'] .input-text[name='postcode']")).sendKeys("99212");
        driver.findElement(By.cssSelector("div[class='payment-method payment-method-braintree _active'] div[class='control _with-tooltip'] .input-text[name='telephone']")).sendKeys("509-924-6673");
        driver.findElement(By.cssSelector("div[class='payment-method payment-method-braintree _active'] div[class='field choice'] #braintree_vault_enabler")).click();
        driver.findElement(By.cssSelector("div[class='payment-method payment-method-braintree _active'] div[class='primary'] .action.action-update")).click();

    /*BrainTree*/
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
        driver.findElement(By.id("braintree_vault_enabler")).click();

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