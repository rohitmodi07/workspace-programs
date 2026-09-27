package leetcode.arraysHashing;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FindFirstMissingPositiveNum {
	

    
    /*
     * Input: nums = [-2,-1,0]

       Output: 1
       
       Input: nums = [1,2,4]

       Output: 3
       
       Input: nums = [1,2,4,5,6,3,1]

       Output: 7

     */
    

    public static int firstMissingPositive(int[] nums) {
        
    	if(nums == null || nums.length<1)
    		return -1;
    	
    	int minVal = Integer.MAX_VALUE;
    	
    	Set<Integer> iset = new HashSet<>();
    	
    	for(int i=0; i<nums.length; i++) {   // 1,2,4,5,6,3,1
    		
    		if(nums[i]>=0) {
    			minVal = Math.min(minVal, nums[i]);
    			iset.add(nums[i]);
    		}
    		
    	}
    	
    	while(iset.contains(minVal)) {
    		minVal++;
    	}
    	
    	return minVal;
    	
    }
    
    public static int firstMissingPositive1(int[] nums) {
        Arrays.sort(nums);
        int missing = 1;
        for (int num : nums) {
            if (num > 0 && missing == num) {
                missing++;
            }
        }
        return missing;
    }

}
