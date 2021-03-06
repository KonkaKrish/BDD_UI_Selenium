	package MyUtilities;
	
	import java.io.File;
	import java.io.FileInputStream;
	import java.io.FileOutputStream;
	import java.io.FileWriter;
	import java.io.IOException;
	import java.util.ArrayList;
	import java.util.Date;
	import java.util.Properties;
	
	import org.apache.poi.ss.usermodel.Row;
	import org.apache.poi.xssf.usermodel.XSSFCell;
	import org.apache.poi.xssf.usermodel.XSSFRow;
	import org.apache.poi.xssf.usermodel.XSSFSheet;
	import org.apache.poi.xssf.usermodel.XSSFWorkbook;
	
	import com.relevantcodes.extentreports.ExtentReports;
	import com.relevantcodes.extentreports.ExtentTest;
	import com.relevantcodes.extentreports.LogStatus;
	
	public class ReusableFunctions {
	
		public static String sheetName = "TestDataSheet";
		public FileWriter objwriter;
		static boolean htmlheader = true;
		public int iRow = 0;
		public long startTime;
		public String newStartTime = null;
		public static int iPassCount;
		public static int iFailCount;
		public static int tPassCount;
		public static int tFailCount;
		public static File fileName;
		public static FileInputStream fileInputStream;
		public String keyname = null;
		public static XSSFWorkbook excelWorkbook;
		static Properties prop;
		static FileInputStream input = null;
	
		// *************************************************************************************
		//
		// Start of Extent Reports Reusable Methods
		//
		// *************************************************************************************
		// Extent Reports Initialization
		static ExtentReports extent;
		static ExtentTest logger;

		// Create Extent Report Details
		public static void createExtentReportsInfo() {
			extent = new ExtentReports("./results/ExtentReport.html", true);
			extent.addSystemInfo("Host Name", "Sample Selenium").addSystemInfo("Environment", "Automation Testing")
					.addSystemInfo("User Name", "KONKA RAVI");
			extent.loadConfig(new File(System.getProperty("user.dir") + "\\config\\extent-config.xml"));
		}
		
		// Compare and Write results to Extent Report
		public static void addResultData(String testCaseName, String exceptedResult, String actualResult) throws Exception {
			logger = extent.startTest(testCaseName);
			if (exceptedResult.equals(actualResult)) {
				System.out.println("PASS");
				logger.log(LogStatus.INFO, "Expected Results || " + exceptedResult);
				logger.log(LogStatus.INFO, "Actual Results || " + actualResult);
				logger.log(LogStatus.PASS, "Test Case Passed");
			} else {
				System.out.println("FAIL");
				logger.log(LogStatus.INFO, "Expected Results || " + exceptedResult);
				logger.log(LogStatus.INFO, "Actual Results || " + actualResult);
				logger.log(LogStatus.FAIL, "Test Case Failed");
			}
		}
	
		// End logger after every Method
		public static void endLogger() {
			extent.endTest(logger);
		}
	
		// Close Extent logger after every Test
		public static void endReport() {
			extent.flush();
		}
	
		// *************************************************************************************
		//
		// END of Extent Reports Reusable Methods
		//
		// *************************************************************************************
	
		// Open Excel File
		public static void openExcelWorkBook() throws Exception {
			// System.out.println("Excel Opened");
			fileName = new File(".\\Test Data\\MyTestdata.xlsx");
			// fileName = new File((excelFilePath));
			fileInputStream = new FileInputStream(fileName);
			excelWorkbook = new XSSFWorkbook(fileInputStream);
	
		}
	
		public static String GetTestData(String KeyValue, String MyColumnName, String SheetName) throws IOException {
			String MyFinalvalue1 = null;
			String MyRowFlag1 = KeyValue;
			XSSFSheet MySheet1 = excelWorkbook.getSheet(SheetName);
			int RowCount = MySheet1.getLastRowNum() + 1;
			int ColumnCount = MySheet1.getRow(0).getLastCellNum();
			int TempValue = 0;
			for (int iRow = 1; iRow < RowCount; iRow++) {
				XSSFRow row = MySheet1.getRow(iRow);
				int flag = 0;
				for (int cellValue = 0; cellValue < row.getPhysicalNumberOfCells(); cellValue++) {
					row.getCell(cellValue, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
					XSSFCell cellValue1 = MySheet1.getRow(iRow).getCell(cellValue);
					// cellValue1.setCellType(CellType.STRING);
					if (MyRowFlag1.equals(cellValue1.getStringCellValue())) {
						//
						for (int iColumn = 0; iColumn < ColumnCount; iColumn++) {
							XSSFRow row2 = MySheet1.getRow(0);
							XSSFCell cell1 = row2.getCell(iColumn);
							if (MyColumnName.equals(cell1.getStringCellValue())) {
								//
								TempValue = iColumn;
								flag = 1;
								break;
							}
						}
						XSSFRow row1 = MySheet1.getRow(iRow);
						MyFinalvalue1 = row1.getCell(TempValue).getStringCellValue();
						//
						break;
					}
					if (flag == 1) {
						break;
					}
				}
				if (flag == 1) {
					break;
				}
			}
	
			return MyFinalvalue1;
		}
	
		public void WriteExpectedResults(String keyvalue, String sheetName, String MyColumnName, String value)
				throws IOException {
			FileInputStream MyInputStream1 = new FileInputStream(fileName);
			FileOutputStream fos = null;
			excelWorkbook = new XSSFWorkbook(MyInputStream1);
			String MyRowFlag1 = keyvalue;
			XSSFSheet MySheet1 = excelWorkbook.getSheet(sheetName);
			int RowCount = MySheet1.getLastRowNum() + 1;
			int ColumnCount = MySheet1.getRow(0).getLastCellNum();
			int TempValue = 0;
			for (int iRow = 1; iRow < RowCount; iRow++) {
				XSSFRow row = MySheet1.getRow(iRow);
				int flag = 0;
				for (int cellValue = 0; cellValue < row.getPhysicalNumberOfCells(); cellValue++) {
	
					row.getCell(cellValue, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
					XSSFCell cellValue1 = MySheet1.getRow(iRow).getCell(cellValue);
					// cellValue1.setCellType(CellType.STRING);
					if (MyRowFlag1.equals(cellValue1.getStringCellValue())) {
						//
						for (int iColumn = 0; iColumn < ColumnCount; iColumn++) {
							XSSFRow row2 = MySheet1.getRow(0);
							XSSFCell cell1 = row2.getCell(iColumn);
							if (MyColumnName.equals(cell1.getStringCellValue())) {
								//
								TempValue = iColumn;
								flag = 1;
								break;
							}
						}
						XSSFCell cell1 = row.getCell(TempValue);
						cell1.setCellValue(value);
						fos = new FileOutputStream(fileName);
						excelWorkbook.write(fos);
						fos.close();
						break;
					}
					if (flag == 1) {
						break;
					}
				}
				if (flag == 1) {
					break;
				}
			}
	
		}
	
		/********
		 * Fetching the row count excel sheet
		 * 
		 * @param Sheetname
		 * @return
		 * @throws IOException
		 */
		public static int GetRowCount(String sheetName) throws IOException {
			// System.out.println("row Count sheet name " + sheetName);
			XSSFSheet MySheet1 = excelWorkbook.getSheet(sheetName);
			int RowCount = MySheet1.getLastRowNum() + 1;
	
			return RowCount;
		}
	
		public static String ActualDataConversion(ArrayList<String> actualData2) throws Exception {
			String FianlActual = actualData2.toString(); // Converting Array to
															// String
			FianlActual = FianlActual.replace(", ", "|");
			FianlActual = FianlActual.replace("[", "");
			FianlActual = FianlActual.replace("]", "");
			return FianlActual;
		}
	
		public static String GetCellData(String Scenario_Key, String ColumnName) throws Exception {
	
			String ExpectedData = null;
			int rowCount = GetRowCount(sheetName);
			for (int i = 1; i < rowCount; i++) {
				if ((GetTestData(Scenario_Key, "Run", sheetName)).equals("YES")) {
					ExpectedData = GetTestData(Scenario_Key, ColumnName, sheetName);
				}
			}
			return ExpectedData;
		}
	
		public static void Close() throws Exception {
			// System.out.println("Excel Closed");
			excelWorkbook.close();
			fileInputStream.close();
		}
	
		public String TestScenPropertyFile(String ScenarioName) throws IOException {
			String SheetName = ReadPropertiesFile(ScenarioName);
			return SheetName;
		}
	
		public static String DynamicValue() {
			Date currentdatetime = new Date();
			String NewDatetime = currentdatetime.toString();
			NewDatetime = NewDatetime.replace("/", "");
			NewDatetime = NewDatetime.replace(" ", "");
			NewDatetime = NewDatetime.replace("AM", "");
			NewDatetime = NewDatetime.replace("PM", "");
			NewDatetime = NewDatetime.replace(":", "");
			NewDatetime = NewDatetime.replace("CET", "");
			return NewDatetime;
		}
	
		/*
		 * public static void Compare_WriteResults(String ExpectedValue, String
		 * ActualValue, ExtentTest logInfo) throws Exception {
		 * 
		 * JSONParser myParser = new JSONParser(); Object jsonExpected =
		 * myParser.parse(ExpectedValue); Object jsonActual =
		 * myParser.parse(ExpectedValue);
		 * 
		 * // Compare Expected vs Actual and write results to report if
		 * (jsonExpected.equals(jsonActual)) { //
		 * logInfo.pass("Expected and Actual are Matching");
		 * Actual_Expected_Comp("PASS", logInfo); } else { //
		 * logInfo.fail("Expected and Actual are NOT Matching");
		 * Actual_Expected_Comp("FAIL", logInfo); }
		 * 
		 * // Writing Actual and Expected values to Extent reports
		 * logInfo.info("********************************************************");
		 * logInfo.info("Expected Value >> From Excel Sheet");
		 * logInfo.info("********************************************************");
		 * logInfo.info(ExpectedValue);
		 * logInfo.info("********************************************************");
		 * logInfo.info("Actual Value >> From Server Response");
		 * logInfo.info("********************************************************");
		 * logInfo.info(ActualValue); }
		 */
	
		/************
		 * Reading values from Properties file
		 * 
		 * @param Filename
		 * @param KeyName
		 * @return KeyValue
		 * @throws IOException
		 */
		public static String ReadPropertiesFile(String KeyName) throws IOException {
			prop = new Properties();
			String KeyValue = null;
			input = new FileInputStream("./config/config.properties");
	
			// load a properties file
			prop.load(input);
	
			// get the property value and print it out
			KeyValue = prop.getProperty(KeyName);
	
			return KeyValue;
		}
	
	}