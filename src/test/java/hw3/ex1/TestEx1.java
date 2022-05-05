package hw3.ex1;

import hw3.BeforeAfterTestHw3;
import org.testng.asserts.SoftAssert;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.HomePage;

import java.util.List;


public class TestEx1 extends BeforeAfterTestHw3 {

    @Test
    public void testEx1() {
        HomePage homePage = new HomePage(driver);

        //Exercise 1 (1 - Open test site by URL)
        homePage.openURL(properties.getProperty("url"));

        //Exercise 1 (2 - Assert Browser title)
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(driver.getTitle(), "Home Page");

        //Exercise 1 (3 - Perform login)
        homePage.loginUser(properties.getProperty("login"), properties.getProperty("passwd"));

        //Exercise 1 (4 - Assert Username is loggined)
        softAssert.assertEquals(homePage.getUserName(), "ROMAN IOVLEV");

        //Exercise 1 (5 - Assert that there are 4 items on the header section are displayed and they have proper texts)
        List<WebElement> navigationBar = homePage.getHeaderMenu().getNavigationItems();
        String[] expectedName = {"HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS"};
        for(int i = 0; i < expectedName.length; i++){
            softAssert.assertEquals(navigationBar.get(i).getText(), expectedName[i]);
            softAssert.assertTrue(navigationBar.get(i).isDisplayed());
        }

        //Exercise 1 (6 - Assert that there are 4 images on the Index Page and they are displayed)
        List<WebElement> icons = homePage.getIcons();
        for(WebElement icon: icons){
            softAssert.assertTrue(icon.isDisplayed());
        }

        //Exercise 1 (7 - Assert that there are 4 texts on the Index Page under icons and they have proper text	4 texts below of each image	Texts are displayed and equal to expected)
        String[] expectedText = {"To include good practices\nand ideas from successful\nEPAM project",
                "To be flexible and\ncustomizable",
                "To be multiplatform",
                "Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more…"};
        List<WebElement> benefit = homePage.getBenefitTxt();
        for(int i = 0; i < 4; i++){
            softAssert.assertEquals(benefit.get(i).getText(), expectedText[i]);
        }

        //Exercise 1 (8 - Assert that there is the iframe with “Frame Button” exist)
        softAssert.assertTrue(homePage.getFrame().isDisplayed());

        //Exercise 1 (9 - Switch to the iframe and check that there is “Frame Button” in the iframe)
        driver.switchTo().frame("frame");
        softAssert.assertTrue(homePage.getFrameButton().isDisplayed());

        //Exercise 1 (10 - Switch to original window back)
        driver.switchTo().parentFrame();

        //Exercise 1 (11 - Assert that there are 5 items in the Left Section are displayed and they have proper text)
        String[] expectedHeader = {"Home", "Contact form", "Service", "Metals & Colors", "Elements packs"};
        List<WebElement> nameHeader = homePage.getLeftMenu().getLeftMenuItems();
        for(int i =0; i < nameHeader.size(); i++){
            softAssert.assertEquals(nameHeader.get(i).getText(), expectedHeader[i]);
            softAssert.assertTrue(nameHeader.get(i).isDisplayed());
        }
        softAssert.assertAll();
    }
}

