package com.mazesto.automation.commons;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Executor {

	private Executor() {

	}

	private static Executor classInstance = null;
	private static ExecutorService executorServiceInstance = null;

	public static synchronized Executor executorInstanceInit() {
		if (classInstance == null && executorServiceInstance == null) {
			executorServiceInstance = Executors.newFixedThreadPool(20);
			classInstance = new Executor();

		}

		return classInstance;
	}

	
	public synchronized ExecutorService getExecutorServiceInstance() {
		return executorServiceInstance;
	}
	
}
