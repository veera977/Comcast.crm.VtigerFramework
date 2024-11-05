package Com.comcat.demoWebshop.objectRepository;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddProduct {
WebDriver driver;
public  AddProduct(WebDriver driver) {
	this.driver=driver;
	
	PageFactory.initElements(driver, this);
}
@FindBy(id = "small-searchterms")
private WebElement searchfield;
@FindBy(xpath = "//input[@value='Search']")
private WebElement searchbtn; 
@FindBy(linkText  = "Build your own cheap computer")
private WebElement product;
@FindBy(id = "addtocart_72_EnteredQuantity")
private WebElement quantity;
@FindBy(id = "add-to-cart-button-72")
private WebElement addtocart;
@FindBy(xpath = "//h1[@itemprop='name']")
private WebElement veryfy;

public WebElement getVeryfy() {
	return veryfy;
}
public WebDriver getDriver() {
	return driver;
}
public WebElement getSearchfield() {
	return searchfield;
}
public WebElement getSearchbtn() {
	return searchbtn;
}
public WebElement getProduct() {
	return product;
}
public WebElement getQuantity() {
	return quantity;
}
public WebElement getAddtocart() {
	return addtocart;
}
public void searchproduct(String value) {
	searchfield.sendKeys(value);}
public void button() {
	searchbtn.click();
}
public void ClickOnproduct() {
	product.click();
}
public void enterQuantity(String value) {
	
	quantity.clear();
	quantity.sendKeys(value);
}
public void clickonAddtoCart() {
	
	addtocart.click();
	
	
}
public void Verifypage() {
	
}

}
