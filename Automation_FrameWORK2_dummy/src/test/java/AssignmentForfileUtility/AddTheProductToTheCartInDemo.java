package AssignmentForfileUtility;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import Com.comcast.crm.genaric.fileutility.ExcelUtility1;
import Com.comcast.crm.genaric.fileutility.FileUtility;
import Com.comcast.crm.genaric.fileutility.FileUtility1;

public class AddTheProductToTheCartInDemo {

	public static void main(String[] args) throws IOException {
		// read the data from the property file
		// create an object of file utility class
		FileUtility1 fu = new FileUtility1();
		String BROWSER = fu.getDataFromPropertyfile("browser");
		String URL = fu.getDataFromPropertyfile("url");
		String EMAIL = fu.getDataFromPropertyfile("email");
		String PASSWORD = fu.getDataFromPropertyfile("password");
		// read the data from the excel file
		// create an object of excel utility
		ExcelUtility1 eu = new ExcelUtility1();
		String product = eu.getDatafromexcel("DemoWebshop", 1, 0);

		String quantity = eu.getDatafromexcel("DemoWebshop", 1, 1);
		WebDriver driver = null;
		if (BROWSER.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equals("edge")) {
			driver = new EdgeDriver();
		}
		if (BROWSER.equals("firefox")) {
			driver = new FirefoxDriver();
		} else if (BROWSER.equals("safari")) {
			driver = new SafariDriver();
		}
		driver.get(URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.findElement(By.linkText("Log in")).click();
		driver.findElement(By.id("Email")).sendKeys(EMAIL);
		driver.findElement(By.id("Password")).sendKeys(PASSWORD);
		driver.findElement(By.xpath("//input[@value='Log in']")).click();
		driver.findElement(By.id("small-searchterms")).click();
		driver.findElement(By.id("small-searchterms")).sendKeys(product, Keys.ENTER);
		driver.findElement(By.partialLinkText("Build your own cheap computer")).click();
		WebElement textfield = driver.findElement(By.id("addtocart_72_EnteredQuantity"));
		textfield.click();
		textfield.clear();
		textfield.sendKeys(quantity);
		driver.findElement(By.id("add-to-cart-button-72")).click();
		String actdata = driver.findElement(By.xpath("//h1[@itemprop='name']")).getText();

		if (actdata.contains(product)) {
			System.out.println("product added successfully");
eu.backToExcel("DemoWebshop", 1, 2, "pass");
			
		} else {
			System.out.println("not added successfully");
			eu.backToExcel("DemoWebshop", 1, 2, "fail");
		}
		
		driver.quit();

	}

}
