	package Library;
	
	import java.io.File;
	import java.io.FileInputStream;
	import java.io.FileOutputStream;
	import java.io.FileWriter;
	import java.io.IOException;
	import org.apache.poi.ss.usermodel.CellType;
	import org.apache.poi.ss.usermodel.Row;
	import org.apache.poi.xssf.usermodel.XSSFCell;
	import org.apache.poi.xssf.usermodel.XSSFRow;
	import org.apache.poi.xssf.usermodel.XSSFSheet;
	import org.apache.poi.xssf.usermodel.XSSFWorkbook;
	
	public class reuseFunctions {
	
	public String sheetName;
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
	public FileInputStream fileInputStream;
	public String keyname = null;
	public static XSSFWorkbook excelWorkbook;
	
		/***
	 * Opening Excel Workbook
	 * 
	 * @throws Exception
	 */
	public void openExcelWorkBook() throws Exception {
	
		// src//test//resources//config//config.properties
	fileName = new File(System.getProperty("user.dir") + "//src//test//resources//testData//Gemini_TestData.xlsx");
		fileInputStream = new FileInputStream(fileName);
		excelWorkbook = new XSSFWorkbook(fileInputStream);
	
	}
	
	/*****
	 * Get Data From excel
	 * 
	 * @param KeyValue
	 * @param MyColumnName
	 * @param sheetName
	 * @return
	 * @throws IOException
	 */
	public String getTestData(String KeyValue, String MyColumnName, String sheetName) throws IOException {
	
		String MyRowFlag1 = KeyValue;
		String MyFinalvalue1 = null;
		XSSFSheet MySheet1 = excelWorkbook.getSheet(sheetName);
		int RowCount = MySheet1.getLastRowNum() + 1;
		int ColumnCount = MySheet1.getRow(0).getLastCellNum();
		int TempValue = 0;
	
		for (int iRow = 1; iRow < RowCount; iRow++) {
			XSSFRow row = MySheet1.getRow(iRow);
			int flag = 0;
			for (int cellValue = 0; cellValue < row.getPhysicalNumberOfCells(); cellValue++) {
				String data = null;
				XSSFCell cell1 = row.getCell(cellValue, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
				if (cell1.getCellType() == CellType.STRING)
					data = cell1.getStringCellValue();
				else if (cell1.getCellType() == CellType.NUMERIC)
					data = String.valueOf(cell1.getNumericCellValue());
				if (MyRowFlag1.equals(data)) {
					for (int iColumn = 0; iColumn < ColumnCount; iColumn++) {
						XSSFRow row2 = MySheet1.getRow(0);
						XSSFCell cell = row2.getCell(iColumn);
						if (MyColumnName.equals(cell.getStringCellValue())) {
							TempValue = iColumn;
							flag = 1;
							break;
						}
					}
	
					XSSFRow row1 = MySheet1.getRow(iRow);
					MyFinalvalue1 = row1.getCell(TempValue, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK)
							.getStringCellValue();
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
	
	/********
	 * Fetching the row count excel sheet
	 * 
	 * @param Sheetname
	 * @return
	 * @throws IOException
	 */
	public int getRowCount(String sheetName) throws IOException {
	
		XSSFSheet MySheet1 = excelWorkbook.getSheet(sheetName);
		int RowCount = MySheet1.getLastRowNum() + 1;
	
		return RowCount;
	}
	
	/***
	 * Writing the test data
	 * 
	 * @param keyvalue
	 * @param sheetName
	 * @param MyColumnName
	 * @param value
	 * @throws IOException
	 */
	public void writeTestData(String keyvalue, String sheetName, String MyColumnName, String value) throws IOException {
		FileInputStream MyInputStream1 = new FileInputStream(fileName);
		FileOutputStream fos = null;
		excelWorkbook = new XSSFWorkbook(MyInputStream1);
		String MyRowFlag1 = keyvalue;
		XSSFSheet MySheet1 = excelWorkbook.getSheet(sheetName);
		int RowCount = MySheet1.getLastRowNum() + 1;
		int ColumnCount = MySheet1.getRow(0).getLastCellNum();
		int TempValue = 0;
		for (int iRow = 0; iRow < RowCount; iRow++) {
			XSSFRow row = MySheet1.getRow(iRow);
			if (MyRowFlag1.equals(row.getCell(0).getStringCellValue())) {
				for (int iColumn = 0; iColumn < ColumnCount; iColumn++) {
					XSSFRow row2 = MySheet1.getRow(0);
					XSSFCell cell = row2.getCell(iColumn);
	
					if (MyColumnName.equals(cell.getStringCellValue())) {
						TempValue = iColumn;
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
		}
	
	}
	
	/**
	 * Close Excel Workbook
	 * 
	 * @throws Exception
	 */
		public void closeWorkBook() throws Exception {
			excelWorkbook.close();
			fileInputStream.close();
		}
	
	}
