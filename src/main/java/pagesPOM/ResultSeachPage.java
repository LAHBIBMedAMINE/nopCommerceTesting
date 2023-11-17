package pagesPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

public class ResultSeachPage extends PageBase{

	public ResultSeachPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(css ="div.product-selectors")
	public WebElement resultProductSelector;
	
	@FindBys({@FindBy(css="div.product-grid")
	,@FindBy(css = "h2.product-title")
	,@FindBy(tagName ="a")})
	public WebElement itemNameLink;
		
	public void accessProductdetail() {
		itemNameLink.click();
		
	}

}
