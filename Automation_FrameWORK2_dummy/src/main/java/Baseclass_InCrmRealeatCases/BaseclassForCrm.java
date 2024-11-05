package Baseclass_InCrmRealeatCases;

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

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import Com.comcast.crm.ObjectrepositoryUtility.HomePage;
import Com.comcast.crm.ObjectrepositoryUtility.LoginPage;
import Com.comcast.crm.genaric.databaseutility.DatabaseUtility;
import Com.comcast.crm.genaric.fileutility.FileUtility;
import Com.comcast.crm.genaric.WebDriverutility.UtilityClassObject;
import Com.comcast.crm.genaric.WebDriverutility.WebDriverUtility;

public class BaseclassForCrm {

	// create an object of database auatility
	public WebDriver driver = null;
	public FileUtility fu = new FileUtility();
	public DatabaseUtility db = new DatabaseUtility();
	public WebDriverUtility wu = new WebDriverUtility();
	public static WebDriver sdriver = null;
	
	@BeforeSuite(groups= {"smoketest","regressiontest"})
	public void configBs() {
		System.out.println("====connect database====,====reportcofiguration");
		db.getConnection();
		
	}
	
	@Parameters("BROWSER")
	@BeforeClass(groups= {"smoketest","regressiontest"})
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
		UtilityClassObject.setDriver(driver);
	}

	@BeforeMethod(groups= {"smoketest","regressiontest"})
	public void configBm() throws IOException {
		wu.maximize(driver);
		wu.implicitWait(driver);

		String URL = fu.getDataFromPropertyFile("url");
		driver.get(URL);
		System.out.println("=====login====");
		String USERNAME = fu.getDataFromPropertyFile("username");
		String PASSWORD = fu.getDataFromPropertyFile("password");
		LoginPage lp = new LoginPage(driver);
		lp.getUsernameEdt().sendKeys(USERNAME);
		lp.getPasswordEdt().sendKeys(PASSWORD);
		lp.getLoginbtn().click();

	}

	@AfterMethod(groups= {"smoketest","regressiontest"})
	public void configAm() {
		HomePage hp=new HomePage(driver);
		hp.signOut(driver);
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
		//report.flush();
		db.closeConnectin();
		

	}

}
