package testBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public Logger logger;

	public static WebDriver driver;
	
	public Properties prop;
	public FileInputStream fis;

	@BeforeClass(groups= {"Regression","Sanity","Master"})
	@Parameters({"browser" })
	public void setUp(String browser)  {

		
		
		prop=new Properties();
		try {
			fis = new FileInputStream(System.getProperty("user.dir")+"//src//test//resources//config.properties");
			prop.load(fis);
	} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*if(prop.getProperty("execution_env").equalsIgnoreCase("remote")) {
			
			DesiredCapabilities cap = new DesiredCapabilities();
			
			if(Os.equalsIgnoreCase("windows")) {
				
			cap.setPlatform(Platform.WIN11);
			
			}
			else if(Os.equalsIgnoreCase("mac")){
				cap.setPlatform(Platform.MAC);
		}else {
			
			System.out.println("No matching os");
		}
			
			
			switch (browser.toLowerCase()) {

			case "chrome":
				
				cap.setBrowserName("chrome");

				
                break;

			case "edge":
				
				cap.setBrowserName("edge");
				
				break;
			default:
				System.out.println("Invalid Browser");
				return;

			}
			try {
				driver = new RemoteWebDriver(new URL("http://localhost:4444"), cap);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.get(prop.getProperty("url"));

		}	*/
		

		
		//if(prop.getProperty("execution_env").equalsIgnoreCase("local")) {
		switch (browser.toLowerCase()) {

		case "chrome":
			
			

			WebDriverManager.chromedriver().setup();

			ChromeOptions options = new ChromeOptions();
			options.addArguments("disable-notifications");
			options.addArguments("--remote-allow-origins=*");
			options.addArguments("--no-sandbox");
			options.addArguments("--disable-dev-shm-usage");
			logger = LogManager.getLogger(this.getClass());
			driver = new ChromeDriver(options);
			driver.manage().deleteAllCookies();
			

			driver.manage().window().maximize();
			

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.get("https://tutorialsninja.com/demo/");
			
			
			break;

		case "edge":
			
			
			WebDriverManager.edgedriver().setup();

			EdgeOptions option = new EdgeOptions();

			option.addArguments("--remote-allow-origins=*");
			option.addArguments("--no-sandbox");
			option.addArguments("--disable-dev-shm-usage");
			logger = LogManager.getLogger(this.getClass());

			driver = new EdgeDriver(option);
			driver.manage().deleteAllCookies();
			

			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.get(prop.getProperty("url"));
			break;
		default:
			System.out.println("Invalid Browser");
			return;

		}
		
		//}		
	}

	@AfterClass(groups= {"Regression","Sanity","Master"})
	public void tearDown() {

		if (driver != null) {
		    driver.quit();
		} else {
		    System.out.println("WebDriver is not initialized.");
		}
	}

	public String randomstring() {

		String generatedstring = RandomStringUtils.randomAlphabetic(8);

		return generatedstring;

	}

	public String randomNumber() {

		String generatedstring = RandomStringUtils.randomNumeric(10);

		return generatedstring;

	}

	public String randomAlphanumeric() {

		String generatednumber = RandomStringUtils.randomNumeric(3);
		String generatedstring = RandomStringUtils.randomAlphabetic(5);

		return generatedstring + generatednumber;

	}

	/*public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
				
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp + ".png";
		File targetFile=new File(targetFilePath);
		
		sourceFile.renameTo(targetFile);
			
		return targetFilePath;

	}*/

}
//thread-count="5" will be useful if we are running tests in parallel
