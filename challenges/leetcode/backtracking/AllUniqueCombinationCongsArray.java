package leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

import stages.TestProgram;

public class AllUniqueCombinationCongsArray {
	
	public static List<List<Integer>> findAllCombinationSum(int[] nums, int target){
		if(nums == null || nums.length<1)
			return new ArrayList<>();
		
		List<List<Integer>> comboList = new ArrayList<>();
		List<Integer> numlist = new ArrayList<>();
		
		for(int i=0; i<nums.length; i++) {
			int num = nums[i];
			int tar = target;
			
			while(tar>=num) {
				numlist.add(num);
				tar = tar-num;
			}
		}
		
		System.out.println(" numlist :::: "+numlist);
		
		int curMax = 0;
		List<Integer> nlist = new ArrayList<>();
		int j=0;
		
		for(int i=j; i<numlist.size(); i++) {
			
			
			curMax = curMax + numlist.get(i);
		
			
			if(curMax>target) {
				j++;
				i=j;
				curMax = 0;
				nlist = new ArrayList<>();
			}else if(curMax == target){
				nlist.add(numlist.get(i));
				comboList.add(nlist);
			}else {
				nlist.add(numlist.get(i));
			}
		}
		
		return comboList;
	}
	


	public static void main(String[] args) {
		
		TestProgram tp = new TestProgram();
		
		int[] arr = {3,4,5}; // 7,4,3,0   2,2,2,2,5,6,9
		
		System.out.println(findAllCombinationSum(arr, 16));
      
	}

}
