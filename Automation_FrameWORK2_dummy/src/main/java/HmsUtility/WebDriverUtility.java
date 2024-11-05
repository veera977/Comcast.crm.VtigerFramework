package HmsUtility;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.WebDriver;

public class WebDriverUtility {
public void maximize(WebDriver driver) {
	
	driver.manage().window().maximize();
}

public void implicitwait(WebDriver driver) {
	
	
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	
}
public void popup(WebDriver driver) {
	String parent = driver.getWindowHandle();
	Set<String> child = driver.getWindowHandles();
	child.remove(parent);
	for(String a:child) {
		driver.switchTo().window(a);
		
	}
	
	
}
}
