package runner;

import io.cucumber.testng.CucumberOptions;
import steps.TestBase;

@CucumberOptions(features = "src/test/java/features/UserRegistration.feature"
,glue= {"steps"}, plugin = {"pretty","html:target/HtmlReports"},
dryRun = false)
public class UserRegistration_TestRunner extends TestBase {
	
	

}
