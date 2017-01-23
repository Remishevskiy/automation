package driver;


import driver.pageObjectsCheckout.CheckoutPage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class LoggedUserBuySimplePrViaPayPalCredit {

	public WebDriver driver;

	@BeforeMethod

	public void beforeMethod() {


		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://dev.m2ce.deviwd.com/");
		driver.manage().window().maximize();

	}
	@Test

	public void main() {

		driver.findElement(By.cssSelector(".action-close")).click();
		WebDriverWait wait1 = new WebDriverWait(driver, 10);
		wait1.until(ExpectedConditions.invisibilityOfElementLocated(By.id("iwd-newsletterpopup-wrapper")));


		driver.findElement(By.cssSelector(".authorization-link>a")).click();
		driver.findElement(By.id("email")).sendKeys("remishevskiy@ex.ua");
		driver.findElement(By.id("pass")).sendKeys("gold89_18745120");
		driver.findElement(By.id("send2")).click();
		driver.get("http://dev.m2ce.deviwd.com/impulse-duffle.html");
		driver.findElement(By.id("product-addtocart-button")).click();


		driver.get("http://dev.m2ce.deviwd.com/checkout");

		WebDriverWait wait2 = new WebDriverWait(driver, 15);
		try {
			wait2.until(ExpectedConditions.visibilityOfElementLocated(By.id("checkout-loader")));
			wait2.until(ExpectedConditions.invisibilityOfElementLocated(By.id("checkout-loader")));

		} catch (TimeoutException e) {
			System.out.println(1);
		}

		CheckoutPage.Freeshipping(driver).click();

		try {
			wait2.until(ExpectedConditions.visibilityOfElementLocated(By.id("checkout-loader")));
			wait2.until(ExpectedConditions.invisibilityOfElementLocated(By.id("checkout-loader")));
		} catch (TimeoutException e) {
			System.out.println(2);
		}

		driver.findElement(By.xpath("//span[contains(.,'PayPal Credit')]")).click();
		try{
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("checkout-loader")));
			wait1.until(ExpectedConditions.invisibilityOfElementLocated(By.id("checkout-loader")));

		}catch (TimeoutException e) {
			System.out.println(4);
		}
		driver.findElement(By.cssSelector("#agreement_1")).click();

		driver.findElement(By.cssSelector(".iwd-place-order-button>button")).click();

				/*driver.switchTo().frame(driver.findElement(By.id("yui-history-iframe")));*/
		try{
				driver.findElement(By.cssSelector("div[class='subhead'] input[id='loadLogin']")).click();
		}catch (NoSuchElementException e) {
			System.out.println("Unable to locate element");
		}
				driver.findElement(By.id("login_email")).clear();
				driver.findElement(By.id("login_email")).sendKeys("max-buyer@iwdagency.com");
				driver.findElement(By.id("login_password")).sendKeys("123321qazwsx");
				driver.findElement(By.id("submitLogin")).click();
				driver.findElement(By.id("continue_abovefold")).click();
				/*driver.switchTo().defaultContent();*/
				/*try{
					wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("spinner")));
					wait1.until(ExpectedConditions.invisibilityOfElementLocated(By.id("spinner")));

				}catch (TimeoutException e) {
					System.out.println(6);
				}
				driver.findElement(By.id("confirmButtonTop")).click();


				driver.switchTo().window(homePage);*/

		wait2.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".order-number>strong")));
		String order = driver.findElement(By.cssSelector(".order-number>strong")).getText();
		System.out.println(order);

	}


	@AfterMethod

	public void afterMethod() {

		driver.quit();

	}}





