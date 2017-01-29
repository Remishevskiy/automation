package driver.TestCases;

import driver.ScreenShot.MainTest;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Test1 extends MainTest {

    @Test
    public void captureScreenshot() {
        System.setProperty("webdriver.firefox.marionette", "D:\\drivers\\geckodriver-0.10.0\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.get("http://www.automationtesting.in");
        String title = driver.getTitle();
        Assert.assertEquals("Home - Automation Test", title);
        driver.close();
    }
}
