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
import Com.comcast.crm.ObjectrepositoryUtility.CreatingNewOrganizationPage;
import Com.comcast.crm.ObjectrepositoryUtility.HomePage;
import Com.comcast.crm.ObjectrepositoryUtility.LoginPage;
import Com.comcast.crm.ObjectrepositoryUtility.OrganaizationPage;
import Com.comcast.crm.genaric.WebDriverutility.JavaUtility;
import Com.comcast.crm.genaric.WebDriverutility.WebDriverUtility;
import Com.comcast.crm.genaric.fileutility.ExcelUtility;
import Com.comcast.crm.genaric.fileutility.FileUtility;

public class CreateContactWithOrganizationIntegrationType {
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

		// read the data from the excell file
		// create an object of excelutility
		ExcelUtility eu = new ExcelUtility();
		String lastname = eu.getDataFromTheExcel("contactmodule", 1, 2) + ju.getRandomNum();
		String orgname = eu.getDataFromTheExcel("contactmodule", 1, 3) + ju.getRandomNum();
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
		/*
		 * lp.getUsernameEdt().sendKeys(USERNAME);
		 * lp.getPasswordEdt().sendKeys(PASSWORD); lp.getLoginbtn().click();
		 */
		lp.loginToApp(USERNAME, PASSWORD);
		HomePage hp = new HomePage(driver);
		hp.clickOnOrgLink();
		OrganaizationPage op = new OrganaizationPage(driver);
		op.clickOncreateOrg();
		CreatingNewOrganizationPage cp = new CreatingNewOrganizationPage(driver);
		// cp.enterOrgName(orgname);
		cp.getOrgname().sendKeys(orgname);
		cp.getSavebtn().click();
		String actual = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		// check heder field
		if (actual.contains(orgname)) {
			System.out.println("organization created succefully");
		} else {
			System.out.println("not created");
		}
		// cheach text field
		String actual1 = driver.findElement(By.id("mouseArea_Organization Name")).getText();
		if (actual1.contains(orgname)) {
			System.out.println("organization created succefully done");
		} else {
			System.out.println(" createdfail");
		}
		// move to contact module
		CreateContactpage ccp = new CreateContactpage(driver);
		ccp.clickOncontactlink();
		ccp.clickOnCreatecontactlink();
		ccp.enterLastName(lastname);
		driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img")).click();
		wu.getWindow(driver, "Accounts&action");
		ccp.searchfeild(orgname);
		ccp.getClicksearch();
		driver.findElement(By.linkText(orgname)).click();
		wu.getWindow(driver, "Contacts&action");
		driver.findElement(By.xpath("(//input[@name='button'])[1]")).click();
		String verify = driver.findElement(By.id("dtlview_Last Name")).getText();
		System.out.println(verify);
		if (verify.trim().equals(lastname)) {
			System.out.println("contact orgname created successfully");
			eu.setDataBackToEXcel("contactmodule", 1, 5, "succsess");
		}

		else {
			System.out.println("contact orgname created failed");
			eu.setDataBackToEXcel("contactmodule", 1, 5, "faild");
		}
		driver.quit();

	}

}
