package practiceTestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;
import java.util.Set;

public class IFrame {

    public static void main(String[] args) throws InterruptedException
    {

        WebDriver driver = new FirefoxDriver();
        driver.get("http://toolsqa.wpengine.com/iframe-practice-page/");
        //First find the element using any of locator stratedgy
        WebElement iframeElement = driver.findElement(By.id("IF1"));

        //now use the switch command
        driver.switchTo().frame(0);

        //Do all the required tasks in the frame 0
        //Switch back to the main window
        driver.switchTo().defaultContent();
        driver.quit();

    }}
