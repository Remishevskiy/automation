package practiceTestCases;



import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class programMain {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        FirefoxDriver driver = new FirefoxDriver();
        EventFiringWebDriver eventDriver = new EventFiringWebDriver(driver);

        EventHandler handler = new EventHandler();
        eventDriver.register(handler);
        eventDriver.get("http://toolsqa.wpengine.com/automation-practice-switch-windows/");
        WebElement element = eventDriver.findElement(By.cssSelector("#alert"));
        element.click();

    }

}