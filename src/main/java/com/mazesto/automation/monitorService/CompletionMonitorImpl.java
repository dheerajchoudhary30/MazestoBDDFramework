package com.mazesto.automation.monitorService;

import com.mazesto.automation.helpers.ConfigurationRepository;

public class CompletionMonitorImpl implements ExecutionMonitor {

	private ConfigurationRepository configRepo = null;

	public CompletionMonitorImpl() {
		this.configRepo = ConfigurationRepository.getInstance();
	}

	@Override
	public Boolean call() throws Exception {

		try {
			while (configRepo.getConfigurations(1).size() != configRepo.getNumberOfConfigurations()) {
				Thread.sleep(5000);
			}

			System.out.println("Process Completed successfully!!");
		} catch (InterruptedException ie) {
			System.out.println("In Completion Monitor : " + ie.getMessage());
			Thread.currentThread().interrupt();
		}
		return true;
	}

}
