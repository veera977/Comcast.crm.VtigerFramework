 package Com.comcast.listenerUtility;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import Baseclass_InCrmRealeatCases.BaseclassForCrm;
import Com.comcast.crm.genaric.WebDriverutility.UtilityClassObject;

public class ListenerImplimentation implements ITestListener,ISuiteListener {
public  ExtentReports report;
//public WebDriver driver=null;
public  static ExtentTest test;

@Override
public void onStart(ISuite suite) {
	// TODO Auto-generated method stub
	System.out.println("report configuration");
	String time = new Date().toString().replace(" ", "_").replace(":", "_");
	ExtentSparkReporter spark=new ExtentSparkReporter("./addextentreports/Createproducts2 "+time+".html");
	spark.config().setDocumentTitle("crm extent report results");
	spark.config().setReportName("crm reports");
	spark.config().setTheme(Theme.DARK);
	//create an object of the Extent report
	report=new ExtentReports();
	report.attachReporter(spark);
	
	report.setSystemInfo("os", "Window-10");
	report.setSystemInfo("Browser", "Chrome_100");

}

@Override
public void onFinish(ISuite suite) {
	// TODO Auto-generated method stub
	System.out.println("report backup");
	report.flush();
}

@Override
public void onTestStart(ITestResult result) {
	// TODO Auto-generated method stub
	 test = report.createTest(result.getMethod().getMethodName());
	 UtilityClassObject.setTest(test);
	test.log(Status.INFO, result.getMethod().getMethodName()+"========>started");
}

@Override
public void onTestSuccess(ITestResult result) {
	// TODO Auto-generated method stub
	test.log( Status.PASS,"=========>"+result.getMethod().getMethodName()+"==== completed===>");
}
@Override
public void onTestFailure(ITestResult result) {
	// TODO Auto-generated method stub
	String testname = result.getMethod().getMethodName();
	System.out.println("Hi:"+BaseclassForCrm.sdriver);
	//TakesScreenshot ts=(TakesScreenshot) BaseclassForCrm.sdriver;
	
//	EventFiringWebDriver efdriver=new EventFiringWebDriver(BaseclassForCrm.sdriver);
//	 
//	File temp =efdriver .getScreenshotAs(OutputType.FILE); 
	String time = new Date().toString().replace(" ", "_").replace(":", "_");
	TakesScreenshot ts=(TakesScreenshot)BaseclassForCrm.sdriver;
	String filepath = ts.getScreenshotAs(OutputType.BASE64);
	File src = new File("./errorshots/"+testname+""+time+"."+ "PNG");
	test.addScreenCaptureFromBase64String(filepath,testname);
	test.log( Status.FAIL,"=========>"+result.getMethod().getMethodName()+"==== failed===>");
	test.log(Status.FAIL, result.getThrowable());

}

@Override
public void onTestSkipped(ITestResult result) {
	// TODO Auto-generated method stub
	ITestListener.super.onTestSkipped(result);
	test.log(Status.FAIL, result.getThrowable());
}

@Override
public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	
}

@Override
public void onTestFailedWithTimeout(ITestResult result) {
	// TODO Auto-generated method stub
	ITestListener.super.onTestFailedWithTimeout(result);
}

@Override
public void onStart(ITestContext context) {
	// TODO Auto-generated method stub
	ITestListener.super.onStart(context);
}

@Override
public void onFinish(ITestContext context) {
	// TODO Auto-generated method stub
	ITestListener.super.onFinish(context);
}
	
	
	
	

}
