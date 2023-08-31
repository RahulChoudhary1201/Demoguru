package com.utils;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

//Extra class added 
public class ExcelUtils {
	private static XSSFSheet ExcelWSheet;
	private static XSSFWorkbook ExcelWBook;
	private static FileInputStream excelFile;
	private static String filePath;

	public static Object[][] readExcelData(String sheetName) throws Exception {
		String[][] arrayExcelData = null;
		FileInputStream file = null;

		String workingDir = System.getProperty("user.dir");
		filePath = workingDir
				+ "\\src\\test\\java\\com\\testdata\\DemoGuruLoginTestData.xlsx";
		excelFile = new FileInputStream(filePath);
		ExcelWBook = new XSSFWorkbook(excelFile);
		ExcelWSheet = ExcelWBook.getSheet(sheetName);
		int rowcount = ExcelWSheet.getLastRowNum();
		DataFormatter formatter = new DataFormatter();
		arrayExcelData = new String[rowcount][12];
		for (int i = 0; i < rowcount; i++) {
			Row row = ExcelWSheet.getRow(i + 1);
			for (int k = 0; k < row.getLastCellNum(); k++) {
				Cell celval = row.getCell(k);
				if (celval != null) {
					arrayExcelData[i][k] = formatter.formatCellValue(celval);
				}
			}
		}
		return arrayExcelData;
	}
	public static void main(String[] args) throws Exception {
	Object[][] data = ExcelUtils.readExcelData("Sheet1");
	for (int i = 0; i < data.length; i++) {
		for (int j = 0; j < data[0].length; j++) {
			System.out.print(data[i][j] + " ");
		}
		System.out.println();
	}
}
}
