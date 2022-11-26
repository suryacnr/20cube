package practise_Java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import baseclass.Basepage;
import testsclass.BaseTest;

public class Practise_java extends parentclass {

	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Practise_java obj = new Practise_java();
		//obj.property();
		obj.hashmap();
	// String [] name = {"1","2","3"};
	// String [] names = {"surya":"101","dhars":"102","surya":101};
	 
	 
		
		

	}
	public void hashmap() {
		HashMap<String,String>m1 =new HashMap<String,String>();
		m1.put("Surya", "101");
		m1.put("sharath", "102");
		m1.put("ram", "101");
		//m1.put("Surya", "104");
		//m1.remove("sharath");
	
		
		for(Map.Entry map:m1.entrySet()) {
			System.out.println(map.getKey()+","+map.getValue());
			//System.out.println(map);
			
		}
		
	}
	
				
		
		
			
		
		
	
	
	
	
}
