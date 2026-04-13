package leetcode.dynamicprograms;

import java.util.Arrays;


public class LongestIncContgSubSeq {
	
	// longest increasing subsequence
	
		public static int longestIncSubSequence(int[] nums) { // 9,1,4,2,3,3,7
			
			if(nums == null || nums.length<1)
				return -1;
			int n = nums.length;
			int[] dp = new int[n];
			Arrays.fill(dp, 1);
			
			for(int i=1; i<n; i++) {
				for(int j=0; j<i; j++) {
					if(nums[i]>nums[j]) {
						dp[i] = Math.max(dp[i], dp[j]+1);
					}
				}
			}
			
			return Arrays.stream(dp).max().getAsInt();
			
		}
	    


		public static void main(String[] args) {
			
			
			int[] num = {9,1,4,2,3,3};
			System.out.println(" max product contigous sub array :::: "+longestIncSubSequence(num));
			
			int[] num1 = {0,3,1,3,2,3};
			System.out.println(" max product contigous sub array :::: "+longestIncSubSequence(num1));
	      
		}

}
