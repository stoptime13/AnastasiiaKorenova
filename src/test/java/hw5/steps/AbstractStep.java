package hw5.steps;

import hw5.context.TestContext;
import org.openqa.selenium.WebDriver;
import pages.DifferentElementsPage;
import pages.HomePage;
import page.UserTable;


public class AbstractStep {
    protected static WebDriver driver;
    protected static HomePage homePage;
    protected static DifferentElementsPage diffElement;
    protected static UserTable userTable;

    public AbstractStep() {
        driver = TestContext.getInstance().getObject("driver");
        homePage = new HomePage(driver);
        diffElement = new DifferentElementsPage(driver);
        userTable = new UserTable(driver);
    }
}