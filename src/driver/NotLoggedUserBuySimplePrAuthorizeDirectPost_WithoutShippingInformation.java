/*
package driver;


import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;


public class NonLogedUserBuyPrViaPayPalBraintree {

    public static void main(String[] args) throws InterruptedException {
    // Use PayPal braintree, flat rate
    WebDriver driver = new FirefoxDriver();

    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("http://dev.m2ce.nexcess.iwdfun.com/impulse-duffle.html");
        driver.manage().window().maximize();
        driver.findElement(By.cssSelector(".action-close")).click();
        WebDriverWait wait1 = new WebDriverWait(driver, 10);
        wait1.until(ExpectedConditions.invisibilityOfElementLocated(By.id("iwd-newsletterpopup-wrapper")));

        driver.findElement(By.id("product-addtocart-button")).click();

        driver.get("http://dev.m2ce.nexcess.iwdfun.com/checkout");
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

        driver.findElement(By.xpath("//span[contains(.,'PayPal (Braintree)')]")).click();
        driver.findElement(By.cssSelector("#agreement_1")).click();

        String homePage = driver.getWindowHandle();
        //System.out.println(homePage);

        driver.findElement(By.cssSelector("._active .action.primary.checkout")).click();

        Set<String> windows = driver.getWindowHandles();
        //System.out.println(windows.size());

        Iterator iterator = windows.iterator();
        String currentWindowId;

        while(iterator.hasNext()){
            currentWindowId = iterator.next().toString();
            //System.out.println(currentWindowId);

            if(!currentWindowId.equals(homePage)){
                driver.switchTo().window(currentWindowId);
                driver.findElement(By.id("return_url")).click();
                driver.switchTo().window(homePage);

                wait1.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".checkout-success>p>span")));
                String order = driver.findElement(By.cssSelector(".checkout-success>p>span")).getText();
                System.out.println(order);
                driver.close();
            }
        }
}}
*/

package driver;


import driver.pageObjectsCheckout.CheckoutPage;
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

public class NotLoggedUserBuySimplePrAuthorizeDirectPost_WithoutShippingInformation {

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
        /*
        driver.findElement(By.cssSelector("div[id='shipping-new-address-form'] div[class='control'] .input-text[name='street[0]']")).sendKeys("1978 Lindale Avenue");
        driver.findElement(By.cssSelector("div[id='shipping-new-address-form'] div[class='control'] .input-text[name='city']")).sendKeys("San Francisco");
        Select oSelect = new Select(driver.findElement(By.cssSelector("div[id='shipping-new-address-form'] div[class='control'] .select[name='region_id']")));
        oSelect.selectByVisibleText("California");
        driver.findElement(By.cssSelector("div[id='shipping-new-address-form'] div[class='control'] .input-text[name='postcode']")).sendKeys("94108");
        driver.findElement(By.cssSelector("div[id='shipping-new-address-form'] div[class='control _with-tooltip'] .input-text[name='telephone']")).sendKeys("+1-202-555-0100");*/

        CheckoutPage.Freeshipping(driver).click();

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
        try{
        driver.findElement(By.xpath("//span[contains(.,'Credit Card Direct Post (Authorize.net)')]")).click();
        }catch (NoSuchElementException e) {
            System.out.println(4);
        }
        try {
            wait1.until(ExpectedConditions.visibilityOf(CheckoutPage.Checkout_loader(driver)));
            int k = 0;
            while (CheckoutPage.Checkout_loader(driver).isDisplayed() && k < 30){
                System.out.println(CheckoutPage.Checkout_loader(driver).isDisplayed());
                Thread.sleep(500);
                k = k + 1;
            }
        } catch (org.openqa.selenium.NoSuchElementException | TimeoutException e) {
            System.out.println(5);
        }

        try{
        driver.findElement(By.cssSelector("#authorizenet_directpost_cc_number")).sendKeys("371449635398431");
        Select SelectMonth = new Select(driver.findElement(By.id("authorizenet_directpost_expiration")));
        SelectMonth.selectByValue("9");
        Select SelectYear = new Select(driver.findElement(By.cssSelector("#authorizenet_directpost_expiration_yr")));
        SelectYear.selectByValue("2021");

        driver.findElement(By.cssSelector("#agreement_1")).click();
        driver.findElement(By.cssSelector(".iwd-place-order-button")).click();
        }catch (NoSuchElementException e) {
            System.out.println(6);
        }
        String element1 = (String) (((JavascriptExecutor)driver).executeScript("return jQuery('[name=\"shippingAddress.city\"] input').css('border-top-color')"));
        System.out.println(element1);
        assertEquals("rgb(237, 131, 128)", element1);
        System.out.println("Test done1");

        String element2 = (String) (((JavascriptExecutor)driver).executeScript("return jQuery('[name=\"shippingAddress.region_id\"] select').css('border-right-color')"));
        System.out.println(element2);
        assertEquals("rgb(237, 131, 128)", element2);
        System.out.println("Test done2");

        String element3 = (String) (((JavascriptExecutor)driver).executeScript("return jQuery('[name=\"shippingAddress.postcode\"] input').css('border-left-color')"));
        System.out.println(element3);
        assertEquals("rgb(237, 131, 128)", element3);
        System.out.println("Test done3");

        String element4 = (String) (((JavascriptExecutor)driver).executeScript("return jQuery('[name=\"shippingAddress.telephone\"] input').css('border-bottom-color')"));
        System.out.println(element4);
        assertEquals("rgb(237, 131, 128)", element4);
        System.out.println("Test done4");

        /*System.out.println(((JavascriptExecutor)driver).executeScript("return jQuery('[name=\"shippingAddress.city\"] input').css('border-right-color')"));
        System.out.println(((JavascriptExecutor)driver).executeScript("return jQuery('[name=\"shippingAddress.city\"] input').css('border-left-color')"));
        System.out.println(((JavascriptExecutor)driver).executeScript("return jQuery('[name=\"shippingAddress.city\"] input').css('border-bottom-color')"));*/


        //System.out.println("CssValue - of the webelement  e is -> " + actualValue);


        /*wait1.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".checkout-success>p>span")));
        String order = driver.findElement(By.cssSelector(".checkout-success>p>span")).getText();
        System.out.println(order);*/
    }


    @AfterMethod

    public void afterMethod() {

        driver.quit();

    }}