package hw3.ex2;

import hw3.BeforeAfterTestHw3;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.DifferentElementsPage;
import pages.HomePage;


import java.util.List;


public class TestEx2 extends BeforeAfterTestHw3 {

    @Test
    public void testEx2() {
        HomePage homePage = new HomePage(driver);

        //Exercise 2 (1 - Open test site by URL)
        homePage.openURL(properties.getProperty("url"));

        //Exercise 2 (2 - Assert Browser title)
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(driver.getTitle(), "Home Page");

        //Exercise 2 (3 - Perform login)
        homePage.loginUser(properties.getProperty("login"), properties.getProperty("passwd"));

        //Exercise 2 (4 - Assert Username is loggined)
        softAssert.assertEquals(homePage.getUserName(), "ROMAN IOVLEV");

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
        String[] expected = {"Colors: value changed to Yellow",
                "metal: value changed to Selen",
                "Wind: condition changed to true",
                "Water: condition changed to true"
        };

        List<WebElement> logs = diffEl.getLogs();
        for (int i = 0; i < expected.length; i++) {
            softAssert.assertTrue(logs.get(i).isDisplayed());
            softAssert.assertTrue(logs.get(i).getText().contains(expected[i]));
        }
        softAssert.assertAll();
    }
}

