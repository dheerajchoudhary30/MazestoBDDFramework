package com.mazesto.automation.beans.vo;

import java.util.ArrayList;
import java.util.List;

import com.mazesto.automation.beans.ConfigurationJob;
import com.mazesto.automation.commons.Executor;

public class ConfigurationVO {

	private Integer configID = -1;
	private boolean parallelSwitch = false;
	private Integer configDegreeOfParallelism = -1;
	private List<ConfigurationJob> configJobs = new ArrayList<ConfigurationJob>();
	private Executor executor = null;
	
	
	public ConfigurationVO(Integer configID, boolean parallelSwitch, Integer configDegreeOfParallelism,Executor executor) {
		super();
		this.configID = configID;
		this.parallelSwitch = parallelSwitch;
		this.configDegreeOfParallelism = configDegreeOfParallelism;
		this.executor = executor;
	}


	public Integer getConfigID() {
		return configID;
	}


	public void setConfigID(Integer configID) {
		this.configID = configID;
	}

	

	public Executor getExecutor() {
		return executor;
	}


	public void setExecutor(Executor executor) {
		this.executor = executor;
	}


	public boolean isParallelSwitch() {
		return parallelSwitch;
	}


	public void setParallelSwitch(boolean parallelSwitch) {
		this.parallelSwitch = parallelSwitch;
	}


	public Integer getConfigDegreeOfParallelism() {
		return configDegreeOfParallelism;
	}


	public void setConfigDegreeOfParallelism(Integer configDegreeOfParallelism) {
		this.configDegreeOfParallelism = configDegreeOfParallelism;
	}


	public List<ConfigurationJob> getConfigJobs() {
		return configJobs;
	}


	public void setConfigJobs(List<ConfigurationJob> configJobs) {
		this.configJobs = configJobs;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((configDegreeOfParallelism == null) ? 0 : configDegreeOfParallelism.hashCode());
		result = prime * result + ((configID == null) ? 0 : configID.hashCode());
		result = prime * result + ((configJobs == null) ? 0 : configJobs.hashCode());
		result = prime * result + (parallelSwitch ? 1231 : 1237);
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
		ConfigurationVO other = (ConfigurationVO) obj;
		if (configDegreeOfParallelism == null) {
			if (other.configDegreeOfParallelism != null)
				return false;
		} else if (!configDegreeOfParallelism.equals(other.configDegreeOfParallelism))
			return false;
		if (configID == null) {
			if (other.configID != null)
				return false;
		} else if (!configID.equals(other.configID))
			return false;
		if (configJobs == null) {
			if (other.configJobs != null)
				return false;
		} else if (!configJobs.equals(other.configJobs))
			return false;
		if (parallelSwitch != other.parallelSwitch)
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "ConfigurationVO [configID=" + configID + ", parallelSwitch=" + parallelSwitch
				+ ", configDegreeOfParallelism=" + configDegreeOfParallelism + ", configJobs=" + configJobs + "]";
	}


}
