package com.mazesto.automation.commons;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ThreadTestDataMapper {

	private ThreadTestDataMapper() {

	}

	private static Map<Thread, Map<String, String>> testDataS = new HashMap<Thread, Map<String, String>>();
	private static Map<Thread, Map<String, List<String>>> testDataL = new HashMap<Thread, Map<String, List<String>>>();
	private static Map<Thread, Map<String, Map<String, String>>> testDataM = new HashMap<Thread, Map<String, Map<String, String>>>();

	public static synchronized void addData(Thread currentThread, String key, String value) {

		synchronized (testDataS) {

			Map<String, String> tempData = new HashMap<String, String>();

			if (currentThread != null) {

				if (testDataS.get(currentThread) != null) {
					tempData.putAll(testDataS.get(currentThread));
				}

				
			}
			
			tempData.put(key, value);
			testDataS.put(currentThread, tempData);
		}

	}

	public static String getData(Thread currentThread, String key) {

		return testDataS.get(currentThread).get(key) != null ? testDataS.get(currentThread).get(key)
				: "###Did not find Value for key " + key;

	}

	public static synchronized void addData(Thread currentThread, String key, List<String> value) {

		synchronized (testDataL) {

			Map<String, List<String>> tempData = new HashMap<String, List<String>>();

			if (currentThread != null) {

				if (testDataL.get(currentThread) != null) {
					tempData.putAll(testDataL.get(currentThread));
				}

				
			}
			tempData.put(key, value);
			testDataL.put(currentThread, tempData);
		}

	}

	public static List<String> getDataofList(Thread currentThread, String key) {

		List<String> tempList = new ArrayList<String>();
		tempList.add("###DID NOT FIND VALUE FOR " + key);
		return testDataL.get(currentThread).get(key) != null ? testDataL.get(currentThread).get(key) : tempList;

	}

	public static synchronized void addData(Thread currentThread, String key, Map<String, String> value) {

		synchronized (testDataM) {

			Map<String, Map<String, String>> tempData = new HashMap<String, Map<String, String>>();

			if (currentThread != null) {

				if (testDataM.get(currentThread) != null) {
					tempData.putAll(testDataM.get(currentThread));
				}

				
			}
			
			tempData.put(key, value);
			testDataM.put(currentThread, tempData);
		}

	}

	public static Map<String, String> getDataOfMap(Thread currentThread, String key) {

		Map<String, String> tempData = new HashMap<String, String>();
		tempData.put("#DID NOT FIND KEY", key);

		return testDataM.get(currentThread).get(key) != null ? testDataM.get(currentThread).get(key) : tempData;

	}

	public static synchronized void flushData() {
		synchronized (testDataS) {
			synchronized (testDataL) {
				synchronized (testDataM) {
		
		
			testDataS.remove(Thread.currentThread());
			testDataL.remove(Thread.currentThread());
			testDataM.remove(Thread.currentThread());
				}
			}
			
			
		}
		
	}

}
