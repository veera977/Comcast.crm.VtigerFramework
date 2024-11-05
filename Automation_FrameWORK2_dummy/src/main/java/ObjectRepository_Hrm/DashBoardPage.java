package ObjectRepository_Hrm;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashBoardPage {
	
	
private WebDriver driver;

public  DashBoardPage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
	
	
}
@FindBy(xpath = "//span[text()='Patient']")
private WebElement patientLink;

public WebElement getPatientLink() {
	return patientLink;
}
public void clickOnpatientLink() {
	patientLink.click();
	
}



}
