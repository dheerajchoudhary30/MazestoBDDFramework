package com.mazesto.automation.beans.fileparser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.mazesto.automation.beans.Configuration;
import com.mazesto.automation.beans.ConfigurationJob;
import com.mazesto.automation.beans.Suite;
import com.mazesto.automation.commons.Executor;
import com.mazesto.automation.commons.GlobalConstants;
import com.mazesto.automation.commons.ThreadTestDataMapper;

public class XMLFileParserImpl implements FileParser {
	
	private Executor executor = null;

	public XMLFileParserImpl() {
		System.out.println("Started project Mazesto BDD");
		System.out.println();
		System.out.println("Running Framework...");
		System.out.println();
		System.out.println(
				"$$        $$       $$        $$$$$$$$$$$  $$$$$$$$$$$  $$$$$$$$$$$  $$$$$$$$$$$$  $$$$$$$$$$$");
		System.out.println(
				"$$ $$  $$ $$     $$  $$              $$   $            $$                $$       $$       $$");
		System.out.println(
				"$$   $$   $$    $$ $$ $$         $$       $$$$$$$$$$$  $$$$$$$$$$$       $$       $$       $$");
		System.out.println(
				"$$        $$   $$      $$    $$           $                     $$       $$       $$       $$ ");
		System.out.println(
				"$$        $$  $$        $$  $$$$$$$$$$$   $$$$$$$$$$$  $$$$$$$$$$$       $$       $$$$$$$$$$$ ");

		System.out.println();

		System.out.println("$$$$$$$$$$$   $$$$$$$$$$$  $$$$$$$$$$$");
		System.out.println("  $$     $$     $$     $$    $$     $$");
		System.out.println("  $$$$$$$$$     $$     $$    $$     $$");
		System.out.println("  $$     $$     $$     $$    $$     $$");
		System.out.println("$$$$$$$$$$$   $$$$$$$$$$$  $$$$$$$$$$$");
		System.out.println();
		System.out.println();
	}

	public Suite parseFile(String fileName) {

		System.out.println("parsing execution file : " + fileName);
		Suite suite = null;

		try {

			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(System.getProperty("user.dir")+"\\"+
					fileName);
			doc.getDocumentElement().normalize();

			NodeList list = doc.getElementsByTagName(GlobalConstants.ConfigKey.SUITE_SETTINGS);
			Node nS = list.item(0);

			Element suiteSettingsElement = null;
			String reportingPath = null;
			String executionEnv = null;

			if (nS.getNodeType() == Node.ELEMENT_NODE) {

				suiteSettingsElement = (Element) nS;
				reportingPath = suiteSettingsElement.getElementsByTagName(GlobalConstants.ConfigKey.REPORT_PATH).item(0)
						.getTextContent();
				executionEnv = suiteSettingsElement.getElementsByTagName(GlobalConstants.ConfigKey.EXECUTION_ENV)
						.item(0).getTextContent();

			} else {
				System.err.println("Suite settings not properly defined!!\nSystem now Exits!!");
				System.exit(1);
			}

			ThreadTestDataMapper.addData(null, "executionEnv", executionEnv);
			
			executor = Executor.executorInstanceInit();
			
			suite = new Suite(reportingPath, executionEnv,executor);

			NodeList configurationsTags = doc.getElementsByTagName(GlobalConstants.ConfigKey.CONFIGURATIONS);

			Node configurationsNode = configurationsTags.item(0);

			Element configurationsElement = (Element) configurationsNode;

			NodeList configurationNodeList = configurationsElement
					.getElementsByTagName(GlobalConstants.ConfigKey.CONFIGURATION);

			for (int i = 0; i < configurationNodeList.getLength(); i++) {

				suite.getSuiteData().addConfiguration(getConfiguration(configurationNodeList.item(i)));
				
			}

		} catch (Exception e) {
			System.err.println(e.getMessage());
			System.err.println(Arrays.toString(e.getStackTrace()));
		}

		return suite;

	}

	private Configuration getConfiguration(Node configurationNode) {

		Element configurationNodeElement = null;
		Integer configID = null;
		boolean parallelSwitch = false;
		Integer configDegreeOfParallelism = null;

		Configuration config = null;

		try {
			if (configurationNode.getNodeType() == Node.ELEMENT_NODE) {

				configurationNodeElement = (Element) configurationNode;
				configID = Integer.parseInt(configurationNodeElement
						.getElementsByTagName(GlobalConstants.ConfigKey.CONFIG_ID).item(0).getTextContent());
				parallelSwitch = GlobalConstants.Characters.TRUE.equalsIgnoreCase(configurationNodeElement
						.getElementsByTagName(GlobalConstants.ConfigKey.PARALLEL_SWITCH_KEY).item(0).getTextContent())
								? true
								: false;
				configDegreeOfParallelism = Integer.parseInt(configurationNodeElement
						.getElementsByTagName(GlobalConstants.ConfigKey.PARALLEL_NUMBER_KEY).item(0).getTextContent());
				config = new Configuration(configID, parallelSwitch, configDegreeOfParallelism,executor);

				config.getConfigData().setConfigJobs(getConfigurationJobs(configurationNodeElement));

			} else {
				System.err.println("Suite settings not properly defined!!\nSystem now Exits!!");
				System.exit(1);
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
			System.err.println(Arrays.toString(e.getStackTrace()));
			System.err.println("There was an exception while parsing the configuration!");
			config = null;
		}

		return config;
	}

	private List<ConfigurationJob> getConfigurationJobs(Element configurationNodeElement) {

		List<ConfigurationJob> configJobList = new ArrayList<ConfigurationJob>();
		try {
			String browsersConfig = null;
			String featuresPath = null;
			String glue = null;
			String executionTags = null;
			ConfigurationJob configJob = null;

			browsersConfig = configurationNodeElement.getElementsByTagName(GlobalConstants.ConfigKey.BROWSERS).item(0)
					.getTextContent();

			if (browsersConfig == null || browsersConfig.trim().equals("")) {
				System.err.println("\\nBrowser configuration not found!!\\n Setting default browser \""
						+ GlobalConstants.Browsers.CHROME + "!!\n\n");
				browsersConfig = GlobalConstants.Browsers.CHROME;
			}

			List<String> browsers = Arrays.asList(browsersConfig.split(GlobalConstants.Characters.COMMA));
			featuresPath = configurationNodeElement.getElementsByTagName(GlobalConstants.ConfigKey.FEATURES_PATH)
					.item(0).getTextContent();
			glue = configurationNodeElement.getElementsByTagName(GlobalConstants.ConfigKey.GLUE).item(0)
					.getTextContent();
			executionTags = configurationNodeElement.getElementsByTagName(GlobalConstants.ConfigKey.EXECUTION_TAGS)
					.item(0).getTextContent();

			for (String browser : browsers) {
				configJob = new ConfigurationJob(browser, featuresPath, glue, executionTags);
				configJobList.add(configJob);
			}

		} catch (Exception e) {
			System.err.println(e.getMessage());
			System.err.println(Arrays.toString(e.getStackTrace()));
		}

		return configJobList;
	}

}
