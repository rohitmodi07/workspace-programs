package leetcode.dynamicprograms;

import java.util.Arrays;

public class NumOfCoinsAndLongestIncreasingSubArr {
	
	    
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
	    
	    public static int minNumOfCoins(int[] coins, int amount) { // 1,5,7  11
	 	   
	 	   if(coins == null || coins.length<1)
	 		   return -1;
	 	   Arrays.sort(coins);
	 	   
	 	   int rem = amount;
	 	   int count = 0;
	 	   int min = Integer.MAX_VALUE;
	 	   
	 	   for(int i=coins.length-1; i>=0; i--) {
	 		   for(int j=i; j>=0; j--) {
	 			   
	 			   while(rem>=coins[j]) {
	 				   count++;
	 				   rem = rem - coins[j];
	 			   }
	 			   if(rem == 0) {
	 				   min = Math.min(min, count);
	 				   count = 0;
	 				   break;
	 			   }
	 			   
	 		   }
	 		   rem = amount;
	 		   
	 	   }
	 	   return min;
	 	   
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
