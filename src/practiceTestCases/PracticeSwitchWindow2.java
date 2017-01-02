package practiceTestCases;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class PracticeSwitchWindow2 {

    public static WebDriver driver;


    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new FirefoxDriver();
        driver.get("http://toolsqa.wpengine.com/handling-alerts-using-selenium-webdriver/");
        driver.manage().window().maximize();
        // This step will result in an alert on screen
        WebElement element = driver.findElement(By.xpath("//*[@id='content']/p[11]/button"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", element);

        Alert promptAlert  = driver.switchTo().alert();
        String alertText = promptAlert .getText();
        System.out.println("Alert text is " + alertText);
        //Send some text to the alert
        promptAlert .sendKeys("Accepting the alert");
        Thread.sleep(4000); //This sleep is not necessary, just for demonstration
        promptAlert .accept();
    }}