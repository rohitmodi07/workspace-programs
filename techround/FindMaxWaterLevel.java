package techround;

public class FindMaxWaterLevel {

	// Time Complexity : O(n^2), Space Complexity : O(1)
	
	public static int findMaxWater(int[] arr) { 
	
		if(arr.length<1)
			return -1;
		int maxval = -1;
		
		for (int i = 0; i < arr.length; i++) {
		  for (int j = i+1; j < arr.length; j++) {
		      int minval = min(arr[i], arr[j])*(j-i);
		
		      maxval = max(maxval, minval);
		  }
		}
		return maxval;
	
	}
	
	// Time Complexity : O(n), Space Complexity : O(1)
	
	public static int findMaxWaterwithNTImeComplexity(int[] arr) { 
	
		if(arr.length<1)
			return -1;
		
		int maxval = -1;
		int i = 0;
		int j = arr.length-1;
		
		while(i<j) {
		  int minval = min(arr[i], arr[j])*(j-i);
		
		  maxval = max(maxval, minval);
		
		  if(arr[i]<arr[j]) {
		     i++;
		  }else {
		     j--;
		  }
		}
		return maxval;
	
	}
	
	public static int min(int a, int b) {
		if(a<b) {
		  return a;
		}
		return b;
	}
	
	public static int max(int a, int b) {
		if(a>b) {
		  return a;
		}
		return b;
	}
	
	public static void main(String[] args) {
		
        int[] arr1 = {};
		
        System.out.println(" The max water level : findMaxWater : "+findMaxWater(arr1));
		System.out.println(" The max water level : findMaxWaterwithNTImeComplexity : "+findMaxWaterwithNTImeComplexity(arr1));
		System.out.println();
		
        int[] arr2 = {1};
		
        System.out.println(" The max water level : findMaxWater : "+findMaxWater(arr2));
		System.out.println(" The max water level : findMaxWaterwithNTImeComplexity : "+findMaxWaterwithNTImeComplexity(arr2));
		System.out.println();
		
        int[] arr3 = {1,1};
		
		System.out.println(" The max water level : findMaxWater : "+findMaxWater(arr3));
		System.out.println(" The max water level : findMaxWaterwithNTImeComplexity : "+findMaxWaterwithNTImeComplexity(arr3));
		System.out.println();
		
        int[] arr4 = {1,8,3,4,7,5};
		
		System.out.println(" The max water level : findMaxWater : "+findMaxWater(arr4));
		System.out.println(" The max water level : findMaxWaterwithNTImeComplexity : "+findMaxWaterwithNTImeComplexity(arr4));
		System.out.println();
	
	}

}
