package comonutility;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import baseclass.Basepage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Utilitys extends Basepage{
	



	//public  WebDriver  driver;
	public  WebDriverWait wait;
	
	
	
	
	
	public  void waitToBeClickable( By element) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(element));
		
	}catch (Exception e) {
		e.printStackTrace();
	}
	}
	public   void waitToBepresent(By element) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOfElementLocated(element));
		
	}catch (Exception e) {
		e.printStackTrace();
	}
	}
	public  void radiobutton(By Radioelement,By clickelement) {
		
		try {
			WebElement ele =driver.findElement(Radioelement);
			if(ele.isSelected()) {
			 ClickOnElement(clickelement);
			}else if(! ele.isSelected()) {
				ClickOnElement( Radioelement);
				ClickOnElement( clickelement);
			}
			else {
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
		public  void ClickOnElement( By element) {
			try {
				driver.findElement(element).click();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
		
		public void Send( By username, String Input) {
			driver.findElement(username).sendKeys(Input);
			
		}

}
