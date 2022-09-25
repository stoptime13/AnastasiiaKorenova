package hw1;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestSub extends InitClass{

    @DataProvider(name = "SubDataProvider")
    public Object[][] provideNewData() {
        return new Object[][]{
                {54, 12, 42},
                {51, 51, 0},
                {6.5678, 2.45, 4.1178},
                {78, 0, 78},
                {0, -6, 6},
                {-67, -6, -61},
                {45.02, 45, 0.02}};
    }

    @Test(dataProvider = "SubDataProvider", groups = "SumSub")
    public void testSub(double a, double b, double result) {
        double sub = calculator.sub(a, b);
        Assert.assertEquals(sub, result, 1e-4);
    }

}