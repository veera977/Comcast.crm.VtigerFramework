package Understandinon_ConfigurationAnntation;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class ContactTest {
	@BeforeSuite
	public void configBs() {
		System.out.println("execute before suit");
	}

	@AfterSuite
	public void configAs() {
		System.out.println("execute after suit");
	}

	@BeforeClass
	public void configBc() {
		System.out.println("execute before class");
	}

	@AfterClass
	public void configAc() {
		System.out.println("execute after class");
	}

	@BeforeMethod
	public void configBm() {
		System.out.println("execute before method");
	}

	@AfterMethod
	public void configAm() {
		System.out.println("execute after method");
	}

	@Test
	public void createContact() {
		System.out.println("execute createContact");

	}

	@Test
	public void createContactWithDate() {
		System.out.println("execute createContactWithDate");

	}

}
