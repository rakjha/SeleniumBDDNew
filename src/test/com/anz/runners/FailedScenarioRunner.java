package test.com.anz.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import main.com.anz.core.BaseMethods;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

@SuppressWarnings("NewClassNamingConvention")
@CucumberOptions(

        features = {"@target/rerun.txt"},
        glue = {"test.com.anz.steps"}, // path of step definition

        plugin = {"pretty", "html:./target/rerun-cucumber-reports/failed-rerun.html"},
        monochrome = true
)

public class FailedScenarioRunner extends AbstractTestNGCucumberTests {
    @Parameters("browserValue")

    @BeforeClass
    public void setBrowserValue(String browserValue) {
        BaseMethods.browserName.set(browserValue);

    }
}