package cn.kgc.tangcco.util;

import java.util.HashMap;
import java.util.Map;

public class PropertiesFactory {

	private static Map<String, Object> map = new HashMap<>();
	
	
	public static Object getInstance(String key) {
		Object obj = null;
		String value = PropertiesUtils.getInstance().getValue(key);
		try {
			if(map.containsKey(key)) {
				obj = map.get(key);
			}else {
				obj = Class.forName(value).newInstance();
				map.put(key, obj);
			}
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return obj;
	}
	
	
	
	
}
