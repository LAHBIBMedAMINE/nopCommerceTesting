package steps;

import static org.testng.Assert.assertTrue;

import com.github.javafaker.Faker;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pagesPOM.HomePage;
import pagesPOM.LoginPage;
import pagesPOM.ProductDetailPage;
import pagesPOM.RegisterPage;
import pagesPOM.ResultSeachPage;
import pagesPOM.ReviewPage;

public class AddReviews extends TestBase{
	
	HomePage homePageObj;
	RegisterPage registerPgObj;
	LoginPage loginPgObj;
	ResultSeachPage resultSeachPgObj;
	ProductDetailPage productDetailPgObj;
	ReviewPage reviewPgObj;
	

	
	// use faker to generate fake data for registration
    Faker fakeData = new Faker();
    String FirstName = fakeData.name().firstName();
    String LastName = fakeData.name().lastName();
    String DayofBirth ="25";
    String MonthofBirth ="June";
    String YearofBirth ="1989";
    String mail = fakeData.internet().emailAddress();
    String password = fakeData.internet().password(6, 10);
    String company =fakeData.company().name();
    String reviewText= "I will give it ";
    String reviewTitleText="I love Apple" ;
    
	
	@Given("registred user logged to website")
	public void registred_user_logged_to_website() {
		//Obj declarations
		homePageObj = new HomePage(driver);
		registerPgObj = new RegisterPage(driver);
		loginPgObj = new LoginPage(driver);
		
		//Registration Phase
		System.out.println(mail);
		System.out.println(password);
		
		assertTrue(driver.getCurrentUrl().contains("https://demo.nopcommerce.com/"));
		homePageObj.openRegistrationLink();
		assertTrue(registerPgObj.registerTitle.getText().contains("Register"));
		registerPgObj.userRegistration(FirstName, LastName, DayofBirth, MonthofBirth, YearofBirth, mail, password, company);
		registerPgObj.RegisterButtonClick();
		assertTrue(registerPgObj.ResultMessage.getText().contains("Your registration completed"));
		//login phase
		homePageObj.openLoginLink();
	    assertTrue(loginPgObj.signUpMsg.getText().contains("Welcome, Please Sign In!"));
	    loginPgObj.userLogin(mail,password);
	    loginPgObj.loginBTnClick();
	}

	@When("I search for product")
	public void i_search_for_product(String ProductName) {
		//Obj declarations
		resultSeachPgObj = new ResultSeachPage(driver);
		
		//search for product
		homePageObj.SearchForProduct(ProductName);
		assertTrue(resultSeachPgObj.resultProductSelector.isDisplayed());
		
		
		
	}
	
	@When("i enter in product detail")
	public void i_enter_in_product_detail(String ProductName) {
		//Obj declarations
		productDetailPgObj = new ProductDetailPage(driver);
		// product detail page
		resultSeachPgObj.accessProductdetail();
		assertTrue(productDetailPgObj.productNameTitle.getText().contains(ProductName));
	}

	@When("i click on add review")
	public void i_click_on_add_review() {
		productDetailPgObj.addReviewOpnLink();
  
	}

	@When("I fill the review form")
	public void i_fill_the_review_form() {
		//Obj declarations
		reviewPgObj = new ReviewPage(driver);
		
		// add five reviews
		for (int i=1; i<6; i++) 
		{
		reviewPgObj.AddaReview(reviewTitleText, reviewText+i+" Stars", i);
		assertTrue(reviewPgObj.messageresult.getText().contains("Product review is successfully added"));
		reviewPgObj.productlink.click();
		productDetailPgObj.addReviewOpnLink();
		}
		
		
		
	}
	
	
	

}
