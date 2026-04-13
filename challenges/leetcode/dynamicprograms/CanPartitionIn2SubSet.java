package leetcode.dynamicprograms;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CanPartitionIn2SubSet {
	
	public static boolean canPartition(int[] nums) {
        if (Arrays.stream(nums).sum() % 2 != 0) {
            return false;
        }

        Set<Integer> dp = new HashSet<>();
        dp.add(0);
        int target = Arrays.stream(nums).sum() / 2;

        for (int i = nums.length - 1; i >= 0; i--) {
            Set<Integer> nextDP = new HashSet<>();
            for (int t : dp) {
                if (t + nums[i] == target) {
                    return true;
                }
                nextDP.add(t + nums[i]);
                nextDP.add(t);
            }
            dp = nextDP;
        }
        return false;
    }
	

	public static void main(String[] args) {
		
		int[] nums = {1,2,3,4};
		System.out.println(canPartition(nums));
		
	}

}
