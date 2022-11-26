package comonutility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.util.CellAddress;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;




public class XMLUtility {
	
	public static void input(String get) {
		try {
			FileInputStream stream = new FileInputStream("./XLData/TestData.xlsx");
			XSSFWorkbook xs = new XSSFWorkbook(stream);
				XSSFSheet sheet = xs.getSheetAt(0);
				
				 int rowcount = sheet.getLastRowNum();
				    System.out.println(rowcount);
				    
				    HashMap<Object,Object> data =new HashMap<Object,Object>();
				     for(int i=0; i<rowcount; i++){
				    	 //int lastcell =sheet.getRow(i).getLastCellNum();
				    	 
				    	 String data0 = sheet.getRow(i).getCell(0).getStringCellValue();
					     String data1 = sheet.getRow(i).getCell(1).getStringCellValue();
					     data.put(data0, data1);
					    	//System.out.println("data in the string: " + data0 );
					    	//System.out.println("data in the string: " + data1 );	    	     
			          }
				     for(Map.Entry entry :data.entrySet()) {
				    	 if(entry.getKey().equals(get))
				    	 System.out.println(entry.getValue());
				     }
			
	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static String readdata(String value) {
		try {
			FileInputStream stream = new FileInputStream("./XLData/TestData.xlsx");
			XSSFWorkbook xs = new XSSFWorkbook(stream);
				XSSFSheet sheet = xs.getSheetAt(0);
				
				 int rowcount = sheet.getLastRowNum();
				   // System.out.println(rowcount);
				    
				    HashMap<Object,Object> data =new HashMap<Object,Object>();
				     for(int i=0; i<rowcount; i++){
				    	String getscriptId= sheet.getRow(i).getCell(0).getStringCellValue();
				    	//XSSFRow getscriptId=sheet.getRow(i
				    	 if(getscriptId.equals("TC_LHL_001")) {
				    		int lastcolumn= sheet.getRow(i).getLastCellNum();
				    		//System.out.println("Last column count " + lastcolumn );
				    		for(int j=0; j<lastcolumn; j++) {
				    			String getscriptname=sheet.getRow(i).getCell(j).getStringCellValue();
				    			//System.out.println("column count " + getscriptname );
				    			if(getscriptname.equals(value)) {
				    			String Cellvalue=sheet.getRow(i+1).getCell(j).getStringCellValue();
				    			
				    			 data.put(getscriptname, Cellvalue);
				    				for(Map.Entry entry :data.entrySet()) {
								    	 String val= (String) entry.getValue();
								     
				    			 return Cellvalue;	
								     }
				    			}
				    	}
				    		
				    			
				    		}
				    		 
				    	 }
				    	 

	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
//	public void getMethodname() {
//		// create class object 
//        Class<? extends XMLUtility> classobj =getClass();
//        System.out.println(classobj);
//
//        // get list of methods 
//        Method[] methods = classobj.getMethods(); 
//		
//	}
	

}
