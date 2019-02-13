package com.flipkart.Utiliity;

import java.io.FileInputStream;

import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class XlsReader {

	public static Workbook book;
	public static Sheet sheet;
	
	//This will return a 2D array of String type.
	public static String[][] getTestData(String sheetname){
		FileInputStream fis = null;
	try {
		 fis = new FileInputStream(Constants.WORKBOOK_PATH);
	}
	catch(IOException e) {
		e.printStackTrace();
	}
	try {
		book = WorkbookFactory.create(fis);
	}
	catch(IOException e) {
		e.printStackTrace();
	}
	sheet = book.getSheet(sheetname);
	
	String[][] data = new String[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
	for(int i = 0; i<sheet.getLastRowNum(); i++)
	{
		for(int j=0; j<sheet.getRow(0).getLastCellNum();j++)
		{
			data[i][j] = sheet.getRow(i+1).getCell(j).toString();
		}
	}
	return data;

  }
}
