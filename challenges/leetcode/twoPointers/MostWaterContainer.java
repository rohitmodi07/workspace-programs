package leetcode.twoPointers;

public class MostWaterContainer {
	
	// container with most water
		/*
		 * Input: height = [1,7,2,5,4,7,3,6]          Output: 36
		 * Input: height = [2,2,2]                    Output: 4
		 */
		
		public static int mostWaterContainer(int[] nums) {
			if(nums == null || nums.length<1)
				return -1;
			
			int maxWater = 0;
			int i=0;
			int j=nums.length-1;
			
			while(i<j) {
				
				int curmax = Math.min(nums[i], nums[j])*(j-i);
				
				maxWater = Math.max(maxWater, curmax);
				
				if(i<j) {
					i++;
				}else {
					j--;
				}
				
			}
			return maxWater;
		}
		
		
		

		public static void main(String[] args) {

			int[] nums = {1,7,2,5,4,7,3,6};
			System.out.println(" max water container :::: "+mostWaterContainer(nums));
			
			int[] nums1 = {2,2,2};
			System.out.println(" max water container :::: "+mostWaterContainer(nums1));
			
			
		}

}
