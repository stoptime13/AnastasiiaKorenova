package hw2.ex2;

import hw2.BeforeAfterTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class TestEx2 extends BeforeAfterTest {
    @Test
    public void testEx2(){

        //Exercise 2 (1 - Open test site by URL)
        driver.get("https://jdi-testing.github.io/jdi-light/index.html");

        //Exercise 2 (2 - Assert Browser title)
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(driver.getTitle(),"Home Page");

        //Exercise 2 (3 - Perform login)
        driver.findElement(By.cssSelector("a[href = '#']")).click();
        driver.findElement(By.id("name")).sendKeys("Roman");
        driver.findElement(By.id("password")).sendKeys("Jdi1234");
        driver.findElement(By.id("login-button")).click();

        //Exercise 2 (4 - Assert Username is loggined)
        softAssert.assertEquals(driver.findElement(By.id("user-name")).getText(), "ROMAN IOVLEV");

        //Exercise 2 (5 - Open through the header menu Service -> Different Elements Page)
        driver.findElement(By.cssSelector(".dropdown-toggle")).click();
        driver.findElement(By.cssSelector("a[href=\"different-elements.html\"]")).click();

        //Exercise 2 (6 - Select checkboxes)
        List<WebElement> check = driver.findElements(By.cssSelector("label.label-checkbox"));
        for(int i = 0; i < check.size(); i++) {
            if(check.get(i).getText().equals("Water") || check.get(i).getText().equals("Wind")) {
                check.get(i).findElement(By.tagName("input")).click();
            }
        }

        //Exercise 2 (7 - Select radio)
        List<WebElement> radio = driver.findElements(By.cssSelector("label.label-radio"));
        for(int i = 0; i < radio.size(); i++) {
            if(radio.get(i).getText().equals("Selen") ) {
                radio.get(i).findElement(By.tagName("input")).click();
            }
        }

        //Exercise 2 (8 - Select in dropdown)
        String xPath = "//select/option[text()='Yellow']";
        driver.findElement(By.xpath(xPath)).click();

        //Exercise 2 (9)
        String[] expected = {"Colors: value changed to Yellow",
                "metal: value changed to Selen",
                "Wind: condition changed to true",
                "Water: condition changed to true"
        };
        List<WebElement> logs = driver.findElements(By.cssSelector(".info-panel-body-log li"));
        for (int i = 0; i < logs.size(); i++) {
            softAssert.assertTrue(logs.get(i).getText().contains(expected[i]));
            softAssert.assertTrue(logs.get(i).isDisplayed());
        }
        softAssert.assertAll();
    }
}
