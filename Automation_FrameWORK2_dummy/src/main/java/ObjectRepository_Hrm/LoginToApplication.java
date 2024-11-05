package ObjectRepository_Hrm;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginToApplication {
	private WebDriver driver;

	public LoginToApplication(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(name = "email")
	private WebElement email;

	@FindBy(name = "password")
	private WebElement password;
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement login;

	public WebElement getEmail() {
		return email;
	}
	public WebElement getPassword() {
		return password;
	}
	public WebElement getLogin() {
		return login;
	}
public void enteremail(String name,String pass) {
	email.sendKeys(name);
	password.sendKeys(pass);
	login.click();
	
}
}
