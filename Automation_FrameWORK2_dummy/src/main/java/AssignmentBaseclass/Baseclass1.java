package AssignmentBaseclass;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import Com.comcast.crm.ObjectrepositoryUtility.HomePage;
import Com.comcast.crm.ObjectrepositoryUtility.LoginPage;
import Com.comcast.crm.genaric.WebDriverutility.WebDriverUtility;
import Com.comcast.crm.genaric.databaseutility.DatabaseUtility;
import Com.comcast.crm.genaric.fileutility.FileUtility;
import HmsUtility.ExcelUtility;
import HmsUtility.Fileutility;
import ObjectRepository_Hrm.LoginToApplication;

public class Baseclass1 {
	public WebDriver driver=null;
	public Fileutility fu=new Fileutility();
	public ExcelUtility eu=new ExcelUtility();
	public DatabaseUtility du=new DatabaseUtility();
	public	WebDriverUtility wu=new WebDriverUtility();
	
	public static WebDriver sdriver = null;
		
		
		@BeforeSuite(groups= {"smoketest",})
		public void configBs() {
			System.out.println("====connect database====,====reportcofiguration");
			du.getConnection();

		}
		
		@Parameters("BROWSER")
		@BeforeClass(groups= {"smoketest"})
		public void configBc(@Optional("chrome") String browser) throws IOException {
			String BROWSER=browser;
			System.out.println("====launch the browser=====");
			

			if (BROWSER.equalsIgnoreCase("chrome")) {
				driver = new ChromeDriver();
			} else if (BROWSER.equalsIgnoreCase("edge")) {
				driver = new EdgeDriver();
			} else if (BROWSER.equalsIgnoreCase("firefox")) {
				driver = new FirefoxDriver();
			} else if (BROWSER.equalsIgnoreCase("safari")) {
				driver = new SafariDriver();
			}
			sdriver=driver;
			String URL = fu.getDatafromPropertiyfile("url");
			
			wu.maximize(driver);
			driver.get(URL);
			wu.implicitWait(driver);
		}

		@BeforeMethod(groups= {"smoketest","regressiontest"})
		public void configBm() throws IOException {
			LoginToApplication lap=new LoginToApplication(driver);
			//String URL = fu.getDatafromPropertiyfile("url");
			String EMAIL = fu.getDatafromPropertiyfile("email");
			String PASSWORD = fu.getDatafromPropertiyfile("password");
			//driver.get(URL);
			lap.enteremail(EMAIL, PASSWORD);
			

		}

		@AfterMethod(groups= {"smoketest","regressiontest"})
		public void configAm() {
			
			System.out.println("====logout======");
			
		}

		@AfterClass(groups= {"smoketest","regressiontest"})
		public void configAc() {
			System.out.println("====close the browser====");
			driver.quit();
		}

		@AfterSuite(groups= {"smoketest","regressiontest"})
		public void configAs() {
			System.out.println("===close the database====,===reports backup=====");

			
		}

	}


