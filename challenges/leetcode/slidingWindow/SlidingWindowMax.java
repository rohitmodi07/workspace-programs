package leetcode.slidingWindow;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
	
	
    public static Optional<int[]> maxSlidingWindowNew(int[] nums, int k) {
        
    	if(nums == null || nums.length<1)
    		return Optional.empty();
    	
    	List<Integer> ilist = new ArrayList<>();
    	
    	for(int i=0; i<=nums.length-k; i++) {   // 0,3   1,4   2,5
    		
    		int t = i;
    		int j = t+k;
    		int max = Integer.MIN_VALUE;
    		
    		while(t<j) {
    			max = Math.max(max, nums[t]);
    			t++;
    		}
    		
    		ilist.add(max);
    		
    	}
    	
    	return Optional.of(ilist.stream().mapToInt(Integer::intValue).toArray());
    }
    
    public static int[] maxSlidingWindowLatest(int[] nums, int k) {
        
    	if(nums == null || nums.length<1 || k<1)
    		return null;
    	
    	int n = nums.length;
    	
    	int[] result = new int[n-k+1];
    	
    	for(int left=0; left<=n-k; left++) {
    		
    		int max = Integer.MIN_VALUE;
    		
    		for(int right=left; right<left+k; right++) {
    			
    			max = Math.max(max, nums[right]);
    			
    		}
    		
    		result[left] = max;
    		
    	}
    	
    	return result;
    	
    }
   

	public static void main(String[] args) {
		
		int[] nums = {1,2,1,0,4,2,6};
		System.out.println(" max of three num in all contigous numbers :::: "+maxSlidingWindow(nums, 2));
      
	}

}
