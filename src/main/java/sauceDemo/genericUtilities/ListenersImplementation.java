package sauceDemo.genericUtilities;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenersImplementation implements ITestListener {

	WebDriverUtility wU = new WebDriverUtility();
	JavaUtility jU = new JavaUtility();
	ExtentReports report;
	ExtentTest test;

	@Override
	public void onTestStart(ITestResult result) {

		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName + " -> Test Execution Started-----------------------");
		test = report.createTest(methodName);
	}

	@Override
	public void onTestSuccess(ITestResult result) {

		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName + " -> Test Execution Successful-----------------------");
		test.log(Status.PASS, methodName + " -> Test Execution Successful-----------------------");
	}

	@Override
	public void onTestFailure(ITestResult result) {

		String methodName = result.getMethod().getMethodName();
		test.log(Status.FAIL, methodName + " -> Test Execution Failed-----------------------");
		try {
			String screenshotPath = wU.captureScreenshot(BaseClass.sDriver, jU.getSystemDate());
			test.addScreenCaptureFromPath(screenshotPath);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(methodName + " -> Test Execution Failed-----------------------");

	}

	@Override
	public void onTestSkipped(ITestResult result) {

		String methodName = result.getMethod().getMethodName();
		test.log(Status.PASS, methodName + " -> Test Execution Successful-----------------------");
		try {
			String screenshotPath = wU.captureScreenshot(BaseClass.sDriver, jU.getSystemDate());
			test.addScreenCaptureFromPath(screenshotPath);

		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(methodName + " -> Test Execution Skipped-----------------------");

	}

	@Override
	public void onStart(ITestContext context) {

		ExtentSparkReporter esr = new ExtentSparkReporter(".\\ExtentReports\\" + jU.getSystemDate() + ".html");
		esr.config().setTheme(Theme.DARK);
		esr.config().setDocumentTitle("Sauce Demo Automation Framework");
		esr.config().setReportName("Sauce Demo Automation Framework Test Report");

		report = new ExtentReports();
		report.attachReporter(esr);
		report.setSystemInfo("Base Browser", "Microsoft Edge");
		report.setSystemInfo("Base Platform", "Windows");
		report.setSystemInfo("Base URL", "Test Environment");
		report.setSystemInfo("Reporter Name", "Abhinav");
		System.out.println("-----------------------Suite Execution Start-----------------------");

	}

	@Override
	public void onFinish(ITestContext context) {
		report.flush();
		System.out.println("-----------------------Suite Execution Ended-----------------------");

		;
	}

}
