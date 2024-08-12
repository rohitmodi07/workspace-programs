package techround;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FindIfArrayIsBalanced {
	
	//{1, 0, -3, 0,-1, 3, 0}  , {-3,-1,1,3}
	
	public static boolean isABalancedTree(int[] arr) {
		if(arr.length<1)
			return false;
		List<Integer> numlist = new ArrayList<>();
		for(int i=0; i<arr.length; i++) {
			if(arr[i] != 0) {
				numlist.add(arr[i]);
			}
		}
		
		System.out.println(" list is ::: "+numlist);
		
		Collections.sort(numlist);
		
		System.out.println(" list is ::: "+numlist);
		
		int i=0;
		int j = numlist.size()-1; // 4,2,6, 1,3,5,7,
		
		if(numlist.size()%2 != 0) {
			return false;
		}
		
		while(i<j) {
			int val = -numlist.get(i);
			if(val != numlist.get(j)) {
				return false;
			}
			i++;
			j--;
		}
		
		return true;
		
	}
	
	public static boolean isABalancedTreeInPlace(int[] arr) {
		
		//{1, 0, -3, 0,-1, 3, 0}  , {-3,-1,1,3}
		
		if(arr.length<1)
			return false;
		Arrays.sort(arr);   //{-3,-1,0,0,1,3} ,  {1, 0, -3, 0,-1, 3, 0, 1} , {-3, -1, 0,0, 1,1, 3}, {-1,-1,1}
		
		int i = 0;
		int j = arr.length-1;
		
		while(i<=j) {
			if(arr[i] !=0 && arr[j] != 0) {
				
				int val = -arr[i];
				if((val != arr[j]) || (arr[i] == arr[j])) {
					return false;
				}
			}else {
				return false;
			}
			i++;
			j--;
			
		}
		
		return true;
		
	}
	
	

	public static void main(String[] args) {
		
		int[] arr = {1,-1,-1, -1, 1,1,-1};
		
		System.out.println(isABalancedTreeInPlace(arr));
		
	}

}
