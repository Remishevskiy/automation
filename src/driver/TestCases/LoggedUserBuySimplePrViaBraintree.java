package driver.TestCases;



        import java.io.IOException;
        import java.util.concurrent.TimeUnit;
        import com.relevantcodes.extentreports.ExtentReports;
        import com.relevantcodes.extentreports.ExtentTest;
        import com.relevantcodes.extentreports.LogStatus;
        import driver.ScreenShot.MainTest;
        import driver.appModules.Actions;
        import driver.appModules.GetScreenShot;
        import driver.pageObjectsCheckout.CheckoutPage;
        import driver.pageObjectsCheckout.Global_var;
        import org.openqa.selenium.TimeoutException;
        import org.openqa.selenium.firefox.FirefoxDriver;
        import org.openqa.selenium.support.ui.ExpectedConditions;
        import org.openqa.selenium.support.ui.WebDriverWait;
        import org.testng.ITestResult;
        import org.testng.annotations.*;




public class LoggedUserBuySimplePrViaBraintree extends MainTest {

    ExtentReports extent;
    ExtentTest test;
    /*public WebDriver driver;*/

    @BeforeTest
    public void init()
    {
        extent = new ExtentReports(System.getProperty("user.dir") + "/src/report/ExtentScreenshot.html", true);
    }


    @BeforeMethod

    public void beforeMethod() {

        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(Global_var.URL_MainWebSite);
        driver.manage().window().maximize();

    }
    @Test

    public void main() throws InterruptedException, IOException {

        test = extent.startTest("captureScreenshot");
        Actions.CloseNewsletterpopup_Action(driver);
        Actions.SignIn_Action(driver);


        /*File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("D:\\Testing\\image\\filename.png"));*/

        /*Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
        ImageIO.write(screenshot.getImage(),"PNG",new File(System.getProperty("user.dir") +"/ErrorScreenshots/FullPageScreenshot.png"));*/

        /*TakesScreenshot ts = (TakesScreenshot)driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        String dest = System.getProperty("D:\\Testing\\") + "image\\filename.png";
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

        test.log(LogStatus.PASS, "Test Passed");

    }

    @AfterMethod
    public void getResult(ITestResult result) throws IOException
    {
        if(result.getStatus() == ITestResult.FAILURE)
        {

            String ClassName = getClass().getName();
            String screenShotPath = GetScreenShot.capture(driver, ClassName);
            test.log(LogStatus.FAIL, result.getThrowable());
            test.log(LogStatus.FAIL, "Screenshot Below: " + test.addScreenCapture(screenShotPath));

        }
        extent.endTest(test);
    }


    @AfterTest
    public void endreport()
    {
        driver.close();
        extent.flush();
        extent.close();
    }



   /* @AfterMethod

    public void  afterMethod(ITestResult result) throws IOException {



        System.out.println("Testcase status is"+result.getStatus());
        System.out.println("Iresult status is"+result.FAILURE);

        if(result.FAILURE == result.getStatus())
        {
            //Now we need to capture Screenshot
            //use CaptureScreenshot Class to Take Screenshot

            //https://www.seleniumeasy.com/testng-tutorials/testng-customize-emailable-html-report-example
            //http://automationtesting.in/capture-screenshot-in-extent-reports-java/
            //

            String ClassName = getClass().getName();
            CaptureScreenshot.takescreenshot(driver, ClassName);
            System.out.println("Failed SCR_located:"+Path_to_Screenshots+ClassName+".png");
            Reporter.log("Test log_Failed SCR_located:"+Path_to_Screenshots+ClassName+".png");
        }

        driver.quit();

    }*/

}
