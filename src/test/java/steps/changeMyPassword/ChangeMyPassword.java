package steps.changeMyPassword;

import static org.testng.Assert.assertTrue;

import com.github.javafaker.Faker;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pagesPOM.HomePage;
import pagesPOM.LoginPage;
import pagesPOM.MyAccountPage;
import pagesPOM.RegisterPage;
import steps.TestBase;

public class ChangeMyPassword extends TestBase{
	
	    //PagesPOMs declarations
		HomePage homePgObj;
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
	    String  mail = fakeData.internet().emailAddress();
	    String password = fakeData.internet().password(6, 10);
	    String company =fakeData.company().name();
	    String newpassword = fakeData.internet().password(6, 10);
		@Given("^I  register on a website using fake account$")
		public void I_register_on_a_website_using_fake_account() {
			driver.navigate().to("https://demo.nopcommerce.com/");
		    //registration Phase
		    
		    homePgObj = new HomePage(driver);
		    registerPgObj = new RegisterPage(driver);
		    //steps
		    homePgObj.openRegistrationLink();
		    System.out.println(mail+" // "+password);
		    registerPgObj.userRegistration(FirstName,LastName,DayofBirth,MonthofBirth,YearofBirth,mail,password,company);
		    registerPgObj.RegisterButtonClick();
		  
		}
		
		@When("^As  registered user I Login to my account$")
		public void As_registered_user_I_Login_to_my_account() {
			//login Phase
			//PageObj initiation
			loginPgObj = new LoginPage(driver);
		  	//steps
			homePgObj.openLoginLink();
		  	System.out.println(mail+" // "+password);
		  	loginPgObj.userLogin(mail, password);
		  	loginPgObj.loginBTnClick();
		  	//verification of login
		  	assertTrue(loginPgObj.myAccountLink.isDisplayed());
		}

	@When("I click on myAccount")
	public void i_click_on_my_account() {
		//PageObj initiation
		homePgObj = new HomePage(driver);
		//Steps
		homePgObj.openMyAccountLink();
		
	}

	@When("I click on change my password")
	public void i_click_on_change_my_password() {
		//PageObj initiation
		MyAccountPgObj = new MyAccountPage(driver);
		//open link to change password
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
		homePgObj.openLoginLink();
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
