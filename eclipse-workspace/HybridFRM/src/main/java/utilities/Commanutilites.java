package utilities;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Commanutilites {
	
	public static WebDriver driver;
	
	public static void firstDroppown(By element,String visabletext) {
		WebElement stores= driver.findElement(element);
		stores.click();
		Select action =new Select(stores);
		action.selectByVisibleText(visabletext);
		
	}
	
	public static String gettext(By element) {
		String elements = driver.findElement(element).getText(); 
		return elements;
	}
	
	public static boolean isElementpresent(By element) {
		boolean bool =driver.findElement(element).isDisplayed();
		return bool;
		
	}
	
	public static String gettextboxvalue(By element) {
		//By xpath = By.xpath("//id[text()=''");
			if(isElementpresent(element)) {
				WebElement elements =driver.findElement(element);
				String attribute = elements.getAttribute("value");
				System.out.println("Captured text: "+ attribute);
				return attribute;
			}
			return null;
		
		
	}
	public static void dropdownsingforloop(By element, String dropdownvalue) {
		List<WebElement> drop =driver.findElements(element);
		
		
		for(int i =0; i < drop.size(); i++) {
			String single =drop.get(i).getText(); 
			if(single.equals(dropdownvalue)) {
				drop.get(i).click();
				System.out.println("Successfully clicked on"+dropdownvalue );
				break;
			}else if(single.equals(dropdownvalue)) {
				
				
			}
		}
		
		
		
}
	
	
	

}
