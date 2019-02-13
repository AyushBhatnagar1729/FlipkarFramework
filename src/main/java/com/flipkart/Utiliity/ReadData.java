package com.flipkart.Utiliity;

import java.util.ArrayList;

public class ReadData {

	public static XlsReader1 reader;
	
	public ArrayList<Object[]> getData(String sheetname)
	{
		ArrayList<Object[]> data = new ArrayList<Object[]>();
		reader = new XlsReader1("D:\\Flipkart framework\\test\\src\\main\\java\\com\\flipkart\\Testdata\\TestData.xlsx");
		int rowcount = reader.getRowCount(sheetname);
		for(int rownum =0; rownum<rowcount; rownum++ )
		{
			String username = reader.getCellData(sheetname, "Username", rownum);
			String password = reader.getCellData(sheetname, "Password", rownum);
			String address = reader.getCellData(sheetname, "Address", rownum);
			Object[] obj = {username, password, address};
			data.add(obj);
		}
		return data;
	}
}
