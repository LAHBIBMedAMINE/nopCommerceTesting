package steps;

import static org.testng.Assert.assertTrue;

import com.github.javafaker.Faker;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pagesPOM.HomePage;
import pagesPOM.LoginPage;
import pagesPOM.MyAccountPage;
import pagesPOM.RegisterPage;

public class ChangeMyPassword extends TestBase{
	
	//PagesPOMs declarations
		HomePage homePageObj;
		RegisterPage registerPgObj;
		LoginPage loginPgObj;
		MyAccountPage MyAccountPgObj;
		
		// use faker to generate fake data for registration
	    Faker fakeData = new Faker();
	    String FirstName = fakeData.name().firstName();
	    String LastName = fakeData.name().lastName();
	    String DayofBirth ="25";
	    String MonthofBirth ="June";
	    String YearofBirth ="1989";
	    String mail = fakeData.internet().emailAddress();
	    String password = fakeData.internet().password(6, 10);
	    String newpassword = fakeData.internet().password(6, 10);
	    String company =fakeData.company().name();
	    
	    
    @Given("User on the home page")
    public void user_on_the_home_page() {
    driver.navigate().to("https://demo.nopcommerce.com/");
	//Obj declarations
	homePageObj = new HomePage(driver);
	// Verifying the right URL
	assertTrue(driver.getCurrentUrl().contains("https://demo.nopcommerce.com/")); 
        
    }

    @When("I Click on register link")
    public void i_click_on_register_link() {
	//Obj declarations
	registerPgObj = new RegisterPage(driver);
	//Steps
	homePageObj.openRegistrationLink();
	//verify Register title display
	assertTrue(registerPgObj.registerTitle.getText().contains("Register")); 
    }
	    
   
	@When("I fill the registration form")
	public void i_fill_the_registration_form() {
		//Steps
		registerPgObj.userRegistration(FirstName, LastName, DayofBirth, MonthofBirth, YearofBirth, mail, password, company);
	}

	@When("I click on register and continue")
	public void i_click_on_register_and_continue() {
		registerPgObj.RegisterButtonClick();
		//verify success registration
		assertTrue(registerPgObj.ResultMessage.getText().contains("Your registration completed"));
		//continue to home page
		registerPgObj.ContinueAfterRegistration();
		assertTrue(driver.getCurrentUrl().contains("https://demo.nopcommerce.com/"));
	}
	
	@When("I click on login Link")
	public void i_click_on_login_link() {
		//Obj declarations
		loginPgObj = new LoginPage(driver);
		//Steps
	    homePageObj.openLoginLink();
	    //verify login page
	    assertTrue(loginPgObj.signUpMsg.getText().contains("Welcome, Please Sign In!"));
	}

	@When("I log to my new account")
	public void i_log_to_my_new_account() {
		loginPgObj.userLogin(mail,password);
		loginPgObj.loginBTnClick();
		//verify i'm logged
		assertTrue(loginPgObj.myAccountLink.isDisplayed());
	}

	@When("I click on myAccount")
	public void i_click_on_my_account() {
		homePageObj.openMyAccountLink();
		
	}

	@When("I click on change my password")
	public void i_click_on_change_my_password() {
		MyAccountPgObj = new MyAccountPage(driver);
		MyAccountPgObj.ChangePasswordlink();
	    
	}

	@When("I fill the form of changing passwor")
	public void i_fill_the_form_of_changing_passwor() {
		MyAccountPgObj.ChangeThePasswordSuccess(password,newpassword);
	    
	}

	@Then("Msg your Password was changed")
	public void msg_your_password_was_changed() {
		assertTrue(MyAccountPgObj.resultnotification.getText().contains("Password was changed"));
		MyAccountPgObj.closeNotification();
	}

	@When("I logOut")
	public void i_log_out() {
		registerPgObj.Userlogout();
	    assertTrue(driver.getCurrentUrl().contains("https://demo.nopcommerce.com/"));
	    
	}

	@When("I log in with my new password")
	public void i_log_in_with_my_new_password() {
		//Steps
	    homePageObj.openLoginLink();
	    //verify login page
	    assertTrue(loginPgObj.signUpMsg.getText().contains("Welcome, Please Sign In!"));
	    loginPgObj.userLogin(mail,newpassword);
		loginPgObj.loginBTnClick();
	}

	@Then("I successfuly login")
	public void i_successfuly_login() {
		assertTrue(loginPgObj.myAccountLink.isDisplayed());
		driver.navigate().to("https://demo.nopcommerce.com/");
	}
	
	@When("I logOut again")
	public void i_log_out_again() {
		registerPgObj.Userlogout();
	    assertTrue(driver.getCurrentUrl().contains("https://demo.nopcommerce.com/"));
	    
	}

}
