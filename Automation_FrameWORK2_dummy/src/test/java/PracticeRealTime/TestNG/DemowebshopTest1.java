package PracticeRealTime.TestNG;

import java.io.IOException;
import java.time.Duration;
import java.util.ServiceLoader.Provider;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import Com.comcast.crm.ObjectrepositoryUtility.DtaProvider;
import Com.comcast.crm.genaric.fileutility.FileUtility1;

public class DemowebshopTest1 {
	@Test(dataProviderClass=DtaProvider.class,dataProvider="getdata")
	
	public void addtheProductToTheCratTest(String productname) throws IOException {
		FileUtility1 fu = new FileUtility1();
		String EMAIL = fu.getDataFromPropertyfile("email");
		String BROWSER = fu.getDataFromPropertyfile("browser");
		String PASSWORD = fu.getDataFromPropertyfile("password");
		String URL = fu.getDataFromPropertyfile("url");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get(URL);
		driver.findElement(By.linkText("Log in")).click();
		driver.findElement(By.id("Email")).sendKeys(EMAIL);
		driver.findElement(By.id("Password")).sendKeys(PASSWORD);
		driver.findElement(By.xpath("(//input[@type='submit'])[2]")).click();
		driver.findElement(By.id("small-searchterms")).sendKeys(productname, Keys.ENTER);
		driver.findElement(By.partialLinkText(productname)).click();
		WebElement pro = driver.findElement(By.id("addtocart_72_EnteredQuantity"));
		pro.clear();
		pro.sendKeys("12");
		driver.findElement(By.id("add-to-cart-button-72")).click();
		String actdata = driver.findElement(By.xpath("//h1[@itemprop='name']")).getText();
		if (actdata.contains(productname)) {
			System.out.println("product added successfully");
		} else {
			System.out.println("not added");
		}
		driver.quit();

	}
}
