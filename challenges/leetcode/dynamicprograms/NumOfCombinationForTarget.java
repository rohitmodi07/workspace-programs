package leetcode.dynamicprograms;

public class NumOfCombinationForTarget {
	
	/*
	 * Input: nums = [2,2,2], target = 2

       Output: 3
	 */

	
	public static int maxNumOfCombination(int[] nums, int target) {
		if(nums == null || nums.length<1)
			return -1;
		
		return numOfCombination(0, 0, nums, target);
	}
	

	private static int numOfCombination(int i, int total, int[] nums, int target) {
		
		if(i == nums.length) {
			return total == target ? 1 : 0;
		}
		
		return numOfCombination(i+1, total+nums[i], nums, target) +
				numOfCombination(i+1, total-nums[i], nums, target);
		
	}

	public static void main(String[] args){       
    
		int[] nums = {2,2,2};
		System.out.println(" number of combos :::: "+maxNumOfCombination(nums, 2));
    	
    }

}
