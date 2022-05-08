package hw1;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestMult extends InitClass{

    @DataProvider(name = "MultDataProvider")
    public Object[][] provideNewData() {
        return new Object[][]{
                {34, 11, 374},
                {51, 0, 0},
                {8.456, 32.121212, 271.61696968672},
                {2, -2, -4},
                {0, 0, 0},
                {-89, -3, 267},
                {23, -78.56, -1806.88},
                {-1, 232.56, -232.56}};
    }

    @Test(dataProvider = "MultDataProvider", groups = "MultDiv")
    public void testAddition(double a, double b, double result) {
        double mult = calculator.mult(a, b);
        Assert.assertEquals(mult, result);
    }
}