package Com.comcast.crm.ObjectrepositoryUtility;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.DataProvider;

import Com.comcast.crm.genaric.fileutility.ExcelUtility;

public class DtaProvider {
	@DataProvider
	public Object[][] getdata() throws EncryptedDocumentException, IOException {
		ExcelUtility eu = new ExcelUtility();
		int rowcount = eu.getRowCount("Demowebshop");
		Object[][] ref = new Object[rowcount][1];
		for (int i = 0; i < rowcount; i++) {
			ref[i][0] = eu.getDataFromTheExcel("Demowebshop", i + 1, 0);

		}

		return ref;

	}

}
