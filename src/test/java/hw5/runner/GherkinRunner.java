package hw5.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/resources/GherkinTest.feature"},
        glue = {"hw5.steps"}
)
public class GherkinRunner extends AbstractTestNGCucumberTests {
}