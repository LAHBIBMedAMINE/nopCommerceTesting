package pagesPOM;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

public class ShoppingCartPage extends PageBase{

	public ShoppingCartPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(css="table.cart")
	public WebElement shoppingTable;
	
	@FindBys({@FindBy(css="div.table-wrapper"),
		@FindBy(css="td.product"),
		@FindBy(tagName = "a")})
	public List<WebElement> productList;
	
	@FindBy(id="termsofservice")
	public WebElement agreeTermscheck;
	
	@FindBy(id="checkout")
	WebElement checkoutBtn;
	
	
	public boolean checkproductinCart(List<WebElement> productList, String product) {
		//List <String> productNames = new ArrayList<>();
		 Set<String> uniqueProductNames = new HashSet<>();
		// Iterate through the list and get text from each WebElement
	        for (WebElement element : productList) {
	        	uniqueProductNames.add(element.getText()) ;
	        }
	        return uniqueProductNames.contains(product);
		
	}
	
	public void EnsureAndCheckAgreeTermsButton() {
		
		if (agreeTermscheck.isSelected()) {
			// do nothing
		}else {agreeTermscheck.click(); }
	}
	
	public void proceedTocheckout() {
		checkoutBtn.click();
		
	}
	
	

}
