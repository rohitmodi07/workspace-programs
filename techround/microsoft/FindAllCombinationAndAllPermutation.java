package techround.microsoft;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllCombinationAndAllPermutation {
	
	public static void allCombination(int num) {
		if(num <1)
			return;
		int[] arr = new int[num];
		
		printCompositions(arr, num, 0, num-1);
			
	}
	
	static void printCompositions(int[] arr, int num, int start, int end)
    {
        
        if (num == 0)
        {
            printArray(arr, start);
        }
        else if(num > 0)
        {
        	int prev = start == 0 ? 1 : arr[start-1];
            for (int k = prev; k <= end; k++)
            {
                arr[start]= k;
                printCompositions(arr, num-k, start+1, end);
            }
        }
    }
     
    // Utility function to print array arr[] 
    static void printArray(int arr[], int m)
    {
        for (int i = 0; i < m; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
	
	public static List<List<Integer>> subsets(int[] nums) {
	    List<List<Integer>> list = new ArrayList<>();
	    Arrays.sort(nums);
	    backtrack(list, new ArrayList<>(), nums, 0);
	    return list;
	}

	private static void backtrack(List<List<Integer>> list , List<Integer> tempList, int [] nums, int start){
	    list.add(new ArrayList<>(tempList));
	    for(int i = start; i < nums.length; i++){
	        tempList.add(nums[i]);
	        System.out.println(" i ::: "+i);
	        backtrack(list, tempList, nums, i + 1);
	        System.out.println(" current list :::: "+tempList);
	        tempList.remove(tempList.size() - 1);
	    }
	}
	
	 
	public static void main(String[] args) {
		
		System.out.println(" all combinations ::::: ");
		int[] arr = {1,2,3,4,5};
		
		List<List<Integer>> intlist = subsets(arr);
		
		for(List<Integer> lst : intlist) {
			System.out.println(" subsets are ::::: "+lst);
		}
		
		allCombination(5);
		  
	}

}
