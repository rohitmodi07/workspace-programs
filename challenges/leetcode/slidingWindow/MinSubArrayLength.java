package leetcode.slidingWindow;


public class MinSubArrayLength {
	
	/*
	 * 
	 * Input: target = 10, nums = [2,1,5,1,5,3]

       Output: 3
       
       Input: target = 5, nums = [1,2,1]

       Output: 0
	 * 
	 */

    public static int minSubArrayLen(int target, int[] nums) {
        
    	if(nums == null || nums.length<1)
    		return -1;
    	
    	int minLen = Integer.MAX_VALUE;
    	int currentSum = 0;
    	int left = 0;
    	
    	for(int i=0; i<nums.length; i++) {          // 2,1,5,1,5,3    10
    		
    		currentSum = currentSum + nums[i];
    		
    		
    		while(currentSum>=target) {
    			
    			minLen = Math.min(minLen, i-left+1);
    			currentSum = currentSum - nums[left];
    			left++;
    		}
    		
    	}
    	
    	System.out.println(" currentSum - "+currentSum);
    	System.out.println(" left - "+left);
    	
    	
    	return minLen == Integer.MAX_VALUE ? 0 : minLen;
    	
    }
	
	
   public static void main(String[] args) {
	
	   
	   int[] nums = {2,1,5,1,5,3};
	   System.out.println(minSubArrayLen(10, nums));
	   
	   int[] nums1 = {1,2,1};
	   System.out.println(minSubArrayLen(5, nums1));
	   
   }

}
