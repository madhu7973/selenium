package testNG;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class DataProviderUtility_ExceL {

	public static String excel_path = "C:\\Users\\Madhusudan Devaraju\\Desktop\\Selenium Docs\\TestDataExcelFile\\WalmartSignupTestData.xlsx";

	public static Object[][] testData(String sheetName) throws EncryptedDocumentException, IOException {
		FileInputStream file = new FileInputStream(excel_path);

		Workbook book = WorkbookFactory.create(file);

		Sheet sheet = book.getSheet(sheetName);

		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];

		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++)
				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
		}
		return data;
	}

}
