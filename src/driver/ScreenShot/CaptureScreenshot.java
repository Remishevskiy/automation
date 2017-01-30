package driver.ScreenShot;



import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

/**
 * Created by Император on 29.01.2017.
 */
/*public class GetScreenshot extends MainTest {
    public static String capture(String screenshotName) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        String dest = System.getProperty("user.dir") + "./ErrorScreenshot/" + screenshotName + ".png";
        File destination = new File(dest);
        FileUtils.copyFile(source, destination);
        System.out.println("Screenshot Taken Successfully!!!!");

        return dest;
    }
}*/

public class CaptureScreenshot {

    public static void takescreenshot(WebDriver driver, String Screenshotname) throws IOException
    {
        TakesScreenshot takescreenshot=(TakesScreenshot)driver;
        File source=takescreenshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(source, new File("./Screenshots/"+Screenshotname+".png"));
        System.out.println("Screenshot Taken Successfully!!!!");

    }

}
