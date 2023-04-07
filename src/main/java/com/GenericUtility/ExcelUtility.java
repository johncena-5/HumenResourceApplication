package com.GenericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	
	public void excelIntialization(String excelPath) {
		
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(excelPath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			wb = WorkbookFactory.create(fis);
		} catch (EncryptedDocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	/**
	 * this method is used to read data from excel sheet
	 */
	
	Workbook wb = null;
	public String readDataFromExcel(String SheetName, int RowNo, int CellNo) throws EncryptedDocumentException, IOException  {
		
		FileInputStream fis = new FileInputStream(IConstantPath.EXCEL_FILE_PATH);
		
		wb = WorkbookFactory.create(fis);
		
	    Sheet sh = wb.getSheet(SheetName); 
	    String value = sh.getRow(RowNo).getCell(CellNo).getStringCellValue();
	    return value; 
	}
	/**
	 * This method is used to get the last row of the excel sheet
	 * @param SheetName
	 * @return
	 * @throws IOException 
	 * @throws EncryptedDocumentException 
	 * @throws Throwable
	 */
	public int getLastRowNum(String SheetName) throws EncryptedDocumentException, IOException  {
		FileInputStream fis = new FileInputStream(IConstantPath.EXCEL_FILE_PATH);
		
		wb = WorkbookFactory.create(fis);
		
	    Sheet sh = wb.getSheet(SheetName);
	    int count = sh.getLastRowNum();
		return count;
	}
	/**
	 * This method is used to write data in excel sheet
	 * @param SheetName
	 * @param RowNum
	 * @param CellNum
	 * @param data
	 * @throws Throwable 
	 * @throws Throwable
	 */
	public void writeDataIntoExcelSheet(String SheetName, int RowNum, int CellNum, String data) throws Throwable  {
		
		FileInputStream fis = new FileInputStream(IConstantPath.EXCEL_FILE_PATH);

		wb = WorkbookFactory.create(fis);
		
	    Sheet sh = wb.getSheet(SheetName);
		sh.createRow(RowNum).createCell(CellNum).setCellValue(data);
		FileOutputStream fos = new FileOutputStream(IConstantPath.EXCEL_FILE_PATH);
	
		wb.write(fos);
	}
	/**
	 * This method is used to read the multiple data from excel sheet
	 * @param SheetName
	 * @return
	 * @throws Throwable 
	 * @throws Throwable
	 */
	public HashMap<String, String> readMultipleDataFromExcel(String SheetName) throws Throwable {
		
		FileInputStream fis = new FileInputStream(IConstantPath.EXCEL_FILE_PATH);
		
	    wb = WorkbookFactory.create(fis);
		
	    Sheet sh = wb.getSheet(SheetName);
	    int count = sh.getLastRowNum();
	    HashMap<String, String> map = new HashMap<String, String>();
	    for(int i=0; i<=count; i++) {
	    	
	    	String key = sh.getRow(i).getCell(0).getStringCellValue();
	    	String value = sh.getRow(i).getCell(1).getStringCellValue();
	    	map.put(key, value);
	    }  
	    return map;
	}
	/**
	 * This method is used to close the excel sheet
	 * @throws Throwable 
	 */
	public void closeExcel()  {
		
		try {
			wb.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	/**
	 * This method is used to read multiple set of data through excel
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	
	public Object[][] readMultipleSetOfDataFromExcel() throws EncryptedDocumentException, IOException {
		
		FileInputStream fis = new FileInputStream(IConstantPath.EXCEL_FILE_PATH);
        
		Workbook wb = WorkbookFactory.create(fis);
		
		Sheet sh = wb.getSheet("DP");
		
		int lastRow = sh.getLastRowNum()+1;
		int lastCell = sh.getRow(0).getLastCellNum();
		
		
		Object[][] obj = new Object[lastRow][lastCell];
		
		for(int i=0;i<lastRow;i++)
		{
			for(int j=0;j<lastCell;j++) {
				
				obj[i][j]= sh.getRow(i).getCell(j).getStringCellValue();
			}
		}
		
		return obj;
	}
}
