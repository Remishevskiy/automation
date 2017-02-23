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

public class Magento_header1_bulidastore_doitYourself {

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

        Header.Move_to_Do_It_Yourself(driver);
        test.log(LogStatus.INFO, "Do_It_Yourself was opened");

        Verify_Pages.Verify_Title_Do_It_Yourself(driver);
        test.log(LogStatus.INFO, "Title is correct");

        Verify_Pages.Verify_Preview_a_tour_Video_Do_It_Yourself(driver);
        test.log(LogStatus.INFO, "Video is displayed");

        Verify_Pages.Verify_Weeetail_Themes_a_tour_Video_Do_It_Yourself(driver);
        test.log(LogStatus.INFO, "All weetail themes were found");

        Verify_Pages.Verify_Preview_a_tour_Video2_Do_It_Yourself(driver);
        test.log(LogStatus.INFO, "Video2 is displayed");

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
