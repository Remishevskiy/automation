package IWDmainsiteProject.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static org.testng.Assert.assertEquals;

/**
 * Created by Oleg on 10.02.2017.
 */
public class Header {


    public WebDriver driver;

    //BUILD_A_STORE
    static By BUILD_A_STORE = By.cssSelector(".build-store-menu a");
    static By Do_It_Yourself = By.cssSelector("a[href*='http://weeetail.com']");
    static By Work_With_A_Team = By.cssSelector("a[href*='/magento-development']");

    //OPTIMIZATION & SUPPORT
    static By OPTIMIZATION_SUPPORT = By.cssSelector(".optimization a");
    static By Store_Optimization_Support = By.cssSelector("a[href*='/magento-support']");
    static By Extension_Support = By.cssSelector("a[href*='https://joe568.typeform.com/to/ecFKHU']");
    static By Health_Check = By.cssSelector("a[href*='/health-check/']");

    //ABOUT
    static By ABOUT = By.cssSelector(".abount-menu a");
    static By Portfolio = By.cssSelector("a[href*='/portfolio']");
    static By Meet_the_team = By.cssSelector("a[href*='/#meet-the-team']");
    static By Blog = By.cssSelector("a[href*='/blog']");
    static By Contact_Us = By.cssSelector("li[class='last abount-menu sub-level'] a[href*='https://joe568.typeform.com/to/ecFKHU']");

    //Else
    static By Shopping_Cart = By.cssSelector(".fa.fa-shopping-cart");
    static By Message_Shopping_Cart = By.cssSelector("header[id='header'] .empty");
    static By User_Account = By.cssSelector("a[href*='https://www.iwdagency.com/extensions/downloadable/customer/products']");
    static By Magento_Extensions = By.cssSelector(".magento-extensions>span");
    static By Checkout_suite = By.cssSelector(".item.link-to-product.item-111");

    //Weeetail
    static By User_Account_Weeetail = By.cssSelector("a[href='https://www.iwdagency.com/weeetail/portal/account/']");



    //Verify all elements in header
    public static void Verify_all_elements_in_header(WebDriver driver) {

        driver.findElement(BUILD_A_STORE);
        driver.findElement(OPTIMIZATION_SUPPORT);
        driver.findElement(ABOUT);
        driver.findElement(Shopping_Cart);
        driver.findElement(User_Account);
        driver.findElement(Magento_Extensions);
        System.out.println("Verify_all_elements_in_header is done, Pass");

    }

    public static void Verify_all_elements_in_header_weeetail(WebDriver driver) {

        driver.findElement(BUILD_A_STORE);
        driver.findElement(OPTIMIZATION_SUPPORT);
        driver.findElement(ABOUT);
        driver.findElement(Shopping_Cart);
        driver.findElement(User_Account_Weeetail);
        driver.findElement(Magento_Extensions);
        System.out.println("Verify_all_elements_in_header is done, Pass");

    }



    //BUILD_A_STORE
    public static void Move_to_Do_It_Yourself(WebDriver driver) {

        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(BUILD_A_STORE));

        actions.moveToElement(driver.findElement(Do_It_Yourself));
        actions.click().build().perform();

    }

    public static void Move_to_Work_With_A_Team(WebDriver driver) {

        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(BUILD_A_STORE));

        actions.moveToElement(driver.findElement(Work_With_A_Team));
        actions.click().build().perform();

    }

    //OPTIMIZATION & SUPPORT
    public static void Move_to_Store_Optimization_Support(WebDriver driver) {

        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(OPTIMIZATION_SUPPORT));

        actions.moveToElement(driver.findElement(Store_Optimization_Support));
        actions.click().build().perform();

    }

    public static void Move_to_Extension_Support(WebDriver driver) {

        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(OPTIMIZATION_SUPPORT));

        actions.moveToElement(driver.findElement(Extension_Support));
        actions.click().build().perform();

    }

    public static void Move_to_Health_Check(WebDriver driver) {

        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(OPTIMIZATION_SUPPORT));

        actions.moveToElement(driver.findElement(Health_Check));
        actions.click().build().perform();

    }

    //ABOUT

    public static void Move_to_Portfolio(WebDriver driver) {

        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(ABOUT));

        actions.moveToElement(driver.findElement(Portfolio));
        actions.click().build().perform();

    }

    public static void Move_to_Meet_the_team(WebDriver driver) {

        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(ABOUT));

        actions.moveToElement(driver.findElement(Meet_the_team));
        actions.click().build().perform();

    }

    public static void Move_to_Blog(WebDriver driver) {

        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(ABOUT));

        actions.moveToElement(driver.findElement(Blog));
        actions.click().build().perform();

    }

    public static void Move_to_Contact_Us(WebDriver driver) {

        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(ABOUT));

        actions.moveToElement(driver.findElement(Contact_Us));
        actions.click().build().perform();

    }

    public static void Move_to_Shopping_cart(WebDriver driver) {

        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(Shopping_Cart));

        actions.moveToElement(driver.findElement(Message_Shopping_Cart));
        actions.build().perform();
        String actual_Shopping_cart = driver.findElement(By.cssSelector("header[id='header'] p[class='empty']")).getText();
        System.out.println(actual_Shopping_cart);
        String expected_Shopping_cart = "Your shopping cart is empty.";
        assertEquals(actual_Shopping_cart, expected_Shopping_cart);
        System.out.println("Your shopping cart is empty was found");

    }

    public static void Verify_Account_link(WebDriver driver) {

        String actual_User_Account = driver.findElement(User_Account).getAttribute("href");
        System.out.println(actual_User_Account);
        String expected_User_Account = "https://www.iwdagency.com/extensions/downloadable/customer/products";
        assertEquals(actual_User_Account, expected_User_Account);
        System.out.println("Account_link was found");

    }

    public static void Move_to_Checkout_suite(WebDriver driver) {

        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(Magento_Extensions));

        actions.moveToElement(driver.findElement(Checkout_suite));
        actions.click().build().perform();
        System.out.println("Checkout_suite was opened");


    }
}

