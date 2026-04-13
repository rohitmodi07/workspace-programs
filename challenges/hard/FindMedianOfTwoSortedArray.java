package challenges.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FindMedianOfTwoSortedArray {
	
	public static float findMedianSortedArrays(int[] num1, int[] num2) {
		if(num1 == null || num2 == null || num1.length<1 || num2.length<1)
			return -1;
		List<Integer> numset = new ArrayList<>();
		for(int num : num1) {
			numset.add(num);
		}
		for(int num : num2) {
			numset.add(num);
		}
		Collections.sort(numset);
		
		int mid = (numset.size()-1)/2;             // 1,2,3,4
		System.out.println(" mid ::: "+mid);
		float median = 0;
		if(numset.size()>1 && (numset.size())%2 == 0) {
		
			median = (float)(numset.get(mid) + numset.get(mid+1))/2;
		}else {
			
			median = (float)numset.get(mid);
		}
		
		return median;
		
	}
	
	public double findMedianSortedArraysNeet(int[] nums1, int[] nums2) {
        int len1 = nums1.length, len2 = nums2.length;
        int[] merged = new int[len1 + len2];
        System.arraycopy(nums1, 0, merged, 0, len1);
        System.arraycopy(nums2, 0, merged, len1, len2);
        Arrays.sort(merged);

        int totalLen = merged.length;
        if (totalLen % 2 == 0) {
            return (merged[totalLen / 2 - 1] + merged[totalLen / 2]) / 2.0;
        } else {
            return merged[totalLen / 2];
        }
    }
	
	


	public static void main(String[] args) {
		
		int[] num1 = {1,2};
		int[] num2 = {3,4};
		
		System.out.println(" median is :::: "+findMedianSortedArrays(num1, num2));
		
		num1 = new int[]{1,2};
		num2 = new int[]{3};
		
		System.out.println(" median is :::: "+findMedianSortedArrays(num1, num2));
		
	}

}
