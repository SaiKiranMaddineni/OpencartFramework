package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
	
	
	public LoginPage(WebDriver driver) {
	
		super(driver);
	}
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement txt_Email;

	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement txt_Password;
	
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement btn_Login;

	public void ClickLogin() {
		btn_Login.click();
	}
	
	public void enterEmail(String Email) {
		txt_Email.sendKeys(Email);
	}
	
	public void enterPassword(String Password) {
		txt_Password.sendKeys(Password);
	}
	
}
