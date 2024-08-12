package dynamicprog;

import java.util.Arrays;

public class FindLongestConsSubSeq {
	
	public static int findLongestConsecutiveSubSeq(int[] arr) {
		   if(arr == null || arr.length<1)
			   return -1;
		   Arrays.sort(arr);   //1,2,3,4,100,200    0,0,1,2,3,4,5,6,7,8
		   
		   int count = 1;	
		   
		   int max = 0;
		   for(int i=0; i<arr.length-1; i++) {
			   if(arr[i]+1 == arr[i+1]) {
				   count++;
			   }else {
				   max = count>max ? count : max;
				   count = 1;
			   }
		   }
		   max = count>max ? count : max;
		   return max;
		   
	   }
		

		public static void main(String[] args) { 
			
			int[] arr = {0,3,7,2,5,8,4,6,0,1};
			
			System.out.println(" longest consecutive sub sequence :::: "+findLongestConsecutiveSubSeq(arr));
			
	        int[] arr1 = {100,4,200,1,3,2};
			
			System.out.println(" longest consecutive sub sequence :::: "+findLongestConsecutiveSubSeq(arr1));
			
	    }

}
