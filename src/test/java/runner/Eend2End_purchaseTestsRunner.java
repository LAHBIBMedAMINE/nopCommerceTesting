package runner;

import io.cucumber.testng.CucumberOptions;
import steps.TestBase;

@CucumberOptions(features = "src/test/java/features/EndToEnd_Purchase.feature"
,glue= {"steps.EndtoEndpurchase"}, plugin = {"pretty","html:target/HtmlReports.html"},
dryRun = false)
public class Eend2End_purchaseTestsRunner extends TestBase {
	
	

}
