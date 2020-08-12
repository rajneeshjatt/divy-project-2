package Academy;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resources.BaseClass;
import resources.ExtentReporterNG;

public class Listeners extends BaseClass implements ITestListener {

	ExtentTest test;
	ExtentReports extents = ExtentReporterNG.ExtentReportconfig();
	ThreadLocal<ExtentTest> extent_thread = new ThreadLocal<ExtentTest>();

	public void onTestStart(ITestResult result) {
		test = extents.createTest("Initialize" + result.getMethod().getMethodName());
		extent_thread.set(test);

	}

	public void onTestSuccess(ITestResult result) {
		extent_thread.get().log(Status.PASS, result.getMethod().getMethodName() + " successfully passed.");

	}

	public void onTestFailure(ITestResult result) {

		extent_thread.get().fail(result.getThrowable());
		WebDriver driver = null;

		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver")
					.get(result.getInstance());
		} catch (Exception e1) {
			e1.printStackTrace();
		}

		String TestcaseName = result.getMethod().getMethodName();
		try {
			screenShot(TestcaseName, driver);  
			extent_thread.get().addScreenCaptureFromPath(System.getProperty("user.dir")+"\\reports\\"+TestcaseName +".png", TestcaseName);
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

	}

	public void onFinish(ITestContext context) {
		
		extents.flush();

	}

}
