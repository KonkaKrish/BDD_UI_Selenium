package Selenium_Files;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UI_Sample_DriverManager {
	
	@Test
	public void testing() throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		// Navigate to the demoqa website
		driver.get("https://www.google.com");
		Thread.sleep(5000);
		driver.quit();
	}
}
