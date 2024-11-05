package ListenerUtilityForDemo;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import Baseclass_InCrmRealeatCases.BaseclassForCrm;
import DemoWebshopByusingbaseclass.BaseclassDemo;

public class ListenerImplimentationForDemo implements ITestListener,ISuiteListener {
	@Override
	public void onStart(ISuite suite) {
		// TODO Auto-generated method stub
		System.out.println("report configuration");
	}

	@Override
	public void onFinish(ISuite suite) {
		// TODO Auto-generated method stub
		System.out.println("report backup");
	}

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("=========>"+result.getMethod().getMethodName()+"==== start===>");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("=========>"+result.getMethod().getMethodName()+"==== success===>");
	}
	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		String testname = result.getMethod().getMethodName();
		System.out.println("Hi:"+BaseclassDemo.sdriver);
		//TakesScreenshot ts=(TakesScreenshot) BaseclassForCrm.sdriver;
		
		EventFiringWebDriver efdriver=new EventFiringWebDriver(BaseclassDemo.sdriver);
		 
		File temp =efdriver .getScreenshotAs(OutputType.FILE); 
		String time = new Date().toString().replace(" ", "_").replace(":", "_");
		File src = new File("./errorshots/"+testname+""+time+"."
				+ "PNG");
		try {
			FileUtils.copyFile(temp, src);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSkipped(result);
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


