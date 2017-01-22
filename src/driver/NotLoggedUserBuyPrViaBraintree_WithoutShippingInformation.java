package driver;


import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class NotLoggedUserBuyPrViaBraintree_WithoutShippingInformation {

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
        try {
            wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("checkout-loader")));
            wait1.until(ExpectedConditions.invisibilityOfElementLocated(By.id("checkout-loader")));

        } catch (TimeoutException e) {
            System.out.println(1);
        }
        driver.findElement(By.id("customer-email")).sendKeys("test666test@mail.com");

        try {
            wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("checkout-loader")));
            wait1.until(ExpectedConditions.invisibilityOfElementLocated(By.id("checkout-loader")));

        } catch (TimeoutException e) {
            System.out.println(2);
        }

        /*driver.findElement(By.cssSelector("div[id='shipping-new-address-form'] div[class='control'] .input-text[name='firstname']")).sendKeys("Test");
        driver.findElement(By.cssSelector("div[id='shipping-new-address-form'] div[class='control'] .input-text[name='lastname']")).sendKeys("Ignore");*/
        driver.findElement(By.cssSelector("div[id='shipping-new-address-form'] div[class='control'] .input-text[name='street[0]']")).sendKeys("1978 Lindale Avenue");
        driver.findElement(By.cssSelector("div[id='shipping-new-address-form'] div[class='control'] .input-text[name='city']")).sendKeys("San Francisco");
        Select oSelect = new Select(driver.findElement(By.cssSelector("div[id='shipping-new-address-form'] div[class='control'] .select[name='region_id']")));
        oSelect.selectByVisibleText("California");
        driver.findElement(By.cssSelector("div[id='shipping-new-address-form'] div[class='control'] .input-text[name='postcode']")).sendKeys("94108");
        /*driver.findElement(By.cssSelector("div[id='shipping-new-address-form'] div[class='control _with-tooltip'] .input-text[name='telephone']")).sendKeys("+1-202-555-0100");*/

        driver.findElement(By.id("s_method_freeshipping_freeshipping")).click();

        try {
            wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("checkout-loader")));
            wait1.until(ExpectedConditions.invisibilityOfElementLocated(By.id("checkout-loader")));

        } catch (TimeoutException e) {
            System.out.println(3);
        }

        try {
            driver.findElement(By.xpath("//span[contains(.,'Credit Card (Braintree)')]")).click();
        } catch (NoSuchElementException e) {
            System.out.println(4);
        }

        try {
            wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("checkout-loader")));
            wait1.until(ExpectedConditions.invisibilityOfElementLocated(By.id("checkout-loader")));

        } catch (TimeoutException e) {
            System.out.println(5);
        }
        try {
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
        } catch (NoSuchElementException e) {
            System.out.println(6);
        }

        String element1 = (String) (((JavascriptExecutor) driver).executeScript("return jQuery('[name=\"shippingAddress.firstname\"] input').css('border-top-color')"));
        System.out.println(element1);
        assertEquals("rgb(237, 131, 128)", element1);
        System.out.println("Test done1");

        String element2 = (String) (((JavascriptExecutor) driver).executeScript("return jQuery('[name=\"shippingAddress.lastname\"] input').css('border-right-color')"));
        System.out.println(element2);
        assertEquals("rgb(237, 131, 128)", element2);
        System.out.println("Test done2");

        String element3 = (String) (((JavascriptExecutor) driver).executeScript("return jQuery('[name=\"shippingAddress.telephone\"] input').css('border-left-color')"));
        System.out.println(element3);
        assertEquals("rgb(237, 131, 128)", element3);
        System.out.println("Test done3");


    }
    @AfterMethod

    public void afterMethod() {

        driver.quit();

    }

}