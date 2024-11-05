package CreateContact_ByUsingPom;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import Com.comcast.crm.ObjectrepositoryUtility.CreateContactpage;
import Com.comcast.crm.ObjectrepositoryUtility.LoginPage;
import Com.comcast.crm.genaric.WebDriverutility.JavaUtility;
import Com.comcast.crm.genaric.WebDriverutility.WebDriverUtility;
import Com.comcast.crm.genaric.fileutility.ExcelUtility;
import Com.comcast.crm.genaric.fileutility.FileUtility;

public class CreateContactWithSupportDateByUsingPom {
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
		 String contact = eu.getDataFromTheExcel("contact", 1, 2)+ju.getRandomNum();
		
		
		

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
		
		ccp.enterStartdate(sysdate);
		ccp.enterEnddate(actdate);
		ccp.clickOnSaveButton();
		
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


