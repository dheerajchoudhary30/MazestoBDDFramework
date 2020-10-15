package com.mazesto.automation.listeners;

public class ExtentProperties {

	public ExtentProperties() {
	System.setProperty("extent.reporter.html.start","true");
	//System.setProperty("extent.reporter.html.config","src/test/resources/extent-config.xml");
	System.setProperty("extent.reporter.html.out","reports/cucumber-reports/advanced-reports/extentreports/extent.html");
	System.setProperty("extent.reporter.html.start","true");
	//System.setProperty("extent.reporter.html.config","src/test/resources/extent-config.xml");
	System.setProperty("extent.reporter.html.out","reports/test-output/SparkReport/Index.html");
	  
	System.setProperty("json-reporter extent.reporter.json.start","false");
	System.setProperty("extent.reporter.json.out","reports/test-output/JsonReport/Json.json");
	  
	System.setProperty("screenshot.dir","reports/test-output/");
	System.setProperty("screenshot.rel.path","../");
	}

}
