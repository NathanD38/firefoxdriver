import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FirefoxDriverTest {
    private static WebDriver driver;

    @BeforeClass
    public static void runOnceBeforeClass() {
        System.setProperty("webdriver.gecko.driver", Constants.FIREFOXDRIVER_PATH);
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void test_01() {
        driver.get("https://www.mozilla.org/");
    }

    @AfterClass
    public static void afterAll() {
//        driver.quit();
    }
}
