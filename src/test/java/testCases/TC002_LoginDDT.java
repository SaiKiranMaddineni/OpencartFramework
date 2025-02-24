package testCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountsPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC002_LoginDDT extends BaseClass {

	@Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class , groups={"data driven" ,"Master"})
	public void VerifyLoginDDT(String email, String pwd, String exp) {

		logger.info("Starting TC002_LoginTestDDT");

		try {
			
			HomePage hp = new HomePage(driver);

			hp.clickMyAccount();
			hp.clickLogin();
			logger.info("Clicked on Login Link ddt");

			LoginPage login = new LoginPage(driver);
			login.enterEmail(email);
			logger.info("Enytered the Email ddt");
			login.enterPassword(pwd);
			logger.info("Enytered the Password ddt");
			login.ClickLogin();
			logger.info("Clicked on Login button ddt");

			MyAccountsPage ma = new MyAccountsPage(driver);
			boolean st = ma.isMyaccountpageexists();
			if (exp.equalsIgnoreCase("Valid")) {
				if (st == true) {

					ma.clickLogout();
					Assert.assertTrue(true);
				} else {
					Assert.assertTrue(false);
				}
			}
			if (exp.equalsIgnoreCase("Invalid")) {
				if (st == true) {
					ma.clickLogout();
					Assert.assertTrue(false);

				} else {
					Assert.assertTrue(true);
				}
			}
		} catch (Exception e) {

			e.printStackTrace();

		}
		logger.info("--**Finished Login TestDDT**--");

	}

}