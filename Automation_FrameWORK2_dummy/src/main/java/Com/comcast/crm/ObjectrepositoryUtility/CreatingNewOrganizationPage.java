package Com.comcast.crm.ObjectrepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatingNewOrganizationPage {
	private WebDriver driver;

	public CreatingNewOrganizationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "accountname")
	private WebElement orgname;

	@FindBy(xpath = "(//input[@title='Save [Alt+S]'])[1]")
	private WebElement savebtn;

	@FindBy(name = "industry")
	private WebElement industry;
	@FindBy(name = "accounttype")
	private WebElement type;
	@FindBy(id="phone")
	private WebElement phone;
	

	public WebElement getPhone() {
		return phone;
	}

	public WebElement getIndustry() {
		return industry;
	}

	public WebElement getType() {
		return type;
	}

	public WebElement getSavebtn() {
		return savebtn;
	}

	public WebElement getOrgname() {
		return orgname;
	}

	public void enterOrgName(String name) {
		driver.manage().window().maximize();
		getOrgname().sendKeys(name);
		//getSavebtn().click();
	}
	public void clickOnIndustry() {
	industry.click();
	}
	public void ClickOnType() {
		type.click();
		

	}
	public void enterPhoneNum(String phn) {
		phone.sendKeys(phn);
	}
	public void Createorg(String name) {
		orgname.sendKeys(name);
		savebtn.click();
		
	}
	public void Createorg(String name,String phn) {
		orgname.sendKeys(name);
		phone.sendKeys(phn);
		savebtn.click();
		
	}
	public void Createorg(String name,String name1,String name2) {
		orgname.sendKeys(name);
		industry.sendKeys(name1);
		type.sendKeys(name2);
		savebtn.click();
		
	}
		
	}


