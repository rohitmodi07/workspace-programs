package leetcode.dynamicprograms;

import stages.TestProgram;

public class MaxProductContiguosSubArray {

	public static int maxProduct(int[] nums) { // 1,2,-3,4
		if(nums == null || nums.length<1)
			return -1;
		
		int curMax = nums[0];
		int max = nums[0];
		
		for(int i=1; i<nums.length; i++) {
			curMax = curMax*nums[i];
			max = Math.max(max, curMax);
			
			if(curMax<0) {
				curMax = 1;
			}
		}
		return max;
	}
    


	public static void main(String[] args) {
		
		TestProgram tp = new TestProgram();
		
		int[] num = {1,2,-3,4};
		System.out.println(" max product contigous sub array :::: "+maxProduct(num));
		
		int[] num1 = {-2,-1};
		System.out.println(" max product contigous sub array :::: "+maxProduct(num1));
		
		int[] num2 = {-2,6,-3,-10,4};
		System.out.println(" max product contigous sub array :::: "+maxProduct(num2));
      
	}
}
