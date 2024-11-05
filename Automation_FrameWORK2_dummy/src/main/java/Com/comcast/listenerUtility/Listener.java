package Com.comcast.listenerUtility;

import java.awt.Event;
import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.IRetryAnalyzer;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import AssignmentBaseclass.Baseclass1;

public class Listener implements ITestListener,ISuiteListener,IRetryAnalyzer {
int count =0;
int limit=3;
	@Override
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		if(count<limit) {
			count++;
			return true;
		}
	
		
		
		return false;
	}

	@Override
	public void onStart(ISuite suite) {
		// TODO Auto-generated method stub
		System.out.println("=====>report configuration======>");
	}

	@Override
	public void onFinish(ISuite suite) {
		// TODO Auto-generated method stub
		System.out.println("=====>report backup=====>");
	}

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("result.getMethod().getMethodName()=====>stsrt");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("result.getMethod().getMethodName()=====>success");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		String name = result.getMethod().getMethodName();
		
		EventFiringWebDriver ref=new EventFiringWebDriver(Baseclass1.sdriver);
		File temp = ref.getScreenshotAs(OutputType.FILE);
		String time = new Date().toString().replace(" ", "_").replace(":", "_");
		File src=new File("./errorshots/"+name+""+time+".png");
		try {
			FileUtils.copyFile(temp,src );
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("result.getMethod().getMethodName()=====>skipped");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("result.getMethod().getMethodName()=====>failed but with in successPercentage");
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("result.getMethod().getMethodName()=====>failed with time out");
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("result.getMethod().getMethodName()=====>stsrt with context");
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("result.getMethod().getMethodName()=====>report backup with context");
	}
	
	
	
	
	
	

}
