package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserLogin {
    @FindBy(css = "a[href = '#']")
    private WebElement loginSymbol;

    @FindBy(id = "name")
    private WebElement login;

    @FindBy(id = "password")
    private WebElement passwd;

    @FindBy(id = "login-button")
    private WebElement logButton;

    @FindBy(id = "user-name")
    private WebElement userName;

    public UserLogin(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void loginUser(String userName, String password) {
        this.loginSymbol.click();
        this.login.sendKeys(userName);
        this.passwd.sendKeys(password);
        this.logButton.click();
    }

    public String getUserName() {
        return this.userName.getText();
    }
}
