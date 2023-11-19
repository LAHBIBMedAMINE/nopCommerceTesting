package steps.addReview;

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
import steps.TestBase;

public class AddReviews extends TestBase{
	
	HomePage homePageObj;
	RegisterPage registerPgObj;
	LoginPage loginPgObj;
	ResultSeachPage resultSeachPgObj;
	ProductDetailPage productDetailPgObj;
	ReviewPage reviewPgObj;
	

	
	
    String reviewText= "I will give it ";
    String reviewTitleText="I love Apple" ;
    
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
	  	//steps
	    homePageObj.openLoginLink();
	  	System.out.println(mail+" // "+password);
	  	loginPgObj.userLogin(mail, password);
	  	loginPgObj.loginBTnClick();
	  	//verification of login
	  	assertTrue(loginPgObj.myAccountLink.isDisplayed());
	}
    
	@When("I search for product")
	public void i_search_for_product_in_addReview(String ProductName) {
		//PageObj initiation
		homePageObj = new HomePage(driver);
		resultSeachPgObj = new ResultSeachPage(driver);
		
		//search for product
		homePageObj.SearchForProduct(ProductName);
		assertTrue(resultSeachPgObj.resultProductSelector.isDisplayed());	
	}
	
	@When("i enter in product detail")
	public void i_enter_in_product_detail(String ProductName) {
		//PageObj initiation
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
		//PageObj initiation
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
