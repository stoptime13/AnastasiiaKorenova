package hw4;

import hw4.steps.ActionStep;
import hw4.steps.AssertionStep;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BeforeAfterTestHw4 {

    public static WebDriver driver;
    public static Properties properties;
    public static ActionStep actionStep;
    public static AssertionStep assertionStep;


    @BeforeSuite(description = "Set path to driver")
    public void initDriver(){
        String path = "src/test/resources/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", path);
    }

    @BeforeMethod(description = "Initial of class fields")
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

        actionStep = new ActionStep(driver);
        assertionStep = new AssertionStep(driver);

    }

    @AfterMethod(description = "Close browser")
    public void closeSession(){
        if(driver != null) {
            driver.quit();
        }
    }
}
