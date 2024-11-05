package PracticeRealTime.TestNG;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Com.comcast.crm.genaric.fileutility.ExcelUtility;

public class GetPriceOfTheProductTest {
@Test (dataProvider = "getdata")
public void getprice(String brandname,String productname) {
	WebDriver driver=new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	driver.get("https://www.amazon.in");
	driver.findElement(By.id("twotabsearchtextbox")).sendKeys(brandname,Keys.ENTER);
	//capture product info
	String price = driver.findElement(By.xpath("//span[text()='"+productname+"']/../../../../descendant::span[text()='₹']/following-sibling::span")).getText();
	System.out.println(price);
	driver.quit();
	
}
@DataProvider
public Object[][]getdata() throws EncryptedDocumentException, IOException{
	
	 ExcelUtility eu=new ExcelUtility();
	 int rowcount = eu.getRowCount("Amazon");
	 Object[][]objarray=new  Object[rowcount][2];
	 for(int i=0;i<rowcount;i++) {
		 
		         objarray[i][0]=eu.getDataFromTheExcel("Amazon", i+1, 0);
			     objarray[i][1]=eu.getDataFromTheExcel("Amazon", i+1, 1);
			     
		 
	 
	 
	 
	 
	 
	
	//return objarray;
	 
	
	
}
	return objarray;






}
}
