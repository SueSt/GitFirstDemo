package com.crm.qa.ExtentReportListener;

	import java.io.File;
	import java.util.Calendar;
	import java.util.Collection;
	import java.util.Date;
	import java.util.List;
	import java.util.Map;
	import java.util.Set;

	import javax.naming.spi.DirStateFactory.Result;

	import org.testng.IReporter;
	import org.testng.IResultMap;
	import org.testng.ISuite;
	import org.testng.ISuiteResult;
	import org.testng.ITestContext;
	import org.testng.ITestNGMethod;
	import org.testng.ITestResult;
	import org.testng.xml.XmlSuite;

	import com.google.common.io.Files;
	import com.relevantcodes.extentreports.ExtentReports;
	import com.relevantcodes.extentreports.ExtentTest;
	import com.relevantcodes.extentreports.LogStatus;

	public class ExtentReporterNG implements IReporter {
		private ExtentReports extent;

		public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites,
				String outputDirectory) {
			extent = new ExtentReports(outputDirectory + File.separator
					+ "Extent.html", true);
			
			for (ISuite suite : suites) {
				Map<String, ISuiteResult> result = suite.getResults();
				
				//Get the key of the result map

	            Set<String> keys = result.keySet();

	        //Go to each map value one by one

	            for (String key : keys) {

	             //The Context object of current result

	            ITestContext context = result.get(key).getTestContext();

	            //Print Suite detail in Console

	             System.out.println("Suite Name->"+context.getName()

	                    + "::Report output Ditectory->"+context.getOutputDirectory()

	                     +"::Suite Name->"+ context.getSuite().getName()

	                     +"::Start Date Time for execution->"+context.getStartDate()

	                     +"::End Date Time for execution->"+context.getEndDate());

	            }
				for (ISuiteResult r : result.values()) {
					ITestContext context1 = r.getTestContext();

					buildTestNodes(context1.getPassedTests(), LogStatus.PASS);
					buildTestNodes(context1.getFailedTests(), LogStatus.FAIL);
					buildTestNodes(context1.getSkippedTests(), LogStatus.SKIP);
				}
			}

			extent.flush();
			extent.close();
		}

		private void buildTestNodes(IResultMap tests, LogStatus status) {
			ExtentTest test;

			if (tests.size() > 0) {
				for (ITestResult result : tests.getAllResults()) {
					test = extent.startTest(result.getMethod().getMethodName());

					test.setStartedTime(getTime(result.getStartMillis()));
					test.setEndedTime(getTime(result.getEndMillis()));

					for (String group : result.getMethod().getGroups())
						test.assignCategory(group);

					if (result.getThrowable() != null) {
						test.log(status, result.getThrowable());
					} else {
						test.log(status, "Test " + status.toString().toLowerCase()
								+ "ed");
					}

					extent.endTest(test);
				}
			}
		}

		private Date getTime(long millis) {
			Calendar calendar = Calendar.getInstance();
			calendar.setTimeInMillis(millis);
			return calendar.getTime();
		}
	}

	

