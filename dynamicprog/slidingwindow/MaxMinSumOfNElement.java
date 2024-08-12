package dynamicprog.slidingwindow;

public class MaxMinSumOfNElement {
	
	public static int maxContSubArray(int[] arr, int k) {
		if(arr == null || arr.length<1)
			return -1;
		
		int currentMax = 0;
		int max = Integer.MIN_VALUE;
		
		for(int i=0; i<arr.length; i++) {
			currentMax = currentMax + arr[i];
			
			if(i>=(k-1)) {
				max = Math.max(max, currentMax);
				currentMax = currentMax - arr[i-(k-1)];
			}
		}
		
		return max;
	}
	
	public static int minContSubArray(int[] arr, int k) {
		if(arr == null || arr.length<1)
			return -1;
		
		int currentMax = 0;
		int min = Integer.MAX_VALUE;
		
		for(int i=0; i<arr.length; i++) {
			currentMax = currentMax + arr[i];
			
			if(i>=(k-1)) {
				min = Math.min(min, currentMax);
				currentMax = currentMax - arr[i-(k-1)];
			}
		}
		
		return min;
	}
	
	public static int maxContSubArrayProd(int[] arr, int k) {
		if(arr == null || arr.length<1)
			return -1;
		
		int currentMax = 1;
		int max = 1;
		
		for(int i=0; i<arr.length; i++) {
			currentMax = currentMax * arr[i];
			
			if(i>=(k-1)) {
				max = Math.max(max, currentMax);
				currentMax = currentMax / arr[i-(k-1)];
			}
		}
		
		return max;
	}
	
	public static int maxSumContArray(int[] arr) {
		if(arr == null || arr.length<1)
			return -1;
		
		int max = arr[0];
		int currentMax = arr[0];
		
		for(int i=1; i<arr.length; i++) {
			currentMax = Math.max(arr[i], currentMax + arr[i]);
			max = Math.max(currentMax, max);
		}
		
		return max;
		
	}
	
	public static int maxProdContArray(int[] arr) {
		if(arr == null || arr.length<1)
			return -1;
		
		int max = arr[0];
		int currentMax = arr[0];
		
		for(int i=1; i<arr.length; i++) {
			currentMax = Math.max(arr[i], currentMax * arr[i]);
			max = Math.max(currentMax, max);
		}
		
		return max;
		
	}

	public static int smallestSubArray(int[] arr, int target){

	   int currentSum = 0;
	   int minSum = Integer.MAX_VALUE;
	   int wstart = 0;
	   
	   for(int wend = 0; wend<arr.length; wend++){
	   
	       currentSum = currentSum + arr[wend];
		   
		   while(currentSum >= target){
		     
			 minSum = Math.min(minSum, wend-wstart + 1);
			 currentSum = currentSum - arr[wstart];
			 wstart++;
		   
		   }
	   
	   }
	   
	   return minSum;

	}

	public static void main(String[] args) {
		
		System.out.println(" max sum of N contiguos element :::: "+smallestSubArray(new int[] {4,2,1,7,8,1,2,8,1,0}, 3));

	}

}
