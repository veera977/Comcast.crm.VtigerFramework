package Com.comcast.crm.ObjectrepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateContactpage {
	private WebDriver driver;

	public CreateContactpage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(linkText ="Contacts")
	private WebElement contact;
	@FindBy(xpath = "//img[@title='Create Contact...']")
	private WebElement create;
	@FindBy(name = "lastname")
	private WebElement lastname;
	@FindBy(id = "mobile")
	private WebElement mobile;
	@FindBy(xpath = "(//input[@title='Save [Alt+S]'])[1]")
	private WebElement savebtn;
	@FindBy(name="support_start_date")
	private WebElement startdate;
	@FindBy(name = "support_end_date")
	private WebElement enddate;
	@FindBy(id = "search_txt")
	private WebElement search;
	@FindBy(id = "search")
	private WebElement clicksearch;
	
	
	public WebElement getClicksearch() {
		return clicksearch;
	}

	public WebElement getSearch() {
		return search;
	}

	public WebElement getStartdate() {
		return startdate;
	}

	public WebElement getEnddate() {
		return enddate;
	}

	public WebElement getContact() {
		return contact;
	}
	public WebElement getCreate() {
		return create;
	}
	public WebElement getLastname() {
		return lastname;
	}
	public WebElement getMobile() {
		return mobile;
	}
	public WebElement getSavebtn() {
		return savebtn;
	}
	public void clickOncontactlink() {
		contact.click();
	}
	public void clickOnCreatecontactlink() {
		create.click();
	}
	public void enterLastName(String name) {
		lastname.sendKeys(name);
	}
	public void enterMobileNumber(String phn) {
		mobile.sendKeys(phn);
	}
	public void clickOnSaveButton() {
		savebtn.click();
	}
	public void enterStartdate(String date  ) {
		startdate.clear();
		startdate.sendKeys(date);
	}
	public void enterEnddate(String date) {
		enddate.clear();
		enddate.sendKeys(date);
	}
	public void searchfeild(String name) {
		search.sendKeys(name);
	}
	public void clickonsearch() {
		clicksearch.click();
	}

	
	public void createContact(String Lastname,String Contact) {
		
	lastname.sendKeys(Lastname);
	contact.sendKeys(Contact);
	savebtn.click();
	
	}
	public void createContact(String systemDate,String EndDate,String Contact,String Name) {
		
		lastname.sendKeys(Name);
		contact.sendKeys(Contact);
		startdate.clear();
		startdate.sendKeys(systemDate);
		enddate.clear();
		enddate.sendKeys(EndDate);
		savebtn.click();
		
	}
	}
