package pagesPOM;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PageBase {
		protected WebDriver driver;
		public JavascriptExecutor js;
		public Select select;
		public Actions action;

		//create constructor

		public PageBase(WebDriver driver) {
			this.driver = driver;
			PageFactory.initElements(driver, this);
		}
		
		public void hoveroverMenu(WebElement element, boolean rx) {
			// hover to the webElement True: click() False: no click() 
			action.moveToElement(element).build().perform();
			if (rx) {element.click();}
		}
		
		

}
