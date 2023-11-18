package steps;

import static org.testng.Assert.assertTrue;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pagesPOM.HomePage;
import pagesPOM.LoginPage;
import pagesPOM.RegisterPage;

public class UserRegistrationTEST extends TestBase{
	
	
	//PagesPOMs declarations
	HomePage homePageObj;
	RegisterPage registerPgObj;
	LoginPage loginPgObj;
	
	
	
	@Given("user on the home page")
	public void user_on_the_home_page() {
		driver.navigate().to("https://demo.nopcommerce.com/");
		//Obj declarations
		homePageObj = new HomePage(driver);
		// Verifying the right URL
		assertTrue(driver.getCurrentUrl().contains("https://demo.nopcommerce.com/"));  
	}
	
	
	@When("I click on register link")
	public void i_click_on_register_link() {
		//Obj declarations
		registerPgObj = new RegisterPage(driver);
		//Steps
		homePageObj.openRegistrationLink();
		//verify Register title display
		assertTrue(registerPgObj.registerTitle.getText().contains("Register"));  
	}
	
	
	@When("I enter {string},{string},{string},{string},{string},{string},{string},{string}")
	public void i_enter(String firstName,String lastname,String day,String month,
    		String year,String Email,String Password,String compagny) {
		//Steps
		registerPgObj.userRegistration(firstName, lastname, day, month, year, Email, Password, compagny);
		   
	}
	
	@When("I click on register")
	public void i_click_on_register() {	
		registerPgObj.RegisterButtonClick();	
	}
	
	@Then("sucessful registring Msg is displayed")
	public void sucessful_registring_msg_is_displayed() {
		assertTrue(registerPgObj.ResultMessage.getText().contains("Your registration completed"));
	}
	
	@Then("I click continue")
	public void i_click_continue() {
		registerPgObj.ContinueAfterRegistration();
		assertTrue(driver.getCurrentUrl().contains("https://demo.nopcommerce.com/"));
	    
	}
	
	@When("I click on log in Link")
	public void i_click_on_log_in_link() {
		//Obj declarations
		loginPgObj = new LoginPage(driver);
		//Steps
	    homePageObj.openLoginLink();
	    //verify login page
	    assertTrue(loginPgObj.signUpMsg.getText().contains("Welcome, Please Sign In!"));
	    
	}

	@When("I enter {string},{string}")
	public void i_enter(String Email, String Password) {
		//Steps
		loginPgObj.userLogin(Email,Password);
		
	}

	@When("I click on log in")
	public void i_click_on_log_in() {
		loginPgObj.loginBTnClick();
	}
	
	@Then("Myaccount link is displayed")
	public void myaccount_link_is_displayed() {
		//verify i'm logged
		assertTrue(loginPgObj.myAccountLink.isDisplayed());
	}
	
	@Then("I click logout again")
	public void i_click_logout_again() {
		registerPgObj.Userlogout();
	    assertTrue(driver.getCurrentUrl().contains("https://demo.nopcommerce.com/"));
	    driver.navigate().to("https://demo.nopcommerce.com/");
	}



}
