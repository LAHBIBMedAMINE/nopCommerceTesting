package runner;

import io.cucumber.testng.CucumberOptions;
import steps.TestBase;
@CucumberOptions(features = "src/test/java/features/ContactUS.feature"
,glue= {"steps.ContactUs"}, plugin = {"pretty","html:target/HtmlReports.html"},
dryRun = false)
public class Contact_Us_TestRunner extends TestBase{

}
