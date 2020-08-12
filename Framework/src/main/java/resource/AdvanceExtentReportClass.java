package resource;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class AdvanceExtentReportClass {
	
	public static ExtentSparkReporter rep;
	public static ExtentReports extent;
	public static File file;

	public static ExtentReports extentReporter() {

		 file = new File(System.getProperty("user.dir") + "\\reports\\index.html");
		rep = new ExtentSparkReporter(file);
		rep.config().setDocumentTitle("Divy Automation Framework");
		rep.config().setReportName("Air Asia Automation Tests");

		extent = new ExtentReports();
		extent.attachReporter(rep);
		extent.setSystemInfo("Divy", "Automation Engineer");

		return extent;
	}

}
