	package com.cucumber.stepdefs;
	
	import java.io.IOException;
	
	import io.cucumber.java.en.Given;
	import io.cucumber.java.en.Then;
	import io.cucumber.java.en.When;
	import pageObjects.LoginPage;
	import MyUtilities.*;
	
	public class ToDoStepDefinition extends baseClass {
	
		pageObjects.LoginPage login = new LoginPage();
	
		@Given("user is on home Page")
		public void user_already_on_home_page() throws IOException {
			// initiateChormeDriver();
		}
	
		@When("open browser")
		public void select_first_item() throws IOException, InterruptedException {
			System.out.println("launching chrome browser");
			getAppUrl();
			maximizeWindow();
		}
	
		@Then("add new item (.*) and (.*)$")
		public void add_new_item(String TestCaseName, String Expected) throws Exception {
			String expectedValue = Expected;
			elementClick(login.btn_login);
			Thread.sleep(2000);
			String actualValue = getElementText(login.txt_loginerror);
			ReusableFunctions.addResultData(TestCaseName, expectedValue, actualValue);
		}
	
		// New Scenario
		@Given("user is at home Page")
		public void user_is_on_home_page() {
			// System.setProperty("webdriver.chrome.driver", driverPath);
		}

		@When("Get Side Limks")
		public void select_first_item1() throws IOException, InterruptedException {
			System.out.println("launching chrome browser");
		}

		@Then("Validate side Links(.*) and (.*)$")
		public void add_new_item1(String TestCaseName, String Expected) throws Exception {
			System.out.println("IM HERE");
			String expectedValue = Expected;
			String actualValue = getElementText(login.txt_login);
			ReusableFunctions.addResultData(TestCaseName, expectedValue, actualValue);
		}
	
	}