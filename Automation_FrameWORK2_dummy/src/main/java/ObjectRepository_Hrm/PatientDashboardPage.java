package ObjectRepository_Hrm;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PatientDashboardPage {

public  PatientDashboardPage(WebDriver driver) {
	
	PageFactory.initElements(driver, this);
	
	
}

@FindBy(xpath = "//button[@class='btn btn-primary pull-right']")
private WebElement addbpatientbtn;

@FindBy(name = "name")
private WebElement namefield;
@FindBy(name = "email")
private WebElement emailfield;
@FindBy(name = "password")
private WebElement passwordfield;
@FindBy(name = "address")
private WebElement adressfield;
@FindBy(name = "phone")
private WebElement phonefield;

@FindBy(name = "birth_date")
private WebElement birthfield;
@FindBy(name = "age")
private WebElement agefield;

@FindBy(xpath = "//input[@type='submit']")
private WebElement submit;
public WebElement getAddbpatientbtn() {
	return addbpatientbtn;
}

public WebElement getNamefield() {
	return namefield;
}

public WebElement getEmailfield() {
	return emailfield;
}

public WebElement getPasswordfield() {
	return passwordfield;
}

public WebElement getAdressfield() {
	return adressfield;
}

public WebElement getPhonefield() {
	return phonefield;
}

public WebElement getBirthfield() {
	return birthfield;
}

public WebElement getAgefield() {
	return agefield;
}

public WebElement getSubmit() {
	return submit;
}
public void enteralldetails(String name,String emi,String pass,String add,String phn,String birth,String age) {
	addbpatientbtn.click();
	namefield.sendKeys(name);
	emailfield.sendKeys(emi);
	passwordfield.sendKeys(pass);
	adressfield.sendKeys(add);
	phonefield.sendKeys(phn);
	birthfield.sendKeys(birth);
	agefield.sendKeys(age);
	submit.click();
	
}
}
