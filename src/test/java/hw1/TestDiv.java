package hw1;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestDiv extends InitClass{

    @DataProvider(name = "DivDataProvider")
    public Object[][] provideNewData() {
        return new Object[][]{
                {0, 114, 0},
                {51, 3, 17},
                {271.61696968672, 8.456, 32.12121212},
                {-88, -11, 8},
                {21, -3, -7},
                {-12, 24, -0.5},
                {-4.6, 2.5, -1.84}};
    }

    @Test(dataProvider = "DivDataProvider", groups = "MultDiv")
    public void testDiv(double a, double b, double result) {
        double div = calculator.div(a, b);
        Assert.assertEquals(div, result, 1e-4);
    }
}