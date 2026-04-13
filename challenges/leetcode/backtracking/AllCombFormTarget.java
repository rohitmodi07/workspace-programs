package leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AllCombFormTarget {
	
	public static List<List<Integer>> combinationSum(int[] nums, int target) {

        if(nums == null || nums.length<1)
            return new ArrayList<>();

        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        dfs(0, new ArrayList<>(), 0, nums, target, res);
        return res;    
        
    }

    public static void dfs(int i, List<Integer> cur, int total, int[] nums, int target,
                     List<List<Integer>> res){
         
         if(total == target){
            res.add(new ArrayList<>(cur));
            return;
         }

         for(int j=i; j<nums.length; j++){
             if(total + nums[j] > target){
                return ;
             } 
             cur.add(nums[j]);
             dfs(j, cur, total + nums[j], nums, target, res);
             System.out.println(" cur is :::: "+cur);
             cur.remove(cur.size()-1);
         }

    }
	

	public static void main(String[] args) {
		
		
		int[] arr = {3,4,5}; // 7,4,3,0   2,2,2,2,5,6,9
		
		System.out.println(combinationSum(arr, 16));
      
	}

}
