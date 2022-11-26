package testsclass;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Test;

import baseclass.PageClass;
import comonutility.Utilitys;
import comonutility.XMLUtility;
import tes.POM.POM;

public class Logintosalesforce extends BaseTest {

	/*
	 * @BeforeMethod public Logintosalesforce(WebDriver driver) { this.driver
	 * =driver; }
	 */

	

	
	public void logintosa() {
		
		String Username=XMLUtility.readdata("Username");
		String Password=XMLUtility.readdata("Password");
		String getTitle = XMLUtility.readdata("getTitle");
		
			
		
	    try {
	    	//Basepage pg =new Basepage();
	    	//pg.startBR();
			
			//double name = 1.2;
	    	Utilitys utl = new Utilitys();
	    	driver.manage().deleteAllCookies();
			  utl.Send(POM.Username,Username);
			  utl.Send(POM.Password,Password);
			  //driver.findElement(By.xpath(POM.Username)).sendKeys(Username);
			  
			  //driver.findElement(By.xpath(POM.Password)).sendKeys(Password);
			  utl.ClickOnElement(POM.Login);
			  
			  
			///  WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(30));
			 // wait.ignoring(NoAlertPresentException.class);
			 // wait.until(ExpectedConditions.alertIsPresent());
			 // driver.switchTo().alert().accept(); 
			  Thread.sleep(15000);
			 // Utilitys.waitToBepresent(driver,POM.Direct);
			  String expected =driver.getTitle();
			  Thread.sleep(10000);
			//  String actual = "Home | Salesforce"; 
			  assertEquals(getTitle, expected, "test step pass");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 

	}

}
