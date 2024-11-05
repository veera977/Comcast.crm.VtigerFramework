package bikes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class ToLaunchActiva {
	@Test(groups="smoke")
	public void access() {
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.bikedekho.com/");
		Reporter.log("activa got executed", true);
		driver.quit();

}
}
