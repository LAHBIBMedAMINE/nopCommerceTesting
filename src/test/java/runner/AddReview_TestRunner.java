package runner;

import io.cucumber.testng.CucumberOptions;
import steps.TestBase;
@CucumberOptions(features = "src/test/java/features/AddReviews.feature"
,glue= {"steps"}, plugin = {"pretty","html:target/HtmlReports"},
dryRun = false)
public class AddReview_TestRunner extends TestBase{

}
