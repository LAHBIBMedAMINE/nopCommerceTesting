package pagesPOM;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends PageBase{

	public HomePage(WebDriver driver) {
		super(driver);
		action = new Actions(driver);
		
	}
	
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(5000));
	
	@FindBy (partialLinkText = "Register")
	WebElement registerlink;
	
	@FindBy (partialLinkText = "Log in")
	WebElement Loginlink;
	
	@FindBy(id="small-searchterms")
	WebElement searchTxBox;
	
	@FindBy(css="button.button-1.search-box-button")
	WebElement searchBtn;
	
	@FindBy(id="topcartlink")
	public WebElement topcartLink;
	
	@FindBy(id="flyout-cart")
	public WebElement flyout_cart;
	
	@FindBys({@FindBy(id="flyout-cart"),
		@FindBy(css="div.name")})
	public List<WebElement> productsFlyout;
	
	@FindBy(css="span.close")
	WebElement closeNotificationBtn;
	
	@FindBy(partialLinkText = "Log out")
	public WebElement logoutlink;
	
	
	
	
	
	
	public void openRegistrationLink() {
		registerlink.click();
	}
	public void openLoginLink() {
		Loginlink.click();
	}
	public void SearchForProduct(String productName) {
		searchTxBox.sendKeys(productName);
		searchBtn.click();
	}
	public void openCartLink() {
		wait.until(ExpectedConditions.visibilityOf(topcartLink));
		topcartLink.click();
	}
	
	public void closeNotification() {
		closeNotificationBtn.click();
		wait.until(ExpectedConditions.invisibilityOf(closeNotificationBtn));
	}
	
	
	
	public void Userlogout(){

    	logoutlink.click();

    }
}
