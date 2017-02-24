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

/**
 * Created by Oleg on 10.02.2017.
 */
public class Weeetail_header1_Work_with_a_team {
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
        driver.get(Global_Var_Agency.URL_MainWebSiteIWD_Weeetail);
        driver.manage().window().maximize();

    }
    @Test

    public void main() throws InterruptedException, IOException {


        String ClassName = getClass().getName();
        test = extent.startTest("Report-"+ClassName);

        Header.Move_to_Work_With_A_Team(driver);
        test.log(LogStatus.INFO, "Link Work_With_A_Team was opened");

        Verify_Pages.Verify_Title_Work_With_A_Team(driver);
        test.log(LogStatus.INFO, "Title is correct");

        Header.Verify_all_elements_in_header(driver);
        test.log(LogStatus.INFO, "Header displayed correct");

        Verify_Pages.Verify_Button_SEETHEIRPROJECT_Work_With_A_Team(driver);
        test.log(LogStatus.INFO, "Button SEE THEIR PROJECT is working");

        Verify_Pages.Verify_Text_Work_With_A_Team(driver);
        test.log(LogStatus.INFO, "Text on page is correct");


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


