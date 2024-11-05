package HmsUtility;

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

public class ExcelUtility {
	
	
		public int getRowCount(String sheetName) throws EncryptedDocumentException, IOException {
			FileInputStream fis = new FileInputStream("./TestData/Test_Script_Data.xlsx");
			Workbook wb = WorkbookFactory.create(fis);
			Sheet sh = wb.getSheet(sheetName);
		int rowcount = sh.getLastRowNum();
		return rowcount;

	}
		public void setDataBackToEXcel(String sheetName, int rowNum, int CelNum,String data) throws EncryptedDocumentException, IOException {
			FileInputStream fis = new FileInputStream("./TestData/Test_Script_Data.xlsx");
			Workbook wb = WorkbookFactory.create(fis);
			Sheet sh = wb.getSheet(sheetName);
			Row row = sh.getRow(rowNum);
			 Cell ce = row.createCell(CelNum,CellType.STRING);
			 ce.setCellValue(data);
				 FileOutputStream	fos=new FileOutputStream("./TestData/Test_Script_Data.xlsx");
					wb.write(fos);
					wb.close();
					
			 }
	
		public String getDataFromTheExcel(String sheetname, int rownum, int cellnum) throws EncryptedDocumentException, IOException {
			FileInputStream fis = new FileInputStream("./TestData/Test_Script_Data.xlsx");
			
			Workbook wb = WorkbookFactory.create(fis);
			Sheet sh = wb.getSheet(sheetname);
			Row row = sh.getRow(rownum);
			String data = row.getCell(cellnum).toString();
			wb.close();

			return data;
			
		}
		
		}

