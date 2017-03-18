package IWDmainsiteProject.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.Iterator;
import java.util.Set;

import static org.testng.Assert.assertEquals;

/**
 * Created by Oleg on 10.02.2017.
 */
public class footer {


    public WebDriver driver;


    //
    static By reviews = By.cssSelector("div[class='wpb_wrapper'] a[href='../reviews']");

    //Footer social
    static By facebook = By.cssSelector("li[class='icon-facebook'] a[href='https://www.facebook.com/iwdagency']");
    static By blog = By.cssSelector("li[class='icon-blog'] a[href='/blog']");
    static By google = By.cssSelector("li[class='icon-google last'] a[href='https://plus.google.com/+Interiorwebdesign/posts']");

    //Footer
    static By magento_development = By.cssSelector("ul[class='services'] a[href='/magento-development']");
    static By b2b_wholesale = By.cssSelector("ul[class='services'] a[href='/extensions/b2b-wholesale-suite.html']");
    static By magento_support = By.cssSelector("ul[class='services'] a[href='/magento-support']");
    static By partner_program = By.cssSelector("ul[class='services'] a[href='/extensions/IWD_Partner_Program.pdf']");

    static By privacy_policy = By.cssSelector("a[href='/privacy-policy-cookie-restriction-mode']");
    static By terms_conditions = By.cssSelector("a[href='/terms-and-conditions']");
    static By all_rights_reserved = By.cssSelector(".copy");




    //Verify all elements in header
    public static void verify_all_elements_in_footer(WebDriver driver) {

        driver.findElement(facebook);
        driver.findElement(blog);
        driver.findElement(google);


        String actual_magento_development = driver.findElement(magento_development).getText();
        System.out.println(actual_magento_development);
        String expected_magento_development = "MAGENTO DEVELOPMENT1";//////////////////////1
        assertEquals(actual_magento_development, expected_magento_development);
        System.out.println("magento_development is correct");

        String actual_b2b_wholesale = driver.findElement(b2b_wholesale).getText();
        System.out.println(actual_b2b_wholesale);
        String expected_b2b_wholesale = "B2B / WHOLESALE";
        assertEquals(actual_b2b_wholesale, expected_b2b_wholesale);
        System.out.println("b2b_wholesale is correct");

        String actual_magento_support = driver.findElement(magento_support).getText();
        System.out.println(actual_magento_support);
        String expected_magento_support = "MAGENTO SUPPORT";
        assertEquals(actual_magento_support, expected_magento_support);
        System.out.println("magento_support is correct");

        String actual_partner_program = driver.findElement(partner_program).getText();
        System.out.println(actual_partner_program);
        String expected_partner_program = "PARTNER PROGRAM";
        assertEquals(actual_partner_program, expected_partner_program);
        System.out.println("partner_program is correct");

        String actual_privacy_policy = driver.findElement(privacy_policy).getText();
        System.out.println(actual_privacy_policy);
        String expected_privacy_policy = "PRIVACY POLICY";
        assertEquals(actual_privacy_policy, expected_privacy_policy);
        System.out.println("privacy_policy is correct");

        String actual_terms_conditions = driver.findElement(terms_conditions).getText();
        System.out.println(actual_terms_conditions);
        String expected_terms_conditions = "TERMS & CONDITIONS";
        assertEquals(actual_terms_conditions, expected_terms_conditions);
        System.out.println("terms_conditions is correct");

        String actual_all_rights_reserved = driver.findElement(all_rights_reserved).getText();
        System.out.println(actual_all_rights_reserved);
        String expected_all_rights_reserved = "IWD © 2015 ALL RIGHTS RESERVED";
        assertEquals(actual_all_rights_reserved, expected_all_rights_reserved);
        System.out.println("all_rights_reserved is correct");

    }


    //magento_development
    public static void Click_on_magento_development(WebDriver driver) {

        driver.findElement(magento_development).click();

    }


    public static void Click_on_b2b_wholesale(WebDriver driver) {

        driver.findElement(b2b_wholesale).click();

    }

    public static void Click_on_magento_support(WebDriver driver) {

        driver.findElement(magento_support).click();

    }

    public static void Click_on_partner_program(WebDriver driver) {

        driver.findElement(partner_program).click();

    }

    public static void Click_on_privacy_policy(WebDriver driver) {

        driver.findElement(privacy_policy).click();

    }

    public static void Click_on_terms_conditions(WebDriver driver) {

        driver.findElement(terms_conditions).click();

    }

    public static void Click_on_facebook(WebDriver driver) {

        driver.findElement(facebook).click();

    }

    public static void Click_on_blog(WebDriver driver) {

        String homePage = driver.getWindowHandle();
        driver.findElement(blog).click();
        Set<String> windows = driver.getWindowHandles();


        Iterator iterator = windows.iterator();
        String currentWindowId;

        while(iterator.hasNext()) {
            currentWindowId = iterator.next().toString();
            if (!currentWindowId.equals(homePage)) {
                driver.switchTo().window(currentWindowId);
            }
        }

    }

    public static void Click_on_google(WebDriver driver) {

        driver.findElement(google).click();

    }

    public static void Click_on_reviews(WebDriver driver) {

        driver.findElement(reviews).click();

    }

}


