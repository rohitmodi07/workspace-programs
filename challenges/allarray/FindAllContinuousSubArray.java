package challenges.allarray;

import java.util.ArrayList;
import java.util.List;

public class FindAllContinuousSubArray {
	
	public static void main(String[] args) {
	      
	      // The array elements
	      int arr[] = { 1,2,3 };
	      System.out.println("The subarrays are-");
	      
	      List<List<Integer>> intlist = new ArrayList<>();
	      
	      // For loop for start index
		      for (int i = 0; i < arr.length; i++) {
		      
		      // For loop for end index
		      for (int j = i; j < arr.length; j++) {
		      
		         // For loop to print subarray elements
		    	  List<Integer> lst = new ArrayList<>(); 
		         for (int k = i; k <=j; k++) {
		        	
		        	lst.add(arr[k]);
		         }
		         intlist.add(lst);
		         
		      }
	      }
		  System.out.println(intlist);
		  int minval = 1;
		  int maxval = 0;
		  
		  for(List<Integer> lstval : intlist) {
			  
			  
			  for(int i=0; i<lstval.size(); i++) {
				  minval = minval & lstval.get(i);
			  }
			  
			  for(int i=0; i<lstval.size(); i++) {
				  maxval = maxval | lstval.get(i);
			  }
			  
		  }
		  
		  System.out.println(" minval ::::: "+minval);
		  System.out.println(" maxval ::::: "+maxval);
	   }

}
