package Divy.Framework;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resource.AdvanceExtentReportClass;
import resource.BaseClass;

public class ITestListenerInterfaceClass extends BaseClass implements ITestListener {

	ExtentReports extent = AdvanceExtentReportClass.extentReporter();
	ExtentTest test;
	ThreadLocal<ExtentTest> thread_test = new ThreadLocal<ExtentTest>();
	
    
	public void onTestStart(ITestResult result) {
        
		String methodName = result.getMethod().getMethodName();
		test = extent.createTest(methodName + " is initialized and Test is started");
		thread_test.set(test);
	}

	public void onTestSuccess(ITestResult result) {
		thread_test.get().log(Status.PASS, "Test passed successfully");

	}

	public void onTestFailure(ITestResult result) {
		
		thread_test.get().fail(result.getThrowable());
		WebDriver driver = null;
		String TestCaseName = result.getMethod().getMethodName();
		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver")
					.get(result.getInstance());
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		try {
			captureScreenshot(TestCaseName, driver);
			String path = (String)captureScreenshot(TestCaseName, driver);
			thread_test.get().addScreenCaptureFromPath(path, TestCaseName);
			
			
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
		extent.flush();

	}

}
