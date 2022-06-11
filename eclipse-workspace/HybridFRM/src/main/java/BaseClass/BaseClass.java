package BaseClass;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import utilities.ReadProperites;


public class BaseClass {
	ReadProperites read =new ReadProperites();
	
	public String username =read.getUsername();
	public String Password =read.getPassword();
	public String baseUrl =read.getbaseUrl();
	public static WebDriver driver;
	public static Logger logger;
	
	@BeforeClass
	public void setup() {
		logger =Logger.getLogger("HybridFRM");
		PropertyConfigurator.configure("Log4j.properties");
		//System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//Driver//chromedriver.exe");
		System.setProperty("webdriver.chrome.driver",read.getchromePath());
		driver = new ChromeDriver();
		
		
	}
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	public static String getScreenshot(WebDriver driver,String ScreenShotName) throws IOException {
		String data = new SimpleDateFormat("yyyyMMddhhmm").format(new Date());
		TakesScreenshot  tc= (TakesScreenshot) driver;
		File source =tc.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir")+"/ScreenShot/"+ScreenShotName+data+".png";
		File finalDestination =new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;
		
		
		
	}
	
	

}
