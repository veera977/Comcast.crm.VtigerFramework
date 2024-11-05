package DemoWebshopByusingbaseclass;

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

import Com.comcast.crm.genaric.WebDriverutility.WebDriverUtility;
import Com.comcast.crm.genaric.databaseutility.DatabaseUtility;
import Com.comcast.crm.genaric.fileutility.FileUtility1;
import Com.comcat.demoWebshop.objectRepository.LoginPage;

public class BaseclassDemo {
	public DatabaseUtility du=new DatabaseUtility();
public FileUtility1 fu=new FileUtility1();
public WebDriverUtility wu=new WebDriverUtility();
public WebDriver driver=null;
public  static WebDriver sdriver=null;
@BeforeSuite
public void configBS() {
	du.getConnection();
	System.out.println("connection is done");
}
@BeforeClass
public void configBC(@Optional("chrome")String browser) throws IOException {
	String BROWSER=browser;
	//String BROWSER = fu.getDataFromPropertyfile("browser");
	String URL = fu.getDataFromPropertyfile("url");
	if (BROWSER.equals("chrome")) {
		driver = new ChromeDriver();
	} else if (BROWSER.equals("edge")) {
		driver = new EdgeDriver();
	} else if (BROWSER.equals("firefox")) {
		driver = new FirefoxDriver();
	} else if (BROWSER.equals("safari")) {
		driver = new SafariDriver();
	} 
	sdriver=driver;
	wu.maximize(driver);
	wu.implicitWait(driver);
	driver.get(URL);
}
@BeforeMethod
public void configBM() throws IOException {
	String EMAIL = fu.getDataFromPropertyfile("email");
	String PASSWORD = fu.getDataFromPropertyfile("password");
	LoginPage lp=new LoginPage(driver);
	lp.logintoapp();
	//lp.clickonLogin();
	lp.enterEmail(EMAIL);
	lp.enterpassword(PASSWORD);
	lp.getClicklogin();
	
}
@AfterMethod
public void configAM() {
	System.out.println("logout");
}
@AfterClass
public void configAC() {
	driver.quit();
	
}
@AfterSuite
public void configAS() {
	du.closeConnectin();
	
}
}
