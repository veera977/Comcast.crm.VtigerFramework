package bikes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class Tolaunchrx100 {
	@Test(groups="system")
	public void access() {
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.bikedekho.com/");
		Reporter.log("rx 100 got executed", true);
		driver.quit();

}
}


