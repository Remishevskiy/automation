package driver;


import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class NotLoggedUserBuyPrViaAuthorizeDirectPostAndChangeBilling {

    public WebDriver driver;

    @BeforeMethod

    public void beforeMethod() {


        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://dev.m2ce.deviwd.com/impulse-duffle.html");
        driver.manage().window().maximize();

    }
    @Test

    public void main() {

        driver.findElement(By.cssSelector(".action-close")).click();
        WebDriverWait wait1 = new WebDriverWait(driver, 10);
        wait1.until(ExpectedConditions.invisibilityOfElementLocated(By.id("iwd-newsletterpopup-wrapper")));

        driver.findElement(By.id("product-addtocart-button")).click();

        driver.get("http://dev.m2ce.deviwd.com/checkout");
        try{
            wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("checkout-loader")));
            wait1.until(ExpectedConditions.invisibilityOfElementLocated(By.id("checkout-loader")));

        }catch (TimeoutException e) {
            System.out.println(1);
        }
        driver.findElement(By.id("customer-email")).sendKeys("test666test@mail.com");

        try{
            wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("checkout-loader")));
            wait1.until(ExpectedConditions.invisibilityOfElementLocated(By.id("checkout-loader")));

        }catch (TimeoutException e) {
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

        driver.findElement(By.id("s_method_flatrate_flatrate")).click();

        try{
            wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("checkout-loader")));
            wait1.until(ExpectedConditions.invisibilityOfElementLocated(By.id("checkout-loader")));

        }catch (TimeoutException e) {
            System.out.println(3);
        }

        //AuthorizeDirectPost payment
        driver.findElement(By.xpath("//span[contains(.,'Credit Card Direct Post (Authorize.net)')]")).click();
        driver.findElement(By.id("billing-address-same-as-shipping-authorizenet_directpost")).click();

    /*Change billing address*/
        driver.findElement(By.cssSelector("div[class='payment-method _active'] div[class='control'] .input-text[name='firstname']")).sendKeys("Tadeush");
        driver.findElement(By.cssSelector("div[class='payment-method _active'] div[class='control'] .input-text[name='lastname']")).sendKeys("Borowskiy");
        driver.findElement(By.cssSelector("div[class='payment-method _active'] div[class='control'] .input-text[name='street[0]']")).sendKeys("8104 E Nora Ave");
        driver.findElement(By.cssSelector("div[class='payment-method _active'] div[class='control'] .input-text[name='city']")).sendKeys("SPOKANE");
        Select SelectNewRegion = new Select(driver.findElement(By.cssSelector("div[class='payment-method _active'] div[class='control'] .select[name=region_id]")));
        SelectNewRegion.selectByVisibleText("Washington");

        driver.findElement(By.cssSelector("div[class='payment-method _active'] div[class='control'] .input-text[name='postcode']")).sendKeys("99212");
        driver.findElement(By.cssSelector("div[class='payment-method _active'] div[class='control _with-tooltip'] .input-text[name='telephone']")).sendKeys("509-924-6673");
        driver.findElement(By.cssSelector("div[class='payment-method _active'] div[class='primary'] .action.action-update")).click();

    /*AuthorizeDirectPost*/
        driver.findElement(By.xpath("//span[contains(.,'Credit Card Direct Post (Authorize.net)')]")).click();
        driver.findElement(By.cssSelector("#authorizenet_directpost_cc_number")).sendKeys("4111111111111111");
        Select SelectMonth = new Select(driver.findElement(By.id("authorizenet_directpost_expiration")));
        SelectMonth.selectByValue("9");
        Select SelectYear = new Select(driver.findElement(By.cssSelector("#authorizenet_directpost_expiration_yr")));
        SelectYear.selectByValue("2019");

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