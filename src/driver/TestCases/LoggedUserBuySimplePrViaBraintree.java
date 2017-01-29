package driver.TestCases;


        import java.io.File;
        import java.io.IOException;
        import java.util.concurrent.TimeUnit;

        import driver.ScreenShot.MainTest;
        import driver.appModules.Actions;
        import driver.pageObjectsCheckout.CheckoutPage;
        import driver.pageObjectsCheckout.Global_var;
        import org.apache.commons.io.FileUtils;
        import org.openqa.selenium.OutputType;
        import org.openqa.selenium.TakesScreenshot;
        import org.openqa.selenium.TimeoutException;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.firefox.FirefoxDriver;
        import org.openqa.selenium.support.ui.ExpectedConditions;
        import org.openqa.selenium.support.ui.WebDriverWait;
        import org.testng.annotations.Test;
        import org.testng.annotations.BeforeMethod;
        import org.testng.annotations.AfterMethod;
        import ru.yandex.qatools.ashot.AShot;
        import ru.yandex.qatools.ashot.Screenshot;
        import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

        import javax.imageio.ImageIO;


public class LoggedUserBuySimplePrViaBraintree extends MainTest {

    public WebDriver driver;

    @BeforeMethod

    public void beforeMethod() {

        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(Global_var.URL_MainWebSite);
        driver.manage().window().maximize();

    }
    @Test

    public void main() throws InterruptedException, IOException {

        Actions.CloseNewsletterpopup_Action(driver);
        Actions.SignIn_Action(driver);

        Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
        ImageIO.write(screenshot.getImage(),"PNG",new File(System.getProperty("user.dir") +"/ErrorScreenshots/FullPageScreenshot.png"));

        /*TakesScreenshot ts = (TakesScreenshot)driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        String dest = System.getProperty("user.dir") + "/ErrorScreenshot/Screenshotname.png";
        File destination = new File(dest);
        FileUtils.copyFile(source, destination);*/

        driver.get(Global_var.URL_SimpleProduct);

        CheckoutPage.AddtoCartButton(driver).click();

        driver.get(Global_var.URL_Checkout);


        WebDriverWait wait1 = new WebDriverWait(driver, 15);
        try {
            wait1.until(ExpectedConditions.visibilityOf(CheckoutPage.Checkout_loader(driver)));
            int k = 0;

            while (CheckoutPage.Checkout_loader(driver).isDisplayed() && k < 30) {
                System.out.println(CheckoutPage.Checkout_loader(driver).isDisplayed());
                Thread.sleep(500);
                k = k + 1;
            }
        } catch (org.openqa.selenium.NoSuchElementException | TimeoutException e) {
            System.out.println(1);
        }

        CheckoutPage.Tablerate_Bestway(driver).click();

        try {
            wait1.until(ExpectedConditions.visibilityOf(CheckoutPage.Checkout_loader(driver)));
            int l = 0;
            while (CheckoutPage.Checkout_loader(driver).isDisplayed() && l < 30) {
                System.out.println(CheckoutPage.Checkout_loader(driver).isDisplayed());
                Thread.sleep(500);
                l = l + 1;
            }
        } catch (org.openqa.selenium.NoSuchElementException | TimeoutException e) {
            System.out.println(2);
        }

        //Braintree payment

        Actions.Braintree_Payment(driver);

        Actions.PlaceOrder_Action(driver);

        Actions.PrintOrderNumber_Action_NotLoggedUser(driver);




    }

    @AfterMethod

    public void afterMethod() {

        driver.quit();

    }

}
