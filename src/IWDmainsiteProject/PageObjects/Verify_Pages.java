package IWDmainsiteProject.PageObjects;

import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.testng.Assert.assertEquals;

/**
 * Created by Император on 11.02.2017.
 */
public class Verify_Pages {


                              //BUILD_A_STORE

    //Do_It_Yourself http://weeetail.com/

    public static void Verify_Title_Do_It_Yourself(WebDriver driver) {

        String actualTitle = driver.getTitle();
        System.out.println(actualTitle);
        String expectedTitle = "eCommerce Website Designer | Development";
        assertEquals(expectedTitle,actualTitle);
        System.out.println("Title is correct");

    }

    public static void Verify_Preview_a_tour_Video_Do_It_Yourself(WebDriver driver) throws InterruptedException {

        driver.findElement(By.cssSelector("img[data-video-url='https://www.youtube.com/embed/O_OjaLhJIYA']")).click();
        Thread.sleep(3000);
        System.out.println("video is displayed");
        driver.findElement(By.cssSelector(".fa.fa-close")).click();
        System.out.println("video was closed");


    }
    public static void Verify_Weeetail_Themes_a_tour_Video_Do_It_Yourself(WebDriver driver) throws InterruptedException {

        driver.findElement(By.cssSelector("a[href*='https://www.iwdagency.com/weeetail/alexander-designs/'] img[title='Alexander Designs']"));
        driver.findElement(By.cssSelector("a[href*='https://www.iwdagency.com/weeetail/lucca-dante/'] img[title='Lucca Dante']"));
        driver.findElement(By.cssSelector("a[href*='https://www.iwdagency.com/weeetail/ourea/'] img[title='Ourea']"));
        driver.findElement(By.cssSelector("a[href*='https://www.iwdagency.com/weeetail/cole-parker/'] img[title='Cole Parker']"));
        driver.findElement(By.cssSelector("a[href*='https://www.iwdagency.com/weeetail/josephine/'] img[title='Josephine']"));
        driver.findElement(By.cssSelector("a[href*='https://www.iwdagency.com/weeetail/xander/'] img[title='Xander']"));
        System.out.println("All weetail themes were found");
    }
    public static void Verify_Preview_a_tour_Video2_Do_It_Yourself(WebDriver driver) throws InterruptedException {

        driver.findElement(By.cssSelector("img[data-video-url='https://www.youtube.com/embed/EAjl6amk7Vg']")).click();
        Thread.sleep(3000);
        System.out.println("video is displayed");
        driver.findElement(By.cssSelector(".fa.fa-close")).click();
        System.out.println("video was closed");


    }

    //Work With A Team https://www.iwdagency.com/magento-development

    public static void Verify_Title_Work_With_A_Team(WebDriver driver) {

        String actualTitle = driver.getTitle();
        System.out.println(actualTitle);
        String expectedTitle = "Magento Website Development | eCommerce Web Design | IWD Agency";
        assertEquals(expectedTitle,actualTitle);
        System.out.println("Title is correct");

    }

    public static void Verify_Button_SEETHEIRPROJECT_Work_With_A_Team(WebDriver driver) {

        driver.findElement(By.cssSelector("a[href*='/marucci-sporting-goods']")).click();
        String actualTitle = driver.getTitle();
        System.out.println(actualTitle);
        String expectedTitle = "Baton Rouge Louisiana Magento eCommerce Development by IWD";
        assertEquals(expectedTitle,actualTitle);
        driver.navigate().back();
        System.out.println("Title is correct");

    }

    public static void Verify_Text_Work_With_A_Team(WebDriver driver) {

        String Text1 = driver.findElement(By.cssSelector(".wpb_wrapper>h1")).getText();
        System.out.println(Text1);
        String expectedTitle1 = "PROFESSIONALLY DESIGNED MAGENTO STORES";
        assertEquals(expectedTitle1,Text1);
        System.out.println("Text1 is correct");
        String Text2 = driver.findElement(By.cssSelector(".wpb_wrapper>h2")).getText();
        System.out.println(Text2);
        String expectedTitle2 = "Development | Marketing | Extensions";
        assertEquals(expectedTitle2,Text2);
        System.out.println("Text2 is correct");

    }

                       //OPTIMIZATION & SUPPORT

    //Store_Optimization_Support  https://www.iwdagency.com/magento-support

    public static void Verify_Title_Store_Optimization_Support(WebDriver driver) {

        String actualTitle = driver.getTitle();
        System.out.println(actualTitle);
        String expectedTitle = "Magento Support & Help";
        assertEquals(expectedTitle,actualTitle);
        System.out.println("Title is correct");

    }



}
