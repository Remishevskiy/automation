package driver;


        import java.util.List;
        import java.util.concurrent.TimeUnit;
        import org.openqa.selenium.By;
        import org.openqa.selenium.TimeoutException;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.WebElement;
        import org.openqa.selenium.firefox.FirefoxDriver;
        import org.openqa.selenium.support.ui.ExpectedConditions;
        import org.openqa.selenium.support.ui.Select;
        import org.openqa.selenium.support.ui.WebDriverWait;
        import org.testng.annotations.Test;
        import org.testng.annotations.BeforeMethod;
        import org.testng.annotations.AfterMethod;

public class LogedUserBuyConfigurablePrViaBraintree {

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
        driver.get("http://dev.m2ce.deviwd.com/chaz-kangeroo-hoodie.html");
        wait1.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".swatch-option.color[option-id='49']")));
        driver.findElement(By.cssSelector(".swatch-option.color[option-id='49']")).click();
        driver.findElement(By.cssSelector(".swatch-option.text[option-id='167']")).click();
        Select CustomOption1 = new Select(driver.findElement(By.id("select_78")));
        CustomOption1.selectByVisibleText("Test custom option 1.1");
        driver.findElement(By.id("options_79_2")).click();
        driver.findElement(By.id("options_80_2")).click();
        driver.findElement(By.id("options_80_3")).click();
        Select CustomOption4 = new Select(driver.findElement(By.cssSelector("#select_81")));
        List<WebElement> oSize = CustomOption4.getOptions();
        int iListSize = oSize.size();

        // Setting up the loop to print all the options
        for(int i =0; i < iListSize ; i++){
            // Storing the value of the option
            String sValue = CustomOption4.getOptions().get(i).getText();

            // Printing the stored value
            System.out.println(sValue);

            // Selecting all the elements one by one
            CustomOption4.selectByIndex(i);
        }


            /*ProductDesigner*/
    /*driver.findElement(By.cssSelector(".fpd-add-text.fpd-btn-raised.fpd-secondary-bg-color.fpd-secondary-text-color>span")).click();
    wait1.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".modal-body>textarea")));
    driver.findElement(By.cssSelector(".modal-body>textarea")).sendKeys("Automation Test");
    driver.findElement(By.cssSelector(".btn.action.primary.iwdpd-add-text-btn")).click();
    wait1.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".modal-body>textarea")));*/
    /*wait1.until(ExpectedConditions.elementToBeClickable(By.id("product-addtocart-button")));*/
        driver.findElement(By.id("product-addtocart-button")).click();

        driver.get("http://dev.m2ce.deviwd.com/checkout");

        WebDriverWait wait2 = new WebDriverWait(driver, 15);
        try{
            wait2.until(ExpectedConditions.visibilityOfElementLocated(By.id("checkout-loader")));
            wait2.until(ExpectedConditions.invisibilityOfElementLocated(By.id("checkout-loader")));

        }catch (TimeoutException e) {
            System.out.println(1);
        }

        //Braintree payment
        driver.findElement(By.id("label_method_1DP_ups")).click();
        try{
            wait2.until(ExpectedConditions.visibilityOfElementLocated(By.id("checkout-loader")));
            wait2.until(ExpectedConditions.invisibilityOfElementLocated(By.id("checkout-loader")));

        }catch (TimeoutException e) {
            System.out.println(2);
            driver.findElement(By.xpath("//span[contains(.,'Credit Card (Braintree)')]")).click();

            driver.switchTo().frame(driver.findElement(By.id("braintree-hosted-field-number")));
            driver.findElement(By.id("credit-card-number")).sendKeys("5555555555554444");
            driver.switchTo().defaultContent();
            driver.switchTo().frame(driver.findElement(By.id("braintree-hosted-field-expirationMonth")));
            driver.findElement(By.id("expiration-month")).sendKeys("12");
            driver.switchTo().defaultContent();
            driver.switchTo().frame(driver.findElement(By.id("braintree-hosted-field-expirationYear")));
            driver.findElement(By.id("expiration-year")).sendKeys("20");
            driver.switchTo().defaultContent();
            driver.switchTo().frame(driver.findElement(By.id("braintree-hosted-field-cvv")));
            driver.findElement(By.id("cvv")).sendKeys("111");
            driver.switchTo().defaultContent();
            driver.findElement(By.id("braintree_vault_enabler")).click();

            driver.findElement(By.cssSelector("#agreement_1")).click();


            driver.findElement(By.cssSelector(".iwd-place-order-button")).click();

            wait2.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".order-number>strong")));
            String order = driver.findElement(By.cssSelector(".order-number>strong")).getText();
            System.out.println(order);

        }}


    @AfterMethod

    public void afterMethod() {

        driver.quit();

    }

}