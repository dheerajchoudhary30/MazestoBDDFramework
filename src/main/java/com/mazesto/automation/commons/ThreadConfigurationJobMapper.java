package com.mazesto.automation.commons;

import java.util.HashMap;
import java.util.Map;

import com.mazesto.automation.beans.ConfigurationJob;

public class ThreadConfigurationJobMapper {

	private ThreadConfigurationJobMapper() {

	}

	private static Map<Thread, ConfigurationJob> configurationsJobs = new HashMap<Thread, ConfigurationJob>();

	public static synchronized void addConfigurationJob(Thread currentThread, ConfigurationJob configJob) {

		synchronized (configurationsJobs) {
			configurationsJobs.put(currentThread, configJob);
		}

	}

	public static synchronized ConfigurationJob getConfigurationJob(Thread currentThread) {

		return configurationsJobs.get(currentThread);
	}

}
