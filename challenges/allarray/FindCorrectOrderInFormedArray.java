package challenges.allarray;

public class FindCorrectOrderInFormedArray {
	
	public static boolean findCorrectnessOfArray(int[] arr1, int[] arr2, int[] arr3){

		   if(arr1 == null || arr1.length<1 || arr2 == null || arr2.length<1){
		      
			    return false;
		   
		   }
		   
		   if((arr1.length + arr2.length) != arr3.length){                             // {1,4,5} and {2,3,6} , {1,2,3,4,5,6}
		   
		   
		      return false;
		   
		   }
		   
		   int count1 = 0;
		   int count2 = 0;
		   int k = 0;
		   
		  for(int i=0; i<arr1.length; i++){
		      
		     for(int j=k; j<arr3.length; j++){
			   
		    	 if(arr1[i] == arr3[j]) {
		    		 count1++;
		    		 k = j;
		    		 break;
		    	 }  
			     
			 
			 }
		   
		  }
		  k=0;
		  
		  for(int i=0; i<arr2.length; i++){
			  
			     for(int j=k; j<arr3.length; j++){
				   
			    	 if(arr2[i] == arr3[j]) {
			    		 count2++;
			    		 k = j;
			    		 break;
			    	 }  
				     
				 
				 }
			   
		  }
		  
		  if((count1 + count2) == arr3.length) {
			  return true;
		  }

      return false;

		}

	


	public static void main(String[] args) { 
		
		int[] arr1 = {1,4,5};
		int[] arr2 = {2,3,6};
		int[] arr3 = {1,4,5,2,3,6};
		
		System.out.println(" is formed array is valid ::: "+findCorrectnessOfArray(arr1, arr2, arr3));
		
        arr3 = new int[]{1,2,3,4,5,6};
		
		System.out.println(" is formed array is valid ::: "+findCorrectnessOfArray(arr1, arr2, arr3));
		
        arr3 = new int[]{1,2,3,5,4,6};
		
		System.out.println(" is formed array is valid ::: "+findCorrectnessOfArray(arr1, arr2, arr3));
		
		
 }

}
