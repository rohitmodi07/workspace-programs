package techround.microsoft;

import java.util.Arrays;
import java.util.List;

public class FindMissingElement {
	
	public static int findMissingElement(int[] arr) {
		if(arr == null || arr.length<1)
			return -1;
		List<Integer> intlist = Arrays.stream(arr).boxed().toList();
		
		int count = 1;
		
		while(count>0) {
			if(!intlist.contains(count)) {
				return count;
			}
			count++;
		}
		
		return -1;
	}
	
	public static int findMissingElement1(int[] arr) {
		if(arr == null || arr.length<1)
			return -1;
		Arrays.sort(arr);
		
		int count = 1;
		
		for(int i=0; i<arr.length; i++) { //1,2,3,4,5,7,8
			System.out.println(" count is :::: "+count);
			System.out.println(" element is :::: "+arr[i]);
			if(count != arr[i]) {
				return count;
			}
			count++;
		}
		
		return -1;
	}


	public static void main(String[] args) { 
		
		int[] arr = {7,1,2,4,3,8,5};
		
		System.out.println(" find missing element :::: "+findMissingElement1(arr));
    }

}
