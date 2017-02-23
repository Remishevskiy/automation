package IWDmainsiteProject.TestCases;

import IWDmainsiteProject.AppModule.ReportAndScreenShot;
import IWDmainsiteProject.PageObjects.Global_Var_Agency;
import IWDmainsiteProject.PageObjects.Header;
import IWDmainsiteProject.PageObjects.Verify_Pages;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Magento_header4_Shopping_cart_acount_magento_extention {

    ExtentReports extent;
    ExtentTest test;
    public WebDriver driver;

    @BeforeClass
    public void init()
    {
        extent = ReportAndScreenShot.Report();
    }


    @BeforeMethod

    public void beforeMethod() {

        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(Global_Var_Agency.URL_MainWebSiteIWD_Magento);
        driver.manage().window().maximize();

    }
    @Test

    public void main() throws InterruptedException, IOException {

        String ClassName = getClass().getName();
        test = extent.startTest("Report-"+ClassName);

        Header.Move_to_Shopping_cart (driver);
        test.log(LogStatus.INFO, "Shopping cart was found");

        Header.Verify_Account_link(driver);
        test.log(LogStatus.INFO, "Account_link was found");

        Header.Move_to_Checkout_suite(driver);
        test.log(LogStatus.INFO, "Checkout_suite was opened");

        Verify_Pages.Verify_Title_link_Checkout_suite(driver);
        test.log(LogStatus.INFO, "Checkout_suite was opened");

        Header.Verify_all_elements_in_header(driver);
        test.log(LogStatus.INFO, "Verify_all_elements_in_header was found");


        test.log(LogStatus.PASS, "Test Passed");
    }

    @AfterMethod
    public void getResult(ITestResult result) throws IOException
    {
        if(result.getStatus() == ITestResult.FAILURE)
        {

            String ClassName = getClass().getName();
            String screenShotPath = ReportAndScreenShot.capture(driver, ClassName);
            test.log(LogStatus.FAIL, result.getThrowable());
            test.log(LogStatus.FAIL, "Screenshot Below: " + test.addScreenCapture(screenShotPath));
        }

    }


    @AfterClass
    public void endreport()
    {
        extent.endTest(test);
        extent.flush();
        extent.close();
        driver.quit();
    }
}