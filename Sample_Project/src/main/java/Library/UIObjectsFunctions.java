/*
 * package Library;
 * 
 * import java.io.IOException; import java.text.DateFormat; import
 * java.text.SimpleDateFormat; import java.util.ArrayList; import
 * java.util.Calendar; import java.util.List; import
 * java.util.concurrent.TimeUnit; import org.openqa.selenium.By; import
 * org.openqa.selenium.JavascriptExecutor; import
 * org.openqa.selenium.NoSuchElementException; import
 * org.openqa.selenium.StaleElementReferenceException; import
 * org.openqa.selenium.WebDriver; import org.openqa.selenium.WebElement; import
 * org.openqa.selenium.chrome.ChromeDriver; import
 * org.openqa.selenium.chrome.ChromeOptions; import
 * org.openqa.selenium.interactions.Actions; import
 * org.openqa.selenium.support.ui.ExpectedConditions; import
 * org.openqa.selenium.support.ui.Select; import
 * org.openqa.selenium.support.ui.WebDriverWait;
 * 
 * public class UIObjectsFunctions {
 * 
 * 
 * 
 * public WebDriver openBrowser() throws IOException { String chromeDriverPath =
 * System.getProperty(baseClass.USER_DIR) +
 * "//src//test//resources//drivers//windows//chromedriver.exe";
 * System.setProperty("webdriver.chrome.driver", chromeDriverPath);
 * ChromeOptions options = new ChromeOptions(); //
 * options.addArguments("--headless");
 * options.setExperimentalOption("useAutomationExtension", false);
 * options.addArguments("--start-maximized");
 * options.addArguments("--disable-extensions");
 * options.addArguments("--disable-notifications");
 * options.addArguments("--ignore-certificate-errors"); driver = new
 * ChromeDriver(options); deleteAllCookies(); return driver; }
 * 
 * // Fetching the Application Url from config file public void getAppUrl() {
 * driver.get(baseClass.configProperties.getProperty("baseUrl"));
 * implicitWait(5);
 * 
 * }
 * 
 * // Maximizing the browser window public void maximizeWindow() {
 * driver.manage().window().maximize(); }
 * 
 * // Closing the browser public void closeBrowser() { driver.close(); }
 * 
 * // Quitting the browser public void quitBrowser() { driver.quit(); }
 * 
 * // Defining wait for certain time frame public void implicitWait(int time) {
 * driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS); }
 * 
 * // Waits until the condition is satisfied public void explicitWait(WebElement
 * element) { WebDriverWait wait = new WebDriverWait(driver, 60);
 * wait.until(ExpectedConditions.visibilityOf(element)); }
 * 
 * // Wait for page to load completely public void pageLoad(int time) {
 * driver.manage().timeouts().pageLoadTimeout(time, TimeUnit.SECONDS); }
 * 
 * // Deleting browser cookies public void deleteAllCookies() {
 * driver.manage().deleteAllCookies(); }
 * 
 * // Getting the Time stamp public String currentDateTime() { DateFormat
 * dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss"); Calendar cal =
 * Calendar.getInstance(); String cal1 = dateFormat.format(cal.getTime());
 * return cal1; }
 * 
 * // Performing click on WebElement using Javascript Executor public void
 * clickUsingExecutor(WebElement element) throws Exception { try { if
 * (element.isDisplayed()) {
 * 
 * JavascriptExecutor executor = (JavascriptExecutor) driver;
 * executor.executeScript("arguments[0].click();", element); Thread.sleep(3000);
 * } } catch (StaleElementReferenceException e) { } catch
 * (NoSuchElementException e) { } catch (Exception e) {
 * 
 * } }
 * 
 * // Performing Mouse Hover on WebElement using Javascript Executor public void
 * mouseHoverOnWebElement(WebElement HoverElement) { try {
 * 
 * Thread.sleep(2000); String mouseOverScript =
 * "if(document.createEvent){var evObj = document.createEvent('MouseEvents');evObj.initEvent('mouseover', true, false); arguments[0].dispatchEvent(evObj);} else if(document.createEventObject) { arguments[0].fireEvent('onmouseover');}"
 * ; ((JavascriptExecutor) driver).executeScript(mouseOverScript, HoverElement);
 * 
 * Thread.sleep(2000);
 * 
 * } catch (StaleElementReferenceException e) { } catch (NoSuchElementException
 * e) { } catch (Exception e) { e.printStackTrace(); } }
 * 
 *//****
	 * Selecting the value from the dropdown
	 * 
	 * @param webElement
	 * @param elementToSelect
	 */
/*
 * public void selectValueFromDropdown(WebElement webElement, String
 * elementToSelect) { try { Select select = new Select(webElement);
 * select.selectByVisibleText(elementToSelect); } catch (Exception e) {
 * e.toString(); } }
 * 
 *//***
	 * Checking the Status of WebElement
	 * 
	 * @param elementName
	 * @return
	 * @throws InterruptedException
	 */
/*
 * public boolean isActive(WebElement elementName) throws InterruptedException {
 * Thread.sleep(1000); if (elementName.getAttribute("class").contains("active"))
 * { return true; }
 * 
 * else { return false;
 * 
 * }
 * 
 * }
 * 
 *//***
	 * Wait to perform click on WebElement
	 * 
	 * @param elementName
	 * @throws Exception
	 */
/*
 * public void isReadyToClick(WebElement elementName) throws Exception { if
 * (elementName.isDisplayed() && elementName.isEnabled()) {
 * clickUsingExecutor(elementName); } }
 * 
 *//***
	 * Performing click on WebElement using Javascript Executor
	 * 
	 * @param webElement
	 */
/*
 * 
 * 
 * public boolean getWebElementStatus(WebElement webElement) { if
 * (webElement.getAttribute("class").contains("selected")) { return true; }
 * return false; }
 * 
 * public void executorClick(WebElement webElement) { JavascriptExecutor
 * executor = (JavascriptExecutor) driver;
 * executor.executeScript("arguments[0].click();", webElement); }
 * 
 *//***
	 * Check Modal displayed
	 * 
	 * @param modalWindow
	 * @return
	 */
/*
 * public boolean isModalDisplayed(List<WebElement> modalWindow) { if (null !=
 * modalWindow && !modalWindow.isEmpty()) { return true; } return false; }
 * 
 *//***
	 * Scrolling into WebElement View
	 * 
	 * @param webElement
	 * @throws Exception
	 */
/*
 * public void scrollToView(WebElement webElement) throws Exception {
 * ((JavascriptExecutor)
 * driver).executeScript("arguments[0].scrollIntoView(true);", webElement);
 * waitForElementToBeVisible(60, webElement);
 * 
 * }
 * 
 * public void waitforElement(long timeoutseconds, String element) {
 * WebDriverWait wait = new WebDriverWait(driver, timeoutseconds);
 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(
 * element))); }
 * 
 * // Waits for elements to be clickable public void
 * waitForElementToBeClickable(long timeoutseconds, WebElement element) {
 * WebDriverWait wait = new WebDriverWait(driver, timeoutseconds);
 * wait.until(ExpectedConditions.elementToBeClickable(element)); }
 * 
 * // Waits for Invisibility of the Element public void
 * waitForInvisibilityOfElement(long timeoutseconds, String element) {
 * WebDriverWait wait = new WebDriverWait(driver, timeoutseconds);
 * wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(
 * element))); }
 * 
 * // Waits for Elements to be in selected mode public void
 * waitForElementToSelect(long timeoutseconds, String element) { WebDriverWait
 * wait = new WebDriverWait(driver, timeoutseconds);
 * wait.until(ExpectedConditions.elementSelectionStateToBe(By.cssSelector(
 * element), true)); }
 * 
 * // Waits for Elements to disappeared from DOM public void
 * waitForElementToDisappear(long timeoutseconds, WebElement element) {
 * WebDriverWait wait = new WebDriverWait(driver, timeoutseconds);
 * wait.until(ExpectedConditions.invisibilityOf(element)); }
 * 
 * public void waitForElementToBeDisplayed(long timeoutseconds, WebElement
 * element) { WebDriverWait wait = new WebDriverWait(driver, timeoutseconds);
 * wait.until(ExpectedConditions.visibilityOf(element));
 * 
 * }
 * 
 * // Waits for list of WebElements to be displayed public void
 * waitForElementListToBeDisplayed(long timeoutseconds, List<WebElement>
 * elements) { WebDriverWait wait = new WebDriverWait(driver, timeoutseconds);
 * wait.until(ExpectedConditions.visibilityOfAllElements(elements));
 * 
 * }
 * 
 * // Wait for Elements to be Visible public void waitForElementToBeVisible(long
 * timeoutseconds, WebElement element) { WebDriverWait wait = new
 * WebDriverWait(driver, timeoutseconds);
 * wait.until(ExpectedConditions.visibilityOf(element));
 * 
 * }
 * 
 * // Waits for the presence of WebElement public void
 * waitForPresenceOfElement(long timeoutseconds, String element) { WebDriverWait
 * wait = new WebDriverWait(driver, timeoutseconds);
 * wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(element
 * ))); }
 * 
 * //Performs double click on the WebElement public void doubleClick(WebElement
 * targetElement) throws InterruptedException { Actions elementActions = new
 * Actions(driver); elementActions.doubleClick(targetElement).build().perform();
 * }
 * 
 * public void selectValueFromLinkText(String elementToSelect) { try {
 * driver.findElement(By.linkText(elementToSelect)).click();
 * 
 * Thread.sleep(1000); } catch (Exception e) { e.printStackTrace(); } }
 *//*********
	 * This method is used for performing mouse hover action on Web Elements
	 * 
	 * @param targetElement
	 * @throws InterruptedException
	 */
/*
 * public void performActions(WebElement targetElement) throws
 * InterruptedException { Actions performActions = new Actions(driver);
 * performActions.moveToElement(targetElement).build().perform();
 * 
 * }
 * 
 * public void scrollBy() throws InterruptedException { JavascriptExecutor
 * Scrool = (JavascriptExecutor) driver; Thread.sleep(1000);
 * Scrool.executeScript("window.scrollBy(0,300)");
 * Scrool.executeScript("window.scrollBy(0,-300)"); }
 *//***
	 * Fetch values from dropdown
	 * 
	 * @param webElement
	 * @return
	 *//*
		 * 
		 * public ArrayList<String> fetchValuesfromDropdown(WebElement webElement) {
		 * ArrayList<String> values = new ArrayList<>(); try{ Select select = new
		 * Select(webElement); List<WebElement> Options = select.getOptions(); for (int
		 * i = 0; i < Options.size(); i++) { values.add(Options.get(i).getText()); }
		 * }catch(Exception e) { e.printStackTrace(); } values.remove("Select"); return
		 * values; } }
		 */