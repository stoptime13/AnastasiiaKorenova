package pages;

import elements.HeaderMenu;
import elements.LeftElements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage {

    private final HeaderMenu headerMenu;
    private final LeftElements leftMenu;
    private final WebDriver driver;

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

    @FindBy(className = "benefit-icon")
    private List<WebElement> icon;

    @FindBy(className = "benefit-txt")
    private List<WebElement> benefitTxt;

    @FindBy(id = "frame")
    private WebElement frame;

    @FindBy(id = "frame-button")
    private WebElement frameButton;

    @FindBy(tagName = "body")
    private WebElement body;

    @FindBy(css = "ul[class = 'dropdown-menu'] li a")
    private List<WebElement> dropdownMenu;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        headerMenu = new HeaderMenu(this.driver);
        leftMenu = new LeftElements(this.driver);
        PageFactory.initElements(this.driver, this);
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

    public void openURL(String url) {
        driver.get(url);
    }

    public HeaderMenu getHeaderMenu() {
        return this.headerMenu;
    }

    public LeftElements getLeftMenu() {
        return leftMenu;
    }

    public void clickDropdownMenu(final String item) {
        for (WebElement element : dropdownMenu) {
            if (item.equals(element.getText())) {
                element.click();
                break;
            }
        }
    }

    public List<WebElement> getIcons() {
        return this.icon;
    }

    public List<WebElement> getBenefitTxt() {
        return this.benefitTxt;
    }

    public WebElement getFrame() {
        return this.frame;
    }

    public WebElement getFrameButton() {
        return this.frameButton;
    }

    public WebElement getBody() {
        return this.body;
    }

}