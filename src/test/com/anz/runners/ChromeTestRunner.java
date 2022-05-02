package test.com.anz.runners;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import main.com.anz.core.BaseMethods;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

@SuppressWarnings("NewClassNamingConvention")
@CucumberOptions(features = "./src/test/resources/features/",

        tags = "@LoanTest", glue = {"test.com.anz.steps"},

        plugin = {"pretty", "json:target/chromeOutput/chrome.json", "rerun:target/rerun.txt",
                "html:target/default-cucumber-reports/chrome-reports.html"})

public class ChromeTestRunner extends AbstractTestNGCucumberTests {


    @Parameters("browserValue")
    @BeforeClass
    public void setBrowserValue(@Optional String browserValue) {
        BaseMethods.browserName.set(browserValue);

    }
}