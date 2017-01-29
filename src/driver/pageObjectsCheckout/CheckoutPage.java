package driver.pageObjectsCheckout;

/**
 * Created by Oleg on 19.01.2017.
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutPage {

    //Shipping

    private static WebElement element = null;

    public static WebElement Store_Pickup(WebDriver driver) {

        element = driver.findElement(By.id("iwd_storepickup_store_select"));

        return element;

    }

    public static WebElement Flat_Rate(WebDriver driver) {

        element = driver.findElement(By.id("s_method_flatrate_flatrate"));

        return element;

    }

    public static WebElement Tablerate_Bestway(WebDriver driver) {

        element = driver.findElement(By.id("s_method_tablerate_bestway"));

        return element;

    }

    public static WebElement Freeshipping(WebDriver driver) {

        element = driver.findElement(By.id("s_method_freeshipping_freeshipping"));

        return element;

    }

    public static WebElement UPS_Ground(WebDriver driver) {

        element = driver.findElement(By.id("s_method_ups_GND"));

        return element;

    }

    public static WebElement UPS_3DaySelect(WebDriver driver) {

        element = driver.findElement(By.id("s_method_ups_3DS"));

        return element;

    }

    public static WebElement UPS_2ndDayAir(WebDriver driver) {

        element = driver.findElement(By.id("s_method_ups_2DA"));

        return element;

    }

    public static WebElement UPS_NextDayAirSaver(WebDriver driver) {

        element = driver.findElement(By.id("s_method_ups_1DP"));

        return element;

    }

    public static WebElement UPS_NextDayAir(WebDriver driver) {

        element = driver.findElement(By.id("s_method_ups_1DA"));

        return element;

    }

    public static WebElement UPS_NextDayAirEarlyAM(WebDriver driver) {

        element = driver.findElement(By.id("s_method_ups_1DM"));

        return element;

    }

    //loader
    public static WebElement Checkout_loader(WebDriver driver) {

        element = driver.findElement(By.id("checkout-loader"));

        return element;
    }

    //SignIn

    public static WebElement SignIn_Bouton(WebDriver driver) {

        element = driver.findElement(By.cssSelector(".authorization-link>a"));

        return element;
    }

    public static WebElement Email(WebDriver driver) {

        element = driver.findElement(By.id("email"));

        return element;
    }

    public static WebElement Password(WebDriver driver) {

        element = driver.findElement(By.id("pass"));

        return element;
    }

    public static WebElement Confirm_SignIn(WebDriver driver) {

        element = driver.findElement(By.id("send2"));

        return element;
    }


    //Braintree payment

    public static WebElement Braintree_Boutton(WebDriver driver) {

        element = driver.findElement(By.xpath("//span[contains(.,'Credit Card (Braintree)')]"));

        return element;
    }

    public static WebElement FrameID_CreditCard_Field_(WebDriver driver) {

        element = driver.findElement(By.id("braintree-hosted-field-number"));

        return element;
    }

    public static WebElement CreditCard_Field(WebDriver driver) {

        element = driver.findElement(By.id("credit-card-number"));

        return element;
    }

    public static WebElement FrameID_CreditCard_Month(WebDriver driver) {

        element = driver.findElement(By.id("braintree-hosted-field-expirationMonth"));

        return element;
    }

    public static WebElement CreditCard_Month_Field(WebDriver driver) {

        element = driver.findElement(By.cssSelector("expiration-month"));

        return element;
    }

    public static WebElement FrameID_CreditCard_Year(WebDriver driver) {

        element = driver.findElement(By.id("braintree-hosted-field-expirationYear"));

        return element;
    }

    public static WebElement CreditCard_Year_Field(WebDriver driver) {

        element = driver.findElement(By.cssSelector("expiration-year"));

        return element;
    }

    //Place Order

    public static WebElement AgreeTermsAndConditions(WebDriver driver) {

        element = driver.findElement(By.cssSelector("#agreement_1"));

        return element;
    }

    public static WebElement PlaceOrderButton(WebDriver driver) {

        element = driver.findElement(By.cssSelector(".iwd-place-order-button"));

        return element;
    }

    public static WebElement AddtoCartButton(WebDriver driver) {

        element = driver.findElement(By.id("product-addtocart-button"));

        return element;

    }

}