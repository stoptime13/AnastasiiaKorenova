package hw3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.asserts.SoftAssert;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BeforeAfterTestHw3 {

    protected static WebDriver driver;
    protected static Properties properties;

    @BeforeSuite
    public void initDriver(){
        String path = "src/test/resources/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", path);
    }

    @BeforeMethod
    public void init(){
        properties = new Properties();
        try (FileReader fr = new FileReader("src/test/resources/conf.properties");) {
            properties.load(fr);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @AfterMethod
    public void closeSession(){
        driver.quit();
    }
}