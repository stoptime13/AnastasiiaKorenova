package hw4.steps;

import hw4.BeforeAfterTestHw4;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class ActionStep extends AbstractStep{

    public ActionStep(WebDriver driver){
        super(driver);
    }

    @Step("Exercise 1 (1 - Open test site by URL)   ")
    public void openPage(){
        homePage.openURL(BeforeAfterTestHw4.properties.getProperty("url"));
    }

    @Step("Exercise 1 (3 - Perform login)")
    public void loginUser(String login, String passwd){
        homePage.loginUser(login, passwd);
    }

    @Step("Exercise 1 (9 - Switch to the iframe and check that there is “Frame Button” in the iframe {frame})")
    public void switchToFrame(String frame) {
        driver.switchTo().frame(frame);
    }

    @Step("Exercise 1 (10 - Switch to original window back)")
    public void switchParentFrame() {
        driver.switchTo().parentFrame();
    }

    @Step("Exercise 2 (5 - Open through the header menu Service -> Different Elements Page)")
    public void clickHeaderItem(){
        homePage.getHeaderMenu().clickNavigationBarItem("SERVICE");
        homePage.clickDropdownMenu("DIFFERENT ELEMENTS");
    }

    @Step("Exercise 2 (6 - Select {checkbox})")
    public void selectCheckbox(String checkbox) {
        differentElementsPage.clickCheckbox(checkbox);
    }

    @Step("Exercise 2 (7 - Select {radiobox})")
    public void selectRadio(String radiobox) {
        differentElementsPage.clickRadiobox(radiobox);
    }

    @Step("Exercise 2 (8 - Select in dropdown {optionItem})")
    public void selectOption(String optionItem) {
        differentElementsPage.clickOption(optionItem);
    }

}
