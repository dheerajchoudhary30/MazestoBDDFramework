package com.mazesto.automation.commons;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestDataMapper {

	private TestDataMapper() {

	}

	private static Map<String, String> testDataS = new HashMap<String, String>();
	private static Map<String, List<String>> testDataL = new HashMap<String, List<String>>();
	private static Map<String, Map<String, String>> testDataM = new HashMap<String, Map<String, String>>();

	public static synchronized void addData(String key, String value) {

		synchronized (testDataS) {

			testDataS.put(key, value);
			
		}

	}

	public static String getData(String key) {

		return testDataS.get(key) != null ? testDataS.get(key)
				: "###Did not find Value for key " + key;

	}

	public static synchronized void addData(String key, List<String> value) {

		synchronized (testDataL) {

			testDataL.put(key, value);
		}

	}

	public static List<String> getDataofList(String key) {

		List<String> tempList = new ArrayList<String>();
		tempList.add("###DID NOT FIND VALUE FOR " + key);
		return testDataL.get(key) != null ? testDataL.get(key) : tempList;

	}

	public static synchronized void addData(String key, Map<String, String> value) {

		synchronized (testDataM) {
		
			testDataM.put(key, value);
		}

	}

	public static Map<String, String> getDataOfMap( String key) {

		Map<String, String> tempData = new HashMap<String, String>();
		tempData.put("#DID NOT FIND KEY", key);

		return testDataM.get(key) != null ? testDataM.get(key) : tempData;

	}

	

}
