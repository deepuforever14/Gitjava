package JavaResources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReoprt {
	public class ExtentReporters {
		public void getResult()
		{
			String path = System.getProperty("user.dir")+"\\reportss\\index1.html";
			ExtentSparkReporter reporter = new ExtentSparkReporter(path);
			//setting up Report name
			reporter.config().setReportName("Test Report Capture");
			reporter.config().setDocumentTitle("Test Results");
			ExtentReports extent = new ExtentReports();
			extent.attachReporter(reporter);
			extent.setSystemInfo("Tester","DeepuPinky");
		    //create test path
			extent.createTest(path);
			
			
		}

	}


}
