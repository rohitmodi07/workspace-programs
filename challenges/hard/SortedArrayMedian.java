package challenges.hard;

import java.util.Arrays;
import java.util.stream.Stream;

public class SortedArrayMedian {
	
	public static double sortedArrMedian(int[] arr1, int[] arr2) {
		if(arr1 == null && arr2 == null)
			return 0;
		float med = 0;
		
		Object[] arr3 = Stream.concat(Arrays.stream(arr1).boxed(), Arrays.stream(arr2).boxed()).toArray();
		
		Integer[] result = Arrays.copyOf(arr3, arr3.length, Integer[].class);
		
		System.out.println(" result :: "+Arrays.toString(result));
		if(result.length%2 == 0) {
			int len = result.length/2;
			
			System.out.println(" result[len] :: "+result[len]);
			System.out.println(" result[len-1] :: "+result[len-1]);
			
			med = (result[len] + result[len-1]);
			
			return med/2;
		}else {
			int len = result.length/2;
			return result[len];
			
		}
		
	}

	public static void main(String[] args) {
		
		int[] arr1 = {1,2};
		int[] arr2 = {3,4};
		
		System.out.println(" median of two sorted array :::: "+sortedArrMedian(arr1, arr2));
	}

}
