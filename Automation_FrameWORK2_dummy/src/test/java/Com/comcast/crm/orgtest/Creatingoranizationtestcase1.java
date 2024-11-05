package Com.comcast.crm.orgtest;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import Com.comcast.crm.genaric.fileutility.ExcelUtility;
import Com.comcast.crm.genaric.fileutility.FileUtility;
import Com.comcast.crm.genaric.fileutility.Jsonutility;

public class Creatingoranizationtestcase1 {
	
	
	public static void main(String[] args) throws IOException {
		//create an object of fileutility
		FileUtility fu=new FileUtility();
		String BROWSER = fu.getDataFromPropertyFile("browser");
		String URL = fu.getDataFromPropertyFile("url");
		String USERNAME = fu.getDataFromPropertyFile("username");
		String PASSWORD = fu.getDataFromPropertyFile("password");
		// use random class
		Random ran = new Random();
		int rancount = ran.nextInt(1000);
		// read the data from the excell file
		ExcelUtility eu=new ExcelUtility();
		String orgname= eu.getDataFromTheExcel("ORG",1,2)+rancount;
		
		
			
			
		
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
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		driver.findElement(By.name("accountname")).sendKeys(orgname);
		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
		String actual = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		// check heder field
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


	}

}
