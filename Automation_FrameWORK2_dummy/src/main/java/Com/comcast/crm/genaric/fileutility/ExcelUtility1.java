package Com.comcast.crm.genaric.fileutility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility1 {
public String getDatafromexcel(String sheetName,int rowNum,int cellNum) throws EncryptedDocumentException, IOException {
	FileInputStream fis=new FileInputStream("./TestData/Test_Script_Data.xlsx");
	Workbook wb = WorkbookFactory.create(fis);
	Sheet sh = wb.getSheet(sheetName);
	Row row = sh.getRow(rowNum);
	String data = row.getCell(cellNum).toString();
	
	return data;
}
public void backToExcel(String sheetName,int rowNum,int cellNum,String data) throws IOException {
	FileInputStream fis=new FileInputStream("./TestData/Test_Script_Data.xlsx");
	Workbook wb = WorkbookFactory.create(fis);
	Sheet sh = wb.getSheet(sheetName);
	Row row = sh.getRow(rowNum);
	Cell ce = row.createCell(cellNum, CellType.STRING);
	ce.setCellValue(data);
	FileOutputStream fos=new FileOutputStream("./TestData/Test_Script_Data.xlsx");
	wb.write(fos);
	wb.close();
	
	
}
 
	
}

