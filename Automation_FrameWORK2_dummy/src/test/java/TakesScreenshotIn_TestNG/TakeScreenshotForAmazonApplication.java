package TakesScreenshotIn_TestNG;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.FileFilterUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

import Com.comcast.crm.genaric.fileutility.FileUtility;

public class TakeScreenshotForAmazonApplication {
	@Test
	public void amazonTest() throws IOException {
		Reporter.log("excuting the take screenshot is start", true);
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://www.amazon.in/");
		// create an object ofEvenFiringWebDriver
		EventFiringWebDriver ref = new EventFiringWebDriver(driver);
		File temp = ref.getScreenshotAs(OutputType.FILE);
		File src = new File("./errorshots/amazonTESTNG.PNG");
		FileUtils.copyFile(temp, src);
		

	}
}
