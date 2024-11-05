package Com.comcast.crm.genaric.fileutility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtility1 {
public String getDataFromPropertyfile(String key) throws IOException {
	FileInputStream fis=new FileInputStream("./CommonData/demo.properties");
	Properties prop = new Properties();
	prop.load(fis);
	String data = prop.getProperty(key);
	
	
	
	
	return data;
	
	
}
}
