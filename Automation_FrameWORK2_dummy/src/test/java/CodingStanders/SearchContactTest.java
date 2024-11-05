package CodingStanders;
/**
 * @author asha
 * Test class for  create contact module
 */

import org.testng.annotations.Test;

import Baseclass_InCrmRealeatCases.BaseclassForCrm;
import Com.comcast.crm.ObjectrepositoryUtility.LoginPage;

public class SearchContactTest  extends BaseclassForCrm{
	/**
	 * navigate to contact and create cntact
	 */
	@Test
	public void serchcontactTest() {
		/*step 1:login to app*/
		LoginPage lp=new LoginPage(driver);
		lp.loginToApp("usrename", "password");
		
		
		
	}
}
