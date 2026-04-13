package leetcode.arraysHashing;

import java.util.Arrays;


public class LongestConsecutiveSequence {
	
	public static int longestConsSeq(int[] nums) {
		if(nums == null || nums.length<1)
			return 0;
		
		Arrays.sort(nums);  // 2,3,4,4,5,10,20
		
		int count = nums[0];
		int k = 1;
		int maxlen = 1;
		int currentMax = 1;
		
		for(int i=k; i<nums.length;i++) {
			
			if(count+1 == nums[i]) {
				count++;
				currentMax++;
			}else {
				if(count == nums[i]) {
					continue;
				}
				count = nums[i];
				maxlen = Math.max(currentMax, maxlen);
				currentMax = 1;
				k = i-1;
			}
		}
		maxlen = Math.max(currentMax, maxlen);
		return maxlen;
		
		
	}
	
	
	

	public static void main(String[] args) {

		int[] nums = {0,3,2,5,4,6,1,1};
		System.out.println(" longest cons subseq :::: "+longestConsSeq(nums));
		
		
	}

}
