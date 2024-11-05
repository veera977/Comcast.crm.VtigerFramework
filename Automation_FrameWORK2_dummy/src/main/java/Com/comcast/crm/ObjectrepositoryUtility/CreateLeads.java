package Com.comcast.crm.ObjectrepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateLeads {
	private WebDriver driver;

	public CreateLeads (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(linkText = "Leads")
	private WebElement leadlink;
	@FindBy(xpath = "//img[@alt='Create Lead...']")
	private WebElement createlead;
	@FindBy(name = "lastname")
	private WebElement lastname;
	@FindBy(name = "company")
	private WebElement company;
	@FindBy(id = "phone")
	private WebElement phn;
	public WebElement getPhn() {
		return phn;
	}
	@FindBy(name = "firstname")
	private WebElement firstname;
	@FindBy(name = "salutationtype")
	private WebElement prifix;
	
	public WebElement getFirstname() {
		return firstname;
	}
	public WebElement getPrifix() {
		return prifix;
	}
	@FindBy(xpath = "(//input[@type='submit'])[1]")
	private WebElement savebtn;


	public WebDriver getDriver() {
		return driver;
	}
	public WebElement getLeadlink() {
		return leadlink;
	}
	public WebElement getCreatelead() {
		return createlead;
	}
	public WebElement getLastname() {
		return lastname;
	}
	public WebElement getCompany() {
		return company;
	}
	public WebElement getSavebtn() {
		return savebtn;
	}
	public void clickOnLink() {
		leadlink.click();
	}
	public void createLead() {
		createlead.click();
	}
	public void lastname(String name) {
		lastname.sendKeys(name);
	}
	public void company(String name) {
		company.sendKeys(name);
	}
	public void phnnumber(String value) {
		phn.sendKeys(value);
	}
	public void save() {
		savebtn.click();
	}
	public void firstname(String name) {
		firstname.sendKeys(name);
	}
	public void prifix(String name) {
		prifix.sendKeys(name);
	}
	public void createLeads(String name,String name1) {
		lastname.sendKeys(name);
		company.sendKeys(name1);
		savebtn.click();
		
	}
	public void createLeads(String name1,String name2,String value) {
		lastname.sendKeys(name1);
		company.sendKeys(name2);
		phn.sendKeys(value);
		savebtn.click();
	
	
}
	public void createLeads(String name1,String name2,String value,String name3) {
		lastname.sendKeys(name1);
		company.sendKeys(name2);
		phn.sendKeys(value);
		firstname.sendKeys(name3);
		savebtn.click();
	
}
}
