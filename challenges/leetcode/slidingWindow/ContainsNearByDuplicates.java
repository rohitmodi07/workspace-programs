package leetcode.slidingWindow;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ContainsNearByDuplicates {
	
	/*
	 * Input: nums = [1,2,3,1], k = 3

       Output: true
       
       Input: nums = [2,1,2], k = 1

       Output: false
	 */

    public static boolean containsNearbyDuplicateOld(int[] nums, int k) {
        
    	if(nums == null || nums.length<1)
    		return false;
    	
    	Map<Integer, List<Integer>> nmap = new HashMap<>();
    	
    	for(int i=0; i<nums.length; i++) {
    		
    		if(!nmap.containsKey(nums[i])) {
    			List<Integer> ilist = new ArrayList<>();
    			ilist.add(i);
    			nmap.put(nums[i], ilist);
    		}else {
    			List<Integer> ilist = nmap.get(nums[i]);
    			if(ilist.size() < 2) {
    				ilist.add(i);
    			}else {
    				int val = ilist.get(1);
    				if(val>i) {
    					ilist.remove(1);
    					ilist.add(i);
    				}
    			}
    			Collections.sort(ilist);
    			
    			nmap.put(nums[i], ilist);
    		}
    	}
    	
    	for(Map.Entry<Integer, List<Integer>> et : nmap.entrySet()) {
    		
    		if(et.getValue().size() == 2) {
    			
    			List<Integer> nlist = et.getValue();
    			if(Math.abs(nlist.get(0)-nlist.get(1))<=k) {
    				return true;
    			}
    			
    		}
    		
    	}
    	
    	return false;
    	
    }

    public static boolean containsNearbyDuplicateNew(int[] nums, int k) {
        if (nums == null || nums.length < 2)
            return false;
        
        // Map to store: Key = the number, Value = its MOST RECENT index
        Map<Integer, Integer> nmap = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            // If we've seen this number before...
            if (nmap.containsKey(nums[i])) {
                int lastIndex = nmap.get(nums[i]);
                
                // Check if the distance meets the requirement
                if (i - lastIndex <= k) {
                    return true;
                }
            }
            
            // Always update the map with the latest index of the number
            nmap.put(nums[i], i);
        }
        
        return false;
    }

	public static void main(String[] args) {
		
		int[] nums = {2,1,2,2};
		System.out.println(containsNearbyDuplicateOld(nums, 2));
	}

}
