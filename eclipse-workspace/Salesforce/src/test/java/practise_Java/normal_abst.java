package practise_Java;

//import java.util.ArrayList;
import java.util.*;

public class normal_abst implements inter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 normal_abst abs = new  normal_abst();
		 abs.m2();

	}

	@Override
	public void m1() {
          String [][] a = { {"surya","dhrashan","abcd"},{"volva","bmw"},{"abc","we"}};
          System.out.println(a.length);
         for(int i = 0; 1<a.length;i++) {
        	 for (int j =0;0<a[i].length;j++) { //for (int j =0;j<2;j++
        		 System.out.println(a[i][j]);
        	 }
         }
	}
          
           
		
		// TODO Auto-generated method stub
		
	

	@Override
	public void m2() {
		List<String> list1 = new ArrayList<String>();
		
		list1.add("Volvo");
		list1.add("BMW");
		list1.add("toy");
		list1.add("dummy");
		list1.add("toy");
		
		list1.remove(1);
		
		
		
		for(String car : list1) {
			System.out.println(car);
		}
		 String [][] a = { {"surya","dhrashan","abcd"},{"volva","bmw"},{"abc","we"}};
         System.out.println(a.length);
         for(String[] car :a) {
        	 for (String b: car) {
        		 System.out.println(b);
        	 }
         }
		
		
		// TODO Auto-generated method stub
		
	
	}
	

	

}
