package Com.comcast.crm.ObjectrepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "Organizations")
	private WebElement orglink;
	@FindBy(linkText = "Campaigns")
	private WebElement compaignlink;
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminbtn;
	@FindBy(linkText = "Sign Out")
	private WebElement signout;
	

	

	public WebElement getSignout() {
		return signout;
	}

	public WebElement getCompaignlink() {
		return compaignlink;
	}

	public WebElement getOrglink() {
		return orglink;
	}

	public WebElement getAdminbtn() {
		return adminbtn;
	}

	public void clickOnOrgLink() {
		driver.manage().window().maximize();
		orglink.click();
	}

	// compaignlink.click();
	public void logOut() {
		Actions action = new Actions(driver);
		action.moveToElement(adminbtn).perform();

	}

	public void cliconSignOut() {
		getSignout().click();
	}

	

	public void signOut(WebDriver driver) {
		Actions action = new Actions(driver);
		action.moveToElement(adminbtn).perform();
		action.moveToElement(signout).click().perform();

	}

}
