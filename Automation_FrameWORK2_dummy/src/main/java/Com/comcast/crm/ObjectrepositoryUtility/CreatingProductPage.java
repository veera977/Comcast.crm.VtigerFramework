package Com.comcast.crm.ObjectrepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatingProductPage {
	private WebDriver driver;

	public CreatingProductPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(linkText = "Products")
	private WebElement prolink;
	@FindBy(xpath = "//img[@alt='Create Product...']")
	private WebElement createpro;
	@FindBy(name = "productname")
	private WebElement proname;
	@FindBy(id = "productcode")
	private WebElement code;
	
	public WebElement getCode() {
		return code;
	}
	@FindBy(id = "jscal_field_sales_start_date")
	private WebElement salesStartdate;
	@FindBy(id = "jscal_field_sales_end_date")
	private WebElement salesEnddate;
	
	public WebElement getSalesStartdate() {
		return salesStartdate;
	}
	public WebElement getSalesEnddate() {
		return salesEnddate;
	}
	@FindBy(xpath = "(//input[@type='submit'])[1]")
	private WebElement savebtn;

	public WebElement getProlink() {
		return prolink;
	}
	public WebElement getCreatepro() {
		return createpro;
	}
	public WebElement getProname() {
		return proname;
	}
	public WebElement getSavebtn() {
		return savebtn;
	}
	public void clickonlink() {
		prolink.click();
	}
	public void createpro() {
		createpro.click();
	}
	public void productname(String name) {
		proname.sendKeys(name);
		savebtn.click();
	}
	public void savebtnn() {
		savebtn.click();
	}
	public void enterportnum(String value) {
		code.sendKeys(value);
	}
	public void salesStartdate(String value) {
		salesStartdate.sendKeys(value);
	}
	public void salesEndDtae(String value) {
		salesEnddate.sendKeys(value);
}
	public void productname(String name,String value) {
		proname.sendKeys(name);
		code.sendKeys(value);
		savebtn.click();
	}
}
