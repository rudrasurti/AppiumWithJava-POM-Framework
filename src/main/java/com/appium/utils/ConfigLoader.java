/**
 * @author Rudra Surti

 */

/***************************************************/

package com.appium.utils;

import java.util.Properties;

import org.apache.commons.lang3.StringUtils;

import static com.appium.constants.FrameworkConstants.RESOURCES_MAIN_PATH;

/*Singleton Design pattern*/
public class ConfigLoader {

	private static final String SEND_EMAIL_TO_USERS = "send_email_to_users";
	private static final String OVERRIDE_REPORTS = "override_reports";
	private static final String SKIPPED_STEPS_SCREENSHOT = "skipped_steps_screenshot";
	private static final String PASSED_STEPS_SCREENSHOT = "passed_steps_screenshot";
	private static final String FAILED_STEPS_SCREENSHOT = "failed_steps_screenshot";
	private static final String RETRY_FAILED_TESTS = "retry_failed_tests";
	private static final String WARN_STEPS_SCREENSHOT = "warn_steps_screenshot";

	

	private static final String FAILED_TESTS_VIDEO = "failed_tests_video";
	private static final String RECORD_ALL_VIDEO = "record_all_video";

	private static final String APPIUM_URL = "appiumURL";
	private static final String ANDROID_AUTOMATION_NAME = "androidAutomationName";
	private static final String ANDROID_APP_PACKAGE = "androidAppPackage";
	private static final String ANDROID_APP_ACTIVITY = "androidAppActivity";
	private static final String ANDROID_APP_LOCATION = "androidAppLocation";

	private static final String iOS_AUTOMATION_NAME = "iOSAutomationName";
	private static final String iOS_BUNDLE_ID = "iOSBundleId";
	private static final String iOS_APP_LOCATION = "iOSAppLocation";

	private static final String Browserstack_USERNAME = "browserstackUsername";
	private static final String Browserstack_AUTOMATE_KEY = "browserstackAutomateKey";
	private static final String Browserstack_APP_LOCATION = "browserstackAppLocation";
	private static final String Browserstack_APP_UPLOAD = "apkUpload";

	private static final String CONFIG_PROPERTIES = "config.properties";

	private Properties properties;

	private static ConfigLoader configLoader;

	private ConfigLoader() {
		properties = getConfigPropertyFile(CONFIG_PROPERTIES);
	}

	private Properties getConfigPropertyFile(String configFile) {
		return PropertyUtils.propertyLoader(RESOURCES_MAIN_PATH + configFile);
	}

	private String getPropertyValue(String propertyKey) {
		String prop = properties.getProperty(propertyKey);
		if (prop != null) {
			return prop.trim();
		} else {
			throw new RuntimeException("Property " + propertyKey + " is not specified in the config.properties file");
		}
	}

	public static ConfigLoader getInstance() {
		if (configLoader == null) {
			configLoader = new ConfigLoader();
		}
		return configLoader;
	}

	public String getAppiumURL() {
		return getPropertyValue(APPIUM_URL);
	}

	public String getAndroidAutomationName() {
		return getPropertyValue(ANDROID_AUTOMATION_NAME);
	}

	public String getAndroidAppPackage() {
		return getPropertyValue(ANDROID_APP_PACKAGE);
	}

	public String getAndroidAppActivity() {
		return getPropertyValue(ANDROID_APP_ACTIVITY);
	}

	public String getAndroidApplocation() {
		if (StringUtils.isNotBlank(System.getProperty("androidAppLocation"))) {
			return System.getProperty("androidAppLocation");
		}
		return getPropertyValue(ANDROID_APP_LOCATION);
	}

	public String getiOSAutomationName() {
		return getPropertyValue(iOS_AUTOMATION_NAME);
	}

	public String getiOSBundleID() {
		return getPropertyValue(iOS_BUNDLE_ID);
	}

	public String getiOSAppLocation() {
		return getPropertyValue(iOS_APP_LOCATION);
	}

	public String getFailedStepsScreenshot() {
		return getPropertyValue(FAILED_STEPS_SCREENSHOT);
	}
	
	public String getWarnStepsScreenshot() {
	    return getPropertyValue(WARN_STEPS_SCREENSHOT);
	}


	public String getPassedStepsScreenshot() {
		return getPropertyValue(PASSED_STEPS_SCREENSHOT);
	}

	public String getSkippedStepsScreenshot() {
		return getPropertyValue(SKIPPED_STEPS_SCREENSHOT);
	}

	public String getRetryFailedTests() {
		return getPropertyValue(RETRY_FAILED_TESTS);
	}

	public String getOverrideReports() {
		return getPropertyValue(OVERRIDE_REPORTS);
	}

	public String getSendEmailToUsers() {
		return getPropertyValue(SEND_EMAIL_TO_USERS);
	}

	public String getFailedTestsVideo() {
		return getPropertyValue(FAILED_TESTS_VIDEO);
	}
	
	public String getRecordAllVideo() {
		return getPropertyValue(RECORD_ALL_VIDEO);
	}

	public String getBrowserstackUsername() {
		return getPropertyValue(Browserstack_USERNAME);
	}

	public String getBrowserstackAutomateKey() {
		return getPropertyValue(Browserstack_AUTOMATE_KEY);
	}

	public String getBrowserstackApplocation() {
		return getPropertyValue(Browserstack_APP_LOCATION);
	}

	public String getBrowserstackAppUploadOrNot() {
		return getPropertyValue(Browserstack_APP_UPLOAD);
	}

	
}
