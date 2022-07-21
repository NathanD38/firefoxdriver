import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Set;

public class IsraelSecurityAuthorityTest {
    private static WebDriver driver;
    private static WebDriverWait wait;
    Logger logger = Logger.getInstance();


    @BeforeClass
    public static void runOnceBeforeClass() {
        System.setProperty("webdriver.chrome.driver", Constants.CHROMEDRIVER_PATH);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void test_01_openSite() {
        driver.get("https://www.new.isa.gov.il//");
    } //open main ISA website

    @Test
    public void test_02_switchToDropDown() {
        driver.findElement(By.cssSelector("button[class='btn close-dialog p-0']")).click(); //close welcome pop-up
        driver.findElement(By.id("dropdownMenuButton-0-2-1")).click(); //click on reports & updates dropdown
    }

    @Test
    public void test_03_clickOnReports() {
        driver.findElement(By.linkText("דוחות")).click(); //click on reports on dropdown menu
    }

    @Test
    public void test_04_chooseYearlyReports() {
        driver.findElement(By.linkText("דוחות שנתיים של הרשות")).click(); //yearly reports
    }

    @Test
    public void test_05_getAllYearlyReports() throws IOException {
        String parent = driver.getWindowHandle();
        Set<String> handles = driver.getWindowHandles();
        logger.clearFile();
        for (String windowHandle : handles) {
            if (!windowHandle.equals(parent)) {
                driver.switchTo().window(windowHandle);
//                driver.findElement(By.className("DivWebPartISATemplate9")).click(); //switch to td where list of reports exists
                List<WebElement> reports = driver.findElements(By.cssSelector(".VerticalLITemplate9Link > a"));
                for (WebElement report : reports) {
                    String yearlyReports = report.getAttribute("href");
                    logger.logToFile(yearlyReports);



                }
//                wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//                wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText("דוח שנתי"))).click();
//                driver.close(); //close child window
//                driver.switchTo().window(parent); //back to page of yearly reports
            }
        }
    }


    @AfterClass
    public static void afterAll() {
//        driver.quit();
    }
}
