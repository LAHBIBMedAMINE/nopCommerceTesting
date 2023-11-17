package pagesPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailPage extends PageBase{

	public ProductDetailPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(css ="input.qty-input")
	WebElement quantityTxBx;
	@FindBy(css="button.button-1.add-to-cart-button")
	WebElement addTocartBtn;
	
	
	
	
	public void addQuantity(String quatity) {
		quantityTxBx.clear();
		quantityTxBx.sendKeys(quatity);
	
	}
	
	public void addtocart() {
		addTocartBtn.click();
	
	}
	
	
	

}
