package pageObjects;

import javax.xml.xpath.XPath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPAGE {
	WebDriver ldriver;
	public LoginPAGE(WebDriver rdriver){
	 ldriver =rdriver;
	 PageFactory.initElements(rdriver, this);	
		
	}
	//@FindBy(xpath="//input[@name='uid']")
	//public static WebElement uid;
	public static By uid= By.xpath("//input[@name='uid']");
	@FindBy(xpath="//input[@name='password']")
	WebElement pass;
	@FindBy(xpath="//input[@name='btnLogin']")
	WebElement login;
	
//	public void setuid(String uidvalue) {
//		uid.sendKeys(uidvalue);
//	}
	public void setpsd(String psd) {
		pass.sendKeys(psd);
	}
	public void setlogin() {
		login.click();
	}

}
