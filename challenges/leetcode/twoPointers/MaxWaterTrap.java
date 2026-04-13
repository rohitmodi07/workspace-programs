package leetcode.twoPointers;

public class MaxWaterTrap {
	
	// trapping rain water
		/*
		 * Input: height = [0,2,0,3,1,0,1,3,2,1]              Output: 9

		 */
		
		public static int trapMaxWater(int[] nums) {
			if(nums == null || nums.length<1)
				return -1;
			
			int l=0;
			int r=nums.length-1;
			
			int lmax = nums[l];
			int rmax = nums[r];
			
			int maxWater = 0;
			
			while(l<r) {
				if(lmax<rmax) {
					l++;
					lmax = Math.max(lmax, nums[l]);
					maxWater = maxWater + (lmax-nums[l]);
				}else {
					r--;
					rmax = Math.max(rmax, nums[r]);
					maxWater = maxWater + (rmax-nums[r]);
				}
			}
			return maxWater;
		}
		

		public static void main(String[] args) {

			int[] nums = {0,2,0,3,1,0,1,3,2,1};
			System.out.println(" max water trapped :::: "+trapMaxWater(nums));
			
			
		}

}
