package dynamicprog;

import java.util.Arrays;

public class CombinatioAndRobbers {
	
	/*
	 * Input: nums = [1,2,3], target = 4
		Output: 7
		Explanation:
		The possible combination ways are:
		(1, 1, 1, 1)
		(1, 1, 2)
		(1, 2, 1)
		(1, 3)
		(2, 1, 1)
		(2, 2)
		(3, 1)
	 */
	
	public static int findAllCombination(int[] arr, int target){
		
		if(arr == null || arr.length<1)
			return -1;
		int[] dp = new int[target+1];
		dp[0] = 1;
		
		for(int i=1; i<=target; i++) {
			for(int j=0; j<arr.length; j++) {
				int num = arr[j];
				if(num<=i) {
				  dp[i] = dp[i] + dp[i-num];
				}
			}
		}
		System.out.println(" dp is :::: "+Arrays.toString(dp));
		return dp[target];
		
		
	}
	
	public int combinationSum4(int[] nums, int target) {
        int sumCount[] = new int[target + 1];
        sumCount[0] = 1;
        int sz = nums.length;
        for(int sum = 1; sum <= target; sum++){
            for(int indx = 0; indx < sz; indx++){
                if(nums[indx] <= sum){
                    sumCount[sum] = (sumCount[sum] + sumCount[sum-nums[indx]]);
                }
            }
        }
        return sumCount[target];
    }
	
	/*
	 * nput: nums = [1,2,3,1]
		Output: 4
		Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
		Total amount you can rob = 1 + 3 = 4.
	 */
	
	public static int robMaxAmount(int[] arr) {
		if(arr == null || arr.length<1)
			return -1;
		int max = 0;
		for(int i=0; i<arr.length; i++) {
			
			int sum = 0;
			
			for(int j=i; j<arr.length; j++) {
				sum = sum + arr[j];
				j++;
			}
			
			max = Math.max(max, sum);
		}
		
		return max;
	}
	
	/* the order is: prev2, prev1, num  */
	
	public static int rob(int[] nums) {
	    if (nums.length == 0) 
	    	return 0;
	    
	    int prev1 = 0;
	    int prev2 = 0;
	    for(int num : nums) {
	        int tmp = prev1;
	        prev1 = Math.max(prev2 + num, prev1);
	        prev2 = tmp;
	    }
	    return prev1;
	}
	
	


	public static void main(String[] args) { // 0,0,2  0,2,7  2,7,9  7,9,3  9,3,1 
    	
		System.out.println(" all combination ::: "+rob(new int[] {2,7,9,3,1,4}));
    	
        
    }

}
