package steps.emailToFriend;

import static org.testng.Assert.assertTrue;

import com.github.javafaker.Faker;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pagesPOM.EmailToFriendPage;
import pagesPOM.HomePage;
import pagesPOM.LoginPage;
import pagesPOM.ProductDetailPage;
import pagesPOM.RegisterPage;
import pagesPOM.ResultSeachPage;
import steps.TestBase;

public class EmailToFriend extends TestBase{
	
	HomePage homePageObj;
	RegisterPage registerPgObj;
	LoginPage loginPgObj;
	ResultSeachPage resultSeachPgObj;
	ProductDetailPage productDetailPgObj;
	EmailToFriendPage emailToFriendPgObj;
	

	
	// use faker to generate fake data for registration
    Faker fakeData = new Faker();
    String Friendemail = fakeData.internet().emailAddress();
    String FirstName = fakeData.name().firstName();
    String LastName = fakeData.name().lastName();
    String DayofBirth ="25";
    String MonthofBirth ="June";
    String YearofBirth ="1989";
    String mail = fakeData.internet().emailAddress();
    String password = fakeData.internet().password(6, 10);
    String company =fakeData.company().name();
    String Mailtext = "this is the best i found";
	
	@Given("I register on a website using fake account")
	public void I_register_on_a_website_using_fake_account() {
		driver.navigate().to("https://demo.nopcommerce.com/");
	    //registration Phase
	    
		homePageObj = new HomePage(driver);
		registerPgObj = new RegisterPage(driver);
	    //steps
	    homePageObj.openRegistrationLink();
	    System.out.println(mail+" // "+password);
	    registerPgObj.userRegistration(FirstName,LastName,DayofBirth,MonthofBirth,YearofBirth,mail,password,company);
	    registerPgObj.RegisterButtonClick();
	  
	}
	
	@When("As registered user I Login to my account")
	public void As_registered_user_I_Login_to_my_account() {
		//login Phase
		//PageObj initiation
		loginPgObj = new LoginPage(driver);
	    homePageObj = new HomePage(driver);
	  	//steps
	    homePageObj.openLoginLink();
	  	System.out.println(mail+" // "+password);
	  	loginPgObj.userLogin(mail, password);
	  	loginPgObj.loginBTnClick();
	  	//verification of login
	  	assertTrue(loginPgObj.myAccountLink.isDisplayed());
	}

	@When("I search for Product")
	public void i_search_for_product(String ProductName) {
		//PageObj initiation
		resultSeachPgObj = new ResultSeachPage(driver);
		
		//search for product
		homePageObj.SearchForProduct(ProductName);
		assertTrue(resultSeachPgObj.resultProductSelector.isDisplayed());	
	}


	@When("I access to product details")
	public void i_access_to_product_details(String ProductName) {
		productDetailPgObj = new ProductDetailPage(driver);
		emailToFriendPgObj = new EmailToFriendPage(driver);
		resultSeachPgObj.accessProductdetail();
		
			
		
	  
	}

	@When("I click on Email to Friend")
	public void i_click_on_email_to_friend() {
		productDetailPgObj.EmailtoFirendOpnLink();
	}

	@When("I fill the From")
	public void i_fill_the_from() {
		emailToFriendPgObj.emailtofirend(Friendemail,mail , Mailtext);
	}

	@When("I send the email")
	public void i_send_the_email() {
		emailToFriendPgObj.submitEmail();
	}

	@Then("A sucess Msg is displayed")
	public void a_sucess_msg_is_displayed() {
		assertTrue(emailToFriendPgObj.resultmessage.getText().contains("Your message has been sent"));    
	}

	@Then("I logout")
	public void i_logout() {
		homePageObj.Userlogout();
	}

	@Given("non registred user on the WebSite")
	public void non_registred_user_on_the_website() {
		homePageObj = new HomePage(driver);
	    driver.navigate().to("https://demo.nopcommerce.com/");
	    assertTrue(homePageObj.Loginlink.isDisplayed());
	}

	@Then("A fail Msg is displayed")
	public void a_fail_msg_is_displayed() {
		assertTrue(emailToFriendPgObj.errorMessage.getText().contains("Only registered customers can use email a friend feature"));
	}

}
