package leetcode.binarysearch;

public class FindMinInRotatedArray {
	
	// find minimum in the rotated array
	
		public static int findMinInRotatedArray(int[] nums) {  // 3,4,5,6,1,2    4,5,6,1,2,3     5,6,1,2,3,4    
			if(nums == null || nums.length<1)
				return -1;
			int start = 0;
			int end = nums.length-1;
			int min = Integer.MAX_VALUE;
			
			while(start<=end) {
				
				int mid = (start+end)/2;
				
				
				
				if(nums[mid]>nums[end] && nums[mid]<nums[mid+1]) {
					start = mid;
				}else if(nums[mid]<nums[end] && nums[mid]<nums[mid-1]) {
					return nums[mid];
				}else if(nums[mid]>nums[mid+1]) {
					return nums[mid+1];
				}
				start++;
				end--;
				
				
			}
			return -1;
		}
		
		public static int findMin(int[] nums) { //4,5,6,1,2,3
			
			if(nums == null || nums.length<1)
				return -1;
	        int start = 0;
	        int end = nums.length - 1;

	        while (start < end) {
	            int mid = start + (end - start) / 2;
	            if (nums[mid] < nums[end]) {
	                end = mid;
	            } else {
	                start = mid + 1;
	            }
	        }
	        return nums[start];
	    }
		


		public static void main(String[] args) {
			
			int[] nums = {3,4,5,6,1,2};
			int[] nums1 = {4,5,6,1,2,3};
			int[] nums2 = {5,6,1,2,3,4};
			
			System.out.println(" min number is :::: "+findMin(nums));
			System.out.println(" min number is :::: "+findMin(nums1));
			System.out.println(" min number is :::: "+findMin(nums2));
	      
		}

}
