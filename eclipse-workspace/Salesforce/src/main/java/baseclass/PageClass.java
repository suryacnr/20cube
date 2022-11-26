package baseclass;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PageClass {
	
	public WebDriver driver;
	public WebDriverWait wait;
	//page class constructor
	
	public  PageClass(WebDriver driver,WebDriverWait wait) {
		this.driver=driver;
		this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(15));
		
		
	}
	
	//create a new method with java generics and return a new page
/*	public <Tpage extends Basepage> Tpage getInstance(Class<Tpage> PageClass) {
		try {
			return PageClass.getDeclaredConstructor(WebDriver.class, WebDriverWait.class).newInstance(this.driver,this.wait);
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
			
		}*/
	}
	 
	


