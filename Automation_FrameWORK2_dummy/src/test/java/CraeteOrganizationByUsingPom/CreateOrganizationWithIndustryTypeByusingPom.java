package CraeteOrganizationByUsingPom;

import java.io.IOException;
import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import Com.comcast.crm.ObjectrepositoryUtility.CreatingNewOrganizationPage;
import Com.comcast.crm.ObjectrepositoryUtility.HomePage;
import Com.comcast.crm.ObjectrepositoryUtility.LoginPage;
import Com.comcast.crm.ObjectrepositoryUtility.OrganaizationPage;
import Com.comcast.crm.genaric.WebDriverutility.JavaUtility;
import Com.comcast.crm.genaric.WebDriverutility.WebDriverUtility;
import Com.comcast.crm.genaric.fileutility.ExcelUtility;
import Com.comcast.crm.genaric.fileutility.FileUtility;

public class CreateOrganizationWithIndustryTypeByusingPom {
	public static void main(String[] args) throws IOException, InterruptedException {
		//create an object of fileutility
		FileUtility fu=new FileUtility();
		String BROWSER = fu.getDataFromPropertyFile("browser");
		String URL = fu.getDataFromPropertyFile("url");
		String USERNAME = fu.getDataFromPropertyFile("username");
		String PASSWORD = fu.getDataFromPropertyFile("password");
		// use random class
		//cerate an object of javautility
		JavaUtility ju=new JavaUtility();
		//create an object of webdriver utility
		WebDriverUtility wu=new WebDriverUtility();
		
		
		

// read the data from the excell file
//create an object of excelutility
		ExcelUtility eu=new ExcelUtility();
		String lastname = eu.getDataFromTheExcel("contactmodule", 1, 2)+ju.getRandomNum();
		String orgname = eu.getDataFromTheExcel("contactmodule", 1, 3)+ju.getRandomNum();

		
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
		LoginPage lp = new LoginPage(driver);
		/*lp.getUsernameEdt().sendKeys(USERNAME);
		lp.getPasswordEdt().sendKeys(PASSWORD);
		lp.getLoginbtn().click();*/
		lp.loginToApp(USERNAME, PASSWORD);
		HomePage hp=new HomePage(driver);
		hp.clickOnOrgLink();
		OrganaizationPage op=new OrganaizationPage(driver);
		op.clickOncreateOrg();
		CreatingNewOrganizationPage cp=new CreatingNewOrganizationPage(driver);
		//cp.enterOrgName(orgname);
		cp.getOrgname().sendKeys(orgname);
		//cp.getSavebtn().click();
		//CreatingNewOrganizationPage cnp =new CreatingNewOrganizationPage(driver);
		
		
		
		cp.getSavebtn().click();
		String actdata = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(actdata.contains(orgname)) {
			System.out.println("orgname created successfulyy");
		}
		else {
			System.out.println("orgname not created ");
		}
		
		

		hp.getAdminbtn().click();
		hp.getSignout().click();
		driver.quit();
		
		
	}
	}



