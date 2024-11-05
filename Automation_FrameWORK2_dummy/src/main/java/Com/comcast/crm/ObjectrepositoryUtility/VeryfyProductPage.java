package Com.comcast.crm.ObjectrepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class VeryfyProductPage {
	private WebDriver driver;

	public VeryfyProductPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//span[@class='lvtHeaderText']")
	private WebElement veryfyproduct;

	public WebElement getVeryfyproduct() {
		return veryfyproduct;
	}
	public void veryfingpro( String name) {
		Assert.assertEquals(veryfyproduct.getText(), name);
		
		
	}
}
