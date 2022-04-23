package hw3.ex2;

import hw3.BeforeAfterTestHw3;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import page.DifferentElementsPage;
import page.HomePage;
import page.UserLogin;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;



public class TestEx2 extends BeforeAfterTestHw3 {

    @Test
    public void testEx2() {
        HomePage homePage = new HomePage(driver);
        UserLogin userLogin = new UserLogin(driver);

        //Exercise 2 (1 - Open test site by URL)
        homePage.openURL(properties.getProperty("url"));

        //Exercise 2 (2 - Assert Browser title)
        softAssert.assertEquals(driver.getTitle(), "Home Page");

        //Exercise 2 (3 - Perform login)
        userLogin.loginUser(properties.getProperty("login"), properties.getProperty("passwd"));

        //Exercise 2 (4 - Assert Username is loggined)
        softAssert.assertEquals(userLogin.getUserName(), "ROMAN IOVLEV");

        //Exercise 2 (5 - Open through the header menu Service -> Different Elements Page)
        homePage.getHeaderMenu().clickNavigationBarItem("SERVICE");
        homePage.clickDropdownMenu("DIFFERENT ELEMENTS");


        //Exercise 2 (6 - Select checkboxes)
        DifferentElementsPage diffEl = new DifferentElementsPage(driver);
        diffEl.clickCheckbox("Water");
        diffEl.clickCheckbox("Wind");

        //Exercise 2 (7 - Select radio)
        diffEl.clickRadiobox("Selen");

        //Exercise 2 (8 - Select in dropdown)
        diffEl.clickOption("Yellow");

        //Exercise 2 (9)
        String[] expected = {"Wind: condition changed to true",
                "Water: condition changed to true",
                "metal: value changed to Selen",
                "Colors: value changed to Yellow"
        };

        List<WebElement> logs = diffEl.getLogs();
        for (int i = 0; i < expected.length; i++) {
            softAssert.assertTrue(logs.get(i).isDisplayed());
            softAssert.assertTrue(logs.get(i).getText().contains(expected[i]));
        }

    }
}

