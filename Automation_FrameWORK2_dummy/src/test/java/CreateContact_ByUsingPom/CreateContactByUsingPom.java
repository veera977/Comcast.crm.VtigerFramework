package CreateContact_ByUsingPom;

import java.io.IOException;
import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import Com.comcast.crm.ObjectrepositoryUtility.CreateContactpage;
import Com.comcast.crm.ObjectrepositoryUtility.LoginPage;
import Com.comcast.crm.contacttest.Create_Contact;
import Com.comcast.crm.genaric.fileutility.ExcelUtility;
import Com.comcast.crm.genaric.fileutility.FileUtility;

public class CreateContactByUsingPom {
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
		driver.get(URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get(URL);
		LoginPage lp = new LoginPage(driver);
		lp.getUsernameEdt().sendKeys(USERNAME);
		lp.getPasswordEdt().sendKeys(PASSWORD);
		lp.getLoginbtn().click();
		//lp.loginToApp(USERNAME, PASSWORD);
		
		//create object of CreateContactpage
		CreateContactpage ccp=new CreateContactpage(driver);
		ccp.clickOncontactlink();
		ccp.clickOnCreatecontactlink();
		ccp.enterLastName(lastname);
		ccp.enterMobileNumber(contact);
		ccp.clickOnSaveButton();
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


