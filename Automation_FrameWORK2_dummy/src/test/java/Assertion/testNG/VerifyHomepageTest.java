package Assertion.testNG;

import java.time.Duration;

import javax.annotation.processing.SupportedSourceVersion;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class VerifyHomepageTest {
@Test

public void homepageTest() {
	String Expected="Home";
	System.out.println("homepageTest excution started");
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	driver.get("http://localhost:8888/index.php");
	driver.findElement(By.name("user_name")).sendKeys("admin");
	driver.findElement(By.name("user_password")).sendKeys("manager");
	driver.findElement(By.id("submitButton")).click();
	String actual = driver.findElement(By.xpath("//a[@class='hdrLink']")).getText();
	//hardassert
	Assert.assertEquals(actual, Expected);
	System.out.println("homepage test end");
}
@Test
	public void verifyLogoHomepage() {
	
	System.out.println("verify logo homepageTest excution started");
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	driver.get("http://localhost:8888/index.php");
	driver.findElement(By.name("user_name")).sendKeys("admin");
	driver.findElement(By.name("user_password")).sendKeys("manager");
	driver.findElement(By.id("submitButton")).click();
	boolean status = driver.findElement(By.xpath("//img[@title='vtiger-crm-logo.gi']")).isEnabled();
	//softAssert
	SoftAssert assertref=new SoftAssert();
	assertref.assertTrue(status);
	//Assert.assertTrue(status);
	System.out.println("logoverified successfull");
assertref.assertAll();
}
}
