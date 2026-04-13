package leetcode.slidingWindow;

import java.util.ArrayList;
import java.util.List;

public class SlidingWindowMax {
	
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
	
	public static List<Integer> maxSlidingWindow(int[] nums, int k) {
        if(nums == null || nums.length<1)
        	return new ArrayList<>();
        
        List<Integer> maxvalList = new ArrayList<>();
        
        
        for(int i=0; i<=nums.length-k; i++) {
        	
        	List<Integer> lst = new ArrayList<>();
        	int l = i;
        	int j= i+(k-1);
        	while(l<=j) {
        		lst.add(nums[l]);
        		l++;
        	}
        	
        	int maxVal = lst.stream().mapToInt(v -> v).max().getAsInt();
        	maxvalList.add(maxVal);
        	
        }
        return maxvalList;
    }
	
	public static List<Integer> slidingWindowMax(int[] nums, int k){
		if(nums == null || nums.length<1 || k<1 || k>=nums.length-1)
			return new ArrayList<>();
		
		List<Integer> nlist = new ArrayList<>();
		
		for(int i=0; i<=nums.length-k; i++) {
			
			List<Integer> lst = new ArrayList<>();
			int j=0;
			while(j<k) {
				lst.add(nums[i+j]);
				j++;
			}
			System.out.println(" lst ::: "+lst);
			int max = lst.stream().mapToInt(val -> val).max().getAsInt();
			nlist.add(max);
			
		}
		
		return nlist;
	}
   

	public static void main(String[] args) {
		
		int[] nums = {1,2,1,0,4,2,6};
		System.out.println(" max of three num in all contigous numbers :::: "+maxSlidingWindow(nums, 2));
      
	}

}
