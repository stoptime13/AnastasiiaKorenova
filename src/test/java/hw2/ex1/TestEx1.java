package hw2.ex1;

import hw2.BeforeAfterTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class TestEx1 extends BeforeAfterTest {

    @Test
    public void testEx1(){

        //Exercise 1 (1 - Open test site by URL)
        driver.get("https://jdi-testing.github.io/jdi-light/index.html");

        //Exercise 1 (2 - Assert Browser title)
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(driver.getTitle(),"Home Page");

        //Exercise 1 (3 - Perform login)
        driver.findElement(By.cssSelector("a[href = '#']")).click();
        driver.findElement(By.id("name")).sendKeys("Roman");
        driver.findElement(By.id("password")).sendKeys("Jdi1234");
        driver.findElement(By.id("login-button")).click();

        //Exercise 1 (4 - Assert Username is loggined)
        softAssert.assertEquals(driver.findElement(By.id("user-name")).getText(), "ROMAN IOVLEV");

        //Exercise 1 (5 - Assert that there are 4 items on the header section are displayed and they have proper texts)
        String[] selectors = {"a[href=\"index.html\"]", "a[href=\"contacts.html\"]", ".dropdown-toggle", "a[href=\"metals-colors.html\"]"};
        String[] expectedName = {"HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS"};
        for(int i = 0; i < 4; i++){
            softAssert.assertEquals(driver.findElement(By.cssSelector(selectors[i])).getText(), expectedName[i]);
            softAssert.assertTrue(driver.findElement(By.cssSelector(selectors[i])).isDisplayed());
        }

        //Exercise 1 (6 - Assert that there are 4 images on the Index Page and they are displayed)
        softAssert.assertTrue(driver.findElement(By.cssSelector(".icon-practise")).isDisplayed());
        softAssert.assertTrue(driver.findElement(By.cssSelector(".icon-custom")).isDisplayed());
        softAssert.assertTrue(driver.findElement(By.cssSelector(".icon-multi")).isDisplayed());
        softAssert.assertTrue(driver.findElement(By.cssSelector(".icon-base")).isDisplayed());

        //Exercise 1 (7 - Assert that there are 4 texts on the Index Page under icons and they have proper text	4 texts below of each image	Texts are displayed and equal to expected)
        String[] expectedText = {"To include good practices\nand ideas from successful\nEPAM project",
                "To be flexible and\ncustomizable",
                "To be multiplatform",
                "Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more…"};
        List<WebElement> benefit = driver.findElements(By.className("benefit-txt"));
        for(int i = 0; i < 4; i++){
            softAssert.assertEquals(benefit.get(i).getText(), expectedText[i]);
        }

        //Exercise 1 (8 - Assert that there is the iframe with “Frame Button” exist)
        softAssert.assertTrue(driver.findElement(By.id("frame")).isDisplayed());

        //Exercise 1 (9 - Switch to the iframe and check that there is “Frame Button” in the iframe)
        driver.switchTo().frame(driver.findElement(By.tagName("iframe")));
        softAssert.assertTrue(driver.findElement(By.id("frame-button")).isDisplayed());

        //Exercise 1 (10 - Switch to original window back)
        driver.switchTo().parentFrame();

        //Exercise 1 (11 - Assert that there are 5 items in the Left Section are displayed and they have proper text)
        String[] expectedHeader = {"HOME", "CONTACT FORM", "Service", "METALS & COLORS", "Elements packs"};
        String[] selectorItems = {"a[href=\"index.html\"]", "a[href=\"contacts.html\"]", "li[index = \"3\"]", "a[href=\"metals-colors.html\"]","li[index = \"3\"]"};
        for(int i = 0; i < 4; i++){
            softAssert.assertEquals(driver.findElement(By.cssSelector(selectorItems[i])).getText(), expectedHeader[i]);
            softAssert.assertTrue(driver.findElement(By.cssSelector(selectorItems[i])).isDisplayed());
        }
        softAssert.assertAll();
    }
}
