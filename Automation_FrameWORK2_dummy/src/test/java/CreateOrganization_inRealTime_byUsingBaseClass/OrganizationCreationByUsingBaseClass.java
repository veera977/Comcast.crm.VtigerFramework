package CreateOrganization_inRealTime_byUsingBaseClass;

import java.io.IOException;
import java.time.Duration;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.PageFactory;
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
import Com.comcast.crm.ObjectrepositoryUtility.CreatingNewOrganizationPage;
import Com.comcast.crm.ObjectrepositoryUtility.HomePage;
import Com.comcast.crm.ObjectrepositoryUtility.LoginPage;
import Com.comcast.crm.ObjectrepositoryUtility.OrgVerifyPage;
import Com.comcast.crm.ObjectrepositoryUtility.OrganaizationPage;

import Com.comcast.crm.genaric.WebDriverutility.JavaUtility;
import Com.comcast.crm.genaric.WebDriverutility.UtilityClassObject;
import Com.comcast.crm.genaric.fileutility.ExcelUtility;
import Com.comcast.crm.genaric.fileutility.FileUtility;
import Com.comcast.listenerUtility.ListenerImplimentation;
import Com.crm.comcast.Contacts.baseclass.BaseClass;

//@Listeners(Com.comcast.listenerUtility.ListenerImplimentation.class)
@Listeners(Com.comcast.listenerUtility. ListenerImplimentation.class)
public class OrganizationCreationByUsingBaseClass extends BaseclassForCrm {

	JavaUtility ju = new JavaUtility();

	@Test(groups = { "smoketest" }, retryAnalyzer = Com.comcast.listenerUtility.RetryListener.class)
	public void CreateOrgTest() throws EncryptedDocumentException, IOException {
		UtilityClassObject.getTest().log(Status.INFO, "read the data from the excel");
		// read the data from the excell file
		ExcelUtility eu = new ExcelUtility();
		String orgname = eu.getDataFromTheExcel("ORG", 1, 2) + ju.getRandomNum();

		// WebDriver driver = null;
		UtilityClassObject.getTest().log(Status.INFO, "navigate to orgpage");
		HomePage hp = new HomePage(driver);
		hp.clickOnOrgLink();
		OrganaizationPage op = new OrganaizationPage(driver);
		op.clickOncreateOrg();
		UtilityClassObject.getTest().log(Status.INFO, "navigate to create orgpage");
		CreatingNewOrganizationPage cp = new CreatingNewOrganizationPage(driver);
		// cp.enterOrgName(orgname);
		UtilityClassObject.getTest().log(Status.INFO, "create org");
		cp.Createorg(orgname);
		UtilityClassObject.getTest().log(Status.INFO, orgname+"=====>created");
		OrgVerifyPage ovp = new OrgVerifyPage(driver);
		String res = ovp.getOrgverify().getText();
		boolean act = res.contains(orgname);
		String phn = ovp.getPhnverify().getText();
		Assert.assertTrue(act);
	}

	@Test(groups = { "regressiontest" }, retryAnalyzer = Com.comcast.listenerUtility.RetryListener.class)

	public void CreateOrgWithPhoneNumberTest() throws EncryptedDocumentException, IOException {
		UtilityClassObject.getTest().log(Status.INFO, "read the data from the excel file");
		ExcelUtility eu = new ExcelUtility();
		String orgname = eu.getDataFromTheExcel("ORG", 1, 2) + ju.getRandomNum();
		String PHONENUMBER = eu.getDataFromTheExcel("ORG", 7, 3) + ju.getRandomNum();
		UtilityClassObject.getTest().log(Status.INFO, "navigate to org page");
		HomePage hp = new HomePage(driver);
		hp.clickOnOrgLink();
		UtilityClassObject.getTest().log(Status.INFO, "navigate to createorg page");
		OrganaizationPage op = new OrganaizationPage(driver);
		op.clickOncreateOrg();
		UtilityClassObject.getTest().log(Status.INFO, "create  orgwith phone number page");
		CreatingNewOrganizationPage cp = new CreatingNewOrganizationPage(driver);
		cp.Createorg(orgname, PHONENUMBER);
		OrgVerifyPage op1 = new OrgVerifyPage(driver);
		String res = op1.getOrgverify().getText();
		UtilityClassObject.getTest().log(Status.INFO, "orgnamewith phn number created successfully");
		boolean act = res.contains(orgname);
		String phn = op1.getPhnverify().getText();
		Assert.assertTrue(act);
		Assert.assertEquals(phn, PHONENUMBER);

	}

	@Test(groups = { "regressiontest" }, retryAnalyzer = Com.comcast.listenerUtility.RetryListener.class)
	public void CreateOrgWithIndustryTypeTest() throws EncryptedDocumentException, IOException {
		UtilityClassObject.getTest().log(Status.INFO, "read the data from the excel");
		ExcelUtility eu = new ExcelUtility();
		String orgname = eu.getDataFromTheExcel("ORG", 1, 2) + ju.getRandomNum();
		String INDUSTRY = eu.getDataFromTheExcel("ORG", 4, 3);
		String type = eu.getDataFromTheExcel("ORG", 4, 4);
		UtilityClassObject.getTest().log(Status.INFO, "navigate to org page");
		HomePage hp = new HomePage(driver);
		hp.clickOnOrgLink();
		UtilityClassObject.getTest().log(Status.INFO, "navigate to createorg page");
		OrganaizationPage op = new OrganaizationPage(driver);
		op.clickOncreateOrg();
		UtilityClassObject.getTest().log(Status.INFO, "create orgwith industry page");
		CreatingNewOrganizationPage cp = new CreatingNewOrganizationPage(driver);

		cp.getOrgname().sendKeys(orgname);

		wu.select(cp.getIndustry(), INDUSTRY);
		wu.select(cp.getType(), type);
		cp.getSavebtn().click();
		UtilityClassObject.getTest().log(Status.INFO, "create org with industry successfully");
		OrgVerifyPage ovp = new OrgVerifyPage(driver);
		String res = ovp.getOrgverify().getText();
		boolean act = res.contains(orgname);
		Assert.assertTrue(act);
	}

}
