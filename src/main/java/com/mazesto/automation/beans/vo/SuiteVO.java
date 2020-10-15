package com.mazesto.automation.beans.vo;

import java.util.ArrayList;
import java.util.List;

import com.mazesto.automation.beans.Configuration;
import com.mazesto.automation.commons.Executor;
import com.mazesto.automation.helpers.ConfigurationRepository;

public class SuiteVO {
	
	
	private String reportingPath;
	private String executionEnv;
	private List<Configuration> configurationList = new ArrayList<Configuration>();
	private int numberOfConfigurations = 0;
	private Executor executor = null;
	
	
	public int getNumberOfConfigurations() {
		return numberOfConfigurations;
	}

	public String getReportingPath() {
		return reportingPath;
	}

	public void setReportingPath(String reportingPath) {
		this.reportingPath = reportingPath;
	}

	public String getExecutionEnv() {
		return executionEnv;
	}

	public void setExecutionEnv(String executionEnv) {
		this.executionEnv = executionEnv;
	}

	
	
	public Executor getExecutor() {
		return executor;
	}

	public void setExecutor(Executor executor) {
		this.executor = executor;
	}

	public List<Configuration> getConfigurationList() {
		return configurationList;
	}

	public void setConfigurationList(List<Configuration> configurationList) {
		this.configurationList = configurationList;
	}

	public SuiteVO(String reportingPath, String executionEnv, Executor executor) {
		
		setReportingPath(reportingPath);
		setExecutionEnv(executionEnv);
		setExecutor(executor);
	}

	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((executionEnv == null) ? 0 : executionEnv.hashCode());
		result = prime * result + ((reportingPath == null) ? 0 : reportingPath.hashCode());
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
		SuiteVO other = (SuiteVO) obj;
		if (executionEnv == null) {
			if (other.executionEnv != null)
				return false;
		} else if (!executionEnv.equals(other.executionEnv))
			return false;
		if (reportingPath == null) {
			if (other.reportingPath != null)
				return false;
		} else if (!reportingPath.equals(other.reportingPath))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "SuiteVO [reportingPath=" + reportingPath + ", executionEnv=" + executionEnv + "]";
	}
	
	
	public void addConfiguration(Configuration configuration) {
		
		configurationList.add(configuration);
		ConfigurationRepository.getInstance().addConfiguration(0, configuration);
		numberOfConfigurations++;
	}

}
