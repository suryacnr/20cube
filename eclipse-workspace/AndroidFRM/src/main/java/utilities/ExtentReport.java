package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReport extends TestListenerAdapter {
	
	public WebDriver driver;
	public ExtentReports report;
	public ExtentTest test;
	public ExtentSparkReporter  spark;
	public SimpleDateFormat data;
	
	public void onStart(ITestContext testContext) {
		String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		String repName = timestamp+".html";
		spark =new ExtentSparkReporter(System.getProperty("user.dir")+"./target/"+repName);
		try {
			spark.loadXMLConfig(System.getProperty("user.dir")+"/extent-report.xml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		spark.config().setDocumentTitle("Automation Testing");
		spark.config().setReportName("Functional Testing");
		spark.config().setTheme(Theme.DARK);
		
		report =new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("HostName", "LocalHost");
		report.setSystemInfo("Port", "4444");
		report.setSystemInfo("OS", "Windows10");
		
		
	}
	
	public void onTestSuccess(ITestResult tr) {
		test =report.createTest(tr.getName());
		test.log(Status.PASS,MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));
		
	}
	
	public void onTestFailure(ITestResult tr) {
		test =report.createTest(tr.getName());
		test.log(Status.FAIL,MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));
		String ScrenShot =System.getProperty("user.dir")+"\\ScreenShot\\"+tr.getName()+".png";
		File finalDestination =new File(ScrenShot);
		if(finalDestination.exists()) {
			try {
				test.fail("ScreenShot Below: "+test.addScreenCaptureFromPath(ScrenShot));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public void onTestSkipped(ITestResult tr) {
		test =report.createTest(tr.getName());
		test.log(Status.SKIP,MarkupHelper.createLabel(tr.getName(), ExtentColor.ORANGE));
	}
	
	
	public void onFinish(ITestContext testContext) {
		report.flush();
	}
	
//	@AfterMethod
//	public void teardown(ITestResult result) throws IOException {
//		if(result.getStatus()==ITestResult.FAILURE) {
//			test.log(Status.FAIL, "Test Case Failed"+result.getName());
//			test.log(Status.FAIL, "Test Case Failed"+result.getThrowable());
//			String ScrenShot =ExtentReport.getScreenshot(driver, result.getName());
//			test.addScreenCaptureFromPath(ScrenShot);
//			
//		}
//		else if(result.getStatus()==ITestResult.SKIP) {
//			test.log(Status.SKIP, "Test Case Skiped"+result.getName());
//		}else if(result.getStatus()==ITestResult.SUCCESS)
//		{
//			test.log(Status.PASS, "Test Case Passed"+result.getName());
//		}
//		
//	}
	
//	public static String getScreenshot(WebDriver driver,String ScreenShotName) throws IOException {
//		String data = new SimpleDateFormat("yyyyMMddhhmm").format(new Date());
//		TakesScreenshot  tc= (TakesScreenshot) driver;
//		File source =tc.getScreenshotAs(OutputType.FILE);
//		String destination = System.getProperty("user.dir"+"/ScreenShot/"+ScreenShotName+data+".png");
//		File finalDestination =new File(destination);
//		FileUtils.copyFile(source, finalDestination);
//		return destination;
//		
//		
//		
//	}
//	
	
}
