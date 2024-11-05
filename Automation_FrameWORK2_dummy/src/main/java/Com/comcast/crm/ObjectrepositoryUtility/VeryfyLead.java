package Com.comcast.crm.ObjectrepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class VeryfyLead {
	private WebDriver driver;

	public VeryfyLead(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement leadveryfy;

	
	public WebElement getLeadveryfy() {
		return leadveryfy;
	}


	public void veryfyLeadpage(String name ) {
		Assert.assertEquals(leadveryfy.getText(), name);
		
		
	}
}

