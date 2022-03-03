
	package pageObjects;
	
	import org.openqa.selenium.By;
	
	import MyUtilities.baseClass;
	
	public class sideLinks extends baseClass {
		public By txt_login = By.linkText("Login");
		public By txt_register = By.linkText("Register");
		public By txt_forgotpass = By.linkText("Forgotten Password");
		public By txt_myaccount = By.linkText("My Account");
		public By txt_addressbook = By.linkText("Address Book");
		public By txt_wishlist = By.linkText("Wish List");
		public By txt_orderhistory = By.linkText("Order History");
	
	}
