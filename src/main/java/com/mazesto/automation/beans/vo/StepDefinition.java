package com.mazesto.automation.beans.vo;

import org.openqa.selenium.WebDriver;

import com.mazesto.automation.commons.ThreadConfigurationJobMapper;

public class StepDefinition {

	protected WebDriver driver = null;

	public StepDefinition() {
		driver = ThreadConfigurationJobMapper.getConfigurationJob(Thread.currentThread()).getConfigurationJobData()
				.getDriver();

	}

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

}
