package leetcode.backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AllSubsets {
	
	/*
	 * Input: nums = [1,2,3]

       Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
	 */
	
    public static Set<List<Integer>> subsets(int[] nums) {
        
    	if(nums == null || nums.length<1)
    		return new HashSet<>();
    	
    	Set<List<Integer>> numList = new HashSet<>();
    	numList.add(new ArrayList<>());
    	
    	if(nums.length == 1) {
    		List<Integer> elist = new ArrayList<>();
        	elist.add(nums[0]);
        	numList.add(elist);
        	return numList;
    	}
    	
    	List<Integer> ilist = new ArrayList<>();
    	
    	for(int i=0; i<nums.length; i++) {
    		
    		ilist.add(nums[i]);
    	}
    	
    	numList.add(ilist);
    	
        for(int i=0; i<nums.length; i++) {
        	List<Integer> elist = new ArrayList<>();
        	elist.add(nums[i]);
        	numList.add(elist);
    	}
    	
    	
    	for(int i=0; i<nums.length; i++) {              // 1,2,3
    		List<Integer> nlist = new ArrayList<>();
    		
    		for(int j=i+1; j<nums.length; j++) {
    			nlist.add(nums[i]);
    			nlist.add(nums[j]);
    			numList.add(nlist);
    			nlist = new ArrayList<>();
    		}
    	}
    	
    	return numList;
    	
    }
    
    public static Set<List<Integer>> subsets2(int[] nums) {
        
    	if(nums == null || nums.length<1)
    		return new HashSet<>();
    	
    	Set<List<Integer>> numList = new HashSet<>();
    	numList.add(new ArrayList<>());
    	
    	if(nums.length == 1) {
    		List<Integer> elist = new ArrayList<>();
        	elist.add(nums[0]);
        	numList.add(elist);
        	return numList;
    	}
    	
    	List<Integer> ilist = new ArrayList<>();
    	
    	for(int i=0; i<nums.length; i++) {
    		
    		ilist.add(nums[i]);
    	}
    	
    	numList.add(ilist);
    	
        for(int i=0; i<nums.length; i++) {
        	List<Integer> elist = new ArrayList<>();
        	elist.add(nums[i]);
        	numList.add(elist);
    	}
    	
    	
    	for(int i=0; i<nums.length; i++) {              // 1,2,3
    		List<Integer> nlist = new ArrayList<>();
    		
    		for(int j=i+1; j<nums.length; j++) {
    			nlist.add(nums[i]);
    			nlist.add(nums[j]);
    			Collections.sort(nlist);
    			numList.add(nlist);
    			nlist = new ArrayList<>();
    		}
    	}
    	
    	return numList;
    	
    }
    
    public static List<List<Integer>> subsets1(int[] nums) {
    	if(nums == null || nums.length<1)
    		return new ArrayList<>();
    	
    	List<List<Integer>> numlist = new ArrayList<>();
    	numlist.add(new ArrayList<>());
    	
    	for(int num : nums) {
    		
    		int size = numlist.size();
    		System.out.println(" size : "+size);
    		System.out.println(" numlist : "+numlist);
    		
    		for(int i=0; i<size; i++) {
    			
    			System.out.println(" numlist value : "+numlist.get(i));
    			
    			List<Integer> sublist = new ArrayList<>(numlist.get(i));
    			
    			sublist.add(num);
    			
    			numlist.add(sublist);
    			
    		}
    		
    	}
    	
    	return numlist;
    }
	
	
	public static void main(String[] args){
		
		int[] nums = {7,7};
		
		System.out.println(subsets2(nums));
		
    }

}
