package com.mazesto.automation.monitorService;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import com.mazesto.automation.beans.Configuration;
import com.mazesto.automation.helpers.ConfigurationRepository;

public class RunningMonitorImpl implements ExecutionMonitor {

	private ConfigurationRepository configRepo = null;

	public RunningMonitorImpl() {
		this.configRepo = ConfigurationRepository.getInstance();
	}

	@Override
	public Boolean call() throws Exception {

		try {
			
			System.out.println("Total Completed confg : " +configRepo.getConfigurations(1).size());
			System.out.println();
			while (configRepo.getConfigurations(1).size() != configRepo.getNumberOfConfigurations()) {
				Map<Configuration, Thread> runningConfigs = configRepo.getConfigurations();
				Iterator<Entry<Configuration, Thread>> it = runningConfigs.entrySet().iterator();

				while (it.hasNext()) {

					Entry<Configuration, Thread> item = it.next();
					if (!item.getValue().isAlive()) {
						System.err.println(
								"****Running Configuration having Config: " + item.getValue().getName() + " is Not Alive");
					}

					if (!item.getValue().isAlive()) {
						synchronized (configRepo) {
							configRepo.addConfiguration(1, item.getKey());
							it.remove();
						}
					}
				}

				Thread.sleep(50);

			}

			System.out.println("Completed Running monitor!!");
		} catch (InterruptedException ie) {
			System.out.println("In Running Monitor : " + ie.getMessage());
			Thread.currentThread().interrupt();
		}
		return true;
	}

}
