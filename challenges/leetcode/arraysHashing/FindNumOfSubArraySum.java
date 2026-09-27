package leetcode.arraysHashing;

import java.util.HashMap;
import java.util.Map;

public class FindNumOfSubArraySum {
	
	/*
     * Input: nums = [2,-1,1,2], k = 2

       Output: 4
       
       Input: nums = [4,4,4,4,4,4], k = 4

       Output: 6
     */
    

    public static int subarraySum(int[] nums, int k) {
        
    	if(nums == null || nums.length<1 || k<1)
    		return -1;
    	
    	int count = 0;
    	
    	for(int i=0; i<nums.length; i++) {      // [2,-1,1,2], k = 2
    		int num1 = nums[i];
    		if(num1 == k) {
    			count++;
    		}
    		
    		int sum = num1;
    		
    		for(int j=i+1; j<nums.length; j++) {
    			
    			int num2 = nums[j];
    			sum = sum + num2;
    			if(sum == k) {
        			count++;
        		}
    		}
    	}
    	
    	return count;
    	
    }
    

    public static int subarraySum1(int[] nums, int k) {
        
    	if(nums == null || nums.length<1 || k<1)
    		return -1;
    	
    	int result = 0;
    	int currentSum = 0;
    	
    	Map<Integer, Integer> nmap = new HashMap<>();
    	nmap.put(0, 1);
    	
    	
    	for(int i=0; i<nums.length; i++) {
    		
    		int num = nums[i];
    		currentSum = currentSum+num;
    		System.out.println(" currentSum - "+currentSum);
    		
    		int diff = currentSum-k;
    		System.out.println(" diff - "+diff);
    		
    		result = result + nmap.getOrDefault(diff, 0);
    		
    		System.out.println(" result - "+result);
    		nmap.put(currentSum, nmap.getOrDefault(currentSum, 0)+1);
    		
    		System.out.println(" nmap - "+nmap);
    		
    	}
    	
    	return result;
    	
    }

}
