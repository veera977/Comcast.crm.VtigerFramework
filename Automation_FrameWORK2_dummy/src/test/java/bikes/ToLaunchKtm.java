package bikes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class ToLaunchKtm {
	@Test(groups="integration")
	public void access() {
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.ktm.com/en-in.html");
		Reporter.log("Ktm got executed", true);
		driver.quit();

}
}
