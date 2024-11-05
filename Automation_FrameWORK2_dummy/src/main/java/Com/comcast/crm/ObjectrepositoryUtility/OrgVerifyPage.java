package Com.comcast.crm.ObjectrepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class OrgVerifyPage {
	private WebDriver driver;

	public OrgVerifyPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement orgverify;
	@FindBy(id = "dtlview_Last Name")
	private WebElement lastname;
	@FindBy(id = "dtlview_Phone")
	private WebElement phnverify;

	public WebElement getPhnverify() {
		return phnverify;
	}
	public WebElement getLastname() {
		return lastname;
	}
	public WebElement getOrgverify() {
		return orgverify;
	}
	public void verifyorgpage(String name) {
		Assert.assertEquals(orgverify.getText(), name);
		
		
	}
	public void verifylastname(String value) {
		Assert.assertEquals(lastname.getText(), value);
		
	}
	public void verifyphn(String value) {
		Assert.assertEquals(phnverify.getText(), value);
		
	
}
	
	}

