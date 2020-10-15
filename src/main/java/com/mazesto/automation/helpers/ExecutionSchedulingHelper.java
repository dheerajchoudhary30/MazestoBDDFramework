package com.mazesto.automation.helpers;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

import com.mazesto.automation.beans.ConfigurationJob;

public class ExecutionSchedulingHelper {

	private List<ConfigurationJob> jobs = null;

	private ExecutorService executorServiceInstance = null;

	public ExecutionSchedulingHelper(List<ConfigurationJob> jobs, ExecutorService executorServiceInstance) {
		this.jobs = jobs;
		this.executorServiceInstance = executorServiceInstance;
	}

	public List<Future<?>> submitJobs() {

		List<Future<?>> result = new ArrayList<Future<?>>();
		if (jobs != null && !jobs.isEmpty()) {

			for (ConfigurationJob job : jobs) {
				System.out.println("Submitting a config job :"  + job.getConfigurationJobData().getExecutionTags());
				Future<?> resJob = executorServiceInstance.submit(job);
				result.add(resJob);
			}

		} else {
			System.err.println(
					"************************************\njobs Not Parsed\n************************************");
		}

		return result;

	}

}
