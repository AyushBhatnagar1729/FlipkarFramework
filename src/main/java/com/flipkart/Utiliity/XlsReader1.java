package com.flipkart.Utiliity;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XlsReader1 {

    public String path;
	public FileInputStream fis = null;
	public FileOutputStream fos = null;
	public XSSFWorkbook book = null;
	public XSSFSheet sheet = null;
	public XSSFCell cell= null;
	public XSSFRow row = null;
	 
	public XlsReader1(String path)
	{
		this.path = path;
		try {
		fis = new FileInputStream(path);
		book = new XSSFWorkbook(fis);
		sheet = book.getSheetAt(0); // returns the XSSFSheet object at the given index
		fis.close();
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	 
	//this method will return the number of rows in the specified sheet
	public int getRowCount(String sheetname)
	{
		int index = book.getSheetIndex(sheetname);
		if(index == -1)
			return 0;
		else{
		sheet = book.getSheetAt(index);
		int rowCount = sheet.getLastRowNum()+1;
		return rowCount;
		}
	}
	
	//This method will return the cell data
	public String getCellData(String sheetname, String colname, int rownum)
	{
		try {
		if(rownum <= -1)
			return "";
		int index = book.getSheetIndex(sheetname);
		if(index == -1)
			return "";
		sheet = book.getSheetAt(index);
		row = sheet.getRow(0);
		int colnum = -1;
		for(int i = 0; i<row.getLastCellNum();i++)
		{
			if(row.getCell(i).getStringCellValue().trim().equals(colname.trim()))
					colnum = i;
		}
		
		if(colnum == -1)
			return "";
		
		sheet = book.getSheetAt(index);
		row = sheet.getRow(rownum-1);
		
		if(row == null)
			return "";
		
		cell = row.getCell(colnum);
		
		if(cell == null)
			return "";
		
		if(cell.getCellType() == CellType.STRING)
			return cell.getStringCellValue();
		
		else if(cell.getCellType()==CellType.NUMERIC || cell.getCellType() == CellType.FORMULA)
			{String cellText = String.valueOf(cell.getNumericCellValue());
			return cellText;
			}
		
		else if(cell.getCellType() == CellType.BLANK)
			return "";
		
		else
		return String.valueOf(cell.getBooleanCellValue());
		//return cellText;
	}
		catch(Exception e) {
			e.printStackTrace();
			return "row "+rownum+" or column "+colname +" does not exist in xls";
		}
	}
			
}
