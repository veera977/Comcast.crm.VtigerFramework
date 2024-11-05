package PracticeRealTime.TestNG;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import Com.comcast.crm.ObjectrepositoryUtility.DataproviderAmazon;

public class AmazonGetPriceTest {
	@Test (dataProviderClass = DataproviderAmazon.class,dataProvider="getdata")
	
	public void getprice(String brandname,String productname) {
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://www.amazon.in");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(brandname,Keys.ENTER);
		//capture product info
		String price = driver.findElement(By.xpath("//span[text()='"+productname+"']/../../../../descendant::span[text()='₹']/following-sibling::span")).getText();
		System.out.println(price);
		driver.quit();
		
	}
}
