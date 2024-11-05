package CraeteProductByUsingPom;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import Com.comcast.crm.ObjectrepositoryUtility.CreatingProductPage;
import Com.comcast.crm.ObjectrepositoryUtility.LoginPage;
import Com.comcast.crm.ObjectrepositoryUtility.VeryfyProductPage;
import Com.comcast.crm.genaric.WebDriverutility.JavaUtility;
import Com.comcast.crm.genaric.WebDriverutility.WebDriverUtility;
import Com.comcast.crm.genaric.fileutility.ExcelUtility;
import Com.comcast.crm.genaric.fileutility.FileUtility;

public class CreatingProductByUsingPom {
	public static void main(String[] args) throws IOException, InterruptedException {
		// public static void main(String[] args) throws IOException {
		// tead the data from property file
		// creare an object of fileutility
		FileUtility fu = new FileUtility();
		String BROWSER = fu.getDataFromPropertyFile("browser");
		String URL = fu.getDataFromPropertyFile("url");
		String USERNAME = fu.getDataFromPropertyFile("username");
		String PASSWORD = fu.getDataFromPropertyFile("password");
		// use random class
		// cerate an object of javautility
		JavaUtility ju = new JavaUtility();
		// create an object of webdriver utility
		WebDriverUtility wu = new WebDriverUtility();
		//create an object of excelutility
		ExcelUtility ex=new ExcelUtility();
		String productname = ex.getDataFromTheExcel("product", 1, 2);
		
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
		
		LoginPage lp = new LoginPage(driver);
		lp.getUsernameEdt().sendKeys(USERNAME);
		lp.getPasswordEdt().sendKeys(PASSWORD);
		lp.getLoginbtn().click();
		CreatingProductPage cpp=new CreatingProductPage(driver);
		cpp.clickonlink();
		cpp.createpro();
		cpp.productname(productname);
		cpp.savebtnn();
		VeryfyProductPage vfp=new VeryfyProductPage(driver);
		vfp.veryfingpro(productname);
		
driver.quit();
}
}
