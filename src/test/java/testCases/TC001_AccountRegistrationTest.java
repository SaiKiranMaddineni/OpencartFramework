package testCases;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass {

	//Master executes all the groups testcases if we given in groups
	
	
	
	@Test(groups={"Regression","Sanity","Master"})
	public void verify_account_registration() {

		//logger.info("Starting Account Registration");
		
		
		try{
			HomePage hp = new HomePage(driver);
		
		hp.clickMyAccount();
		logger.info("Clicked on MyAccount Link");
		hp.clickRegister();
		logger.info("Clicked on Register Link");
		AccountRegistrationPage Ap = new AccountRegistrationPage(driver);
		logger.info("Providing Customer details");
		Ap.setFirstName(randomstring().toUpperCase());
		Ap.setLastName(randomstring());
		Ap.setEmail(randomstring()+"@gmail.com");
		Ap.setTelephone(randomNumber());
        String password=randomAlphanumeric();
		Ap.setPassword(password);
		Ap.setConfirmPassword(password);
		Ap.setPrivacyPolicy();
		Ap.clickContinue();
		Thread.sleep(20000);
		logger.info("validating expected message");
		String confirmationmsg = Ap.getConfirmationMsg();
		Assert.assertEquals(confirmationmsg, "Your Account Has Been Created!");
		}catch(Exception e) {
			logger.error("Test Failed");
			logger.debug("debug logs");
			
		}
		logger.info("--**Finished Account Registration Test**--");

	}
	
	
}