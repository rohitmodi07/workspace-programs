package leetcode.arraysHashing;

import java.util.HashSet;
import java.util.Set;


public class FirstMissingPositiveNumber {
	
public static int findFirstMissingPositive1(int[] nums) {
    	
    	if(nums == null || nums.length<1)
    		return -1;
    	
        Set<Integer> iset = new HashSet<>();
    	
    	for(int num: nums) {
    		iset.add(num);
    	}
    	
    	//Arrays.sort(nums);
    	
    	int missing = 1;
    	
    	while(iset.contains(missing)) {
    		
    		missing++;
    		
    	}
    	
    	return missing;
    	
    }
    

	public static void main(String[] args) {
		
		
		int[] nums = {-2,-1,0};
		int[] nums1 = {1,2,4};
		int[] nums2 = {1,2,4,5,6,3,1};
		int[] nums3 = {2,1,3};
		
		System.out.println(findFirstMissingPositive1(nums));
		System.out.println(findFirstMissingPositive1(nums1));
		System.out.println(findFirstMissingPositive1(nums2));
		System.out.println(findFirstMissingPositive1(nums3));
	}

}
