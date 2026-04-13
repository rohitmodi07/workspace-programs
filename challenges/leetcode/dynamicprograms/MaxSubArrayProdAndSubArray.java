package leetcode.dynamicprograms;

import java.util.ArrayList;
import java.util.List;

public class MaxSubArrayProdAndSubArray {
	
	public static int maxProdSubArray(int[] nums) {
		if(nums == null || nums.length<1)
			return -1;
		
		int maxProd = nums[0];
		int minProd = nums[0];
		int res = nums[0];
		
		for(int i=1; i<nums.length; i++) {
			int current = nums[i];
			
			if(current<0) {
				int temp = minProd;
				minProd = maxProd;
				maxProd = temp;
			}
			
			maxProd = Math.max(current, maxProd*current);
			minProd = Math.min(current, minProd*current);
			
			res = Math.max(res, maxProd);
		}
		return res;
	}
	
	// find the array which computes max prod array
	
	public static List<Integer> maxProdSubArrayList(int[] nums){
		if(nums == null || nums.length<1)
			return new ArrayList<>();
		
		int maxProd = nums[0];
		int minProd = nums[0];
		int res = nums[0];
		
		int tempStart = 0;
		int finalStart = 0;
		int finalEnd = 0;
		
		for(int i=1; i<nums.length; i++) {
			int current = nums[i];
			
			if(current<0) {
				int temp = minProd;
				minProd = maxProd;
				maxProd = temp;
			}
			
			if(current>maxProd*current) {
				maxProd = current;
				tempStart = i;
			}else {
				maxProd = maxProd*current;
			}
			
			minProd = Math.min(current, minProd*current);
			
			if(maxProd>res) {
				res = maxProd;
				finalStart = tempStart;
				finalEnd = i;
			}
			
		}
		List<Integer> lst = new ArrayList<>();
		
		for(int j=finalStart; j<=finalEnd; j++) {
			lst.add(nums[j]);
		}
		
		return lst;
	}


	public static void main(String[] args){
		
		//TestProgram tp = new TestProgram();
		int[] nums = {-2,6,-3,-10,4};
		
		System.out.println(" max prod :::: "+maxProdSubArrayList(nums));
		
	}

}
