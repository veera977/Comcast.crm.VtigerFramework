package Com.comcast.crm.ObjectrepositoryUtility;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.DataProvider;

import Com.comcast.crm.genaric.fileutility.ExcelUtility;
import Com.comcast.crm.genaric.fileutility.ExcelUtility1;

public class DataproviderAmazon {
	@DataProvider
	public Object[][] getdata() throws EncryptedDocumentException, IOException {
		ExcelUtility eu = new ExcelUtility();
		int rowcount = eu.getRowCount("Amazon");
		Object[][] objarray = new Object[rowcount][2];
		for (int i = 0; i < rowcount; i++) {
			objarray[i][0] = eu.getDataFromTheExcel("Amazon", i + 1, 0);

			objarray[i][1] = eu.getDataFromTheExcel("Amazon", i + 1, 1);

		}

		return objarray;

	}

}
