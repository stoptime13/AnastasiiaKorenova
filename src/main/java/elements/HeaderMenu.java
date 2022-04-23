package elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HeaderMenu {

    @FindBy(css = "nav[role = 'navigation']>ul>li")
    private List<WebElement> navigation;

    public HeaderMenu(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public List<WebElement> getNavigationItems() {
        return this.navigation;
    }

    public void clickNavigationBarItem(final String item) {
        for (WebElement element : navigation) {
            String l = element.getText();
            if (item.equals(element.getText())) {
                element.click();
                break;
            }
        }
    }

//    public WebElement getSubitemByText(String itemText, String subitemText) {
//        WebElement item = getItemByText(itemText);
//        item.click();
//        List<WebElement> subitems = item.findElements(By.tagName("li"));
//        for (WebElement sub : subitems) {
//            if (sub.getText().equals(subitemText)) {
//                return sub;
//            }
//        }
//        return null;
//    }

}