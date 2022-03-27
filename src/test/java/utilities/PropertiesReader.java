package utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertiesReader {

	private static Properties configFile;

	static{
		try {
			String File1 = Constants.CONFIG_FILE;
			FileInputStream input1 = new FileInputStream(File1);
			configFile = new Properties();
			configFile.load(input1);
			input1.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String getProperty(String keyName) {
		return configFile.getProperty(keyName);
	}

}
