package runner;

import io.cucumber.testng.CucumberOptions;
import steps.TestBase;

@CucumberOptions(features = "src/test/java/features/ChangeMypasswor.feature"
,glue= {"steps"}, plugin = {"pretty","html:target/HtmlReports"},
dryRun = false)
public class ChangeMypassword_TestsRunner extends TestBase {
	
	

}
