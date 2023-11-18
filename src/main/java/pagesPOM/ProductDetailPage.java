package pagesPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailPage extends PageBase{

	public ProductDetailPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(css ="input.qty-input")
	WebElement quantityTxBx;
	@FindBy(css="button.button-1.add-to-cart-button")
	WebElement addTocartBtn;
	@FindBy(linkText = "Add your review")
	WebElement addreviewLink;
	@FindBy(tagName = "h1")
	public WebElement productNameTitle;
	
	
	
	
	public void addQuantity(String quatity) {
		quantityTxBx.clear();
		quantityTxBx.sendKeys(quatity);
	}
	
	public void addtocart() {
		addTocartBtn.click();
	}
	
	public void addReviewOpnLink() {
		addreviewLink.click();
	}
	
	
	

}
