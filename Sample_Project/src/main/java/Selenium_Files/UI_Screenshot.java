	package Selenium_Files;
	
	import java.io.File;
	import java.io.IOException;
	
	import org.apache.commons.io.FileUtils;
	import org.openqa.selenium.OutputType;
	import org.openqa.selenium.TakesScreenshot;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.testng.Assert;
	import org.testng.annotations.AfterTest;
	import org.testng.annotations.BeforeTest;
	import org.testng.annotations.Parameters;
	import org.testng.annotations.Test;
	
	public class UI_Screenshot {
	
		public String baseUrl = "http://demo.guru99.com/test/newtours/";
		String driverPath = "..\\drivers\\chromedriver.exe";
		public WebDriver driver ; 
	
		@BeforeTest
		public void launchBrowser() throws IOException {
			System.out.println("launching chrome browser"); 
			System.setProperty("webdriver.chrome.driver", driverPath);
			driver = new ChromeDriver();
			driver.get(baseUrl);
			File screenshotfile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshotfile, new File(".//screenshots/app1.jpg"));
		}
		@Test
		@Parameters("MyKey")
		public void verifyHomepageTitle() {
			String expectedTitle = "Welcome: Mercury Tours";
			String actualTitle = driver.getTitle();
			Assert.assertEquals(actualTitle, expectedTitle);
			//System.out.println(MyKey);
	
		}
		@AfterTest
		public void terminateBrowser(){
			driver.close();
		}
	}
