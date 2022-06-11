package TestCases;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import BaseClass.BaseClass;
import pageObjects.LoginPAGE;
import utilities.XmlUtilities;

public class Tc_login002 extends BaseClass {
	@Test(dataProvider="logindetail")
	public void login(String users, String pass, String validation) {
		LoginPAGE page =new LoginPAGE(driver);
		driver.findElement(LoginPAGE.uid).sendKeys(username); 
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
		// WebElement pass1 = LoginPAGE.uid;
		 WebElement pass1=driver.findElement(LoginPAGE.uid);
		pass1.clear();
		pass1.sendKeys(users);
		driver.findElement(By.xpath("login")).click();
		String expected_value ="expected tiltal";
		String actual_value =driver.getTitle();
		if(validation.equals("valid")) {  
			if(actual_value.equalsIgnoreCase(expected_value)) {
				driver.findElement(By.xpath("logout")).click();
				System.out.println("Test Step pass");
			}else {
				System.out.println("Test Step Fail");
			}
		}else if (validation.equals("invalid")){
			if(!actual_value.equalsIgnoreCase(expected_value)) {
				
				System.out.println("Test Step pass");
			}else {
				driver.findElement(By.xpath("logout")).click();
				System.out.println("Test Step Fail");
			}
			
			
		}
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
	public static void Readfile() throws Exception {
		//
				String excel = System.getProperty("user.dir")+"\\Data\\Poitest.xlsx";
				FileInputStream stream =new FileInputStream(excel);
				XSSFWorkbook book = new XSSFWorkbook(stream);
				//XSSFSheet sheet =book.getSheet("Sheet1");
				XSSFSheet sheet =book.getSheetAt(0);
				int rows = sheet.getLastRowNum();
				int cols = sheet.getRow(1).getLastCellNum();
				//Using for loop
				for(int i=0;i<=rows;i++) {
					XSSFRow r= sheet.getRow(i);
					for(int j=0;j<=cols;j++) {
						XSSFCell cell =r.getCell(j);
						switch(cell.getCellType()) {
						case STRING :System.out.print(cell.getStringCellValue());
						break;
						case NUMERIC:System.out.print(cell.getNumericCellValue());
						break;
						case BOOLEAN: System.out.print(cell.getBooleanCellValue());
						default:
							break;
						}
						System.out.print(" | ");
						
					}
					System.out.println();
				}

}
}