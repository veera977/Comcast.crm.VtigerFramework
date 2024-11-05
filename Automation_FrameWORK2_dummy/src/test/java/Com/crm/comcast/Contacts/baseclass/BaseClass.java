package Com.crm.comcast.Contacts.baseclass;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class BaseClass {
	@BeforeSuite
	public void configBs() {
		System.out.println("====connect database====,====reportcofiguration");
	}
	@BeforeClass
	public void configBc() {
		System.out.println("====launch the browser=====");
	}
	@BeforeMethod
	public void configBm() {
		System.out.println("=====login====");
	}

	@AfterMethod
	public void configAm() {
		System.out.println("====logout======");
	}
@AfterClass
	public void configAc() {
		System.out.println("====close the browser====");
	} 
	@AfterSuite
	public void configAs() {
		System.out.println("===close the database====,===reports backup=====");
	}


	

}
