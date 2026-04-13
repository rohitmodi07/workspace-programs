package leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CombinationSum2 {
	
	/*
	 * Input: candidates = [9,2,2,4,6,1,5], target = 8

		Output: [
		  [1,2,5],
		  [2,2,4],
		  [2,6]
		]
	 */
	
    public static List<List<Integer>> combinationSum2(int[] nums, int target) {
        if(nums == null || nums.length<1)
        	return new ArrayList<>();
        
        List<List<Integer>> numlist = new ArrayList<>();
        
        Arrays.sort(nums);
        
        for(int i=0; i<nums.length; i++) {
        	
        	
        	int k=i+1;
        	int j=nums.length-1;
        	
        	while(k<j) {
        		
        		if(nums[i]+nums[j]+nums[k]>target) {
        			j--;
        		}else if(nums[i]+nums[j]+nums[k]<target) {
        			k++;
        		}else {
        			List<Integer> lst = new ArrayList<>();
        			lst.add(nums[i]);
        			lst.add(nums[j]);
        			lst.add(nums[k]);
        			
        			numlist.add(lst);
        			k++;
        			j--;
        		}
        		
        	}
        }
        
       Set<Integer> nset = new HashSet<>();
       
       for(int i=0; i<nums.length; i++) {
    	   if(nums[i] == target) {
    		   List<Integer> nlist = new ArrayList<>();
    		   nlist.add(nums[i]); 	
    		   
    		   numlist.add(nlist);
    		   
    	   }else if(nset.contains(nums[i])){
    		   List<Integer> nlist = new ArrayList<>();
    		   nlist.add(nums[i]);
    		   nlist.add(target-nums[i]);
    		   
    		   numlist.add(nlist);
    	   }else {
    		   nset.add(target-nums[i]);
    	   }
       }
       
       return numlist;
        
        
    } 
	
	
	public static void main(String[] args){
		int[] nums = {9,2,2,4,6,1,5};
		System.out.println(combinationSum2(nums, 8));
		
    }

}
