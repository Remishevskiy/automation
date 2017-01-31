package driver.appModules;


import driver.ScreenShot.MainTest;
import driver.pageObjectsCheckout.CheckoutPage;
import driver.pageObjectsCheckout.Global_var;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


/**
 * Created by Император on 28.01.2017.
 */
public class Actions extends MainTest {

    public static void SignIn_Action(WebDriver driver){

        CheckoutPage.SignIn_Bouton(driver).click();
        CheckoutPage.Email(driver).sendKeys(Global_var.Login);
        CheckoutPage.Password(driver).sendKeys(Global_var.Password);
        CheckoutPage.Confirm_SignIn(driver).click();
    }

    public static void CloseNewsletterpopup_Action(WebDriver driver){

        driver.findElement(By.cssSelector(".action-close")).click();
        WebDriverWait wait1 = new WebDriverWait(driver, 15);
        wait1.until(ExpectedConditions.invisibilityOfElementLocated(By.id("iwd-newsletterpopup-wrapper")));
    }

    public static void Braintree_Payment(WebDriver driver){

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
    }

    public static void PlaceOrder_Action(WebDriver driver){

        CheckoutPage.AgreeTermsAndConditions(driver).click();
        CheckoutPage.PlaceOrderButton(driver).click();
    }

    public static void PrintOrderNumber_Action_NotLoggedUser(WebDriver driver){

        WebDriverWait wait2 = new WebDriverWait(driver, 15);
        wait2.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".order-number>strong")));
        String order = driver.findElement(By.cssSelector(".order-number>strong")).getText();
        System.out.println(order);
    }


}

