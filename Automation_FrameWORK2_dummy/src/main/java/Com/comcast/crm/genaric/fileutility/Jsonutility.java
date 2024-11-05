package Com.comcast.crm.genaric.fileutility;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Jsonutility {
public String getDataFronJson(String key) throws FileNotFoundException, IOException, ParseException {
	JSONParser parser=new JSONParser();
	Object ref = parser.parse(new FileReader("./Jsondata/vtiger.json"));
	
	JSONObject map=(JSONObject)ref;
String data = map.get(key).toString();
	
	
	
	return data;
	
}
}
