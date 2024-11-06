package Com.comcast.crm.ObjectrepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage2 {
	WebDriver driver;

	public HomePage2(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "Organizations")
	private WebElement orglink;
	@FindBy(linkText = "Products")
	private WebElement prolink;
	@FindBy(linkText = "mouseover")
	private WebElement mouseoverbtn1;
	public WebElement getProlink() {
		return prolink;
		
	}
	@FindBy(linkText = "dropdown")
	private WebElement dropdownbtn;
}


