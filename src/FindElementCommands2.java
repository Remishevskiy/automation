package automationFramework;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;
public class FindElementCommands2 {
	public static void main(String[] args) {
		// Create a new instance of the FireFox driver
		WebDriver driver = new FirefoxDriver();
		
		driver.get("http://toolsqa.wpengine.com/automation-practice-form/");
		
		driver.findElement(By.partialLinkText("Partial")).click();
		System.out.println("Partial Link Test Pass");
		
		String sClass = driver.findElement(By.tagName("button")).toString();
		System.out.println(sClass);
		
		driver.findElement(By.linkText("Partial Link Test")).click();
		System.out.println("tagName Test Pass");
		driver.close();
	}
}
		

		