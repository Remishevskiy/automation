package driver;


        import java.util.Iterator;
        import java.util.Set;
        import java.util.concurrent.TimeUnit;
        import org.openqa.selenium.By;
        import org.openqa.selenium.TimeoutException;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.firefox.FirefoxDriver;
        import org.openqa.selenium.support.ui.ExpectedConditions;
        import org.openqa.selenium.support.ui.WebDriverWait;
        import org.testng.annotations.Test;
        import org.testng.annotations.BeforeMethod;
        import org.testng.annotations.AfterMethod;

public class LogedUserBuyVirtualPrViaPayBraintree {

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
        WebDriverWait wait1 = new WebDriverWait(driver, 15);
        wait1.until(ExpectedConditions.invisibilityOfElementLocated(By.id("iwd-newsletterpopup-wrapper")));

        driver.findElement(By.cssSelector(".authorization-link>a")).click();
        driver.findElement(By.id("email")).sendKeys("remishevskiy@ex.ua");
        driver.findElement(By.id("pass")).sendKeys("gold89_18745120");
        driver.findElement(By.id("send2")).click();
        driver.get("http://dev.m2ce.deviwd.com/mh01-blue-xs.html");
        driver.findElement(By.id("product-addtocart-button")).click();

        driver.get("http://dev.m2ce.deviwd.com/checkout");

        WebDriverWait wait2 = new WebDriverWait(driver, 15);
        try{
            wait2.until(ExpectedConditions.visibilityOfElementLocated(By.id("checkout-loader")));
            wait2.until(ExpectedConditions.invisibilityOfElementLocated(By.id("checkout-loader")));

        }catch (TimeoutException e) {
            System.out.println(1);
        }

        String homePage = driver.getWindowHandle();
        //PayPal Braintree payment
        driver.findElement(By.xpath("//label[@for='braintree_paypal']")).click();
        
        try{
            wait2.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".loading-mask")));
            wait2.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".loading-mask")));

        }catch (TimeoutException e) {
            System.out.println(2);
        }

        driver.findElement(By.cssSelector("#agreement_1")).click();
        driver.findElement(By.cssSelector(".iwd-place-order-button>button")).click();
        Set<String> windows = driver.getWindowHandles();
        //System.out.println(windows.size());

        Iterator iterator = windows.iterator();
        String currentWindowId;

        while(iterator.hasNext()){
            currentWindowId = iterator.next().toString();
            //System.out.println(currentWindowId);


            if(!currentWindowId.equals(homePage)){
                driver.switchTo().window(currentWindowId);
                driver.findElement(By.id("return_url")).click();
                driver.switchTo().window(homePage);

                wait2.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".order-number>strong")));
                String order = driver.findElement(By.cssSelector(".order-number>strong")).getText();
                System.out.println(order);

    }}}


    /*@AfterMethod

    public void afterMethod() {

        driver.quit();

    }*/

}



