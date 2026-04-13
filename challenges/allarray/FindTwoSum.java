package challenges.allarray;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FindTwoSum {
	
	public static List<List<Integer>> findTwoSUm(int[] arr, int target){
		if(arr == null || arr.length<1 || target<0)
			return new ArrayList<>();
		
		Set<Integer> hset = new HashSet<>();
		List<List<Integer>> flist = new ArrayList<>();
		
		for(int i=0; i<arr.length; i++) {
			
			if(hset.contains(arr[i])) {
			  List<Integer> lst = new ArrayList<>();	
			  lst.add(arr[i]);
			  lst.add(target-arr[i]);
			  flist.add(lst);
			}else {
				hset.add(target-arr[i]);
			}
			
		}
		return flist;
	}
	
	public static List<List<Integer>> twoSUm(int[] arr, int target){
		if(arr == null || arr.length<1 || target<0)
			return new ArrayList<>();
		
		
		List<List<Integer>> flist = new ArrayList<>();
		
		for(int i=0; i<arr.length; i++) {
			for(int j=i+1; j<arr.length; j++) {
				if((arr[i]+arr[j]) == target) {
					List<Integer> lst = new ArrayList<>();	
					  lst.add(i);
					  lst.add(j);
					  flist.add(lst);
				}
			}
		}
		
		return flist;
	}
	
	public static List<List<Integer>> findTwoSum(int[] arr, int target){
		if(arr == null || arr.length<1 || target<0)
			return new ArrayList<>();
		
		Map<Integer, Integer> hmap = new HashMap<>();
		List<List<Integer>> flist = new ArrayList<>();
		
		for(int i=0; i<arr.length; i++) {
			
			if(hmap.containsKey(target-arr[i])) {
			  List<Integer> lst = new ArrayList<>();	
			  lst.add(hmap.get(target-arr[i]));
			  lst.add(i);
			  
			  flist.add(lst);
			}else {
				hmap.put(arr[i], i);
			}
			
		}
		return flist;
	}

	public static void main(String[] args) {
        
		int[] arr = {2,7,11,15,6,3};
		System.out.println(" pair :::: "+findTwoSum(arr, 9));
		
    }

}
