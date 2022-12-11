package com.utility;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadExcelLoginUtils {
	
	public static String readExcelSheet(String fileName, String sheetName, int row, int col) throws Exception
	{   
		DataFormatter df = new DataFormatter();
		
		FileInputStream fis = new FileInputStream(fileName);
		
		Workbook wb= WorkbookFactory.create(fis);
		
		Sheet sheet = wb.getSheet(sheetName);
		
		Cell cell=sheet.getRow(row).getCell(col);
		
		return df.formatCellValue(cell);
		
		}


}
