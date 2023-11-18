package pagesPOM;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyAccountPage extends PageBase{

	public MyAccountPage(WebDriver driver) {
		super(driver);
	}
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(5000));
	
	@FindBy(partialLinkText = "Change password")
	WebElement ChangePasswordLink;
	
	@FindBy(id = "OldPassword")
	WebElement OldPasswordTxBx;
	
	@FindBy(id = "NewPassword")
	WebElement NewPasswordTxBx;
	
	@FindBy(id = "ConfirmNewPassword")
	WebElement ConfirmNewPasswordTxBx;
	
	@FindBy(css = "button.button-1.change-password-button")
	WebElement ChangePasswordBtn;
	
	@FindBy(css = "div.bar-notification.success")
	public WebElement resultnotification;
	
	@FindBy(css = "span.close")
	public WebElement closebtn;
	
	
	
	
	public void ChangeThePasswordSuccess(String oldPasswordTx,String NewPasswordTx) {
		ChangePasswordLink.click();
		OldPasswordTxBx.sendKeys(oldPasswordTx);
		NewPasswordTxBx.sendKeys(NewPasswordTx);
		ConfirmNewPasswordTxBx.sendKeys(NewPasswordTx);
		ChangePasswordBtn.click();
	}
	
	public void ChangePasswordlink() {
		ChangePasswordLink.click();
		
	}
	public void closeNotification() {
		closebtn.click();
		wait.until(ExpectedConditions.invisibilityOf(closebtn));
	}

}
