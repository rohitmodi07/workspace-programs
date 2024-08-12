package techround;

public class CombinationEqSum {
		
		
		public static int combinationSum4(int[] nums, int target) {
		    if (target == 0) {
		        return 1;
		    }
		    int res = 0;
		    for(int num : nums) {
		    	if(num<=target) {
		    		res = res + combinationSum4(nums, target-num);
		    	}
		    }
		    
		    return res;
		}
		
		public static int combinationSum(int[] nums, int target) {
	        int[] dp = new int[target+1];
	        dp[0] = 1;
	        for (int i = 1; i <= target; i++)
	            for (int n : nums) {
	                if (n <= i) {
	                	dp[i] = dp[i] + dp[i-n];
	                }
	            }
	        return dp[target];
	    }
		

		public static void main(String[] args) {
			
			int[] arr = {1,2,3};
			System.out.println(" number of combination :::: "+combinationSum4(arr, 4));
			
		}
		
}
