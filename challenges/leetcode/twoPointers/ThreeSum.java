package leetcode.twoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ThreeSum {
	
	// three sum
		/*
		 * Input: nums = [-1,0,1,2,-1,-4]    Output: [[-1,-1,2],[-1,0,1]]
		 * Input: nums = [0,1,1]             Output: []
		 * Input: nums = [0,0,0]             Output: [[0,0,0]]
		 */
		
		public static Set<List<Integer>> threeSum(int[] nums, int target){
			if(nums == null || nums.length<1)
				return new HashSet<>();
			
			Set<List<Integer>> tripletList = new HashSet<>();
			int n = nums.length;
			
			Arrays.sort(nums);
			
			for(int i=0; i<n-2; i++) {
				
				int l = i+1;
				int r = n-1;
				
				while(l<r) {
					if((nums[i]+nums[l]+nums[r])>target) {
						r--;
					}else if((nums[i]+nums[l]+nums[r])<target) {
						l++;
					}else {
						List<Integer> lt = new ArrayList<>();
						lt.add(nums[i]);
						lt.add(nums[l]);
						lt.add(nums[r]);
						
						tripletList.add(lt);
						
						l++;
						r--;
					}
				}
			}
			
			return tripletList;
		}
		
		

		public static void main(String[] args) {

			int[] nums = {-1,0,1,2,-1,-4};
			System.out.println(" two sum 2 :::: "+threeSum(nums, 0));
			
			int[] nums1 = {0,1,1};
			System.out.println(" two sum 2 :::: "+threeSum(nums1, 0));
			
			int[] nums2 = {0,0,0};
			System.out.println(" two sum 2 :::: "+threeSum(nums2, 0));
			
			
			int[] nums3 = {1,4,3,2,5,6,8,7};
			System.out.println(" two sum 2 :::: "+threeSum(nums3, 11));
			
			
		}

}
