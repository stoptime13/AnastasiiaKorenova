package hw1;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestSum extends InitClass{

    @DataProvider(name = "SumDataProvider")
    public Object[][] provideNewData() {
        return new Object[][]{
                {-23, 12, -11},
                {17, -17, 0},
                {2.1, 7.2, 9.3},
                {19, 0, 19},
                {0, -6, -6},
                {345678, 10879754, 11225432},
                {34, 0.23, 34.23},
                {-0.1, -56.05, -56.15}};
    }

    @Test(dataProvider = "SumDataProvider", groups = "SumSub")
    public void testSum(double a, double b, double result) {
        double sum = calculator.sum(a, b);
        Assert.assertEquals(sum, result);
    }

}
