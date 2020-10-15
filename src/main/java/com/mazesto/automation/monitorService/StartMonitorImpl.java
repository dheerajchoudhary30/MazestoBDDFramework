package com.mazesto.automation.monitorService;

import java.util.List;

import com.mazesto.automation.beans.Configuration;
import com.mazesto.automation.helpers.ConfigurationRepository;

public class StartMonitorImpl implements ExecutionMonitor {

	private ConfigurationRepository configRepo = null;

	public StartMonitorImpl() {
		this.configRepo = ConfigurationRepository.getInstance();
	}

	@Override
	public Boolean call() throws Exception {

		System.out.println("Started StartMonitorImpl..");
		try {

			while (!configRepo.getConfigurations(0).isEmpty()) {

				synchronized (configRepo) {

					List<Configuration> configurations = configRepo.getConfigurations(0);

					for (Configuration confg : configurations) {

						Thread tConfg = new Thread(confg);
						tConfg.setName(confg.getConfigData().getConfigID().toString());
						System.out.println("Strting the configuration config ID : "+confg.getConfigData().getConfigID().toString());
						tConfg.start();

						configRepo.addConfiguration(tConfg, confg);
						configRepo.removeConfiguration(0, confg);

						break;

					}

				}

				Thread.sleep(5000);

			}

			System.err.println("Completed Start monitor!!");
			
		} catch (InterruptedException ie) {
			System.out.println("In Start Monitor : " + ie.getMessage());
			Thread.currentThread().interrupt();
		}
		return true;
	}

}
