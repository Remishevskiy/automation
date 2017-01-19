package practiceTestCases;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Scrolelement1 {



    private static WebDriver driver;

    @Test


    public static void main(String[] args) throws Exception {

        // TODO Auto-generated method stub

        driver = new FirefoxDriver();

        driver.get("http://toolsqa.wpengine.com");

        Thread.sleep(5000);

        ((JavascriptExecutor)driver).executeScript("document.getElementById('text-8').scrollIntoView(true);");




    }

    }


