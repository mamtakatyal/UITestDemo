package BusyQA.ExcelConnect;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

	String filepath;
	String fullpath;
	XSSFWorkbook workbook;
	XSSFSheet sheet;
	XSSFRow row;
	FileInputStream fis=null;
	FileOutputStream fos=null;
	int rowcount=0;
	int colcount=0;
	ArrayList<String> loginvalues=new ArrayList<String>();
	
	
	public ArrayList<String> getData(String filepath,String excelname, String sheetname,int rownum) throws IOException {
		//this.filepath=filepath;
		fullpath=filepath+excelname;
		
		fis=new FileInputStream(fullpath);
		workbook=new XSSFWorkbook(fis);
		sheet=workbook.getSheet(sheetname);
		
		rowcount=sheet.getLastRowNum(); //till which row number is there data
		colcount=sheet.getRow(0).getLastCellNum(); //till which col number is there data
		
		System.out.println(rowcount + " " +colcount );
		
		row=sheet.getRow(rownum);
		for (int i=0;i<colcount-1;i++) {
			String var=row.getCell(i).getStringCellValue();
			loginvalues.add(var);
		}
		workbook.close();
		fis.close();
		return loginvalues;
	}
	
	public void updateData(String filepath,String excelname, String sheetname,int rownum, String result) 
							throws IOException {
		//this.filepath=filepath;
		
		fullpath=filepath+excelname;
		fis=new FileInputStream(fullpath);
		workbook=new XSSFWorkbook(fis);
		sheet=workbook.getSheet(sheetname);
		colcount=sheet.getRow(0).getLastCellNum();
		row=sheet.getRow(rownum);
		row.createCell(colcount-1).setCellValue(result);
		fos=new FileOutputStream(fullpath);
		workbook.write(fos);
		workbook.close();
		fis.close();
		fos.close();
	}
}
