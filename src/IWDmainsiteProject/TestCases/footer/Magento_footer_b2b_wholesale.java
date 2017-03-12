package IWDmainsiteProject.TestCases.footer;

import IWDmainsiteProject.AppModule.ReportAndScreenShot;
import IWDmainsiteProject.PageObjects.Global_Var_Agency;
import IWDmainsiteProject.PageObjects.Header;
import IWDmainsiteProject.PageObjects.Verify_Pages;
import IWDmainsiteProject.PageObjects.footer;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Magento_footer_b2b_wholesale {

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

        footer.verify_all_elements_in_footer(driver);
        test.log(LogStatus.INFO, "footer is correct");

        footer.Click_on_b2b_wholesale(driver);
        test.log(LogStatus.INFO, "click on b2b_wholesale is done");

        Verify_Pages.Verify_title_link_b2b(driver);
        test.log(LogStatus.INFO, "title on b2b_wholesale is correct");

        Verify_Pages.Verify_guides_button_b2b(driver);
        test.log(LogStatus.INFO, "guides_button on b2b_wholesale works correct");

        Header.Verify_all_elements_in_header(driver);
        test.log(LogStatus.INFO, "Header is correct");

        footer.verify_all_elements_in_footer(driver);
        test.log(LogStatus.INFO, "Footer is correct");

        Verify_Pages.Verify_installation_guide_button_b2b(driver);
        test.log(LogStatus.INFO, "Test Verify_installation_guide_button_b2b is done");

        Verify_Pages.Verify_get_started_price_b2b(driver);
        test.log(LogStatus.INFO, "Verify_get_started_price_b2b is done");



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
