package techround.microsoft;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllPairSum {
	
	public static List<List<Integer>> getSumOfTwoNum(int[] arr, int target){
		if(arr == null || arr.length<1)
			return new ArrayList<>();
		
		List<List<Integer>> pairList = new ArrayList<>();
		
		for(int i=0; i<arr.length; i++) {
			List<Integer> ilist = new ArrayList<>();
			for(int j=i+1; j<arr.length; j++) {
				if(arr[i]+arr[j] == target) {
					ilist.add(arr[i]);
					ilist.add(arr[j]);
					pairList.add(ilist);
				}
			}
			
		}
		return pairList;
	}
	
	public static List<List<Integer>> getSumOfTwoNum1(int[] arr, int target){
		if(arr == null || arr.length<1)
			return new ArrayList<>();
		
		List<List<Integer>> pairList = new ArrayList<>();
		
		Arrays.sort(arr);
		
		int j = arr.length-1;
		int i = 0;
		
		while(i<j) {
			if(arr[i]+arr[j]>target) {
				j--;
			}else if(arr[i]+arr[j]<target) {
				i++;
			}else {
				List<Integer> ilist = new ArrayList<>();
				ilist.add(arr[i]);
				ilist.add(arr[j]);
				pairList.add(ilist);
				
				i++;
				j--;
			}
		}
		
		
		return pairList;
	}


	public static void main(String[] args) { 
		
		int[] arr = {7,1,2,6,4,3,8,5};
		
		System.out.println(" pairs which compute the target :::: "+getSumOfTwoNum1(arr, 9));
    }

}
