package leetcode.dynamicprograms;

import java.util.Arrays;

import stages.TestProgram;

public class SumOfLongIncAndDecSequence {
	
	// dynamic programming
	
		public static int longestIncDecSeq(int[] nums) {
			if(nums == null || nums.length<1)
				return -1;
			int n = nums.length;
			int[] dp = new int[n];
			
			Arrays.fill(dp, 1);
			
			for(int i=1; i<n; i++) {
				for(int j=0; j<n; j++) {
					if(nums[i]>nums[j]) {
						dp[i] = Math.max(dp[i], dp[j]+1);
					}
				}
			}
			int incLen =  Arrays.stream(dp).max().orElse(0);
			
	        dp = new int[n];
			
			Arrays.fill(dp, 1);
			
			for(int i=n-2; i>0; i--) {
				for(int j=n-1; j>0; j--) {
					if(nums[i]>nums[j]) {
						dp[i] = Math.max(dp[i], dp[j]+1);
					}
				}
			}
			int decLen =  Arrays.stream(dp).max().orElse(0);
			
			return incLen + decLen;
		}


		public static void main(String[] args) {
			
			TestProgram tp = new TestProgram();
			
			int[] nums = {1,9,3,2,4,7};
			System.out.println(" longest increasing sequence :::: "+longestIncDecSeq(nums));
			
		}

}
