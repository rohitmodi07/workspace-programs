package leetcode.arraysHashing;

import java.util.Arrays;

public class LongestIncreasingSeq {
	
	public static int longIncSeq(int[] nums) {
    	if(nums == null || nums.length<1)
    		return -1;
    	
    	Arrays.sort(nums);
    	
    	int num = nums[0];
    	int max = 0;
    	int count = 1;
    	
    	for(int i=1; i<nums.length; i++) {
    		
    		if(nums[i] == num+1) {
    			num = nums[i];
    			count++;
    		}else {
    			if(nums[i] == num) {
    				continue;
    			}
    			num = nums[i];
    			max = Math.max(max, count);
    			count = 1;
    		}
    	}
    	
    	
    	return count>max ? count : max;
    }


	public static void main(String[] args) {
		
		int[] nums = {0,3,2,5,4,6,1,1};
		// [["hat"],["act", "cat"],["stop", "pots", "tops"]]
		
		System.out.println(longIncSeq(nums));
	
	}

}
