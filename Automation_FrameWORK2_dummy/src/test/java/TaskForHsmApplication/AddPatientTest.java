package TaskForHsmApplication;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import AssignmentBaseclass.Baseclass1;
import ObjectRepository_Hrm.DashBoardPage;
import ObjectRepository_Hrm.PatientDashboardPage;
import ObjectRepository_Hrm.Verifypage;
@Listeners(ListenerimplimentationForHms.ListenerImplimentation.class)
public class AddPatientTest extends Baseclass1 {
	@Test(retryAnalyzer = Com.comcast.listenerUtility.RetryListener.class)
	public void createpatient() throws EncryptedDocumentException, IOException {

		String patientname = eu.getDataFromTheExcel("hms", 1, 0);
		String email = eu.getDataFromTheExcel("hms", 1, 1);
		String password = eu.getDataFromTheExcel("hms", 1, 2);
		String address = eu.getDataFromTheExcel("hms", 1, 3);
		String phone = eu.getDataFromTheExcel("hms", 1, 4);
		String birth = eu.getDataFromTheExcel("hms", 1, 5);
		String age = eu.getDataFromTheExcel("hms", 1, 6);
		DashBoardPage dp = new DashBoardPage(driver);
		dp.clickOnpatientLink();
		PatientDashboardPage pd = new PatientDashboardPage(driver);
		pd.enteralldetails(patientname, email, password, address, phone, birth, age);
		driver.findElement(By.partialLinkText("Log Out")).click();
		WebElement em=driver.findElement(By.name("email"));
		em.clear();

		em.sendKeys(email);
//		WebElement pa = driver.findElement(By.name("password"));
//		pa.clear();
//		pa.sendKeys(password);
//		driver.findElement(By.xpath("xpath = \"//button[@type='submit']")).click();
//		Verifypage vp = new Verifypage(driver);
//		vp.search(patientname);
//		WebElement actual = driver.findElement(By.xpath("//td[text()='" + patientname + "']"));
//		Assert.assertEquals(actual, patientname);

	}

}
