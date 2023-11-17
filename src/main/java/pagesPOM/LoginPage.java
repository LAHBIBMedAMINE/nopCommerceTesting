package pagesPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

public class LoginPage extends PageBase{

	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy (id ="Email" )
	WebElement emailTxBx;

	@FindBy (id ="Password" )
	WebElement PasswordlTxBx;

	@FindBy(css ="button.button-1.login-button")
    WebElement Loginbtn;
	
	@FindBy(linkText = "Log out")
	public WebElement logoutlink;
	
	@FindBy(tagName = "h1")
	public WebElement signUpMsg;
	
	@FindBys({@FindBy(css ="div.header-links"),
		@FindBy(partialLinkText = "My account" )})
	public WebElement myAccountLink;
	
	public void userLogin(String Email,String Password)
	{
		emailTxBx.sendKeys(Email);
		PasswordlTxBx.sendKeys(Password);
	}
	
	public void loginBTnClick() {
		Loginbtn.click();
		
	}

}
