package runners;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
@CucumberOptions(
        features = "src/test/java/features",      // path to feature files
        glue = {"stepDefinitions"},               // step definitions package
        plugin = {
                "pretty",
                "html:target/cucumber-report.html"
        },
        monochrome = true,
        dryRun = false,
        tags = "@scenario1"
       
)
public class TestRunner extends AbstractTestNGCucumberTests {
}
