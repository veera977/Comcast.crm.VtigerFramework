package Com.comcast.crm.contacttest;

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
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import Com.comcast.crm.genaric.fileutility.ExcelUtility;
import Com.comcast.crm.genaric.fileutility.FileUtility;

public class Create_Contact {
	public static void main(String[] args) throws IOException {
		// tead the data from property file
		//creare an object of fileutility 
		FileUtility fu=new FileUtility();
		String BROWSER = fu.getDataFromPropertyFile("browser");
		String URL = fu.getDataFromPropertyFile("url");
		String USERNAME = fu.getDataFromPropertyFile("username");
		String PASSWORD = fu.getDataFromPropertyFile("password");
		// use random class
		Random ran = new Random();
		int rancount = ran.nextInt(100);
		// read the data from the excell file
		//create an object of excelutility
		ExcelUtility eu=new ExcelUtility();
		String contact = eu.getDataFromTheExcel("contact", 1, 2)+rancount;
		String lastname = eu.getDataFromTheExcel("contact", 1, 3)+rancount;
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
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		driver.findElement(By.name("lastname")).sendKeys(lastname);
		driver.findElement(By.id("mobile")).sendKeys(contact);
		driver.findElement(By.xpath("(//input[@name='button'])[1]")).click();
		// verify header
		String res1 = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if (res1.contains(lastname)) {
			System.out.println("geader value created successfully");
		} else {
			System.out.println("not created successfully");
		}
		// veryfy last name textfield
		String res2 = driver.findElement(By.id("mouseArea_Last Name")).getText();
		if (res2.contains(lastname)) {
			System.out.println("lastname created successfully");
		} else {
			System.out.println("last name not created successfully");
		}
		String res3 = driver.findElement(By.id("mouseArea_Mobile")).getText();
		if (res2.contains(lastname)) {
			System.out.println("contact created successfully");
		} else {
			System.out.println("contact name not created successfully");
		}
		//wb.close();
		driver.quit();

	}
}
