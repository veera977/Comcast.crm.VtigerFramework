package Retryanalyzer;

import org.testng.Assert;
import org.testng.annotations.Test;

import Baseclass_InCrmRealeatCases.BaseclassForCrm;

public class RetryClass extends BaseclassForCrm {
@Test(retryAnalyzer=Com.comcast.listenerUtility.RetryListener.class)


public void simpleTest() {
	String actual = driver.getTitle();
	//Assert.assertEquals(actual, "login");
	System.out.println("step_1");
	System.out.println("step_2");
	System.out.println("step_3");
	System.out.println("step_4");
	System.out.println("step_5");
	
	
	
}
}
