package com.mazesto.automation.commons;

public class GlobalConstants {

	public static final String DEFAULT_EXECUTION_ENVIORONMENT = "MQA";

	private GlobalConstants() {

	}

	
	public static class DefaultDriverPath {
		private DefaultDriverPath() {

		}

		public static final String DEFAULT_CHROME_PATH = System.getProperty("user.dir") + "\\src\\main\\resources\\DefaultDrivers\\chromedriver.exe";
		public static final String DEFAULT_FIREFOX_PATH = System.getProperty("user.dir") + "\\src\\main\\resources\\DefaultDrivers\\geckodriver.exe";
		public static final String DEFAULT_IE_PATH = System.getProperty("user.dir") + "\\src\\main\\resources\\DefaultDrivers\\IEDriverServer.exe";
		public static final String DEFAULT_EDGE_PATH = System.getProperty("user.dir") + "\\src\\main\\resources\\DefaultDrivers\\msedgedriver.exe";

	}
	
	
	public static class SystemProperty {
		private SystemProperty() {

		}

		public static final String CHROME_PROPERTY = "webdriver.chrome.driver";
		public static final String FIREFOX_PROPERTY = "webdriver.gecko.driver";
		public static final String IE_PROPERTY = "webdriver.ie.driver";
		public static final String EDGE_PROPERTY = "webdriver.edge.driver";

	}

	public static class Browsers {
		private Browsers() {

		}

		public static final String CHROME = "chrome";
		public static final String FIREFOX = "firefox";
		public static final String EDGE = "edge";
		public static final String IE = "ie";

	}

	public static class ConfigKey {
		private ConfigKey() {

		}

		public static final String REPORT_PATH = "reportingPath";
		public static final String EXECUTION_ENV = "executionEnv";
		public static final String CONFIG_ID = "configID";
		public static final String BROWSERS = "browsers";
		public static final String FEATURES_PATH = "featuresPath";
		public static final String GLUE = "glue";
		public static final String PARALLEL_SWITCH_KEY = "parallelSwitch";
		public static final String PARALLEL_NUMBER_KEY = "degreeOfParallelism";
		public static final String CONFIGURATION = "Configuration";
		public static final String CONFIGURATIONS = "Configurations";
		public static final String SUITE_SETTINGS = "suiteSettings";
		public static final String EXECUTION_TAGS = "tags";
	}

	public static class Characters {
		private Characters() {

		}

		public static final String TRUE = "true";
		public static final String FALSE = "false";
		public static final String COMMA = ",";
		public static final String BLANK = "";

	}
	
	
	public static class ConsoleColors {
		
		private ConsoleColors() {
			
		}
	    // Reset
	    public static final String RESET = "\033[0m";  // Text Reset

	    // Regular Colors
	    public static final String BLACK = "\033[0;30m";   // BLACK
	    public static final String RED = "\033[0;31m";     // RED
	    public static final String GREEN = "\033[0;32m";   // GREEN
	    public static final String YELLOW = "\033[0;33m";  // YELLOW
	    public static final String BLUE = "\033[0;34m";    // BLUE
	    public static final String PURPLE = "\033[0;35m";  // PURPLE
	    public static final String CYAN = "\033[0;36m";    // CYAN
	    public static final String WHITE = "\033[0;37m";   // WHITE

	    // Bold
	    public static final String BLACK_BOLD = "\033[1;30m";  // BLACK
	    public static final String RED_BOLD = "\033[1;31m";    // RED
	    public static final String GREEN_BOLD = "\033[1;32m";  // GREEN
	    public static final String YELLOW_BOLD = "\033[1;33m"; // YELLOW
	    public static final String BLUE_BOLD = "\033[1;34m";   // BLUE
	    public static final String PURPLE_BOLD = "\033[1;35m"; // PURPLE
	    public static final String CYAN_BOLD = "\033[1;36m";   // CYAN
	    public static final String WHITE_BOLD = "\033[1;37m";  // WHITE

	    // Underline
	    public static final String BLACK_UNDERLINED = "\033[4;30m";  // BLACK
	    public static final String RED_UNDERLINED = "\033[4;31m";    // RED
	    public static final String GREEN_UNDERLINED = "\033[4;32m";  // GREEN
	    public static final String YELLOW_UNDERLINED = "\033[4;33m"; // YELLOW
	    public static final String BLUE_UNDERLINED = "\033[4;34m";   // BLUE
	    public static final String PURPLE_UNDERLINED = "\033[4;35m"; // PURPLE
	    public static final String CYAN_UNDERLINED = "\033[4;36m";   // CYAN
	    public static final String WHITE_UNDERLINED = "\033[4;37m";  // WHITE

	    // Background
	    public static final String BLACK_BACKGROUND = "\033[40m";  // BLACK
	    public static final String RED_BACKGROUND = "\033[41m";    // RED
	    public static final String GREEN_BACKGROUND = "\033[42m";  // GREEN
	    public static final String YELLOW_BACKGROUND = "\033[43m"; // YELLOW
	    public static final String BLUE_BACKGROUND = "\033[44m";   // BLUE
	    public static final String PURPLE_BACKGROUND = "\033[45m"; // PURPLE
	    public static final String CYAN_BACKGROUND = "\033[46m";   // CYAN
	    public static final String WHITE_BACKGROUND = "\033[47m";  // WHITE

	    // High Intensity
	    public static final String BLACK_BRIGHT = "\033[0;90m";  // BLACK
	    public static final String RED_BRIGHT = "\033[0;91m";    // RED
	    public static final String GREEN_BRIGHT = "\033[0;92m";  // GREEN
	    public static final String YELLOW_BRIGHT = "\033[0;93m"; // YELLOW
	    public static final String BLUE_BRIGHT = "\033[0;94m";   // BLUE
	    public static final String PURPLE_BRIGHT = "\033[0;95m"; // PURPLE
	    public static final String CYAN_BRIGHT = "\033[0;96m";   // CYAN
	    public static final String WHITE_BRIGHT = "\033[0;97m";  // WHITE

	    // Bold High Intensity
	    public static final String BLACK_BOLD_BRIGHT = "\033[1;90m"; // BLACK
	    public static final String RED_BOLD_BRIGHT = "\033[1;91m";   // RED
	    public static final String GREEN_BOLD_BRIGHT = "\033[1;92m"; // GREEN
	    public static final String YELLOW_BOLD_BRIGHT = "\033[1;93m";// YELLOW
	    public static final String BLUE_BOLD_BRIGHT = "\033[1;94m";  // BLUE
	    public static final String PURPLE_BOLD_BRIGHT = "\033[1;95m";// PURPLE
	    public static final String CYAN_BOLD_BRIGHT = "\033[1;96m";  // CYAN
	    public static final String WHITE_BOLD_BRIGHT = "\033[1;97m"; // WHITE

	    // High Intensity backgrounds
	    public static final String BLACK_BACKGROUND_BRIGHT = "\033[0;100m";// BLACK
	    public static final String RED_BACKGROUND_BRIGHT = "\033[0;101m";// RED
	    public static final String GREEN_BACKGROUND_BRIGHT = "\033[0;102m";// GREEN
	    public static final String YELLOW_BACKGROUND_BRIGHT = "\033[0;103m";// YELLOW
	    public static final String BLUE_BACKGROUND_BRIGHT = "\033[0;104m";// BLUE
	    public static final String PURPLE_BACKGROUND_BRIGHT = "\033[0;105m"; // PURPLE
	    public static final String CYAN_BACKGROUND_BRIGHT = "\033[0;106m";  // CYAN
	    public static final String WHITE_BACKGROUND_BRIGHT = "\033[0;107m";   // WHITE
	}

}
