package ExtentReportes;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import Baseclass_InCrmRealeatCases.BaseclassForCrm;
@Listeners(Com.comcast.listenerUtility.ListenerImplimentation.class)

public class SimpleExtentReport extends BaseclassForCrm {
	//ExtentSparkReporter report=new ExtentSparkReporter()
	ExtentReports report=new ExtentReports();
	@Test
	public void createcontact() {


		ExtentTest test = report.createTest("createcontact");
		test.log(Status.INFO, "login to app");
		test.log(Status.INFO, "navigate to app");
		test.log(Status.INFO, "create cantact  ");
		if ("hdfc".equals("hfdc")) {
			test.log(Status.PASS, "create contact successfully");
		} else {
			
		}
		// report.flush();

	}

	@Test
	public void createcontactwithsysstemdate() {

		ExtentTest test = report.createTest("createcontactwithsysstemdate");
		test.log(Status.INFO, "login to app");
		test.log(Status.INFO, "navigate to app");
		test.log(Status.INFO, "create cantact  ");
		if ("hdfc".equals("hfdc")) {
			test.log(Status.PASS, " createcontactwithsysstemdate successfully");
		} else {
			test.log(Status.FAIL, "createcontactwithsysstemdate not created");
		}
		// report.flush();

	}

	@Test
	public void createcontactwithphonenumber() {

		ExtentTest test = report.createTest("createcontactwithphonenumber");
		test.log(Status.INFO, "login to app");
		test.log(Status.INFO, "navigate to app");
		test.log(Status.INFO, "create cantact  ");
		if ("hdfc".equals("hdfc")) {
			test.log(Status.PASS, " createcontactwithphonenumber successfully");
		} else {
			test.log(Status.FAIL, "createcontactwithphonenumbert not created");
		}
		// report.flush();

	}
}
