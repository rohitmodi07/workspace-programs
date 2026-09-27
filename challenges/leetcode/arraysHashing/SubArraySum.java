package leetcode.arraysHashing;

import java.util.HashMap;
import java.util.Map;

public class SubArraySum {
	
	/*
     * Input: nums = [2,-1,1,2], k = 2

       Output: 4
       
       Input: nums = [4,4,4,4,4,4], k = 4

       Output: 6
     */

    public static int subarraySum(int[] nums, int k) {
        
    	if(nums == null || nums.length<1)
    		return -1;
    	
  
    	int sumcount = 0;
    	
    	for(int i=0; i<nums.length; i++) {      // 2,-1,1,2
    		
    		int currentSum = 0;
    		
    		for(int j=i; j<nums.length; j++) {
    			
    			currentSum = currentSum + nums[j];
    			if(currentSum == k) {
    				sumcount++;
    			}
    			
    		}
    	}
    	
    	return sumcount;
    	
    }
    

    public static int subarraySum1(int[] nums, int k) {
        
    	if(nums == null || nums.length<1)
    		return -1;
    	
  
    	int sumcount = 0;
    	int currentSum = 0;
    	
    	Map<Integer, Integer> imap = new HashMap<>();
    	imap.put(0, 1);
    	
    	for(int num : nums) {      // 2,-1,1,2   
    		
    		currentSum = currentSum + num;
    		
    		int diff = currentSum-k;
    		
    		sumcount = sumcount + imap.getOrDefault(diff, 0);
    		
    		imap.put(currentSum, imap.getOrDefault(currentSum, 0)+1);
    		
    	}
    	System.out.println(imap);
    	
    	return sumcount;
    	
    }
    

	public static void main(String[] args) {
		
		
		
		int[] nums = {2,-1,1,2};
		System.out.println(subarraySum1(nums, 2));
	}

}
