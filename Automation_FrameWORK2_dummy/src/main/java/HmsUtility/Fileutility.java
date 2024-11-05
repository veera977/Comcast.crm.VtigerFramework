package HmsUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Fileutility {
//public static void main(String[] args) throws IOException {
	public String getDatafromPropertiyfile(String key) throws IOException {
	FileInputStream fis=new FileInputStream("./CommonData/HMS.properties");
	Properties prop=new Properties();
	prop.load(fis);
	String data = prop.getProperty(key);
	
	return data;
	
	
}
}
