package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {

	static ExtentReports extents;

	public static ExtentReports ExtentReportconfig() {

		String file = System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter rep = new ExtentSparkReporter(file);
		rep.config().setDocumentTitle("Academy Test Project");
		rep.config().setReportName("Academy Test Results");

		extents = new ExtentReports();
		extents.attachReporter(rep);
		extents.setSystemInfo("Automation QA", "Divy Muni");

		return extents;

	}

}
