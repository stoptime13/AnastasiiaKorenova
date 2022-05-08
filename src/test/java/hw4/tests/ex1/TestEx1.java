package hw4.tests.ex1;

import hw4.BeforeAfterTestHw4;
import hw4.listeners.ScreenshotListener;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({ScreenshotListener.class})
@Feature("HomePage test class")
public class TestEx1 extends BeforeAfterTestHw4 {

    @Test
    @Story("HomePage test method")
    public void testEx1() {
        //Exercise 1 (1 - Open test site by URL)
        actionStep.openPage();

        //Exercise 1 (2 - Assert Browser title)
        assertionStep.assertBrowserTitle("Home Page");

        //Exercise 1 (3 - Perform login)
        actionStep.loginUser(BeforeAfterTestHw4.properties.getProperty("login"),
                BeforeAfterTestHw4.properties.getProperty("passwd"));

        //Exercise 1 (4 - Assert Username is loggined)
        assertionStep.assertUsername("ROMAN IOVLEV");

        //Exercise 1 (5 - Assert that there are 4 items on the header section are displayed and they have proper texts)
        String[] expectedName = {"HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS"};
        assertionStep.assertHeaderItems(expectedName);

        //Exercise 1 (6 - Assert that there are 4 images on the Index Page and they are displayed)
        assertionStep.assertIcons();

        //Exercise 1 (7 - Assert that there are 4 texts on the Index Page under icons and they have proper text	4 texts below of each image	Texts are displayed and equal to expected)
        String[] expectedText = {"To include good practices\nand ideas from successful\nEPAM project",
                "To be flexible and\ncustomizable",
                "To be multiplatform",
                "Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more…"};
        assertionStep.assertIconText(expectedText);

        //Exercise 1 (8 - Assert that there is the iframe with “Frame Button” exist)
        assertionStep.assertFrame();

        //Exercise 1 (9 - Switch to the iframe and check that there is “Frame Button” in the iframe)
        actionStep.switchToFrame("frame");
        assertionStep.assertFrameButton();

        //Exercise 1 (10 - Switch to original window back)
        actionStep.switchParentFrame();
        assertionStep.assertOriginalWindow();

        //Exercise 1 (11 - Assert that there are 5 items in the Left Section are displayed and they have proper text)
        String[] expectedLeftMenuItems = {"Home", "Contact form", "Service", "Metals & Colors", "Elements packs"};
        assertionStep.assertLeftItems(expectedLeftMenuItems);

        assertionStep.assertAll();

    }
}

