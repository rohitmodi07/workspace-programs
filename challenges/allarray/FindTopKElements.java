package challenges.allarray;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FindTopKElements {
	
	public static Set<Integer> topKElement(int[] arr, int k){ // 1,2,2,3,3,3
		if(arr == null || arr.length<1 || k<1)
			return new LinkedHashSet<>();
		Set<Integer> lst = new LinkedHashSet<>();
		
		int j = arr.length-1;
		while(j>0) {
			int count = 1;
			while(arr[j] == arr[j-1]) {
				count++;
				j--;
				if(j == 0) {
					break;
				}
			}
			lst.add(arr[j]);
			j--;
			if(lst.size() == k) {
				break;
			}
		}
		System.out.println(" linked hash set maintains ordering :::: "+lst);
		
		return lst;
		
	}
	

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        List<int[]> arr = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            arr.add(new int[] {entry.getValue(), entry.getKey()});
        }
        arr.sort((a, b) -> b[0] - a[0]);

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = arr.get(i)[1];
        }
        return res;
    }
	

	public static void main(String[] args) {
    	
    	int[] arr = {1,2,2,3,3,3};
    	System.out.println(" top k element ::: "+topKElement(arr, 2));
    	
    	int[] arr1 = {7,7};
    	System.out.println(" top k element ::: "+topKElement(arr1, 1));
    	
    }

}
