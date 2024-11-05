package DatabaseutilityAssignment;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.mysql.cj.jdbc.Driver;

public class Frontend_to_Backend_assignment {
	public static void main(String[] args)
			throws EncryptedDocumentException, IOException, InterruptedException, SQLException {
//add the product to the cart
		String expect = "shoe";
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://demowebshop.tricentis.com/");
		driver.findElement(By.linkText("Log in")).click();
		driver.findElement(By.id("Email")).sendKeys("seleniumA2@gmail.com");
		driver.findElement(By.id("Password")).sendKeys("selenium@123");
		driver.findElement(By.xpath("//input[@value='Log in']")).click();
		Thread.sleep(2000);
		WebElement search = driver.findElement(By.id("small-searchterms"));
		search.click();
		search.sendKeys("blue and green sneaker", Keys.ENTER);
		driver.findElement(By.linkText("Blue and green Sneaker")).click();
		WebElement quant = driver.findElement(By.id("addtocart_28_EnteredQuantity"));
		quant.clear();
		quant.sendKeys("3");
		driver.findElement(By.id("add-to-cart-button-28")).click();
		List<WebElement> all = driver.findElements(By.xpath("//div[@class='master-wrapper-page'"));
		for (WebElement a : all) {
			String actual = a.getText();
			if (expect.equals(actual)) {
				System.out.println("product added successfully");
			} else {
				System.out.println("product not added");
			}
			// verify the data in data base
			Driver ref = new Driver();
			DriverManager.registerDriver(ref);
			Connection conn = DriverManager.getConnection("jdbc:mysql://106.51.90.215:3333/demowebshop", "root@%",
					"root");
			Statement state = conn.createStatement();
			int result = state.executeUpdate("insert into demo values('shoes' varchar(10),12,286700;");

			if (expect.equals(result)) {
				System.out.println("data available");
			} else {
				System.out.println("data not available");
			}
			conn.close();

		}

	}

}
