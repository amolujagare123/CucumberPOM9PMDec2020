package TestRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "Features",glue = "StepDefinition"
,tags = "@verifyDeal",monochrome = true,
        plugin = {"pretty","html:target/cucumber-reports.html",
                "json:target/cucumber.json",
                "junit:target/cuckes.xml",
               })
public class TestRunner {
}
