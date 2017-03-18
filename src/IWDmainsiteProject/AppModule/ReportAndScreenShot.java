package IWDmainsiteProject.AppModule;

import com.relevantcodes.extentreports.ExtentReports;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class ReportAndScreenShot {


    private static String getDateTime() {

        DateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd_HH_mm");

        Date date = new Date();

        return dateFormat.format(date);

    }

    public static ExtentReports Report()
    {
        ExtentReports extent;


        System.out.println(ReportAndScreenShot.getDateTime());

        String date = ReportAndScreenShot.getDateTime();

        String Path = System.getProperty("user.dir") +"\\src\\IWDmainsiteProject\\Report\\Report.html";
        System.out.println(Path);
        extent = new ExtentReports(Path, false);
        extent
                .addSystemInfo("Host Name", "IWDAgency")
                .addSystemInfo("Environment", "Firefpx 46.0")
                .addSystemInfo("User Name", "Remishevskiy Oleg");


        return extent;
    }

    public static String capture(WebDriver driver,String screenShotName) throws IOException
    {
        TakesScreenshot ts = (TakesScreenshot)driver;
        File source = ts.getScreenshotAs(OutputType.FILE);


        //String dest = "D:/Testing/untitled1/src/IWDmainsiteProject/Report/image/"+screenShotName+".png";

        String dest = System.getProperty("user.dir")+"\\src\\IWDmainsiteProject\\Report\\image\\"+screenShotName+".png";
        //String dest = System.getProperty("D:/Testing/untitled1/src/report/src/IWDmainsiteProject/Report/image/"+screenShotName+".jpg");
        System.out.println(dest);
        File destination = new File(dest);
        FileUtils.copyFile(source, destination);

        return dest;
    }
}
