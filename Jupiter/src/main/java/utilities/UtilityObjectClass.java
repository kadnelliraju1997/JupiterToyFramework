package utilities;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

public class UtilityObjectClass {

	private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();
	

	public static WebDriver getDriver() {
		return driver.get();
	}

	public static void setDriver(WebDriver actDriver) {
		driver.set(actDriver);
	}

	public static ExtentTest getExtentTest() {
		return extentTest.get();
	}

	public static void setExtentTest(ExtentTest actExtentTest) {
		extentTest.set(actExtentTest);
	}

	

}
