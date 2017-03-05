package IWDmainsiteProject.TestCases;

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

public class WordPress_header2_Health_Check {

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
        driver.get(Global_Var_Agency.URL_MainWebSiteIWD);
        driver.manage().window().maximize();

    }
    @Test

    public void main() throws InterruptedException, IOException {

        String ClassName = getClass().getName();
        test = extent.startTest("Report-"+ClassName);

        Header.Move_to_Health_Check(driver);
        test.log(LogStatus.INFO, "Health_Check was opened");

        Verify_Pages.Verify_Title_Health_Check(driver);
        test.log(LogStatus.INFO, "Title is correct");

        footer.verify_all_elements_in_footer(driver);
        test.log(LogStatus.INFO, "Footer is correct");


        Header.Verify_all_elements_in_header(driver);
        test.log(LogStatus.INFO, "Verify_all_elements_in_header is done = Pass");

        Verify_Pages.Verify_All_Buttons_on_page_Health_Check(driver);
        test.log(LogStatus.INFO, "Verify_All_Buttons_on_page_Health_Check = Pass");

        //Try to scan with button Start_Scan
        Verify_Pages.Verify_Start_Scan_Health_Check(driver);
        test.log(LogStatus.INFO, "Start_Scan is working");

        Verify_Pages.Verify_Link_Health_Check(driver);
        test.log(LogStatus.INFO, "Link is correct");

        //Try to scan with button Scan_My_Store
        Header.Move_to_Health_Check(driver);
        Verify_Pages.Verify_Scan_My_Store_Health_Check(driver);
        test.log(LogStatus.INFO, "Test scan with button Scan_My_Store = Pass");


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
