package CreateContactRealTeatScriptUsingBaseClass;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
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
import Com.comcast.crm.ObjectrepositoryUtility.CreateContactpage;
import Com.comcast.crm.ObjectrepositoryUtility.CreatingNewOrganizationPage;
import Com.comcast.crm.ObjectrepositoryUtility.HomePage;
import Com.comcast.crm.ObjectrepositoryUtility.OrgVerifyPage;
import Com.comcast.crm.ObjectrepositoryUtility.OrganaizationPage;
import Com.comcast.crm.ObjectrepositoryUtility.VerificationContactPage;
import Com.comcast.crm.genaric.WebDriverutility.JavaUtility;
import Com.comcast.crm.genaric.WebDriverutility.UtilityClassObject;
import Com.comcast.crm.genaric.fileutility.ExcelUtility;

/**
 * @author asha
 * testclass contains contact moule
 */
public class CreateContactTest extends BaseclassForCrm {
	
	ExcelUtility eu = new ExcelUtility();
	JavaUtility ju = new JavaUtility();

	@Test(groups = { "smoketest" }, retryAnalyzer = Com.comcast.listenerUtility.RetryListener.class)
	public void createContactTest() throws IOException, InterruptedException {
		/* tead the data from property file
		creare an object of fileutility*/

		/* use random class*/
		JavaUtility ju = new JavaUtility();

		/*read the data from the excell file
		create an object of excelutility*/
		UtilityClassObject.getTest().log(Status.INFO, "read the data from the excel");
		ExcelUtility eu = new ExcelUtility();
		String contact = eu.getDataFromTheExcel("contact", 1, 2) + ju.getRandomNum();
		String lastname = eu.getDataFromTheExcel("contact", 1, 3) + ju.getRandomNum();
		String orgname = eu.getDataFromTheExcel("contactmodule", 1, 3) + ju.getRandomNum();
		/* create object of CreateContactpage*/
		UtilityClassObject.getTest().log(Status.INFO, "navigate to contact page");
		CreateContactpage ccp = new CreateContactpage(driver);
		ccp.clickOncontactlink();
		ccp.clickOnCreatecontactlink();
		ccp.createContact(lastname, contact);

		/*verify header*/
		UtilityClassObject.getTest().log(Status.INFO, "navigate to create contact page");
		VerificationContactPage vc = new VerificationContactPage(driver);
		UtilityClassObject.getTest().log(Status.INFO, "create contact added successfully ");
		String res = vc.getVeryfy().getText();
		boolean actual = res.contains(lastname);
/*hordassert*/
		Assert.assertTrue(actual);

//Assert.assertEquals(actual, res);
		String mob = vc.getMobileNum().getText();
		boolean phone = mob.contains(contact);
		org.testng.Assert.assertFalse(phone);

	}

	@Test(groups = { "regressiontest" }, retryAnalyzer = Com.comcast.listenerUtility.RetryListener.class)
	public void CreatecontactwithSystemDateTest() throws EncryptedDocumentException, IOException {
		UtilityClassObject.getTest().log(Status.INFO, "read the data from the excel");
		ExcelUtility eu = new ExcelUtility();
		String lastname = eu.getDataFromTheExcel("contactmodule", 1, 2) + ju.getRandomNum();
		String contact = eu.getDataFromTheExcel("contact", 1, 2) + ju.getRandomNum();

		JavaUtility ju = new JavaUtility();
		String sysdate = ju.getSystemDate();
		String actdate = ju.getendDtae(30);
		UtilityClassObject.getTest().log(Status.INFO, "navigate to contact page");
		CreateContactpage ccp = new CreateContactpage(driver);
		ccp.clickOncontactlink();
		ccp.clickOnCreatecontactlink();
		ccp.createContact(sysdate, actdate, contact, lastname);

	}

	@Test(groups = { "regressiontest" }, retryAnalyzer = Com.comcast.listenerUtility.RetryListener.class)

	public void CreateContactWithOrgNameTest() throws EncryptedDocumentException, IOException {
		UtilityClassObject.getTest().log(Status.INFO, "navigate to contact page");
		HomePage hp = new HomePage(driver);
		
		hp.clickOnOrgLink();
		OrganaizationPage op = new OrganaizationPage(driver);
		op.clickOncreateOrg();
		CreatingNewOrganizationPage cp = new CreatingNewOrganizationPage(driver);
		UtilityClassObject.getTest().log(Status.INFO, "read the data from the excel");
		ExcelUtility eu = new ExcelUtility();
		String orgname = eu.getDataFromTheExcel("contactmodule", 1, 3) + ju.getRandomNum();
		// cp.enterOrgName(orgname);
		cp.Createorg(orgname);
		OrgVerifyPage op1 = new OrgVerifyPage(driver);
		String res = op1.getOrgverify().getText();
		boolean actual = res.contains(orgname);
		Assert.assertTrue(actual);

		// move to contact module
		UtilityClassObject.getTest().log(Status.INFO, "create contact with orgname ");
		CreateContactpage ccp = new CreateContactpage(driver);
		ccp.clickOncontactlink();
		ccp.clickOnCreatecontactlink();
		String lastname = eu.getDataFromTheExcel("contact", 1, 3) + ju.getRandomNum();
		ccp.enterLastName(lastname);
		driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img")).click();
		wu.getWindow(driver, "Accounts&action");
		ccp.searchfeild(orgname);
		ccp.getClicksearch();
		driver.findElement(By.linkText(orgname)).click();
		wu.getWindow(driver, "Contacts&action");

	}

}
