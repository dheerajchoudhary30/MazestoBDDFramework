package com.mazesto.automation.listeners;

import java.io.File;
import java.io.IOException;



public class Reporter extends ExtentCucumberAdapter {

	public Reporter(String arg) {
		super(arg);
		// TODO Auto-generated constructor stub
	}

	public static void addStepLog(String message) {
		Reporter.addTestStepLog(message);
	}
	
	
	public static void renameReportFile() {
		// File (or directory) with old name
				File file = new File(System.getProperty("user.dir") + "\\reports\\test-output\\SparkReport\\Index.html");

				// File (or directory) with new name
				File file2 = new File(System.getProperty("user.dir") + "\\reports\\test-output\\SparkReport\\Index_" + System.getProperty("current.date")+".html");

				
				boolean success = file.renameTo(file2);

				if (!success) {
				
					System.err.println("Report is not named correctly with current time, please check Index.html");
					
				}
	}

}
