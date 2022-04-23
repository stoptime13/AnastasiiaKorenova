package page;

import elements.HeaderMenu;
import elements.LeftM;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage {

    private final HeaderMenu headerMenu;
    private final LeftM leftM;
    private final WebDriver driver;
    private final UserLogin userLogin;

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
        leftM = new LeftM(this.driver);
        userLogin = new UserLogin(driver);
        PageFactory.initElements(this.driver, this);
    }

    public void openURL(String url) {
        driver.get(url);
    }

    public HeaderMenu getHeaderMenu() {
        return this.headerMenu;
    }

    public LeftM getLeftM() {
        return leftM;
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