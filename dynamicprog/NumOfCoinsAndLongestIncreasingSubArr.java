package dynamicprog;

import java.util.Arrays;

public class NumOfCoinsAndLongestIncreasingSubArr {
	
	//climb stairs
		private int[] cache;

		public NumOfCoinsAndLongestIncreasingSubArr(int[] cache){
	        this.cache = cache;
	    }

	    int fibonacci(int n) {
	        if (cache[n] == 0) {
	            if (n < 2) { 
	            	cache[n] = n;
	            }else {
	            	cache[n] = fibonacci(n-1) + fibonacci( n-2);
	            }
	        }

	        return cache[n];
	    }
	    
	    public static int findNumOfCoin(int[] coins, int amount) {
	    	if(coins == null || coins.length<1)
	    		return -1;
	    	int[] dp = new int[amount+1];
	    	Arrays.fill(dp, amount+1);
	    	dp[0] = 0;
	    	
	    	for(int i=1; i<=amount; i++) {
	    		for(int c : coins) {
	    			if(i>=c) {
	    			   dp[i] = Math.min(dp[i], dp[i-c]+1);
	    			}
	    		}
	    	}
	    	
	    	return dp[amount];
	    	
	    }
	    
	    public static int longestIncreasingSubString(int[] arr) { //10,9,2,5,3,7,101,18
	    	if(arr == null || arr.length<1)
	    		return -1;
	    	int maxLen = 0;
	    	int count = 1;
	    	for(int i=0; i<arr.length-1; i++) {
	    		
	    		
	    		if(arr[i]<arr[i+1]) {
	    			count++;
	    		}
	  
	    		
	    		System.out.println(" for i ::: "+i);
	    		System.out.println(" count is ::::: "+count);
	    		maxLen = Math.max(maxLen, count);
	    	}
	    	return maxLen;
	    }
	    
	    public static int lengthOfLIS(int[] nums) {               //10,9,2,5,3,7,101,18
	        if (nums == null || nums.length == 0) {
	            return 0;
	        }

	        int n = nums.length;
	        int[] dp = new int[n];
	        Arrays.fill(dp, 1);

	        for (int i = 1; i < n; ++i) {
	            for (int j = 0; j < i; ++j) {
	                if (nums[i] > nums[j]) {
	                    dp[i] = Math.max(dp[i], dp[j] + 1);
	                }
	            }
	        }
	        
	        System.out.println(" dp is :::: "+Arrays.toString(dp));

	        int maxLength = Arrays.stream(dp).max().orElse(0);
	        return maxLength;
	    }

	    public static void main(String[] args) {
	        int n = 6;
	        //System.out.println(new TestProgram(new int[n+1]).fibonacci(n));
	        
	        //System.out.println(" number of coin requires :::: "+findNumOfCoin(new int[] {1,2,5}, 11));
	        
	        int[] arr = {10,9,2,5,3,7,101,18};
	        
	        System.out.println(" longest increasing numbers len :::: "+lengthOfLIS(arr));
	    }

}
