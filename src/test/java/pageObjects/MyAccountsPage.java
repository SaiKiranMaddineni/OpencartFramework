package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountsPage extends BasePage{

	
	public MyAccountsPage(WebDriver driver) {
		
		super(driver);
	}
	
	
	@FindBy(xpath="//h2[text()='My Account']")
	WebElement MyAccount;
	
	
	@FindBy(xpath="(//a[text()='Logout'])[2]")
	WebElement Logout;
	public boolean isMyaccountpageexists() {
		
		try {
		return MyAccount.isDisplayed();
		}
		catch(Exception e) {
			
			return false;
		}
		
	}
	public void clickLogout() {
		Logout.click();
	}
}
