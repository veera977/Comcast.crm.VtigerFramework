package Practice.TestNG;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateContact_DP_Test {
@Test(dataProvider = "getdata")
public void signinTest(String name,int pwd) {
	System.out.println("username"+name+"password"+pwd);
	
}
@DataProvider
public Object[][]getdata(){
	Object[][]objarry=new Object[3][2];
	objarry[0][0]="asha";
	objarry[0][1]=12345;
	
	objarry[1][0]="nisha";
	objarry[1][1]=678910;
	
	objarry[2][0]="usha";
	objarry[2][1]=012345;
	
	
	return objarry;
	
	
	
	
	
}


}
