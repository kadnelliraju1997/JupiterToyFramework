package utilities;

import java.io.FileInputStream;
import java.util.Properties;


public class FileUtility {

	public String getDataFromPropertyFile(String key) throws Throwable {
		FileInputStream fis=new FileInputStream("C:\\Users\\Admin\\eclips-eclipse\\Jupiter\\src\\test\\resources\\CommonData.properties");
		Properties p=new Properties();
		p.load(fis);
		String data = p.getProperty(key);
		return data;
		
	}
}
