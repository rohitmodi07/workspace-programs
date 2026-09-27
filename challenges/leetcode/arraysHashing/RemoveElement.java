package leetcode.arraysHashing;

import java.util.Arrays;

public class RemoveElement {
	
	/*
     * Input: nums = [3,2,2,3], val = 3

       Output: k = 2, nums = [2,2,_,_]
     */

    public static int removeElement(int[] nums, int val) {
        
    	if(nums == null || nums.length<1)
    		return -1;
    	
    	int i=0;
    	int j=nums.length-1;
    	
    	while(i<j) {                                // 3,2,2,1,3,4    4,2,2,1,3,3
    		
    		if(nums[i] != val) {    
    			i++;
    		}else if(nums[j] == val) {
    			j--;
    		}else {
    			int temp = nums[i];
    			nums[i] = nums[j];
    			nums[j] = temp;
    			
    			i++;
    			j--;
    		}
    		
    	}
    	
    	int count = 0;
    	
    	for(int right=nums.length-1; right>=0; right--) {
    		
    		if(nums[right] == val) {
    			nums[right] = 0;
    			count++;
    		}
    		
    	}
    	System.out.println(Arrays.toString(nums));
    	
    	return nums.length-count;
    	
    }

    
	public static void main(String[] args) {
		
		int[] nums = {3,2,2,1,3,4};
		int[] nums1 = {3,2,2,3};
		System.out.println(removeElement(nums1, 3));
		
	}

}
