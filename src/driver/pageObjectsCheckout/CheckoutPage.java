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

    public static WebElement Store_Pickup(WebDriver driver){

        element = driver.findElement(By.id("iwd_storepickup_store_select"));

        return element;

    }

    public static WebElement Flat_Rate(WebDriver driver){

        element = driver.findElement(By.id("s_method_flatrate_flatrate"));

        return element;

    }

    public static WebElement Tablerate_Bestway(WebDriver driver){

        element = driver.findElement(By.id("s_method_tablerate_bestway"));

        return element;

    }
    public static WebElement Freeshipping(WebDriver driver){

        element = driver.findElement(By.id("s_method_freeshipping_freeshipping"));

        return element;

    }
    public static WebElement UPS_Ground(WebDriver driver){

        element = driver.findElement(By.id("s_method_ups_GND"));

        return element;

    }
    public static WebElement UPS_3DaySelect(WebDriver driver){

        element = driver.findElement(By.id("s_method_ups_3DS"));

        return element;

    }
    public static WebElement UPS_2ndDayAir(WebDriver driver){

        element = driver.findElement(By.id("s_method_ups_2DA"));

        return element;

    }
    public static WebElement UPS_NextDayAirSaver(WebDriver driver){

        element = driver.findElement(By.id("s_method_ups_1DP"));

        return element;

    }
    public static WebElement UPS_NextDayAir(WebDriver driver){

        element = driver.findElement(By.id("s_method_ups_1DA"));

        return element;

    }
    public static WebElement UPS_NextDayAirEarlyAM(WebDriver driver){

        element = driver.findElement(By.id("s_method_ups_1DM"));

        return element;

    }

    //loader
    public static WebElement Checkout_loader(WebDriver driver) {

        element = driver.findElement(By.id("checkout-loader"));

        return element;
    }


}

