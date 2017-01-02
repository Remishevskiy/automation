package practiceTestCases;

/**
 * Created by Император on 09.12.2016.
 */


        import org.openqa.selenium.WebDriver;

        import org.testng.annotations.Test;

public class MultipleTest {

    public WebDriver driver;

    @Test(priority = 3)

    public void One() {

        System.out.println("This is the Test Case number One");

    }

    @Test(priority = 1, enabled = false)

    public void Two() {

        System.out.println("This is the Test Case number Two");

    }

    @Test(priority = 2)

    public void Three() {

        System.out.println("This is the Test Case number Three");

    }

    @Test(priority = 0)

    public void Four() {

        System.out.println("This is the Test Case number Four");

    }

}

