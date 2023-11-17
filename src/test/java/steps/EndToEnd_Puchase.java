package steps;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;

import com.github.javafaker.CreditCardType;
import com.github.javafaker.Faker;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pagesPOM.CheckoutPage;
import pagesPOM.HomePage;
import pagesPOM.LoginPage;
import pagesPOM.OrderInformationPage;
import pagesPOM.ProductDetailPage;
import pagesPOM.RegisterPage;
import pagesPOM.ResultSeachPage;
import pagesPOM.ShoppingCartPage;


public class EndToEnd_Puchase extends TestBase{
	
 	HomePage homepgObj;
 	RegisterPage RegisterPgObj;
 	LoginPage loginObj;
 	ResultSeachPage resultSearchPgObj;
 	ProductDetailPage productDetailPgObj;
 	ShoppingCartPage shoppingCartPgObj;
 	CheckoutPage CheckoutPgObj;
 	OrderInformationPage OrderInformationPgObj;
	
	
	
	@Given("AS registred User I logged in home Page")
	public void as_registred_user_i_logged_in_home_page() {
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
	    
	    
	    
	    //registration Phase
	    //Obj declaration
	    homepgObj = new HomePage(driver);
	    RegisterPgObj = new RegisterPage(driver);
	    //steps
	    homepgObj.openRegistrationLink();
	  	RegisterPgObj.userRegistration(FirstName,LastName,DayofBirth,MonthofBirth,YearofBirth,mail,password,company);
	  	RegisterPgObj.RegisterButtonClick();
	  	//login Phase
	  	//Obj declaration
	  	loginObj = new LoginPage(driver);
	  	//steps
	  	homepgObj.openLoginLink();
	  	loginObj.userLogin(mail, password);
	  	loginObj.loginBTnClick();
	  	//verification of login
	  	assertTrue(loginObj.myAccountLink.isDisplayed());
	  	
	  
	    
	}
	
	@When("I search for First available {string}")
	public void i_search_for_first_available(String product1) {
				//Obj declaration
				resultSearchPgObj = new ResultSeachPage(driver);
				//step1 search for product
			    homepgObj.SearchForProduct(product1);
			    //verification the Item displayed
			    assertTrue(resultSearchPgObj.itemNameLink.getText().contains(product1));
			    //access product detail
			    resultSearchPgObj.accessProductdetail();
	}

	@When("I add First products to cart")
	public void i_add_first_products_to_cart() {
		//Obj declaration
		productDetailPgObj = new ProductDetailPage(driver);
		//Steps
		productDetailPgObj.addQuantity("3");
		productDetailPgObj.addtocart();
		homepgObj.closeNotification();
	}
	
	@When("I search for Second available {string}")
	public void i_search_for_second_available(String product2) {
		//step1 search for product
	    homepgObj.SearchForProduct(product2);
	    //verification the Item displayed
	    assertTrue(resultSearchPgObj.itemNameLink.getText().contains(product2));
	    //access product detail
	    resultSearchPgObj.accessProductdetail();
	    
	}

	@When("I add Second products to cart")
	public void i_add_second_products_to_cart() {
		productDetailPgObj.addQuantity("2");
		productDetailPgObj.addtocart();
		homepgObj.closeNotification();
		
	}

	@When("I proceed to my shopping cart {string} {string}")
	public void i_proceed_to_my_shopping_cart(String product1,String product2) {
		//Obj declaration
		shoppingCartPgObj = new ShoppingCartPage(driver);
		
		homepgObj.hoveroverMenu(homepgObj.topcartLink, false);
		// verify flyout-cart is displayed
		assertTrue(homepgObj.flyout_cart.isDisplayed());
		// verify number of product displayed
		assertEquals(homepgObj.productsFlyout.size(),2);
		homepgObj.openCartLink();
		//proceed to shopping cart
		homepgObj.openCartLink();
		//check the elements
		assertEquals(shoppingCartPgObj.productList.size(),2);
		assertTrue(shoppingCartPgObj.checkproductinCart(shoppingCartPgObj.productList,product1));
		assertTrue(shoppingCartPgObj.checkproductinCart(shoppingCartPgObj.productList,product2));
		
	}
	
	

	@When("I check the agree of terms and proceed to pay")
	public void i_check_the_agree_of_terms_and_proceed_to_pay() {
		
		// check the agreeTerms Box
		shoppingCartPgObj.EnsureAndCheckAgreeTermsButton();
		//verification for checking agree terms
		assertTrue(shoppingCartPgObj.agreeTermscheck.isSelected());
		//proceed to checkout
		shoppingCartPgObj.proceedTocheckout();
	    
	}
	
	//filling form
			Faker fakeData = new Faker();
			String country ="United States";
			String state ="California";
			String city =fakeData.address().city();
			String adress1 =fakeData.address().streetAddress();
			String adress2 =fakeData.address().streetAddress();
			String zipcode =fakeData.address().zipCode();
			String phone = fakeData.phoneNumber().cellPhone();
			String fax = fakeData.phoneNumber().phoneNumber();

	@When("I fill the adress form")
	public void i_fill_the_adress_form() {
		
		
		//Obj declaration
		CheckoutPgObj = new CheckoutPage(driver) ;
	    
		//fill the forms
		CheckoutPgObj.FilladressForm(country,state,city,adress1,adress2,
				zipcode,phone,fax);
	}

	@When("I check ship to same adress option")
	public void i_check_ship_to_same_adress_option() {
		CheckoutPgObj.EnsureAndCheckShipToSameAdress();
	}
	
	@When("I choose the shipment_Option {string}")
	public void i_choose_the_shipment_option(String Shipping_options) {
		CheckoutPgObj.SelectshippingoptionAndContinue(Shipping_options);
	}
	
	// card info
	String FirstName = fakeData.name().firstName();
	String cardNumber =fakeData.finance().creditCard(CreditCardType.VISA);
	List<String> cardInfo = List.of("Visa",FirstName,cardNumber,"06","2027","396");
	
	@When("I choose the payment_Option {string}")
	public void i_choose_the_payment_option(String payment_option) {
		CheckoutPgObj.SelectPaymentoptionAndContinue(payment_option,cardInfo);
		
		
	}


	@Then("I validate the puchase")
	public void i_validate_the_puchase() {
		CheckoutPgObj.paymentcheckInofProceed();
		//confirming the purchase
		CheckoutPgObj.confirmtheorder();
		//verifying the success of the purchase
		assertTrue(CheckoutPgObj.orderSuccessMsg.getText().contains("Your order has been successfully processed!"));
	    
	}

	@Then("I download the order")
	public void i_download_the_order() throws InterruptedException {
		//Obj declaration
		OrderInformationPgObj = new OrderInformationPage(driver);
		
		
		CheckoutPgObj.openOrderDetailLink();
		//Download the Pdf
		OrderInformationPgObj.pdfDownload();
		Thread.sleep(5000);
		
		
	    
	}

	@Then("I log Out")
	public void i_log_out() {
	    homepgObj.Userlogout();
	    assertTrue(driver.getCurrentUrl().contains("https://demo.nopcommerce.com/"));
	}

}
