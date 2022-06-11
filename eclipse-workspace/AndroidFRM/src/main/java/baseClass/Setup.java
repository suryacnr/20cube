package baseClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Setup {
	
	public static Properties pro;
	public static ExtentReports report;
	public static ExtentTest test;
	public static ExtentSparkReporter  spark;
	public static SimpleDateFormat data;
	public static Logger logger;
	
	public static void intialization() {
		try {
			//Declaring log4j for logging
			logger =Logger.getLogger(Setup.class.getName());
			PropertyConfigurator.configure("Log4j.properties");
			
			//To Load ConfigProperties
			File file = new File("./Configuration/Config.properties");
			FileInputStream src = new FileInputStream(file);
			pro =new Properties();
			pro.load(src);
			
			//To load Extend Report
			String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
			String repName = timestamp+".html";
			spark =new ExtentSparkReporter(System.getProperty("user.dir")+"./target/"+repName);
			spark.loadXMLConfig(System.getProperty("user.dir")+"/extent-report.xml");
			
			
			spark.config().setDocumentTitle("Automation Testing");
			spark.config().setReportName("Functional Testing");
			spark.config().setTheme(Theme.DARK);
			
			report =new ExtentReports();
			report.attachReporter(spark);
			report.setSystemInfo("HostName", "LocalHost");
			report.setSystemInfo("Port", "4444");
			report.setSystemInfo("OS", "Windows10");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
}
