package com.mazesto.automation.helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;

import com.mazesto.automation.commons.GlobalConstants;
import com.mazesto.automation.commons.ThreadConfigurationJobMapper;
import com.mazesto.automation.commons.ThreadTestDataMapper;

public class WebDriverHelper {

	private WebDriverHelper() {

	}

	public static synchronized void initiateRequiredDrivers() {

		ThreadConfigurationJobMapper.getConfigurationJob(Thread.currentThread()).initializeDriver();

	}

	public static synchronized void destroyProcessedDrivers() {
		System.out.println();
		
//		System.err.println("Scenario: " + scenario.getGherkinName() + " is " + scenario.getStatus() + " on browser "
//				+ ThreadConfigurationJobMapper.getConfigurationJob(Thread.currentThread()).getConfigurationJobData()
//						.getBrowser());
//		
//		System.err.println("Destroying browser -  "
//				+ ThreadConfigurationJobMapper.getConfigurationJob(Thread.currentThread()).getConfigurationJobData()
//						.getBrowser() + " instance on thread : "+ Thread.currentThread());

		ThreadConfigurationJobMapper.getConfigurationJob(Thread.currentThread()).destroyDriver();
		ThreadTestDataMapper.flushData();

	}

	public static synchronized WebDriver getDriver(String browser) {

		switch (browser.trim().toLowerCase()) {

		case GlobalConstants.Browsers.CHROME: {

			System.setProperty(GlobalConstants.SystemProperty.CHROME_PROPERTY,
					GlobalConstants.DefaultDriverPath.DEFAULT_CHROME_PATH);

			ChromeOptions options = new ChromeOptions();
			options.addArguments("--ignore-certificate-errors");
			options.addArguments("--allow-running-insecure-content");
			options.addArguments("--disable-extensions");
			options.addArguments("start-maximized");
			options.addArguments("incognito");
			options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);

			return new ChromeDriver(options);

		}

		case GlobalConstants.Browsers.FIREFOX: {
			System.setProperty(GlobalConstants.SystemProperty.FIREFOX_PROPERTY,
					GlobalConstants.DefaultDriverPath.DEFAULT_FIREFOX_PATH);

			FirefoxOptions options = new FirefoxOptions();
			options.addArguments("--ignore-certificate-errors");
			options.addArguments("--allow-running-insecure-content");
			options.addArguments("--disable-extensions");
			options.addArguments("start-maximized");
			options.addArguments("incognito");

			options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);

			return new FirefoxDriver(options);
		}

		case GlobalConstants.Browsers.EDGE: {
			System.setProperty(GlobalConstants.SystemProperty.EDGE_PROPERTY,
					GlobalConstants.DefaultDriverPath.DEFAULT_EDGE_PATH);

			EdgeOptions options = new EdgeOptions();
			options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);

			return new EdgeDriver();
		}

		case GlobalConstants.Browsers.IE: {
			System.setProperty(GlobalConstants.SystemProperty.IE_PROPERTY,
					GlobalConstants.DefaultDriverPath.DEFAULT_IE_PATH);
			return new InternetExplorerDriver();
		}

		default: {
			return new ChromeDriver();
		}

		}

	}

	public static synchronized boolean isBrowserName(String browser) {
		return GlobalConstants.Browsers.CHROME.equalsIgnoreCase(browser.trim())
				|| GlobalConstants.Browsers.FIREFOX.equalsIgnoreCase(browser.trim())
				|| GlobalConstants.Browsers.IE.equalsIgnoreCase(browser.trim())
				|| GlobalConstants.Browsers.EDGE.equalsIgnoreCase(browser.trim());
	}

}
