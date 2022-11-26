package testsclass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import baseclass.Basepage;
import comonutility.Utilitys;
import tes.POM.POM;

public class TS_LHL_001 extends BaseTest {
	public  WebDriver driver;
	public Utilitys utilitys;

	

	@Test(priority =2)
	public void ts_lhl_001() {
		try {
			Logintosalesforce login =new Logintosalesforce();
			login.logintosa();
			//Basepage page = new Basepage(driver);
			utilitys = new Utilitys();
			System.out.println("Entered in to login script");
			utilitys.waitToBeClickable(POM.LeadObject);
			utilitys.ClickOnElement( POM.LeadObject);
			//driver.findElement(By.xpath(POM.LeadObject)).click();
			utilitys.waitToBeClickable(POM.LeadNew);
			utilitys.ClickOnElement( POM.LeadNew);
			utilitys.waitToBepresent(POM.Direct);
			utilitys.radiobutton(POM.Advisor,POM.DirectNew);
			//utilitys.Send(POM., null);
			
			Thread.sleep(10000);
			//Utilitys.waitToBeClickable(driver,POM.DirectNew);
			//Utilitys.ClickOnElement(driver,POM.DirectNew);
			
			System.out.println("Entered in to login script");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
