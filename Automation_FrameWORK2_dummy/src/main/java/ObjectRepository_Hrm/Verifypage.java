package ObjectRepository_Hrm;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class Verifypage {
	private WebDriver driver;
	public  Verifypage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
		
	}
	
	@FindBy(xpath = "//input[@aria-controls='table-2']")
	private WebElement searchfield;
	
	
	public WebElement getSearchfield() {
		return searchfield;
	}


	public void verifypatient(String nam1,String nam2) {
		Assert.assertEquals(nam1, nam2);
	}
	public void search(String name) {
		searchfield.sendKeys(name);
		
	}


	
}
