package AddTheProductintoDemowebshopByUsingBaseClas;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Com.comcast.crm.genaric.fileutility.ExcelUtility;
import Com.comcat.demoWebshop.objectRepository.AddProduct;
import DemoWebshopByusingbaseclass.BaseclassDemo;
@Listeners(ListenerUtilityForDemo.ListenerImplimentationForDemo.class)
public class AddTheProductToTheCart extends BaseclassDemo {
@Test(groups="smoketesting",retryAnalyzer = Com.comcast.listenerUtility.RetryListener.class)
public void addproductTest() throws EncryptedDocumentException, IOException {
	ExcelUtility eu=new ExcelUtility();
	//int rowcount = eu.getRowCount("Demowebshop");
	String product = eu.getDataFromTheExcel("Demowebshop", 1, 0).toString();
	String quantity = eu.getDataFromTheExcel("Demowebshop", 1, 1);
	AddProduct ad=new AddProduct(driver);
	ad.searchproduct(product);
	ad.ClickOnproduct();
	ad.enterQuantity(quantity);
	ad.clickonAddtoCart();
	//ad.Verifypage(product);
	String res = ad.getVeryfy().getText();
	boolean act = res.contains(product);
	Assert.assertEquals(act, product,"Fails");
	Reporter.log("verification is failed");
	
}
}
