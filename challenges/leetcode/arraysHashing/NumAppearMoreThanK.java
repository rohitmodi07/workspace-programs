package leetcode.arraysHashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NumAppearMoreThanK {
	
	/*
     * Input: nums = [5,2,3,2,2,2,2,5,5,5]

       Output: [2,5]
       
       Input: nums = [4,4,4,4,4]

       Output: [4]
       
       Input: nums = [1,2,3]

       Output: []
     */

    public static List<Integer> majorityElement(int[] nums) {
    	
    	if(nums == null || nums.length<1)
    		return new ArrayList<>();
    	
    	List<Integer> ilist = new ArrayList<>();
    	int n = nums.length/3;
    	
    	Map<Integer, Integer> nmap = new HashMap<>();
    	
    	for(int num : nums) {
    		nmap.put(num, nmap.getOrDefault(num, 0)+1);
    	}
    	
    	for(Map.Entry<Integer, Integer> et : nmap.entrySet()) {
    		
    		if(et.getValue()>n) {
    			ilist.add(et.getKey());
    		}
    		
    	}
    	
    	return ilist;
        
    }
    

	public static void main(String[] args) {
		
		int[] nums = {5,2,3,2,2,2,2,5,5,5};
		int[] nums1 = {4,4,4,4,4};
		int[] nums2 = {1,2,3};
		
		System.out.println(majorityElement(nums));
		System.out.println(majorityElement(nums1));
		System.out.println(majorityElement(nums2));
		
	}

}
