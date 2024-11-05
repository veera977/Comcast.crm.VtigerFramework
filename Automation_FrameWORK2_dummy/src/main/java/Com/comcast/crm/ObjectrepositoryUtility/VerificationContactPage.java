package Com.comcast.crm.ObjectrepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class VerificationContactPage {
	WebDriver driver;

	public VerificationContactPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement veryfy;

	@FindBy(id = "dtlview_Last Name")
	private WebElement lastname;
	@FindBy(id = "dtlview_Mobile")
	private WebElement mobileNum;

	public WebElement getMobileNum() {
		return mobileNum;
	}

	public WebElement getLastname() {
		return lastname;
	}

	public WebElement getVeryfy() {
		return veryfy;
	}

	public void verifyPage(String name) {
		Assert.assertEquals(veryfy.getText(), name);
		

	}

	public void verifyLastName(String name) {
		Assert.assertEquals(lastname.getText(), name);
		
	}
	public void verifyMobileNum(String num) {
		Assert.assertEquals(mobileNum.getText(), num);
	}

}
