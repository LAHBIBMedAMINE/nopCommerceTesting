package runner;

import io.cucumber.testng.CucumberOptions;
import steps.TestBase;
@CucumberOptions(features = "src/test/java/features/EmailToFriend.feature"
,glue= {"steps.emailToFriend"}, plugin = {"pretty","html:target/HtmlReports.html"},
dryRun = false)
public class EmailToFriend_TestRunner extends TestBase{

}
