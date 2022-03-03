	
	package Selenium_Files;
	
	import java.io.File;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.testng.annotations.AfterMethod;
	import org.testng.annotations.AfterTest;
	import org.testng.annotations.BeforeMethod;
	import org.testng.annotations.BeforeTest;
	import org.testng.annotations.Test;
	import com.relevantcodes.extentreports.ExtentReports;
	import com.relevantcodes.extentreports.ExtentTest;
	import com.relevantcodes.extentreports.LogStatus;
	
	public class UI_Sample_Extent {
		// Extent report initialization
		ExtentReports extent;
		ExtentTest logger;
	
		// Browser initialization
		public String baseUrl = "http://demo.guru99.com/test/newtours/";
		String driverPath = "C:\\Users\\Ravi Konka\\Automation\\Software\\Drivers\\geckodriver.exe";
		public WebDriver driver;
	
		@BeforeTest
		public void startReport() {
			// Extent Reports code
			extent = new ExtentReports(".\\results\\ExtentReport.html", true);
			extent.addSystemInfo("Host Name", "Sample Selenium").addSystemInfo("Environment", "Automation Testing")
					.addSystemInfo("User Name", "KONKA RAVI");
			extent.loadConfig(new File(System.getProperty("user.dir") + "\\config\\extent-config.xml"));
	
			// Browser Code
			System.setProperty("webdriver.gecko.driver", driverPath);
			driver = new FirefoxDriver();
			driver.get(baseUrl);
		}
	
		@BeforeMethod
		public void startLogger() {
			logger = extent.startTest("FireFox Testing");
		}
	
		@Test
		public void passTest() throws Exception {
			// Browser Code
			String expectedTitle = "Welcome: Mercury Tours1";
			String actualTitle = driver.getTitle();
			addResultData(expectedTitle, actualTitle);
		}
	
		public void addResultData(String exceptedResult, String actualResult) throws Exception {
			if (exceptedResult.equals(actualResult)) {
				System.out.println("PASS");
				logger.log(LogStatus.PASS, "Test Case Passed");
			} else {
				System.out.println("FAIL");
				logger.log(LogStatus.FAIL, "Test Case Failed");
			}
		}
	
		@AfterMethod
		public void endLogger() {
			extent.endTest(logger);
		}
	
		@AfterTest
		public void endReport() {
			// Extent Report Code
			extent.flush();
			extent.close();
			// Browser Code
			driver.close();
		}
	
	}