	package Selenium_Files;
	
	import java.io.FileInputStream;
	import java.io.IOException;
	import java.util.HashMap;
	import java.util.Properties;

	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.testng.Assert;
	import org.testng.annotations.AfterTest;
	import org.testng.annotations.BeforeTest;
	import org.testng.annotations.Test;
	
	public class UI_Sample_Chrome {
	
		public String baseUrl = "http://demo.guru99.com/test/newtours/";
		String driverPath = "..\\drivers\\chromedriver.exe";
		public WebDriver driver ; 
	
		@BeforeTest
		public void launchBrowser() throws IOException {
			System.out.println("launching chrome browser"); 
			System.setProperty("webdriver.chrome.driver", driverPath);
			driver = new ChromeDriver();
			driver.get(readProperties());
			String WindowName = driver.getWindowHandle();
			System.out.println(WindowName);
		}
		@Test
		public void verifyHomepageTitle() {
			String expectedTitle = "Welcome: Mercury Tours";
			String actualTitle = driver.getTitle();
			Assert.assertEquals(actualTitle, expectedTitle);
	
		}
	
		@Test
		public void sample() throws IOException {
			System.out.println(reverseString("SAI"));
			System.out.println(reverseString1("SAI"));
			System.out.println(hashMap());
			System.out.println(readProperties());
			System.out.println(testing());
		}
	
		@AfterTest
		public void terminateBrowser(){
			driver.close();
		}
	
		public static String reverseString(String str){  
			StringBuilder SB=new StringBuilder(str);
			SB.reverse();
			return SB.toString();
		}  
	
		public static String reverseString1(String str){  
			char ch[]=str.toCharArray();
			String rev="";  
			for(int i=ch.length-1;i>=0;i--){  
				rev+=ch[i];
			}  
			return rev;  
		}  
	
		public static HashMap<String, Integer> hashMap(){  
			HashMap<String,Integer> happy=new HashMap<String,Integer>();
			happy.put("a", 10);
			happy.put("b", 20);
			happy.put("c", 30);
			return happy;
	
		}
		
		public static String readProperties() throws IOException{  
			Properties myProp = new Properties();
			FileInputStream inputstream = new FileInputStream(".//config/config.properties");
			myProp.load(inputstream);
			String baseURL = myProp.getProperty("baseURL");
			return baseURL;
			
		} 
	
		public static int testing() throws IOException{  
			int a =100;
			Integer objI=a;
			//int i= objI;
			return objI;
			
		} 
	}
