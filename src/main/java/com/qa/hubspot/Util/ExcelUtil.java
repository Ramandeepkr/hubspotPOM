package com.qa.hubspot.Util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtil {
	static Workbook book;
	 static org.apache.poi.ss.usermodel.Sheet sheet;
	public static String TESTDATA_SHEET_PATH = "C:/Users/Sandeep/eclipse-workspace1/AugPOMFrameWork"
			+ "/src/main/java/com/qa/hubspot/testdata/contacts.xlsx";
	/**
	 * This method is used to get the data sheet on the basis of sheet name..
	 * param sheetName
	 * @return 
	 */
	public static Object[][] getTestData(String sheetName)
	{
		try {
			FileInputStream fis = new FileInputStream(TESTDATA_SHEET_PATH);
			try {
				 book = WorkbookFactory.create(fis);
				 sheet = book.getSheet(sheetName);
				 Object data[][] = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
				 for(int i=0;i<sheet.getLastRowNum();i++)
				 {
					 for(int k=0;k<sheet.getRow(0).getLastCellNum();k++)
					 {
						 data[i][k] = sheet.getRow(i+1).getCell(k).toString();
					 }
				 }
				 return data;
			
			
			} catch (EncryptedDocumentException e) {
				e.printStackTrace();
			} catch (InvalidFormatException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return null;
		
	}

}
