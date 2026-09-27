package leetcode.slidingWindow;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FindClosestNumber {
	
	/*
	 * Input: arr = [2,4,5,8], k = 2, x = 6

       Output: [4,5]
       
       Input: arr = [2,3,4], k = 3, x = 1

       Output: [2,3,4]
	 */
	
      public static List<Integer> findClosestElementsNew(int[] nums, int k, int x) {
        
    	if(nums == null || nums.length<1 || k<1)
    		return new ArrayList<>();
    	
    	int left = 0;
    	int right = nums.length-1;
    	
    	while(right-1>=k) {
    		
    		if(Math.abs(x-nums[left]) <= Math.abs(x-nums[right])) {
    			right--;
    		}else {
    			left++;
    		}
    		
    	}
    	
    	List<Integer> ilist = new ArrayList<>();
    	
    	for(int i=left; i<=right; i++) {
    		ilist.add(nums[i]);
    	}
    	
    	return ilist;
    	
    	
      }

    public static List<Integer> findClosestElements(int[] nums, int k, int x) {
        
    	if(nums == null || nums.length<1 || k<1)
    		return new ArrayList<>();
    	
    	List<Integer> ilist = new ArrayList<>();
    	
    	for(int i=0; i<nums.length; i++) {     // arr = [2,4,5,8], k = 2, x = 6
    		
    		
    		if(nums[i]>x && i>k) {
    			
    			int j = i-1;
    			
    			while(j>0) {
    				if(k>0) {
    					ilist.add(nums[j]);
    					j--;
    					k--;
    				}else {
    					break;
    				}
    			}
    			
    			Collections.sort(ilist);
    			
    			return ilist;
    		}
    		
    		if(nums[i]>x && i<k) {       // // arr = [2,4,5,8], k = 2, x = 3
    			
                int j = i;
    			
    			while(j>=0) {
    				ilist.add(nums[j]);
    				k--;
    				j--;
    			}
    			
    			j = i+1;
    			
    			while(k>0) {
    				ilist.add(nums[j]);
    				j++;
    				k--;
    			}
    			
    			Collections.sort(ilist);
    			
    			return ilist;
    			
    		}
            
    		
    	}
    	
    	return new ArrayList<>();
    	
    }
	
	
   public static void main(String[] args) {
	
	   
	   int[] nums = {2,4,5,8};
	   System.out.println(findClosestElementsNew(nums, 2, 6));
	   
	   int[] nums1 = {2,3,4};
	   System.out.println(findClosestElementsNew(nums1, 3, 1));
	   
   }

}
