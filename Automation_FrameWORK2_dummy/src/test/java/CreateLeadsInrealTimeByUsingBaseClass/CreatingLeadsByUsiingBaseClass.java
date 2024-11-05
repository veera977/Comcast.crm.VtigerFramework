package CreateLeadsInrealTimeByUsingBaseClass;

import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.By;
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
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import Baseclass_InCrmRealeatCases.BaseclassForCrm;
import Com.comcast.crm.ObjectrepositoryUtility.CreateLeads;
import Com.comcast.crm.ObjectrepositoryUtility.LoginPage;
import Com.comcast.crm.ObjectrepositoryUtility.VeryfyLead;
import Com.comcast.crm.genaric.WebDriverutility.JavaUtility;
import Com.comcast.crm.genaric.WebDriverutility.UtilityClassObject;
import Com.comcast.crm.genaric.WebDriverutility.WebDriverUtility;
import Com.comcast.crm.genaric.fileutility.ExcelUtility;
import Com.comcast.crm.genaric.fileutility.FileUtility;

@Listeners(Com.comcast.listenerUtility.ListenerImplimentation.class)
public class CreatingLeadsByUsiingBaseClass extends BaseclassForCrm {

	// cerate an object of javautility
	JavaUtility ju = new JavaUtility();

	@Test(groups = { "smoketest" }, retryAnalyzer = Com.comcast.listenerUtility.RetryListener.class)
	public void CreateLeadTest() throws EncryptedDocumentException, IOException {
		// create an object of excelutility
		UtilityClassObject.getTest().log(Status.INFO, "read the data from the excel");
		ExcelUtility ex = new ExcelUtility();
		String lastname = ex.getDataFromTheExcel("lead", 1, 4);
		String company = ex.getDataFromTheExcel("lead", 1, 5);
		// creatae an object of create leads
		UtilityClassObject.getTest().log(Status.INFO, "navigate to leads page");
		CreateLeads clp = new CreateLeads(driver);
		clp.clickOnLink();
		clp.createLead();
		UtilityClassObject.getTest().log(Status.INFO, "navigate to create leads page");
		clp.createLeads(lastname, company);

		// verify the last nametextfiled
		UtilityClassObject.getTest().log(Status.INFO, "rleads added successfully");
		VeryfyLead vl = new VeryfyLead(driver);
		String res = vl.getLeadveryfy().getText();
		// softAssert
		SoftAssert assertref = new SoftAssert();
		assertref.assertEquals(res, lastname);
	}

	@Test(groups = { "regressiontest" }, retryAnalyzer = Com.comcast.listenerUtility.RetryListener.class)
	public void CreateLeadsWithPhoneNumber() throws EncryptedDocumentException, IOException {
		// create an object of excelutility
		UtilityClassObject.getTest().log(Status.INFO, "read the data from the excel");
		ExcelUtility ex = new ExcelUtility();
		String lastname = ex.getDataFromTheExcel("lead", 1, 4);
		String company = ex.getDataFromTheExcel("lead", 1, 5);
		String phn = ex.getDataFromTheExcel("lead", 1, 6) + ju.getRandomNum();
		// creatae an object of create leads
		UtilityClassObject.getTest().log(Status.INFO, "navigate to leads page");
		CreateLeads clp = new CreateLeads(driver);
		clp.clickOnLink();
		clp.createLead();
		UtilityClassObject.getTest().log(Status.INFO, "creates leads withphone number");
		clp.createLeads(lastname, company, phn);

		// verify the last nametextfiled
		VeryfyLead vl = new VeryfyLead(driver);
		UtilityClassObject.getTest().log(Status.INFO, "created leads with phone number");
		String res = vl.getLeadveryfy().getText();
		// softAssert
		SoftAssert assertref = new SoftAssert();
		assertref.assertEquals(res, lastname);
		assertref.assertAll();

	}

	@Test(groups = { "regressiontest" }, retryAnalyzer = Com.comcast.listenerUtility.RetryListener.class)

	public void CreateLeadWithAllDetails() throws EncryptedDocumentException, IOException {
		JavaUtility ju = new JavaUtility();
		// create an object of webdriver utility
		WebDriverUtility wu = new WebDriverUtility();
		// create an object of excelutility
		UtilityClassObject.getTest().log(Status.INFO, "read the data from the excel");
		ExcelUtility ex = new ExcelUtility();
		String lastname = ex.getDataFromTheExcel("lead", 1, 4);
		String company = ex.getDataFromTheExcel("lead", 1, 5);
		String phn = ex.getDataFromTheExcel("lead", 1, 6);
		String firstname = ex.getDataFromTheExcel("lead", 1, 3);
		String prefix = ex.getDataFromTheExcel("lead", 1, 2);
		UtilityClassObject.getTest().log(Status.INFO, " navigate to leads page");
		CreateLeads clp = new CreateLeads(driver);
		clp.clickOnLink();
		clp.createLead();
		wu.select(clp.getPrifix(), prefix);
		clp.createLeads(lastname, company, phn, firstname);

		// verify the last nametextfiled
		UtilityClassObject.getTest().log(Status.INFO, "created leads with all data");
		VeryfyLead vl = new VeryfyLead(driver);
		String res = vl.getLeadveryfy().getText();
		boolean act = res.contains(lastname);
		Assert.assertTrue(act);

	}

}
