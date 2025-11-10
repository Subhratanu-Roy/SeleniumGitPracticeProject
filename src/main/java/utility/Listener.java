package utility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import base.Base;

public class Listener extends Base implements ITestListener {

	ExtentSparkReporter reporter = null;
	ExtentReports report = null;
	ExtentTest test = null;

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		reporter = new ExtentSparkReporter(System.getProperty("user.dir") + "\\test_screenshots\\extentReport.html");
		reporter.config().setDocumentTitle("Automation e2e report");
		reporter.config().setReportName("Automation report");

		report = new ExtentReports();
		report.attachReporter(reporter);
		report.setSystemInfo("Environment", "UAT");
		report.setSystemInfo("Tester", "Roy");

	}

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		test = report.createTest(result.getMethod().getMethodName());

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		test.pass("Test is pass");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		test.fail("Test is a fail");
		String ssPath = PageFunction.takeScreenshot(driver, result.getMethod().getMethodName());
		System.out.println("SS Path: "+ ssPath);
		test.addScreenCaptureFromPath(ssPath);

	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		report.flush();
	}

}
