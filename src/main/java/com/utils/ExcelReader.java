package com.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ExcelReader {

	public static String[][] readingExcelSheet(String filePath, String fileName,
			String sheetName) throws IOException {
		File file = new File(filePath + "\\" + fileName);
		FileInputStream fis = new FileInputStream(file);
		Workbook workbook = null;
		DataFormatter formatter = new DataFormatter();
		String fileExtensionName = fileName.substring(fileName.indexOf("."));
		if (fileExtensionName.contains(".xlsx")) {
			workbook = new XSSFWorkbook(fis);
		} else if (fileExtensionName.contains(".xls")) {
			workbook = new HSSFWorkbook(fis);
		}

		Sheet workbookSheet = workbook.getSheet(sheetName);
		int rowCount = workbookSheet.getPhysicalNumberOfRows();
		int colCount = workbookSheet.getRow(0).getLastCellNum();
		String[][] data = new String[rowCount][colCount];
		for (int i = 0; i < rowCount; i++) {
			Row row = workbookSheet.getRow(i);
			for (int j = 0; j < colCount; j++) {
				Cell cell = row.getCell(j);
				if (cell != null) {
					data[i][j] = formatter.formatCellValue(cell);
				}
			}
		}
		return data;
	}

	// @Test(dataProvider = "myData")
	// public void test1(String firstNameValue, String lastNameValue,
	// String phoneValue, String emailValue, String addressValue,
	// String cityValue, String stateValue, String postalCodeValue,
	// String countryValue, String userNameValue, String passValue,
	// String confirmPassValue) throws IOException {
	// Object[][] data = ExcelReader.readingExcelSheet(
	// ".\\src\\test\\java\\com\\testdata",
	// "DemoGuruLoginTestData.xlsx", "Sheet1");
	// for (int i = 0; i < data.length; i++) {
	// for (int j = 0; j < data[0].length; j++) {
	// System.out.print(data[i][j] + " ");
	// }
	// System.out.println();
	// System.out.println(firstNameValue + lastNameValue + phoneValue
	// + emailValue + addressValue + cityValue + stateValue
	// + postalCodeValue + countryValue + userNameValue + passValue
	// + confirmPassValue);
	// }
	// public static void main(String[] args) throws IOException {
	// Object[][] data = ExcelReader.readingExcelSheet(
	// ".\\src\\test\\java\\com\\testdata",
	// "DemoGuruLoginTestData.xlsx", "Sheet1");
	// for (int i = 0; i < data.length; i++) {
	// for (int j = 0; j < data[0].length; j++) {
	// System.out.print(data[i][j] + " ");
	// }
	// System.out.println();
	// }
	// }
//	@DataProvider(name = "myData")
//	public Object[][] dataProvide() throws IOException {
//
//		Object[][] data = ExcelReader.readingExcelSheet(
//				".\\src\\test\\java\\com\\testdata",
//				"DemoGuruLoginTestData.xlsx", "Sheet1");
//		Object[][] formattedData = new String[data.length - 1][data[1].length];
//		for (int i = 1; i < data.length; i++) {
//			for (int j = 0; j < data[0].length; j++) {
//				formattedData[i - 1][j] = data[i][j];
//			}
//		}
//		return formattedData;
//	}
//	@Test(dataProvider = "myData")
//	public void testData(String firstNameValue, String lastNameValue,
//			String phoneValue, String emailValue, String addressValue,
//			String cityValue, String stateValue, String postalCodeValue,
//			String countryValue, String userNameValue, String passValue,
//			String confirmPassValue) {
//		System.out.println(firstNameValue + lastNameValue + phoneValue
//				+ emailValue + addressValue + cityValue + stateValue
//				+ postalCodeValue + countryValue + userNameValue + passValue
//				+ confirmPassValue);
//
//	}
}
