package steps.ContactUs;

import static org.testng.Assert.assertTrue;

import com.github.javafaker.Faker;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pagesPOM.ContactUsPage;
import pagesPOM.HomePage;
import steps.TestBase;

public class ContactUS extends TestBase{
	
	ContactUsPage contactusPgOb;
	HomePage homePgObj;
	
	// use faker to generate fake data
	Faker fakeData = new Faker();
	String FirstName = fakeData.name().firstName();
	String mail = fakeData.internet().emailAddress();
	String txt="you are the best";
	
	@Given("unregistred user on home page")
	public void unregistred_user_on_home_page() {
		//PageObj initiation
		contactusPgOb = new ContactUsPage(driver);
		homePgObj = new HomePage(driver);
		driver.navigate().to("https://demo.nopcommerce.com/");
		
	    
	}

	@When("i click on Contact us")
	public void i_click_on_contact_us() {
		homePgObj.openContactusLink();
	}

	@When("i fill the Contact Us form")
	public void i_fill_the_contact_us_form() {
		contactusPgOb.FillFromContactUs(FirstName, mail, txt);
	}

	@When("i submit")
	public void i_submit() {
		contactusPgOb.submitContactUs();
	    
	}

	@Then("sucessful Msg is displayed")
	public void sucessful_msg_is_displayed() {
	assertTrue(contactusPgOb.resultRx.getText().contains("Your enquiry has been successfully sent to the store owner."));
	    
	}

}
