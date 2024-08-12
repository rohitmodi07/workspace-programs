package challenges.allarray;

import java.util.ArrayList;
import java.util.List;

public class PrintContigousSubArrayCombination {
	
public static List<List<Integer>> printAllCombination(int[] arr) {
		
		if(arr == null || arr.length<1)
			return new ArrayList<>();
		List<List<Integer>> intlist = new ArrayList<>();
		
		for(int i=0; i<arr.length; i++) {
			List<Integer> lst = new ArrayList<>();
			lst.add(arr[i]);
			intlist.add(lst);
			
			for(int j=i+1; j<arr.length; j++) {
				List<Integer> nlist = new ArrayList<>();
				nlist.addAll(lst);
				nlist.add(arr[j]);
				intlist.add(nlist);
			}
		}
		
		return intlist;
		
	}
	
   public static List<List<Integer>> printAllCombination1(int[] arr) {
		
		if(arr == null || arr.length<1)
			return new ArrayList<>();
		List<List<Integer>> intlist = new ArrayList<>();
		
		for(int i=0; i<arr.length; i++) { //1,2,3,4
			
			int j=i;
			
			List<Integer> ilist = new ArrayList<>();
			
			while(j<arr.length) {
				ilist.add(arr[j]);
				List<Integer> nlist = new ArrayList<>(ilist);
				intlist.add(nlist);
				j++;
			}
			
		}
		
		return intlist;
		
	}
   

	public static void main(String[] args) {
		
		int[] arr = {1,2,3,4};
		
		System.out.println(" combinations :::: "+printAllCombination1(arr));
	}

}
