package CreateProductByUsingBaseClass;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import Baseclass_InCrmRealeatCases.BaseclassForCrm;
import Com.comcast.crm.ObjectrepositoryUtility.CreatingProductPage;
import Com.comcast.crm.ObjectrepositoryUtility.LoginPage;
import Com.comcast.crm.ObjectrepositoryUtility.VeryfyProductPage;
import Com.comcast.crm.genaric.WebDriverutility.JavaUtility;
import Com.comcast.crm.genaric.WebDriverutility.UtilityClassObject;
import Com.comcast.crm.genaric.WebDriverutility.WebDriverUtility;
import Com.comcast.crm.genaric.fileutility.ExcelUtility;
import Com.comcast.crm.genaric.fileutility.FileUtility;
/*@Listeners(Com.comcast.listenerUtility.ListenerImplimentation.class)*/
public class CreatingProductByUsingBaseClass extends BaseclassForCrm {

	

	
	@Test(groups = { "smoketest" },retryAnalyzer = Com.comcast.listenerUtility.RetryListener.class)
	public void CreateProductTest() throws EncryptedDocumentException, IOException {
		// cerate an object of javautility
		JavaUtility ju = new JavaUtility();
		// create an object of webdriver utility
		WebDriverUtility wu = new WebDriverUtility();
		// create an object of excelutility
		UtilityClassObject.getTest().log(Status.INFO, "read the data from the excel");
		ExcelUtility ex = new ExcelUtility();
		String productname = ex.getDataFromTheExcel("product", 1, 2);
		UtilityClassObject.getTest().log(Status.INFO, "navigate to product link");
		CreatingProductPage cpp = new CreatingProductPage(driver);
		cpp.clickonlink();
		cpp.createpro();
		UtilityClassObject.getTest().log(Status.INFO, "create product");
		cpp.productname(productname);
		VeryfyProductPage vfp = new VeryfyProductPage(driver);
		//vfp.veryfingpro(productname);
		UtilityClassObject.getTest().log(Status.INFO, "create product successfully");
		String res = vfp.getVeryfyproduct().getText();
		boolean act = res.contains(productname);
		Assert.assertTrue(act);
		
		
		
	}

	@Test(groups = { "regressiontest" },retryAnalyzer = Com.comcast.listenerUtility.RetryListener.class)
	public void CreateProductWithStartAndEndDateTset() throws EncryptedDocumentException, IOException {

		JavaUtility ju = new JavaUtility();
		// create an object of webdriver utility
		WebDriverUtility wu = new WebDriverUtility();
		// create an object of excelutility
		UtilityClassObject.getTest().log(Status.INFO, "read the data from the excel");
		ExcelUtility ex = new ExcelUtility();
		String productname = ex.getDataFromTheExcel("product", 1, 2) + ju.getRandomNum();
		String partnum = ex.getDataFromTheExcel("product", 1, 3) + ju.getRandomNum();
		String startdate = ju.getSystemDate();
		String enddate = ju.getendDtae(30);
		UtilityClassObject.getTest().log(Status.INFO, "create product with  start date and end date ");
		CreatingProductPage cpp = new CreatingProductPage(driver);
		cpp.clickonlink();
		cpp.createpro();
		cpp.productname(productname, partnum);
		UtilityClassObject.getTest().log(Status.INFO, "added successfully");
		VeryfyProductPage vfp = new VeryfyProductPage(driver);
		//vfp.veryfingpro(productname);
		String res = vfp.getVeryfyproduct().getText();
		boolean act = res.contains(productname);
		Assert.assertTrue(act);
		

	}

	@Test(groups = { "regressiontest" },retryAnalyzer = Com.comcast.listenerUtility.RetryListener.class)
	public void CreateProductWithPortNumberTest() throws EncryptedDocumentException, IOException {

		// use random class
		// cerate an object of javautility
		JavaUtility ju = new JavaUtility();
		// create an object of webdriver utility
		WebDriverUtility wu = new WebDriverUtility();
		// create an object of excelutility
		UtilityClassObject.getTest().log(Status.INFO, "read the data from the excel");
		ExcelUtility ex = new ExcelUtility();
		String productname = ex.getDataFromTheExcel("product", 1, 2) + ju.getRandomNum();
		String partnum = ex.getDataFromTheExcel("product", 1, 3) + ju.getRandomNum();
		UtilityClassObject.getTest().log(Status.INFO, "add the product with part number");
		CreatingProductPage cpp = new CreatingProductPage(driver);
		cpp.clickonlink();
		cpp.createpro();
		cpp.productname(productname, partnum);
		VeryfyProductPage vfp = new VeryfyProductPage(driver);
		//vfp.veryfingpro(productname);
		String res = vfp.getVeryfyproduct().getText();
		boolean act = res.contains(productname);
		Assert.assertTrue(act);
		
	}

}
