package baseclass;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import comonutility.XMLUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Basepage{
	public static  WebDriver driver;
	public static WebDriverWait wait;
	
	@BeforeMethod
	public  void startBR() {
		String url =XMLUtility.readdata("URL");
        WebDriverManager.chromedriver().setup();
        WebDriverManager.firefoxdriver().setup();
		ChromeOptions o = new ChromeOptions();
		o.addArguments("disable-notifications");
		driver= new ChromeDriver(o);
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	//return driver;
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
		
	}
	
	
	
	
	
	
	
		
			
		
	



}