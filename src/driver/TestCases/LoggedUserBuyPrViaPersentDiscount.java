package driver.TestCases;

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

public class LoggedUserBuyPrViaPersentDiscount {

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
        WebDriverWait wait1 = new WebDriverWait(driver, 10);
        wait1.until(ExpectedConditions.invisibilityOfElementLocated(By.id("iwd-newsletterpopup-wrapper")));

        driver.findElement(By.cssSelector(".authorization-link>a")).click();
        driver.findElement(By.id("email")).sendKeys("remishevskiy@ex.ua");
        driver.findElement(By.id("pass")).sendKeys("gold89_18745120");
        driver.findElement(By.id("send2")).click();
        driver.get("http://dev.m2ce.deviwd.com/impulse-duffle.html");
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
            System.out.println(2);
        }

            driver.findElement(By.id("block-discount-heading")).click();
            driver.findElement(By.id("discount-code")).sendKeys("test50per");
            driver.findElement(By.cssSelector(".action.iwd-action-code-button.iwd-action-apply.action-apply")).click();
            try {
                wait1.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".message.message-success.success")));
                String Diskount = driver.findElement(By.cssSelector(".message.message-success.success")).getText();
                System.out.println(Diskount + " persent 50 discount add");
            }catch (TimeoutException e) {
                System.out.println("Test failed, persent discount wasn't added");
            }
            //Braintree payment
            driver.findElement(By.xpath("//span[contains(.,'Check / Money order')]")).click();
            driver.findElement(By.cssSelector("#agreement_1")).click();
            driver.findElement(By.cssSelector(".iwd-place-order-button")).click();

            wait1.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".order-number>strong")));
            String order = driver.findElement(By.cssSelector(".order-number>strong")).getText();
            System.out.println(order + " order was created with discount 50%");

    }


    @AfterMethod

    public void afterMethod() {

        driver.quit();

    }

}