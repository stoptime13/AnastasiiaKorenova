package hw2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class BeforeAfterTest {

    protected static SoftAssert softAssert;
    protected static WebDriver driver;

    @BeforeMethod
    public void init(){
        String path = "src/test/resources/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", path);

        softAssert = new SoftAssert();

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @AfterMethod
    public void closeSession(){
        driver.quit();
    }
}
