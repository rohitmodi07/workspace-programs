package leetcode.arraysHashing;

import java.util.Arrays;

public class ArrayConcatenation {
	
	/*
     * Input: nums = [1,4,1,2]

       Output: [1,4,1,2,1,4,1,2]
       
       Input: nums = [22,21,20,1]

       Output: [22,21,20,1,22,21,20,1]
     */

    public static int[] getConcatenation(int[] nums) {
        
    	if(nums == null || nums.length<1)
    		return null;
    	
    	int n = nums.length;
    	
    	int[] newnums = new int[2*n];
    	
    	for(int i=0; i<n; i++) {
    		newnums[i] = nums[i];
    		newnums[i+n] = nums[i];
    	}
    	
    	return newnums;
    	
    }
    

    public static int[] getConcatenationNew(int[] nums, int k) {
        
    	if(nums == null || nums.length<1 || k<1)
    		return null;
    	
    	int n = nums.length;
    	
    	int[] newnums = new int[k*n];
    	int cnt = 0;
    	
    	while(k>0) {
    		
    		for(int i=0; i<n; i++) {
        		newnums[cnt] = nums[i];
        		cnt++;
        	}
    		k--;
    	}
    	
    	return newnums;
    	
    }
    

	public static void main(String[] args) {
		
		int[] nums = {1,4,3,6};
		System.out.println(Arrays.toString(getConcatenationNew(nums, 3)));
		
	}

}
