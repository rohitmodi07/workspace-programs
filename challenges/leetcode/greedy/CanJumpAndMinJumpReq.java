package leetcode.greedy;

public class CanJumpAndMinJumpReq {
	
	// jump 1
	/*
	 * Input: nums = [1,2,0,1,0]

       Output: true
	 */
	
	public static boolean canJump(int[] nums) {
		if(nums == null || nums.length<1)
			return false;
		int jump = nums.length-1;
		
		for(int i=nums.length-2; i>=0; i--) {
			if(i+nums[i]>=jump) {
				jump = i;
			}
		}
		return jump == 0;
	}
	
	/*
	 * Input: nums = [2,4,1,1,1,1]

       Output: 2
	 */
	
	public static int minNumOfJumpReq(int[] nums) {
		if(nums == null || nums.length<1)
			return -1;
		
		int left=0;
		int right=0;
		int res = 0;
		
		while(right<nums.length-1) {   // 2,4,1,1,1,1
			
			int farthest = 0;
			for(int i=left; i<=right; i++) {
				farthest = Math.max(farthest, i+nums[i]);
			}
			
			left = right+1;
			right = farthest;
			res++;	
		}
		
		return res;
	}
	

	public static void main(String[] args) throws InterruptedException{
		
		int[] coins = {1,2,1,0,1};
		
		System.out.println(canJump(coins));
		
    }

}
