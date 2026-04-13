package leetcode.twoPointers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class TwoSumFirstPairOnly {
	
	// two sum
		/*
		 * Input: numbers = [1,2,3,4], target = 3   Output: [1,2]

		 */
		
		public static List<Integer> twoSum2(int[] nums, int target){ // 2-0, 
			if(nums == null || nums.length<1)
				return new ArrayList<>();
			
			Map<Integer, Integer> nmap = new HashMap<>();
			List<Integer> nlist = new ArrayList<>();
			
			for(int i=0; i<nums.length; i++) {
				
				if(!nmap.containsKey(nums[i])) {
					nmap.put(target-nums[i], i);
				}else {
					nlist.add(target-nums[i]);
					nlist.add(nums[i]);
					break;
				}
				
			}
			return nlist;
		}
		
		public static Optional<List<Integer>> twoNumSum(int[] nums, int target) {
			if(nums == null || nums.length<1)
				return Optional.empty();
			
			int l=0;
			int r=nums.length-1;
			List<Integer> lst = new ArrayList<>();
			
			int curVal = 0;
			
			while(l<r) {
				curVal = nums[l] + nums[r];
				
				if(curVal>target) {
					r--;
				}else if(curVal<target) {
					l++;
				}else {
					lst.add(nums[l]);
					lst.add(nums[r]);
					
					return Optional.of(lst);
				}
			}
			return Optional.empty();
		}
		
		

		public static void main(String[] args) {

			int[] nums = {1,2,3,4};
			
			//System.out.println(" two sum 2 :::: "+twoSum2(nums, 3));
			//System.out.println(" two sum 2 :::: "+twoSum2(nums, 5));
			
			System.out.println(" two sum 2 :::: "+twoNumSum(nums, 3));
			System.out.println(" two sum 2 :::: "+twoNumSum(nums, 5));
			
			
		}

}
