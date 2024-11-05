
package Com.comcast.crm.contacttest;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
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

public class CreateContactWithIntegrationSenario {
	public static void main(String[] args) throws IOException {
		// tead the data from property file
		//creare an object of fileutility 
				FileUtility fu=new FileUtility();
				String BROWSER = fu.getDataFromPropertyFile("browser");
				String URL = fu.getDataFromPropertyFile("url");
				String USERNAME = fu.getDataFromPropertyFile("username");
				String PASSWORD = fu.getDataFromPropertyFile("password");
		// use random class
				//cerate an object of javautility
				JavaUtility ju=new JavaUtility();
				//create an object of webdriver utility
				WebDriverUtility wu=new WebDriverUtility();
				
				
				
		
		// read the data from the excell file
		//create an object of excelutility
				ExcelUtility eu=new ExcelUtility();
				String lastname = eu.getDataFromTheExcel("contactmodule", 1, 2)+ju.getRandomNum();
				String orgname = eu.getDataFromTheExcel("contactmodule", 1, 3)+ju.getRandomNum();
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
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		driver.findElement(By.name("accountname")).sendKeys(orgname);
		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
		String actual = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		 //check heder field
		if (actual.contains(orgname)) {
			System.out.println("organization created succefully");
		} else {
			System.out.println("not created");
		}
//cheach text field
		String actual1 = driver.findElement(By.id("mouseArea_Organization Name")).getText();
		if (actual1.contains(orgname)) {
			System.out.println("organization created succefully done");
		} else {
			System.out.println(" createdfail");
		}
		//move to contact module
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		driver.findElement(By.name("lastname")).sendKeys(lastname);
		driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img")).click();
		//swtch to parent window
		//String parent = driver.getWindowHandle();
		//switch to child window
		wu.getWindow(driver,"Accounts&action");
			

	driver.findElement(By.id("search_txt")).sendKeys(orgname);
	driver.findElement(By.xpath("//input[@name='search']")).click();
	driver.findElement(By.linkText(orgname)).click();
	//switch back to parent
	//driver.switchTo().window(parent);
	wu.getWindow(driver, "Contacts&action");
	driver.findElement(By.xpath("(//input[@name='button'])[1]")).click();
	String verify = driver.findElement(By.id("dtlview_Last Name")).getText();
	System.out.println(verify);
		if(verify.trim().equals(lastname
				)) {
			System.out.println("contact orgname created successfully");
			eu.setDataBackToEXcel("contactmodule", 1, 5, "succsess");
		}
		
		else
		{
			System.out.println("contact orgname created failed");
			eu.setDataBackToEXcel("contactmodule", 1, 5, "faild");
		}
		driver.quit();
			
			
			
		}
		
		
}

