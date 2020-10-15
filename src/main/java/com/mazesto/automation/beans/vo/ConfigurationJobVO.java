package com.mazesto.automation.beans.vo;

import org.openqa.selenium.WebDriver;

import com.mazesto.automation.commons.GlobalConstants;

public class ConfigurationJobVO {

	private String browser;
	private String featuresPath;
	private String glue;
	private String executionTags;
	private WebDriver driver = null;
	private boolean isGluePresent;
	private boolean isExecutionTagsPresent;

	public ConfigurationJobVO(String browser, String featuresPath, String glue, String executionTags) {
		super();
		this.browser = browser;
		this.featuresPath = featuresPath;

		if (glue != null || GlobalConstants.Characters.BLANK.equals(glue)) {
			this.glue = glue;
			isGluePresent = true;
		}

		if (glue != null || GlobalConstants.Characters.BLANK.equals(glue)) {
			this.executionTags = executionTags;
			isExecutionTagsPresent = true;
		}

	}

	public boolean isExecutionTagsPresent() {
		return isExecutionTagsPresent;
	}

	public void setExecutionTagsPresent(boolean isExecutionTagsPresent) {
		this.isExecutionTagsPresent = isExecutionTagsPresent;
	}

	public boolean isGluePresent() {
		return isGluePresent;
	}

	public void setGluePresent(boolean isGluePresent) {
		this.isGluePresent = isGluePresent;
	}

	public String getBrowser() {
		return browser;
	}

	public void setBrowser(String browser) {
		this.browser = browser;
	}

	public String getFeaturesPath() {
		return featuresPath;
	}

	public void setFeaturesPath(String featuresPath) {
		this.featuresPath = featuresPath;
	}

	public String getGlue() {
		return glue;
	}

	public void setGlue(String glue) {
		this.glue = glue;
	}

	public String getExecutionTags() {
		return executionTags;
	}

	public void setExecutionTags(String executionTags) {
		this.executionTags = executionTags;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((browser == null) ? 0 : browser.hashCode());
		result = prime * result + ((executionTags == null) ? 0 : executionTags.hashCode());
		result = prime * result + ((featuresPath == null) ? 0 : featuresPath.hashCode());
		result = prime * result + ((glue == null) ? 0 : glue.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ConfigurationJobVO other = (ConfigurationJobVO) obj;
		if (browser == null) {
			if (other.browser != null)
				return false;
		} else if (!browser.equals(other.browser))
			return false;
		if (executionTags == null) {
			if (other.executionTags != null)
				return false;
		} else if (!executionTags.equals(other.executionTags))
			return false;
		if (featuresPath == null) {
			if (other.featuresPath != null)
				return false;
		} else if (!featuresPath.equals(other.featuresPath))
			return false;
		if (glue == null) {
			if (other.glue != null)
				return false;
		} else if (!glue.equals(other.glue))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ConfigurationJobVO [browser=" + browser + ", featuresPath=" + featuresPath + ", glue=" + glue
				+ ", executionTags=" + executionTags + "]";
	}

}
