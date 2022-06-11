package TestCases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import BaseClass.BaseClass;
import pageObjects.LoginPAGE;

public class Login extends BaseClass {

	@Test(priority=1)
	public void Tc_IESP_001() {
		driver.get(baseUrl);
		LoginPAGE page =new LoginPAGE(driver);
		try {
			driver.findElement(LoginPAGE.uid).sendKeys(username);
			//page.setuid(username);
			logger.info("Username entered");
			page.setpsd(Password);
			page.setlogin();
			Thread.sleep(20);
			getScreenshot(driver,"Login");
			
			
			if(driver.getTitle().equalsIgnoreCase("Guru99 Bank Manager HomePage")) {
				System.out.println("TestStepPass");
			}else {
				getScreenshot(driver,"Login");
				System.out.println("TestStepFail");
				
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			
		}
		
		
	}

}
