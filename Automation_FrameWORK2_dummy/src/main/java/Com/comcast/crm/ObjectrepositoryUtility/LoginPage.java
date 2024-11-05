package Com.comcast.crm.ObjectrepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * @author asha
 * contains login page elements and busiiness methods
 */
public class LoginPage {//create separate pom class for separate page
	//object implimentation
	WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements( driver,this);
	}
	@FindBy(name="user_name")
    private WebElement usernameEdt;
	@FindBy(name="user_password")
   private WebElement passwordEdt;
	@FindBy(id="submitbutton")
   private WebElement loginbtn;//object initilization
	//object encapsullation
	public WebElement getUsernameEdt() {
		return usernameEdt;
	}
	public WebElement getPasswordEdt() {
		return passwordEdt;
	}
	public WebElement getLoginbtn() {
		return loginbtn;
	}
	//provide a action
	/**
	 * 
	 * @param username
	 * @param password
	 * login to application based on username and password arguments
	 */
	public void loginToApp(String username,String password) {
		driver.manage().window().maximize();
		usernameEdt.sendKeys(username);
		passwordEdt.sendKeys(password);
		loginbtn.click();
		
	}
	
	
	
	

}
