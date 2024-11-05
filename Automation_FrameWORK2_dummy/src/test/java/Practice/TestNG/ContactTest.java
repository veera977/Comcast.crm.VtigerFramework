package Practice.TestNG;

import org.testng.annotations.Test;

public class ContactTest {
@Test(priority = -1)
	//@Test
public void CreateContactTest() {
	System.out.println("CreateContact====>HDFC");
}
@Test(priority=0)
//@Test
public void modifyContactTest() {
	//System.out.println("CreateContact====>ICICI");
	System.out.println("ModifyContact====>ICICI=====>ICICI1");
	
}
@Test (priority=3)
//@Test
public void deleteContactTest() {
	//System.out.println("CreateContact====>UPI");
	System.out.println("deleteContact====>UPI");
	
	
}
}
