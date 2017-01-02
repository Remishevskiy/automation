package practiceTestCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class mouseHover{

    public static WebDriver driver;

    public static void main(String[] args) {

        driver = new FirefoxDriver();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("http://store.demoqa.com/");


        WebElement element = driver.findElement(By.cssSelector("#menu-item-33>a"));

        Actions action = new Actions(driver);

        action.moveToElement(element).perform();

        WebElement subElement = driver.findElement(By.id("menu-item-36"));

        action.moveToElement(subElement);

        action.click();

        action.perform();

}}
