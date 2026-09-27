package leetcode.arraysHashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindMajorityElement {

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
    	
    	Map<Integer, Integer> nmap = new HashMap<>();
    	
    	for(int i=0; i<nums.length; i++) {
    		nmap.put(nums[i], nmap.getOrDefault(nums[i], 0)+1);
    	}
    	
    	int threashold = nums.length/3;
    	List<Integer> ilist = new ArrayList<>();
    	
    	for(Map.Entry<Integer, Integer> et : nmap.entrySet()) {
    		
    		if(et.getValue()>threashold) {
    			ilist.add(et.getKey());
    		}
    	}
    	
    	return ilist;
    	
    }
}
