package techround;

import java.util.Stack;

public class FindKthMissingElement {

	public static int missingElement(int[] arr, int k){
		   
	      if(arr.length<1 || k<1)
		       return -1;
		  Stack<Integer> stk = new Stack<>();
		  int count = 1;
		   
		  for(int i=0; i<arr.length; i++){
	        
			  if(count == arr[i]){
			    count++;
			  }else{
			     stk.push(count);
				 count = arr[i];
				 i = i-1;
			  }
			  if(stk.size() == k){
			     return stk.pop();
			  }

	      }
		  
		  while(stk.size()<k) {
			  stk.push(count);
			  count++;
		  }
		  
		  return stk.pop(); 
	   }

	public static void main(String[] args) {
		int[] arr1 = new int[] {1,3,4,5,6,7};
		System.out.println(" Missing element is -------"+missingElement(arr1, 1));
		
		int[] arr2 = new int[] {1,3,4,5,7};
		System.out.println(" Missing element is -------"+missingElement(arr2, 2));
		
		int[] arr3 = new int[] {1,3,4,5,6,7};
		System.out.println(" Missing element is -------"+missingElement(arr3, 2));
		
		int[] arr4 = new int[] {1,2,3,4,5,6,7};
		System.out.println(" Missing element is -------"+missingElement(arr4, 3));

	}

}
