package techround;

public class TotalWaterStoreInGrid {
	
public static int findMaxWaterwithNTImeComplexity(int[] arr) { 
		
		if(arr.length<1)
			return -1;
		
		int sum = 0;
		
		for(int i = 0; i < arr.length-1;) {
			
			int j = i;
			while(arr[j]>arr[j+1]) {
				j++;
			}
			j++;
			
			int min = Math.min(arr[i], arr[j]);
			
			while(i<j) {
				int val = min-arr[i];
				if(val>0) {
					sum = sum + val;
				}
				i++;
			}
			
			
		}
		
		return sum;
	
	}
		

	public static void main(String[] args) {
    	
		int[] arr = {5,3,2,5,4,1,2};
		
		int[] arr1 = {1,3,2,5,4,1,2};
	
		System.out.println(findMaxWaterwithNTImeComplexity(arr));
		System.out.println(findMaxWaterwithNTImeComplexity(arr1));
    }

}
