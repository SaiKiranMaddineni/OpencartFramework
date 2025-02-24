package testCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountsPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass {

	
	
	
	@Test(groups={"Sanity","Master"})
	public void LogintoOpencartTest() {
		
		
		//logger.info("Starting TC002_LoginTest");
		try{HomePage hp = new HomePage(driver);
		
		hp.clickMyAccount();
		hp.clickLogin();
		//logger.info("Clicked on Login Link");
		
		LoginPage login=new LoginPage(driver);
		login.enterEmail(prop.getProperty("Email"));
		//logger.info("Enytered the Email");
		login.enterPassword(prop.getProperty("Password"));
		//logger.info("Enytered the Password");
		login.ClickLogin();
		//logger.info("Clicked on Login button");
		
		MyAccountsPage ma=new MyAccountsPage(driver);
		boolean st=ma.isMyaccountpageexists();
		Assert.assertEquals(st,true,"Loginfailed");
		
		}catch(Exception e){
			
			e.printStackTrace();
		
	}
		//logger.info("--**Finished Login Test**--");
	}
	
}
