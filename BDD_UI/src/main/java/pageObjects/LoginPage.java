
	package pageObjects;
	
	import org.openqa.selenium.By;
	
	public class LoginPage {
	
		public By txt_username = By.id("input-email");
		public By txt_password = By.id("input-password");
		public By btn_login = By.xpath("//input[@value='Login']");
		public By txt_loginerror = By.xpath("//div[@class='alert alert-danger alert-dismissible']");
		public By txt_login = By.linkText("Login");

	}
