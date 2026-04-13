package leetcode.binarysearch;

public class FindIfAValExistInRotatedArray {
	
	// search an element in rotated array
	
		
	public static int search(int[] nums, int target) {
		
		if(nums == null || nums.length<1)
			return -1;
		
        int start = 0;
        int end = nums.length - 1;

        while(start <= end) {

            int mid = start + (end - start) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            if (nums[start] <= nums[mid]) {                        // 4,5,6,7,8,1,2,3
                if (target > nums[mid] || target < nums[start]) {   // 
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            } else {
                if (target < nums[mid] || target > nums [end]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }

        }

        return -1;
    }
	
	
	public static boolean doesKeyExist(int[] nums, int target) { // 4,5,6,1,2,3
		if(nums == null || nums.length<1)
			return false;
		int start = 0;
		int end = nums.length-1;
		
		while(start <= end) {
			int mid = start + (end-start)/2;
			
			if(target == nums[mid]) {
				return true;
			}
			
			if(nums[start]<=nums[mid]) {
				if(target>nums[mid] || target<nums[start]) {
					start = mid+1;
				}else {
					end = mid-1;
				}
			}else {
				if(target<nums[mid] || target>nums[end]) {
					end = mid-1;
				}else {
					start = mid+1;
				}
			}
		}
		return false;
	}
		


	public static void main(String[] args) {
		
		int[] nums = {3,4,5,6,1,2};
		int[] nums1 = {4,5,6,1,2,3};
		int[] nums2 = {5,6,1,2,3,4};
		
		
		System.out.println(" key found :::: "+search(nums, 6));
		
      
	}

}
