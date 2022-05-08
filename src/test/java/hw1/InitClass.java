package hw1;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.BeforeGroups;


public class InitClass {

    protected static Calculator calculator;

    @BeforeGroups(groups = {"SumSub", "MultDiv"})
    public void initCalc() {
        calculator = new Calculator();
    }
}
