package com.mazesto.automation.beans;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

import com.mazesto.automation.beans.vo.ConfigurationVO;
import com.mazesto.automation.commons.Executor;
import com.mazesto.automation.helpers.ExecutionSchedulingHelper;

public class Configuration implements Runnable {

	private ConfigurationVO configdata = null;

	public Configuration(Integer configID, boolean parallelSwitch, Integer configDegreeOfParallelism,
			Executor executor) {

		configdata = new ConfigurationVO(configID, parallelSwitch, configDegreeOfParallelism, executor);

	}

	public ConfigurationVO getConfigData() {
		return configdata;
	}

	public void setConfigdata(ConfigurationVO configdata) {
		this.configdata = configdata;
	}

	@Override
	public void run() {

		ExecutionSchedulingHelper executionSchedulingHelper = new ExecutionSchedulingHelper(configdata.getConfigJobs(),
				configdata.getExecutor().getExecutorServiceInstance());
		List<Future<?>> result = executionSchedulingHelper.submitJobs();

		while (true) {

			boolean status = false;
			List<Boolean> results = result.stream().map(Future::isDone).collect(Collectors.toList());

			for (Boolean res : results) {
				if (!res) {
					status = true;
				}
			}

			if (!status) {

				System.err.println("Completed executing thread with ID " + configdata.getConfigID());
				break;

			}

			try {
				Thread.sleep(2000);
			} catch (InterruptedException e1) {
				System.err.println(e1.getMessage());
				System.err.println(Arrays.toString(e1.getStackTrace()));
				// Passing the interrupt to the calling class.
				Thread.currentThread().interrupt();
			}

		}

	}

}
