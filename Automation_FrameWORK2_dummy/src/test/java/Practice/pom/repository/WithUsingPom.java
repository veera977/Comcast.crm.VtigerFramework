package Practice.pom.repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class WithUsingPom {

	@FindBy(name="user_name")
		WebElement ele1;
	@FindBy(name="user_password")
	WebElement ele2;
	@FindBy(id="submitButton")
	WebElement ele3;
	@Test
	public void simpleTest() {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:8888/index.php");
		WithUsingPom s = PageFactory.initElements(driver,WithUsingPom.class );
		s.ele1.sendKeys("admin");
		s.ele2.sendKeys("manager");
		driver.navigate().refresh();
		s.ele1.sendKeys("admin");
		s.ele2.sendKeys("manager");
		s.ele3.click();
		
	
}
}
