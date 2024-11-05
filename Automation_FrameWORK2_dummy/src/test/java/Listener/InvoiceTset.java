package Listener;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Baseclass_InCrmRealeatCases.BaseclassForCrm;

//@Listeners(Com.comcast.listenerUtility.ListenerImplimentation.class)
public class InvoiceTset extends BaseclassForCrm {
	@Test
	public void createInvoice() {
		System.out.println("excute createInvoice ");
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, "login");
		System.out.println("step_1");
		System.out.println("step_2");
		System.out.println("step_3");
		System.out.println("step_4");
		System.out.println("step_5");

	}

	@Test
	public void createInvoiceWithPhoneNumber() {
		System.out.println("excute createInvoiceWithPhoneNumber ");
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, "login");
        System.out.println("step_1");
		System.out.println("step_2");
		System.out.println("step_3");
		System.out.println("step_4");
		System.out.println("step_5");

	}

}
