package com.mazesto.automation.helpers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import java.util.stream.Collectors;

import com.mazesto.automation.beans.Configuration;

public class ConfigurationRepository {

	private static ConfigurationRepository configurationRepositoryInstance = new ConfigurationRepository();

	private List<Configuration> configurations = new Vector<Configuration>();
	private List<Configuration> completed = new Vector<Configuration>();
	private Map<Configuration, Thread> running = new HashMap<Configuration, Thread>();

	private Integer numberOfConfigurations = 0;

	private ConfigurationRepository() {

	}

	public static synchronized ConfigurationRepository getInstance() {
		return configurationRepositoryInstance;
	}

	public synchronized Map<Configuration, Thread> getConfigurations() {
		return running;
	}

	public synchronized Integer getNumberOfConfigurations() {
		return numberOfConfigurations;
	}

	public synchronized void addConfiguration(Integer queueIndex, Configuration configuration) {
		if (queueIndex == 0) {
			configurations.add(configuration);
			numberOfConfigurations++;
		} else {
			completed.add(configuration);
		}
	}

	public synchronized void addConfiguration(Thread thread, Configuration configuration) {
		running.put(configuration, thread);
	}

	public synchronized void removeConfiguration(Integer queueIndex, Configuration configuration) {
		if (queueIndex == 0) {
			configurations.remove(configuration);
			
		} else {
			completed.remove(configuration);
		}
	}

	public synchronized void removeConfiguration(Thread thread, Configuration configuration) {
		running.remove(configuration, thread);
	}

	public synchronized List<Configuration> getConfigurations(Integer queueIndex) {
		if (queueIndex == 0) {
			return configurations;

		} else {
			return completed;
		}
	}

	public synchronized boolean containsConfiguration(Integer queueIndex,Configuration configuration) {
		if (queueIndex == 0) {
			return configurations.contains(configuration);

		} else {
			return completed.contains(configuration);
		}
	}
	
	public synchronized boolean containsConfiguration(Configuration configuration) {
		List<Integer> list = running.keySet().stream().
				map(e->e.getConfigData().getConfigID()).collect(Collectors.toList());
	    return list.contains(configuration.getConfigData().getConfigID());
	
	}
	
	
	public synchronized List<Integer> getCompletedConfigIds() {
		List<Integer> list = completed.stream().
				map(e->e.getConfigData().getConfigID()).collect(Collectors.toList());
	    return list;
	
	}
}
