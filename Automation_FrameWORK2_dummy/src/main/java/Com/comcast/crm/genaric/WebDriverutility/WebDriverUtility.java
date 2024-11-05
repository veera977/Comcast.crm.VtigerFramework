package Com.comcast.crm.genaric.WebDriverutility;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
public class WebDriverUtility {
	public void maximize(WebDriver driver) {
		driver.manage().window().maximize();
	}
 public void implicitWait(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
  public void explicitWait(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
  public void getWindow(WebDriver driver, String text) {
 Set<String> child = driver.getWindowHandles();
		for (String a : child) {
			driver.switchTo().window(a);
			String currenturl = driver.getCurrentUrl();
			if (currenturl.contains(text)) {
				break;
			}
}
	}
 public void switchtoFrame(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}
  public void switchtoFrame(WebDriver driver, String name) {
		driver.switchTo().frame(name);
	}
 public void switchtoFrame(WebDriver driver, WebElement element) {
		driver.switchTo().frame(element);
	}
 public void switctoAlertAccept(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
  public void switchtoAlertDismiss(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
  public void select(WebElement element, String text) {
		Select sel = new Select(element);
		sel.selectByVisibleText(text);
	}
   public void select(WebElement element, int index) {
		Select sel = new Select(element);
		sel.selectByIndex(index);
	}
   public void selectvalue(WebElement element, String value) {
		Select sel = new Select(element);
		sel.selectByValue(value);
	}
   public void deselectAll(WebElement element) {
		Select sel = new Select(element);
		sel.deselectAll();
	}
	public void deselectIndex(WebElement element,int index) {
		Select sel = new Select(element);
		sel.deselectByIndex(index);
	}
	public void deselectvalue(WebElement element,String value) {
		Select sel = new Select(element);
		sel.deselectByValue(value);
	}
	public void deselectbytext(WebElement element,String text) {
		Select sel = new Select(element);
		sel.deselectByVisibleText(text);
	}
   public boolean isMultiple(WebElement element) {
		Select sel = new Select(element);
		boolean res = sel.isMultiple();
		return res;
	}
   public String getalloptions(WebElement element) {
		Select sel = new Select(element);
		String options = sel.getOptions().toString();
		return options;
	}
   public void movetoElement(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
	}
    public void doubleclick(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.doubleClick(element);
	}
    public void rightClick(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.contextClick(element);
		}
    public void sendkeys(WebDriver driver, String data) {
		Actions action = new Actions(driver);
		action.sendKeys(data).perform();
	}
	public void screeshotForWebpage(WebDriver driver,String name) throws IOException {
	TakesScreenshot ts=(TakesScreenshot)driver;
	File temp = ts.getScreenshotAs(OutputType.FILE);
		File src=new File("./Screenshot"+name+".jpg");
		FileHandler.copy(temp, src);
	}
	public void screeshotForWebElement(WebDriver driver,WebElement element,String name) throws IOException {
		File temp = element.getScreenshotAs(OutputType.FILE);
			File src=new File("./Screenshot"+name+".jpg");
			FileHandler.copy(temp, src);
		}
	public void draganddrop(WebDriver driver, WebElement element,WebElement element1) {
		Actions action = new Actions(driver);
		action.dragAndDrop(element, element1).perform();
	}
	public void mininize(WebDriver driver) {
		driver.manage().window().minimize();
	}
	public void fullscreen(WebDriver driver) {
		driver.manage().window().fullscreen();	
	}
	public void forword(WebDriver driver) {
		driver.navigate().forward();
	}
	public void bacword(WebDriver driver) {
		driver.navigate().back();
	}
	public void refresh(WebDriver driver) {
		driver.navigate().refresh();
	}
	public void getsize(WebDriver driver) {
		Dimension size=driver.manage().window().getSize();
	System.out.println(size);
	}
	public void getposition(WebDriver driver) {
		Point position=driver.manage().window().getPosition();
	System.out.println(position);
	}
	public void executeScript(WebDriver driver,WebElement element) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()",element);
		
		
	}
}
	
	


