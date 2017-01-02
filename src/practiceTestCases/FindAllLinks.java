package practiceTestCases;

        import org.openqa.selenium.By;

        import org.openqa.selenium.Keys;
        import org.openqa.selenium.WebDriver;

        import org.openqa.selenium.WebElement;

        import org.openqa.selenium.firefox.FirefoxDriver;

public class FindAllLinks {

    public static void main(String[] args) {

        WebDriver driver = new FirefoxDriver();

        driver.get("http://toolsqa.com/");

        driver.findElement(By.name("s")).sendKeys(Keys.F5);

        /*java.util.List<WebElement> links = driver.findElements(By.tagName("a"));

        System.out.println(links.size());

        for (int i = 1; i<=links.size(); i=i+1)

        {

            System.out.println(links.get(i).getText());

        }

        java.util.List<WebElement> dropdown = driver.findElements(By.tagName("select"));

        System.out.println(dropdown.size());
    }
*/
}}
