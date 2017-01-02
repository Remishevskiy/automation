package automationFramework;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;
public class FindElementCommands1 {
	public static void main(String[] args) {
		// Create a new instance of the FireFox driver
		WebDriver driver = new FirefoxDriver();
		
		driver.get("http://toolsqa.wpengine.com/automation-practice-form/");
		
		driver.findElement(By.name("firstname")).sendKeys("Oleg");
		driver.findElement(By.name("lastname")).sendKeys("Remishevskiy");
		driver.findElement(By.id("submit")).click();
		driver.close();
	}
}
		

		