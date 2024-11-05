package Practicing_Listener;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import AssignmentBaseclass.Baseclass1;
 @Listeners(Com.comcast.listenerUtility.Listener.class)
public class ListenerTest extends Baseclass1 {
	 
	
@Test(retryAnalyzer=Com.comcast.listenerUtility.Listener.class)
public void navigateToAmazon() {
	WebDriver driver=new ChromeDriver();
	
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	driver.get("https://www.amazon.in/");
	String actual = driver.getTitle();
	
	Assert.assertEquals(actual, "demo");
	System.out.println("step_1=======>excuted=========>");
	System.out.println("step_2=======>excuted=========>");
	System.out.println("step_3=======>excuted=========>");
	System.out.println("step_4=======>excuted=========>");
	//driver.quit();
	
}
@Test(retryAnalyzer=Com.comcast.listenerUtility.Listener.class)
public void navigateToAmazon2() {
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	driver.get("https://www.amazon.in/");
	//String actual = driver.getTitle();
	//Assert.assertEquals(actual, "demo");
	System.out.println("step_1=======>excuted=========>");
	System.out.println("step_2=======>excuted=========>");
	System.out.println("step_3=======>excuted=========>");
	System.out.println("step_4=======>excuted=========>");
	//driver.quit();

}
}
