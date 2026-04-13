package leetcode.slidingWindow;

import java.util.ArrayList;
import java.util.List;

public class FIndMaxOfEachKElementInArray {

	/*
	 * Input: nums = [1,2,1,0,4,2,6], k = 3

		Output: [2,2,4,4,6]
		
		Explanation: 
		Window position            Max
		---------------           -----
		[1  2  1] 0  4  2  6        2
		 1 [2  1  0] 4  2  6        2
		 1  2 [1  0  4] 2  6        4
		 1  2  1 [0  4  2] 6        4
		 1  2  1  0 [4  2  6]       6

	 */
	
	public static List<Integer> findMaxOfEachKSubArray(int[] nums, int k){
		if(nums == null || nums.length<1)
			return new ArrayList<>();
		List<Integer> numlist = new ArrayList<>();
		
		for(int i=0; i<nums.length-(k-1); i++) {
			int max = 0;
			for(int j=i; j<k+i; j++) {
				max = Math.max(max, nums[j]);
			}
			numlist.add(max);
		}
		
		return numlist;
	}
	
	

	public static void main(String[] args) {

		int[] nums = {1,2,1,0,4,2,6};
		System.out.println(" all max of k element ::::: "+findMaxOfEachKSubArray(nums, 3));
		
	}
}
