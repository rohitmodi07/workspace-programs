package leetcode.dynamicprograms;

import stages.TestProgram;

public class JumpGame {
	
	public static boolean jumpGame(int[] nums) {
    	if(nums == null || nums.length<1)
    		return false;
    	
    	int jump = nums.length-1;
    	for(int i=nums.length-2; i>=0; i--) {
    		if((i+nums[i])>=jump) {
    			jump = i;
    		}
    	}
    	return jump == 0;
    }


	public static void main(String[] args) {
		
		TestProgram tp = new TestProgram();
		
		System.out.println(" jump possible :::: "+jumpGame(new int[]{3,2,1,0,4}));
		
      
	}

}
