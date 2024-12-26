package utilities;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ListenerImplementationClass extends BaseClass implements ITestListener, ISuiteListener {
	JavaUtility javaUtility = new JavaUtility();
	public ExtentSparkReporter sparkReporter;
	public ExtentReports extentReports;
	public ExtentTest extentTestReport;

	@Override
	public void onStart(ISuite suite) {
		JavaUtility javaUtility = new JavaUtility();
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter("./Execution_Reports/MyReport" + "_" +javaUtility.getSystemDateYYYYMMDD()+ ".html"
				+ javaUtility.getSystemDateYYYYMMDD() + ".html");
		sparkReporter.config().setDocumentTitle("Test Report");
		sparkReporter.config().setReportName("JupiterToy Project Automation Suite Report");
		sparkReporter.config().setTheme(com.aventstack.extentreports.reporter.configuration.Theme.DARK);
		extentReports = new ExtentReports();
		extentReports.attachReporter(sparkReporter);
		extentReports.setSystemInfo("Customer Name", "Jupiter Toy");
		extentReports.setSystemInfo("Environment", "Production");

		extentReports.setSystemInfo("Browser Name", "Chrome");
		extentReports.setSystemInfo("User", "Raju");
		

	}

	@Override
	public void onFinish(ISuite suite) {
		extentReports.flush();
	}

	@Override
	public void onTestStart(ITestResult result) {
		String testName = result.getMethod().getMethodName();
		extentTestReport=extentReports.createTest(testName);
		UtilityObjectClass.setExtentTest(extentTestReport);
		UtilityObjectClass.getExtentTest().assignAuthor("Raju");
		UtilityObjectClass.getExtentTest().assignCategory("Generic Test Scripts");

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		UtilityObjectClass.getExtentTest().log(Status.PASS, "Test Passed");
	}

	@Override
	public void onTestFailure(ITestResult result){
		String testName = result.getMethod().getMethodName();
		WebDriverUtility wLib=new WebDriverUtility();
		UtilityObjectClass.getExtentTest().log(Status.FAIL, "Test Failed: ");
		String screenshotPath = wLib.getScreenShot(sessionDriver, testName);
		UtilityObjectClass.getExtentTest().addScreenCaptureFromBase64String(screenshotPath,testName);
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		UtilityObjectClass.getExtentTest().log(Status.SKIP, "Test Skipped");
	}

}
