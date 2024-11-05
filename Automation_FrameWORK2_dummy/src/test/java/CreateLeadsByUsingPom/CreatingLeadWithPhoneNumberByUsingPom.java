package CreateLeadsByUsingPom;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import Com.comcast.crm.ObjectrepositoryUtility.CreateLeads;
import Com.comcast.crm.ObjectrepositoryUtility.LoginPage;
import Com.comcast.crm.ObjectrepositoryUtility.VeryfyLead;
import Com.comcast.crm.genaric.WebDriverutility.JavaUtility;
import Com.comcast.crm.genaric.WebDriverutility.WebDriverUtility;
import Com.comcast.crm.genaric.fileutility.ExcelUtility;
import Com.comcast.crm.genaric.fileutility.FileUtility;

public class CreatingLeadWithPhoneNumberByUsingPom {
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
		String lastname = ex.getDataFromTheExcel("lead", 1, 4);
		String company = ex.getDataFromTheExcel("lead", 1, 5);
		String phn = ex.getDataFromTheExcel("lead", 1, 6);
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
		//creatae an object of create leads
		CreateLeads clp=new CreateLeads(driver);
		clp.clickOnLink();
		clp.createLead();
		clp.lastname(lastname);
		clp.company(company);
		clp.phnnumber(phn);
		clp.getSavebtn().click();
		
		// verify the last nametextfiled
		VeryfyLead vl=new VeryfyLead(driver);
		vl.veryfyLeadpage(lastname);
		
		
		driver.quit();

	}
}
