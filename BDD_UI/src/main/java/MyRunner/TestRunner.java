	package MyRunner;
	
	import org.testng.annotations.AfterClass;
	import org.testng.annotations.AfterTest;
	import org.testng.annotations.BeforeClass;
	import org.testng.annotations.DataProvider;
	import org.testng.annotations.Test;
	
	import io.cucumber.testng.CucumberOptions;
	import io.cucumber.testng.FeatureWrapper;
	import io.cucumber.testng.PickleWrapper;
	import io.cucumber.testng.TestNGCucumberRunner;
	import MyUtilities.ReusableFunctions;
	import MyUtilities.baseClass;
	
	@CucumberOptions(plugin = { "pretty", "json:target/report/cucumber.json" }, monochrome = true, features = {
			"src/test/resources/features" }, glue = { "com.cucumber.stepdefs" })
	public class TestRunner {
		private TestNGCucumberRunner testNGCucumberRunner;
	

		@BeforeClass(alwaysRun = true)
		public void setUpClass() throws Exception {
			// Call Extent Function
			 baseClass.initiateChormeDriver();
			ReusableFunctions.createExtentReportsInfo();
			testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
		}
	
		@Test(groups = "cucumber", description = "Runs Cucumber Feature", dataProvider = "scenarios")
		public void scenario(PickleWrapper pickleWrapper, FeatureWrapper featureWrapper) throws Throwable {
			testNGCucumberRunner.runScenario(pickleWrapper.getPickle());
		}
	
		@DataProvider
		public Object[][] scenarios() {
			return testNGCucumberRunner.provideScenarios();
		}
	
		// End the Extent Report
		@AfterTest(alwaysRun = true)
		public void afterTest() {
			ReusableFunctions.endReport();
		}
	
		@AfterClass(alwaysRun = true)
		public void tearDownClass() throws Exception {
			testNGCucumberRunner.finish();
			//baseClass.closeBrowser();
		}
	}