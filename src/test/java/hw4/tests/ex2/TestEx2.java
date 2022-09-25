package hw4.tests.ex2;

import hw4.BeforeAfterTestHw4;
import hw4.listeners.ScreenshotListener;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners({ScreenshotListener.class})
@Feature("HomePage and Diff elements page tests class")
public class TestEx2 extends BeforeAfterTestHw4{

    @Test
    @Story("HomePage and Diff elements page tests method")
    public void testEx2() {

        //Exercise 2 (1 - Open test site by URL)
        actionStep.openPage();

        //Exercise 2 (2 - Assert Browser title)
        assertionStep.assertBrowserTitle("Home Page");

        //Exercise 2 (3 - Perform login)
        actionStep.loginUser(BeforeAfterTestHw4.properties.getProperty("login"),
                BeforeAfterTestHw4.properties.getProperty("passwd"));

        //Exercise 2 (4 - Assert Username is loggined)
        assertionStep.assertUsername("ROMAN IOVLEV");

        //Exercise 2 (5 - Open through the header menu Service -> Different Elements Page)
        actionStep.clickHeaderItem();

        //Exercise 2 (6 - Select checkboxes)
        actionStep.selectCheckbox("Water");
        actionStep.selectCheckbox("Wind");

        //Exercise 2 (7 - Select radio)
        actionStep.selectRadio("Selen");

        //Exercise 2 (8 - Select in dropdown)
        actionStep.selectOption("Yellow");

        //Exercise 2 (9)
        String[] expected = {"Colors: value changed to Yellow",
                "metal: value changed to Selen",
                "Wind: condition changed to true",
                "Water: condition changed to true"
        };
        assertionStep.assertLogs(expected);

        assertionStep.assertAll();
    }
}
