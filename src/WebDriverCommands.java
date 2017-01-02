package automationFramework;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverCommands {
	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		driver.get("http://demoqa.com/frames-and-windows/");
		driver.navigate().to("https://dou.ua/");
		driver.findElement(By.xpath(".//*[@id='tabs-1']/div/p/a")).click();
		driver.findElement(By.xpath(".//*[@id='tabs-1']/div/p/a")).click();
		driver.findElement(By.xpath(".//*[@id='tabs-1']/div/p/a")).click();
		driver.quit();
	}
}