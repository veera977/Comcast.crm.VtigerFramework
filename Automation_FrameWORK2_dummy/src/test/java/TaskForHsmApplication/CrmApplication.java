package TaskForHsmApplication;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import Baseclass_InCrmRealeatCases.BaseclassForCrm;

public class CrmApplication extends BaseclassForCrm {
	@Test
	public void addmore() {
		WebElement more = driver.findElement(By.xpath("(//a[@href='javascript:;'])[1]"));
		//Select dropdown=new Select(more);
		//dropdown.selectByIndex(1);
		Actions action=new Actions(driver);
		action.moveToElement(more).perform();
		driver.findElement(By.linkText("Services")).click();
		driver.findElement(By.xpath("//img[@alt='Create Service...']")).click();
		driver.findElement(By.name("servicename")).sendKeys("computer");
		driver.findElement(By.xpath("(//input[@type='submit'])[1]")).click();
		
	}
	
	

}
