package IWDmainsiteProject.PageObjects;


import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Iterator;
import java.util.Set;

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
        assertEquals(expectedTitle, actualTitle);
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
        assertEquals(expectedTitle, actualTitle);
        System.out.println("Title is correct");

    }

    public static void Verify_Button_SEETHEIRPROJECT_Work_With_A_Team(WebDriver driver) {

        driver.findElement(By.cssSelector("a[href*='/marucci-sporting-goods']")).click();
        String actualTitle = driver.getTitle();
        System.out.println(actualTitle);
        String expectedTitle = "Baton Rouge Louisiana Magento eCommerce Development by IWD";
        assertEquals(expectedTitle, actualTitle);
        driver.navigate().back();
        System.out.println("Title is correct");

    }

    public static void Verify_Text_Work_With_A_Team(WebDriver driver) {

        String Text1 = driver.findElement(By.cssSelector(".wpb_wrapper>h1")).getText();
        System.out.println(Text1);
        String expectedTitle1 = "PROFESSIONALLY DESIGNED MAGENTO STORES";
        assertEquals(expectedTitle1, Text1);
        System.out.println("Text1 is correct");
        String Text2 = driver.findElement(By.cssSelector(".wpb_wrapper>h2")).getText();
        System.out.println(Text2);
        String expectedTitle2 = "Development | Marketing | Extensions";
        assertEquals(expectedTitle2, Text2);
        System.out.println("Text2 is correct");

    }

    //OPTIMIZATION & SUPPORT

    //Store_Optimization_Support  https://www.iwdagency.com/magento-support

    public static void Verify_Title_Store_Optimization_Support(WebDriver driver) {

        String actualTitle = driver.getTitle();
        System.out.println(actualTitle);
        String expectedTitle = "Magento Support & Help";
        assertEquals(expectedTitle, actualTitle);
        System.out.println("Title is correct");

    }

    public static void Verify_ALL_Links_START_NOW_Store_Optimization_Support(WebDriver driver) {

        String href_GET_A_FREE_QUOTE = driver.findElement(By.cssSelector(".vc_general.vc_btn3.vc_btn3-size-lg.vc_btn3-shape-square.vc_btn3-style-custom.typeform-share.link")).getAttribute("href");
        System.out.println(href_GET_A_FREE_QUOTE);
        String href_START_NOW1 = driver.findElement(By.cssSelector(".typeform-share.link.vc_general.vc_btn3.vc_btn3-size-lg.vc_btn3-shape-square.vc_btn3-style-outline-custom")).getAttribute("href");
        System.out.println(href_START_NOW1);
        String href_START_NOW2 = driver.findElement(By.cssSelector("div[class='gw-go-col-wrap gw-go-col-wrap-1'] a[class='typeform-share link start-now-link']")).getAttribute("href");
        System.out.println(href_START_NOW2);
        String href_START_NOW3 = driver.findElement(By.cssSelector("div[class='gw-go-col-wrap gw-go-col-wrap-2'] a[class='typeform-share link start-now-link']")).getAttribute("href");
        System.out.println(href_START_NOW3);
        String expected_href = "https://joe568.typeform.com/to/ecFKHU";
        assertEquals(expected_href, href_GET_A_FREE_QUOTE);
        assertEquals(expected_href, href_START_NOW1);
        assertEquals(expected_href, href_START_NOW2);
        assertEquals(expected_href, href_START_NOW3);
        System.out.println("All links were verified. Test passed");

    }

    public static void Verify_Button_WATCH_A_VIDEO_ABOUT_US_Store_Optimization_Support(WebDriver driver) throws InterruptedException {

        driver.findElement(By.cssSelector(".watch-video")).click();
        driver.switchTo().frame(driver.findElement(By.cssSelector("#iwd-iframe")));
        driver.findElement(By.cssSelector(".ytp-thumbnail-overlay-image")).click();
        driver.switchTo().defaultContent();
        Thread.sleep(3000);
        System.out.println("video is displayed");
        driver.findElement(By.cssSelector(".fa.fa-times-circle-o")).click();
        System.out.println("video was closed");

    }
    //Extension_Support (Contact us form)  https://www.iwdagency.com/

    public static void Verify_Extension_Support_Contact_us_form(WebDriver driver) throws InterruptedException {



        WebDriverWait wait1 = new WebDriverWait(driver, 10);
        wait1.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("iframe[src='https://joe568.typeform.com/to/ecFKHU?typeform-embed=popup-classic']")));
        driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[src='https://joe568.typeform.com/to/ecFKHU?typeform-embed=popup-classic']")));



        driver.findElement(By.cssSelector("div[class='content'] div[class='button general full enabled hover-effect']")).click();
        driver.findElement(By.id("45706099")).click();

        driver.findElement(By.cssSelector("li[id='36032111'] input[type='text']")).click();
        driver.findElement(By.cssSelector("li[id='36032111'] input[type='text']")).sendKeys("test");
        driver.findElement(By.cssSelector("li[id='36032111'] span[class='confirm']")).click();
        driver.findElement(By.cssSelector("li[id='36032182'] input[type='text']")).click();
        driver.findElement(By.cssSelector("li[id='36032182'] input[type='text']")).sendKeys("1222333444555");
        driver.findElement(By.cssSelector("li[id='36032182'] span[class='confirm']")).click();
        driver.findElement(By.cssSelector("li[id='36032179'] input[type='text']")).click();
        driver.findElement(By.cssSelector("li[id='36032179'] input[type='text']")).sendKeys("testiwd@gmail.com");
        driver.findElement(By.cssSelector("li[id='36032179'] span[class='confirm']")).click();
        driver.findElement(By.cssSelector("li[id='36032232'] .textarea-wrapper>textarea")).click();
        driver.findElement(By.cssSelector("li[id='36032232'] .textarea-wrapper>textarea")).sendKeys("IWD-test");
        driver.findElement(By.cssSelector("li[id='36032232'] span[class='confirm']")).click();
        driver.findElement(By.cssSelector("li[id='36033432'] .textarea-wrapper>textarea")).click();
        driver.findElement(By.cssSelector("li[id='36033432'] .textarea-wrapper>textarea")).sendKeys("IWD-test-comment");
        driver.findElement(By.cssSelector("li[id='36033432'] span[class='confirm']")).click();
        driver.findElement(By.cssSelector("div[class='button-wrapper submit'] div[class='button general hover-effect enabled']"));
        System.out.println("Submit button was found");
        driver.switchTo().defaultContent();
        driver.findElement(By.cssSelector(".typeform-wrapper.show.drawer>img")).click();
        System.out.println("Test Contact us form passed");

    }

    //Health Check https://www.iwdagency.com/health-check/

    public static void Verify_Title_Health_Check(WebDriver driver) {

        String actualTitle = driver.getTitle();
        System.out.println(actualTitle);
        String expectedTitle = "Free Magento Security Audit & Health Check";
        assertEquals(expectedTitle, actualTitle);
        System.out.println("Title is correct");

    }

    public static void Verify_Start_Scan_Health_Check(WebDriver driver) {

        driver.findElement(By.cssSelector("form[id='health_check__scan_store'] input[name='site_url']")).sendKeys("https://www.iwdagency.com/extensions/");
        driver.findElement(By.cssSelector("#health_check__scan_store>button")).click();

        WebDriverWait wait1 = new WebDriverWait(driver, 10);
        try {
        wait1.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#healthcheck__overlay")));
        wait1.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("#healthcheck__overlay")));
        } catch (org.openqa.selenium.NoSuchElementException | TimeoutException e) {
            System.out.println("#healthcheck__overlay not visible");

    //.health_cheack__cancel

        }}

        public static void Verify_Link_Health_Check(WebDriver driver){

        String TextLink = driver.findElement(By.cssSelector(".site_url")).getText();
        System.out.println(TextLink);
        String expectedlink = "https://www.iwdagency.com/extensions/";
        assertEquals(TextLink, expectedlink);
        System.out.println("Link is correct");

        }

    public static void Verify_All_Buttons_on_page_Health_Check(WebDriver driver){

        String Button_learn_more_Link = driver.findElement(By.cssSelector(".button")).getAttribute("href");
        System.out.println(Button_learn_more_Link);
        String expectedlink = "https://www.iwdagency.com/magento-support";
        assertEquals(Button_learn_more_Link, expectedlink);
        System.out.println("Link is correct");

        String Help_center = driver.findElement(By.cssSelector(".health_check__scan_button>a")).getAttribute("href");
        System.out.println(Help_center);
        String expectedlink2 = "https://www.iwdagency.com/help/health-check";
        assertEquals(Help_center, expectedlink2);
        System.out.println("Link is correct");


    }

    public static void Verify_Scan_My_Store_Health_Check(WebDriver driver) {

        driver.findElement(By.cssSelector("form[id='health_check__site_url'] input[name='site_url']")).sendKeys("https://www.iwdagency.com/extensions/");
        driver.findElement(By.cssSelector("#health_check__site_url>button")).click();

        WebDriverWait wait1 = new WebDriverWait(driver, 10);
        try {
            wait1.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#healthcheck__overlay")));
            wait1.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("#healthcheck__overlay")));
        } catch (org.openqa.selenium.NoSuchElementException | TimeoutException e) {
            System.out.println("#healthcheck__overlay not visible");
        }
        String TextLink1 = driver.findElement(By.cssSelector(".site_url")).getText();
        System.out.println(TextLink1);
        String expectedlink1 = "https://www.iwdagency.com/extensions/";
        assertEquals(TextLink1, expectedlink1);
        System.out.println("Link is correct https://www.iwdagency.com/extensions");

        driver.findElement(By.cssSelector(".health_check__remove.fa.fa-times")).click();
        wait1.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".site_url")));
        System.out.println("Link was removed");

        driver.findElement(By.cssSelector("form[id='health_check__scan_url'] input[name='site_url']")).sendKeys("http://dev.weeetail.com/extensions/");
        driver.findElement(By.cssSelector("#health_check__scan_url>button")).click();

        try {
        wait1.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#healthcheck__overlay")));
        wait1.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("#healthcheck__overlay")));
        } catch (org.openqa.selenium.NoSuchElementException | TimeoutException e) {
        System.out.println("#healthcheck__overlay not visible");
        }

        String TextLink2 = driver.findElement(By.cssSelector(".site_url")).getText();
        System.out.println(TextLink2);
        String expectedlink2 = "http://dev.weeetail.com/extensions/";
        assertEquals(TextLink2, expectedlink2);
        System.out.println("Link is correct dev.m2ce.deviwd.com");
    }
    //Meet the team
    public static void Verify_current_url_Meet_the_team(WebDriver driver) {

        String currentURL = driver.getCurrentUrl();
        System.out.println(currentURL);
        String expectedcurrentURL = "https://www.iwdagency.com/#meet-the-team";
        assertEquals(currentURL, expectedcurrentURL);
        System.out.println("Link is correct https://www.iwdagency.com/#meet-the-team");
    }

    public static void Verify_buttons_left_right_Meet_the_team(WebDriver driver) throws InterruptedException {

        WebDriverWait wait1 = new WebDriverWait(driver, 10);
        wait1.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span[class='fa fa-chevron-circle-left']")));
        wait1.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span[class='fa fa-chevron-circle-right']")));
        System.out.println("Right and left buttons were found");

        driver.findElement(By.cssSelector("span[class='fa fa-chevron-circle-left']")).click();
        driver.findElement(By.cssSelector("span[class='fa fa-chevron-circle-left']")).click();
        driver.findElement(By.cssSelector("span[class='fa fa-chevron-circle-left']")).click();
        driver.findElement(By.cssSelector("span[class='fa fa-chevron-circle-right']")).click();
        driver.findElement(By.cssSelector("span[class='fa fa-chevron-circle-right']")).click();
        driver.findElement(By.cssSelector("span[class='fa fa-chevron-circle-right']")).click();
        driver.findElement(By.cssSelector("span[class='fa fa-chevron-circle-left']")).click();
        driver.findElement(By.cssSelector("span[class='fa fa-chevron-circle-left']")).click();
        driver.findElement(By.cssSelector("span[class='fa fa-chevron-circle-left']")).click();
        System.out.println("Functionality of right and left buttons works");

    }

    //Portfolio https://www.iwdagency.com/portfolio

    public static void Verify_Title_link_Portfolio(WebDriver driver) {

        String actualTitle = driver.getTitle();
        System.out.println(actualTitle);
        String expectedTitle = "IWD Agency's Portfolio";
        assertEquals(expectedTitle, actualTitle);
        System.out.println("Title is correct");

        String currentURL = driver.getCurrentUrl();
        System.out.println(currentURL);
        String expectedcurrentURL = "https://www.iwdagency.com/portfolio";
        assertEquals(currentURL, expectedcurrentURL);
        System.out.println("Link is correct https://www.iwdagency.com/portfolio");

    }
    public static void Verify_ALL_Shops_Links_Portfolio(WebDriver driver) {

        String text_Penn_State_Creamery = driver.findElement(By.cssSelector("div[class='portfolio-item-new'] a[href='/penn-state-creamery'] span[class='name']")).getText();
        System.out.println(text_Penn_State_Creamery);
        String expected_Penn_State_Creamery = "PENN STATE CREAMERY";
        assertEquals(expected_Penn_State_Creamery, text_Penn_State_Creamery);
        System.out.println("Penn State Creamery was found");

        String text_Buga_Nation = driver.findElement(By.cssSelector("div[class='portfolio-item-new'] a[href='/buga-nation'] span[class='name']")).getText();
        System.out.println(text_Buga_Nation);
        String expected_Buga_Nation = "BUGA NATION";
        assertEquals(expected_Buga_Nation, text_Buga_Nation);
        System.out.println("Buga Nation was found");

        String text_Marucci = driver.findElement(By.cssSelector("div[class='portfolio-item-new'] a[href='/marucci-sporting-goods'] span[class='name']")).getText();
        System.out.println(text_Marucci);
        String expected_Marucci = "MARUCCI";
        assertEquals(expected_Marucci, text_Marucci);
        System.out.println("Marucci was found");

        String text_EvoShield = driver.findElement(By.cssSelector("div[class='portfolio-item-new'] a[href='/atlanta-georgia'] span[class='name']")).getText();
        System.out.println(text_EvoShield);
        String expected_EvoShield = "EVOSHIELD";
        assertEquals(expected_EvoShield, text_EvoShield);
        System.out.println("EvoShield was found");

        String text_Golf_SkiWarehouse = driver.findElement(By.cssSelector("div[class='portfolio-item-new'] a[href='/golf-ski-warehouse'] span[class='name']")).getText();
        System.out.println(text_Golf_SkiWarehouse);
        String expected_Golf_SkiWarehouse = "GOLF & SKI WAREHOUSE";
        assertEquals(expected_Golf_SkiWarehouse, text_Golf_SkiWarehouse);
        System.out.println("GOLF & SKI WAREHOUSE was found");

        String text_tasc_Performance = driver.findElement(By.cssSelector("div[class='portfolio-item-new'] a[href='/new-orleans'] span[class='name']")).getText();
        System.out.println(text_tasc_Performance);
        String expected_tasc_Performance = "TASC PERFORMANCE";
        assertEquals(expected_tasc_Performance, text_tasc_Performance);
        System.out.println("TASC PERFOMANCE was found");

        String text_Piccadilly = driver.findElement(By.cssSelector("div[class='portfolio-item-new'] a[href='/restaurant-web-development'] span[class='name']")).getText();
        System.out.println(text_Piccadilly);
        String expected_Piccadilly = "PICCADILLY";
        assertEquals(expected_Piccadilly, text_Piccadilly);
        System.out.println("PICCADILLY was found");

        String text_Railing_Dynamics = driver.findElement(By.cssSelector("div[class='portfolio-item-new'] a[href='/new-jersey-magento-development'] span[class='name']")).getText();
        System.out.println(text_Railing_Dynamics);
        String expected_Railing_Dynamics = "RAILING DYNAMICS";
        assertEquals(expected_Railing_Dynamics, text_Railing_Dynamics);
        System.out.println("RAILING DYNAMICS was found");

        String text_Storyville = driver.findElement(By.cssSelector("div[class='portfolio-item-new'] a[href='/austin-texas'] span[class='name']")).getText();
        System.out.println(text_Storyville);
        String expected_Storyville = "STORYVILLE";
        assertEquals(expected_Storyville, text_Storyville);
        System.out.println("Storyville was found");

        String text_Lemon_Drop_Gifts = driver.findElement(By.cssSelector("div[class='portfolio-item-new'] a[href='/oregon-magento-development'] span[class='name']")).getText();
        System.out.println(text_Lemon_Drop_Gifts);
        String expected_Lemon_Drop_Gifts = "LEMON DROP GIFTS";
        assertEquals(expected_Lemon_Drop_Gifts, text_Lemon_Drop_Gifts);
        System.out.println("LEMON DROP GIFTS was found");

        String text_Top_Gun_Supply = driver.findElement(By.cssSelector("div[class='portfolio-item-new'] a[href='/ohio-magento-ecommerce'] span[class='name']")).getText();
        System.out.println(text_Top_Gun_Supply);
        String expected_Top_Gun_Supply = "TOP GUN SUPPLY";
        assertEquals(expected_Top_Gun_Supply, text_Top_Gun_Supply);
        System.out.println("TOP GUN SUPPLY was found");

    }

    //BLOG https://www.iwdagency.com/blog
    public static void Verify_Title_link_Blog(WebDriver driver) {

        String actualTitle = driver.getTitle();
        System.out.println(actualTitle);
        String expectedTitle = "IWD Blog | Magento eCommerce Marketing & Related News | IWD Agency's Blog";
        assertEquals(expectedTitle, actualTitle);
        System.out.println("Title is correct");

        String currentURL = driver.getCurrentUrl();
        System.out.println(currentURL);
        String expectedcurrentURL = "https://www.iwdagency.com/blog";
        assertEquals(currentURL, expectedcurrentURL);
        System.out.println("Link is correct https://www.iwdagency.com/blog");

    }

    public static void Verify_Links_Blog(WebDriver driver) {

        String actual_eCommerce = driver.findElement(By.cssSelector("li[class='cat-item cat-item-2'] a[href='https://www.iwdagency.com/blog/category/ecommerce/']")).getText();
        System.out.println(actual_eCommerce);
        String expected_eCommerce = "ECOMMERCE";
        assertEquals(actual_eCommerce, expected_eCommerce);
        System.out.println("ECOMERCE was found");

        String actual_Magento = driver.findElement(By.cssSelector("li[class='cat-item cat-item-3'] a[href='https://www.iwdagency.com/blog/category/magento/']")).getText();
        System.out.println(actual_Magento);
        String expected_Magento = "MAGENTO";
        assertEquals(actual_Magento, expected_Magento);
        System.out.println("Magento was found");

        String actual_Marketing = driver.findElement(By.cssSelector("li[class='cat-item cat-item-4'] a[href='https://www.iwdagency.com/blog/category/marketing/']")).getText();
        System.out.println(actual_Marketing);
        String expected_Marketing = "MARKETING";
        assertEquals(actual_Marketing, expected_Marketing);
        System.out.println("Marketing was found");

    }

    public static void Verify_Title_link_Checkout_suite(WebDriver driver) {

        String actualTitle = driver.getTitle();
        System.out.println(actualTitle);
        String expectedTitle = "Magento One Step & Page Checkout Extension";
        assertEquals(actualTitle, expectedTitle);
        System.out.println("Title is correct");

        String currentURL = driver.getCurrentUrl();
        System.out.println(currentURL);
        String expectedcurrentURL = "https://www.iwdagency.com/extensions/one-step-page-checkout.html";
        assertEquals(currentURL, expectedcurrentURL);
        System.out.println("Link is correct https://www.iwdagency.com/extensions/one-step-page-checkout.html");

    }

    //B2B eCommerce Suite

    public static void Verify_title_link_b2b(WebDriver driver) {

        String actualTitle = driver.getTitle();
        System.out.println(actualTitle);
        String expectedTitle = "Magento B2B eCommerce Extension | Wholesale Software";
        assertEquals(actualTitle, expectedTitle);
        System.out.println("Title is correct");

        String currentURL = driver.getCurrentUrl();
        System.out.println(currentURL);
        String expectedcurrentURL = "https://www.iwdagency.com/extensions/b2b-wholesale-suite.html";
        assertEquals(currentURL, expectedcurrentURL);
        System.out.println("Link is correct https://www.iwdagency.com/extensions/b2b-wholesale-suite.html");

    }

    public static void Verify_guides_button_b2b(WebDriver driver) {

        driver.findElement(By.cssSelector("div[class='demos-guides-link'] button[class='demos-guides-button']")).click();
        String user_guide = driver.findElement(By.cssSelector("li[class='link-button user-guide'] a[href='https://www.iwdagency.com/help/m2-b2b-suite/b2b-suite-2-settings']")).getText();
        System.out.println(user_guide);
        String expected_user_guide = "User Guide";
        assertEquals(user_guide, expected_user_guide);
        System.out.println("user_guide is correct");

        String installation_guide = driver.findElement(By.cssSelector("li[class='link-button install-guide'] a[href='https://www.iwdagency.com/help/general-information/installing-iwd-extensions']")).getText();
        System.out.println(installation_guide);
        String expected_installation_guide = "Installation Guide";
        assertEquals(installation_guide, expected_installation_guide);
        System.out.println("installation_guide is correct");
        String homePage = driver.getWindowHandle();

        driver.findElement(By.cssSelector("li[class='link-button user-guide'] a[href='https://www.iwdagency.com/help/m2-b2b-suite/b2b-suite-2-settings']")).click();

        Set<String> windows = driver.getWindowHandles();
        //System.out.println(windows.size());

        Iterator iterator = windows.iterator();
        String currentWindowId;

        while(iterator.hasNext()){
            currentWindowId = iterator.next().toString();
            //System.out.println(currentWindowId);

            if(!currentWindowId.equals(homePage)) {
                driver.switchTo().window(currentWindowId);

                String actualTitle = driver.getTitle();
                System.out.println(actualTitle);
                String expectedTitle = "[M2] B2B Suite Settings - IWD Agency Support Center";
                assertEquals(actualTitle, expectedTitle);
                System.out.println("Title of page is correct");

                String b2b_suite_settings = driver.findElement(By.cssSelector(".header-title")).getText();
                System.out.println(b2b_suite_settings);
                String expected_b2b_suite_settings = "[M2] B2B Suite Settings";
                assertEquals(b2b_suite_settings, expected_b2b_suite_settings);
                System.out.println("[M2] B2B Suite Settings is correct");

                driver.findElement(By.cssSelector("a[href='#DefaultSettings']"));
                driver.findElement(By.cssSelector("a[href='#Access']"));
                driver.findElement(By.cssSelector("a[href='#Registration']"));
                driver.findElement(By.cssSelector("a[href='#Requester']"));
                driver.findElement(By.cssSelector("a[href='#Notifications']"));
                driver.findElement(By.cssSelector("a[href='#Tables']"));
                driver.findElement(By.cssSelector("a[href='#Download']"));
                driver.findElement(By.cssSelector("a[href='#Order']"));
                driver.findElement(By.cssSelector("a[href='#Account']"));
                driver.findElement(By.cssSelector("a[href='#Credit']"));
                driver.findElement(By.cssSelector("a[href='#Guest']"));
                driver.findElement(By.cssSelector("a[href='#Matrix']"));

                driver.close();
                driver.switchTo().window(homePage);
                driver.findElement(By.cssSelector("div[class=\"md-content es-wrapper\"] a[class=\"close\"]")).click();
                System.out.println("Test Verify_guides_button_b2b is done");

            }}}

            public static void Verify_installation_guide_button_b2b(WebDriver driver) {

                String homePage2 = driver.getWindowHandle();


                driver.findElement(By.cssSelector("div[class='demos-guides-link'] button[class='demos-guides-button']")).click();
                driver.findElement(By.cssSelector("li[class='link-button install-guide'] a[href='https://www.iwdagency.com/help/general-information/installing-iwd-extensions']")).click();
                Set<String> windows2 = driver.getWindowHandles();
                //System.out.println(windows.size());

                Iterator iterator2 = windows2.iterator();
                String currentWindowId2;

                while(iterator2.hasNext()){
                    currentWindowId2 = iterator2.next().toString();
                    //System.out.println(currentWindowId);

                    if(!currentWindowId2.equals(homePage2)) {
                        driver.switchTo().window(currentWindowId2);

                        String actualtitle_Installing = driver.getTitle();
                        System.out.println(actualtitle_Installing);
                        String expectedtitle_Installing = "Installing IWD Extensions - IWD Agency Support Center";
                        assertEquals(actualtitle_Installing, expectedtitle_Installing);
                        System.out.println("Title of page Installing is correct");

                        String installing_iwd_extensions = driver.findElement(By.cssSelector(".header-title")).getText();
                        System.out.println(installing_iwd_extensions);
                        String expected_installing_iwd_extensions = "Installing IWD Extensions";
                        assertEquals(installing_iwd_extensions, expected_installing_iwd_extensions);
                        System.out.println("Installing IWD Extensions is correct");

                        driver.findElement(By.cssSelector("a[href='#MAGENTO 1 INSTALLATION']"));
                        driver.findElement(By.cssSelector("a[href='#MAGENTO 2 INSTALLATION']"));
                        driver.findElement(By.cssSelector("a[href='#ACTIVATING LICENSES']"));
                        driver.findElement(By.cssSelector("a[href='/extensions/media/modules/m2/iwd_all.zip']"));
                        driver.findElement(By.cssSelector("a[href='/extensions/downloadable/customer/products']"));
                        driver.findElement(By.cssSelector("a[href='https://iwdagency.com/help/general-information/installing-iwd-all"));

                        driver.close();
                        driver.switchTo().window(homePage2);
                        driver.findElement(By.cssSelector("div[class=\"md-content es-wrapper\"] a[class=\"close\"]")).click();

                    }
                }
            }
    public static void Verify_get_started_price_b2b(WebDriver driver) throws InterruptedException {

        //M1
        driver.findElement(By.cssSelector("a[href=\"/extensions/b2b-wholesale-suite.html?editions=magento-1&plans=Monthly\"]")).click();

        WebDriverWait wait_for_popup = new WebDriverWait(driver, 10);
        wait_for_popup.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ajaxcart-content")));


        String actual_price_m1 = driver.findElement(By.cssSelector("#product-price-44")).getText();
        System.out.println(actual_price_m1);
        String expected_price_m1 = "$50 /mo";
        assertEquals(expected_price_m1, actual_price_m1);
        System.out.println("$50 /mo was found");

        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#options_105_text")).sendKeys("test.com");
        driver.findElement(By.cssSelector(".button.btn-add-to-cart.left")).click();

        String actual_price_m1_shopping_cart = driver.findElement(By.cssSelector("div[class=\"cart-price\"] span[class=\"price\"]")).getText();
        System.out.println(actual_price_m1_shopping_cart);
        String expected_price_m1_shopping_cart = "$50.00";
        assertEquals(expected_price_m1_shopping_cart, actual_price_m1_shopping_cart);
        System.out.println("Price $50 in shopping cart is right ");

        driver.findElement(By.cssSelector(".fa.fa-times")).click();
        driver.findElement(By.cssSelector("div[class='cart-empty'] a[href='https://www.iwdagency.com/extensions/']"));
        driver.findElement(By.cssSelector("ul[class='services'] a[href='/extensions/b2b-wholesale-suite.html']")).click();

        //M2 Bronze

        driver.findElement(By.cssSelector("a[href=\"/extensions/b2b-wholesale-suite.html?editions=magento-2&plans=Bronze\"]")).click();
        wait_for_popup.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ajaxcart-content")));
        wait_for_popup.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#select_-177328")));

        String actual_price_m2_bronze = driver.findElement(By.cssSelector("#product-price-44")).getText();
        System.out.println(actual_price_m2_bronze);
        String expected_price_m2_bronze = "$50 /mo";
        assertEquals(actual_price_m2_bronze, expected_price_m2_bronze);
        System.out.println("$50 /mo was found for m2");

        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#options_105_text")).sendKeys("test.com");
        driver.findElement(By.cssSelector(".button.btn-add-to-cart.left")).click();

        String actual_price_m2_bronze_shopping_cart = driver.findElement(By.cssSelector("div[class=\"cart-price\"] span[class=\"price\"]")).getText();
        System.out.println(actual_price_m2_bronze_shopping_cart);
        String expected_price_m2_bronze_shopping_cart = "$50.00";
        assertEquals(expected_price_m2_bronze_shopping_cart, actual_price_m2_bronze_shopping_cart);
        System.out.println("Price $50 in shopping cart is right for m2");

        driver.findElement(By.cssSelector(".fa.fa-times")).click();
        driver.findElement(By.cssSelector("div[class='cart-empty'] a[href='https://www.iwdagency.com/extensions/']"));
        driver.findElement(By.cssSelector("ul[class='services'] a[href='/extensions/b2b-wholesale-suite.html']")).click();

        // M2 Silver

        driver.findElement(By.cssSelector("a[href=\"/extensions/b2b-wholesale-suite.html?editions=magento-2&plans=Silver\"]")).click();
        wait_for_popup.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ajaxcart-content")));
        wait_for_popup.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#select_-177328")));


        String actual_price_m2_silver = driver.findElement(By.cssSelector("#product-price-44")).getText();
        System.out.println(actual_price_m2_silver);
        String expected_price_m2_silver = "$250 /mo";
        assertEquals(expected_price_m2_silver, actual_price_m2_silver);
        System.out.println("$250 /mo was found for m2");

        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#options_105_text")).sendKeys("test.com");
        driver.findElement(By.cssSelector(".button.btn-add-to-cart.left")).click();

        String actual_price_m2_silver_shopping_cart = driver.findElement(By.cssSelector("div[class=\"cart-price\"] span[class=\"price\"]")).getText();
        System.out.println(actual_price_m2_silver_shopping_cart);
        String expected_price_m2_silver_shopping_cart = "$250.00";
        assertEquals(expected_price_m2_silver_shopping_cart, actual_price_m2_silver_shopping_cart);
        System.out.println("Price $250 in shopping cart is right for m2");

        driver.findElement(By.cssSelector(".fa.fa-times")).click();
        driver.findElement(By.cssSelector("div[class='cart-empty'] a[href='https://www.iwdagency.com/extensions/']"));
        driver.findElement(By.cssSelector("ul[class='services'] a[href='/extensions/b2b-wholesale-suite.html']")).click();

        //M2 Bronze M2 Gold

        driver.findElement(By.cssSelector("a[href=\"/extensions/b2b-wholesale-suite.html?editions=magento-2&plans=Gold\"]")).click();
        wait_for_popup.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ajaxcart-content")));
        wait_for_popup.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#select_-177328")));

        String actual_price_m2_gold = driver.findElement(By.cssSelector("#product-price-44")).getText();
        System.out.println(actual_price_m2_gold);
        String expected_price_m2_gold = "$500 /mo";
        assertEquals(expected_price_m2_gold, actual_price_m2_gold);
        System.out.println("$500 /mo was found for m2");

        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#options_105_text")).sendKeys("test.com");
        driver.findElement(By.cssSelector(".button.btn-add-to-cart.left")).click();

        String actual_price_m2_gold_shopping_cart = driver.findElement(By.cssSelector("div[class=\"cart-price\"] span[class=\"price\"]")).getText();
        System.out.println(actual_price_m2_gold_shopping_cart);
        String expected_price_m2_gold_shopping_cart = "$500.00";
        assertEquals(expected_price_m2_gold_shopping_cart, actual_price_m2_gold_shopping_cart);
        System.out.println("Price $500 in shopping cart is right for m2");

        driver.findElement(By.cssSelector(".fa.fa-times")).click();
        driver.findElement(By.cssSelector("div[class='cart-empty'] a[href='https://www.iwdagency.com/extensions/']"));
        driver.findElement(By.cssSelector("ul[class='services'] a[href='/extensions/b2b-wholesale-suite.html']")).click();

        //M2 Bronze M2 Platinum

        driver.findElement(By.cssSelector("a[href=\"/extensions/b2b-wholesale-suite.html?editions=magento-2&plans=Platinum\"]")).click();
        wait_for_popup.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ajaxcart-content")));
        wait_for_popup.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#select_-177328")));

        String actual_price_m2_platinum = driver.findElement(By.cssSelector("#product-price-44")).getText();
        System.out.println(actual_price_m2_platinum);
        String expected_price_m2_platinum = "$1000 /mo";
        assertEquals(expected_price_m2_platinum, actual_price_m2_platinum);
        System.out.println("$1000 /mo was found for m2");

        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#options_105_text")).sendKeys("test.com");
        driver.findElement(By.cssSelector(".button.btn-add-to-cart.left")).click();

        String actual_price_m2_platinum_shopping_cart = driver.findElement(By.cssSelector("div[class=\"cart-price\"] span[class=\"price\"]")).getText();
        System.out.println(actual_price_m2_platinum_shopping_cart);
        String expected_price_m2_platinum_shopping_cart = "$1,000.00";
        assertEquals(expected_price_m2_platinum_shopping_cart, actual_price_m2_platinum_shopping_cart);
        System.out.println("Price $1,000.00 in shopping cart is right for m2");

        driver.findElement(By.cssSelector(".fa.fa-times")).click();
        driver.findElement(By.cssSelector("div[class='cart-empty'] a[href='https://www.iwdagency.com/extensions/']"));
        driver.findElement(By.cssSelector("ul[class='services'] a[href='/extensions/b2b-wholesale-suite.html']")).click();

        //M2 Bronze M2 Diamond

        driver.findElement(By.cssSelector("a[href=\"/extensions/b2b-wholesale-suite.html?editions=magento-2&plans=Diamond\"]")).click();
        wait_for_popup.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ajaxcart-content")));
        wait_for_popup.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#select_-177328")));

        String actual_price_m2_diamond = driver.findElement(By.cssSelector("#product-price-44")).getText();
        System.out.println(actual_price_m2_diamond);
        String expected_price_m2_diamond = "$2000 /mo";
        assertEquals(expected_price_m2_diamond, actual_price_m2_diamond);
        System.out.println("$2000 /mo was found for m2");

        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#options_105_text")).sendKeys("test.com");
        driver.findElement(By.cssSelector(".button.btn-add-to-cart.left")).click();

        String actual_price_m2_diamond_shopping_cart = driver.findElement(By.cssSelector("div[class=\"cart-price\"] span[class=\"price\"]")).getText();
        System.out.println(actual_price_m2_diamond_shopping_cart);
        String expected_price_m2_diamond_shopping_cart = "$2,000.00";
        assertEquals(expected_price_m2_diamond_shopping_cart, actual_price_m2_diamond_shopping_cart);
        System.out.println("Price $2,000.00 in shopping cart is right for m2");

        driver.findElement(By.cssSelector(".fa.fa-times")).click();
        driver.findElement(By.cssSelector("div[class='cart-empty'] a[href='https://www.iwdagency.com/extensions/']"));
        driver.findElement(By.cssSelector("ul[class='services'] a[href='/extensions/b2b-wholesale-suite.html']")).click();




    }
}

