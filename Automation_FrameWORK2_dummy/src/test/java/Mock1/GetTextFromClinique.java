package Mock1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class GetTextFromClinique {
	
public static void main(String[] args) throws InterruptedException {
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	driver.get("https://www.clinique.in/");
	
	/*
	 * Thread.sleep(5000);
	 * 
	 * WebElement element = driver.findElement(By.
	 * xpath("(//li[@class='gnav-block__navigation-item js-gnav-block-navigation-item'])[4]"
	 * )); Actions action=new Actions(driver); action.moveToElement(element);
	 */
//	driver.findElement(By.id("onetrust-accept-btn-handler")).click();
//	WebElement move = driver.findElement(By.xpath("(//a[@class='gnav-desktop-top-level-title'])[4]"));
//	Actions action=new Actions(driver) ;
//	action.moveToElement(move).perform();
//	Thread.sleep(2000);
//	String getText = driver.findElement(By.xpath("(//div[@class='gnav-desktop-sub-nav-container'])[1]")).getText();
//	Thread.sleep(2000);
//	System.out.println(getText);)
	driver.findElement(By.partialLinkText("Skincare")).click();
	Thread.sleep(2000);
	String text = driver.findElement(By.xpath("(//div[@class='gnav-desktop-sub-nav-content-column space-y-4'])[11]")).getText();
	System.out.println(text);

	

	driver.quit();
	
	
}
	
	
	
	
}
