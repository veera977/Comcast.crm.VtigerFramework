package Com.comcast.crm.contacttest;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import Com.comcast.crm.genaric.WebDriverutility.JavaUtility;
import Com.comcast.crm.genaric.WebDriverutility.WebDriverUtility;
import Com.comcast.crm.genaric.fileutility.ExcelUtility;
import Com.comcast.crm.genaric.fileutility.FileUtility;

public class CreateContactWithSupportDate {
	public static void main(String[] args) throws IOException {
		// tead the data from property file
		//create an object of fileutility class
		FileUtility fu=new FileUtility();
		String BROWSER = fu.getDataFromPropertyFile("browser");
		String URL=fu.getDataFromPropertyFile("url");
		String USERNAME=fu.getDataFromPropertyFile("username");
		String PASSWORD=fu.getDataFromPropertyFile("password");
		//create an object of javautility
		JavaUtility ju=new JavaUtility() ;
			String sysdate = ju.getSystemDate();
			String actdate = ju.getendDtae(30);
			
			//create an object of webdriver utility
			WebDriverUtility wu=new WebDriverUtility();
		
			
		
		//Create object of Excelutility class
		ExcelUtility eu=new ExcelUtility();
		 String lastname=eu.getDataFromTheExcel("contactmodule", 1, 2)+ju.getRandomNum();
		
		
		
		

		WebDriver driver = null;
		if (BROWSER.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equals("edge")) {
			driver = new EdgeDriver();
		}
		if (BROWSER.equals("firefox")) {
			driver = new FirefoxDriver();
		} else if (BROWSER.equals("safari")) {
			driver = new SafariDriver();
		}
		wu.maximize(driver);
		wu.implicitWait(driver);
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		driver.findElement(By.name("lastname")).sendKeys(lastname);
		driver.findElement(By.xpath("//input[@name='support_start_date']")).clear();
		driver.findElement(By.xpath("//input[@name='support_start_date']")).sendKeys(sysdate);
		driver.findElement(By.xpath("//input[@name='support_end_date']")).clear();
		driver.findElement(By.xpath("//input[@name='support_end_date']")).sendKeys(actdate);
		driver.findElement(By.xpath("(//input[@name='button'])[1]")).click();
		String actorg = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if (actorg.contains(lastname)) {
			System.out.println("support start date added successfull");
			System.out.println("support end date added successfull");

		} else {
			System.out.println("support start date failed");
			System.out.println("support end date added failed");

		}
		driver.quit();

	}
}
