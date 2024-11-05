package Practice.TestNG;

import org.testng.annotations.Test;

public class CCantacTest {
	
		@Test
		public void CreateContactTest() {
			System.out.println("CreateContact====>HDFC");
		}
		@Test(dependsOnMethods = "CreateContactTest" )
		public void modifyContactTest() {
			//System.out.println("CreateContact====>ICICI");
			System.out.println("ModifyContact====>ICICI=====>ICICI1");
			
		}
		@Test (dependsOnMethods = "modifyContactTest")
		public void deleteContactTest() {
			//System.out.println("CreateContact====>UPI");
			System.out.println("deleteContact====>UPI");
			
			
		}
		}


