package Com.comcat.demoWebshop.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
private WebDriver driver;
public LoginPage( WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
}
@FindBy(linkText = "Log in")
private WebElement login;
@FindBy(id = "Email")
private WebElement email;
@FindBy(id = "Password")
private WebElement password;
@FindBy(xpath = "(//input[@type='submit'])[2]")
private WebElement clicklogin;
public WebDriver getDriver() {
	return driver;
}
public WebElement getLogin() {
	return login;
}
public WebElement getEmail() {
	return email;
}
public WebElement getPassword() {
	return password;
}
public WebElement getClicklogin() {
	return clicklogin;
}
public void logintoapp() {
	login.click();
}
public void enterEmail(String data) {
	email.sendKeys(data);
	
}
public void enterpassword(String data) {
	password.sendKeys(data);}
public void clickonLogin() {
	clicklogin.click();
	
	

	
	
}
}
