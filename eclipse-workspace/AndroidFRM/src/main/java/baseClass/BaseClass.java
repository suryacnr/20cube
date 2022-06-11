package baseClass;


import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Arrays;

import org.apache.poi.xssf.eventusermodel.XSSFReader;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import utilities.ReadProperites;


public class BaseClass {
	
	@BeforeSuite
	@Parameters("device")
	public void loadfails(String device) throws MalformedURLException {
		Setup.intialization();
		Reusable.launchApp(device);
	}
	
	@AfterMethod
	public void afterMethod(ITestResult tr) {
		try {
			String MethodName=tr.getMethod().getMethodName();
			if(tr.getStatus()==ITestResult.FAILURE) {
				String expectedMsg =Arrays.toString(tr.getThrowable().getStackTrace());
				Setup.test.fail("<details><summary><b><font color=red>Exception accured Please click here to see the detail.</font></b><summary>"+
						expectedMsg.replace(",", "<br>")+"</details> \n");
				String path= Reusable.getScreenshot(MethodName);
				Setup.test.fail("<b><font color=red>"+"ScreenShot of Failure"+"</font><b>",MediaEntityBuilder.createScreenCaptureFromPath(path).build());
				String logText="<b> Test Method"+MethodName+"Failed</b>";
				Markup markup=MarkupHelper.createLabel(logText, ExtentColor.RED);
				Setup.test.log(Status.FAIL, markup);
			}else if(tr.getStatus()==ITestResult.SUCCESS) {
				String logText="<b> Test Method"+MethodName+"Successfull</b>";
				Markup markup=MarkupHelper.createLabel(logText, ExtentColor.GREEN);
				Setup.test.log(Status.PASS, markup);
				
			}else if(tr.getStatus()==ITestResult.SKIP) {
				String logText="<b> Test Method"+MethodName+"Skipped</b>";
				Markup markup=MarkupHelper.createLabel(logText, ExtentColor.ORANGE);
				Setup.test.log(Status.SKIP, markup);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@AfterSuite
	public void teardown() {
		Setup.report.flush();
		
	}
	
	public String getMethodNmae() {
		String method = new Exception().getStackTrace()[1].getMethodName();
		return method;
	}
	
	
	
//	public void setResultInExcel(XSSFReader xls_obj,String sheetname,String testcaseId, String result) {
//		int rownumber=xls_obj.ge
//		
//	}
	

}
