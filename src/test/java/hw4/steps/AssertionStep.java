package hw4.steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class AssertionStep extends AbstractStep {
    SoftAssert softAssert;
    public AssertionStep(WebDriver driver) {
        super(driver);
        softAssert = new SoftAssert();
    }

    @Step("Exercise 1 (2 - Assert {browserTitle})")
    public void assertBrowserTitle(String browserTitle) {
        softAssert.assertEquals(driver.getTitle(), browserTitle);
    }

    @Step("Exercise 1 (4 - Assert {username} is loggined)")
    public void assertUsername(String username) {
        softAssert.assertEquals(homePage.getUserName(), username);
    }

    @Step("Exercise 1 (5 - Assert that there are 4 items on the header section are displayed and they have proper texts)")
    public void assertHeaderItems(String[] expectedName) {
        List<WebElement> navigationBar = homePage.getHeaderMenu().getNavigationItems();
        for(int i = 0; i < expectedName.length; i++){
            softAssert.assertEquals(navigationBar.get(i).getText(), expectedName[i]);
            softAssert.assertTrue(navigationBar.get(i).isDisplayed());
        }
    }

    @Step("Exercise 1 (6 - Assert that there are 4 images on the Index Page and they are displayed)")
    public void assertIcons() {
        List<WebElement> icons = homePage.getIcons();
        for(WebElement icon: icons){
            softAssert.assertTrue(icon.isDisplayed());
        }
    }

    @Step("Exercise 1 (7 - Assert that there are 4 texts on the Index Page under icons and they have proper text 4 texts below of each image Texts are displayed and equal to expected)")
    public void assertIconText(List<String> expectedText) {
        List<WebElement> benefit = homePage.getBenefitTxt();
        for(int i = 0; i < 4; i++){
            softAssert.assertEquals(benefit.get(i).getText(), expectedText.get(i));
        }
    }

    @Step("Exercise 1 (8 - Assert that there is the iframe with “Frame Button” exist)")
    public void assertFrame() {
        softAssert.assertTrue(homePage.getFrame().isDisplayed());
    }

    @Step("Exercise 1 (9 - Switch to the iframe and check that there is “Frame Button” in the iframe)")
    public void assertFrameButton() {
        softAssert.assertTrue(homePage.getFrameButton().isDisplayed());
    }

    @Step("Exercise 1 (10 - Switch to original window back)")
    public void assertOriginalWindow() {
        softAssert.assertEquals(driver.switchTo().activeElement(), homePage.getBody());
    }

    @Step("Exercise 1 (11 - Assert that there are 5 {items} in the Left Section are displayed and they have proper text)")
    public void assertLeftItems(String[] expectedHeader) {
        List<WebElement> nameHeader = homePage.getLeftMenu().getLeftMenuItems();
        for(int i =0; i < nameHeader.size(); i++){
            softAssert.assertEquals(nameHeader.get(i).getText(), expectedHeader[i]);
            softAssert.assertTrue(nameHeader.get(i).isDisplayed());
        }
    }

    @Step("Exercise 2 (9)")
    public void assertLogs(String[] expected) {
        List<WebElement> logs = differentElementsPage.getLogs();
        for (int i = 0; i < expected.length; i++) {
            softAssert.assertTrue(logs.get(i).isDisplayed());
            softAssert.assertTrue(logs.get(i).getText().contains(expected[i]));
        }
    }

    public void assertAll() {
        softAssert.assertAll();
    }
}