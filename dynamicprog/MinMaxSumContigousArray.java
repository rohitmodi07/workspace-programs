package dynamicprog;

import java.util.Arrays;

public class MinMaxSumContigousArray {
	
	public static void fib(int n) {
		
		for(int i=0; i<=n; i++) {
			int[] cache = new int[i+1];
			System.out.println(" fib number "+findfibDP(i, cache));
		}
	}

	private static int findfib(int i) {
		
		if(i<2)
			return i;
		return findfib(i-1)+findfib(i-2);
	}
	
    private static int findfibDP(int i, int[] cache) {
    	
		
		if(i<2)
			return i;
		if(cache[i] == i) {
			return cache[i];
		}else {
			cache[i] = findfibDP(i-1, cache) + findfibDP(i-2, cache);
		}
		return cache[i];
	}
    
    public static int minSumArray(int[] arr) { //-6,3,4,-2,-3,1,-3
    	
    	if(arr == null || arr.length<1)
    		return -1;
    	int minsum = 0;
    	
    	for(int i=0; i<arr.length; i++) {
    		int sum = arr[i];
    		for(int j=i+1; j<arr.length; j++) {
    			sum = sum + arr[j];
    			minsum = minsum>sum ? sum : minsum;
    		}
    	}
    	
    	return minsum;
    }
    
    public static int minSumArrayDP(int[] arr) { //-6,3,4,-2,-3,1,-3
    	
    	if(arr == null || arr.length<1)
    		return -1;
    	int minsum = arr[0];
    	int[] dp = new int[arr.length];
    	
    	Arrays.fill(dp, 0);
    	dp[0] = arr[0];
    	
    	
    	for(int i=1; i<arr.length; i++) {
    		
    		int currentMin = Math.min(arr[i], arr[i]+dp[i-1]);
    		
    		dp[i] = currentMin;
    		minsum = Math.min(minsum, currentMin);
    		
    	}
    	System.out.println(" dp array ::: "+Arrays.toString(dp));
    	
    	return minsum;
    }
    
   public static int maxSumArrayDP(int[] arr) { //-6,3,4,-2,-3,1,-3
    	
    	if(arr == null || arr.length<1)
    		return -1;
    	int maxsum = arr[0];
    	int[] dp = new int[arr.length];
    	
    	Arrays.fill(dp, 0);
    	dp[0] = arr[0];
    	
    	
    	for(int i=1; i<arr.length; i++) {
    		
    		int currentMin = Math.max(arr[i], arr[i]+dp[i-1]);
    		
    		dp[i] = currentMin;
    		maxsum = Math.max(maxsum, currentMin);
    		
    	}
    	System.out.println(" dp array ::: "+Arrays.toString(dp));
    	
    	return maxsum;
    }

	public static void main(String[] args) {
		
		int[] arr = {7,1,5,3,6,4};
		
	    //fib(10);
		
		int[] arr1 = {-6,3,4,-2,-3,1,-3};
		
		System.out.println(" min sum :::: "+minSumArray(arr1));
		
    }

}
