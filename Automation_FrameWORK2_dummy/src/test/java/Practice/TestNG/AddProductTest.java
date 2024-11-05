package Practice.TestNG;

import org.testng.annotations.Test;

public class AddProductTest {
@Test
public void addproducttothecartTest() {
	System.out.println("login to application");
	System.out.println("search the product in search context field");
	System.out.println("select the product");
	System.out.println("add the product in to cart");
	System.out.println("veryfy whether the product is add r not");
	System.out.println("logout");
}
@Test
public void paymentTest() {
	System.out.println("go to payment option");
	System.out.println("select payment method");
	System.out.println("pay the amount");
	System.out.println("veryfy");
	System.out.println("logout");
	
}


}
