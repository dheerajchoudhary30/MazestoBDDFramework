package com.mazesto.automation.beans;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.mazesto.automation.beans.vo.ConfigurationJobVO;
import com.mazesto.automation.commons.ThreadConfigurationJobMapper;
import com.mazesto.automation.helpers.WebDriverHelper;

import io.cucumber.core.cli.Main;

public class ConfigurationJob implements Runnable {

	private ConfigurationJobVO configurationJobData = null;

	public ConfigurationJob(String browser, String featuresPath, String glue, String executionTags) {
		configurationJobData = new ConfigurationJobVO(browser, featuresPath, glue, executionTags);
	}

	public synchronized void initializeDriver() {

		if (WebDriverHelper.isBrowserName(configurationJobData.getBrowser())) {
			configurationJobData.setDriver(WebDriverHelper.getDriver(configurationJobData.getBrowser()));
		}

	}

	public synchronized void destroyDriver() {

		if (configurationJobData.getDriver() != null) {
			configurationJobData.getDriver().quit();
			configurationJobData.setDriver(null);

		}
	}
	
	

	public ConfigurationJobVO getConfigurationJobData() {
		return configurationJobData;
	}

	public void setConfigurationJobData(ConfigurationJobVO configurationJobData) {
		this.configurationJobData = configurationJobData;
	}

	@Override
	public void run() {

		try {
			String[] argv = getArgv();

			ThreadConfigurationJobMapper.addConfigurationJob(Thread.currentThread(), this);

			Main.run(argv, Thread.currentThread().getContextClassLoader());
		} catch (Exception exception) {
			System.err.println(exception.getMessage());
			System.err.println(Arrays.toString(exception.getStackTrace()));
		}

	}

	public String[] getArgv() {
		List<String> argsList = new ArrayList<String>();
		String tags = configurationJobData.getExecutionTags();
		
		
		 argsList.add("-p"); argsList.add(
		 "com.mazesto.automation.listeners.ExtentCucumberAdapter:");
		 
		 argsList.add("-p"); argsList.add(
				 "html:target/cucumber-html-report");
		 
		 
		 
		if (configurationJobData.isGluePresent()) {
			argsList.add("-g");
			argsList.add(configurationJobData.getGlue());
		}

		if (configurationJobData.isExecutionTagsPresent()) {

			argsList.add("-t");
			argsList.add(tags);

		}

		argsList.add(configurationJobData.getFeaturesPath());
		
		

		return argsList.toArray(new String[argsList.size()]);
	}

}
