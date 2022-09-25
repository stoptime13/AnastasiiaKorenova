package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class DifferentElementsPage {

    @FindBy(css = "label[class='label-checkbox']")
    private List<WebElement> checkBoxes;

    @FindBy(css = "label[class='label-radio']")
    private List<WebElement> radioBoxes;

    @FindBy(css = "select[class='uui-form-element'] option")
    private List<WebElement> options;

    @FindBy(css = ".info-panel-body-log li")
    private List<WebElement> logs;

    public DifferentElementsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void clickCheckbox(final String item) {
        for (WebElement element : checkBoxes) {
            if (item.equals(element.getText())) {
                element.click();
                break;
            }
        }
    }

    public void clickRadiobox(final String item) {
        for (WebElement element : radioBoxes) {
            if (item.equals(element.getText())) {
                element.click();
                break;
            }
        }
    }

    public void clickOption(final String item) {
        for (WebElement element : options) {
            if (item.equals(element.getText())) {
                element.click();
                break;
            }
        }
    }

    public List<WebElement> getLogs() {
        return logs;//.stream();
//                .map(WebElement::getText)
//                .collect(Collectors.toList());
    }
}