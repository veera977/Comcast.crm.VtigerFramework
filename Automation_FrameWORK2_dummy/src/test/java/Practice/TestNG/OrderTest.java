package Practice.TestNG;

import org.testng.annotations.Test;

public class OrderTest {
@Test
public void createOrderTset() {
	System.out.println("execute createorder");
}
@Test(dependsOnMethods = "createOrderTset")
public void billingOrderTest() {
	System.out.println("execute billing order");
	
	
	
}
		
		

}
