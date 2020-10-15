package com.mazesto.automation.beans;

import java.util.Arrays;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import com.mazesto.automation.beans.vo.SuiteVO;
import com.mazesto.automation.commons.Executor;
import com.mazesto.automation.commons.GlobalConstants;
import com.mazesto.automation.commons.TestDataMapper;
import com.mazesto.automation.commons.ThreadTestDataMapper;
import com.mazesto.automation.listeners.ExtentProperties;
import com.mazesto.automation.listeners.Reporter;
import com.mazesto.automation.monitorService.CompletionMonitorImpl;
import com.mazesto.automation.monitorService.RunningMonitorImpl;
import com.mazesto.automation.monitorService.StartMonitorImpl;

public class Suite {

	private SuiteVO suiteData = null;

	public Suite(String reportingPath, String executionEnv,Executor executor) {

		suiteData = new SuiteVO(reportingPath, executionEnv,executor);

	}

	public SuiteVO getSuiteData() {
		return suiteData;
	}

	public void setSuiteData(SuiteVO suiteData) {
		this.suiteData = suiteData;
	}

	public void execute() {

		System.out.println("Executing Suite ");
		
		ExtentProperties r = new ExtentProperties();
		
		String reportPath = System.getProperty("user.dir") + "\\reports\\test-output\\SparkReport";
		TestDataMapper.addData(GlobalConstants.ConfigKey.REPORT_PATH,reportPath);

		if (suiteData.getExecutionEnv() != null || suiteData.getExecutionEnv() != GlobalConstants.Characters.BLANK) {

			ThreadTestDataMapper.addData(null, GlobalConstants.ConfigKey.EXECUTION_ENV, suiteData.getExecutionEnv());

		} else {
			ThreadTestDataMapper.addData(null, GlobalConstants.ConfigKey.EXECUTION_ENV,
					GlobalConstants.DEFAULT_EXECUTION_ENVIORONMENT);
		}

		startup();
	}

	public void startup() {
		
		ExecutorService executorService = Executors.newFixedThreadPool(3);
		StartMonitorImpl startMonitorImpl = new StartMonitorImpl();
		RunningMonitorImpl runningMonitorImpl = new RunningMonitorImpl();
		CompletionMonitorImpl completionMonitorImpl = new CompletionMonitorImpl();
		
		
		Future<Boolean> isstartMonitorImplstatus = executorService.submit(startMonitorImpl);
		Future<Boolean> isrunningMonitorImplstatus = executorService.submit(runningMonitorImpl);
		Future<Boolean> iscompletionMonitorImplstatus=  executorService.submit(completionMonitorImpl);
		
		try {
			System.out.println("startMonitorCompletionStatus " + isstartMonitorImplstatus.get());
			System.out.println("runningMonitorCompletionStatus " + isrunningMonitorImplstatus.get());
			System.out.println("completionMonitorCompletionStatus " + iscompletionMonitorImplstatus.get());
			executorService.shutdownNow();
			suiteData.getExecutor().getExecutorServiceInstance().shutdownNow();
			Reporter.renameReportFile();
			System.err.println("Shutdown!!");
		} catch (InterruptedException e1) {
			System.err.println(e1.getMessage());
			System.err.println(Arrays.toString(e1.getStackTrace()));
			Thread.currentThread().interrupt();
			System.out.println("InterruptedException " + e1.getMessage());
		} catch (ExecutionException e1) {
			System.err.println(e1.getMessage());
			System.err.println(Arrays.toString(e1.getStackTrace()));
			System.out.println("ExecutionException " + e1.getMessage());
		}
		

	}


}
