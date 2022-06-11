package TestCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import BaseClass.BaseClass;
import pageObjects.LoginPAGE;
import utilities.XmlUtilities;

public class TC_LoginDDT_002 extends BaseClass {
	@Test(dataProvider="logindetail")
	public void login(String users, String pass, String validation) {
		LoginPAGE page =new LoginPAGE(driver);
		driver.findElement(page.uid).sendKeys(username); 
		 page.setpsd(pass);
		 page.setlogin();
		 
		 if(isAlertPrsent()==true) {
			 driver.switchTo().alert().accept();
			 driver.switchTo().defaultContent();
			 Assert.assertTrue(false);
		 }else {
			 Assert.assertTrue(true);
			 driver.findElement(By.xpath("logout")).click();
			 driver.switchTo().alert().accept();
			 driver.switchTo().defaultContent();
		 }
//		 WebElement pass1 = LoginPAGE.uid;
//		pass1.clear();
//		pass1.sendKeys(users);
//		driver.findElement(By.xpath("login")).click();
//		String expected_value ="expected tiltal";
//		String actual_value =driver.getTitle();
//		if(validation.equals("valid")) {  
//			if(actual_value.equalsIgnoreCase(expected_value)) {
//				driver.findElement(By.xpath("logout")).click();
//				System.out.println("Test Step pass");
//			}else {
//				System.out.println("Test Step Fail");
//			}
//		}else if (validation.equals("invalid")){
//			if(!actual_value.equalsIgnoreCase(expected_value)) {
//				
//				System.out.println("Test Step pass");
//			}else {
//				driver.findElement(By.xpath("logout")).click();
//				System.out.println("Test Step Fail");
//			}
//			
//			
//		}
	}

	public boolean isAlertPrsent() {
		
		 try {
			driver.switchTo().alert();
			 return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	 }
	
	


	@DataProvider(name="logindetail")
	public String[][] getData() throws IOException{
		

		//String Xls =".\\Data\\testdata.xlsx";
		String Xls =System.getProperty("user.dir")+"/Data/Poitest.xlsx";
		int totalrows=XmlUtilities.getRowCount(Xls,"Sheet1");
		int totalcolms=XmlUtilities.getCellCount(Xls,"Sheet1",1);
		System.out.println("Total row count: "+totalrows+"and colum"+totalcolms);
		
		String logindetails[][]=new String[totalrows][totalcolms]; 
		//must be equals to total rows&colms size The same number mst be in excel and 2Dimanstion arrays
		for (int i=1; i<=totalrows; i++) //1
		{
				
			for(int j =0; j<totalcolms; j++)//0
				{
				logindetails[i-1][j]=XmlUtilities.getCellData(Xls,"Sheet1",i,j); // in sheet there will be header element so we need to ignore in 2Dimanstion array so we are using i-1
				
				}
		}
		
		
		return logindetails;
		
	}
}
