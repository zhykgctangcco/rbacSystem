package cn.kgc.tangcco.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtils {

	private static PropertiesUtils utils;
	private static Properties properties;
	private  PropertiesUtils() {
		properties = new Properties();
		InputStream in = this.getClass().getResourceAsStream("/applicationContext.properties");
		try {
			properties.load(in);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static String getValue(String key) {
		String value = properties.getProperty(key);
		return value;
	}
	public static PropertiesUtils  getInstance() {
		
		if(utils==null) {
			utils = new PropertiesUtils();
		}
		return utils;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
