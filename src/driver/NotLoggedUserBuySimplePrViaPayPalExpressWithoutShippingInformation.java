package driver;


import driver.pageObjectsCheckout.CheckoutPage;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import static com.thoughtworks.selenium.SeleneseTestNgHelper.assertEquals;

public class NotLoggedUserBuySimplePrViaPayPalExpressWithoutShippingInformation {

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
        /*driver.findElement(By.cssSelector("div[id='shipping-new-address-form'] div[class='control'] .input-text[name='lastname']")).sendKeys("Ignore");
        driver.findElement(By.cssSelector("div[id='shipping-new-address-form'] div[class='control'] .input-text[name='street[0]']")).sendKeys("1978 Lindale Avenue");
        driver.findElement(By.cssSelector("div[id='shipping-new-address-form'] div[class='control'] .input-text[name='city']")).sendKeys("San Francisco");
        Select oSelect = new Select(driver.findElement(By.cssSelector("div[id='shipping-new-address-form'] div[class='control'] .select[name='region_id']")));
        oSelect.selectByVisibleText("California");
        driver.findElement(By.cssSelector("div[id='shipping-new-address-form'] div[class='control'] .input-text[name='postcode']")).sendKeys("94108");
        driver.findElement(By.cssSelector("div[id='shipping-new-address-form'] div[class='control _with-tooltip'] .input-text[name='telephone']")).sendKeys("+1-202-555-0100");*/

        CheckoutPage.Tablerate_Bestway(driver).click();

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

        try {
            driver.findElement(By.xpath("//label[@for='paypal_express']")).click();
            driver.findElement(By.cssSelector("#agreement_1")).click();
            driver.findElement(By.cssSelector(".iwd-place-order-button")).click();
        } catch (NoSuchElementException e) {
            System.out.println(3);
        }

        String element1 = (String) (((JavascriptExecutor) driver).executeScript("return jQuery('[name=\"shippingAddress.lastname\"] input').css('border-top-color')"));
        System.out.println(element1);
        assertEquals("rgb(237, 131, 128)", element1);
        System.out.println("Test done1");

        /*String element2 = (String) (((JavascriptExecutor) driver).executeScript("return jQuery('[name=\"shippingAddress.street.0\"] input').css('border-right-color')"));
        System.out.println(element2);
        assertEquals("rgb(237, 55, 51)", element2);
        System.out.println("Test done2");*/

        String element3 = (String) (((JavascriptExecutor) driver).executeScript("return jQuery('[name=\"shippingAddress.city\"] input').css('border-left-color')"));
        System.out.println(element3);
        assertEquals("rgb(237, 131, 128)", element3);
        System.out.println("Test done3");

        String element4 = (String) (((JavascriptExecutor) driver).executeScript("return jQuery('[name=\"shippingAddress.region_id\"] select').css('border-right-color')"));
        System.out.println(element4);
        assertEquals("rgb(237, 131, 128)", element4);
        System.out.println("Test done4");

        String element5 = (String) (((JavascriptExecutor) driver).executeScript("return jQuery('[name=\"shippingAddress.postcode\"] input').css('border-left-color')"));
        System.out.println(element5);
        assertEquals("rgb(237, 131, 128)", element5);
        System.out.println("Test done5");

        String element6 = (String) (((JavascriptExecutor) driver).executeScript("return jQuery('[name=\"shippingAddress.telephone\"] input').css('border-bottom-color')"));
        System.out.println(element6);
        assertEquals("rgb(237, 131, 128)", element6);
        System.out.println("Test done6");
    }

    @AfterMethod

    public void afterMethod() {

        driver.quit();

    }

}