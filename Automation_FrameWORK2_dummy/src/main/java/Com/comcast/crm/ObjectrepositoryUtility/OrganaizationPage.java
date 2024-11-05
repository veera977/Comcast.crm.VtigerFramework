package Com.comcast.crm.ObjectrepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganaizationPage {
WebDriver driver;
public OrganaizationPage(WebDriver driver) {
this.driver=driver;
PageFactory.initElements(driver,this);
}
@FindBy(xpath="//img[@alt='Create Organization...']")
 private WebElement clickonPlus;


public WebElement getClickonPlus() {
	return clickonPlus;
}
public void clickOncreateOrg() {
	driver.manage().window().maximize();
	clickonPlus.click();


}

	
	
	
}
