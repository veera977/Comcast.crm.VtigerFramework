package AssignmentForDemowebshopByUsingPom;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import Com.comcast.crm.genaric.WebDriverutility.WebDriverUtility;
import Com.comcast.crm.genaric.fileutility.ExcelUtility;
import Com.comcast.crm.genaric.fileutility.FileUtility;
import Com.comcast.crm.genaric.fileutility.FileUtility1;
import Com.comcat.demoWebshop.objectRepository.AddProduct;
import Com.comcat.demoWebshop.objectRepository.LoginPage;

public class Assignment_ByUsingPom {
public static void main(String[] args) throws IOException {
	//read the data from property file
	FileUtility1 fu=new FileUtility1();
	String BROWSER = fu.getDataFromPropertyfile("browser");
	String URL = fu.getDataFromPropertyfile("url");
	String EMAIL = fu.getDataFromPropertyfile("email");
	String PASSWORD = fu.getDataFromPropertyfile("password");
	//create an object of excelutility
	ExcelUtility eu=new ExcelUtility();
	//int rowcount = eu.getRowCount("Demowebshop");
	String product = eu.getDataFromTheExcel("Demowebshop", 1, 0).toString();
	String quantity = eu.getDataFromTheExcel("Demowebshop", 1, 1);
	WebDriver driver=new ChromeDriver();
	WebDriverUtility wu=new WebDriverUtility();
	wu.maximize(driver);
	wu.implicitWait(driver);
	driver.get(URL);
	//create an object of loginpage
	LoginPage lp=new LoginPage(driver);
	lp.logintoapp();
	lp.enterEmail(EMAIL);
	lp.enterpassword(PASSWORD);
	lp.clickonLogin();
	//create an object of Addproduct
	AddProduct ad=new AddProduct(driver);
	ad.searchproduct(product);
	ad.ClickOnproduct();
	ad.enterQuantity(quantity);
	ad.clickonAddtoCart();
	ad.Verifypage();
	driver.quit();
	
	
	
	
	
	
}
}
