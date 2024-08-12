package techround.microsoft;

import java.util.ArrayList;
import java.util.List;

public class FindNumOfElementWhichMakeSum {
	
public static List<Integer> NumFormSum(int[] arr, int sum){
		
		if(arr == null || arr.length<1)
			return new ArrayList<>();
		int totalSum = 0;
		List<Integer> lst = new ArrayList<>();
		for(int i=0; i<arr.length; i++) {
			totalSum = arr[i];
			lst.add(arr[i]);
			boolean findSum = false;
			for(int j=i+1; j<arr.length; j++) {
				totalSum = totalSum + arr[j];
				lst.add(arr[j]);
				if(totalSum == sum) {
					findSum = true;
					break;
				}else if(totalSum>sum){
					lst = new ArrayList<>();
					break;
				}
			}
			if(findSum) {
				break;
			}
			
		}
		return lst;
		
	}


	public static void main(String[] args) {
		
		int[] arr = {1, 4, 20, 3, 10,5};
		
		System.out.println(" longest palindrom :::: "+NumFormSum(arr, 15));
		
	}

}
